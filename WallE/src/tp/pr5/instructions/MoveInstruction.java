/**
 * Esta ejecucion mueve al robot de un lugar al siguiente en la direccion a la que mire el robot.
 * Esta instruccion funciona si el usuario escribe MOVE o MOVER.
 */

package tp.pr5.instructions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import tp.pr5.Direction;
import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.ItemContainer;
import tp.pr5.utilidades.Texts;

public class MoveInstruction implements Instruction{
	private RobotEngine engine;
	private NavigationModule navigation; 
	//CONSTRUCTORS

	/**
	 * Contructor vacio
	 */
	public MoveInstruction(){}
	
	//METHODS
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * MoveInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		if(cad.equalsIgnoreCase("MOVE")||cad.equalsIgnoreCase("MOVER")){
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion MOVE|MOVER
	 * @return String MOVE|MOVER
	 */
	public String getHelp() {
		return "   MOVE|MOVER" ;
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
		this.navigation=navigation;
	}

	@Override
	
	/**
	 * Lleva a cabo la ejecucion del movimiento. Si el movimiento no es posible (por motivo como
	 * que no haya una calle a la que ir o la calle este cerrada), se lanza un mensaje de error.
	 * Se le resta 5 de fuel cuando se ejecuta la accion.
	 */
	public void execute() throws InstructionExecutionException {
		if(this.navigation.getHeadingStreet()==null || !this.navigation.getHeadingStreet().isOpen()){
			throw new InstructionExecutionException("No puede moverse");
		}else{
			String LINE_SEPARATOR = System.getProperty("line.separator");
			
			this.engine.saySomething(Texts.WALLE_MOVING + this.navigation.getCurrentHeading() + LINE_SEPARATOR );
			this.navigation.move();
			this.engine.addFuel(-5);
		}
		
	}
	
	/**
	 * Realiza el undo de la accion move. Para ello cambia 360 grados la direccion del robot, lo mueve,
	 * y vuelve a dejar su direccion como estaba.
	 */
	public void undo(){
		Direction dir = this.navigation.getCurrentHeading().inverse();
		this.navigation.setDirection(dir);
		try { // El undo nunca va a lanzar excepcion
			this.navigation.move();
		} catch (InstructionExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.engine.addFuel(5);
		this.navigation.setDirection(dir.inverse());
	}
}
