package algoritmos;
import java.util.*;

public class CMFexacto implements Algoritmo {

	private static Inicio inicio = Inicio.NODO_MAYOR_GRADO;

	public void setIncio(Inicio inicio) {
		this.inicio = inicio;
	}

	public String getNombre() {
		return "Exacto";
	}


    public int ejecutar(boolean[][] grafo)
    {	
    	List<Integer> nodos = new ArrayList<Integer>();
    	int n = grafo.length;
    	for(int i=0;i<n;i++)
        {
        	nodos.add(i);
        }

		List<List<Integer>> cliques = funcionesAux.dameCliques(grafo, nodos);

		List<Integer> fronteras = new ArrayList<Integer>();
    	
    	for(int i=0;i<cliques.size();i++)
        {
        	fronteras.add(funcionesAux.frontera(grafo, grafo[0].length, cliques.get(i)));
        }

		return Collections.max(fronteras);
    }

	
	public void setCondicionDeCorteEnIteraciones(CondicionDeCorteEnIteraciones condicionDeCorteEnIteraciones) {
		
	}



}

