/**
 * Esta instruccion muestra la descripcion del lugar actual en el que se encuentra wall-e y los objetos que hay en él.
 * Esta instruccion funciona si el usuario escribe RADAR.
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
import tp.pr5.items.ItemContainer;

public class RadarInstruction implements Instruction{
	private NavigationModule navigation;
	//Constructors

	/**
	 * Contructor vacio
	 */
	public RadarInstruction(){}
		
		//Methods
	@Override
	
	/**
	 * Recibe una cadena y parsea la instrucción, devolviendo una instancia de
	 * RadarInstruction o lanzando una WrongInstructionFormatException() si no
	 * tiene un formato correcto.
	 * @param cad - String que se quiere parsear
	 */
	public Instruction parse(String cad) throws WrongInstructionFormatException {
		if(cad.equalsIgnoreCase("RADAR")){
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
		return "   RADAR";
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
	}

	@Override
	
	/**
	 * Muestra los items que hay en cierto lugar. Un iterador recorre la informacion del lugar
	 * mostrando los items que hay en el mientras haya mas que mostrar (hasNext()).
	 */
	public void execute() throws InstructionExecutionException {
		
		Iterator<NavigationObserver> it = this.navigation.iterator();
		while(it.hasNext()){
			it.next().placeScanned(this.navigation.getCurrentPlace());
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
