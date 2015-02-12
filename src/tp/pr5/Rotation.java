package tp.pr5;
/**
 * Una clase enumerada que representa en que direccion rota el robot(left or right)
 * mas un valor extra que representa una direcciondesconida (unkown)
 * 
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public enum Rotation {
	
	LEFT, RIGHT, UNKNOWN;

	// METHODS

	/**
	 * 
	 * @return un array que contiene todas las direcciones en el orden en el que han sido
	 * declaradas
	 */
	public static Rotation[] valores() {
		Rotation[] rotaciones = new Rotation[3];
		rotaciones[0] = Rotation.LEFT;
		rotaciones[1] = Rotation.RIGHT;
		rotaciones[2] = Rotation.UNKNOWN;
		return rotaciones;
	}

	
	/**
	 * @param name - Nombre de la rotacion instroducida por el usuario
	 * @return una rotacion con el nombre especificado (Ignora mayusculas y minusculas, y no puede
	 * haber ni espacios ni caracteres no permitidos, en este caso devolverá una rotacion
	 * desconocida UNKNOWN)
	 */
	public static Rotation valorDe(String name) {
		Rotation r = null;
		if (name.equalsIgnoreCase("LEFT"))
			r = Rotation.LEFT;
		else if (name.equalsIgnoreCase("RIGHT"))
			r = Rotation.RIGHT;
		else
			r = Rotation.UNKNOWN;
		
		return r;
	}
	
	/*** Funcion que devuelve la Rotation opuesta de una rotacion (LEFT-RIGHT, RIGHT-LEFT)
	 * @return la direccion opuesta de una direccion (LEFT-RIGHT, RIGHT-LEFT)
	 */
	public Rotation inverse() {
		Rotation r = null;
		if (this == Rotation.LEFT) {
			return Rotation.RIGHT;
		} else if (this == Rotation.RIGHT) {
			return Rotation.LEFT;
		}
		return r;
			
	}
	
	/**
	 * Actualiza una direccion segun una Rotation dada. Por ejemplo, si se le pasa una
	 * direccion norte y la rotación es "izquierda", devolverá una direccion oeste.
	 * @param rotation - Rotation que marca hacia donde tiene que rotar el robot
	 * @param direction - Direccion a la que estaba mirando el robot
	 */
	public static Direction rotate(Direction direction, Rotation rotation){
		if (direction == Direction.NORTH) {
			if (rotation == Rotation.LEFT)
				direction = Direction.WEST;
			else if (rotation == Rotation.RIGHT) {
				direction = Direction.EAST;
			}
		}

		else if (direction == Direction.WEST) {
			if (rotation == Rotation.LEFT)
				direction = Direction.SOUTH;
			else if (rotation == Rotation.RIGHT) {
				direction = Direction.NORTH;
			}
		}

		else if (direction == Direction.SOUTH) {
			if (rotation == Rotation.LEFT)
				direction = Direction.EAST;
			else if (rotation == Rotation.RIGHT) {
				direction = Direction.WEST;
			}
		}

		else if (direction == Direction.EAST) {
			if (rotation == Rotation.LEFT)
				direction = Direction.NORTH;
			else if (rotation == Rotation.RIGHT) {
				direction = Direction.SOUTH;
			}
		}
		
		return direction;
	}

}