package ejemplos.tema5;

import librerias.estructurasDeDatos.modelos.MapOrdenado;
import librerias.estructurasDeDatos.modelos.EntradaMap;
import librerias.estructurasDeDatos.modelos.ListaConPI; 
import librerias.estructurasDeDatos.lineales.LEGListaConPI; 
import librerias.estructurasDeDatos.jerarquicos.ABBMapOrdenado;

/**
 * class UsosMapOrdenado.
 * 
 * @author FTG 
 * @version 2.0
 */

public class UsosMapOrdenado {
    
    /** Dise�ar un m�todo est�tico, gen�rico e iterativo entradas 
     *  que devuelva una ListaConPI con las Entradas de un Map m, no vac�o, 
     *  ordenadas ascendentemente. 
     */
    public static <C extends Comparable<C>, V> 
    ListaConPI<EntradaMap<C, V>> entradas(MapOrdenado<C, V> m) 
    {
        // COMPLETAR 
        return null;
    }
    
    /** Dise�ar un m�todo est�tico, gen�rico e iterativo mapSort 
     *  que, con la ayuda de un MapOrdenado, 
     *  ordene los elementos (Comparable) de un array v no vac�o, y sin repetidos.  
     */
    public static <C extends Comparable<C>> void mapSort(C[] v) {
        // COMPLETE
    }
    
    /** Dise�ar un m�todo est�tico, e iterativo hayDosQueSuman 
     *  que, dados un array v, no vac�o, de enteros y un entero k, 
     *  determine si existen en v dos n�meros cuya suma sea k. 
     *  Usar un Map Ordenado como EDA auxiliar.
     */
    public static boolean hayDosQueSuman(int[] v, int k) {
        // COMPLETE
		
        return false;
    }
}