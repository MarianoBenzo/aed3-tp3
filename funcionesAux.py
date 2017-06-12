#frontera = Devuelve #frontera de la clique ingresada.
def frontera(grafo, n, clique):
	res = 0
	for i in range(len(clique)):
		res += len(nodosAdyacentes(grafo, n, clique[i])) - (len(clique) - 1)

	return res


#formaClique = True si la clique y el nodo ingresado forman una nueva clique.
def formaClique(grafo, clique, nodo):
	#Grafo = Matriz, clique = Lista de nodos, nodo = Nodo.

	res = True
	i = 0
	
	while i < len(clique) and res:

		nodoClique = clique[i]
		res = grafo[nodo][nodoClique]

		i += 1

	return res
				

#nodosAdyacentes = Devuelve los nodos adyacentes al nodo ingresado, en forma de lista.
def nodosAdyacentes(grafo, n, nodo):
	#Grafo = Matriz, n = #Nodos, nodo = Nodo.

	res = []
	for i in range(n):
		if grafo[nodo][i]:
			res.append(i)

	return res


#dameCliques = Devuelve todas las cliques formadas con los nodos ingresados.
def dameCliques(grafo, nodos):
	#Grafo = Matriz, nodos = Lista de nodos.

	cliques=[]
	cantNodos=len(nodos)

	if cantNodos>1:
		cliques+=dameCliques(grafo, nodos[1:])
		elemento=[nodos[0]]
		for sub in cliques[:]:
			
			if formaClique(grafo, sub, elemento[0]):
				cliques.append(sub+elemento)

		cliques.append(elemento)
	else:
		cliques+=[nodos]

	return cliques

#cliquesDeNodo = Devuelve todas las cliques formadas por nodo
def cliquesDeNodo(grafo, nodo, adyacentes):
	#Grafo = Matriz, nodo = Nodo, adyacentes = Lista de nodos adyacentes a nodo.

	cliques=dameCliques(grafo, adyacentes)


	for clique in cliques:
		clique.append(nodo)

	cliques.append([nodo])


  	return cliques



#CMFnodo = Devuelve la frontera maxima de las cliques que forma el nodo ingresado
def CMFnodo(grafo, n, nodo):
	#Grafo = Matriz, n = #Nodos, nodo = Nodo.

	adyacentes = nodosAdyacentes(grafo, n, nodo)

	cliques = cliquesDeNodo(grafo, nodo, adyacentes)

	fronteras = []

	for clique in cliques:
		fronteras.append(frontera(grafo, n, clique))

	return max(fronteras)

