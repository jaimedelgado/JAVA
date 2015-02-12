package Mensaje;

import Utilidades.Textos;

public class IniciarSesion extends Mensaje {
	private String nombre, contrasenya;
	public IniciarSesion(String origen, String nombre, String c) {
		this.origen=origen; this.destino="destino";
		this.tipo = Textos.INICIAR_SESION;
		this.nombre = nombre;
		this.contrasenya = c;
	}
	public String toString() {
		return this.getOrigen() + " " + this.getDestino() + " " + this.getTipo() + " " 
										+ this.nombre + " " + this.contrasenya;
	}

}
