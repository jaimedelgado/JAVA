/**
 * La vista que muestra la aplicacion en la salida del sistema. Implementa todas las
 * interfaces de observer con la intencion de ser informada sobre todo evento que 
 * ocurra cuando se esta ejecutando la aplicacion y el robot esta en marcha.
 */
package tp.pr5.console;

import tp.pr5.Direction;
import tp.pr5.Interpreter;
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
public class Console implements InventoryObserver, NavigationObserver, RobotEngineObserver{
	private ConsoleController controlador;
	/**
	 * Crea la vista de la consola inicializando el controlador
	 * @param controlador - Controlador del modelo
	 */
	public Console(ConsoleController controlador) {
		this.controlador = controlador;
		this.controlador.registerEngineObserver(this);
		this.controlador.registerItemContainerObserver(this);
		this.controlador.registerRobotObserver(this);
	}

	/**
	 * Notifica sobre un cambio en el contenedor. No hará nada en esta vista
	 * @param inventory - El nuevo inventario
	 */
	public void inventoryChange(java.util.List<Item> inventory){
		
	}
	
	/**
	 * Notifica que el usuario solicita una instruccion del tipo 'SCAN'
	 * sobre el inventario o contenedor.
	 * @param collectionDescription -  Un string que contiene informacion sobre
	 * el inventario o contenedor
	 */
	public void inventoryScanned(java.lang.String collectionDescription){
		System.out.println(collectionDescription);
		System.out.println();
	}
	
	/**
	 * Notifica que el usuario solicita una instruccion del tipo 'SCAN'
	 * sobre un item que se encuentra en el inventario/contenedor
	 * @param description - String que contiene la descripcion del item
	 */
	public void itemScanned(java.lang.String description){
		System.out.println(Texts.WALLE_SAYS + description);
	}
	
	/**
	 * Informa del cambio de que un item esta vacio (no le quedan mas usos posibles) y que
	 * será borrado del contenedor. A esto le sigue una llamada al metodo InventoryChange.
	 * @param itemName - Nombre sobre el item que está vacio.
	 */
	public void itemEmpty(java.lang.String itemName){
		System.out.println(Texts.AVISO_NO_TENGO +itemName+ ".");
	}

	/**
	 * El motor del robot informa de que el robot se ha apagado (o bien porque haya llegado a la nave espacial
	 * o bien porque se haya quedado sin fuel)
	 * @param win - Booleano que devuelve true si el robot se apaga porque haya llegado a la nave
	 * espacial o false si se apaga porque se haya quedado sin combustible.
	 */
	public void engineOff(boolean win){
		if(win){
			System.out.println(Texts.ERROR_SPACESHIP);
		}else{
			System.out.println(Texts.ERROR_FUEL_EMPTY);
		}
	}

	/**
	 * El motor del robot (robotEngine) informa de que la comunicacion ha terminado.
	 */
	public void communicationCompleted(){
		System.out.println(Texts.ERROR_FUEL_EMPTY);
	}

	/**
	 * El motor del robot informa de la ayuda ha sido solicitada
	 * @param help - Un string que contiene la informacion a comunicar
	 */
	public void communicationHelp(java.lang.String help){
		System.out.println(Interpreter.interpreterHelp());
	}

	/**
	 * El motor del robot informa de que ha llegado un error
	 * @param msg - Un string que contiene el mensaje de error
	 */
	public void raiseError(java.lang.String msg){
		System.out.println(msg);
	}

	/**
	 * El motor del robot informa de que el robot quiere comunicar un mensaje
	 * @param message - Un string que contiene el mensaje que quiere comunicar el robot.
	 */
	public void robotSays(java.lang.String message){
		System.out.print(message);
	}

	
	/**
	 * El motor del robot informa que el fuel y/o la cantidad de material reciclado ha cambiado
	 * @param fuel - Cantidad actual de fuel
	 * @param recycledMaterial - Cantidad actual de material reciclado
	 */
	public void robotUpdate(int fuel, int recycledMaterial){
		System.out.println(Texts.WALLE_FUEL + fuel);
		System.out.println(Texts.WALLE_MATERIAL + recycledMaterial);
	}

	
	/**
	 * Notifica que el modulo de navegacion ha sido iniciado
	 * @param initialPlace - Lugar donde el robot estaba
	 * @param heading - Dirección en la que estaba mirando el robot
	 */
	public void initNavigationModule(PlaceInfo initialPlace, Direction heading){
		this.robotArrivesAtPlace(heading, initialPlace);
		this.headingChanged(heading);
	}

	/**
	 * Notifica que el robot ha llegado a un lugar
	 * @param heading - Direccion a la que quieres que se mueva el robot
	 * @param place - Lugar al que llega el robot
	 */
	public void robotArrivesAtPlace(Direction heading, PlaceInfo place){
		System.out.println(place.toString());
	}

	/**
	 * Notifica que el usuario solicita la instruccion 'RADAR'
	 * @param placeDescription - Lugar del que quieres informar
	 */
	public void placeScanned(PlaceInfo placeDescription){
		//tengo que quitar el nombre del toString() de place y el "The place contains these objects:"
		String tostring = placeDescription.toString();
		String nombre = placeDescription.getName();
		String LINE_SEPARATOR = System.getProperty("line.separator");
		String sobrante = Texts.PLACE_OBJECTS + LINE_SEPARATOR ;
		//Quito nombre del place
		String imprimir = tostring.substring(nombre.length()+2, tostring.length());
		System.out.println(imprimir.replaceFirst(sobrante, ""));
		
	}

	/**
	 * Notifica que el lugar donde estaba el robot, ha cambiado (porque el robot
	 * ha cogido o dejado algun objeto en ese lugar). No hara nada en esta vista
	 * @param placeDescription - Lugar que quieres notificar
	 */
	public void placeHasChanged(PlaceInfo placeDescription){
		
	}

	/**
	 * Notifica que la dirección a la que ha pasado a mirar el robot ha cambiado
	 * @param newHeading - Una nueva direccion a la que quieres que mire
	 */
	public void headingChanged(Direction newHeading){
		System.out.println(Texts.AVISO_ESTA_MIRANDO + newHeading);
	}

	

}
