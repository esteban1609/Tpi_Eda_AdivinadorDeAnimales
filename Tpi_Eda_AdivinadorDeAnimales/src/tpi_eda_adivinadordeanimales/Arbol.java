/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_eda_adivinadordeanimales;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase principal que representa el árbol binario de decisión
 * utilizado para el juego de adivinador de animales.
 * Cada nodo interno es una pregunta y cada hoja es un animal.
 */
public class Arbol {

    private Nodo raiz;
    private Scanner sc;

    /**
     * Constructor que inicializa el árbol con un conjunto de animales
     * y preguntas predefinidas.
     */
    public Arbol() {
        raiz = null;
        sc = new Scanner(System.in);
        crearArbolInicial();
    }

    /**
     * Retorna el nodo raíz del árbol.
     * @return Nodo raíz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Construye el árbol inicial con preguntas y animales predefinidos.
     * El árbol cubre mamíferos, aves, reptiles y peces mediante
     * preguntas de si/no.
     */
    public void crearArbolInicial() {

    raiz = crearPregunta(
            Preguntas.PREGUNTA_RAIZ
    );

    // SI
    raiz.si = crearPregunta(
            Preguntas.VIVE_EN_EL_AGUA
    );

    raiz.si.si = crearPregunta(
            Preguntas.ES_MUY_GRANDE
    );

    raiz.si.si.si = crearAnimal("Ballena");
    raiz.si.si.no = crearAnimal("Delfin");

    raiz.si.no = crearPregunta(
            Preguntas.ES_DOMESTICO
    );

    raiz.si.no.si = crearAnimal("Perro");
    raiz.si.no.no = crearAnimal("Leon");

    // NO
    raiz.no = crearPregunta(
            Preguntas.TIENE_ALAS
    );

    raiz.no.si = crearPregunta(
            Preguntas.VUELA_LARGAS_DISTANCIAS
    );

    raiz.no.si.si = crearAnimal("Aguila");
    raiz.no.si.no = crearAnimal("Gallina");

    raiz.no.no = crearPregunta(
            Preguntas.VIVE_EN_EL_AGUA
    );

    raiz.no.no.si = crearAnimal("Pez");

    raiz.no.no.no = crearPregunta(
            Preguntas.TIENE_PATAS
    );

    raiz.no.no.no.si = crearAnimal("Tortuga");
    raiz.no.no.no.no = crearAnimal("Serpiente");
}

    /**
     * Ejecuta una partida del juego. Recorre el árbol realizando preguntas
     * al usuario hasta llegar a un animal. Si no adivina, llama al método
     * aprender para incorporar el nuevo animal al árbol.
     */
    public void jugar() {
        if (raiz == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }
        Nodo actual = raiz;
        Nodo padre = null;
        boolean vinoPorSi = false;

        while (actual.esPregunta) {
            String resp = JOptionPane.showInputDialog(actual.dato + "\n(si/no)");
            padre = actual;

            if (resp.equalsIgnoreCase("si")) {
                vinoPorSi = true;
                actual = actual.si;
            } else {
                vinoPorSi = false;
                actual = actual.no;
            }
        }

        String respuesta = JOptionPane.showInputDialog("¿Tu animal es " + actual.dato + "?\n(si/no)");

        if (respuesta.equalsIgnoreCase("si")) {
            JOptionPane.showMessageDialog(null, "¡Adiviné tu animal!");
        } else {
            JOptionPane.showMessageDialog(null, "No pude adivinarlo. Voy a aprender.");
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

    /**
     * Muestra el árbol completo en consola de forma visual.
     * Si el árbol está vacío informa al usuario.
     */
    public void mostrarArbol() {
        if (raiz == null) {
            System.out.println("Arbol vacío");
        } else {
            mostrarArbolRec(raiz, "");
        }
    }

    /**
     * Recorre el árbol de forma recursiva mostrando cada nodo
     * con su prefijo correspondiente para visualizar la jerarquía.
     * @param actual Nodo actual a mostrar
     * @param prefijo Cadena de texto que representa la profundidad del nodo
     */
    private void mostrarArbolRec(Nodo actual, String prefijo) {
        if (actual != null) {
            System.out.println(prefijo + actual.getDato());
            mostrarArbolRec(actual.getSi(), prefijo + "   SI -> ");
            mostrarArbolRec(actual.getNo(), prefijo + "   NO -> ");
        }
    }

    /**
     * Permite al árbol aprender un nuevo animal cuando no pudo adivinarlo.
     * Le pide al usuario el animal, una pregunta que lo diferencie del animal
     * que se había adivinado y la respuesta correcta para el nuevo animal.
     * @param animal Nodo del animal que el árbol había intentado adivinar
     * @return Nuevo subárbol con la pregunta y los dos animales como hojas
     */
    private Nodo aprenderRec(Nodo animal) {
        String animalNuevo = JOptionPane.showInputDialog("¿Qué animal era?");
        String pregunta = JOptionPane.showInputDialog("Ingrese una pregunta que diferencie a " + animalNuevo + " de " + animal.getDato());
        String respuesta = JOptionPane.showInputDialog("Para " + animalNuevo + " la respuesta es SI o NO?");

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

        JOptionPane.showMessageDialog(null, "Gracias. Aprendí un nuevo animal.");
        return nuevo;
    }

    /**
     * Método público que delega la lógica de aprendizaje al método privado aprenderRec.
     * @param animal Nodo del animal que el árbol no pudo adivinar
     * @return Nuevo subárbol generado con el animal aprendido
     */
    public Nodo aprender(Nodo animal) {
        return aprenderRec(animal);
    }

    /**
     * Crea un nodo de tipo pregunta.
     * @param pregunta Texto de la pregunta
     * @return Nodo configurado como pregunta
     */
    private Nodo crearPregunta(String pregunta) {
        return new Nodo(pregunta, true);
    }

    /**
     * Crea un nodo de tipo animal (hoja del árbol).
     * @param animal Nombre del animal
     * @return Nodo configurado como animal
     */
    private Nodo crearAnimal(String animal) {
        return new Nodo(animal, false);
    }

    // Métodos deprecados, de momento

    /**
     * Helper para crear un nodo genérico.
     * @param dato Contenido del nodo
     * @param esPregunta true si es pregunta, false si es animal
     */
    private Nodo crearNodoDepre(String dato, boolean esPregunta) {
        return new Nodo(dato, esPregunta);
    }

    /**
     * Helper para crear una pregunta con sus dos ramas de animales.
     * @param pregunta Texto de la pregunta
     * @param animalSi Animal correspondiente a la respuesta SI
     * @param animalNo Animal correspondiente a la respuesta NO
     * @return Nodo pregunta con sus hojas configuradas
     */
    private Nodo crearPreguntaDepre(String pregunta, String animalSi, String animalNo) {
        Nodo nodo = crearNodoDepre(pregunta, true);
        nodo.si = crearNodoDepre(animalSi, false);
        nodo.no = crearNodoDepre(animalNo, false);
        return nodo;
    }
}
