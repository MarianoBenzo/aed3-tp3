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

        List<Integer> fronteras = new ArrayList<Integer>();

        for(int i=0;i<cliques.size();i++)
        {
            fronteras.add(frontera(grafo, n, cliques.get(i)));
        }

        return Collections.max(fronteras);
    }  


/*

def parametrosRandom(n, m, k):

    G = []
    for i in range(n):
        G.append([])
        for j in range(n):
            G[i].append(None)
        
    #Rutas = Todas las rutas posibles enumeradas de 0 a n*n
    rutas = range(n*n)
    #Elimino rutas que tengas de origen y destino la misma ciudad
    for i in range(n):
        rutas.remove(n*i+i)


    for i in range(m):

        infoRuta = []

        #Quiero que las rutas premium tiendan a ser mas cortas
        if random.choice([True, False]):
            distancia = int(abs(random.normalvariate(50, 10)))
            infoRuta = [True, distancia]
        else:
            distancia = int(abs(random.normalvariate(70, 10)))
            infoRuta = [False, distancia]

        ruta = random.choice(rutas)

        #Al ser rutas bidireccionales la matriz se genera de forma geometrica
        rutas.remove(ruta)
        rutas.remove(n*(ruta%n) + ruta/n)

        G[ruta/n][ruta%n] = infoRuta
        G[ruta%n][ruta/n] = infoRuta

    #parametros = [Ciudades, rutas, origen, destino, rutas premium, grafo]
    parametros = [n, m, 0, n-1, k, G]
    
    return parametros

*/

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
            int ruta = (int) (Math.random() * rutas.size());

            int x = rutas.get(ruta)%n;
            int y = rutas.get(ruta)/n;
            grafo[x][y] = true;
            grafo[y][x] = true;

            rutas.remove(ruta);
        }

        return grafo;
    } 



    public static void printGrafo(boolean[][] grafo)
    {   
        int n = grafo[0].length;
        for(int i=0;i<n;i++)
        {
            System.out.println(Arrays.toString(grafo[i]));
        }
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
	