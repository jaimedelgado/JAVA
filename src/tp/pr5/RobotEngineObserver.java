/**
 * Interfaz de los observadores que quieran ser notificados acerca de los acontecimientos
 * ocurridos en el RobotEngine. El robotEngine notificará los cambios en el robot (fuel y 
 * recycledMaterial), informará acerca de los problemas de comunicación, errores, y cuando el robot 
 * quiera decir algo. El robotEngine tambien notificará cuando el usuario solicite ayuda y
 * cuando el robot se apague (Cuando se quede sin fuel o llegue a la nave espacial)
 */
package tp.pr5;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public interface RobotEngineObserver {
	/**
	 * El RobotEngine informa de que la comunicación ha terminado
	 */
	public void communicationCompleted();
	/**
	 * El RobotEngine informa de la instruccion HELP
	 * @param help - String con la información de HELP
	 */
	public void communicationHelp(String help);
	/**
	 * El RobotEngine informa que el robot se ha apagado porque no le queda
	 * combustible o porque ha llegado a la nace espacial
	 * @param atShip - boolean que indica si el robot ha llegado a la nave espacial(true) o
	 * se ha quedado sin fuel (false)
	 */
	public void engineOff(boolean atShip);
	/**
	 * El RobotEngine informa de que ha habido un error
	 * @param msg - String con un mensaje de error del robot
	 */
	public void raiseError(String msg);
	/**
	 * El RobotEngine informa de que el robot quiere decir algo
	 * @param message - String con el mensaje que quiere decir el robot
	 */
	public void robotSays(java.lang.String message);
	/**
	 * El RobotEngine informa de que el fuel o el material reciclado del robot, ha cambiado
	 * @param fuel - int con el fuel que tiene ahora el robot
	 * @param recycledMaterial - int con el material reciclado que tiene ahora el robot
	 */
	public void robotUpdate(int fuel, int recycledMaterial);
}
