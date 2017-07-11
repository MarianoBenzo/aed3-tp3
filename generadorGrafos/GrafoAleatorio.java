package generadorGrafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoAleatorio implements GeneradorGrafo {
	public String getNombre() {
		return "Aleatorio";
	}

	
	//Genera Grafo Aleatorio
    public boolean[][] generar(int n, int m)
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

}
