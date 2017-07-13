package generadorGrafos;

public class GeneradorComponentes {
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

}
