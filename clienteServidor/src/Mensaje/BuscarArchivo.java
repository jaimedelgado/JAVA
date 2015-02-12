package Mensaje;

import Utilidades.Textos;

public class BuscarArchivo extends Mensaje {
	private String archivo;
	public BuscarArchivo(String origen, String archivo) {
		this.origen=origen; this.destino="destino";
		this.tipo = Textos.BUSCAR_ARCHIVO;
		this.archivo=archivo;
	}
	public String toString() {
		return this.getOrigen() + " " + this.getDestino() + " " + this.getTipo() + " " + this.archivo;
	}

}
