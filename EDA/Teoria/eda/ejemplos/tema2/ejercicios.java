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
    
    // public static <T extends Comparable <T>> void mergeDC(T[] v, int izq, int m, int der){
        // int i, j ,k;
        // T[] A = (T[]) new Comparable[v.length];
        // for (i = izq; i <= der; i++){
            // A[i] = v[i];
        // }
        // i = izq; j = m + 1; k = izq;
        
        // while(i <= m && j <= der){
            // if(A[i].compareTo(A[j]) <= 0){
                // v[k++] = A[i++];
            // }
            // else{
                // v[k++] = A[j++];
            // }
        // }
        // while(i <= m){
            // v[k++] = A[i++];
        // }
    // }
    
    private static <T extends Comparable <T>> void mergeDC(T[] v, int i, int m, int j){
        T[] res = (T[]) new Comparable[j-i+1];
        int i1 = i;
        int i2 = m;
        int k = 0;
        while(i1 < m && i2 <= j){
            if(v[i1].compareTo(v[i2]) < 0) res[k++] = v[i1++];
            else res[k++] = v[i2++];
        }
        for(int r = i1; r < m; r++) res[k++] = v[r];
        for(int r = i2; r <= j; r++) res[k++] = v[r];
        for(int r = 0; r < res.length; r++) v[r + i] = res[r];
    }
    
    
    public static <T extends Comparable <T>> void quickSort(T[] v){
        //quickSort(v, 0, v.length - 1);
    }
}
