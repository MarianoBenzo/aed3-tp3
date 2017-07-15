package generadorGrafos;

public class GrafoCliques0aNEnganchadasConUnNodoEnComun extends GeneradorComponentes implements GeneradorGrafo {
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
		int cantidadNodos = getTamano(n);
		System.out.println(cantidadNodos);		
		boolean[][] grafo = crearGrafoCompletamenteDisconexo(cantidadNodos);
		int posicion = 0;
		for (int i = 1; i <= n; i++) {
			boolean[][] clique = crearCliqueConGrafosEstrella(i, 1);
			System.out.println(posicion);		
			copiarGrafoEnPosicion(posicion, grafo, clique, clique.length);
			posicion = getPosicion(i);
		}
		maximaFrontera = calcularMaximaFronteraParaClique(n, 1-1);
		return grafo;
	}
	
	public int getPosicion(int n) {
		int ret = 0;
		int tamAnterior = 0;
		int posicion = 0;
		for (int i=0; i<=n; i++) {
			ret = posicion;
			tamAnterior = i-1;
			posicion = posicion + tamAnterior;
		}
		return ret+1;
	}

	public int getTamano(int n) {
		int tamAnterior = 0;
		int posicion = 0;
		for (int i=1; i<=n; i++) {
			tamAnterior = i-1;
			posicion = posicion + tamAnterior;
		}
		return posicion;
	}
}
