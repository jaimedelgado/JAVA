/**
 * Superclase de cualquier tipo de objeto.
 * Contiene información común a todos los objetos (Nombre del objeto y su descripcion)
 *  y es la interfaz que tienen que usar todos los objetos.
 */
package tp.pr5.items;

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public abstract class Item implements Comparable<Item>{
	protected String id;
	protected String description;

	// CONSTRUCTORS
	/**
	 * Constructor que inicializa el nombre y la descripción del objeto.
	 * @param id - nombre del objeto
	 * @param description - descripción del objeto
	 */
	public Item(String id, String description) {
		this.id = id;
		this.description = description;
	}

	// METHODS
	/**
	 * Devolverá si el objeto puede ser usado o no. Dependerá de que tipo de objeto sea.
	 * @return true si puede ser usado y false sino
	 */
	public abstract boolean canBeUsed();

	/**
	 * Usa el objeto (Dependerá de que tipo de objeto sea) y devuelve si ha podido ser usado.
	 * @param r - Robot
	 * @param nav - Modulo de navegación
	 * @return true si ha podido ser usado y false si no
	 */
	public abstract boolean use(RobotEngine r, NavigationModule nav);
	
	/**
	 * Devuelve un String con el nombre del objeto
	 * @return el nombre del objeto
	 */
	public String getId() {
		return this.id;
	}
	public String getDescription(){
		return this.description;
	}

	/**
	 * Devuelve un String con la descripción del objeto
	 */
	@Override
	public String toString() {
		return this.id + ": " + this.description;
	}
	/**
	 * Devuelve el hashcode del id del objeto en minusculas
	 */
	@Override
	public int hashCode(){
		return this.id.toLowerCase().hashCode(); 
	}
	/**
	 * Compreba si dos items son iguales
	 */
	@Override
	public boolean equals(Object obj){
		//return this.id.hashCode() == ((Item)obj).hashCode();
		return this.id.equalsIgnoreCase(((Item)obj).id);
		
	}
	/**
	 * Devuelve un entero que indica si dos objetos son iguales. Cero indica que si
	 * @param  o - objeto con el que quieres comparar
	 */
	@Override
	public int compareTo(Item o) {
		//return o.hashCode()-this.hashCode();
		return this.id.compareToIgnoreCase(o.id);	
	}
	/**
	 * Deshace los efectos que había tenido antes este objeto sobre el robot y sobre el NavigationModule
	 * @param r
	 * @param nav
	 * @return
	 */
	public boolean unuse(RobotEngine r, NavigationModule nav){
		return true;
	}
	/**
	 * Comprueba si el objeto es un fuel. Este método tiene que reimplementarlo todas las clases que 
	 * hereden de la clase Item. No es abstracta porque fallarían los test del profesor.
	 * @return true si es un fuel y false si no
	 */
	public boolean esFuel(){
		return false;
	}
	/**
	 * Devuelve la energía que le dará al robot. Este método tiene que reimplementarlo todas las clases que 
	 * hereden de la clase Item. No es abstracta porque fallarían los test del profesor
	 * @return un entero indicando la energía que le proporcionará al robot
	 */
	public int energy(){
		return 0;
	}
}
