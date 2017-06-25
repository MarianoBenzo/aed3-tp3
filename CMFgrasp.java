import java.util.*;

public class CMFgrasp
{

    public static List<Integer> CMFgrasp(boolean[][] grafo, int n)
    {	

        int nodo = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodo = (int) (Math.random() * n);
        
        int maxFrontera = 0;
        List<Integer> maxClique = new ArrayList<Integer>();

        for(int j=0;j<(n/10)+1;j++)
        {

            List<Integer> clique = CMFbusquedaLocal.CMFbusquedaLocalAux(grafo, n, nodo);
            int frontera = funcionesAux.frontera(grafo, n, clique);

            if(maxFrontera < frontera)
            {
                maxFrontera = frontera;
                maxClique = clique;
            }
            
            nodo = (int) (Math.random() * n);

        }

        return maxClique;
    }


    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        boolean[][] grafo = leerGrafoEntrada(n, m);


        List<Integer> clique = CMFgrasp(grafo, n);
        int sizeClique = clique.size();
        int frontera = funcionesAux.frontera(grafo, n, clique);

        System.out.print(frontera+" "+sizeClique+" ");
        for(int nodo : clique)
        {
        	System.out.print(nodo+" ");
        }
    }

}