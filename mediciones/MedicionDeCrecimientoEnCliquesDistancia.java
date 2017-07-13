package mediciones;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Algoritmo;
import algoritmos.CMFexacto;
import generadorGrafos.GeneradorGrafo;

public class MedicionDeCrecimientoEnCliquesDistancia implements Medicion {
	public String getNombre() {
		return "Distancias";
	}

	public List<Object> getMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, GeneradorGrafo generador, Algoritmo algoritmo) {
		List<Object> mediciones = new ArrayList<Object>();		

		for (int i = 1; i <= cantidadDeGrafos; i++) {
			
			System.out.println(i);
			
			mediciones.add(promedioDeDistancias(i, 0, cantidadMedicionesXInstancia, generador, algoritmo));
			
		}
		return mediciones;
	}	



	public static Float promedioDeDistancias(int n, int m, int cantidadDeMediciones, GeneradorGrafo generador, Algoritmo algoritmo) {
		
		Float distancia = new Float(0);
		Float promedio = new Float(0);
		
		//Algoritmo algoritmoExacto = new CMFexacto();
		
		for (int i = 0; i < cantidadDeMediciones; i++)
		{
			boolean[][] grafo = generador.generar(n, m);

			//int exacto = algoritmoExacto.ejecutar(grafo, n);
			
			int prueba = algoritmo.ejecutar(grafo);

			distancia += ((n*2) - prueba);
		}

		promedio = distancia / cantidadDeMediciones;

		return promedio;
	}

}
