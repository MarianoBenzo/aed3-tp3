package algoritmos;
import java.util.*;

public class CMFgoloso implements Algoritmo
{
	private static Inicio inicio = Inicio.NODO_MAYOR_GRADO;

	public void setIncio(Inicio inicio) {
		this.inicio = inicio;
	}

	
	public String getNombre() {
		return "Goloso";
	}

	public List<Integer> CMFgolosoAux(boolean[][] grafo, int n, List<Integer> clique, List<Integer> adyacentes)
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


    public int ejecutar(boolean[][] grafo, int n)
    {	

    	
        int nodoInicial = funcionesAux.getNodoIncial(grafo, n, inicio);
        
        List<Integer> clique = new ArrayList<Integer>();
        clique.add(nodoInicial);        

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);

        List<Integer> cliqueMaxFrontera = CMFgolosoAux(grafo, n, clique, adyacentes); //Complejidad n^2

        return funcionesAux.frontera(grafo, n, cliqueMaxFrontera);
    }

/*
    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }
*/
}