from funcionesAux import nodosAdyacentes
from funcionesAux import CMFnodo

#CMFgoloso: Busca al nodo de mayor grado, busca todas las cliques formadas por este nodo, compara las fronteras de estas cliques y devuelve la mayor.
def CMFgoloso(grafo, n):
	#grafo = Matriz, n = #Nodos.

	mayorGrado = 0
	nodoMayorGrado = None
	for nodo in range(n):
		gradoNodo = len(nodosAdyacentes(grafo, n, nodo))
		
		if gradoNodo > mayorGrado:
			mayorGrado = gradoNodo
			nodoMayorGrado = nodo

	return CMFnodo(grafo, n, nodoMayorGrado)

n = 4
G = [
[False, True, False, True],
[True, False, True, True],
[False, True, False, False],
[True, True, False, False]
]


print CMFgoloso(G, n)