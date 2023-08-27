package librerias.estructurasDeDatos.grafos;

public class TestFuenteMST
{
    public static void main(String[] args) {
        GrafoNoDirigido g1 = new GrafoNoDirigido(5);
        int a1[][] = new int[][] {{0, 1, 1}, {1, 2, 2}, {3, 4, 3}};
        for (int a[] : a1) g1.insertarArista(a[0], a[1], a[2]);
        System.out.println("Grafo inconexo: " + g1.fuenteEnMST());
        GrafoNoDirigido g2 = new GrafoNoDirigido(5);
        int a2[][] = new int[][] {{0, 1, 1}, {1, 2, 2}, {1, 4, 3}, {0, 3, 4}, {3, 4, 5}};
        for (int a[] : a2) g2.insertarArista(a[0], a[1], a[2]);
        System.out.println("Sin vertice fuente: " + g2.fuenteEnMST());
        GrafoNoDirigido g3 = new GrafoNoDirigido(5);
        int a3[][] = new int[][] {{0, 1, 1}, {1, 2, 2}, {1, 4, 3}, {0, 3, 4}, {3, 4, 5}, {1, 3, 1}};
        for (int a[] : a3) g3.insertarArista(a[0], a[1], a[2]);
        System.out.println("Vertice fuente: " + g3.fuenteEnMST());
        GrafoNoDirigido g4 = new GrafoNoDirigido(6);
        int a4[][] = new int[][] {{0, 5, 5}, {5, 1, 1}, {5, 2, 2}, {1, 2, 4}, {2, 3, 5}, {5, 3, 2}, {3, 4, 4}, {4, 5, 1}};
        for (int a[] : a4) g4.insertarArista(a[0], a[1], a[2]);
        System.out.println("Vertice fuente: " + g4.fuenteEnMST());
    }

}

