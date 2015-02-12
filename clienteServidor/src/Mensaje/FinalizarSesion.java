package Mensaje;

import Utilidades.Textos;

public class FinalizarSesion extends Mensaje{

	public FinalizarSesion(String origen) {
		this.origen=origen; this.destino="destino";
		this.tipo = Textos.FINALIZAR_SESION;
	}
	public String toString() {
		return this.getOrigen() + " " + this.getDestino() + " " + this.getTipo();
	}
}
