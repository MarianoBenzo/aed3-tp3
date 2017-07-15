package generadorGrafos;

public class GrafoDisconexo implements GeneradorGrafo {
	private int maximaFrontera = 0;

	public int getMaximaFrontera() {
		return maximaFrontera;
	}
	
	
	public String getNombre() {
		return "Disconexo";
	}

	public boolean[][] generar(int cantidadDeNodosPorGrafo, int cantidadDeGrafosConexos) {
        int cantidadDeNodos = cantidadDeNodosPorGrafo * cantidadDeGrafosConexos;
        boolean[][] grafoResultado = new boolean[cantidadDeNodos][cantidadDeNodos];
        inicializarGrafo(grafoResultado, cantidadDeNodos);

        int n = cantidadDeNodos;
        int m = (n*(n-1)/16)+1;

        GeneradorGrafo grafoAleatorio = new GrafoAleatorio();
        
        for (int i = 0; i < cantidadDeGrafosConexos; i++) {
            boolean[][] grafo = grafoAleatorio.generar(n, m);
            ubicarGrafo(grafoResultado, grafo, i, cantidadDeNodosPorGrafo);
        }
        return grafoResultado;
    }



    public static void inicializarGrafo(boolean[][] grafo, int cantidadDeNodos) {
        for (int i = 0; i < cantidadDeNodos; i++) {
            for (int j = 0; j < cantidadDeNodos; j++) {
                grafo[i][j] = false;
            }
            
        }
    }


    public static void ubicarGrafo(boolean[][] grafoOriginal, boolean[][] grafoAUbicar, int numeroGrafo, int cantidadDeNodos) {
        int desplazamiento = numeroGrafo*cantidadDeNodos;
        for (int i = 0; i < cantidadDeNodos; i++) {
            for (int j = 0; j < cantidadDeNodos; j++) {
                grafoOriginal[desplazamiento + i][desplazamiento + j] = grafoAUbicar[i][j];
            }
            
        }

    }

}
