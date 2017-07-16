package mediciones;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Algoritmo;
import generadorGrafos.GeneradorGrafo;

public class MedicionTiemposIncrementando1 implements Medicion {
	public String getNombre() {
		return "Tiempos";
	}

	public List<Object> getMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, GeneradorGrafo generador, Algoritmo algoritmo) {
		List<Object> mediciones = new ArrayList<Object>();

		for (int i = 0; i < cantidadDeGrafos; i++) {			
			System.out.println(i);			
			mediciones.add(promedioDeMediciones(i, i, cantidadMedicionesXInstancia, generador, algoritmo));			
		}
		return mediciones;
	}

	public static Long promedioDeMediciones(int n, int m, int cantidadDeMediciones, GeneradorGrafo generador, Algoritmo algoritmo) {
		Long tiempoTotal = new Long(0);
		boolean[][] grafo = generador.generar(n, m);
		for (int i = 0; i < cantidadDeMediciones; i++) {

			long tiempoIncial = System.nanoTime();
			
			algoritmo.ejecutar(grafo);
			
			long tiempoFinal = System.nanoTime();
			
			tiempoTotal += tiempoFinal - tiempoIncial;
		}
		return tiempoTotal / cantidadDeMediciones;
	}
}
