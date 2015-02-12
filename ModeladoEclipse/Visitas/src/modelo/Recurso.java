/**
 * Clase que representa un recurso de una etapa. Contiene un String con la ruta de la imágen a la que se refiere y una descripción
 * de dicha imagen. Tiene varios métodos que ayudan a modificar y consultar los atributos del recurso.
 */
package modelo;

import interpretePull.InterpretePull;

/**
 * @author Jaime
 *
 */
public class Recurso {
	private String imagen;
	private String descripcion;
	private String html;
	
	//Constructoras
	/**
	 * Constructora sin argumentos
	 */
	public Recurso(){
		this.imagen="";
		this.descripcion="";
		this.html="";
	}
	/**
	 * Constructora que inicializa la imagen(ruta), su descripcion y el archivo html
	 * @param i - String con la ruta de la imagen del recurso
	 * @param d - String con la descripcion de la imagen del recurso
	 * @param h - String con el nombre del archivo html
	 */
	public Recurso(String i, String d, String h){
		this.imagen=i;
		this.descripcion=d;
		this.html=h;
	}
	
	//Metodos
	/**
	 * Devuelve la imagen del recurso
	 * @return
	 */
	public String imagen(){
		return this.imagen;
	}
	/**
	 * Devuelve la descripcion del recurso
	 * @return
	 */
	public String descripcion(){
		return this.descripcion;
	}
	/**
	 * Devuelve el nombre del archivo html
	 * @return
	 */
	public String html(){
		return this.html;
	}
	/**
	 * toString de un recurso
	 */
	public String toString(){
		return this.imagen + InterpretePull.LINE_SEPARATOR + this.descripcion;
	}
	/**
	 * Pone una imagen al recurso
	 * @param im - Ruta de la imagen que quieres poner
	 */
	public void setImagen(String im){
		this.imagen = im;
	}
	/**
	 * Pone la descripcion al recurso
	 * @param desc - Descripcion de la imagen del recurso
	 */
	public void setDescripcion(String desc){
		this.descripcion = desc;
	}
	/**
	 * Pone el nombre del archivo html
	 * @param h - Nombre del archivo html
	 */
	public void setHtml(String h){
		this.html=h;
	}

}
