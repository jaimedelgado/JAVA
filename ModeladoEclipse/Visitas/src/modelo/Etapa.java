/**
 * Clase que representa una Etapa de la visita. Contiene un recurso y un array de continuaciones, así
 * como un entero "numContinuaciones" para saber cuantas continuaciones tiene la etapa.
 * He puesto un máximo de 10 continuaciones que podría cambiarse haciendo que se redimensione de forma dinámica.
 */
package modelo;

import interpretePull.InterpretePull;


/**
 * @author Jaime Delgado Linares
 *
 */
public class Etapa {
	private String html;
	private Recurso recurso;
	private Continuacion[] continuaciones;
	private int numContinuaciones;
	
	//Constructores
	/**
	 * Constructora sin parametros
	 */
	public Etapa(){
		this.recurso = new Recurso();
		this.continuaciones = new Continuacion[10];
		this.numContinuaciones=0;
		this.html = "";
	}
	/**
	 * Constructora que inicializa el recurso, las continuaciones y el documento html
	 * @param rec
	 * @param array
	 * @param num
	 * @param h
	 */
	public Etapa(Recurso rec, Continuacion[] array, int num, String h){
		this.recurso=rec;
		this.continuaciones=array;
		this.numContinuaciones=num;
		this.html = h;
	}
	
	//Metodos
	/**
	 * Devuelve el recurso de la etapa
	 */
	public Recurso recurso(){
		return this.recurso;
	}
	/**
	 * Devuelve las continuaciones de la etapa
	 * @return
	 */
	public Continuacion[] continuaciones(){
		return this.continuaciones;
	}
	/**
	 * Devuelve el numero de continuaciones que hay en la etapa
	 * @return
	 */
	public int numContinuaciones(){
		return this.numContinuaciones;
	}
	/**
	 * Devuelve el nombre del documento html al que esta ligado
	 * @return
	 */
	public String html(){
		return this.html;
	}
	/**
	 * ToString de una etapa
	 */
	public String toString(){
		String s="";
		if(this.numContinuaciones>0){
			s= this.recurso.toString() + InterpretePull.LINE_SEPARATOR;
			for(int i=0; i<this.numContinuaciones; i++){
				s += i+1 + ". " + this.continuaciones[i].texto() + InterpretePull.LINE_SEPARATOR;
			}
			
			s += "Elige una opción:";
		}else{
			s += "Fin de la ejecucion!!";
		}
		return s;
	}
	/**
	 * Le da un recurso a la Etapa
	 * @param rec - Recurso que quieres darle a la etapa
	 */
	public void setRecurso(Recurso rec){
		this.recurso = rec;
	}
	/**
	 * Introduce un array de continuaciones a la etapa
	 * @param c - Array de continuaciones
	 * @param numc - Numero de continuaciones que contiene el array de continuaciones
	 */
	public void setContinuaciones(Continuacion[] c, int numc){
		this.continuaciones = c;
		this.numContinuaciones = numc;
	}
	/**
	 * Introduce el nombre del archivo html
	 * @param h - Nombre del archivo html
	 */
	public void setHtml(String h){
		this.html = h;
	}
	/**
	 * Devuelve true si la etapa tiene continuaciones
	 * @return True si la etapa tiene continuaciones
	 */
	public boolean tieneContinuaciones(){
		return this.numContinuaciones>0;
	}
	/**
	 * Añade la continuacion "c" en el array de continuaciones y actualiza el contador
	 * @param c - Continuacion que quieres añadir a la etapa
	 */
	public void addContinuacion(Continuacion c){
		this.continuaciones[this.numContinuaciones] = c;
		this.numContinuaciones++;
	}
	//Metodos tecnica de los contructores
	/**
	 * Devuelve una Etapa nueva con un recurso, un array de continuaciones, un numContinuaciones y el nombre del archivo html
	 * @param rec - Recurso
	 * @param array - Array de continuaciones
	 * @param num - Numero de continuaciones en el array
	 * @param h - ruta del documento html
	 * @return
	 */
	public Etapa etapa(Recurso rec, Continuacion[] array, int num, String h){
		return new Etapa(rec,array,num,h);
	}
	/**
	 * Devuelve un Recurso con la ruta de la imagen, su descripcion y el archivo html
	 * @param i - String con la ruta de la imagen del recurso
	 * @param d - String con la descripcion de la imagen del recurso
	 * @param h - String con el nombre del archivo html
	 * @return
	 */
	public Recurso recurso(String i, String d, String h){
		return new Recurso(i,d,h);
	}
	/**
	 * Devuelve el mismo array de continuaciones que recibe
	 * @param cs - Array de continuaciones
	 * @return
	 */
	public Continuacion[] continuaciones(Continuacion ... cs ){
		return cs;
	}
	/**
	 * Devuelve una continuacion con su tecto y su Etapa
	 * @param t - texto de la continuacion
	 * @param e - etapa de la continuacion
	 * @return
	 */
	public Continuacion continuacion(String t, Etapa e){
		return new Continuacion(t,e);
	}
}
