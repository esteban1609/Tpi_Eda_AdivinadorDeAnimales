/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi_eda_adivinadordeanimales;

import java.util.Scanner;
import javax.swing.JOptionPane;

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

        String menu =
        "===== ADIVINADOR DE ANIMALES =====\n\n"
      + "1 - Mostrar árbol\n"
      + "2 - Jugar\n"
      + "3 - Salir\n\n"
      + "Seleccione una opción:";

        opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (opcion) {

            case 1:

                System.out.println("\nÁRBOL ACTUAL\n");
                arbol.mostrarArbol();

                JOptionPane.showMessageDialog(
                        null,
                        "El árbol se mostró en la consola."
                );

                break;

            case 2:

                JOptionPane.showMessageDialog(
                        null,
                        "Piense un animal y responda las preguntas en la consola."
                );

                arbol.jugar();

                break;

            case 3:

                JOptionPane.showMessageDialog(
                        null,
                        "Gracias por jugar."
                );

                break;

            default:

                JOptionPane.showMessageDialog(
                        null,
                        "Opción inválida."
                );
        }

    } while (opcion != 3);
    }
    
}
