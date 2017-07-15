package algoritmos;
import java.util.*;

public class CMFbusquedaLocal implements Algoritmo
{
	private static Inicio inicio = Inicio.NODO_MAYOR_GRADO;
	
	public String getNombre() {
		return "BusquedaLocal";
	}

    public int ejecutar(boolean[][] grafo)
    {  
    	int nodoInicial = funcionesAux.getNodoIncial(grafo, grafo.length, inicio);    	
        return CMFbusquedaLocalAux(grafo, grafo.length, nodoInicial);

    }

    public int CMFbusquedaLocalAux(boolean[][] grafo, int n, int nodoInicial)
    {    

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);


        List<Integer> clique = new ArrayList<Integer>();
        clique.add(nodoInicial);

        CMFgoloso goloso = new CMFgoloso();
        clique = goloso.CMFgolosoAux(grafo, n, clique, adyacentes);


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

                clique = goloso.CMFgolosoAux(grafo, n, clique, adyacentes);
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

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}


	public void setCondicionDeCorteEnIteraciones(CondicionDeCorte condicionDeCorteEnIteraciones) {
		
	}


 /*   public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal(grafo, n));
        //System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }
*/
}