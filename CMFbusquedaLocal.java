import java.util.*;

public class CMFbusquedaLocal
{

    public static List<Integer> CMFbusquedaLocal(boolean[][] grafo, int n)
    {  
        
        int nodoInicial = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodoInicial = (int) (Math.random() * n);

        return CMFbusquedaLocalAux(grafo, n, nodoInicial);

    }

    public static List<Integer> CMFbusquedaLocalAux(boolean[][] grafo, int n, int nodoInicial)
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

        return cliqueMaxFronteraLocal;
    }


    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        boolean[][] grafo = EntradaSalida.leerGrafoEntrada(n, m);


        List<Integer> clique = CMFbusquedaLocal(grafo, n);
        int sizeClique = clique.size();
        int frontera = funcionesAux.frontera(grafo, n, clique);

        System.out.print(frontera+" "+sizeClique+" ");
        for(int nodo : clique)
        {
        	System.out.print(nodo+" ");
        }


    }

}
