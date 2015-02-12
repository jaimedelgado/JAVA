/**
 * Esta clase representa la ciudad donde se encuentra el robot. 
 * Contiene un arrayList de calles, por las cuales se va a mover el robot.
 * Tiene metodos que devuelven la calle a la que esta mirando el robot
 */

package tp.pr5;
import java.util.ArrayList;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

public class City {
	
	private ArrayList<Street> map; // Map

	// CONSTRUCTORS
	
	/**
	 * Constructor por defecto. Crea un ArrayList de calles vacio
	 */
	public City() {
		this.map = new ArrayList<Street>();
	}

	/**
	 * Crea una City con las calles que le pases con el parametro
	 * @param cityMap - Array de calles que quieres que tenga la ciudad
	 */
	public City(Street[] cityMap) {
		this.map = new ArrayList<Street>();
		for (int i = 0; i < cityMap.length; i++) {
			this.map.add(i, cityMap[i]);
		}
	}
	
	/**
	 * Crea una City con las calles que le pases con el parametro
	 * @param cityMap - ArrayList de calles que quieres que tenga la ciudad
	 */
	public City(ArrayList<Street> cityMap){
		this.map = new ArrayList<Street>();
		for (int i = 0; i < cityMap.size(); i++) {
			this.map.add(i, cityMap.get(i));
		}
	}

	// METHODS
	
	/**
	 * Busca la calle que empieza en el lugar y en la direccion dadas.
	 * @param currentPlace
	 * @param currentHeading
	 * @return la Street a la que estas mirando desde un lugar y una direccion
	 * dadas. Devuelve null si no hay ninguna calle en esa direccion desde ese lugar
	 */
	public Street lookForStreet(Place currentPlace, Direction currentHeading) {
		Street street = null;
		boolean found = false;
		int i = 0;
		while (!found && (i < this.map.size())) {
			if (this.map.get(i).comeOutFrom(currentPlace, currentHeading)) {
				street = this.map.get(i);
				found = true;
			}
			i++;
		}
		return street;
	}

	
	/**
	 * Añade una calle dada a la ciudad, en la última posición
	 * @param street -  Calle que quieres que se introduzca en la ciudad
	 */
	public void addStreet(Street street){
		this.map.add(this.map.size(), street);
	}

	
	
	
}
