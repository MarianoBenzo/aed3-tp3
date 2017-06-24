import java.util.*;

public class funcionesAux
{
    //frontera = Devuelve #frontera de la clique ingresada.
    public static int frontera(boolean[][] grafo, int n, List<Integer> clique)
    {
        int res = 0;

        for(int i=0;i<clique.size();i++)
        {
            res = res + nodosAdyacentes(grafo, n, clique.get(i)).size() - (clique.size() - 1);
        }

        return res;
    }

/*
    public static List<Integer> nodosFrontera(boolean[][] grafo, int n, List<Integer> clique)
    {
        List<Integer> nodosFrontera = new ArrayList<Integer>();
        for(int i=0;i<clique.size();i++)
        {
            nodosFrontera.addAll(nodosAdyacentes(grafo, n, clique.get(i)));
        }
        nodosFrontera.removeAll(clique);
        return nodosFrontera;
    }
*/
    //nodosAdyacentes = Devuelve los nodos adyacentes al nodo ingresado, en forma de array.
    public static List<Integer> nodosAdyacentes(boolean[][] grafo, int n, int nodo)
    {
        List<Integer> listAdy = new ArrayList<Integer>();

        for(int i=0;i<n;i++)
        {
            if(grafo[nodo][i])
            {
                listAdy.add(i);
            }
        }

        return listAdy;
    }



    //formaClique = True si la clique y el nodo ingresado forman una nueva clique.
    public static boolean formaClique(boolean[][] grafo, List<Integer> clique, int nodo)
        {
            boolean res = true;
            int i = 0;
            while(i < clique.size() && res)
            {
                res = grafo[nodo][clique.get(i)];
                i++;
            }
            return res;
        }


    //dameCliques = Devuelve todas las cliques formadas con los nodos ingresados.
    public static List<List<Integer>> dameCliques(boolean[][] grafo, List<Integer> nodos)
    {
        List<List<Integer>> cliques = new ArrayList<List<Integer>>();


        if (nodos.size()>1)
        {

            cliques.addAll(dameCliques(grafo, nodos.subList(1,nodos.size())));
            List<Integer> elemento = new ArrayList<Integer>();
            elemento.add(nodos.get(0));

            for(int i=0;i<cliques.size();i++)
            {
                if(formaClique(grafo, cliques.get(i), elemento.get(0)))
                {   
                    List<Integer> aux = new ArrayList<Integer>();
                   
                    aux.add(elemento.get(0));
                    aux.addAll(cliques.get(i));

                    cliques.add(aux);
                }
            }
            cliques.add(elemento);
        }
        else
        {
            cliques.add(nodos);    
        }

        return cliques;
    }



    //cliquesDeNodo = Devuelve todas las cliques formadas por nodo
    public static List<List<Integer>> cliquesDeNodo(boolean[][] grafo, int n, int nodo)
    {   

        List<Integer> adyacentes = nodosAdyacentes(grafo, n, nodo);

        List<List<Integer>> cliques = dameCliques(grafo, adyacentes);

        for(int i=0;i<cliques.size();i++)
        {
            cliques.get(i).add(nodo);
        }

        List<Integer> nodoList = new ArrayList<Integer>();
        nodoList.add(nodo);
        cliques.add(nodoList);

        return cliques;
    }



    //CMFnodo = Devuelve la frontera maxima de las cliques que forma el nodo ingresado
    public static int CMFnodo(boolean[][] grafo, int n, int nodo)
    {
        List<Integer> adyacentes = nodosAdyacentes(grafo, n, nodo);

        List<List<Integer>> cliques = cliquesDeNodo(grafo, n, nodo);

        int fronteraMax = 0;

        for(int i=0;i<cliques.size();i++)
        {
            int fronteraAux = frontera(grafo, n, cliques.get(i));
            if(fronteraAux > fronteraMax)
            {
                fronteraMax = fronteraAux;
            }
        }

        return fronteraMax;
    }  



/*
    public static List<Integer> cliqueMaxFronteraDeNodo(boolean[][] grafo, int n, int nodo)
    {
        List<Integer> adyacentes = nodosAdyacentes(grafo, n, nodo);
        List<List<Integer>> cliques = cliquesDeNodo(grafo, n, nodo);
        int fronteraMax = 0;
        List<Integer> cliqueMax = null;
        for(int i=0;i<cliques.size();i++)
        {
            if(frontera(grafo, n, cliques.get(i)) > fronteraMax)
            {
                cliqueMax = cliques.get(i);
                fronteraMax = frontera(grafo, n, cliques.get(i));
            }
        }
        return cliqueMax;
    }  
*/


    public static int nodoMayorGrado(boolean[][] grafo, int n)
    {   
        int mayorGrado = 0;
        Integer nodoMayorGrado = null;

        for(int nodo=0;nodo<n;nodo++)
        {
            int gradoNodo = funcionesAux.nodosAdyacentes(grafo, n, nodo).size();

            if( gradoNodo > mayorGrado)
            {
                mayorGrado = gradoNodo;
                nodoMayorGrado = nodo;
            }
        }    

        return nodoMayorGrado;
    }




    //Genera Grafo Aleatorio
    public static boolean[][] grafoRandom(int n, int m)
    {   

        boolean[][] grafo = new boolean[n][n];

        for (boolean[] fila : grafo)
        {
            Arrays.fill(fila, false);
        }


        List<Integer> rutas = new ArrayList<Integer>();
        
        for (int i=0;i<n*n;i++)
        {
            if(i%n > i/n)
            {
                rutas.add(i);
            }
        }


        for(int i=0;i<m;i++)
        {   
            //long seed = 1L;
            //Random random = new Random(seed);
            //int ruta = random.nextInt();
            //ruta = Math.abs(ruta % rutas.size());

            int ruta = (int) (Math.random() * rutas.size());

            int x = rutas.get(ruta)%n;
            int y = rutas.get(ruta)/n;
            grafo[x][y] = true;
            grafo[y][x] = true;

            rutas.remove(ruta);
        }

        return grafo;
    } 

	static boolean[][] crearGrafoCompleto(int n) {
		boolean[][] grafo = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grafo[i][j] = !(i == j); 
			}
		}
		return grafo;
	}


	static List<boolean[][]> getGrafosCompletos(int n) {
		List<boolean[][]> grafos = new ArrayList<boolean[][]>();
		for (int i = 1; i < n; i++) {
			grafos.add(crearGrafoCompleto(i));
		}
		return grafos;
	}


	static List<boolean[][]> getGrafosAleatorios(int n) {
        int m = n*(n-1)/5;
		List<boolean[][]> grafos = new ArrayList<boolean[][]>();
		for (int i = 1; i < n; i++) {
			grafos.add(funcionesAux.grafoRandom(n, m));
		}
		return grafos;
	}


    public static void printGrafo(boolean[][] grafo)
    {   
        int n = grafo[0].length;

        System.out.println("Grafo: ");
        for(int i=0;i<n;i++)
        {
            System.out.println(Arrays.toString(grafo[i]));
        }
        System.out.println(" ");
    }


    public static void main(String[] args)
    {
        int n = 5;
        //int m = n*(n-1)/2;
        int m = 5;

        boolean[][] grafo = grafoRandom(n, m);

        printGrafo(grafo);      

    }
    

}
