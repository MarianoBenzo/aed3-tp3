package algoritmos;
import java.util.*;
import java.util.Random;

public class funcionesAux
{
    //frontera = Devuelve #frontera de la clique ingresada.
    public static int frontera(boolean[][] grafo, int n, List<Integer> clique)
    {
        //int res = 0;
        Set<Integer> res = new HashSet<Integer>();
        for(int i=0;i<clique.size();i++)
        {
            //res = res + 
            res.addAll((Collection<Integer>)nodosAdyacentes(grafo, n, clique.get(i)));//.size() - (clique.size() - 1);
        }
        int resultado = res.size();
        if (clique.size() != 1)
        	resultado = resultado - clique.size();
        return resultado;
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







    public static void printGrafo(boolean[][] grafo)
    {   
        int n = grafo[0].length;

        System.out.println("Grafo: ");
        for(int i=0;i<n;i++)
        {
            System.out.println(i + Arrays.toString(grafo[i]).replaceAll("true", "*").replaceAll("false", " "));
        }
        System.out.println(" ");
    }

    
    public static int getNodoIncial(boolean[][] grafo, int n, Inicio inicio) {
    	int nodoInicial = 0;
    	
    	switch (inicio) {
    		case NODO_MAYOR_GRADO:
    			nodoInicial = funcionesAux.nodoMayorGrado(grafo, n); break;
    		case NODO_ALEATORIO:
    			nodoInicial = (int) (Math.random() * n);
    	}
    	return nodoInicial;
    }
    
    

}
