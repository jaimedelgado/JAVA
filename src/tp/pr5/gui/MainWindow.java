/**
 * Esta clase crea la ventana de la interfaz Swing. 
 * El MainWindow contiene los siguientes componentes:
 * --Un menú con la acción QUIT
 * --Un panel de acción con varios botones para realizar MOVE, TURN, OPERATE, PICK, y DROP.
 * --Adicionalmente tiene un cuadro combinado de giro rotaciones y un campo de texto para escribir el
 * nombre del elemento que el robot quiere elegir el lugar actual
 * --Un RobotPanel que muestra la información del robot (material de combustible y reciclado) y
 * el inventario de robot, que muestra una tabla con los nombres de los elementos y 
 * las descripciones que el robot lleva. El usuario puede seleccionar los elementos que
 * figuran en el inventario con el fin de dejar u operar un artículo
 * --Un NavigationPanel que representa la ciudad. Se muestran los lugares que el robot ha visitado
 * y un icono que representa la direccion robot. La direccion del robot se actualiza 
 * cuando el usuario realiza una acción TURN. Los lugares visibles se actualizan cuando 
 * el robot realiza una acción de movimiento. Una vez que el lugar es visitado, 
 * el usuario puede hacer clic en él con el fin de mostrar la descripción del lugar (similar 
 * al comando RADAR).
 * --Un Panel de información que muestra información sobre los diferentes eventos que se 
 * producen durante el juego
 */
package tp.pr5.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import tp.pr5.RobotEngineObserver;
import tp.pr5.utilidades.Botones;
import tp.pr5.utilidades.Texts;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements RobotEngineObserver {
	private GUIController controlador;
	private InfoPanel infoPanel;
	private NavigationPanel navigationPanel;
	private RobotPanel robotPanel;

	private JMenuItem quitMenu;
	private JMenu menu;
	private JMenuBar menuBar;
	
	/**
	 * Constructor que inicializa el controlador de la vista y registra sus observadores
	 * en el controlador
	 * @param gameController - Controlador de la vista
	 */
	public MainWindow(GUIController gameController){
		super(Texts.TITULO_MAIN_WINDOW);
		
		this.controlador = gameController;
		this.controlador.registerRobotObserver(this);	
		this.infoPanel = new InfoPanel(gameController);
		this.navigationPanel = new NavigationPanel(gameController);
		this.robotPanel = new RobotPanel(gameController);
		inicializa();
		gameController.setNavigationPanel(this.navigationPanel);
		fijarControlador(gameController);
	}
	/**
	 * Fija los controladores a todos los componentes que lo necesiten
	 * @param controlador - Controlador de cualquier evento (actionlistener, focuslistener..)
	 */
	public void fijarControlador(EventListener controlador) {
		this.quitMenu.addActionListener((ActionListener)controlador);
	    this.navigationPanel.fijarControlador(controlador);
	    this.robotPanel.fijarControlador(controlador);
	   
		
	}
	/**
	 * Inicializa la ventana principal. Introduce arriba un robotPanel, en el centro un NavigationPanel
	 * y en el sur un infoPanel.
	 */
	public void inicializa() {
		
		this.setSize(3*320, 340);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		this.menu = new JMenu("File");
		this.quitMenu = new JMenuItem("QUIT");
		this.quitMenu.setName(Botones.MENU_QUIT);
		this.menu.add(this.quitMenu);
        this.menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
	    this.menuBar.add(menu);
	    
		this.add(this.robotPanel, BorderLayout.NORTH);
		this.add(this.navigationPanel, BorderLayout.CENTER);
		this.add(this.infoPanel, BorderLayout.SOUTH);
       
        this.pack();
	}
	/**
	 * Informa a todos los componentes de que la comunicación ha terminado y cierra la ventana grafica
	 */
	public void communicationCompleted() {
		this.infoPanel.communicationCompleted();
		this.robotPanel.communicationCompleted();
		this.dispose();
	}
	/**
	 * Informa de la instruccion HELP a todos los componentes que tengan que hacer algo (InfoPanel y robotPanel)
	 * @param help - String con la información de HELP
	 */
	public void communicationHelp(String help) {
		this.infoPanel.communicationHelp(help);
		this.robotPanel.communicationHelp(help);
	}
	/**
	 * Informa que el robot se ha apagado porque no le queda
	 * combustible o porque ha llegado a la nace espacial, en una ventana emergente
	 * @param atShip - boolean que indica si el robot ha llegado a la nave espacial
	 */
	public void engineOff(boolean atShip) {
		this.infoPanel.engineOff(atShip);
		if(atShip){
			JOptionPane.showMessageDialog( null,Texts.ERROR_SPACESHIP);
		}else{
			JOptionPane.showMessageDialog( null, Texts.ERROR_FUEL_EMPTY);
		}
	}
	/**
	 *Informa de que ha habido un error a los componentes que tengan que hacer algo (InfoPanel y robotPanel)
	 * @param msg - String con un mensaje de error del robot
	 */
	public void raiseError(String msg) {
		this.infoPanel.raiseError(msg);
		this.robotPanel.raiseError(msg);
	}
	/**
	 * Informa de que el robot quiere decir algo a los componentes que tengan que hacer algo (InfoPanel y robotPanel)
	 * @param message - String con el mensaje que quiere decir el robot
	 */
	public void robotSays(java.lang.String message) {
		this.infoPanel.robotSays(message);
		this.robotPanel.robotSays(message);
	}
	/**
	 * Informa a los componentes que tengan que hacer algo (InfoPanel y robotPanel)
	 * de que el fuel o el material reciclado del robot ha cambiado
	 * @param fuel - int con el fuel que tiene ahora el robot
	 * @param recycledMaterial - int con el material reciclado que tiene ahora el robot
	 */
	public void robotUpdate(int fuel, int recycledMaterial) {
		this.infoPanel.robotUpdate(fuel, recycledMaterial);
		this.robotPanel.robotUpdate(fuel, recycledMaterial);
	}
	/**
	 * Hace visible la aplicacion por GUI
	 */
	public void arranca() {
		EventQueue.invokeLater(new Runnable(){
        	public void run() {
        		setVisible(true);
        	}
        });	
		
	}
	
}
