/**
 * Clase general de Interprete que tiene todas las funciones que van a ser comunes tanto para el interprete en modo consola
 * como para el interprete en modo gráfico. 
 * Tiene como atributo la etapa principal que va a ejecutar, y que sirve como unión del Interprete con el modelo semántico.
 * El único método que no tiene abstracto porque es común a todos los tipos de Interprete es el metodo inicia()
 */
package interpretePull;

import interpreteExpresiones.InterpreteExpresiones;
import modelo.Continuacion;
import modelo.Etapa;
import modelo.Visita;
import expresiones.Procesamiento;
/**
 * @author Jaime Delgado Linares
 *
 */
public abstract class InterpretePull extends Procesamiento {
	public static final String LINE_SEPARATOR = System.getProperty( "line.separator" );
	protected InterpreteExpresiones iExpresiones;
	protected Etapa etapa;
	
	
	/**
	 * Constructor del interprete con una etapa como argumento
	 */
	public InterpretePull(Etapa e) {
       this.etapa = e; 
       this.iExpresiones = new InterpreteExpresiones();
    }
	public InterpretePull(Visita v){
		this.etapa=v.etapaInicial();
		this.iExpresiones = new InterpreteExpresiones();
		v.expresion().acepta(this.iExpresiones);
		v.add(null, etapa);
	}
	/**
	 * Inicia la ejecución del programa
	 */
    public final void inicia() {
    	this.interactua(etapa.continuaciones(), etapa.numContinuaciones());
	  
    }
    /**
     * Hace que la aplicación interaccione con el usuario
     */
    public abstract void transita();
    /**
     * Ejecuta la etapa e
     * @param e - Etapa
     * 
     */
    protected abstract void ejecuta(Etapa e);
    /**
     * Muestra las posibles continuaciones e interactura con el usuario
     * @param array
     * @param n
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
