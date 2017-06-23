import java.util.*;

public class CMFbusquedaLocal
{

    public static int CMFbusquedaLocal(boolean[][] grafo, int n)
       {    

        int nodoInicial = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodoInicial = (int) (Math.random() * n);

        List<Integer> adyacentes = funcionesAux.nodosAdyacentes(grafo, n, nodoInicial);


        List<Integer> cliqueMaxFronteraNodo = new ArrayList<Integer>();
        cliqueMaxFronteraNodo.add(nodoInicial);      
        int maxFronteraNodo = adyacentes.size();


        List<Integer> cliqueMaxFronteraLocal = new ArrayList<Integer>(cliqueMaxFronteraNodo);
        int maxFronteraLocal = maxFronteraNodo;

        List<Integer> cliqueAux = new ArrayList<Integer>();


        List<Integer> nodosUsados = new ArrayList<Integer>();
        

        //boolean finDos = false;


        int j = 0;
        while(j<n/* && !finDos*/)
        {
            //finDos = true;
            
            boolean finUno = false;
            int i = 0;


            while(i<n && !finUno)
            {   
                finUno = true;

                for(int adyacente : adyacentes)
                {   

                    if(funcionesAux.formaClique(grafo, cliqueMaxFronteraNodo, adyacente))
                    {
                        List<Integer> nuevaClique = new ArrayList<Integer>(cliqueMaxFronteraNodo);
                        nuevaClique.add(adyacente);

                        int nuevaFrontera = funcionesAux.frontera(grafo, n, nuevaClique);

                        if(nuevaFrontera > maxFronteraNodo)
                        {   
                            maxFronteraNodo = nuevaFrontera;
                            cliqueAux = new ArrayList<Integer>(nuevaClique);
                            finUno = false;
                        }
                    }

                }

                cliqueMaxFronteraNodo = cliqueAux;

                i++;
            }


            if(maxFronteraLocal < maxFronteraNodo)
            {   

                maxFronteraLocal = maxFronteraNodo;

                cliqueMaxFronteraLocal = new ArrayList<Integer>(cliqueMaxFronteraNodo);

                //finDos = false;
                

            }

            //nodosUsados.add(cliqueMaxFronteraNodo.get(0));
            Integer aux = cliqueMaxFronteraNodo.get(0);
            int aux2 = cliqueMaxFronteraNodo.get(1);
            cliqueMaxFronteraNodo.remove(0);


            adyacentes = funcionesAux.nodosAdyacentes(grafo, n, aux2);
            //adyacentes.removeAll(nodosUsados);
            adyacentes.remove(aux);


            maxFronteraNodo = 0;
            j++;
        }
        return maxFronteraLocal;
    }


    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}