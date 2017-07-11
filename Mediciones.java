//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

import algoritmos.*;
import generadorGrafos.*;
import mediciones.Medicion;
import mediciones.MedicionAciertos;
import mediciones.MedicionAciertosInstanciasSolNoOptima;
import mediciones.MedicionTiempos;

public class Mediciones {

	public static void main(String[] args)
    {
		
    	
		// Instanciamos los distintos algoritmos		
		Algoritmo exacto = new CMFexacto();
		Algoritmo goloso = new CMFgoloso();
		Algoritmo busquedaLocal = new CMFbusquedaLocal();
		Algoritmo grasp = new CMFgrasp();
		
		// Instanciamos los distintos generadores de grafos
		GeneradorGrafo aleatorio = new GrafoAleatorio();
		GeneradorGrafo disconexo = new GrafoDisconexo();
		GeneradorGrafo cliqueMaximaFronteraYNEstrellasDeGradoMaximo = new GrafoConCliqueMaximaFronteraYNEstrellasDeGradoMaximo();
		
		// Instanciamos las distintas mediciones
		MedicionTiempos medicionTiempos = new MedicionTiempos();
		MedicionAciertos medicionAciertos = new MedicionAciertos();
		MedicionAciertosInstanciasSolNoOptima medicionAciertosInstanciasSolNoOptima = new MedicionAciertosInstanciasSolNoOptima();

		
		// ademas a cada algoritmo con el metodo setInicio le seteamos el parametro de incio las dos opciones son las siguientes:
		grasp.setIncio(Inicio.NODO_ALEATORIO);		
		grasp.setIncio(Inicio.NODO_MAYOR_GRADO);

		// y despues podemos llamar a la escritura de las mediciones con las instancias que queramos asi:
		escribirMediciones(600, 100, aleatorio, goloso, medicionTiempos);
		escribirMediciones(600, 100, aleatorio, busquedaLocal, medicionTiempos);
		escribirMediciones(600, 100, aleatorio, grasp, medicionTiempos);

		
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