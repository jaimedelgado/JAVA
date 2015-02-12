/**
 * Clase que representa una continuacion a una etapa. Contiene un texto que representa la continuacion y la etapa a la
 * que refiere. Tiene metodos para modificar y consultar sus atributos.
 */
package modelo;

import interpretePull.InterpretePull;

/**
 * @author Jaime Delgado Linares
 *
 */
public class Continuacion {
	private String texto;
	private Etapa etapa;
	
	//Contructoras
	/**
	 * Constructora sin parametros
	 */
	public Continuacion(){
		this.texto="";
		this.etapa=new Etapa();
	}
	/**
	 * Constructora que inicializa el texto y la etapa
	 * @param t
	 * @param e
	 */
	public Continuacion(String t, Etapa e){
		this.texto=t;
		this.etapa=e;
	}
	
	//Metodos
	/**
	 * Devuelve el texto de la continuacion
	 */
	public String texto(){
		return this.texto;
	}
	/**
	 * Devuelve la etapa de la continuacion
	 * @return
	 */
	public Etapa etapa(){
		return this.etapa;
	}
	/**
	 * toString de una Continuacion
	 */
	public String toString(){
		return this.texto + InterpretePull.LINE_SEPARATOR + this.etapa.toString();
	}
	/**
	 * Pone un texto a la continuacion
	 * @param t - Texto que quieres poner a la continuacion
	 */
	public void setTexto(String t){
		this.texto = t;
	}
	/**
	 * Pone una Etapa a la continuacion
	 * @param e - Etapa de la continuacion
	 */
	public void setEtapa(Etapa e){
		this.etapa = e;
	}

	
}
