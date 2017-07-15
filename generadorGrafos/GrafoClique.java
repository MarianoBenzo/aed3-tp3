package generadorGrafos;

public class GrafoClique extends GeneradorComponentes implements GeneradorGrafo {
	private int maximaFrontera = 0;
	
	public String getNombre() {
		return "GrafoClique";
	}

	public int getMaximaFrontera() {
		return maximaFrontera;
	}
	
	// n indica la cantidad de cliques, la clique 1 tiene 1 nodo la clique 2 tiene dos nodos y asi sigue 
	// aumentando a medida que aumenta la cantidad de cliques.
	
	public boolean[][] generar(int n, int m) {		
		boolean[][] clique = crearCliqueConGrafosEstrella(n, 3);
		maximaFrontera = calcularMaximaFronteraParaClique(n, 3-1);
		
		return clique;
	}
}
