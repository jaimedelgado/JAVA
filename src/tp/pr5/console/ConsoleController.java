/**
 * Es el controlador que se emplea cuando la aplicacion ha sido configurada como
 * una aplicacion de consola.
 * Contiene el bucle de la simulacion que ejecuta las instrucciones escritas en
 * consola por el usuario.
 */
package tp.pr5.console;

import java.util.Iterator;
import java.util.Scanner;

import tp.pr5.Controller;
import tp.pr5.Interpreter;
import tp.pr5.NavigationObserver;
import tp.pr5.RobotEngine;
import tp.pr5.RobotEngineObserver;
import tp.pr5.instructions.Instruction;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.InventoryObserver;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class ConsoleController extends Controller{
	/**
	 * Es la constructora del controlador. Recibe el modelo principal
	 * del juego.
	 * @param game - Es el juego que se va a jugar o se esta jugando
	 */
	public ConsoleController(RobotEngine game){
		super(game);
	}
	/**
	 * Se encarga de ejecutar el bucle del juego en modo consola
	 */
	@Override
	public void startController() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		this.robot.requestStart();
		do{
			this.robot.saySomething("WALL·E> ");
			String line = scan.nextLine();
			if(!this.deshacer(line)){
				try{
					Instruction instruction = Interpreter.generateInstruction(line);
					this.robot.communicateRobot(instruction);
				}catch(WrongInstructionFormatException e){
					/*No se ha podido realizar esa instruccion, realizar lo que queramos (Mensaje de error,
					salida de error, o nada) */
				}
				if(this.robot.getFuel()==0){
					Iterator<RobotEngineObserver> it1 = this.robot.iterator();
					while(it1.hasNext()){
						it1.next().engineOff(false);
					}
					System.exit(0);
				}else if(robot.isOver()){
					Iterator<RobotEngineObserver> it2 = this.robot.iterator();
					while(it2.hasNext()){
						it2.next().engineOff(true);
					}
					System.exit(0);
				}
			}
		}while (!this.robot.isOver());
		
	}
	
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del modulo de navegacion del modelo
	 */
	public void registerEngineObserver(NavigationObserver observer){
		this.robot.addNavigationObserver(observer);
	}
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del inventario del robot
	 */
	public void registerItemContainerObserver(InventoryObserver observer){
		this.robot.addItemContainerObserver(observer);
	}
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del robot
	 */
	public void registerRobotObserver(RobotEngineObserver observer){
		this.robot.addEngineObserver(observer);
	}
	/**
	 * Método que comprueba si la accion que ha introducido el usuario es un undo
	 * @param line
	 * @return
	 */
	public boolean deshacer(String line){
		if(line.equalsIgnoreCase("UNDO")){
			this.robot.deshaceInstruccion();
		}
		return line.equalsIgnoreCase("UNDO");
	}
	
}
