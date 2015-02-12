/**
 * Clase que implementa todas las funciones específicas del interprete en modo consola.
 * Esta clase cuenta con un atributo del tipo escaner para leer lo que va poniendo el usuario, ademas de 
 * la etapa principal que hereda de la clase padre y que sirve como unión del Interprete con el modelo semántico.
 * El único método público que tiene es inicia(), que inicia la ejecución del interprete.
 * Funciona de manera pull, ya que va ayudando al usuario de que interactue para transitar por las diferentes etapas.
 */
package interpretePull;

import java.util.NoSuchElementException;
import java.util.Scanner;

import modelo.Continuacion;
import modelo.Etapa;

/**
 * @author Jaime Delgado Linares
 *
 */
public class InterpretePullConsola extends InterpretePull{
	private Scanner entrada;
	//Contructoras
	/**
	 * Contructora que recibe una etapa
	 * @param e - Etapa que quieres usar en el interprete
	 */
	public InterpretePullConsola(Etapa e) {
		super(e);
		entrada = new Scanner(System.in);
	}
	//Metodos
	/**
	 * Ejecuta la etapa "e". Esta ejecución consiste en mostrar por pantalla los datos del recurso de la etapa "e" y
	 * ver si ya no quedan más continuaciones posibles. En el caso de que no queden continuaciones terminará el programa.
	 * @param e = Etapa que quieres ejecutar
	 */
	@Override
	protected void ejecuta(Etapa e) {
		System.out.println(e.recurso().toString());
		if(!e.tieneContinuaciones()){
			System.out.println("Fin de la ejecucion!!");
			this.finaliza();
		}
		
		
	}
	/**
     * Muestra las posibles continuaciones y pide al usuario que elija una de ellas
     * @param array - Array de continuaciones
     * @param n - Numero de continuaciones que hy en el array
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
	 * Devuelve la opción leida por el usuario
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
	 * Interactua con el usuario leyendo que opcion quiere, actualiza la etapa y vuelve a iniciar el interprete.
	 */
	@Override
	public void transita(){
		int opcion = leeOpcion(this.etapa.numContinuaciones());
        this.etapa = this.etapa.continuaciones()[opcion].etapa();
        this.ejecuta(this.etapa);
        this.inicia();
		
	}

}
