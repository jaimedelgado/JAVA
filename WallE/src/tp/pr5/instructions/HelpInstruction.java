/**
 * Muestra la ayuda del juego con todas las instrucciones que el robot puede ejecutar.
 * Esta instruccion funciona cuando el usuario teclea HELP o AYUDA.
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

public class HelpInstruction implements Instruction{
	private RobotEngine engine;
	
	//CONSTRUCTORS

	/**
	 * Contructor vacio
	 */
	public HelpInstruction(){}
	
	//METHODS
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * HelpInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto (la cadena dada no coincide con ninguna de las
	 * instrucciones posibles).
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		if(cad.equalsIgnoreCase("HELP")||cad.equalsIgnoreCase("AYUDA")){
			return new HelpInstruction();
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	
	/**
	 * Devuelve una cadea de ayuda sobre la instruccion AYUDA/HELP
	 * @return String HELP/AYUDA
	 */
	public String getHelp() {
		return "   HELP|AYUDA";
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
		this.engine=engine;
	}

	@Override
	/**
	 * Ejecuta la instruccion de ayuda
	 */
	public void execute() throws InstructionExecutionException {
		this.engine.requestHelp();
		
	}
	
	/**
	 * No es necesario deshacer esta ejecucion. No implica nada para el
	 * flujo del juego
	 */
	public void undo(){
		
	}

}
