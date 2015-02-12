/**
 * Esta clase representa el motor del robot (robot engine). Controla los movimientos
 * procesando las instrucciones introducidas desde el teclado. El motor para cuando
 * el robot llega a la nave, se queda sin fuel o recibe una instruccion de acabar (quit).
 * El motor del robot (robot engine) tambien es responsable de actualizar el nivel de
 * fuel y de material reciclado acorde a las acciones que el robot lleve a cabo en la
 * ciudad. El motor del robot (robot engine) tambien contiene un inventario donde el
 * robot almacena los objetos (items) que recoge de la ciudad.
 * También tiene una función para encontrar la salida automáticamente (buscaSalida(profundidad))
 * que permite realizar la parte opcional de la práctica.
 */
package tp.pr5;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp.pr5.instructions.Instruction;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.InventoryObserver;
import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;

public class RobotEngine extends Observable<RobotEngineObserver> {
	private NavigationModule navigation;
	private int energy;
	private int recycledMaterial;
	private ItemContainer itemContainer;
	
	private List<Instruction> instrucciones;
	
	private static Direction dirInicial = Direction.NORTH;
	// CONSTRUCTORS
	
	/**
	 * Crea el Robotengine en un lugar inicial, mirando a una direccion inicial y con un mapa de la ciudad
	 * @param cityMap - El mapa de la ciudad sobre el que el robot se movera
	 * @param initialPlace - Lugar (place) inicial en el que empieza el robot
	 * @param direction - Direccion a la que mira el robot al empezar la partida
	 */
	public RobotEngine(City cityMap, Place initialPlace, Direction direction) {
		this.navigation = new NavigationModule(cityMap, initialPlace);
		this.navigation.initHeading(direction);
		this.energy = 100;
		this.recycledMaterial = 0;
		this.itemContainer = new ItemContainer();
		this.instrucciones = new ArrayList<Instruction>();
	
	}
	
	//Methods
	/**
	 * Añade una cantida de fuel al robot (puede ser negativa)
	 * @param fuel - Un entero que será la cantida de fuel a añadir al robot
	 */
	public void addFuel(int fuel) {
		this.energy += fuel;
		if(this.energy<0){
			this.energy = 0;
		}
		Iterator<RobotEngineObserver> it2 = this.iterator();
		while(it2.hasNext()){
			it2.next().robotUpdate(this.energy, this.recycledMaterial);
		}
	}
	
	/**
	 * Aumneta la cantidad de material reciclado del robot.
	 * @param weight - cantidad a añadir de material reciclado.
	 */
	public void addRecycledMaterial(int weight) {
		this.recycledMaterial += weight;
		Iterator<RobotEngineObserver> it2 = this.iterator();
		while(it2.hasNext()){
			it2.next().robotUpdate(this.energy, this.recycledMaterial);
		}
	}
	
	/**
	 * Devuelve el valor actual de fuel del robot. Este metodo es necesario para propositos del test.
	 * @return El valor actual de fuel del robrot.
	 */
	public int getFuel() {
		return this.energy;
	}
	
	/**
	 * Devueleve el peso actual de material reciclado que transporta el robot. Este metodo es necesario para propositos del test.
	 * @return El peso actual de material reciclado que transporta el robot.
	 */
	public int getRecycledMaterial() {
		return this.recycledMaterial;
	}
	
	/**
	 * Ejecuta una instruccion. La instruccion debe ser configurada con el contexto antes de ser ejecutada.
	 * Controla el final de la simulacion. Si la ejecucion de la instruccion lanza una excepcion, entonces el mensaje
	 * correspondiente se muestra por pantalla.
	 * También añade la instruccion a un array de instrucciones del robot para poder hacer luego el undo
	 * de todas las instrucciones
	 * @param c - La instruccion que será ejecutada.
	 */
	public void communicateRobot(Instruction c){
		try {
			c.configureContext(this, this.navigation, this.itemContainer);
			c.execute();
			
			this.instrucciones.add(this.instrucciones.size(), c);

		} catch (InstructionExecutionException e) {
			
		}
	}
	/**
	 * 
	 * @param c
	 */
	public void deshaceInstruccion(){
		if(!this.instrucciones.isEmpty()){
			Instruction c = this.instrucciones.get(this.instrucciones.size()-1);
			c.configureContext(this, this.navigation, this.itemContainer);
			c.undo();
			this.instrucciones.remove(this.instrucciones.size()-1);
		}
	}
	/**
	 * Solicita el final de la aplicacion
	 */
	public void requestQuit(){ 
		Iterator<RobotEngineObserver> it = this.iterator();
		while(it.hasNext()){
			it.next().engineOff(this.energy!=0);
		}
		System.exit(0);
	}
	
	/**
	 * Muestra por pantalla la informacion sobre todas las posibles instrucciones
	 */
	public void requestHelp(){ 
		ArrayList<Instruction> array = Interpreter.instructions();
		Iterator<Instruction> itIns = array.iterator();
		Iterator<RobotEngineObserver> itRobot = iterator();
		String LINE_SEPARATOR = System.getProperty("line.separator");
		while(itRobot.hasNext()){
			RobotEngineObserver obs = itRobot.next();
			while(itIns.hasNext()){
				obs.robotSays(itIns.next().getHelp() + LINE_SEPARATOR);
			}
			obs.robotSays(LINE_SEPARATOR);
		}
	
	}
	
	/**
	 * Añade un observador del robot (RobotEngineObserver) al modelo.
	 * @param observer - El observador que queremos que registre los cambios
	 */
	public void addEngineObserver(RobotEngineObserver observer){
		this.add(observer);

	}
	
	/**
	 * Registra un observador de contenedor de objetos (InventoryObserver) al modelo.
	 * @param observer - El observador que queremos que registre los cambios
	 */
	public void addItemContainerObserver(InventoryObserver observer){
		this.itemContainer.add(observer);
	}
	
	/**
	 * Registra un observador de Navegacion (NavigationObserver) al modelo.
	 * @param robotObserver - El observador que queremos que registre los cambios
	 */
	public void addNavigationObserver(NavigationObserver robotObserver){
		this.navigation.add(robotObserver);
	}
	
	/**
	 * Comprueba si la simulacion ha termindado porque el robot se ha quedado sin fuel
	 * o porque ha llegado a la nave espacial.
	 * @return true si el juego ha terminado
	 */
	public boolean isOver(){
		return !(this.energy>0 && !this.navigation.atSpaceship());
		
	}
	
	/**
	 * Informa de que un error ha ocurrdio a los observadores de robot engine
	 * @param msg - String con el mensaje de error
	 */
	public void requestError(String msg){
		Iterator<RobotEngineObserver> it2 = this.iterator();
		while(it2.hasNext()){
			it2.next().raiseError(msg);
		}
	}
	
	/**
	 * Informa a los observadores del modulo de navegacion y del robot que la simulacion ha comenzado
	 */
	public void requestStart(){
		
		Iterator<NavigationObserver> it1 = this.navigation.iterator();
		while(it1.hasNext()){
			it1.next().initNavigationModule(this.navigation.getCurrentPlace(), dirInicial);
		}
		Iterator<RobotEngineObserver> it2 = this.iterator();
		while(it2.hasNext()){
			it2.next().robotUpdate(this.energy, this.recycledMaterial);
		}
	}
	
	/**
	 * Avisa a los observadores del robot engine de que comuniquen un mensaje
	 * @param message - Un string que es el mensaje que se a va comunicar
	 */
	public void saySomething(java.lang.String message){
		Iterator<RobotEngineObserver> it2 = this.iterator();
		while(it2.hasNext()){
			it2.next().robotSays(message);
		}
	}
	/**
	 * Llama a buscaRecursivo para que haga el backtracking
	* Se encarga de hacer que el robot busque la nave espacial. Recibe un entero que marca 
	 * el máximo numero de acciones posibles, y sirve para limitar la busqueda, de forma que si
	 * la profundidad es 0, haga backtracking. La busqueda se va a realizar del siguiente modo:
	 * Primero usaremos todos los objetos que tengamos, luego se cogerán todos los objetos del 
	 * lugar que no nos quiten fuel y los usaremos nada más cogerlos; después volveremos a usar
	 * todos los objetos que podamos (Esto sirve para conseguir más fuel, pero podriamos quitar
	 * este paso quitando una llamada a usaTodosObjetos).
	 * Despues haremos llamadas a los metodos que comprueban si nos va a valer de algo realizar
	 * la accion, si es posible, la haremos y seguiremos explorando el arbol de busqueda con
	 * una profundidad menos, y si no nos vale para nada ese movimiento, haremos backtracking.
	 * Los movimientos posibles que nos van a ayduar a encontrar la salida van a ser MOVE, turn
	 * left y turn right. (Podriamos hacer que solo girase en una direccion, pero hemos decidido
	 * hacer que gire en las dos direcciones)
	 * Hay que destacar que el robot encontrará un camino que no tiene por que ser el óptimo
	 * (Si lo encuentra, dada la profundidad), y solo contarán como acciones para la profundidad
	 * los move y los turn.
	 * @param profundidad - Max num de acciones que puede hacer el robot. Sirve para
	 * limitar la busqueda.
	 * 
	 */
	public void buscaSalida(int profundidad){
		this.buscaRecursivo(profundidad);
	}
	/**
	 * Se encarga de hacer que el robot busque la nave espacial. Recibe un entero que marca 
	 * el máximo numero de acciones posibles, y sirve para limitar la busqueda, de forma que si
	 * la profundidad es 0, haga backtracking. La busqueda se va a realizar del siguiente modo:
	 * Primero usaremos todos los objetos que tengamos, luego se cogerán todos los objetos del 
	 * lugar que no nos quiten fuel y los usaremos nada más cogerlos; después volveremos a usar
	 * todos los objetos que podamos (Esto sirve para conseguir más fuel, pero podriamos quitar
	 * este paso quitando una llamada a usaTodosObjetos).
	 * Despues haremos llamadas a los metodos que comprueban si nos va a valer de algo realizar
	 * la accion, si es posible, la haremos y seguiremos explorando el arbol de busqueda con
	 * una profundidad menos, y si no nos vale para nada ese movimiento, haremos backtracking.
	 * Los movimientos posibles que nos van a ayduar a encontrar la salida van a ser MOVE, turn
	 * left y turn right. (Podriamos hacer que solo girase en una direccion, pero hemos decidido
	 * hacer que gire en las dos direcciones)
	 * Hay que destacar que el robot encontrará un camino que no tiene por que ser el óptimo
	 * (Si lo encuentra, dada la profundidad), y solo contarán como acciones para la profundidad
	 * los move y los turn.
	 * @param profundidad - Max num de movimientos que puede hacer el robot para llegar a la salida
	 * @throws WrongInstructionFormatException - No lanza esta excepción porque las instrucciones
	 * siempre van a ser correctas, ya que el input lo realiza la aplicacion
	 */
	private void buscaRecursivo(int profundidad){
		if(profundidad!=0){
			this.usaTodosObjetos();
			
			this.seleccionaObjetos();
			
			this.usaTodosObjetos();
			
			this.compruebaMove(profundidad);
			
			this.compruebaTurn(profundidad, "left");
			
			this.compruebaTurn(profundidad, "right");
		}
	}
	
	/**
	 * Método que usa todos los objetos del inventario del robot una vez
	 */
	public void usaTodosObjetos(){
		ArrayList<String> objetos = this.itemContainer.objetos();
		Iterator<String> it = objetos.iterator();
		while(it.hasNext()){
			Instruction instruction = null;
			try {
				instruction = Interpreter.generateInstruction("operate " + it.next());
			} catch (WrongInstructionFormatException e) {

				e.printStackTrace();
			}
			this.communicateRobot(instruction);
		}
	}
	
	/**
	 * Método que selecciona aquellos objetos que no van a restar fuel al robot. Estos objetos
	 * los cogerá y los usará una vez.
	 */
	public void seleccionaObjetos(){
		//Opero todos los objetos menos los que me resten fuel
		
		ArrayList<String> objetosDisponibles = this.navigation.getCurrentPlace().objetos();
		Iterator<String> it = objetosDisponibles.iterator();
		while(it.hasNext()){  //Cojo todos los objetos que me den fuel
			Item item = this.navigation.pickItemFromCurrentPlace(it.next());
			this.navigation.dropItemAtCurrentPlace(item);
			if(item.esFuel()){
				if(item.energy()>=0){
					Instruction instruction = null;
					try {
						instruction = Interpreter.generateInstruction("pick "+ item.getId() );
						this.communicateRobot(instruction);
						instruction = Interpreter.generateInstruction("operate "+ item.getId() );
						this.communicateRobot(instruction);
						
					} catch (WrongInstructionFormatException e) {
					
						e.printStackTrace();
					}
					
				}
			}else{
				Instruction instruction = null;
				try {
					instruction = Interpreter.generateInstruction("pick "+ item.getId() );
					this.communicateRobot(instruction);
					instruction = Interpreter.generateInstruction("operate "+ item.getId() );
				} catch (WrongInstructionFormatException e) {
					
					e.printStackTrace();
				}
				this.communicateRobot(instruction);
			}
		}
		
	}
	/**
	 * Comprueba si puede moverse el robot. Para ellor guarda el nombre del lugar en el
	 * que estaba, realiza una intruccion move, y compara el nombre del nuevo lugar con el
	 * que habiamos guardado. de este modo vemos si nos hemos movido, y si es asi, 
	 * seguimos explorando la salida, si no, hacemos backtracking. En los dos casos tenemos
	 * que actualizar la profundidad de la busqueda.
	 * @param profundidad - profundidad de la busqueda
	 */
	private void compruebaMove(int profundidad) {
		//Compruebo si puedo moverme
		Instruction instruction = null;
		String lugarInicial = this.navigation.getCurrentPlace().getName();
		try {
			instruction = Interpreter.generateInstruction("move");
			this.communicateRobot(instruction);
			if(this.navigation.atSpaceship()){
				this.requestQuit();
			}
		} catch (WrongInstructionFormatException e) {
			
			e.printStackTrace();
		}
		
		if(lugarInicial!=this.navigation.getCurrentPlace().getName()&&!this.navigation.estaVisitadoAct()){
			buscaRecursivo(profundidad-1);
		}
		profundidad++;
		this.deshaceInstruccion();
		
	}
	/**
	 * Comprueba si el robot puede girarse en una direccion dada. Después de girar siempre usará los
	 * objetos una vez (servirá sobre todo para usar codecards), después explorará el siguiente
	 * nivel de la busqueda, y despues deshará la acción para cuando hagamos el backtracking.
	 * @param profundidad - profundidad de la busqueda
	 * @param direction - direccion en la que queremos girar
	 */
	private void compruebaTurn(int profundidad, String direction){
		//Compruebo si puedo girar a la izq
		try {
			Instruction instruction = Interpreter.generateInstruction("turn " + direction);
			this.communicateRobot(instruction);
			this.usaTodosObjetos();
		} catch (WrongInstructionFormatException e) {
			
			e.printStackTrace();
		}
		buscaRecursivo(profundidad-1);
		profundidad++;
		this.deshaceInstruccion();
	}

}
