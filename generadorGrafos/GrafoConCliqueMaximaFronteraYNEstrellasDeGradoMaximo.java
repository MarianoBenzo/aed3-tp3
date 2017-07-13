package generadorGrafos;

public class GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo extends GeneradorComponentes implements GeneradorGrafo {
	public String getNombre() {
		return "Problematico";
	}

	
    // La clique se compone por n grafos estrella, interconectando el nodo central de cada grafo estrella con 
    // el nodo central de todos los otros grafos. Este algoritmo toma la cantidad de grafos estrella cuyo nodo central
    // va a componer la clique y la cantidad de nodos que va a tener cada uno de estos grafos estrella para crear la clique
    // llamando a crearCliqueConGrafosEstrella y luego crea un grafo estrella de forma que el nodo central de este tenga 
    // el mayor grado de cualquier nodo del grafo.
    
    public boolean [][] generar(int cantidadDeGrafosEstrella, int cantidadDeNodosPorGrafoEstrella) {
    	return generar(cantidadDeGrafosEstrella, cantidadDeNodosPorGrafoEstrella, 1);
    }

    
    public boolean [][] generar(int cantidadDeGrafosEstrella, int cantidadDeNodosPorGrafoEstrella, int cantidadDeGrafosEstrellaDeMayorGrado) {
    	int cantidadNodosDeGrafoNodoDeGradoMaximo = cantidadDeGrafosEstrella-1+1+cantidadDeNodosPorGrafoEstrella-1;
    	int cantidadNodosClique = cantidadDeGrafosEstrella*cantidadDeNodosPorGrafoEstrella;
    	boolean [][] clique = crearCliqueConGrafosEstrella(cantidadDeGrafosEstrella, cantidadDeNodosPorGrafoEstrella);
    	boolean [][] grafoConNodoDeGradoMaximo = crearGrafoEstrella(cantidadNodosDeGrafoNodoDeGradoMaximo);
    	boolean [][] grafoProblematico = 
    			crearGrafoCompletamenteDisconexo(cantidadNodosClique + 
    					((cantidadNodosDeGrafoNodoDeGradoMaximo + 1)*cantidadDeGrafosEstrellaDeMayorGrado));
    	copiarGrafoEnPosicion(0, grafoProblematico, clique, cantidadNodosClique);
       	
    	for (int i = 0; i < cantidadDeGrafosEstrellaDeMayorGrado; i++) {
	    	copiarGrafoEnPosicion(cantidadNodosClique+1, grafoProblematico, grafoConNodoDeGradoMaximo, cantidadNodosDeGrafoNodoDeGradoMaximo);
	       	grafoProblematico[cantidadNodosClique+1][cantidadNodosClique] = true;
	       	grafoProblematico[cantidadNodosClique][cantidadNodosClique+1] = true;
	       	grafoProblematico[cantidadNodosClique][cantidadNodosClique-1] = true;
	       	grafoProblematico[cantidadNodosClique-1][cantidadNodosClique] = true;
	       	cantidadNodosClique += cantidadNodosDeGrafoNodoDeGradoMaximo+1;
    	}
       	return grafoProblematico;
    }
    
    
    
}

