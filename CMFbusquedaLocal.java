import java.util.*;

public class CMFbusquedaLocal
{

    public static int CMFbusquedaLocal(boolean[][] grafo, int n)
    {  
        
        int nodoInicial = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodoInicial = (int) (Math.random() * n);

        return CMFbusquedaLocalAux(grafo, n, nodoInicial);

    }

    public static int CMFbusquedaLocalAux(boolean[][] grafo, int n, int nodoInicial)
    {    

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);


        List<Integer> clique = new ArrayList<Integer>();
        clique.add(nodoInicial);

        clique = CMFgoloso.CMFgolosoAux(grafo, n, clique, adyacentes);


        List<Integer> cliqueMaxFrontera = new ArrayList<Integer>(clique);
        int maxFrontera = funcionesAux.frontera(grafo, n, clique);

        List<Integer> cliqueMaxFronteraLocal = new ArrayList<Integer>(cliqueMaxFrontera);
        int maxFronteraLocal = maxFrontera;


        boolean fin = false;
        while(!fin)// a lo sumo n veces
        {   
            fin = true;
            clique = new ArrayList<Integer>(cliqueMaxFrontera);

            for(int nodo=0;nodo<clique.size();nodo++)
            {   

                Integer aux = clique.get(nodo);
                clique.remove(nodo);

                if(clique.size() > 0)
                {
                    adyacentes = funcionesAux.nodosAdyacentes(grafo, n, clique.get(0));
                    adyacentes.remove(aux); 
                }
                else
                {
                    adyacentes.clear();
                }

                clique = CMFgoloso.CMFgolosoAux(grafo, n, clique, adyacentes);
                int frontera = funcionesAux.frontera(grafo, n, clique);
                
                if(maxFrontera < frontera)
                {   
                    maxFrontera = frontera;

                    cliqueMaxFrontera = new ArrayList<Integer>(clique);
                }
            }
            

            if(maxFronteraLocal < maxFrontera)
            {   
                maxFronteraLocal = maxFrontera;

                cliqueMaxFronteraLocal = new ArrayList<Integer>(cliqueMaxFrontera);

                fin = false;
            }


        }

        return maxFronteraLocal;
    }


    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal(grafo, n));
        //System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}