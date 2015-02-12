/**
 * Clase general de Interprete que tiene todas las funciones que van a ser comunes tanto para el interprete en modo consola
 * como para el interprete en modo gráfico. 
 * Tiene como atributo la etapa principal que va a ejecutar, y que sirve como unión del Interprete con el modelo semántico.
 * El único método que no tiene abstracto porque es común a todos los tipos de Interprete es el metodo inicia()
 */
package interpretePush;

import interpreteExpresiones.InterpreteExpresiones;
import modelo.Continuacion;
import modelo.Etapa;
/**
 * @author Jaime Delgado Linares
 *
 */
public abstract class InterpretePush {
	public static final String LINE_SEPARATOR = System.getProperty( "line.separator" );
	protected InterpreteExpresiones iExpresiones;
	protected Etapa etapa;
	//Contructores
	/**
	 * Constructor del interprete con una etapa como argumento
	 */
	public InterpretePush(Etapa e) {
       this.etapa = e; 
       this.iExpresiones = new InterpreteExpresiones();
    }
	/**
	 * Inicia la ejecución del programa
	 */
    public final void inicia() {
    	this.ejecuta(this.etapa);
    	if (this.etapa.tieneContinuaciones()) {
    		this.interactua(this.etapa.continuaciones(), this.etapa.numContinuaciones());
    		this.transita();
    	}
    	else{
    		this.finaliza();
    	}
    }
    /**
     * Hace que la aplicación interaccione con el usuario
     */
    public abstract void transita();
    /**
     * Ejecuta la etapa e
     * @param e - Etapa
     */
    protected abstract void ejecuta(Etapa e);
    /**
     * Ejecuta la siguiente Continuacion de la Etapa
     * @param array - ArrayList de Continuacion
     */
    protected abstract void interactua(Continuacion[] array, int n);
    /**
     * Lee la opcion del usuario y devuelve la opcion seleccionada
     * @param numOp - Numero de opciones
     * @return Un entero con la opcion elegida
     */
    protected abstract int leeOpcion(int numOp);
    /**
     * Finaliza la ejecucion del programa
     */
    protected abstract void finaliza();


}
