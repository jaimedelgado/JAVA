package Mensaje;

public abstract class Mensaje {
	protected String origen, destino, tipo;
	public abstract String toString();
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public String getTipo(){
		return this.tipo;
	}
}
