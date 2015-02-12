/**
 * Clase que representa una tarjeta.
 * Contiene un código, y puede ser usado para abrir y cerrar calles.
 * Es un objeto que siempre puede ser usado, aunque no coincida el código y no haga nada,
 * y no se eliminará del inventario del robot tras ser usada.
 */
package tp.pr5.items;

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.Street;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 */
public class CodeCard extends Item {
	private String code;

	/**
	 * Constructor con tres argumentos (La Id de la tarjeta, su descripción y su código)
	 * @param id
	 * @param description
	 * @param code
	 */
	public CodeCard(String id, String description, String code) {
		super(id, description);
		this.code = code;
	}

	// METHODS
	
	/**
	 * Una tarjeta siempre puede ser usada y no se eliminadá nunca del inventario del robot
	 */
	public boolean canBeUsed() {
		return true;
	}

	
	/**
	 * Este método usa una tarjeta. Si el robot esta en un lugar, mirando hacia una calle,
	 * y los códigos de la tarjeta y de la calle coinciden, se abrirá o cerrará.
	 * Además, devolverá true si el codigo de la tarjeta coincide con el de la calle, y false
	 * en caso contrario.
	 */
	public boolean use(RobotEngine r, NavigationModule nav) {
		boolean ok = false;
		Street street = nav.getHeadingStreet();
		if (street != null) {
			if (street.isOpen()) {
				if(street.close(this)){
					ok=true;
				}
			
			} else{
				if(street.open(this)){
					ok = true;
				}
			}
		}
		return ok;
	}

	
	/** Devuelve el código de la tarjeta
	 * @return un String con el código de la tarjeta
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Deshace la acción que ha hecho antes. Si había abierto una puerta, la cierra y viceversa.
	 * @param r - Robot en el que se va a aplicar la accion
	 * @param nav - NavigationModule donde se va a aplicar la accion
	 * @return true si ha podido usarse y false si no
	 */
	@Override
	public boolean unuse(RobotEngine r, NavigationModule nav) {
		return use(r,nav);
	}
	/**
	 * Comprueba si el objeto es un fuel. en este caso siempre devolverá false
	 */
	@Override
	public boolean esFuel(){
		return false;
	}
	
	/**
	 * Devuelve la energía que le proporcionará al robot. En este caso 0
	 * @return un int con la energía que le proporcionará al robot (0)
	 */
	@Override
	public int energy(){
		return 0;
	}

}
