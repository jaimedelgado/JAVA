/**
 * Representa un lugar (place) en la ciudad. Los lugares (places) están
 * conectados por calles (streets) de acuerdo a los cuatro puntos cardinales:
 * Norte, Sur, Este y Oestre. Todo lugar (place) tiene un nombre y una descripción
 * textual. Esta descripción se muestra cuando el robot llega a dicho lugar (place).
 * Un lugar (place) puede representar la nave espacial (spaceship), donde el robot
 * está seguro. Cuando el robot llega a éste lugar, se apaga y la aplicacíon termina.
 */

package tp.pr5;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import java.util.ArrayList;

import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;

public class Place implements PlaceInfo{
	private String name;
	private boolean isSpaceShip;
	private String description;
	private ItemContainer itemContainer;
	private boolean visitado;
	
	// CONSTRUCTORS
	
	
	/**
	 * Constructor con tres parámetros que incializa los atributos.
	 * @param name Un string que aporta el nombre del lugar. 
	 * @param isSpaceShip Un boolenao indica si ese lugar es una nave donde el robot pueda descansar
	 * @param description un string que es el texto que describe el lugar
	 */
	public Place(String name, boolean isSpaceShip, String description) {
		this.name = name;
		this.isSpaceShip = isSpaceShip;
		String[] s = description.split("_");
		String text = "";
		for(int i=0; i<s.length; i++){
			text=text+s[i];
			if(i!=s.length-1){
				text = text + " ";
			}
		}
		this.description = text;
		
		this.itemContainer = new ItemContainer();
		this.visitado = false;
	}

	// METHODS
	
	/**
	 * Devuleve el nombre del lugar en un String
	 * @return this.name, un string que es el nombre del lugar
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Devuleve la descripcion del lugar en un String
	 * @return this.description, un string que es la descripcion del lugar
	 */
	public String getDescription(){
		return this.description;		
	}
	
	
	/**
	 * Un metodo que a traves de un booleano indica si el lugar en el que esta
	 * el robot tiene o no nave espacial
	 * @return true si el lugar es la nave espacial (isSpaceShip)
	 */
	public boolean isSpaceship() {
		return this.isSpaceShip;
	}

	/**
	 * Ignora el metodo toString y lo implementa de nuevo
	 * @return un string que contiene el nombre del lugar, una descripcion de este
	 * y una lista de los objetos contenidos en dicho lugar.
	 */
	public String toString() {
		String LINE_SEPARATOR = System.getProperty( "line.separator" );
		//return this.name + LINE_SEPARATOR + this.description ;
		String texto= this.name + LINE_SEPARATOR + this.description + LINE_SEPARATOR;
		if (this.itemContainer.numberOfItems() == 0) {
			texto += "The place is empty. There are no objects to pick"+ LINE_SEPARATOR;
		} else {
			texto += "The place contains these objects:" + LINE_SEPARATOR +
					this.itemContainer.toString() + LINE_SEPARATOR;
		}
		return texto;
	}
	
	/**
	 * Intenta coger un objeto caracterizado por un id (string) dado en un lugar
	 * concreto. Si la acción se puede completar, el objeto se tiene que quitrar
	 * del sitio o lugar (place) en el que se encuentre.
	 * @param id String que sirve para identificar y buscar un objeto con ese id.
	 * @return el contenedor de objetos actualizado
	 */
	public Item pickItem(String id) {
		return this.itemContainer.pickItem(id);
	}

	/**
	 * Añade un objeto a la lista de objetos de un lugar. La operación puede
	 * fallar si en el lugar ya existe un item con el mismo nombre, en cuyo caso,
	 * no se insertará.
	 * @param it Un item para ser insertado.
	 * @return true si y solo si el item puede ser añadido al lugar, i.e.,que el lugar no
	 * contenga un objeto con ese nombre.
	 */
	public boolean addItem(Item it) {
		return this.itemContainer.addItem(it);
	}

	
	/**
	 * Comprueba si existe un item con un cierto nombre en cierto lugar.
	 * @param id Un string que representa el nombre del objeto a buscar
	 * @return false si el item con el identificador id no existe en ese lugar. Devuelve verdadero
	 * en cualquier otro caso.
	 */
	public boolean existItem(String id){
		return this.itemContainer.containsItem(id);
	}
	
	
	
	/**
	 * Suelta un objeto (item) en un lugar
	 * @param it Un item que va a ser soltado en este lugar
	 * @return true Si y solo si se ha conseguido soltar el objeto en ese lugar, por ejemplo, un objeto
	 * con el mismo identificador no existe en el lugar
	 */
	public boolean dropItem(Item it){
		boolean ok = true;
		if(this.existItem(it.getId())){
			ok = false;
		}else{
			this.itemContainer.addItem(it);
			ok = true;
		}
		return ok;
	}
	
	/**
	 * Devuelve un arraylist de string con los objetos que tiene el lugar. Es de gran utilidad
	 * para buscar que objetos nos pueden servir del lugar cuando el robot haga la busqueda 
	 * automática de la salida.
	 * @return Arraylist<String> con los objetos del lugar
	 */
	public ArrayList<String> objetos(){
		return this.itemContainer.objetos();
	}
	/**
	 * Comprueba si el lugar ha sido visitado alguna vez. Es de gran utilidad
	 * para buscar que objetos nos pueden servir del lugar cuando el robot haga la busqueda 
	 * automática de la salida.
	 * @return
	 */
	public boolean estaVisitado() {
		return this.visitado;
	}
	/**
	 * Marca el lugar como visitado. Es de gran utilidad
	 * para buscar que objetos nos pueden servir del lugar cuando el robot haga la busqueda 
	 * automática de la salida.
	 * @param v
	 */
	public void visita(boolean v) {
		this.visitado = v;
	}
	
	
}
