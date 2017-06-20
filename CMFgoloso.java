import java.util.*;

public class CMFgoloso
{

    public static int CMFgoloso(boolean[][] grafo, int n)
    {	

        int mayorGrado = 0;
        Integer nodoMayorGrado = null;

        for(int nodo=0;nodo<n;nodo++)
        {
            int gradoNodo = funcionesAux.nodosAdyacentes(grafo, n, nodo).size();

            if( gradoNodo > mayorGrado)
            {
                mayorGrado = gradoNodo;
                nodoMayorGrado = nodo;
            }
        }    

        return funcionesAux.CMFnodo(grafo, n, nodoMayorGrado);
    }


    public static void main(String[] args)
    {
        int n = 150;
        
        int m = n*(n-1)/4;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}