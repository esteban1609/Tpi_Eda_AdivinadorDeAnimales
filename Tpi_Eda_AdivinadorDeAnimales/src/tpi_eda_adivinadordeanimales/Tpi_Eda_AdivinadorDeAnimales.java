/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi_eda_adivinadordeanimales;

import java.util.Scanner;

/**
 *
 * @author esteb
 */
public class Tpi_Eda_AdivinadorDeAnimales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Arbol arbol = new Arbol();

        //arbol.crearArbolInicial();

        //System.out.println("\nARBOL CREADO:\n");
        //arbol.mostrarArbol();
        
        //System.out.println("Comienza el juego");
        //arbol.jugar();
        
        //System.out.println(arbol.getRaiz().getDato());
        //System.out.println(arbol.getRaiz().getSi().getDato());
       // System.out.println(arbol.getRaiz().getNo().getDato());
        Scanner sc = new Scanner(System.in);

        Arbol arbol = new Arbol();

        int opcion;

        do {

            System.out.println("\n=== ADIVINADOR DE ANIMALES ===");
            System.out.println("1 - Crear arbol inicial");
            System.out.println("2 - Mostrar arbol");
            System.out.println("3 - Jugar");
            System.out.println("4 - Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:
                    
                    arbol.crearArbolInicial();

                    break;

                case 2:
                    
                    arbol.mostrarArbol();

                    break;

                case 3:
                    arbol.jugar();

                    break;

                case 4:
                    System.out.println("Fin del programa.");

                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while(opcion != 4);
    }
    
}
