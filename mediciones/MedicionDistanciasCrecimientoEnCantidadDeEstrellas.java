package mediciones;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Algoritmo;
import algoritmos.CMFexacto;
import generadorGrafos.GeneradorGrafo;
import generadorGrafos.GrafoConCMFYNEstrellasDeGradoMaximo;

public class MedicionDistanciasCrecimientoEnCantidadDeEstrellas implements Medicion {
	public String getNombre() {
		return "DistanciasCrecimientoEnCantidadDeEstrellas";
	}

	public List<Object> getMediciones(int cantidadDeGrafosEstrellaNodoMayorGrado, int cantidadMedicionesXInstancia, GeneradorGrafo generador, Algoritmo algoritmo) {
		List<Object> mediciones = new ArrayList<Object>();
		
		for (int i = 1; i < cantidadDeGrafosEstrellaNodoMayorGrado; i++) {
			System.out.println(i);
			mediciones.add(promedioDeDistancias(i, i, cantidadMedicionesXInstancia, generador, algoritmo, i));
		}
		return mediciones;
	}	



	public static Float promedioDeDistancias(int cantidadNodosEnCliqueMaxima, int cantidadDeGrafosEstrella, 
			int cantidadDeMediciones, GeneradorGrafo generador, 
			Algoritmo algoritmo, int cantidadGrafosEstrellaNodoMayorGrado) {
		
		Float distancia = new Float(0);
		Float promedio = new Float(0);
		
//		Algoritmo algoritmoExacto = new CMFexacto();
		
		boolean[][] grafo = generador.generar(cantidadNodosEnCliqueMaxima, cantidadDeGrafosEstrella);
		
		for (int i = 0; i < cantidadDeMediciones; i++)
		{

//			int exacto = algoritmoExacto.ejecutar(grafo);
			
			int prueba = algoritmo.ejecutar(grafo);

			distancia += generador.getMaximaFrontera() - prueba;////(exacto - prueba);
		}

		promedio = distancia / cantidadDeMediciones;

		return promedio;
	}
}
