/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

package tp.pr5.items;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import tp.pr5.Observable;


/**
 * Es un contenedor de objetos. Lo usan todas las clases que necesitan guardar objetos, como
 * el robot, o los lugares. Un contenedor no puede guardar dos objetos con el mismo nombre.
 * Contiene metodos para añadir objetos, preguntar por los objetos y borrarlos del contenedor.
 */
public class ItemContainer extends Observable<InventoryObserver>{	
	private List<Item> container;
	// CONSTRUCTORS
	
	/**
	 * Constructor vacio que crea un ArrayList de objetos vacio
	 */
	public ItemContainer() {
		this.container = new ArrayList<Item>();
	}

	// METHODS
	
	/**
	 * Devuelve el número de objetos que tiene el contenedor
	 * @return un int con el número de objetos que contiene el contenedor
	 */
	public int numberOfItems() {
		return this.container.size();
	}
	

	/**
	 * Busca un objeto que tenga el mismo Id, ignorando mayúsculas y minúsculas, que un objeto
	 * que se le pasa por parámetro. Si está no se podrá añadir el objeto, y sino, lo añadirá por orden alfabético.
	 * @param item - Item que quieres añadir
	 * @return true si el objeto puede ser añadido y false sino
	 */
	public boolean addItem(Item item) {
		int i = Collections.binarySearch(this.container, item);
		if(i<0){
			this.container.add(-i-1, item);
			Iterator<InventoryObserver> itera = this.iterator();
			while(itera.hasNext()){
				itera.next().inventoryChange(this.container);
			}
		}
		return i<0;
	}

	/**
	 * Devuelve el objeto del contenedor que tiene el mismo identificador que el String que
	 * se le pasa por parámetro. En caso de que no exista tal objeto en el contenedor, 
	 * devolverá null.
	 * @param id - String con el identificador del objeto a buscar
	 * @return el objeto del contenedor que tiene el mismo identificador que el String que
	 * se le pasa por parámetro o null si tal objeto no existe.
	 */
	public Item getItem(String id) {
		Item it = new Fuel(id, id, 0, 0);
		int pos = Collections.binarySearch(this.container, it);
		if(pos>=0){
			it = this.container.get(pos);
		}else{
			it = null;
		}
		return it;
	}

	/**
	 * Devuelve un objeto del contenedor, y lo borra del mismo, con el mismo identificador que
	 * el String que se le pasa por parámetro. Si el objeto no existiera en el contenedor, 
	 * devolverá null
	 * @param id - String con el objeto que quieres coger
	 * @return el objeto que tenga el mismo identificador que el String que recibe por
	 * parámetro o null si no está.
	 */
	public Item pickItem(String id) {
		Item it = this.getItem(id);
		if(it!=null){
			this.container.remove(it);
			Iterator<InventoryObserver> itera = this.iterator();
			while(itera.hasNext()){
				itera.next().inventoryChange(this.container);
			}
		}
		return it;
	}

	/**
	 * Devuelve un String con la información sobre los objetos que contiene el contenedor.
	 * Los objetos aparecerán ordenados por nombre.
	 */
	public String toString() {
		String text = "";
		String LINE_SEPARATOR = System.getProperty( "line.separator" );
		for (int i = 0; i < this.container.size(); i++) {
			String[] firstWord = this.container.get(i).toString().split(":");
			text = text + "   " + firstWord[0];
			if(i!=this.container.size()-1){
				text=text + LINE_SEPARATOR;
			}
		}
		
		return text;
	}
	
	
	/**
	 * Comprueba si el contenedor tiene un objeto con el mismo identificador que el String
	 * que recibe como parámetro. Devolverá true si lo tiene y false si no.
	 * @param id - String con el objeto que quieres ver si está en el contenedor.
	 * @return true si está en el contenedor y false si no.
	 */
	public boolean containsItem(String id){
		return this.getItem(id)!=null;
	}
	/**
	 * Solicita al observador que muestre la información del contenedor
	 */
	public void requestScanCollection(){
		Iterator<InventoryObserver> it = this.iterator();
		while(it.hasNext()){
			it.next().inventoryScanned(this.toString());
		}
	}
	/**
	 * Solicita a el observador que muestre la información sobre el objeto
	 * @param id - Información que tiene que mostrar
	 */
	public void requestScanItem(String id){
		
		Iterator<InventoryObserver> it = this.iterator();
		while(it.hasNext()){
			it.next().itemScanned(this.toString());
		}
	}
	/**
	 * Método usado por una OperateInstruction cuando un objeto es usado correctamente.
	 * @param item - Objeto que has usado
	 */
	public void useItem(Item item){
		int i = Collections.binarySearch(this.container, item);
		if(i>=0){
			if(!item.canBeUsed()){
				this.container.remove(i);
			}
			Iterator<InventoryObserver> it = this.iterator();
			while(it.hasNext()){
				it.next().inventoryChange(this.container);
			}
		}
	}
	/**
	 * Devuelve un arraylist de string con los nombres de los objetos que contiene el contenedor
	 * @return un arraylist de string con los nombres de los objetos que contiene el contenedor
	 */
	public ArrayList<String> objetos() {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<Item> it = this.container.iterator();
		while(it.hasNext()){
			lista.add(it.next().id);
		}
		return lista;
	}


	
	
	
}
