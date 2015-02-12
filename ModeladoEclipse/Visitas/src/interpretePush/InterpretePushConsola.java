/**
 * Clase que implementa todas las funciones específicas del interprete en modo consola.
 * Esta clase cuenta con un atributo del tipo escaner para leer lo que va poniendo el usuario, ademas de 
 * la etapa principal que hereda de la clase padre y que sirve como unión del Interprete con el modelo semántico.
 * El único método público que tiene es inicia(), que inicia la ejecución del interprete.
 * Funciona de manera push, ya que va esperandp a que interactue el usuario para transitar por las diferentes etapas.
 */
package interpretePush;

import java.util.NoSuchElementException;
import java.util.Scanner;

import modelo.Continuacion;
import modelo.Etapa;

/**
 * @author Jaime Delgado Linares
 *
 */
public class InterpretePushConsola extends InterpretePush{
	private Scanner entrada;
	//Contructoras
	/**
	 * Contructora que recibe una etapa
	 * @param e - Etapa que quieres introducir en el Interprete
	 */
	public InterpretePushConsola(Etapa e) {
		super(e);
		entrada = new Scanner(System.in);
	}
	//Metodos
	/**
	 * Ejecuta la etapa "e" mostrando un texto con su recurso y muestra un mensaje de fin si ya no hay más continuaciones
	 * @param e - Etapa a ejecutar
	 */
	@Override
	protected void ejecuta(Etapa e) {
		System.out.println(e.recurso().toString());
		if(e.numContinuaciones()<=0){
			System.out.println("Fin de la ejecucion!!");
		}
	}
	/**
	 * Muestra por pantalla las posibles continuaciones y pide al usuario que eliga una de ellas
	 * @param array - Array de continuaciones posibles de la etapa
	 * @param n - Numero de continuaciones posibles de la etapa
	 */
	@Override
	protected void interactua(Continuacion[] array, int n) {
		for(int i=1; i<=n; i++){
			System.out.println(i+"."+array[i-1].texto());
		}
		if(n>0){
			System.out.print("Elige una opcion:");
		}
	}
	/**
	 * Devuelve la opción leida por el usuario. Tendrás que introducir una opción valida para avanzar
	 * @param numOp - numero de opciones posibles
	 */
	@Override
	protected int leeOpcion(int numOp) {
		System.out.println(">");
    	int opcion=-1;
    	while(opcion<1 || opcion>numOp){
    		try{
    			opcion = Integer.valueOf(entrada.nextLine()).intValue();
    		}catch(NumberFormatException e){
    			System.out.println("Elige una opcion:");
    		}catch(NoSuchElementException e1){
    			System.out.println("Elige una opcion:");
    		}catch(IllegalStateException e2){
    			System.out.println("Elige una opcion:");
    		}
    	}
    	return opcion-1;    
	}
	/**
	 * Finaliza el programa en modo consola
	 */
	@Override
	protected void finaliza() {
		System.exit(0); 
	}
	/**
	 * Va transitando por las etapas de la visita. 
	 * Actualiza la etapa e inicia otra vez el interprete
	 */
	@Override
	public void transita() {
		int opcion = leeOpcion(this.etapa.numContinuaciones());
        this.etapa = this.etapa.continuaciones()[opcion].etapa();
        this.inicia();
		
	}

}
