/**
 * Es una clase enumerada que representa las direcciones a las que puede mirar el robot (North, east, south
 * and west) y una direccion desconocida (UNKNOWN)
 *
 */
package tp.pr5;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public enum Direction {
	NORTH, SOUTH, EAST, WEST, UNKNOWN;

	// METHODS

	/**
	 * @return un array que contiene todas las direcciones en el orden en el que han sido
	 * declaradas
	 */
	public static Direction[] valores() {
		Direction[] direcciones = new Direction[5];
		direcciones[0] = Direction.NORTH;
		direcciones[1] = Direction.SOUTH;
		direcciones[2] = Direction.EAST;
		direcciones[3] = Direction.WEST;
		direcciones[4] = Direction.UNKNOWN;
		return direcciones;
	}

	
	/**
	 * @param name - Nombre de la direccion instroducida por el usuario
	 * @return una direccion con el nombre especificado (Ignora mayusculas y minusculas, y no puede
	 * haber ni espacios ni caracteres no permitidos, en este caso devolverá una direccion
	 * desconocida UNKNOWN)
	 */
	public static Direction valorDe(String name) {
		Direction d = null;
		if (name.equalsIgnoreCase("NORTH"))
			d = Direction.NORTH;
		else if (name.equalsIgnoreCase("SOUTH"))
			d = Direction.SOUTH;
		else if (name.equalsIgnoreCase("EAST"))
			d = Direction.EAST;
		else if (name.equalsIgnoreCase("WEST"))
			d = Direction.WEST;
		else
			d = Direction.UNKNOWN;
		return d;
	}

	
	
	/**
	 * Funcion que devuelve la Direction opuesta de una direccion (EAST-WEST, NORTH-SOUTH)
	 * @return la direccion opuesta de una direccion (EAST-WEST, NORTH-SOUTH)
	 */
	public Direction inverse() {
		Direction d = null;
		if (this == Direction.EAST) {
			d = Direction.WEST;
		} else if (this == Direction.WEST) {
			d = Direction.EAST;
		} else if (this == Direction.NORTH) {
			d = Direction.SOUTH;
		} else if (this == Direction.SOUTH) {
			d = Direction.NORTH;
		} else {
			d = Direction.UNKNOWN;
		}
		return d;
	}

}
