/**
 * La ejecucion de esta instruccion solicita al robot finalizar la simulacion. Esta instruccion funciona
 * cuando el usuario escriba QUIT o SALIR.
 */

package tp.pr5.instructions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.ItemContainer;

public class QuitInstruction implements Instruction{
	private RobotEngine engine;
	
	//Constructors

	/**
	 * Contructor vacio
	 */
	public QuitInstruction(){}
	
	//Methods
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * QuitInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		if(cad.equalsIgnoreCase("QUIT")||cad.equalsIgnoreCase("SALIR")){
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion QUIT|SALIR
	 * @return String QUIT|SALIR
	 */
	public String getHelp() {
		return "   QUIT|SALIR";
	}

	@Override
	/**
	 * Modifica el contexto actual. Este metodo se encarga de realizar las modificaciones
	 * cuando se lleva a cabo una ejecucion.
	 * @param engine - El motor del robot
	 * @param navigation - Informacion del juego, como por ejemplo, informacion del lugar o direccion a la que mira el robto
	 * @param robotContainer - El contenedor de objetos del robot
	 */
	public void configureContext(RobotEngine engine, NavigationModule navigation, ItemContainer robotContainer) {
		this.engine = engine;
	}

	@Override
	
	/**
	 * Termina con la aplicaion llamando al metodo correspondiente para que termine con la aplicacion.
	 */
	public void execute() throws InstructionExecutionException {
		this.engine.requestQuit();
	}

	@Override
	/**
	 * No es necesario deshacer esta ejecucion. No implica nada para el
	 * flujo del juego
	 */
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
