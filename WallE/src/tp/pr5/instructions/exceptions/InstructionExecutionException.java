/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
package tp.pr5.instructions.exceptions;

/** 
 * Excepción que es lanzada cuando una instruccion no se puede ejecutar.
 * Esta excepción tiene un mensaje con una explicación sobre que error se ha cometido.
 * Tiene varias contructores diferentes, una por cada contructor de la superclase
*/
@SuppressWarnings("serial")
public class InstructionExecutionException extends Exception{
	
	
	//Constructors
	
	/**
	 * Constructor sin parametros (No tiene ningun mensaje)
	 */
	public InstructionExecutionException(){
	}
	
	/**
	 * La excepción se crea con un mensaje que indica que problema ha habido.
	 * @param arg0 - String con el mensaje de la excepción
	 */
	public InstructionExecutionException(String arg0){
		super(arg0);
	}
	
	/**
	 * Constructor con un mensaje de error y un objeto del tipo Throable
	 * @param arg0 - String con el mensaje de error
	 * @param arg1 - Throwable
	 */
	public InstructionExecutionException(String arg0, Throwable arg1){
		super(arg0, arg1);
	}
	
	/**
	 * Constructor con un objeto del tipo Throwable
	 * @param arg0 - Throwable
	 */
	public InstructionExecutionException(Throwable arg0){
		super(arg0);
	}
	
}
