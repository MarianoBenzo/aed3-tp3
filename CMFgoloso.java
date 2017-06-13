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
    	boolean[][] grafo = {
        {false, true, false, true},
        {true, false, true, true},
        {false, true, false, false},
        {true, true, false, false}
        };

        int n = 4;

        System.out.println("CMF Goloso: "+CMFgoloso(grafo, n));
    }

}