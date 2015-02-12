/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
package tp.pr5.instructions.exceptions;

/**
 * Excepción que se lanza cuando un String no puede ser parseado para crear un comando.
 * Tiene un mensaje con una explicación sobre el error que se ha producido.
 * Tiene varios contrusctores, uno por cada constructor de la superclase.
*/

@SuppressWarnings("serial")
public class WrongInstructionFormatException extends java.lang.Exception{
	
	
	//Constructors

	/**
	 * Constructor sin parametros (No tiene ningun mensaje)
	 */
	public WrongInstructionFormatException(){
	}
	
	/**
	 * La excepción se crea con un mensaje que indica que problema ha habido.
	 * @param arg0 - String con el mensaje de la excepción
	 */
	public WrongInstructionFormatException(String arg0){
		super(arg0);
	}
	
	/**
	 * Constructor con un mensaje de error y un objeto del tipo Throable
	 * @param arg0 - String con el mensaje de error
	 * @param arg1 - Throwable
	 */
	public WrongInstructionFormatException(String arg0, Throwable arg1){
		super(arg0, arg1);
	}
	
	/**
	 * Constructor con un objeto del tipo Throwable
	 * @param arg0 - Throwable
	 */
	public WrongInstructionFormatException(Throwable arg0){
		super(arg0);
	}
}
