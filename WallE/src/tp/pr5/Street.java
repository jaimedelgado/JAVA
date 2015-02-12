/**
 * Una calle (street) une dos lugares (places) A y B. Todas las calles (street)
 * tienen dos sentidos. Si una calle (street) esta definida como Calle(A, NORTE, B)
 * significa que el lugar (place) B esta al NORTE del lugar (place) A, que el lugar A
 * esta al SUR del lugar B.
 */

package tp.pr5;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import tp.pr5.items.CodeCard;

public class Street {
	
	private Place source;
	private Direction direction;
	private Place target;
	private boolean open; // 1 open
	private String code;

	// CONSTRUCTORS

	/**
	 * Constructora con tres parametros que inicializa todos los atributos.
	 * Por defecto inicializa la calle abierta y sin un codigo (un codigo/cadena vacia)
	 * @param source - Punto inicial de la calle
	 * @param direction - Direccion en la cual estan comunicadas/unidas el lugar SOURCE y el lugar TARGET
	 * @param target - Punto destino de la calle
	 */
	public Street(Place source, Direction direction, Place target) {
		this.source = source;
		this.direction = direction;
		this.target = target;
		this.open = true;
		this.code = "";
	}
	

	/**
	 * Crea una calle, la cual necesita de un codigo tanto para abrirse como
	 * para cerrarse. En este caso, la calle se puede crear abierta o cerrada y
	 * será necesario un codigo (que no podrá ser una cadena vacia).
	 * @param source - Punto inicial de la calle
	 * @param direction - Direccion en la cual estan comunicadas/unidas el lugar SOURCE y el lugar TARGET
	 * @param target - Punto destino de la calle
	 * @param isOpen - booleano que indica si una calle está abierta o cerrada
	 * @param code - codigo que tiene la calle. Para operar con esta puerta (tanto abrirla como cerrarla) será necesario que el codgio que se introduzca coincida con éste.
	 */
	public Street(Place source, Direction direction, Place target, boolean isOpen, String code) {
		this.source = source;
		this.direction = direction;
		this.target = target;
		this.open = isOpen;
		this.code = code;
	}

	// METHODS
	
	/**
	 * Comprueba si de un lugar (place) sale una calle (street) en una direccion dada.
	 * Hay que recordar que las calles tienen dos direcciones.
	 * @param place - lugar en el que se va a comprobar si sale una calle
	 * @param whichDirection - Direccion en la que sale la calle del luagr
	 * @return true si sale una calle del lugar concreto
	 */
	public boolean comeOutFrom(Place place, Direction whichDirection) {
		boolean ok=false;
		if ((this.source == place) && (this.direction == whichDirection)) {
			ok = true;
		} else if ((this.target == place)
				&& (this.direction == whichDirection.inverse())) {
			ok = true;
		} 
		return ok;

	}
	
	/**
	 * Devuelve el lugar (place) al otro lado de la calle. Comprobariamos
	 * si es el inicio o el destino de la calle. Devuelve 'NULL' si el lugar
	 * que me dan 'whereAmI' no pertenece a la calle.
	 * @param whereAmI - Lugar que queremos comprobar si esta al otro lado de la calle
	 * @return  Devuelve el lugar del otro lado al lugar en el que estamos
	 */	
	public Place nextPlace(Place whereAmI) {
		Place p = null;
		if (whereAmI == this.source) {
			p = this.target;
		} else if (whereAmI == this.target) {
			p = this.source;
		}
		return p;
	}

	/**
	 * Comprueba si la calle esta abierta o cerrada.
	 * @return true si la calle esta abierta
	 */
	public boolean isOpen() {
		return this.open;
	}

	/**
	 * Intenta abrir una calle usando un objeto 'codecard'. Los
	 * codigos deben coincidir para que esta operacion se pueda completar.
	 * @param card - Este item tiene un codigo que debe coincidir con el codigo que tiene la calle para que pueda ser abierta
	 * @return true si el codigo de la codecard coincide con el codigo de la calle
	 */
	public boolean open(CodeCard card) {
		boolean ok = false;
		if (this.code.equals(card.getCode())) {
			if (!this.open) {
				this.open(true);
			}
			ok = true;
		} 
		return ok;
	}

	
	/**
	 * Intenta cerrar una calle usando un codigo de un item codecard. Los
	 * codigos deben coincidir para que esta operacion se pueda completar.
	 * @param card - Este item tiene un codigo que debe coincidir con el codigo que tiene la calle para que pueda ser cerrada
	 * @return true si el codigo de la codecard coincide con el codigo de la calle
	 */
	public boolean close(CodeCard card) {
		boolean ok = false;
		if (this.code.equals(card.getCode())) {
			if (this.open) {
				this.open(false);
			}
			ok = true;
		} 
		return ok;
	}

	/**
	 * Funcion que cambia el indicador sobre el estado de una calle
	 * @param open - Booleano de entrada, cuyo valor va a determinar si la calle va a pasar a estar abierta o cerrada
	 */
	public void open(boolean open) {
		this.open = open;
	}


	
}
