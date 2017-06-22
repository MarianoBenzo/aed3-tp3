import java.util.*;

public class CMFgoloso
{

    public static int CMFgoloso(boolean[][] grafo, int n)
    {	

        int nodoInicial = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodoInicial = (int) (Math.random() * n);

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);

        List<Integer> clique = new ArrayList<Integer>();
        clique.add(nodoInicial);

        List<Integer> cliqueMaxFrontera = new ArrayList<Integer>();
        cliqueMaxFrontera.add(nodoInicial);

        int maxFrontera = adyacentes.size();

        boolean fin = false;

        while(!fin)
        {   
            fin = true;
            for(int adyacente : adyacentes)
            {
                if(funcionesAux.formaClique(grafo, clique, adyacente))
                {
                    List<Integer> cliqueAux = new ArrayList<Integer>(clique);
                    cliqueAux.add(adyacente);

                    int fronteraAux = funcionesAux.frontera(grafo, n, cliqueAux);

                    if(fronteraAux > maxFrontera)
                    {
                        maxFrontera = fronteraAux;
                        cliqueMaxFrontera = cliqueAux;

                        fin = false;
                    }
                }
            }
            clique = cliqueMaxFrontera;
        }


        return maxFrontera;
    }


    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}