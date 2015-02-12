/**
 * Es un controlador que se utiliza cuando se lanza la aplicación con una interfaz gráfica.
 * Es el que se encarga de iniciar el RobotEngine y realizar las acciones del robot por la
 * ventana gráfica.
 */
package tp.pr5.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.EventObject;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tp.pr5.Controller;
import tp.pr5.Interpreter;
import tp.pr5.NavigationObserver;
import tp.pr5.RobotEngine;
import tp.pr5.RobotEngineObserver;
import tp.pr5.instructions.Instruction;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.InventoryObserver;
import tp.pr5.utilidades.Botones;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class GUIController extends Controller implements ActionListener, FocusListener {
	private String direction;
	private String item;
	private NavigationPanel navigationPanel;

	/**
	 * Constructora con un parámetro que inicializa el controlador con el modelo
	 * @param robot - RobotEngine que va a ser el modelo
	 */
	public GUIController(RobotEngine robot){
		super(robot);
		this.direction="left";
		this.item="";

	}
	
	/**
	 * Método encargado de decirle al robot que empieze el juego
	 */
	@Override
	public void startController() {
		robot.requestStart();
		
	}
	
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del modulo de navegacion del modelo
	 */
	public void registerEngineObserver(NavigationObserver observer){
		this.robot.addNavigationObserver(observer);
	}
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del inventario del robot
	 */
	public void registerItemContainerObserver(InventoryObserver observer){
		this.robot.addItemContainerObserver(observer);
	}
	@Override
	/**
	 * Se encarga de decirle al robot que añada un observador a su lista de vistas
	 * @param observer - Observador del robot
	 */
	public void registerRobotObserver(RobotEngineObserver observer){
		this.robot.addEngineObserver(observer);
	}
	/**
	 * Método que recibe los eventos generados por la vista y los trata. En el caso de que se
	 * haya pulsado un botón, ejecutará la instruccion que haga falta, mandandole el string
	 * a la función ejecutaInstruccion(string). Si se trata de un evento producido por un
	 * campo de texto o por la tabla de objetos del robot, la función guardará el id del objeto
	 * en el atributo de la clase "item". También tratará los eventos producidos al tocar una placeCell
	 * que ya haya sido visitada; en este caso, le dira al modulo de navegación del modelo que escanee
	 * el lugar. Por último comprobará si se ha terminado el juego y le dirá a los observadores del
	 * robot que terminen el juego.
	 * @param fuente - Evento generado por la vista, y que tiene que tratar
	 */
	private void cambiarModelo(Component fuente) {
		//Intrucciones del InstructionPanel
		if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_MOVE_BUTTON)) {
			this.ejecutaInstruccion("move");
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_QUIT_BUTTON)) {
        	this.ejecutaInstruccion("quit");
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_TURN_BUTTON)) {
        	this.ejecutaInstruccion("turn " + this.direction);
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_PICK_BUTTON)) {
        	this.ejecutaInstruccion("pick " + this.item);
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_DROP_BUTTON)) {
        	this.ejecutaInstruccion("drop " + this.item);
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_OPERATE_BUTTON)) {
        	this.ejecutaInstruccion("operate " + this.item);
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_CAMPO_OBJETO)) {
        	JTextField campo=(JTextField)fuente;
        	this.item = (String) campo.getText();
        }else if(fuente.getName().equals(Botones.INSTRUCTIONPANEL_COMBO_DIRECCION)) {
			@SuppressWarnings("unchecked")
			JComboBox<String> campo=(JComboBox<String>)fuente;
        	this.direction = (String) campo.getSelectedItem();
        }
		//Instrucciones del RobotPanel
        else if(fuente.getName().equals(Botones.ROBOTPANEL_TABLA)){
        	JTable tabla = (JTable)fuente;
        	DefaultTableModel tm = (DefaultTableModel) tabla.getModel(); 
        	String dato=String.valueOf(tm.getValueAt(tabla.getSelectedRow(),0));
        	this.item = dato;
        }
		 //Instrucciones del Menu
        else if(fuente.getName().equals(Botones.MENU_QUIT)){
        	this.ejecutaInstruccion("quit");
        	
        }else if(fuente.getName().equals(Botones.NAVIGATIONPANEL_PLACECELL)) {
        	PlaceCell campo=(PlaceCell)fuente;
        	if(campo.estaVisitado()){
        		this.navigationPanel.placeScanned(campo.placeInfo());
        	}
        		
        }
		
       
 		//Comprueba si se ha terminado el juego
		if(this.robot.getFuel()==0){
			Iterator<RobotEngineObserver> it1 = this.robot.iterator();
			while(it1.hasNext()){
				it1.next().engineOff(false);
			}
			System.exit(0);
		}else if(robot.isOver()){
			Iterator<RobotEngineObserver> it2 = this.robot.iterator();
			while(it2.hasNext()){
				it2.next().engineOff(true);
			}
			System.exit(0);
		}
		
		
	}
	/**
	 * Método que le manda al robot ejecutar una accion representada por un determinado string
	 * @param line - String que representa la accion que tiene que realizar el robot
	 */
	void ejecutaInstruccion(String line){
		try{
			Instruction i = Interpreter.generateInstruction(line);
			this.robot.communicateRobot(i);
		}catch(WrongInstructionFormatException e){
			
		}
	}
	/**
	 * Trata cualquier evento generado por la vista y cambia el modelo (Ver funcion cambiarModelo(Component))
	 * @param event
	 */
	private void trataEventoGenerico(EventObject event){
        Component fuente = (Component) event.getSource(); 
		//System.err.println(fuente.getName());
        cambiarModelo(fuente);
	}

	@Override
	/** Si se descomenta el código de la función, mandará por la salida de error un mensaje
	 * informando de que componente a tenido el evento. Son eventos producidos por ganar el focus
	 * @param arg0 - Evento producido tras seleccionar un campo de texto
	 */
	public void focusGained(FocusEvent arg0) {
		//System.err.println("focusGained: "+ ((Component) arg0.getSource()).getName());
		
	}
	@Override
	/**
	 * Si se descomenta el código de la función mandarña por la salida de error un mensaje
	 * informando de que componente ha tenido el evento. Además llamará a otra función para que trate 
	 * el evento como si fuera genérico. Son eventos producidos por perder el focus
	 */
	public void focusLost(FocusEvent arg0) {
		//System.err.print("focusLost: ");
        trataEventoGenerico(arg0);
		
	}
	@Override
	/**
	 * Si se descomenta el código de la función mandarña por la salida de error un mensaje
	 * informando de que componente ha tenido el evento. Además llamará a otra función para que trate 
	 * el evento como si fuera genérico. Son eventos por tocar cualquier botón
	 */
	public void actionPerformed(ActionEvent arg0) {
		//System.err.print("actionPerformed: ");
        trataEventoGenerico(arg0);
		
	}
	/**
	 * Inicializa el navigationPanel para que el controlador pueda actualizarlo
	 * @param nav - navigationPanel que el controlador se encargará de actualizar
	 */
	public void setNavigationPanel(NavigationPanel nav){
		this.navigationPanel = nav;
	}

}
