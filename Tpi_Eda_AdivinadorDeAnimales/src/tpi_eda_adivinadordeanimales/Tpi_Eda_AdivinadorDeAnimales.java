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
        
        Scanner sc = new Scanner(System.in);

        Arbol arbol = new Arbol();

        int opcion;

        do {

            System.out.println("\n=== ADIVINADOR DE ANIMALES ===");
            System.out.println("1 - Mostrar arbol");
            System.out.println("2 - Jugar");
            System.out.println("3 - Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:
                    
                    arbol.mostrarArbol();

                    break;

                case 2:
                    arbol.jugar();

                    break;

                case 3:
                    System.out.println("Fin del programa.");

                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while(opcion != 3);
    }
    
}
