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
    String dato; //pregunta o animal 
    boolean esPregunta;
    
    Nodo si;
    Nodo no;

    public Nodo(String dato,boolean esPregunta) {
        this.dato = dato;
        this.esPregunta = esPregunta;
        this.si = null;
        this.no = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public boolean isEsPregunta() {
        return esPregunta;
    }

    public void setEsPregunta(boolean esPregunta) {
        this.esPregunta = esPregunta;
    }

    public Nodo getSi() {
        return si;
    }

    public void setSi(Nodo si) {
        this.si = si;
    }

    public Nodo getNo() {
        return no;
    }

    public void setNo(Nodo no) {
        this.no = no;
    }
    
}
