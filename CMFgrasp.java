import java.util.*;

public class CMFgrasp
{

    public static int CMFgrasp(boolean[][] grafo, int n)
    {	

        int nodo = funcionesAux.nodoMayorGrado(grafo, n);
        //int nodo = (int) (Math.random() * n);
        
        int maxFrontera = 0;

        for(int j=0;j<n/10;j++)
        {

            int frontera = CMFbusquedaLocal.CMFbusquedaLocalAux(grafo, n, nodo);

            if(maxFrontera < frontera)
            {
                maxFrontera = frontera;
            }
            
            nodo = (int) (Math.random() * n);

        }

        return maxFrontera;
    }


    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal.CMFbusquedaLocal(grafo, n));
        System.out.println("CMF Grasp: "+CMFgrasp(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }

}