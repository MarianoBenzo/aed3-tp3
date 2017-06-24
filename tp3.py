import random
import numpy as np
from time import time #importamos la función time para capturar tiempos
import math
from scipy import stats

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
    

#para la parte de graficos
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
import pylab
tiempos = leerDesdeArchivo('tiemposAgregandoAristas.txt')
print tiempos

def graficarCorrelacion(nodos, tiempos, complejidad, nombreArchivo):
    df = pd.DataFrame()
    df['Nodos'] = nodos
    df['Tiempos (milisegundos)'] = tiempos
    df['Complejidad (2^n)n^2'] = complejidad

    sns.jointplot(df['Complejidad (2^n)n^2'], df['Tiempos (milisegundos)'], kind="reg")
    fig = sns.plt.gcf()
    sns.plt.show()    
    fig.savefig(nombreArchivo, dpi=300)    


def graficarTiempos(tiempos, nombreArchivo):

    instancias = range(0, len(tiempos))

    complejidad = []
    nodos = range(0, len(tiempos))
    for n in nodos:
        complejidad.append(float((n**4)))

    #print complejidad
    df = pd.DataFrame({'Cantidad de nodos': instancias, 'Tiempos': tiempos})#, 'Complejidad': complejidad})
    df.plot(x='Cantidad de nodos')
    plt.ylabel('Tiempo (milisegundos)')
    fig = plt.gcf()
    pylab.show()
    plt.show() # display
    plt.draw()
    fig.savefig(nombreArchivo, dpi=300)
    
    
    
    
complejidad = []
nodos = range(0, len(tiempos))
for n in nodos:
    complejidad.append(float((2**n)*(n**2)))

complejidad2 = []
nodos = range(0, len(tiempos))
for n in nodos:
    complejidad2.append(float((n**7)))

#graficarCorrelacion(nodos, tiempos, complejidad, 'pearsonTiempos.png')
graficarTiempos(tiempos, 'tiemposAgregandoAristas.png')
#graficarTiempos(complejidad2, 'complejidad.png')
graficarCorrelacion(nodos, tiempos, complejidad, 'pearsonTiempos.png')
