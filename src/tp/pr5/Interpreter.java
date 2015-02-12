/**
 * El interpreter es el encargado de convertir una entrada que mete el usuario de la aplicacion
 * en una instruccion para el robot. Para las practicas 4 y 5 no se utiliza esta clase
 */
package tp.pr5;

import java.util.ArrayList;
import java.util.Iterator;

import tp.pr5.instructions.DropInstruction;
import tp.pr5.instructions.HelpInstruction;
import tp.pr5.instructions.Instruction;
import tp.pr5.instructions.MoveInstruction;
import tp.pr5.instructions.OperateInstruction;
import tp.pr5.instructions.PickInstruction;
import tp.pr5.instructions.QuitInstruction;
import tp.pr5.instructions.RadarInstruction;
import tp.pr5.instructions.ScanInstruction;
import tp.pr5.instructions.TurnInstruction;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class Interpreter {

	// METHODS

	public static final String LINE_SEPARATOR = System.getProperty( "line.separator" );

	
	/**
	 * Metodo estatico que devuelve una Instruction que es resultado de parsear un String que
	 * introduce el usuario.
	 * @param line - String que introduce el usuario
	 * @return la instrucción correspondiente de hacer el parseado de lo que introduce el usuario.
	 * Si la instruccion no es correcta lanzará una WrongInstructionFormatException
	 * @throws WrongInstructionFormatException si la instruccion no es correcta
	 */
	public static Instruction generateInstruction(String line) throws WrongInstructionFormatException{
		
		Instruction instruction = null;
		ArrayList<Instruction> array = Interpreter.instructions();
		Iterator<Instruction> it = array.iterator();
		boolean exit=false;
		while(!exit&&it.hasNext()){
			try {
				instruction = it.next();
				instruction = instruction.parse(line);
				exit=true;
			} catch (WrongInstructionFormatException e) {
				
			}
		}
		if(exit){
			return instruction;
		}else{
			throw new WrongInstructionFormatException();
		}
	}

	
	/**Método estático que devuelve la informaciñon de todas las instrucciones disponibles
	 * @return un string con la informacion de todas las instrucciones disponibles
	 */
	public static String interpreterHelp() {
		String line = "The valid instructions for WALL-E are:" + Interpreter.LINE_SEPARATOR;
		ArrayList<Instruction> array = instructions();
		Iterator<Instruction> it = array.iterator();
		while(it.hasNext()){
			line = line + it.next().getHelp();
		}
		line = line + Interpreter.LINE_SEPARATOR;
		return line;
	}
	
	/**
	 * Devuelve un arraylist con todas las instrucciones disponibles para el juego
	 * @return un ArrayList con las instrucciones disponibles para el juego
	 */
	public static ArrayList<Instruction> instructions(){
		ArrayList<Instruction> array = new ArrayList<Instruction>();
		array.add(0, new DropInstruction());
		array.add(1, new HelpInstruction());
		array.add(2, new MoveInstruction());
		array.add(3, new OperateInstruction());
		array.add(4, new PickInstruction());
		array.add(5, new QuitInstruction());
		array.add(6, new RadarInstruction());
		array.add(7, new ScanInstruction());
		array.add(8, new TurnInstruction());
		return array;
	}

}
