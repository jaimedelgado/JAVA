/**
 * Es una interfaz que la utilizan los observadores que quieren que se les notifique
 * sobre los eventos relacionados con el modulo de navegacion. Las clases que implementan
 * esta interfaz serán informados cuando el robot cambie su estado en la partida, cuando
 * llegue a un lugar, cuando el lugar se modifique porque se ha dejado un objeto en él,
 * o cuando el usuario utilice el radar
 */
package tp.pr5;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public interface NavigationObserver {
	/**
	 * Notifica la dirección a la que ha pasado a mirar el robot
	 * @param newHeading - Una nueva direccion a la que quieres que mire
	 */
	public void headingChanged(Direction newHeading);
	/**
	 * Notifica que el modulo de navegacion ha sido actualizado
	 * @param initialPlace - Lugar donde el robot estaba
	 * @param heading - Dirección en la que estaba mirando el robot
	 */
	public void initNavigationModule(PlaceInfo initialPlace, Direction heading);
	/**
	 * Notifica que el lugar donde estaba el robot, ha cambiado (porque el robot
	 * ha cogido o dejado algun objeto en ese lugar)
	 * @param placeDescription - Lugar que quieres notificar
	 */
	public void placeHasChanged(PlaceInfo placeDescription);
	/**
	 * Notifica que el usuario ha realizado la instruccion RADAR
	 * @param placeDescription - Lugar del que quieres informar
	 */
	public void placeScanned(PlaceInfo placeDescription);
	/**
	 * Notifica que el robot ha llegado a un lugar
	 * @param heading - Direccion a la que quieres que se mueva el robot
	 * @param place - Lugar donde estaba el robot
	 */
	public void robotArrivesAtPlace(Direction heading, PlaceInfo place);
	
}
