package mediciones;

import java.util.List;

import algoritmos.Algoritmo;
import algoritmos.Inicio;
import generadorGrafos.GeneradorGrafo;

public interface Medicion {
	public String getNombre();
	public List<Object> getMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia,
			GeneradorGrafo generador, Algoritmo algoritmo);
}
