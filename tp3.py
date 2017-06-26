import random
import numpy as np

import math
from scipy import stats

#para la parte de graficos
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
import pylab


def leerDesdeArchivo(nombreArchivo):
    res = []
    archivo = open(nombreArchivo, "r") 

    for linea in archivo.readlines():
        if linea != "" :
            #linea = linea.split(" ")
            linea = linea.replace("\n", "")
            res.append(long(linea))
    archivo.close()
    return res
  

def leerDesdeArchivoAciertos(nombreArchivo):
    res = []
    archivo = open(nombreArchivo, "r") 

    for linea in archivo.readlines():
        if linea != "" :
            #linea = linea.split(" ")
            linea = linea.replace("\n", "")
            res.append(float(linea))
    archivo.close()
    return res 




def graficarCorrelacion(nombreArchivo):
	
	#tiempos = leerDesdeArchivo('Complejidad exacto.txt')
	#tiempos = leerDesdeArchivo('Complejidad goloso.txt')
	tiempos = leerDesdeArchivo('Complejidad busquedaLocal.txt')
	#tiempos = leerDesdeArchivo('Complejidad grasp.txt')


	complejidad = []
	nodos = range(0, len(tiempos))
	for n in nodos:
		#complejidad.append(float((2**n)*(n**2)))		#Exacto
		#complejidad.append(float(n**4))					#Goloso
		complejidad.append(float(n**5))				#BusquedaLocal
		#complejidad.append(float(n**6))				#Grasp


	df = pd.DataFrame()
	df['Nodos'] = nodos
	df['Tiempos (nanosegundos)'] = tiempos
	df['Complejidad n^5'] = complejidad

	sns.jointplot(df['Complejidad n^5'], df['Tiempos (nanosegundos)'], kind="reg")
	fig = sns.plt.gcf()
	sns.plt.show()    
	fig.savefig(nombreArchivo, dpi=300)    


def graficarTiempos(tiempos, nombreArchivo):

    instancias = range(0, len(tiempos))

    complejidad = []
    nodos = range(0, len(tiempos))
    for n in nodos:
        complejidad.append(float(n**5))

    #print complejidad
    df = pd.DataFrame({'Cantidad de nodos': instancias, 'Tiempos': tiempos, 'Complejidad': complejidad})
    df.plot(x='Cantidad de nodos')
    plt.ylabel('Tiempo (nanosegundos)')
    fig = plt.gcf()
    pylab.show()
    plt.show() # display
    plt.draw()
    fig.savefig(nombreArchivo, dpi=300)
    


def graficarComplejidades():

	exacto = leerDesdeArchivo('Complejidad exacto.txt')
	goloso = leerDesdeArchivo('Complejidad goloso.txt')
	busquedaLocal = leerDesdeArchivo('Complejidad busquedaLocal.txt')
	grasp = leerDesdeArchivo('Complejidad grasp.txt')

	longitud = min(len(exacto), len(goloso), len(busquedaLocal), len(grasp))

	instancias = range(0, longitud)


	#print complejidad
	df = pd.DataFrame({'Cantidad de nodos': instancias, 'Exacto': exacto[:longitud],  'Goloso': goloso[:longitud], 'busquedaLocal': busquedaLocal[:longitud], 'Grasp': grasp[:longitud]})
	df.plot(x='Cantidad de nodos', logy=True)
	plt.ylabel('Tiempo (nanosegundos)')
	fig = plt.gcf()
	pylab.show()
	plt.show() # display
	plt.draw()
	fig.savefig("Complejidades", dpi=300)



def graficarComplejidadesAristas():

	exacto = leerDesdeArchivo('Complejidad aristas exacto.txt')
	goloso = leerDesdeArchivo('Complejidad aristas goloso.txt')
	busquedaLocal = leerDesdeArchivo('Complejidad aristas busquedaLocal.txt')
	grasp = leerDesdeArchivo('Complejidad aristas grasp.txt')

	longitud = min(len(exacto), len(goloso), len(busquedaLocal), len(grasp))

	instancias = range(0, longitud)


	#print complejidad
	df = pd.DataFrame({'Cantidad de aristas': instancias, 'Exacto': exacto[:longitud],  'Goloso': goloso[:longitud], 'busquedaLocal': busquedaLocal[:longitud], 'Grasp': grasp[:longitud]})
	df.plot(x='Cantidad de aristas', logy=True)
	plt.ylabel('Tiempo (nanosegundos)')
	fig = plt.gcf()
	pylab.show()
	plt.show() # display
	plt.draw()
	fig.savefig("Complejidades aristas", dpi=300)



def graficarAciertosNodos():


	goloso = leerDesdeArchivoAciertos('Aciertos por nodo goloso.txt')
	busquedaLocal = leerDesdeArchivoAciertos('Aciertos por nodo busquedaLocal.txt')
	grasp = leerDesdeArchivoAciertos('Aciertos por nodo grasp.txt')

	longitud = min(len(goloso), len(busquedaLocal), len(grasp))

	instancias = range(0, longitud)


	#print complejidad
	df = pd.DataFrame({'Cantidad de nodos': instancias,  'Goloso': goloso[:longitud], 'busquedaLocal': busquedaLocal[:longitud], 'Grasp': grasp[:longitud]})
	df.plot(x='Cantidad de nodos', logy=False)
	plt.ylabel('Porcentaje de aciertos')
	fig = plt.gcf()
	pylab.show()
	plt.show() # display
	plt.draw()
	fig.savefig("Aciertos por nodo", dpi=300)





def graficarAciertosAristas():


	goloso = leerDesdeArchivoAciertos('Aciertos por arista goloso.txt')
	busquedaLocal = leerDesdeArchivoAciertos('Aciertos por arista busquedaLocal.txt')
	grasp = leerDesdeArchivoAciertos('Aciertos por arista grasp.txt')

	longitud = min(len(goloso), len(busquedaLocal), len(grasp))

	instancias = range(0, longitud)


	#print complejidad
	df = pd.DataFrame({'Cantidad de aristas': instancias,  'Goloso': goloso[:longitud], 'busquedaLocal': busquedaLocal[:longitud], 'Grasp': grasp[:longitud]})
	df.plot(x='Cantidad de aristas', logy=False)
	plt.ylabel('Porcentaje de aciertos')
	fig = plt.gcf()
	pylab.show()
	plt.show() # display
	plt.draw()
	fig.savefig("Aciertos por arista", dpi=300)
    


def graficarAciertosSubgrafos():


	goloso = leerDesdeArchivoAciertos('Aciertos por subgrafos goloso.txt')
	busquedaLocal = leerDesdeArchivoAciertos('Aciertos por subgrafos busquedaLocal.txt')
	grasp = leerDesdeArchivoAciertos('Aciertos por subgrafos grasp.txt')

	longitud = min(len(goloso), len(busquedaLocal), len(grasp))

	instancias = range(0, longitud)


	#print complejidad
	df = pd.DataFrame({'Cantidad de subgrafos': instancias,  'Goloso': goloso[:longitud], 'busquedaLocal': busquedaLocal[:longitud], 'Grasp': grasp[:longitud]})
	df.plot(x='Cantidad de subgrafos', logy=False)
	plt.ylabel('Porcentaje de aciertos')
	fig = plt.gcf()
	pylab.show()
	plt.show() # display
	plt.draw()
	fig.savefig("Aciertos por subgrafos", dpi=300)







graficarCorrelacion('pearson busquedaLocal.png')
#graficarComplejidades()
#graficarComplejidadesAristas()
#graficarAciertosNodos()
#graficarAciertosAristas()
#graficarAciertosSubgrafos()