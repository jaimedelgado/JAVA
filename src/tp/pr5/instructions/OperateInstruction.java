/**
 * Es la instruccion encargada de usar u operar un objeto (item). Esta instruccion
 * funciona si el usuario escribe OPERATE id u OPERAR id, donde id es el identificador (string)
 * del objeto que se quiere operar.
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

public class OperateInstruction implements Instruction{
	private RobotEngine engine;
	private NavigationModule navigation; 
	private ItemContainer robotContainer;	
	private String id;
	private Item it;
	
	//CONSTRUCTORS

	/**
	 * Contructor vacio
	 */
	public OperateInstruction(){}
	
	//METHODS
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * DropInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * Comprueba que la cadena tenga dos partes, en la que la primera es la instruccion
	 * en si (y tiene que coindidir con 'OPERATE' u 'OPERAR'), y la segunda parte es el identificador
	 * del item al que hace referencia la accion.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String words[] = cad.split(" ");
		if (words[0].equalsIgnoreCase("OPERATE")||words[0].equalsIgnoreCase("OPERAR")){
			if(words.length>1){
				this.id = words[1];
			}else{
				throw new WrongInstructionFormatException();
				//this.id="";
			}
			return this;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	@Override
	/**
	 * Devuelve una cadena de ayuda sobre la instruccion OPERATE|OPERAR
	 * @return String  OPERATE|OPERAR
	 */
	public String getHelp() {
		return "   OPERATE|OPERAR <id>";
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
		this.robotContainer = robotContainer;
	}

	@Override
	
	/**
	 * Si es posible, opera sobre un objeto, usándolo como lo haría wall-e.
	 * Se lanza una excepcion del tipo InstructionExecutionException si el
	 * item no existe o no se puede usar.
	 */
	public void execute() throws InstructionExecutionException {
		if(this.id==""){
			throw new InstructionExecutionException();
		}else{
			Item item = this.robotContainer.getItem(id);
			if(item==null){
				throw new InstructionExecutionException();
			}else{
				this.it = item;
				if (item.use(this.engine, this.navigation)) {
					this.robotContainer.useItem(item);
					if(!item.canBeUsed()){
						this.robotContainer.pickItem(this.id);
					}
					
				} else {
					throw new InstructionExecutionException();
				}
			}
		}
		
	}
	
	/**
	 * Deshace la ejecucion de la accion de operate. Para ello es necesario que añada
	 * el item de nuevo, ya que al operarlo se consume.
	 */
	public void undo(){
		this.it.unuse(this.engine, this.navigation);
		if(!this.robotContainer.containsItem(id)){
			this.robotContainer.addItem(this.it);
		}
	}

}
