package mediciones;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Algoritmo;
import algoritmos.CMFexacto;
import generadorGrafos.GeneradorGrafo;
import generadorGrafos.GrafoConCMFYNEstrellasDeGradoMaximo;

public class MedicionAciertosInstanciasSolNoOptima implements Medicion {

	public String getNombre() {
		return "AciertosInstanciasNoOptimas";
	}

	public List<Object> getMediciones(int cantidadDeGrafosEstrellaNodoMayorGrado, int cantidadMedicionesXInstancia, GeneradorGrafo generador, Algoritmo algoritmo) {
		List<Object> mediciones = new ArrayList<Object>();
		
		for (int i = 1; i < cantidadDeGrafosEstrellaNodoMayorGrado; i++) {
			System.out.println(i);
			mediciones.add(promedioDeAciertos(3, 3, cantidadMedicionesXInstancia, generador, algoritmo, i));
		}
		return mediciones;
	}	



	public static Float promedioDeAciertos(int cantidadDeGrafosEstrella, int cantidadDeNodosPorGrafoEstrella, int cantidadDeMediciones, GeneradorGrafo generador, Algoritmo algoritmo, int cantidadGrafosEstrellaNodoMayorGrado) {
		
		Float aciertos = new Float(0);
		Float promedio = new Float(0);
		
		Algoritmo algoritmoExacto = new CMFexacto();
		
		boolean[][] grafo = ((GrafoConCMFYNEstrellasDeGradoMaximo)generador).generar(cantidadDeGrafosEstrella, cantidadDeNodosPorGrafoEstrella/*, cantidadGrafosEstrellaNodoMayorGrado*/);
		int cantidadNodosClique = cantidadDeGrafosEstrella*cantidadDeNodosPorGrafoEstrella;;
    	int cantidadNodosDeGrafoNodoDeGradoMaximo = cantidadDeGrafosEstrella-1+1+cantidadDeNodosPorGrafoEstrella-1;
		
		int n = cantidadNodosClique + ((cantidadNodosDeGrafoNodoDeGradoMaximo + 1)*cantidadGrafosEstrellaNodoMayorGrado);
		
		for (int i = 0; i < cantidadDeMediciones; i++)
		{

			int exacto = algoritmoExacto.ejecutar(grafo);
			
			int prueba = algoritmo.ejecutar(grafo);

			if(exacto == prueba)
			{
				aciertos++;
			}
		}

		promedio = aciertos * 100 / cantidadDeMediciones;

		return promedio;
	}
}
