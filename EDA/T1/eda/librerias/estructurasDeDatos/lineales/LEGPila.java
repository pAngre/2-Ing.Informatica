package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

public class LEGPila<E> implements Pila<E> {
        
    protected NodoLEG<E> tope;
    protected int talla;

    /** crea una Pila vacia **/
    public LEGPila() {
        /*COMPLETAR*/
        tope.dato = null;
        talla = 0;
    }
      
    /** inserta el Elemento e en una Pila, o lo situa en su tope **/
    public void apilar(E e) {
        /*COMPLETAR*/
        tope.siguiente = tope;
        tope.dato = e;
        talla++;
    }
      
    /** SII !esVacia(): 
     * obtiene y elimina de una Pila el Elemento que ocupa su tope 
     */
    public E desapilar() {
        /*COMPLETAR Y CORREGIR*/
        E res = tope.dato;
        tope = tope.siguiente;
        talla--;
        return res;
    }
      
    /** SII !esVacia(): 
     * obtiene el Elemento que ocupa el tope de una Pila 
     */
    public E tope() {
        /*CORREGIR*/
        return tope.dato;
    }
      
    /** comprueba si una Pila esta vacia **/
    public boolean esVacia() {
        /*CORREGIR*/
        return tope.dato == null;
    }
      
    /** obtiene un String con los Elementos de una Pila en orden LIFO, 
     *  inverso al de insercion, 
     *  y con el formato que se usa en el estandar de Java. 
     *  Asi, por ejemplo, si se tiene una Pila con los Integer del 1 al 4, 
     *  en orden LIFO, toString devuelve [4, 3, 2, 1]; 
     *  si la Pila esta vacia, entonces devuelve [] 
     */
    public String toString() { 
        StringBuilder res = new StringBuilder();
        res.append("[");
        /*COMPLETAR*/
        for(int i = talla; i<0;i--){
            res.append(tope.dato);
            res.append(", ");
        }
        res.append("]");
        return res.toString(); 
    }
}