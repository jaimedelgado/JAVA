/**
 * Esta interfaz representa una instruccion que la aplicacion puede llevar a cabo.
 * Toda instruccion que el robot pueda llevar a cabo (y por lo tanto la aplicacion),
 * debe implementar esta instruccion. Fuerza a la instruccion a implementar los siguientes
 * cuatro metodos:
 * - Método de parseo: Trata de parsear una instruccion (algo asi como convertir una cadena en una
 * instruccion que el robot pueda entender y llevar a cabo) con la informacion de la instruccion de
 * la calse a la que representa.
 * - Metodo help: Devuleve un string com una explicacion del tipo de expresion que el metodo de parseo admite.
 * - ConfigureCntext: Metodo que establece el contexto necesario para ejecutar la instruccion
 * - Execute: Metodo que lleva a cabo el trabajo de la ejecucion, ejecutandola.
 * 
 *  El metodo execute no tiene ningun parametro
 *  Por ello el contexto de la ejecucion debe ser dado prioritariamente al metodo configureContext, invocandolo.
 *  Hay que darse cuenta que el contexto actual depende de la subclase poruqe la informacion necesitada varia
 *  entre las instrucciones.
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

public interface Instruction {
	
	///////////////////////////////////////////////////////////////////////
	
	/////////////////////////////METHODS/////////////////////////////////////
	
	/**
	 * Parsea el string que recibe y devuelve una instancia a la subclase correspondiente
	 * si la cadena coincide con la sintaxis de la isntrucccion. En otro caso lanza una 
	 * WrongInstructionFormatException. Cada subcalse debe implementar su propio parser.
	 */
	Instruction parse(java.lang.String cad) throws WrongInstructionFormatException;
		
	/**
	 * Devuelve una descripcion de la sintaxis de la instruccion.
	 * La linea no termina con un line separator. Es funcion de quien
	 * llama a este metodo añadir dicho line separator antes de imprimir el
	 * mensaje.
	 */
	String getHelp();
	
	/**
	 * Configura el contexto de ejecucion. El metodo recibe el motor entero (engine, navigation and the robot container)
	 * a pesar de que la implementacion actual de ejecucion no lo necesite.
	 */
	void configureContext(RobotEngine engine,NavigationModule navigation,ItemContainer robotContainer);
	
	/**
	 * Ejecuta la instruccion. Debe ser implementada en cada subclase no abstracta.
	 * Lanza una InstructionExecutionException si la ejecucion no se puede llevar
	 * a cabo por algun motivo.
	 */
	void execute() throws InstructionExecutionException;
	
	/**
	 * Metodo que implementan todas las subclase para poder deshacer una ejecucion llevada a cabo de esa intruccion. 
	 */
	public abstract void undo();
}
