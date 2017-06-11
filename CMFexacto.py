from funcionesAux import dameCliques
from funcionesAux import frontera

#CMFgoloso: Busca todas las cliques del grafo, compara sus fronteras y devuelve la mayor.
def CMFexacto(grafo, n):
	#Grafo = Matriz, n = #Nodos.

	cliques = dameCliques(grafo, range(n))

	fronteras = []
	for clique in cliques:

		fronteras.append(frontera(grafo, n, clique))

	return max(fronteras)


n = 4
G = [
[False, True, False, True],
[True, False, True, True],
[False, True, False, False],
[True, True, False, False]
]


print CMFexacto(G, n)
