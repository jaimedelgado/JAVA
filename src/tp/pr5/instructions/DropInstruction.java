/**
 * Esta instrucción suelta un objeto (item) en el lugar en el que se encuentra el robot.
 * Actualiza el inventario del robot y elimina el objeto de la lista.
 * Esta instruccion funciona si el usuario escribe DROP o SOLTAR.
 */

package tp.pr5.instructions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 */

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;
import tp.pr5.utilidades.Texts;

public class DropInstruction implements Instruction{
	private RobotEngine robot;
	private NavigationModule navigation; 
	private ItemContainer robotContainer;	
	private String id;
	@SuppressWarnings("unused")
	private Item it;
	//CONSTRUCTORS
	
	/**
	 * Contructor vacio
	 */
	public DropInstruction(){}
	
	// METHODS
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * DropInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * Comprueba que la cadena tenga dos partes, en la que la primera es la instruccion
	 * en si (y tiene que coindidir con 'DROP' o 'SOLTAR'), y la segunda parte es el identificador
	 * del item al que hace referencia la accion.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String words[] = cad.split(" ");
		if(words[0].equalsIgnoreCase("DROP")||words[0].equalsIgnoreCase("SOLTAR")){
			if (words.length > 1) {
				this.id = words[1];
			} else {
				throw new WrongInstructionFormatException();
			}
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion DROP/SOLTAR
	 * @return String DROP/SOLTAR
	 */
	public String getHelp() {
		return "   DROP|SOLTAR <id>";
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
		this.navigation=navigation;
		this.robotContainer = robotContainer;
		this.robot = engine;
	}

	@Override
	
	/**
	 * El robot suelta un objeto (item) del contenedor en el lugar en el que se encuentra,
	 * si el objeto existe. Lanza una excepcion del tipo InstructionExecutionException
	 * cuando el el contenedor del robot no contiene un item con el mismo nombre o cuando
	 * hay otro objeto con el mismo nopmbre en el lugar actual.
	 */
	public void execute() throws InstructionExecutionException {
		String LINE_SEPARATOR = System.getProperty("line.separator");
		if(this.robotContainer.containsItem(this.id)){
			Item item = this.robotContainer.getItem(this.id);
			this.it = item;
			if(this.navigation.findItemAtCurrentPlace(this.id)){
				throw new InstructionExecutionException();
			}else{
				this.robotContainer.pickItem(this.id);
				this.robot.saySomething(Texts.WALLE_DROPPED+item.getId() + LINE_SEPARATOR);
				this.navigation.dropItemAtCurrentPlace(item);
			}
		}else{
			this.robot.saySomething(Texts.AVISO_NO_TENGO+this.id+"."+LINE_SEPARATOR);
			throw new InstructionExecutionException();
		}
			
		
	}
	/**
	 * Devuelve el identificador de un objeto.
	 * @return id - String
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * Deshace la accion de DROP. Si el robot no contiene en el contenedor
	 * un item concreto, coge el objeto del lugar en el que esta (que es donde
	 * lo acaba de soltar) y lo añade al inventario de objetos. De esta manera 
	 * deshace la acción.
	 */
	public void undo(){
		if(!this.robotContainer.containsItem(this.id)){
			Item item = this.navigation.pickItemFromCurrentPlace(id);
			this.it = item;
			this.robotContainer.addItem(item);
		}
	}
	

}
