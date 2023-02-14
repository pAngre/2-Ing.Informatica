package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

public class LEGListaConPIPlus<E> extends LEGListaConPI<E> implements ListaConPIPlus<E>
{
    /**comprueba si un elemento esta en la lista o no**/
    public boolean contiene(E e){
        inicio();
        while(!esFin() && !recuperar().equals(e)){
            siguiente();
        }
        if(esFin()) return false;
        return true;
    }
    
    /**elimina el primer elemento e de la lista**/
    /**devuelve true si lo consigue**/
    public boolean eliminarPrimero(E e){
        if(esVacia()){
           return false; 
        }
        inicio();
        while(!esFin() && !recuperar().equals(e)){
            siguiente();
        }
        if(esFin()) return false;
        eliminar();
        return true;
    }
    
    /**elimina el ultimo elemento e de la lista**/
    /**devuleve true si lo consigue**/
    public boolean eliminarUltimo(E e){
        int ultpos = 0;
        inicio();
        for(int i = 1; i < talla + 1; i++){
            if(recuperar().equals(e)) ultpos = i;
            siguiente();
        }
        if(ultpos == 0) return false;
        inicio();
        for(int i = 1; i< ultpos; i++){
            siguiente();
        }
        eliminar();
        return true;
    }
    /**elimina todos los elementos de la lista iguales a e**/
    /**devuelve true si los encuentra**/
    public boolean eliminarTodos(E e){
        inicio();
        int elim = 0;
        for(int i = 0; i < talla; i++){
            if(recuperar().equals(e)){
                eliminar();
                elim++;
            }
        }
        if(elim == 0) return false;
        return true;
    }
    /**borra la lista**/
    public void vaciar(){
        inicio();
        for(int i = 0; i < talla; i++){
            eliminar();
        }
    }
    /**une una nueva lista a esta lista**/
    public void concatenar(ListaConPI<E> otra){
        
    }
    /**invierte una lista**/
    public void invertir(){
        LEGListaConPI<E> l = new LEGListaConPI();
        for(int i = 0; i < this.talla - 1; i++){
            this.inicio();
            l.inicio();
            l.insertar(this.recuperar());
            this.eliminar();
        }
        
    }
    /** coloca el PI en e, si no lo encuentra el PI se pone al final**/
    public void buscar(E e){
        inicio();
        while(!esFin() && !recuperar().equals(e)) siguiente();
    }
    /**devuelve los elementos en forma de lista**/
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        NodoLEG<E> aux = pri.siguiente;         
        for (int i = 1; i < talla; i++, aux = aux.siguiente) {            
            s.append(aux.dato.toString() + ", ");
        }
        if (talla != 0) {
            s.append(aux.dato.toString() + "]"); 
        } else { s.append("]"); }
        return s.toString();
    }
}
