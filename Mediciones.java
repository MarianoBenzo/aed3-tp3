//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class Mediciones {

	public static void main(String[] args)
    {
		//int n = 100;
		//int m = n*(n-1)/8;
    	//getAciertos(n, m, 1000);
		
		//escribirMedicionesGrafosCompletos(200, 1, "tiempos.txt");

		escribirMediciones(100, 10, "goloso.txt");
    }

/*
	public static void escribirMedicionesGrafosCompletos(int cantidadDeGrafos, int cantidadMedicionesXInstancia, String nombreArchivo) {
		List<boolean[][]> grafos = funcionesAux.getGrafosAleatorios(cantidadDeGrafos);
        List<Long> mediciones = getMediciones(grafos, cantidadMedicionesXInstancia);
        EntradaSalida.escribirTiempos(mediciones, nombreArchivo);
	}

*/

	public static void escribirMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, String nombreArchivo) {

        List<Long> mediciones = getMediciones(cantidadDeGrafos, cantidadMedicionesXInstancia);
        EntradaSalida.escribirTiempos(mediciones, nombreArchivo);

	}


	public static List<Long> getMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia) {
		List<Long> mediciones = new ArrayList<Long>();
		
		int n = 2;
		int m = (n*(n-1)/2);
		for (int i = 0; i < cantidadDeGrafos; i++) {
			
			mediciones.add(promedioDeMediciones(n, m, cantidadMedicionesXInstancia));
			
			n++;
			m = (n*(n-1)/2);
		}
		return mediciones;
	}
	
	public static Long promedioDeMediciones(int n, int m, int cantidadDeMediciones) {
		Long tiempoTotal = new Long(0);
		for (int i = 0; i < cantidadDeMediciones; i++) {
			boolean[][] grafo = funcionesAux.grafoRandom(n, m);

			long tiempoIncial = System.nanoTime();
			//CMFexacto.CMFexacto(grafo, n);
			CMFgoloso.CMFgoloso(grafo, n);
			//CMFbusquedaLocal.CMFbusquedaLocal(grafo, n);
			//CMFgrasp.CMFgrasp(grafo, n);		
			long tiempoFinal = System.nanoTime();
			
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
