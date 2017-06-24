//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class Mediciones {

	public static void main(String[] args)
    {
		int n = 100;
		int m = n*(n-1)/8;
    	getAciertos(n, m, 1000);
		//escribirMedicionesGrafosCompletos(200, 1, "tiempos.txt");
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
			CMFexacto.CMFexacto(grafo, n);		
			long tiempoFinal = System.currentTimeMillis();
			tiempoTotal += tiempoFinal - tiempoIncial;
		}
		return tiempoTotal / cantidadDeMediciones;
	}



	public static int[] getAciertos(int n, int m, int cantidadDeInstancias) {

		int[] aciertos = {0,0,0,0};

		for (int i = 0; i < cantidadDeInstancias; i++)
		{
			boolean[][] grafo = funcionesAux.grafoRandom(n, m);

			int exacto = CMFexacto.CMFexacto(grafo, n);
			aciertos[0]++;

			int goloso = CMFgoloso.CMFgoloso(grafo, n);
			if(exacto == goloso)
			{
				aciertos[1]++;
			}

			int busquedaLocal = CMFbusquedaLocal.CMFbusquedaLocal(grafo, n);
			if(exacto == busquedaLocal)
			{
				aciertos[2]++;
			}

			int grasp = CMFgrasp.CMFgrasp(grafo, n);
			if(exacto == grasp)
			{
				aciertos[3]++;
			}

		}

		System.out.println("Aciertos: "+Arrays.toString(aciertos));
		return aciertos;
	}
	
}
