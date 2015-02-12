/**
 * RobotPanel muestra informacion sobre el robot y su inventario (contenedor de items).
 * Mas concretamente, contiene las etiquetas que muestra sobre la cantidad de fuel y la
 * cantidad de material reciclado, y una tabla que muestra el inventario
 * del robot. Cada linea muestra informacion sobre cada objeto (item) almacenado en el
 * inventario.
 */
package tp.pr5.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tp.pr5.RobotEngineObserver;
import tp.pr5.items.InventoryObserver;
import tp.pr5.items.Item;
import tp.pr5.utilidades.Botones;
import tp.pr5.utilidades.Texts;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
@SuppressWarnings("serial")
public class RobotPanel extends JPanel implements InventoryObserver, RobotEngineObserver {
	private GUIController controlador;
	
	private JSplitPane panel;
	
	//Componentes del panel de instrucciones
	private JPanel panelInstrucciones;
	
	private JButton move;
	private JButton quit;
	private JButton turn;
	private JButton pick;
	private JButton drop;
	private JButton operate;
	
	private JComboBox<String> comboDireccion;
	private JTextField campoObjeto;
	
	//Componentes del panel que contiene la informacion del robot
	private JPanel panelRobot;
	private JLabel texto;
	private JTable tabla;
	
	/**
	 * Constructora que inicializa el robot panel con una referencia al controlador de la GUI
	 * y añade los observadores al controlador
	 * @param controller - controlador de la GUI
	 */
	public RobotPanel(GUIController controller){
		this.controlador = controller;
		this.controlador.registerRobotObserver(this);
		this.controlador.registerItemContainerObserver(this);
		inicializa();
	}
	/**
	 * Llama al método que inicializa el panel de instrucciones y al que inicializa el panel del robot
	 * y los introduce en un panel redimensionable (JSplitPane)
	 */
	private void inicializa() {
		// Inicializamos los componentes del panel de instrucciones
		this.inicializaPanelInstrucciones();
		// Inicializamos los componentes del panel del robot
		this.inicializaPanelRobot();
		this.panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.panelInstrucciones, this.panelRobot);
		this.add(panel);
		this.setLayout(new GridLayout());
		
	}
	/**
	 * Inicializa panel del robot. Pone un texto indicando el fuel y el material reciclado del robot
	 * en la parte de arriba, y en la parte de abajo una tabla con los objetos que ha ido cogiendo el robot.
	 */
	private void inicializaPanelRobot() {
		this.panelRobot = new JPanel();
		this.panelRobot.setBorder(new TitledBorder(Texts.ROBOT_INFO));
		
		this.texto = new JLabel(
				Texts.FUEL + ": "+ Texts.fuelInicial + " " +
								Texts.RECYCLED + ": "+ Texts.recycledInicial, JLabel.CENTER);
		this.texto.setName(Botones.ROBOTPANEL_TEXTO);

		String[] cabeceras = {Texts.ID, Texts.DESCRIPTION};
		String[][] items = new String[1][1];
		this.tabla = new JTable(new DefaultTableModel(items,cabeceras));
		this.tabla.setPreferredScrollableViewportSize(new Dimension(490, 50));
		this.tabla.setName(Botones.ROBOTPANEL_TABLA);

		this.panelRobot.setLayout(new BorderLayout());
        this.panelRobot.add(BorderLayout.NORTH, texto);
        this.panelRobot.add(BorderLayout.SOUTH, new JScrollPane(tabla));

		
	}
	/**
	 * Inicializa panel de instrucciones. Se trata de un panel con botones que representan todas las acciones
	 * que se pueden realizar en la vista GUI (MOVE, TURN, QUIT, PICK, DROP, OPERATE), asi como un campo
	 * de texto para introducir el objeto que quieres coger, soltar o usar; y un comboBox que te
	 * permite elegir la direccion para girar(Esta direccion comenzará sienfo left y podrás hacer turn
	 * left sin tener que elegir esa opcion)
	 */
	public void inicializaPanelInstrucciones(){
		this.panelInstrucciones = new JPanel();
		this.panelInstrucciones.setBorder(new TitledBorder(Texts.INSTRUCTIONS));
		this.panelInstrucciones.setPreferredSize(new Dimension(200,120));
		
		move = new JButton(Texts.MOVE);
		move.setName(Botones.INSTRUCTIONPANEL_MOVE_BUTTON);
		
		quit = new JButton(Texts.QUIT);
		quit.setName(Botones.INSTRUCTIONPANEL_QUIT_BUTTON);
		
		turn = new JButton(Texts.TURN);
		turn.setName(Botones.INSTRUCTIONPANEL_TURN_BUTTON);
		
		pick = new JButton(Texts.PICK);
		pick.setName(Botones.INSTRUCTIONPANEL_PICK_BUTTON);
		
		drop = new JButton(Texts.DROP);
		drop.setName(Botones.INSTRUCTIONPANEL_DROP_BUTTON);
		
		operate = new JButton(Texts.OPERATE);
		operate.setName(Botones.INSTRUCTIONPANEL_OPERATE_BUTTON);
		
		campoObjeto = new JTextField();
		campoObjeto.setName(Botones.INSTRUCTIONPANEL_CAMPO_OBJETO);
		
		String[] opciones = { Texts.LEFT, Texts.RIGHT };
		comboDireccion = new JComboBox<String>(opciones);
		comboDireccion.setName(Botones.INSTRUCTIONPANEL_COMBO_DIRECCION);
		
		//Colocacion
		LayoutManager thisLayout = new GridLayout(4,2);
        this.panelInstrucciones.setLayout(thisLayout);
        
        //Añado los componentes
        this.panelInstrucciones.add(move);
        this.panelInstrucciones.add(quit);
        this.panelInstrucciones.add(turn);
        this.panelInstrucciones.add(comboDireccion);
        this.panelInstrucciones.add(pick);
        this.panelInstrucciones.add(campoObjeto);
        this.panelInstrucciones.add(drop);
        this.panelInstrucciones.add(operate);
	}
	/**
	 * El motor del robot (RobotEngine) informa sobre la llegada de un evento. No hace nada en este panel
	 * @param msg -  Es el mensaje de error sobre el cual informa.
	 */
	public void raiseError(java.lang.String msg){
		
	}
	
	/**
	 * El motor del robot (RobotEngine) informa que la ayuda 'HELP'
	 * ha sido solicitada. No hace nada en este panel
	 * @param help -  Es un string que contiene el mensaje de ayuda.
	 */
	public void communicationHelp(java.lang.String help){
		
	}
	
	/**
	 * El motor del robot (RobotEngine) informa de que el robot
	 * se ha apagado (bien porque el robot haya llegado a la nave
	 * espacial o porque el robot se haya quedado sin fuel). No ahce nada en este panel
	 * @param atShip - Devuelve true si el robot se ha apagado porque haya llegado
	 * a la nave espacial y false si se ha quedado sin fuel.
	 */
	public void engineOff(boolean atShip){
		
	}
	
	/**
	 * El motor del robot (RobotEngine) informa que la comunicacion
	 * ha terminado. No hace nada en este panel
	 */
	public void communicationCompleted(){
		
	}
	
	/**
	 * El motor del robot (RobotEngine) informa de que el fuel y/o la cantidad
	 * de material reciclado ha cambiado y actualiza el campo de texto del panel del robot
	 * @param fuel - Cantidad actual de fuel que le queda al robot
	 * @param recycledMaterial - Cantidad actual de material reciclado que lleva el robot. 
	 */
	public void robotUpdate(int fuel, int recycledMaterial){
		this.texto.setText(Texts.FUEL + ": "+ fuel + " " +
								Texts.RECYCLED + ": "+ recycledMaterial);
		this.texto.setLayout(new GridLayout());
	}
	
	/**
	 * Informa de que el contenedor ha cambiado y actualiza la tabla de los objetos
	 * @param inventory -  el nuevo inventario
	 */
	public void inventoryChange(java.util.List<Item> inventory){
		int numItems = 0;
		String[] cabeceras = {Texts.ID, Texts.DESCRIPTION};
		String[][] items = new String[inventory.size()][2];
		Iterator<Item> it = inventory.iterator();
		while(it.hasNext()){
			Item aux = it.next();
			items[numItems][0] = aux.getId();
			items[numItems][1] = aux.getDescription();
			numItems++;
		}
		this.tabla.setModel(new DefaultTableModel(items,cabeceras));
	}
	
	/**
	 * Informa que el usuario solicita realizar una instruccion del tipo
	 * 'SCAN' sobre el inventario. No hace nada en este panel
	 * @param collectionDescription - Contiene la informacion sobre el inventario.
	 */
	public void inventoryScanned(java.lang.String collectionDescription){
		
	}
	
	/**
	 * Informa que el usuario quiere realizar una instruccion del tipo
	 * 'SCAN' en un objeto concreto que se encuentra en el inventario de objetos
	 * (contenedor de items). No hace nada en este panel
	 * @param description - Es la descripcion del elemento a scannear
	 */
	public void itemScanned(java.lang.String description){
		
	}
	
	/**
	 * Informa que un item del contenedor esta vacio (es decir, el numero de veces que
	 * puede ser usado ha llegado a 0 y por lo tanto no se puede usar mas veces), y que
	 * tiene que ser eliminado del contenedor de objetos. No hace nada en este panel.
	 * @param itemName - Es el nombre del item que esta vacio y que hay que eliminar.
	 */
	public void itemEmpty(java.lang.String itemName){
		
	}
	
	/**
	 * El motor del robot (RobotEngine) informa de que el robot quiere decir algo.
	 * No hace nada en este panel.
	 * @param message - Es un string que contiene el mensaje que quiere transmitir el robot.
	 */
	public void robotSays(java.lang.String message){
		
	}
	/**
	 * Añade todos los controladores a los botones para que el controlador pueda tratar sus eventos.
	 */
	public void fijarControlador(EventListener controlador) {
		this.tabla.addFocusListener((FocusListener)controlador);
		move.addActionListener((ActionListener)controlador);
		quit.addActionListener((ActionListener)controlador);
		turn.addActionListener((ActionListener)controlador);
		pick.addActionListener((ActionListener)controlador);
		drop.addActionListener((ActionListener)controlador);
		operate.addActionListener((ActionListener)controlador);
		campoObjeto.addActionListener((ActionListener)controlador);
		comboDireccion.addActionListener((ActionListener)controlador);
		
		campoObjeto.addFocusListener((FocusListener)controlador);
	}
}
