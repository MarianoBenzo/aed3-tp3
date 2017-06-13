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
    	boolean[][] grafo = {
        {false, true, false, true},
        {true, false, true, true},
        {false, true, false, false},
        {true, true, false, false}
        };

        int n = 4;

        System.out.println("CMF Exacto: "+CMFexacto(grafo, n));
    }

}