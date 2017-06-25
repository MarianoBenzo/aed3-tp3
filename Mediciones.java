//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class Mediciones {

	public static void main(String[] args)
    {
		
    	
    	//int cantGrafos = 300;
		//escribirMediciones(cantGrafos, 30, "Complejidad grasp.txt");


	  	int cantGrafos = (50*(50-1)/2)-1;
		escribirMediciones(cantGrafos, 30, "Complejidad aristas goloso.txt");


		//int cantidadDeGrafos = 150;
		//int cantidadMedicionesXInstancia = 200;
		//escribirMedicionesAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia, "Aciertos por nodo goloso.txt");		
		//escribirMedicionesAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia, "Aciertos por nodo nodoInicial Random goloso.txt");		

		//int n = 15;
		//int cantidadDeGrafos = n*(n-1)/2;
		//int cantidadMedicionesXInstancia = 200;
		//escribirMedicionesAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia, "Aciertos por arista goloso.txt");
		//escribirMedicionesAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia, "Aciertos por arista nodoInicial Random goloso.txt");


		//int cantidadDeGrafos = 8;
		//int cantidadMedicionesXInstancia = 20;
		//escribirMedicionesAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia, "Aciertos por subgrafos goloso.txt");
		
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
		
		int n = 50;
		int m = 1;
		
		//int n = 2;
		//int m = (n*(n-1)/8)+1;

		for (int i = 0; i < cantidadDeGrafos; i++) {
			
			System.out.println(i);
			
			mediciones.add(promedioDeMediciones(n, m, cantidadMedicionesXInstancia));
			
			//n++;
			//m = (n*(n-1)/8)+1;

			m++;
		}
		return mediciones;
	}
	
	public static Long promedioDeMediciones(int n, int m, int cantidadDeMediciones) {
		Long tiempoTotal = new Long(0);
		for (int i = 0; i < cantidadDeMediciones; i++) {
			boolean[][] grafo = funcionesAux.grafoRandom(n, m);

			long tiempoIncial = System.nanoTime();
			
			CMFexacto.CMFexacto(grafo, n);
			//CMFgoloso.CMFgoloso(grafo, n);
			//CMFbusquedaLocal.CMFbusquedaLocal(grafo, n);
			//CMFgrasp.CMFgrasp(grafo, n);		
			
			long tiempoFinal = System.nanoTime();
			
			tiempoTotal += tiempoFinal - tiempoIncial;
		}
		return tiempoTotal / cantidadDeMediciones;
	}









	public static void escribirMedicionesAciertos(int cantidadDeGrafos, int cantidadMedicionesXInstancia, String nombreArchivo) {

        List<Float> mediciones = getAciertos(cantidadDeGrafos, cantidadMedicionesXInstancia);
        EntradaSalida.escribirAciertos(mediciones, nombreArchivo);

	}




	public static List<Float> getAciertos(int cantidadDeGrafos, int cantidadMedicionesXInstancia) {
		List<Float> mediciones = new ArrayList<Float>();

		int n = 2;//por nodo
		int m = (n*(n-1)/32)+1;//por nodo
		
		//int n = 15;//por arista
		//int m = 1;//por arista
		
		//int n = 50;//por subgrafo
		//int m = 1;//por subgrafo

		for (int i = 0; i < cantidadDeGrafos; i++) {
			
			System.out.println(i);
			
			mediciones.add(promedioDeAciertos(n, m, cantidadMedicionesXInstancia));
			
			n++;//por nodo
			m = (n*(n-1)/32)+1;//por nodo

			//m++;//por arista

			//m++;//por subgrafo
		}
		return mediciones;
	}	




	public static Float promedioDeAciertos(int n, int m, int cantidadDeMediciones) {
		
		Float aciertos = new Float(0);
		Float promedio = new Float(0);

		for (int i = 0; i < cantidadDeMediciones; i++)
		{
			boolean[][] grafo = funcionesAux.grafoRandom(n, m);
			//boolean[][] grafo = funcionesAux.crearGrafoDisconexo(n, m);//por subgrafo, n = nodos por subgrafo, m = cantidad de subgrafos, cantidad de aristas por subgrafo = n*(n-1)/16


			int exacto = funcionesAux.frontera(grafo, n, CMFexacto.CMFexacto(grafo, n));
			
			int prueba = funcionesAux.frontera(grafo, n, CMFgoloso.CMFgoloso(grafo, n));
			//int prueba = funcionesAux.frontera(grafo, n, CMFbusquedaLocal.CMFbusquedaLocal(grafo, n));
			//int prueba = funcionesAux.frontera(grafo, n, CMFgrasp.CMFgrasp(grafo, n));		

			if(exacto == prueba)
			{
				aciertos++;
			}
		}

		promedio = aciertos * 100 / cantidadDeMediciones;

		return promedio;
	}



}
