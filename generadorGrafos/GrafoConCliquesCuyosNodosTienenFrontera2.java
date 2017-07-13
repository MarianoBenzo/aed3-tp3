package generadorGrafos;

public class GrafoConCliquesCuyosNodosTienenFrontera2 extends GeneradorComponentes implements GeneradorGrafo {

	@Override
	public String getNombre() {
		return "GrafoNodosCliques2Frontera";
	}

	// n indica la cantidad de cliques, la clique 1 tiene 1 nodo la clique 2 tiene dos nodos y asi sigue 
	// aumentando a medida que aumenta la cantidad de cliques.
	
	public boolean[][] generar(int n, int m) {
		int cantidadDeNodos = 0;
		
		for (int i = 1; i <= n; i++) {
			cantidadDeNodos += (i*3);
		}
		
		boolean[][] grafoConCliquesCuyosNodosTienenFrontera2 = crearGrafoCompletamenteDisconexo(cantidadDeNodos);
		
		int posicion = 0;
		for (int i = 1; i <= n; i++) {
			// cantidadGrafosEstrella de la clique, cantidadDeNodosPorGrafoEstrella
			boolean[][] clique = crearCliqueConGrafosEstrella(i, 3);
			copiarGrafoEnPosicion(posicion, grafoConCliquesCuyosNodosTienenFrontera2, clique, i*3);
			if (i < n) {
				posicion +=(i*3);
				grafoConCliquesCuyosNodosTienenFrontera2[posicion+1][posicion-1] = true;
				grafoConCliquesCuyosNodosTienenFrontera2[posicion-1][posicion+1] = true;
			}
		}
		
		return grafoConCliquesCuyosNodosTienenFrontera2;
	}

	
}