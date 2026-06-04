/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_eda_adivinadordeanimales;

/**
 *
 * @author Admin
 */
public class Nodo {
    String dato;
    Nodo si;
    Nodo no;

    public Nodo(String dato) {
        this.dato = dato;
        this.si = null;
        this.no = null;
    }
    
}
