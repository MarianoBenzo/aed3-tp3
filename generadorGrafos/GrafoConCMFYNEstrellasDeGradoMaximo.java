package generadorGrafos;

public class GrafoConCMFYNEstrellasDeGradoMaximo extends GeneradorComponentes implements GeneradorGrafo {

	private int maximaFrontera = 0;

	public int getMaximaFrontera() {
		return maximaFrontera;
	}
	
	public String getNombre() {
		return "CMFYNEstrellasDeGradoMaximo";
	}

	
	
    // La clique se compone por n grafos estrella, interconectando el nodo central de cada grafo estrella con 
    // el nodo central de todos los otros grafos. Este algoritmo toma la cantidad de grafos estrella cuyo nodo central
    // va a componer la clique y la cantidad de nodos que va a tener cada uno de estos grafos estrella para crear la clique
    // llamando a crearCliqueConGrafosEstrella y luego crea un grafo estrella de forma que el nodo central de este tenga 
    // el mayor grado de cualquier nodo del grafo.
    
    public boolean [][] generar(int cantidadDeNodosEnCliqueMaxima, int cantidadDeEstrellas) {
    	return generarGrafo(cantidadDeNodosEnCliqueMaxima, cantidadDeEstrellas);
    }

    
    public boolean [][] generarGrafo(int cantidadDeNodosEnCliqueMaxima, int cantidadDeEstrellas) {    	
    	int nodoGradoMaximoEnCliqueMaxima = 2*(cantidadDeNodosEnCliqueMaxima - 1); 
    	int cantidadNodosEnEstrella = nodoGradoMaximoEnCliqueMaxima+2;
    	
    	boolean [][] clique = crearCliqueConGrafosEstrella(cantidadDeNodosEnCliqueMaxima, cantidadDeNodosEnCliqueMaxima);
    	maximaFrontera = calcularMaximaFronteraParaClique(cantidadDeNodosEnCliqueMaxima, cantidadDeNodosEnCliqueMaxima-1);
    	
    	boolean [][] grafoConNodoDeGradoMaximo = crearGrafoEstrella(cantidadNodosEnEstrella);
    	
    	boolean [][] grafoProblematico = 
    			crearGrafoCompletamenteDisconexo(clique.length + cantidadDeEstrellas*(grafoConNodoDeGradoMaximo.length));
    	copiarGrafoEnPosicion(0, grafoProblematico, clique, clique.length);
       	
    	int cantidadNodosClique = clique.length;
    	for (int i = 1; i < cantidadDeEstrellas; i++) {
	    	copiarGrafoEnPosicion(cantidadNodosClique+1, grafoProblematico, grafoConNodoDeGradoMaximo, grafoConNodoDeGradoMaximo.length);
	       	grafoProblematico[cantidadNodosClique+1][cantidadNodosClique] = true;
	       	grafoProblematico[cantidadNodosClique][cantidadNodosClique+1] = true;
	       	grafoProblematico[cantidadNodosClique][cantidadNodosClique-1] = true;
	       	grafoProblematico[cantidadNodosClique-1][cantidadNodosClique] = true;
	       	cantidadNodosClique += grafoConNodoDeGradoMaximo.length+1;
    	}
    	
       	return grafoProblematico;
    }
    
    
    
}
