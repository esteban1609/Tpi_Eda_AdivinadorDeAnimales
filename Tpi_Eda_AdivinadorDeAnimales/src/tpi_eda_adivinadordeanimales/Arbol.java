/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_eda_adivinadordeanimales;

/**
 *
 * @author Admin
 */
public class Arbol {
    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    
    /**
     * Insertar recursivo
     * @param dato
     * @param raiz
     */
 private Nodo insertarNodo(String dato,Nodo raiz){
     
     if(raiz==null){
         raiz=new Nodo(dato);
         return raiz;
     }
     if(dato.equalsIgnoreCase("si")){
         raiz.si=insertarNodo(dato,raiz);
     }else{
         raiz.no=insertarNodo(dato,raiz);
     }
        return raiz;
     
 }
 
 
     /**
     * Insertar publico
     * @param dato
     */
 public void insertar(String dato){
     this.raiz=insertarNodo(dato,this.raiz);
 }
 
}
