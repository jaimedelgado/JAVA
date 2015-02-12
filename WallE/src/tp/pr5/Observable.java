/**
 * Clase que permite almacenar una coleccion de objetos iterables. Va a ser de gran utilidad en la aplicación
 * de Walle para introducir una lista de vistas en el modelo, y así poder avisarlas a todas
 * de que se actualicen.
 */
package tp.pr5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class Observable<T> implements Iterable<T> {
	private Collection<T> collection = new ArrayList<T>();
	@Override
	/**
	 * Devuelve un iterador de la coleccion
	 */
	public Iterator<T> iterator() {
		return collection.iterator();
	}
	/**
	 * Añade un objeto al final de la coleccion
	 * @param vista
	 */
	public void add(T vista){
		collection.add(vista);
	}
	/**
	 * Borra un objeto de la coleccion
	 * @param vista - Objeto que queremos borrar de la coleccion
	 */
	public void remove(T vista){
		collection.remove(vista);
	}
	

}
