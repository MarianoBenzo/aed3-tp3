package mediciones;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Algoritmo;
import algoritmos.CMFexacto;
import generadorGrafos.GeneradorGrafo;

public class MedicionDistancias implements Medicion {
	public String getNombre() {
		return "Distancias";
	}

	public List<Object> getMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, GeneradorGrafo generador, Algoritmo algoritmo) {
		List<Object> mediciones = new ArrayList<Object>();

		int n = 2;//por nodo
		int m = (n*(n-1)/32)+1;//por nodo
		
		//int n = 15;//por arista
		//int m = 1;//por arista
		
		//int n = 50;//por subgrafo
		//int m = 1;//por subgrafo

		for (int i = 1; i <= cantidadDeGrafos; i++) {
			
			System.out.println(i);
			
			mediciones.add(promedioDeDistancias(n, m, cantidadMedicionesXInstancia, generador, algoritmo));
			
			n++;//por nodo
			m = (n*(n-1)/32)+1;//por nodo

			//m++;//por arista

			//m++;//por subgrafo
		}
		return mediciones;
	}	



	public static Float promedioDeDistancias(int n, int m, int cantidadDeMediciones, GeneradorGrafo generador, Algoritmo algoritmo) {
		
		Float distancia = new Float(0);
		Float promedio = new Float(0);
		
		Algoritmo algoritmoExacto = new CMFexacto();
		
		for (int i = 1; i <= cantidadDeMediciones; i++)
		{
			boolean[][] grafo = generador.generar(n, m);

			int exacto = algoritmoExacto.ejecutar(grafo);
			
			int prueba = algoritmo.ejecutar(grafo);

			distancia += (exacto - prueba);
		}

		promedio = distancia / cantidadDeMediciones;

		return promedio;
	}

}
