/**
 * Excepcion lanzada por la clase que lee el archivo del mapa, si tiene algun error.
 * El archivo será correcto siempre y cuando tenga los Items, los Place y las Street numeradas por orden,
 * no se intente meter un objeto en un Place que no existam y siga la estructura del archivo.
 */

package tp.pr5.cityLoader.cityLoaderExceptions;
/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
@SuppressWarnings("serial")


public class WrongCityFormatException extends java.io.IOException {
	/**
	 * Contructora sin argumentos
	 */
	public WrongCityFormatException(){
		
	}
	/**
	 * Constructora con un argumento con el mensaje de la excepcion
	 * @param msg - String con el mensaje que va a tener la excepcion
	 */
	public WrongCityFormatException(String msg){
		super(msg);
	}
	/**
	 * Constructora con dos argumentos (el mensaje, y un objeto del tipo Throwable)
	 * @param msg - String con el mensaje de la excepcion
	 * @param arg - Throwable
	 */
	public WrongCityFormatException(String msg, Throwable arg){
		super(msg,arg);
	}
	/**
	 * Contructora con un argumento del tipo Throwable
	 * @param arg - Throwable
	 */
	public WrongCityFormatException(Throwable arg){
		super(arg);
	}
}
