package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

public class LEGListaConPIOrdenada<E extends Comparable<E>>
        extends LEGListaConPI<E> {
    public void insertar(E e){
        inicio();
        while(!esFin() && recuperar().compareTo(e) <= 0){
            siguiente();
        }
        super.insertar(e);
    }
}
