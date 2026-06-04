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
    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    
     public void crearArbolInicial() {
        raiz = new Nodo("¿Es mamífero?", true);

        raiz.si = new Nodo("Perro", false);
        raiz.no = new Nodo("Águila", false);
    }
    
    public void jugar(Scanner sc){
        Nodo actual = raiz;
        
        while(actual.esPregunta){
            System.out.println("(s/n)");
            String resp= sc.nextLine();
            
            if(resp.equalsIgnoreCase(("s"))){
                actual = actual.si;
                
            }
            else{
                actual = actual.no;
                        
            }
        }
        System.out.println("¿Tu animal es "+ actual.dato + "? (s/n)");
        String respuesta = sc.nextLine();
        
        if(respuesta.equalsIgnoreCase("s")){
            System.out.println("¡Adiviné!");
        }
        else{
            //aprender() falta metodo aprender
        }
    }
    
}
