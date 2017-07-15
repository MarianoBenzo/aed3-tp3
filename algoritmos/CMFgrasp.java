package algoritmos;


public class CMFgrasp implements Algoritmo
{
	private static Inicio inicio = Inicio.NODO_MAYOR_GRADO;
	private static CondicionDeCorte condicionDeCorte = CondicionDeCorte.CANTIDAD_DE_NODOS_DIVIDO_DIEZ;

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}
		
	public String getNombre() {
		return "Grasp";
	}

	
    public int ejecutar(boolean[][] grafo)
    {	
    	int n = grafo.length;
        int nodoInicial = funcionesAux.getNodoIncial(grafo, n, inicio);
        CMFbusquedaLocal busquedaLocal = new CMFbusquedaLocal();
        ((Algoritmo)busquedaLocal).setInicio(inicio);

        int maxFrontera = getMaxFrontera(grafo, n, nodoInicial, condicionDeCorte, busquedaLocal); 

        return maxFrontera;
    }

    public static int getMaxFrontera(boolean[][] grafo, int n, int nodoInicial, 
    		CondicionDeCorte condicionDeCorte, CMFbusquedaLocal busquedaLocal) {
    	int maxFrontera = 0;
    	switch (condicionDeCorte) {
    		case CANTIDAD_DE_NODOS_DIVIDO_DIEZ:
    	        maxFrontera = ejecutarVerificandoCantidadDeNodosDividoDiez(grafo, n, nodoInicial, busquedaLocal);
   		case CINCO_VECES_SIN_MEJORAR:
   				maxFrontera = ejecutarVerificandoCincoVecesSinMejorar(grafo, n, nodoInicial, busquedaLocal);
    	}
    	return maxFrontera;
    }

    
    private static int ejecutarVerificandoCantidadDeNodosDividoDiez(boolean[][] grafo, int n, 
    		int nodoInicial, CMFbusquedaLocal busquedaLocal) {
        int maxFrontera = 0;

        int repeticiones = n/10;
        
        if (repeticiones < 1)
        	repeticiones = 1;
        
        for(int j=0;j<repeticiones;j++)
        {

            int frontera =  busquedaLocal.CMFbusquedaLocalAux(grafo, n, nodoInicial);

            if(maxFrontera < frontera)
            {
                maxFrontera = frontera;
            }
            
            nodoInicial = (int) (Math.random() * n);

        }
        return maxFrontera;

    }
    
    private static int ejecutarVerificandoCincoVecesSinMejorar(boolean[][] grafo, int n, 
    		int nodoInicial, CMFbusquedaLocal busquedaLocal) {
        int maxFrontera = 0;

        int cantidadDeVecesSinMejorar = 0;
        
        
        while (cantidadDeVecesSinMejorar < 5) 
        {

            int frontera =  busquedaLocal.CMFbusquedaLocalAux(grafo, n, nodoInicial);

            if(maxFrontera < frontera)
            {
                maxFrontera = frontera;
            } else {
            	cantidadDeVecesSinMejorar++;
            }
            
            nodoInicial = (int) (Math.random() * n);

        }
        return maxFrontera;

    }

    public void setCondicionDeCorteEnIteraciones(CondicionDeCorte condicionDeCorteEnIteraciones) {
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