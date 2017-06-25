import java.util.*;

public class CMFexacto
{

    public static List<Integer> CMFexacto(boolean[][] grafo, int n)
    {	

    	List<Integer> nodos = new ArrayList<Integer>();
    	for(int i=0;i<n;i++)
        {
        	nodos.add(i);
        }

		List<List<Integer>> cliques = funcionesAux.dameCliques(grafo, nodos);

		int fronteraMax = 0;
		List<Integer> cliqueMax = new ArrayList<Integer>();
    	
    	for(List<Integer> clique : cliques)
        {	
        	int frontera = funcionesAux.frontera(grafo, n, clique);
        	if(fronteraMax < frontera)
        	{
        		fronteraMax = frontera;
        		cliqueMax = clique;

        	}
        	
        }

		return cliqueMax;
    }


    public static void main(String[] args)
    {	
    	Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        boolean[][] grafo = EntradaSalida.leerGrafoEntrada(n, m);

        List<Integer> clique = CMFexacto(grafo, n);
        int sizeClique = clique.size();
        int frontera = funcionesAux.frontera(grafo, n, clique);

        System.out.print(frontera+" "+sizeClique+" ");
        for(int nodo : clique)
        {
        	System.out.print(nodo+" ");
        }

    }

}