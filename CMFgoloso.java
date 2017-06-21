import java.util.*;

public class CMFgoloso
{

    public static int CMFgoloso(boolean[][] grafo, int n)
    {	

        int nodoMayorGrado = funcionesAux.nodoMayorGrado(grafo, n);

        return funcionesAux.CMFnodo(grafo, n, nodoMayorGrado);
    }


    public static void main(String[] args)
    {
        int n = 100;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}