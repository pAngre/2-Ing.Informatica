package ejemplos.tema2;

public class ejercicios
{
    public static int puntoCruce(int[] v, int i, int j){
        int m = (i + j) / 2;
        if(v[m]<=0){
            if(v[m+1]>0){
                return m;
            }
            else{
                return puntoCruce(v,m+1,j);
            }
        }
        else{
            return puntoCruce(v,i,m-1);
        }
    }
    
    public static int puntoCruce(int[] v){
        return puntoCruce(v, 0, v.length - 1);
    }
    
    public static <T extends Comparable <T>> void mergeSort(T[] v ,int izq, int der){
        if(izq < der){
            int mitad = (izq + der) / 2;
            mergeSort(v, izq, mitad);
            mergeSort(v, mitad + 1, der);
            mergeDC(v, izq, mitad + 1, der);
        }
    }
    
    public static <T extends Comparable <T>> void mergeDC(T[] v, int i, int m, int j){
        T[] res;
        
    }
}
