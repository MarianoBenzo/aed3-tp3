//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

import algoritmos.*;
import generadorGrafos.*;
import mediciones.Medicion;
import mediciones.MedicionAciertos;
import mediciones.MedicionAciertosIncrementandoAristas;
import mediciones.MedicionAciertosIncrementandoNodos;
import mediciones.MedicionAciertosInstanciasSolNoOptima;
import mediciones.MedicionDeCrecimientoEnCliquesDistancia;
import mediciones.MedicionDistancias;
import mediciones.MedicionDistanciasCrecimientoEnCantidadDeEstrellas;
import mediciones.MedicionTiempos;
import mediciones.MedicionTiemposIncrementando1;

public class Mediciones {

	// Instanciamos los distintos algoritmos		
	static Algoritmo exacto = new CMFexacto();
	static Algoritmo goloso = new CMFgoloso();
	static Algoritmo busquedaLocal = new CMFbusquedaLocal();
	static Algoritmo grasp = new CMFgrasp();

	// Instanciamos los distintos generadores de grafos
	static GeneradorGrafo aleatorio = new GrafoAleatorio();
	static GeneradorGrafo disconexo = new GrafoDisconexo();
	static GeneradorGrafo CMFYNEstrellasDeGradoMaximo = new GrafoConCMFYNEstrellasDeGradoMaximo();
	static GeneradorGrafo cliques0aN = new GrafoConCliques0aN();
	static GeneradorGrafo clique = new GrafoClique();
	static GeneradorGrafo cliques0aNEnganchadasConUnNodoEnComun = new GrafoCliques0aNEnganchadasConUnNodoEnComun();

	// Instanciamos las distintas mediciones
	static Medicion medicionTiempos = new MedicionTiempos();
	static Medicion medicionAciertos = new MedicionAciertos();
	static Medicion medicionAciertosInstanciasSolNoOptima = new MedicionAciertosInstanciasSolNoOptima();
	static Medicion medicionDistancias = new MedicionDistancias();
	static Medicion medicionDeCrecimientoEnCliquesDistancia = new MedicionDeCrecimientoEnCliquesDistancia();
	static Medicion medicionAciertosIncrementandoAristas = new MedicionAciertosIncrementandoAristas();
	static Medicion medicionAciertosIncrementandoNodos = new MedicionAciertosIncrementandoNodos();
	static Medicion medicionDistanciasIncrementandoCMFYEstrellas = new MedicionDistanciasCrecimientoEnCantidadDeEstrellas(); 
	static Medicion medicionTiemposIncrementando1 = new MedicionTiemposIncrementando1(); 

	
	public static void main(String[] args)
	{

//		escribirMediciones(100, 100, aleatorio, goloso, medicionDistancias);
//		escribirMediciones(100, 100, aleatorio, busquedaLocal, medicionDistancias);
//		escribirMediciones(100, 100, aleatorio, grasp, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, goloso, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, busquedaLocal, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, grasp, medicionDistancias);
		
		
		goloso.setInicio(Inicio.NODO_MAYOR_GRADO);		
		busquedaLocal.setInicio(Inicio.NODO_MAYOR_GRADO);
		grasp.setInicio(Inicio.NODO_MAYOR_GRADO);
		medicionDistanciaIncrementandoLasCliques(17, 1);
		
	//	funcionesAux.printGrafo(cliqueCuyosNodosTienenFrontera2.generar(4, 0));
		
		// ademas a cada algoritmo con el metodo setInicio le seteamos el parametro de incio las dos opciones son las siguientes:
		grasp.setInicio(Inicio.NODO_ALEATORIO);		
		grasp.setInicio(Inicio.NODO_MAYOR_GRADO);

		// y despues podemos llamar a la escritura de las mediciones con las instancias que queramos asi:
		//escribirMediciones(600, 100, aleatorio, goloso, medicionTiempos);
		//escribirMediciones(600, 100, aleatorio, busquedaLocal, medicionTiempos);
		//escribirMediciones(600, 100, aleatorio, grasp, medicionTiempos);

		
//		GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo problematico = new GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo();
		

    	//int cantGrafos = 300;
		//escribirMediciones(cantGrafos, 30, "Complejidad grasp.txt");
		
	  	int cantGrafos = (50*(50-1)/2)-1;
		int cg = 50;
//	  	escribirMediciones(/*cantGrafos*/50, 30, problematico, goloso, medicionAciertos);


		// cantidadGrafosEstrella, cantidadNodosPorGrafoEstrella
//		boolean[][] clique = GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo.crearCliqueConGrafosEstrella(3, 3);
		
//		boolean[][] grafoEstrella = GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo.crearGrafoEstrella(4);
//		boolean[][] grafoProblematico = problematico.generar(3, 3, 5);
		
		
		//experimentoMedicionAleatoria500Instancias30Repeticiones(problematico, goloso, medicionAciertosInstanciasSolNoOptima);
		//experimentoMedicionAleatoria500Instancias30Repeticiones(problematico, busquedaLocal, medicionAciertosInstanciasSolNoOptima);
		//experimentoMedicionAleatoria500Instancias30Repeticiones(problematico, grasp, medicionAciertosInstanciasSolNoOptima);
		
//		escribirMediciones(600, 50, aleatorio, exacto, medicionTiempos);

		
		
//		funcionesAux.printGrafo(grafoProblematico);
/*	    int tamf = 0;
		int tamf2 = 1;
		int i=1;
		while (tamf != tamf2) {
			i++;
			tamf = goloso.ejecutar(grafoProblematico, 15);
			tamf2 = exacto.ejecutar(grafoProblematico, 15);
			System.out.println(i + "- Busqueda local: " + tamf + ", Exacto: " + tamf2);
		}*/
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

	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 CMF de tamano n y n estrellas de grado maximo.
	 */
	public static void medicionDistanciaIncrementandoLasEstrellasYeLTamanoDeLaCMF(int cantidadMediciones, int repeticiones) {
//		System.out.println("exacto:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, exacto, medicionDistanciasIncrementandoCMFYEstrellas);
//		System.out.println("goloso:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, goloso, medicionDistanciasIncrementandoCMFYEstrellas);
//		System.out.println("busqueda local:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, busquedaLocal, medicionDistanciasIncrementandoCMFYEstrellas);
		System.out.println("grasp:");
		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, grasp, medicionDistanciasIncrementandoCMFYEstrellas);		
		System.out.println("fin");
	}
	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos y las n cliques son cliques de tamano 1 a n 
	 * enganchadas por un nodo en comun.
	 */
	public static void medicionDistanciaIncrementandoLasCliquesYeLTamanoDeLasMismasEnganchadasUnNodoEnComun(int cantidadMediciones, int repeticiones) {
//		System.out.println("exacto:");
//		escribirMediciones(cantidadMediciones, repeticiones, cliques0aNEnganchadasConUnNodoEnComun, exacto, medicionDistancias);
		System.out.println("goloso:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aNEnganchadasConUnNodoEnComun, goloso, medicionDistancias);
		System.out.println("busqueda local:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aNEnganchadasConUnNodoEnComun, busquedaLocal, medicionDistancias);
		System.out.println("grasp:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aNEnganchadasConUnNodoEnComun, grasp, medicionDistancias);		
		System.out.println("fin");
	}

	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre una clique de n nodos.
	 */
	public static void medicionDistanciaIncrementandoElTamanoClique(int cantidadMediciones, int repeticiones) {
//		System.out.println("exacto:");
//		escribirMediciones(cantidadMediciones, repeticiones, clique, exacto, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("goloso:");
		escribirMediciones(cantidadMediciones, repeticiones, clique, goloso, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("busqueda local:");
		escribirMediciones(cantidadMediciones, repeticiones, clique, busquedaLocal, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("grasp:");
		escribirMediciones(cantidadMediciones, repeticiones, clique, grasp, medicionDeCrecimientoEnCliquesDistancia);		
		System.out.println("fin");
	}
	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 CMF de tamano n y n estrellas de grado maximo.
	 */
	public static void medicionTiemposIncrementandoLasEstrellasYeLTamanoDeLaCMF(int cantidadMediciones, int repeticiones) {
//		System.out.println("exacto:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, exacto, medicionDistanciasIncrementandoCMFYEstrellas);
//		System.out.println("goloso:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, goloso, medicionTiemposIncrementando1/*medicionDistanciasIncrementandoCMFYEstrellas*/);
//		System.out.println("busqueda local:");
//		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, busquedaLocal, medicionTiemposIncrementando1/*medicionDistanciasIncrementandoCMFYEstrellas*/);
		System.out.println("grasp:");
		escribirMediciones(cantidadMediciones, repeticiones, CMFYNEstrellasDeGradoMaximo, grasp, medicionTiemposIncrementando1/*medicionDistanciasIncrementandoCMFYEstrellas*/);		
		System.out.println("fin");
	}	
	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionDistanciaIncrementandoLasCliques(int cantidadMediciones, int repeticiones) {
//		System.out.println("exacto:");
//		escribirMediciones(cantidadMediciones, repeticiones, cliques0aN, exacto, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("goloso:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aN, goloso, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("busqueda local:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aN, busquedaLocal, medicionDeCrecimientoEnCliquesDistancia);
		System.out.println("grasp:");
		escribirMediciones(cantidadMediciones, repeticiones, cliques0aN, grasp, medicionDeCrecimientoEnCliquesDistancia);		
		System.out.println("fin");
	}

	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionGrafoAleatorioDistancia(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, exacto, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, goloso, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, busquedaLocal, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, grasp, medicionDistancias);		
	}
	

	
//-----------------PENDIENTE VER ESTOS-----------------------------//	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: aciertos
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 clique de 3 nodos n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionGrafoAleatorioAciertosIncrementandoAristas(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, exacto, medicionAciertosIncrementandoAristas);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, goloso, medicionAciertosIncrementandoAristas);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, busquedaLocal, medicionAciertosIncrementandoAristas);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, grasp, medicionAciertosIncrementandoAristas);		
	}

	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: aciertos
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 clique de 3 nodos n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionGrafoAleatorioAciertosIncrementandoNodos(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, exacto, medicionAciertosIncrementandoNodos);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, goloso, medicionAciertosIncrementandoNodos);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, busquedaLocal, medicionAciertosIncrementandoNodos);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, grasp, medicionAciertosIncrementandoNodos);		
	}
	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 clique de 3 nodos n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionGrafoConCliqueMaximaFronteraYNEstrellasDeGrafoMaximo(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, exacto, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, goloso, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, busquedaLocal, medicionDistancias);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, grasp, medicionDistancias);		
	}
	
	/**
	 * 
	 * @param cantidadMediciones
	 * @param repeticiones
	 * 
	 * Tipo de Medicion: distancia a la solucion optima
	 * 
	 * La medicion n va a medir sobre un grafo conexo con 1 clique de 3 nodos n cliques donde la primer clique 
	 * va a estar compuesta por 1 nodo y la ultima por n nodos.
	 */
	public static void medicionGrafoInstanciasSolNoOptima(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, exacto, medicionAciertosInstanciasSolNoOptima);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, goloso, medicionAciertosInstanciasSolNoOptima);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, busquedaLocal, medicionAciertosInstanciasSolNoOptima);
		escribirMediciones(cantidadMediciones, repeticiones, aleatorio, grasp, medicionAciertosInstanciasSolNoOptima);		
	}

	
/**
 * Impresiones para pruebas de generacion de grafos.
  		boolean[][] grafoCliqueCuyosNodosTienenFrontera2 = cliqueCuyosNodosTienenFrontera2.generar(3, 0);	
		funcionesAux.printGrafo(grafoCliqueCuyosNodosTienenFrontera2);

 */

	public static void escribirMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, GeneradorGrafo generador, 
			Algoritmo algoritmo, Medicion medicion) {
        List<Object> mediciones = medicion.getMediciones(cantidadDeGrafos, cantidadMedicionesXInstancia, generador, algoritmo);
        
        String nombreArchivo = medicion.getNombre() + algoritmo.getNombre() + generador.getNombre() + ".txt";
        
        EntradaSalida.escribirTiempos(mediciones, nombreArchivo);
	}


	public static void experimentoMedicionAleatoria500Instancias30Repeticiones(GeneradorGrafo generadorGrafo, Algoritmo algoritmo, Medicion medicion) {
		algoritmo.setInicio(Inicio.NODO_ALEATORIO);
		escribirMediciones(500, 30, generadorGrafo, algoritmo, medicion);
	}

}