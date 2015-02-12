package tp.pr5;

/**
 * Aplicación que usa la clase Parse para parsear los argumentos del main y ejecuta un programa que 
 * simula que Walle-E va por una ciudad cogiendo objetos. 
 * El comando -i servirá para elegir la interfaz y se podra elegir console, swing, both
 * El comando -m indicará el archivo que quieres leer.
 * El comando -h mostrará una ayuda con las opciones disponibles
 * El comando -d hará que el robot busqué sólo la salida y la muestre por swing y console. Hay que
 * introducir una cantidad de movimientos max para delimitar la busqueda.
 */

import tp.pr5.utilidades.Parser;


/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

public class Main {
	 /**
     * Parsea y analiza la instruccion que se encunetra en la linea de comandos.
     * En el caso de que un elemento no coincida con los entendibles para el programa 
     * (help, map, interface o bactracking) lanza una excepcion del tipo ParseException,
     * y en el caso de que ningun argumento coincida con el tipo de interfaz swing o console
     * sacara un mensaje de error: Wrong type of interface
     * @param args - Linea de comandos que hay que parsear y analizar
     */
	public static void main(String[] args) {
		Parser parse = new Parser();
		parse.parsea(args);
	}
    
}
