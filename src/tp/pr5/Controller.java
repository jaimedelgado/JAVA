/**
 * Define la funcionalidad básica común a los dos controladores, contiene el modelo y funciones
 * para introducir los observadores.
 */
package tp.pr5;

import tp.pr5.items.InventoryObserver;

/**
 * 
 * @authors Jaime Delgado Linares y JuanSamper González
 *
 */
public abstract class Controller {
	protected RobotEngine robot;
	
	/**
	 * Constructor que inicializa el modelo
	 * @param r - RobotEngine que va a ser el modelo
	 */
	public Controller(RobotEngine r){
		robot = r;
	}
	
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del modulo de navegacion del modelo
	 */
	public abstract void registerEngineObserver(NavigationObserver observer);
	
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del inventario del robot
	 */
	public abstract void registerItemContainerObserver(InventoryObserver observer);
	
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del robot
	 */
	public abstract void registerRobotObserver(RobotEngineObserver observer);
	
	/**
	 * El controlador comienza a tratar eventos
	 */
	public abstract void startController();
}
