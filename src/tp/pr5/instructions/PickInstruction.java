/**
 * Esta instruccion trata de coger un item del lugar actual en el que se encuentra el robot y añadirlo
 * al inventario del robot. Esta instruccion funciona si el usuario escribe PICK id o COGER id.
 */

package tp.pr5.instructions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
import java.util.Iterator;

import tp.pr5.NavigationModule;
import tp.pr5.NavigationObserver;
import tp.pr5.RobotEngine;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;
import tp.pr5.utilidades.Texts;

public class PickInstruction implements Instruction{
	private RobotEngine robot;
	private NavigationModule navigation; 
	private ItemContainer robotContainer;	
	private String id;
	private Item it;
	//Constructors

	/**
	 * Contructor vacio
	 */
	public PickInstruction(){}
	
	//METHODS
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * PickInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * Comprueba que la cadena tenga dos partes, en la que la primera es la instruccion
	 * en si (y tiene que coindidir con 'PICK id o COGER id'), y la segunda parte es el identificador
	 * del item al que hace referencia la accion.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String words[] = cad.split(" ");
		if (words[0].equalsIgnoreCase("PICK")||words[0].equalsIgnoreCase("COGER")){
			if(words.length>1){
				this.id = words[1];
			}else{
				throw new WrongInstructionFormatException();
			}
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion PICK|COGER
	 * @return String PICK|COGER
	 */
	public String getHelp() {
		return "   PICK|COGER <id>";
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
	 * Coge un item del lugar actual en el que se encuentra el robot. Este nuevo item pasa a formar parte del inventario
	 * de wall-e (item container). Se lanza una excepcion del tipo InstructionExecutionException si el item no puede
	 * ser añadido al inventario.
	 */
	public void execute() throws InstructionExecutionException {
		if(this.id==""){
			throw new InstructionExecutionException();
		}else{
			if(this.navigation.findItemAtCurrentPlace(id)){
				if(!this.robotContainer.containsItem(id)){
					Item item = this.navigation.pickItemFromCurrentPlace(id);
					this.it = item;
					this.robotContainer.addItem(item);
					String LINE_SEPARATOR = System.getProperty("line.separator");
					this.robot.saySomething(Texts.WALLE_PICKED + id + LINE_SEPARATOR );
					Iterator<NavigationObserver> it = this.navigation.iterator();
					while(it.hasNext()){
						it.next().placeHasChanged(this.navigation.getCurrentPlace());
					}
					
				}else{
					throw new InstructionExecutionException();
				}
			}else{
				throw new InstructionExecutionException();
			}
		}
		
	}


	/**
	 * Devuelve el identificador de un objeto.
	 * @return id - String
	 */
	public String getId() {
		return this.id;
	}

	@Override
	/**
	 * Deshace la accion soltando el objeto que acaba de soltar.
	 */
	public void undo() {
		if(this.robotContainer.containsItem(this.id)){
			this.robotContainer.pickItem(this.id);
			this.navigation.dropItemAtCurrentPlace(it);
		}
		
	}

}
