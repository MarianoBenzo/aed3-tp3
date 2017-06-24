import java.util.ArrayList;
import java.util.List;

public class Mediciones {

	public static void main(String[] args)
    {
		escribirMedicionesGrafosCompletos(200, 1, "tiempos.txt");
    }

	public static void escribirMedicionesGrafosCompletos(int cantidadDeGrafos, int cantidadMedicionesXInstancia, String nombreArchivo) {
		List<boolean[][]> grafos = funcionesAux.getGrafosAleatorios(cantidadDeGrafos);
        List<Long> mediciones = getMediciones(grafos, cantidadMedicionesXInstancia);
        EntradaSalida.escribirTiempos(mediciones, nombreArchivo);
	}
	public static List<Long> getMediciones(List<boolean[][]> grafos, int cantidadMedicionesXInstancia) {
		List<Long> mediciones = new ArrayList<Long>();
		int n = 1;
		for (boolean[][] grafo : grafos) {
			mediciones.add(promedioDeMediciones(grafo, n, cantidadMedicionesXInstancia));
			n++;
		}
		return mediciones;
	}
	
	public static Long promedioDeMediciones(boolean[][] grafo, int n, int cantidadDeMediciones) {
		Long tiempoTotal = new Long(0);
		for (int i = 0; i < cantidadDeMediciones; i++) {
			long tiempoIncial = System.currentTimeMillis();
			CMFExacto.CMFexacto(grafo, n);		
			long tiempoFinal = System.currentTimeMillis();
			tiempoTotal += tiempoFinal - tiempoIncial;
		}
		return tiempoTotal / cantidadDeMediciones;
	}
	
}
