package Mensaje;

import Utilidades.Textos;

public class DescargarArchivo extends Mensaje {
	private String archivo;
	public DescargarArchivo(String origen, String archivo) {
		this.origen=origen; this.destino="destino";
		this.tipo = Textos.DESCARGAR_ARCHIVO;
		this.archivo=archivo;
	}
	public String toString() {
		return this.getOrigen() + " " + this.getDestino() + " " + this.getTipo() + " " + this.archivo;
	}
}
