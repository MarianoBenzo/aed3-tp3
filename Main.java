import algoritmos.CondicionDeCorte;
import algoritmos.Inicio;

public class Main {
	
	public static void main(String[] args) {
		
		Mediciones.exacto.setInicio(Inicio.NODO_ALEATORIO);
		
		
		//Mediciones.medicionGrafoAleatorioAciertosIncrementandoAristas(200, 100);
		//Mediciones.medicionGrafoAleatorioAciertosIncrementandoNodos(200, 100);
		//Mediciones.medicionGrafoAleatorioDistancia(50, 100);
		//Mediciones.medicionGrafoConCliqueMaximaFronteraYNEstrellasDeGrafoMaximo(50, 100);
		
		//Mediciones.medicionDistanciaIncrementandoElTamanoClique(50, 1);
		
		
		seteoParamsAleatorio();
		//Mediciones.grasp.setCondicionDeCorteEnIteraciones(CondicionDeCorte.CINCO_VECES_SIN_MEJORAR);
//		Mediciones.medicionDistanciaIncrementandoLasCliques(50, 10);

		
		
		//Mediciones.medicionTiemposIncrementandoLasEstrellasYeLTamanoDeLaCMF(50, 10);
		//Mediciones.medicionDistanciaIncrementandoLasCliquesYeLTamanoDeLasMismasEnganchadasUnNodoEnComun(50, 1);
		//Mediciones.medicionGrafoInstanciasSolNoOptima(50,100);

		Mediciones.medicionDistanciaIncrementandoLasEstrellasYeLTamanoDeLaCMF(50, 10);
	
		
		//	funcionesAux.printGrafo(Mediciones.cliques0aNEnganchadasConUnNodoEnComun.generar(6, 0));
//		System.out.println(((GrafoCliques0aNEnganchadasConUnNodoEnComun)Mediciones.cliques0aNEnganchadasConUnNodoEnComun).getPosicion(5));
		/*		int tamAnterior = 0;
		int posicion = 0;
		for (int i=1; i<=4; i++) {
			System.out.println(posicion);
			tamAnterior = i-1;
			posicion = posicion + tamAnterior;
		}*/

	}

	static public void medicionesGraspParametroCorte(int cantidadMediciones, int repeticiones) {
		Mediciones.grasp.setCondicionDeCorteEnIteraciones(CondicionDeCorte.CINCO_VECES_SIN_MEJORAR);
		Mediciones.escribirMediciones(cantidadMediciones, repeticiones, Mediciones.cliques0aN, Mediciones.grasp, Mediciones.medicionDeCrecimientoEnCliquesDistancia);		
		Mediciones.escribirMediciones(cantidadMediciones, repeticiones, Mediciones.cliques0aN, Mediciones.grasp, Mediciones.medicionTiemposIncrementando1);		
		Mediciones.escribirMediciones(cantidadMediciones, repeticiones, Mediciones.cliques0aN, Mediciones.grasp, Mediciones.medicionDeCrecimientoEnCliquesDistancia);		
		Mediciones.escribirMediciones(cantidadMediciones, repeticiones, Mediciones.cliques0aN, Mediciones.grasp, Mediciones.medicionTiemposIncrementando1);		
	}
	
	static public void seteoParamsAleatorio() {
		Mediciones.goloso.setInicio(Inicio.NODO_ALEATORIO);
		Mediciones.busquedaLocal.setInicio(Inicio.NODO_ALEATORIO);		
		Mediciones.grasp.setInicio(Inicio.NODO_ALEATORIO);		
	}
	
}
