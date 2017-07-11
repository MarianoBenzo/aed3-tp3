package generadorGrafos;

public class GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo implements GeneradorGrafo {
	public String getNombre() {
		return "Problematico";
	}

/**	public static boolean[][] crearGrafoEstrella(int cantidadDeNodos, int nodoCentral) {
    	boolean[][] grafoEstrella = crearGrafoCompletamenteDisconexo(cantidadDeNodos);
    	for (int i=0; i < cantidadDeNodos; i++) {
    		if (i == nodoCentral) {
	    		for
    			grafoEstrella[i][i] = true;
	    		grafoEstrella[i][0] = true;
    		}
    	}
    	return grafoEstrella;
    }*/
	
	
	
	public static boolean[][] crearGrafoEstrella(int cantidadDeNodos) {
    	boolean[][] grafoEstrella = crearGrafoCompletamenteDisconexo(cantidadDeNodos);
    	for (int i=1; i < cantidadDeNodos; i++) {
    		grafoEstrella[0][i] = true;
    		grafoEstrella[i][0] = true;
    	}
    	return grafoEstrella;
    }

    public static boolean[][] crearGrafoCompletamenteDisconexo(int cantidadDeNodos) {
    	boolean[][] grafo = new boolean[cantidadDeNodos][cantidadDeNodos];
    	for (int i=1; i < cantidadDeNodos; i++) {
        	for (int j=1; j < cantidadDeNodos; j++) {
        		grafo[i][j] = false;
        	}
    	}
    	return grafo;
    }
    
    // La clique se compone por n grafos estrella, interconectando el nodo central de cada grafo estrella con 
    // el nodo central de todos los otros grafos. Este algoritmo toma la cantidad de grafos estrella cuyo nodo central
    // va a componer la clique y la cantidad de nodos que va a tener cada uno de estos grafos estrella para crear estos 
    // grafos estrella e interconectar sus nodos centrales todos contra todos de manera de formar una clique. 
    
    public static boolean[][] crearCliqueConGrafosEstrella(int cantidadDeGrafosEstrella, int cantidadDeNodosPorGrafoEstrella) {
    	int cantidadDeNodosCliqueMasFrontera = cantidadDeGrafosEstrella*cantidadDeNodosPorGrafoEstrella;
    	boolean [][] clique = crearGrafoCompletamenteDisconexo(cantidadDeNodosCliqueMasFrontera);
    	boolean [][] grafoEstrella = crearGrafoEstrella(cantidadDeNodosPorGrafoEstrella);
    	conectarGrafosEstrella(clique, cantidadDeNodosPorGrafoEstrella, cantidadDeNodosCliqueMasFrontera);
    	armarCliqueConGrafosEstrella(clique, grafoEstrella, cantidadDeNodosPorGrafoEstrella, cantidadDeGrafosEstrella);
    	
    	return clique;
    }
    
    public static void armarCliqueConGrafosEstrella(boolean[][] grafo, boolean[][] grafoEstrella, int tamanoGrafoEstrella, int cantidadDeGrafosEstrella) {
    	for (int i=0; i<cantidadDeGrafosEstrella; i++) {
    		copiarGrafoEnPosicion(i*tamanoGrafoEstrella, grafo, grafoEstrella, tamanoGrafoEstrella);
    	}
    }
    
    public static void copiarGrafoEnPosicion(int n, boolean[][] grafo, boolean[][] grafoEstrella, int tamanoGrafoEstrella) {
    //	int desplazamiento = n*tamanoGrafoEstrella;
    	for (int i=0; i<tamanoGrafoEstrella; i++) {
        	for (int j=0; j<tamanoGrafoEstrella; j++) {
        		grafo[i+n][j+n] = grafoEstrella[i][j];
        	}
    	}
    }
    
    public static void conectarGrafosEstrella(boolean[][] grafo, int cantidadDeNodosPorGrafoEstrella, int cantidadDeNodosGrafo) {
    	for (int i=0; i<cantidadDeNodosGrafo; i++) {
        	for (int j=0; j<cantidadDeNodosGrafo; j++) {
        		if ((i % (cantidadDeNodosPorGrafoEstrella) == 0) && (j % (cantidadDeNodosPorGrafoEstrella) == 0)) {
        			grafo[i][j] = true;
        		}
        	}
    	}
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
