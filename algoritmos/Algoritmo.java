package algoritmos;

public interface Algoritmo {
	
	public String getNombre();
	public int ejecutar(boolean[][] grafo);
	public void setInicio(Inicio inicio);
	public void setCondicionDeCorteEnIteraciones(CondicionDeCorte condicionDeCorteEnIteraciones);
}
