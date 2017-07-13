//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

import algoritmos.*;
import generadorGrafos.*;
import mediciones.Medicion;
import mediciones.MedicionAciertos;
import mediciones.MedicionAciertosInstanciasSolNoOptima;
import mediciones.MedicionDeCrecimientoEnCliquesDistancia;
import mediciones.MedicionDistancias;
import mediciones.MedicionTiempos;

public class Mediciones {

	// Instanciamos los distintos algoritmos		
	static Algoritmo exacto = new CMFexacto();
	static Algoritmo goloso = new CMFgoloso();
	static Algoritmo busquedaLocal = new CMFbusquedaLocal();
	static Algoritmo grasp = new CMFgrasp();

	// Instanciamos los distintos generadores de grafos
	static GeneradorGrafo aleatorio = new GrafoAleatorio();
	static GeneradorGrafo disconexo = new GrafoDisconexo();
	static GeneradorGrafo cliqueMaximaFronteraYNEstrellasDeGradoMaximo = new GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo();
	static GeneradorGrafo cliqueCuyosNodosTienenFrontera2 = new GrafoConCliquesCuyosNodosTienenFrontera2();

	// Instanciamos las distintas mediciones
	static MedicionTiempos medicionTiempos = new MedicionTiempos();
	static MedicionAciertos medicionAciertos = new MedicionAciertos();
	static MedicionAciertosInstanciasSolNoOptima medicionAciertosInstanciasSolNoOptima = new MedicionAciertosInstanciasSolNoOptima();
	static MedicionDistancias medicionDistancias = new MedicionDistancias();
	static MedicionDeCrecimientoEnCliquesDistancia medicionDeCrecimientoEnCliquesDistancia = new MedicionDeCrecimientoEnCliquesDistancia();
	
	public static void main(String[] args)
	{

//		escribirMediciones(100, 100, aleatorio, goloso, medicionDistancias);
//		escribirMediciones(100, 100, aleatorio, busquedaLocal, medicionDistancias);
//		escribirMediciones(100, 100, aleatorio, grasp, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, goloso, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, busquedaLocal, medicionDistancias);
//		escribirMediciones(50, 100, cliqueMaximaFronteraYNEstrellasDeGradoMaximo, grasp, medicionDistancias);
		
		
		goloso.setIncio(Inicio.NODO_MAYOR_GRADO);		
		busquedaLocal.setIncio(Inicio.NODO_MAYOR_GRADO);
		grasp.setIncio(Inicio.NODO_MAYOR_GRADO);
		medicionGrafoDeCrecimientoEnCliquesDistancia(17, 1);
		
	//	funcionesAux.printGrafo(cliqueCuyosNodosTienenFrontera2.generar(4, 0));
		
		// ademas a cada algoritmo con el metodo setInicio le seteamos el parametro de incio las dos opciones son las siguientes:
		grasp.setIncio(Inicio.NODO_ALEATORIO);		
		grasp.setIncio(Inicio.NODO_MAYOR_GRADO);

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
 * Impresiones para pruebas de generacion de grafos.
  		boolean[][] grafoCliqueCuyosNodosTienenFrontera2 = cliqueCuyosNodosTienenFrontera2.generar(3, 0);	
		funcionesAux.printGrafo(grafoCliqueCuyosNodosTienenFrontera2);

 */

	
	public static void medicionGrafoDeCrecimientoEnCliquesDistancia(int cantidadMediciones, int repeticiones) {
		escribirMediciones(cantidadMediciones, repeticiones, cliqueCuyosNodosTienenFrontera2, exacto, medicionDeCrecimientoEnCliquesDistancia);
		escribirMediciones(cantidadMediciones, repeticiones, cliqueCuyosNodosTienenFrontera2, goloso, medicionDeCrecimientoEnCliquesDistancia);
		escribirMediciones(cantidadMediciones, repeticiones, cliqueCuyosNodosTienenFrontera2, busquedaLocal, medicionDeCrecimientoEnCliquesDistancia);
		escribirMediciones(cantidadMediciones, repeticiones, cliqueCuyosNodosTienenFrontera2, grasp, medicionDeCrecimientoEnCliquesDistancia);		
	}
	
	
	

	public static void escribirMediciones(int cantidadDeGrafos, int cantidadMedicionesXInstancia, GeneradorGrafo generador, 
			Algoritmo algoritmo, Medicion medicion) {
        List<Object> mediciones = medicion.getMediciones(cantidadDeGrafos, cantidadMedicionesXInstancia, generador, algoritmo);
        
        String nombreArchivo = medicion.getNombre() + algoritmo.getNombre() + generador.getNombre() + ".txt";
        
        EntradaSalida.escribirTiempos(mediciones, nombreArchivo);
	}


	public static void experimentoMedicionAleatoria500Instancias30Repeticiones(GeneradorGrafo generadorGrafo, Algoritmo algoritmo, Medicion medicion) {
		algoritmo.setIncio(Inicio.NODO_ALEATORIO);
		escribirMediciones(500, 30, generadorGrafo, algoritmo, medicion);
	}

}
