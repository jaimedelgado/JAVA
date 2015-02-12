/**
 * La ejecucion de esta instruccion rota al robot. Esta instruccion funciona si el usuario escribe TURN LEFT or RIGHT or GIRAR LEFT or RIGHT.
 */

package tp.pr5.instructions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.Rotation;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.ItemContainer;

public class TurnInstruction implements Instruction{
	private RobotEngine engine;
	private NavigationModule navigation; 
	private Rotation rotation;	
	
	//Constructors

	/**
	 * Contructor vacio
	 */
	public TurnInstruction(){}
		
	//Methods
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * TurnInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String words[] = cad.split(" ");
		if (words[0].equalsIgnoreCase("TURN")||words[0].equalsIgnoreCase("GIRAR")){
			if(words.length>1){
				if(words[1].equalsIgnoreCase("RIGHT")){
					this.rotation = Rotation.RIGHT;
				}else if(words[1].equalsIgnoreCase("LEFT")){
					this.rotation = Rotation.LEFT;
				}else{
					throw new WrongInstructionFormatException();
				}
				return this;
			}else{
				throw new WrongInstructionFormatException();
			}
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion TURN|GIRAR <LEFT|RIGHT>
	 * @return String TURN|GIRAR <LEFT|RIGHT>
	 */
	public String getHelp() {
		return "   TURN|GIRAR <LEFT|RIGHT>";
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
	 * Rota a walle en una rotacion dada.
	 * Se lanza una excepcion del tipo InstructionExecutionException si el mensaje no
	 * es legible (la rotacion sea desconocida).
	 * Resta 5 de fuel por ejecutar esta accion.
	 */
	public void execute() throws InstructionExecutionException {
		try{
			if (this.rotation != Rotation.UNKNOWN) {
				this.navigation.rotate(this.rotation);
				this.navigation.initHeading(this.navigation.getCurrentHeading());
				this.engine.addFuel(-5);
				
			} else {
				throw new InstructionExecutionException();
			}
		}catch(InstructionExecutionException e){
			System.out.println("WALL·E says: I do not understand. Please repeat");
		}
		
	}
	public Rotation getRotation(){
		return this.rotation;
	}

	@Override
	/**
	 * Deshace la rotacion anterior que se llevo a cabo (a no ser que fuera UNKNOWN, que
	 * en dicho caso no se hace nada). Hace la inversa de la rotación y gira el robot.
	 * Añade 5 de fuel para compensar el gasto anterior.
	 */
	public void undo() {
		if (this.rotation != Rotation.UNKNOWN) {
			this.navigation.rotate(this.rotation.inverse());
			this.engine.addFuel(5);
			
		} 
	}
}
