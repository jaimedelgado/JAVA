/**
 * Esta clase se encarga del panel que muestra la informacion acerca de la posicion del robot y de la
 * ciudad en la que se encuentra y está atravesando. Contiene el grid que representa la ciudad en la interfaz Swing,
 * un área de texto donde se muestra la informacion y descripcion del lugar y un label con un icono que representa
 * al robot y la direccion a la que mira.
 * El grid de 11x11 contiene objetos del tipo PlaceCell, y el primer lugar en el que empieza el robot al iniciar la aplicacion
 * es la posicion 5x5. Este panel se ira actualizando a medida que se vayan visitando nuevos sitios en los momentos en los que el
 * robot se mueva de un sitio a otro. Ademas mostrara la descripcion del lugar en un area de texto si el usuario clickea en
 * otra casilla, aunque el robot no se encuentre ahí. Para que esto suceda, dicha casilla ya ha tenido que ser visitada previamente.
 */
package tp.pr5.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr5.Direction;
import tp.pr5.NavigationObserver;
import tp.pr5.PlaceInfo;
import tp.pr5.utilidades.Botones;
import tp.pr5.utilidades.Texts;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
@SuppressWarnings("serial")
public class NavigationPanel extends JPanel implements NavigationObserver{
	private GUIController controlador;
	
	private static final int NUM_FILAS = 11;
	private static final int NUM_COLUMNAS = 11;
	
	private JPanel ventanaBotones;
	private PlaceCell[][] botones;
	private JLabel walle;
	private JTextArea info;
	private JPanel log;
	
	private int filaAct;
	private int colAct;

	
	/**
	 * Constructora que inicializa el navigation panel con una referencia al controlador de la GUI
	 * y registra sus observadores en el controlador
	 * @param controller - controlador de la GUI
	 */
	public NavigationPanel(GUIController controller){
		this.controlador = controller;
		this.controlador.registerEngineObserver(this);
		inicializa();
	}
	
	/**
	 * Inicializa el Navigation Panel. Pone una imagen de walle mirando al norte en la izquierda,
	 * inicializa una ventana de botones en la derecha (Los placeCell todavia no tienen ningun lugar 
	 * inicializado, hay que inicializarlos despues cuando te muevas), y el log, que muestra la informacion
	 * de los lugares y los objetos que tienen, en la parte de abajo.
	 */
	public void inicializa() {
		
		this.filaAct = 5;
		this.colAct = 5;

		this.botones = new PlaceCell[11][11];
		
		this.walle = new JLabel(new ImageIcon("src/tp/pr5/gui/images/walleNorth.png"), JLabel.CENTER);
		this.walle.setName(Botones.NAVIGATIONPANEL_WALLE);
		
		this.ventanaBotones = new JPanel();
		this.ventanaBotones.setLayout(new GridLayout(11,11,0,0));
		this.add(this.walle);
		for(int i=0; i<NUM_FILAS; i++){
			for(int j=0; j<NUM_COLUMNAS; j++){
				this.botones[i][j] = new PlaceCell();
				this.botones[i][j].setName(Botones.NAVIGATIONPANEL_PLACECELL);
				this.ventanaBotones.add(this.botones[i][j]);
			}
		}
		
		this.ventanaBotones.setBorder(new TitledBorder(Texts.CITY_MAP));
		this.ventanaBotones.setPreferredSize(new Dimension(180,280));
		//this.ventanaBotones.setName(Botones.NAVIGATIONPANEL_BOTONES);
		
		this.info = new JTextArea(5,30);
		this.info.setEditable(false);
		JScrollPane sp = new JScrollPane(info);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.log = new JPanel();
		this.log.add(sp, BorderLayout.CENTER);
		this.log.setLayout(new GridLayout());
		this.log.setBorder(new TitledBorder(Texts.LOG));
		this.log.setName(Botones.NAVIGATIONPANEL_LOG);
		
		this.setLayout(new BorderLayout());
		this.add(this.walle, BorderLayout.WEST);
		this.add(this.ventanaBotones, BorderLayout.CENTER);
		this.add(log, BorderLayout.SOUTH);
		
		
	}

	/**
	 * Informa de que el robot ha llegado a un lugar. Actualiza la fila y la columna de la celda
	 * en la que estas, inicializa la información del lugar en el que se encuentra ahora, 
	 * y le dice a la celda que se actualize poniendose verde y mostrando su informacion.
	 * @param heading - La direccion en el movimiento del robot
	 * @param place - El lugar al que llega el robot
	 */
	public void robotArrivesAtPlace(Direction heading, PlaceInfo place){
		this.botones[this.filaAct][this.colAct].visitaLugar(false, place);
		if(heading==Direction.NORTH){
			this.filaAct--;
		}else if(heading==Direction.EAST){
			this.colAct++;
		}else if(heading==Direction.SOUTH){
			this.filaAct++;
		}else if(heading==Direction.WEST){
			this.colAct--;
		}
		this.botones[this.filaAct][this.colAct].setPlaceInfo(place);
		this.botones[this.filaAct][this.colAct].visitaLugar(true, place);
	}
	
	
	
	/**
	 * Informa de que el modulo de navegacion ha sido inicializado.
	 * @param initialPlace - El lugar donde el robot empieza la simulacion
	 * @param heading - La direccion inicial a la que 'apunta' el robot
	 */
	public void initNavigationModule(PlaceInfo initialPlace, Direction heading) {
		this.placeScanned(initialPlace);
		this.headingChanged(heading);
		this.botones[this.filaAct][this.colAct].setPlaceInfo(initialPlace);
		this.botones[this.filaAct][this.colAct].visitaLugar(true, initialPlace);
		
	}
	
	
	/**
	 * Informa que la direccion a la que apunta el robot ha cambiado.
	 * @param newHeading - La nueva direccion a la que mira el robot
	 */
	public void headingChanged(Direction newHeading) {
		if(newHeading==Direction.NORTH){
			walle.setIcon(new ImageIcon("src/tp/pr5/gui/images/walleNorth.png"));
		}else if(newHeading==Direction.SOUTH){
			walle.setIcon(new ImageIcon("src/tp/pr5/gui/images/walleSouth.png"));
		}else if(newHeading==Direction.EAST){
			walle.setIcon(new ImageIcon("src/tp/pr5/gui/images/walleEast.png"));
		}else if(newHeading==Direction.WEST){
			walle.setIcon(new ImageIcon("src/tp/pr5/gui/images/walleWest.png"));
		}
	}

	
	/**
	 * Informa que el usuario a solicitado una instruccion del tipo 'RADAR' t lo muestra
	 * en el log
	 * @param placeDescription - Informacion sobre el lugar actual.
	 */
	public void placeScanned(PlaceInfo placeDescription) {
		this.info.setText(placeDescription.toString());
		
	}


	/**
	 * Informa que el lugar en el que está el robot ha cambiado (porque el robot ha cogido o 
	 * soltado algun objeto). Llama a placeScaned para que muestre la informacion del lugar por el log.
	 * @param placeDescription - Informacion sobre el lugar actual.
	 */
	public void placeHasChanged(PlaceInfo placeDescription) {
		placeScanned(placeDescription);
	}

	/**
	 * Fija los controladores a las celdas para que cuando sean pulsadas, el controlador pueda tratar el evento.
	 */
	public void fijarControlador(EventListener controlador) {
		for(int i=0; i<NUM_FILAS; i++){
			for(int j=0; j<NUM_COLUMNAS; j++){
				this.botones[i][j].addActionListener((ActionListener)controlador);
			}
		}
		
	}
}
