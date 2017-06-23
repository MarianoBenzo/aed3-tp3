import java.util.*;

public class CMFexacto
{

    public static int CMFexacto(boolean[][] grafo, int n)
    {	

    	List<Integer> nodos = new ArrayList<Integer>();
    	for(int i=0;i<n;i++)
        {
        	nodos.add(i);
        }

		List<List<Integer>> cliques = funcionesAux.dameCliques(grafo, nodos);

		List<Integer> fronteras = new ArrayList<Integer>();
    	
    	for(int i=0;i<cliques.size();i++)
        {
        	fronteras.add(funcionesAux.frontera(grafo, n, cliques.get(i)));
        }

		return Collections.max(fronteras);
    }


    public static void main(String[] args)
    {
        int n = 25;
        
        int m = n*(n-1)/2;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);


        System.out.println("CMF Exacto: "+CMFexacto(grafo, n));

    }

}