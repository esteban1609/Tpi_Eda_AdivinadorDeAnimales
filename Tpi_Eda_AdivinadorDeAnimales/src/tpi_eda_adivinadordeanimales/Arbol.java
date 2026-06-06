/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_eda_adivinadordeanimales;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Arbol {

    private Nodo raiz;
    private Scanner sc;

    public Arbol() {
        raiz = null;
        sc = new Scanner(System.in);
        crearArbolInicial();
    }

    public Nodo getRaiz() {
        return raiz;

    }

    public void crearArbolInicial() {

    raiz = crearPregunta(Preguntas.preguntaRaiz);

    raiz.si = crearPregunta(Preguntas.preguntaAgua);
    raiz.no = crearPregunta(Preguntas.preguntaDomestico);

    raiz.si.si = crearAnimal("Pato");
    raiz.si.no = crearAnimal("Aguila");

    raiz.no.si = crearAnimal("Perro");
    raiz.no.no = crearAnimal("Serpiente");

    }

    public void jugar() {

        if (raiz == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }
        Nodo actual = raiz;
        Nodo padre = null;
        boolean vinoPorSi = false;

        while (actual.esPregunta) {
            System.out.println(actual.dato + " (si/no)");
            String resp = sc.nextLine();

            padre = actual;

            if (resp.equalsIgnoreCase(("si"))) {
                vinoPorSi = true;
                actual = actual.si;

            } else {
                vinoPorSi = false;
                actual = actual.no;

            }
        }
        System.out.println("Tu animal es " + actual.dato + "? (si/no)");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¡Adivine!");
        } else {
            Nodo nuevoSubArbol = aprender(actual);

            if (padre == null) {
                raiz = nuevoSubArbol;
            } else if (vinoPorSi) {
                padre.si = nuevoSubArbol;
            } else {
                padre.no = nuevoSubArbol;
            }
        }
    }

    public void mostrarArbol() {
        if (raiz == null) {
            System.out.println("Arbol vacío");
        } else {
            mostrarArbolRec(raiz, "");
        }
    }

    private void mostrarArbolRec(Nodo actual, String prefijo) {

        if (actual != null) {
            System.out.println(prefijo + actual.getDato()
            );
            
            
            
            mostrarArbolRec(actual.getSi(), prefijo + "   SI -> ");
            
            mostrarArbolRec(actual.getNo(), prefijo + "   NO -> ");
        }
    }

    private Nodo aprenderRec(Nodo animal) {

        System.out.println("que animal era? ");
        String animalNuevo = sc.nextLine();

        System.out.println("ingrese una pregunta que diferencia al nuevo animal del anterior");
        String pregunta = sc.nextLine();

        System.out.println("para el nuevo animal, ¿la respuesta es SI o NO?");
        String respuesta = sc.nextLine();

        Nodo nuevo = new Nodo(pregunta, true);
        nuevo.esPregunta = true;

        if (respuesta.equalsIgnoreCase("si")) {
            nuevo.si = new Nodo(animalNuevo, false);
            nuevo.si.esPregunta = false;
            nuevo.no = animal;
        } else {
            nuevo.no = new Nodo(animalNuevo, false);
            nuevo.no.esPregunta = false;
            nuevo.si = animal;
        }
        nuevo.esPregunta = true;

        return nuevo;

    }

    public Nodo aprender(Nodo animal) {
        return aprenderRec(animal);
    }

    private Nodo crearPregunta(String pregunta) {
        return new Nodo(pregunta, true);
    }

    private Nodo crearAnimal(String animal) {
        return new Nodo(animal, false);
    }

    //metodos deprecados, de momento
    /**
     * helper para crear nodo
     *
     * @param dato
     * @param pregunta
     */
    private Nodo crearNodoDepre(String dato, boolean esPregunta) {
        return new Nodo(dato, esPregunta);
    }

    /**
     * helper para crear una pregunta con ramas
     *
     * @param pregunta
     * @param animalSi
     * @param animalNo
     */
    private Nodo crearPreguntaDepre(String pregunta, String animalSi, String animalNo) {
        Nodo nodo = crearNodoDepre(pregunta, true);

        nodo.si = crearNodoDepre(animalSi, false);
        nodo.no = crearNodoDepre(animalNo, false);

        return nodo;
    }

}
