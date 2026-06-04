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
        sc= new Scanner(System.in);
    }
    public Nodo getRaiz() {
    return raiz;
}
    
    public void crearArbolInicial() {

    if (raiz != null) {

        System.out.println("El arbol ya fue creado.");

        return;
    }

    System.out.println("Ingrese pregunta raiz:");

    String pregunta = sc.nextLine();

    raiz = new Nodo(pregunta);

    System.out.println("Animal para respuesta SI:");

    String animalSi = sc.nextLine();

    System.out.println("Animal para respuesta NO:");

    String animalNo = sc.nextLine();

    raiz.si = new Nodo(animalSi);

    raiz.no = new Nodo(animalNo);

    System.out.println("Arbol creado correctamente.");
}
     
    
    public void jugar(){
        Nodo actual = raiz;
        
        while(actual.esPregunta){
            System.out.println("(si/no)");
            String resp= sc.nextLine();
            
            if(resp.equalsIgnoreCase(("si"))){
                actual = actual.si;
                
            }
            else{
                actual = actual.no;
                        
            }
        }
        System.out.println("¿Tu animal es "+ actual.dato + "? (si/no)");
        String respuesta = sc.nextLine();
        
        if(respuesta.equalsIgnoreCase("si")){
            System.out.println("¡Adivine!");
        }
        else{
            //aprender() falta metodo aprender
            aprender(actual);
        }
    }
    
    public void mostrarArbol(){
    if(raiz == null){
        System.out.println("Arbol vacío");
    }
    else{
        mostrarArbolRec(raiz,"");
    }
}
    
    private void mostrarArbolRec(Nodo actual,String prefijo){
    
        if(actual != null){
            System.out.println(prefijo +actual.getDato()
        );

        mostrarArbolRec(actual.getSi(),prefijo + "   SI -> ");

        mostrarArbolRec(actual.getNo(),prefijo + "   NO -> ");
    }
}
    
   private Nodo aprenderRec(Nodo animal){
       
       System.out.println("¿que animal era? ");
       String animalNuevo=sc.nextLine();
       
       System.out.println("ingrese una pregunta que diferencia al nuevo animal del anterior");
       String pregunta=sc.nextLine();
       
       System.out.println("para el nuevo animal, ¿la respuesta es SI o NO?");
       String respuesta=sc.nextLine();
       
       Nodo nuevo=new Nodo(pregunta);
       nuevo.esPregunta=true;
       
       if(respuesta.equalsIgnoreCase("si")){
           nuevo.si=new Nodo(animalNuevo);
           nuevo.si.esPregunta=false;
           nuevo.no=animal;
       }else{
           nuevo.no=new Nodo(animalNuevo);
           nuevo.no.esPregunta=false;
           nuevo.si=animal;
       }
       nuevo.esPregunta=true;
       
        return nuevo;

       
   }
   
   
   public Nodo aprender(Nodo animal){
       return aprenderRec(animal);
   }
    
}
