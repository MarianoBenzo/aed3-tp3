import java.util.*;

public class CMFbusquedaLocal
{

    public static int CMFbusquedaLocal(boolean[][] grafo, int n)
    {	

        int nodo = funcionesAux.nodoMayorGrado(grafo, n);
        int maxFrontera = funcionesAux.CMFnodo(grafo, n, nodo);
        List<Integer> vecinos = funcionesAux.nodosAdyacentes(grafo, n, nodo);

        boolean fin = false;

        int nodoAux = 0;
        int maxFronteraAux = 0;
        List<Integer> vecinosAux = new ArrayList<Integer>();
 
        while(!fin)
        {
            fin = true;

            for(int i=0;i<vecinos.size();i++)
            {   
                int CMFnodo = funcionesAux.CMFnodo(grafo, n, vecinos.get(i));
                if(CMFnodo > maxFrontera)
                {
                    nodoAux = vecinos.get(i);
                    maxFronteraAux = CMFnodo;
                    //vecinosAux = funcionesAux.cliqueMaxFronteraDeNodo(grafo, n, nodoAux);
                    vecinosAux = funcionesAux.nodosAdyacentes(grafo, n, nodoAux);
                    
                    fin = false;
                }
            }

            if(!fin)
            {
            nodo = nodoAux;
            maxFrontera = maxFronteraAux;
            vecinos = vecinosAux;
            }
        }


        return maxFrontera;
    }


    public static void main(String[] args)
    {
        int n = 100;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Primer Nodo: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}