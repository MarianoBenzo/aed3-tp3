import java.util.*;

public class CMFgrasp
{

    public static int CMFgrasp(boolean[][] grafo, int n)
    {	

        //int nodo = funcionesAux.nodoMayorGrado(grafo, n);
        int nodo = (int) (Math.random() * n);
        int maxFrontera = funcionesAux.CMFnodo(grafo, n, nodo);
        List<Integer> vecinos = funcionesAux.nodosAdyacentes(grafo, n, nodo);

        int res = 0;

        for(int j=0;j<n/10;j++)
        {

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

            if(maxFrontera > res)
            {
                res = maxFrontera;
            }

            nodo = (int) (Math.random() * n);
            maxFrontera = funcionesAux.CMFnodo(grafo, n, nodo);
            vecinos = funcionesAux.nodosAdyacentes(grafo, n, nodo);

        }

        return res;
    }


    public static void main(String[] args)
    {
        int n = 100;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal.CMFbusquedaLocal(grafo, n));
        System.out.println("CMF CMFgrasp: "+CMFgrasp(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}