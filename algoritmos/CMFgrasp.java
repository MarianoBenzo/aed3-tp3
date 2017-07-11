package algoritmos;


public class CMFgrasp implements Algoritmo
{
	private static Inicio inicio = Inicio.NODO_MAYOR_GRADO;

	public void setIncio(Inicio inicio) {
		this.inicio = inicio;
	}
		
	public String getNombre() {
		return "Grasp";
	}

	
    public int ejecutar(boolean[][] grafo, int n)
    {	

        int nodo = funcionesAux.getNodoIncial(grafo, n, inicio);
        CMFbusquedaLocal busquedaLocal = new CMFbusquedaLocal();
        int maxFrontera = 0;

        for(int j=0;j<n/10;j++)
        {

            int frontera =  busquedaLocal.CMFbusquedaLocalAux(grafo, n, nodo);

            if(maxFrontera < frontera)
            {
                maxFrontera = frontera;
            }
            
            nodo = (int) (Math.random() * n);

        }

        return maxFrontera;
    }

    
    
/*
    public static void main(String[] args)
    {
        int n = 200;
        
        int m = n*(n-1)/8;

        boolean[][] grafo = funcionesAux.grafoRandom(n, m);

        System.out.println("CMF Goloso: "+CMFgoloso.CMFgoloso(grafo, n));
        System.out.println("CMF Busqueda Local: "+CMFbusquedaLocal.CMFbusquedaLocal(grafo, n));
        System.out.println("CMF Grasp: "+CMFgrasp(grafo, n));
        System.out.println("CMF Exacto: "+CMFexacto.CMFexacto(grafo, n));
    }*/

}