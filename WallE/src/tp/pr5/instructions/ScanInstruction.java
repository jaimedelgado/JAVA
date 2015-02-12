/**
 * La ejecucion de esta instruccion muestra informacion del inventario del robot o la descripcion completa sobre el item con el identificador id
 * contenido en el inventario. Esta instruccion funciona si el usuario escribe SAN o ESCANEAR (el id no es obligatorio, ya que si añades un id, 
 * especificas sobre un item concreto, mientras que sin id, muestra el inventario entero del robot)
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
import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;
import tp.pr5.utilidades.Texts;

public class ScanInstruction implements Instruction{
	private ItemContainer robotContainer;	
	private RobotEngine robot;
	private String id;
	
	//Constructors

	/**
	 * Contructor vacio
	 */
	public ScanInstruction(){}
		
		//Methods
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * ScanInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String words[] = cad.split(" ");
		if (words[0].equalsIgnoreCase("SCAN")||words[0].equalsIgnoreCase("ESCANEAR")){
			if(words.length>1){
				this.id = words[1];
			}else{
				this.id = "";
			}
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion SCAN|ESCANEAR
	 * @return String SCAN|ESCANEAR
	 */
	public String getHelp() {
		return "   SCAN|ESCANEAR <id>";
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
		this.robotContainer = robotContainer;
		this.robot=engine;
	}

	@Override
	
	/**
	 * Muestra todos los items disponibles que wall-e ha ido recogiendo
	 * mediante la funcion de pick.
	 * Si el id es vacio, el metodo llamara al metodo requestScanCollection(), que mostrará el contenido
	 * de todos los objetos contenidos en el contenedor.
	 * Por el contrario, si el id contiene un nombre de item valido, lo buscara en el contenedor y mostrara la informacion
	 * de este unico item.
	 */
	public void execute() throws InstructionExecutionException {
		String LINE_SEPARATOR = System.getProperty("line.separator");
		if (id == "") { // No parameter
			
			this.robot.saySomething(Texts.WALLE_CARRYING + LINE_SEPARATOR);
			this.robotContainer.requestScanCollection();
		} else { // Has a parameter
			Item item = this.robotContainer.getItem(id);
			if (item == null) {
				throw new InstructionExecutionException();
			} else{
				
				this.robot.saySomething(Texts.WALLE_CARRYING+ LINE_SEPARATOR);
				this.robotContainer.requestScanItem(item.toString());
			}
		}
		
		
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
