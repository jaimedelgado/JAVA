/**
 * Esta clase se encarga de las funciones de navegación del robot.
 * Contiene la ciudad donde el robot busca la basura, el lugar actual donde esta,
 * y su dirección actual. Contiene métodos para manejar los diferentes
 * movimientos del robot y para recoger y soltar elementos en el lugar actual.
 */
package tp.pr5;


import java.util.Iterator;

import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.items.Item;


/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class NavigationModule extends Observable<NavigationObserver>{
	private City city;
	private Place initialPlace;
	private Direction direction;
	
	//private boolean consola;
	
	//Constructors
	/**
	 * Crea un Navigation module con una City y un initialPlace específicos
	 * @param aCity
	 * @param initialPlace
	 */
	public NavigationModule(City aCity, Place initialPlace){
		this.city = aCity;
		this.initialPlace = initialPlace;
		this.direction = Direction.NORTH;
	}
	
	//Methods
	

	/**
	 * Comprueba si el lugar en el que esta el robot es una nave espacial
	 * @return true si el robot esta en una nave espacial, false en caso contrario
	 */
	public boolean atSpaceship(){
		return this.initialPlace.isSpaceship();
	}
	
	/**
	 * Actualiza la direccion del robot segun una Rotation dada. Por ejemplo, si el robot
	 * estaba mirando hacia el norte y la rotación es "izquierda", mirará hacia el oeste.
	 * @param rotation - Rotation que marca hacia donde tiene que rotar el robot
	 */
	public void rotate(Rotation rotation){
		this.direction = Rotation.rotate(this.direction, rotation);
	}

	/**
	 * Método que intenta mover al robot la direccion en la que esta mirando. 
	 * Si el movimiento no se puede realizar porque no hay ninguna calle en frente, 
	 * o la calle esta cerrada, entonces lanzará una excepcion. Sino, el lugar actual
	 * se actualizará según el movimiento 
	 * @throws InstructionExecutionException (Si no se puede mover)
	 */
	public void move() throws InstructionExecutionException{		
		Street street = this.city.lookForStreet(this.initialPlace, this.direction);
		if(street==null || !street.isOpen()){
			throw new InstructionExecutionException();
		}
		this.initialPlace = street.nextPlace(this.initialPlace);

		Iterator<NavigationObserver> it = this.iterator();
		while(it.hasNext()){
			NavigationObserver observer = it.next();
			observer.placeHasChanged(this.initialPlace);
			observer.robotArrivesAtPlace(this.direction, this.initialPlace);
		}
	}
	
	/**
	 * Método que intenta coger un objeto con el nombre del string que recibe por parámetro.
	 * Si la accion es posible, el objeto será eliminado del lugar actual
	 * @param id - String con el nombre del objeto a coger
	 * @return un Item con el Id que le metan a la función
	 */
	public Item pickItemFromCurrentPlace(String id){
		
		Item item=null;
		if(this.initialPlace.existItem(id)){
			item = this.initialPlace.pickItem(id);
		}
		return item;
	}
	
	
	/**
	 * Método que suelta un objeto en el lugar actual. 
	 * Assume que no hay ningun otro objeto con el mismo id en el lugar.
	 * En otro caso, su comportamiento se encuentra indefinido
	 * @param it
	 */
	public void dropItemAtCurrentPlace(Item it){
		this.initialPlace.addItem(it);
	}
	
	/**	Método que busca si hay algún objeto en el lugar actual, con el Id que le pasan como parámetro
	 * @param id - String con el nombre del objeto a buscar
	 * @return true si hay un objeto con ese nombre en el lugar, false en otro caso 
	 */
	public boolean findItemAtCurrentPlace(String id){
		return this.initialPlace.existItem(id);
	}
	
	/**
	 * Inicializa la dirección a la que esta mirando el robot según su parametro
	 * @param heading - Direction a la que quieres que mire el robot
	 */
	public void initHeading(Direction heading){
		this.direction=heading;
		Iterator<NavigationObserver> it = this.iterator();
		while(it.hasNext()){
			it.next().headingChanged(this.direction);
		}
	}
	
	
	/**
	 * Devuelve la informacion del lugar en el que esta el robot
	 */
	public void scanCurrentPlace(){ 
		Iterator<NavigationObserver> it = this.iterator();
		while(it.hasNext()){
			it.next().placeScanned(this.initialPlace);
		}
		
	}
	
	/** Devuelve la calle a la que está mirando el robot. Null si no hay ninguna
	 * @return la Street a la que esta mirando el robot
	 */
	public Street getHeadingStreet(){
		return this.city.lookForStreet(this.initialPlace, this.direction);
	}
	
	/** Devuelve la direccion a la que esta mirando el robot
	 * @return - La Direction a la que esta mirando el robot
	 */
	public Direction getCurrentHeading(){
		return this.direction;
	}
	
	/** Devuelve el lugar en el que esta el robot
	 * @return el Place en el que se encuentra el robot
	 */
	public Place getCurrentPlace(){
		return this.initialPlace;
	}
	/**
	 * Cambia la direccion a la que esta mirando el robot
	 * @param dir - direccion a la que quieres que mire el robot
	 */
	public void setDirection(Direction dir){
		this.direction = dir;
	}
	/**
	 * Función usada para que el robot busque la salida automáticamente. Devuelve un booleano
	 * que indica si el lugar ha sido visitado
	 * @return
	 */
	public boolean estaVisitadoAct() {
		return this.initialPlace.estaVisitado();
	}
	/**
	 * Función usada para que el robot busque la salida automáticamente. Pone el atributo "visitado" 
	 * del lugar al valor que tenga el parámetro de la función
	 * @param v
	 */
	public void visitaAct(boolean v){
		this.initialPlace.visita(v);
	}
	
}
