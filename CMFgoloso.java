import java.util.*;

public class CMFgoloso
{
    public static List<Integer> CMFgolosoAux(boolean[][] grafo, int n, List<Integer> clique, List<Integer> adyacentes)
    {   

        //List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, clique.get(0));

        List<Integer> cliqueMaxFrontera = new ArrayList<Integer>(clique);

        int maxFrontera = funcionesAux.frontera(grafo, n, clique);

        boolean fin = false;

        while(!fin) //a lo sumo n ciclos
        {   
            fin = true;
            for(int adyacente : adyacentes) //a lo sumo n ciclos
            {
                if(funcionesAux.formaClique(grafo, clique, adyacente))
                {
                    List<Integer> nuevaClique = new ArrayList<Integer>(clique);
                    nuevaClique.add(adyacente);

                    int nuevaFrontera = funcionesAux.frontera(grafo, n, nuevaClique);

                    if(nuevaFrontera > maxFrontera)
                    {
                        maxFrontera = nuevaFrontera;
                        cliqueMaxFrontera = nuevaClique;

                        fin = false;
                    }
                }
            }
            clique = cliqueMaxFrontera;
        }


        return cliqueMaxFrontera;
    }


    public static List<Integer> CMFgoloso(boolean[][] grafo, int n)
    {	

        int nodoInicial = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodoInicial = (int) (Math.random() * n);
        
        List<Integer> clique = new ArrayList<Integer>();
        clique.add(nodoInicial);        

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);

        List<Integer> cliqueMaxFrontera = CMFgolosoAux(grafo, n, clique, adyacentes); //Complejidad n^2

        return cliqueMaxFrontera;
    }


    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        boolean[][] grafo = EntradaSalida.leerGrafoEntrada(n, m);


        List<Integer> clique = CMFgoloso(grafo, n);
        int sizeClique = clique.size();
        int frontera = funcionesAux.frontera(grafo, n, clique);

        System.out.print(frontera+" "+sizeClique+" ");
        for(int nodo : clique)
        {
        	System.out.print(nodo+" ");
        }
    }

}
