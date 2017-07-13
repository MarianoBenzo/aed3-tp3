package algoritmos;

public interface Algoritmo {
	
	public String getNombre();
	public int ejecutar(boolean[][] grafo);
	public void setIncio(Inicio inicio);
	public void setCondicionDeCorteEnIteraciones(CondicionDeCorteEnIteraciones condicionDeCorteEnIteraciones);
}

