/**
 * La basura es un tipo de objeto que genera material reciclado cuando se usa.
 * Puede ser usado sólo una vez, y despues de usarse el objeto se eliminará del contenedor
 * del robot
 */
package tp.pr5.items;

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class Garbage extends Item {
	private int recycledMaterial;

	// CONSTRUCTORS
	/**
	 * Constructor que inicializa todos los atributos de la basura
	 * @param id - Nombre del objeto
	 * @param description - Descripción del objeto
	 * @param recycledMaterial - Material reciclado que aporta al robot
	 */
	public Garbage(String id, String description, int recycledMaterial) {
		super(id, description);
		this.recycledMaterial = recycledMaterial;
	}

	/**
	 *  Comprueba si puede ser usado. Devolverá true si puede ser usado una vez
	 *  y false sino
	 */
	public boolean canBeUsed() {
		boolean ok =false;
		if (this.recycledMaterial > 0) {
			ok = true;
		} 
		return ok;
	}

	/**
	 * Usa el objeto. Añade el material reciclado al robot y devuelve true si ha podido
	 * ser usado corectamente, sino devolverá false
	 */
	public boolean use(RobotEngine r, NavigationModule nav) {
		boolean ok=true;
		if (this.canBeUsed()) {
			r.addRecycledMaterial(this.recycledMaterial);
			this.recycledMaterial = 0;
		} else {
			ok = false;
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
	 * Deshace los efectos que había tenido el objeto sobre el robot y el NavigationModule
	 * No devuelve el material reciclado que habia antes
	 * @param r - Robot en el que se van a rehacer los efectos
	 * @param nav - NavigationModule en el que se van a rehacer los efectos
	 * @return true si se ha podido deshacer los efectos del objeto, false si no
	 */
	@Override
	public boolean unuse(RobotEngine r, NavigationModule nav) {
		boolean ok=true;
		r.addRecycledMaterial(-this.recycledMaterial);
		return ok;
	}
	
	/**
	 * Comprueba si el objeto es un garbage. En este caso siempre devolvera false;
	 */
	@Override
	public boolean esFuel(){
		return false;
	}
	/**
	 * Devuelve la cantidad de energía que le proporcionará al robot. En este caso 0
	 * @return un int con la energía que le proporcionará al robot (0)
	 */
	@Override
	public int energy(){
		return 0;
	}
}
