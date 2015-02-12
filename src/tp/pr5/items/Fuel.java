/**
 * Un objeto que representa un combustible.
 * Puede ser usado tantas veces como indique su atributo times, y da al robot tanta energia como
 * indique su atributo power. Cuando ya no se puede usar más veces, se borra del contenedor
 * del robot.
 */

package tp.pr5.items;

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

public class Fuel extends Item {
	private int power;
	private int times;

	// CONSTRUCTORS
	/**
	 * Constructor que inicializa todos los atributos del combustible
	 * @param id - Nombre del objeto
	 * @param description - Descripción del objeto
	 * @param power - Combustible que aporta el objeto en total
	 * @param times - Veces que puede ser usado
	 */
	public Fuel(String id, String description, int power, int times) {
		super(id, description);
		this.power = power;
		this.times = times;
	}

	
	/**
	 * Indica si el combustible puede ser usado. Podrá ser usado si times>0 y entonces
	 * devolverá true, sino false.
	 */
	public boolean canBeUsed() {
		boolean ok = true;
		if (this.times == 0) {
			ok = false;
		} 
		return ok;
	}

	
	/**
	 * Usa el combustible. Si puede ser usado añadirá el combustible al robot y devolverá true, 
	 * sino devolverá false
	 */
	public boolean use(RobotEngine r, NavigationModule nav) {
		boolean ok = false;
		if (this.canBeUsed()) {
			r.addFuel(this.power);
			this.times--;
			ok = true;
		} 
		return ok;
	}

	/**
	 * Devuelve un String con la descripción del objeto
	 */
	public String toString() {
		return super.toString(); 
	}

	/**
	 * Deshace los efectos que había tenido antes este objeto sobre el robot y sobre el NavigationModule
	 * @param r
	 * @param nav
	 * @return
	 */
	@Override
	public boolean unuse(RobotEngine r, NavigationModule nav) {
		boolean ok = false;
		
		r.addFuel(-this.power);
		this.times++;
		ok = true;
	
		return ok;
	}

	/**
	 * Comprueba si el objeto es un fuel. En este caso siempre devolverá true
	 */
	@Override
	public boolean esFuel(){
		return true;
	}

	/**
	 * Devuelve la energía que le proporcionará al robot
	 * @return un int con la energía que le proporcionará al robot
	 */
	@Override
	public int energy(){
		return this.power;
	}
}
