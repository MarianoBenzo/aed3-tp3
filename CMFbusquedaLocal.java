import java.util.*;

public class CMFbusquedaLocal
{

    public static int CMFbusquedaLocal(boolean[][] grafo, int n)
    {	

        int nodo = funcionesAux.nodoMayorGrado(grafo, n);
        int cliqueMaxFrontera = funcionesAux.CMFnodo(grafo, n, nodo);
        List<Integer> vecinos = funcionesAux.nodosAdyacentes(grafo, n, nodo);

        boolean fin = false;

        int nodoAux = 0;
        int cliqueMaxFronteraAux = 0;
 
        while(!fin)
        {
            fin = true;

            for(int i=0;i<vecinos.size();i++)
            {
                if(funcionesAux.CMFnodo(grafo, n, vecinos.get(i)) > cliqueMaxFrontera)
                {
                    nodoAux = vecinos.get(i);
                    cliqueMaxFronteraAux = funcionesAux.CMFnodo(grafo, n, vecinos.get(i));
                    fin = false;
                }
            }

            if(!fin)
            {
            nodo = nodoAux;
            cliqueMaxFrontera = cliqueMaxFronteraAux;
            }
        }


        return cliqueMaxFrontera;
    }


    public static void main(String[] args)
    {
        int n = 100;
        
        int m = n*(n-1)/4;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Primer Nodo: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}