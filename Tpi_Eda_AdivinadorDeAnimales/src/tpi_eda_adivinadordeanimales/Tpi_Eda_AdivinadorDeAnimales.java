/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi_eda_adivinadordeanimales;

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
        Arbol arbol = new Arbol();

        arbol.crearArbolInicial();

        System.out.println("\nARBOL CREADO:\n");
        arbol.mostrarArbol();
        
        System.out.println("Comienza el juego");
        arbol.jugar();
        
        //System.out.println(arbol.getRaiz().getDato());
        //System.out.println(arbol.getRaiz().getSi().getDato());
       // System.out.println(arbol.getRaiz().getNo().getDato());
        
    }
    
}
