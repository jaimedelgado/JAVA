/**
 * Es una interfaz que no se puede modificar y que van a utilizar los lugares.
 * Esta interfaz la utilizan las clases que necesitan acceder a la información 
 * contenida en el sitio, pero que no modifican el lugar en sí
 */
package tp.pr5;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public interface PlaceInfo {
	/**
	 * Devuelve un String con la descripción del lugar
	 * @return un String con la descripción del lugar
	 */
	public String getDescription();
	/**
	 * Devuelve un String con el nombre del lugar
	 * @return un String con el nombre del lugar
	 */
	public String getName();
	/**
	 * Devuelve true si el lugar es una nave espacial, y false en caso contrario
	 * @return si es una nave espacial o no (true o false)
	 */
	public boolean isSpaceship();
}
