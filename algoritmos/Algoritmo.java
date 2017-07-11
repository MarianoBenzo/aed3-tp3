package algoritmos;

public interface Algoritmo {
	
	public String getNombre();
	public int ejecutar(boolean[][] grafo, int n);
	public void setIncio(Inicio inicio);
}
