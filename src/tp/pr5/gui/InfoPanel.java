/**
 * Es la clase encargada de controlar la parte inferior de la ventana gráfica, donde se muestran
 * mensajes sobre los eventos que se producen durante la simulación. Este panel implementa
 * todas las interfaces de observación con el fin de ser notificados acerca de todos los
 * eventos ocurridos
 */
package tp.pr5.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr5.Direction;
import tp.pr5.NavigationObserver;
import tp.pr5.PlaceInfo;
import tp.pr5.RobotEngineObserver;
import tp.pr5.items.InventoryObserver;
import tp.pr5.items.Item;
import tp.pr5.utilidades.Texts;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
@SuppressWarnings("serial")
public class InfoPanel extends JPanel implements NavigationObserver,RobotEngineObserver,InventoryObserver{
	private JLabel texto;
	/**
	 * Constructora que inicializa el info panel con una referencia al controlador de la GUI
	 * @param controller - controlador de la GUI
	 */
	public InfoPanel(GUIController controller){
		controller.registerEngineObserver(this);
		controller.registerItemContainerObserver(this);
		controller.registerRobotObserver(this);
		inicializa();
	}
	/**
	 * Inicializa los elementos del panel. Se trata de un JLabel que mmostrará la información de
	 * las acciones que haya hecho el robot
	 */
	private void inicializa() {
		this.setSize(3*320, 340);
		this.texto = new JLabel();
		this.add(this.texto);
		
	}
	/**
	 * Notifica la dirección a la que ha pasado a mirar el robot
	 * @param newHeading - Una nueva direccion a la que quieres que mire
	 */
	public void headingChanged(Direction newHeading) {
		this.texto.setText(Texts.AVISO_ESTA_MIRANDO + newHeading);
	}
	/**
	 * Notifica que el modulo de navegacion ha sido actualizado. Por el info panel no saldrá
	 * nada en este caso.
	 * @param initialPlace - Lugar donde el robot estaba
	 * @param heading - Dirección en la que estaba mirando el robot
	 */
	public void initNavigationModule(PlaceInfo initialPlace, Direction heading) {
		
	}
	/**
	 * Notifica que el lugar donde estaba el robot, ha cambiado (porque el robot
	 * ha cogido o dejado algun objeto en ese lugar). En este caso no se mostrará información por
	 * el panel.
	 * @param placeDescription - Lugar que quieres notificar
	 */
	public void placeHasChanged(PlaceInfo placeDescription) {
		
	}
	/**
	 * Notifica que el usuario ha realizado la instruccion RADAR. En este caso no saldrá nada por el panel.
	 * @param placeDescription - Lugar del que quieres informar
	 */
	public void placeScanned(PlaceInfo placeDescription) {
		
	}
	/**
	 * Notifica que el robot ha llegado a un lugar. En este caso no saldrá nada por el panel.
	 * @param heading - Direccion a la que quieres que se mueva el robot
	 * @param place - Lugar donde estaba el robot
	 */
	public void robotArrivesAtPlace(Direction heading, PlaceInfo place) {
		
	}
	/**
	 * El RobotEngine informa de que la comunicación ha terminado
	 */
	public void communicationCompleted() {
		this.texto.setText(Texts.ERROR_FUEL_EMPTY);
	}
	/**
	 * El RobotEngine informa de la instruccion HELP. En este caso no mostrará nada en el panel
	 * @param help - String con la información de HELP
	 */
	public void communicationHelp(String help) {
		
	}
	/**
	 * El RobotEngine informa que el robot se ha apagado porque no le queda
	 * combustible o porque ha llegado a la nace espacial
	 * @param atShip - boolean que indica si el robot ha llegado a la nave espacial o se ha quedado sin fuel
	 */
	public void engineOff(boolean atShip) {
		if(atShip){
			this.texto.setText(Texts.ERROR_SPACESHIP);
		}else{
			this.texto.setText(Texts.ERROR_FUEL_EMPTY);
		}
	}
	/**
	 * Informa de que ha habido un error por el panel
	 * @param msg - String con un mensaje de error del robot
	 */
	public void raiseError(String msg) {
		this.texto.setText(msg);
	}
	/**
	 * Informa de que el robot quiere decir algo por el panel
	 * @param message - String con el mensaje que quiere decir el robot
	 */
	public void robotSays(java.lang.String message) {
		this.texto.setText(message);
	}
	/**
	 * El RobotEngine informa de que el fuel o el material reciclado del robot, ha cambiado
	 * @param fuel - int con el fuel que tiene ahora el robot
	 * @param recycledMaterial - int con el material reciclado que tiene ahora el robot
	 */
	public void robotUpdate(int fuel, int recycledMaterial) {
		this.texto.setText(Texts.WALLE_ATTRIBUTES + ": (" + fuel + ", " + recycledMaterial + ")");
	}
	

	/**
	 * Notifica que el contenedor ha cambiado. No mostrará nada en el panel
	 * @param inventory - El nuevo inventario
	 */
	public void inventoryChange(java.util.List<Item> inventory) {
		
	}
	
	/**
	 * Notifica que el usuario solicita una instruccion 'SCAN' sobre el contenedor. No mostrará la 
	 * información en el panel
	 * @param inventoryDescription - Proporciona información sobre el inventario (contenedor de objetos)
	 */
	public void inventoryScanned(java.lang.String inventoryDescription) {
	}
	
	/**
	 * Notifica que el usuario quiere realizar una accion 'SCAN' sobre un item
	 * almacenado en el contenedor. No mostrará nada por el panel
	 * @param description - Es la descripcion sobre el item que se busca o scannea
	 */
	public void itemScanned(java.lang.String description){
		
	}
	
	/**
	 * Informa del cambio de que un item esta vacio (no le quedan mas usos posibles) 
	 * @param itemName - Nombre sobre el item que está vacio.
	 */
	public void itemEmpty(java.lang.String itemName) {
		this.texto.setText(Texts.AVISO_NO_TENGO+itemName+".");
	}

}
