/**
 * Clase que implementa todas las funciones específicas del interprete en modo gráfico.
 * Esta clase cuenta con un array de botones que se mostrarán en la interfaz para representar
 * las posibles continuaciones que puede elegir el usuario, una foto del recurso que tiene la etapa que
 * se esta mostrando en la interfaz, y una descripción de la foto. Ademas cuenta con 
 * la etapa principal que hereda de la clase padre y que sirve como unión del Interprete con el modelo semántico.
 * El único método público que tiene es muestraInterfazGrafica(), que inicia la ejecución del
 * interprete en modo gráfico.
 */
package interpretePull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modelo.Continuacion;
import modelo.Etapa;
/**
 * @author Jaime Delgado Linares
 *
 */
public class InterpretePullGUI extends InterpretePull {
	private JButton[] botones;
	private int numBotones;
	private JLabel foto;
	private JLabel descripcionFoto;
	public JFrame frame;
	private int opcion;
	
	
	private class OyenteInteraccion implements ActionListener{
		/**
		 * Esta clase implementa un oyente de interacciones del usuario en modo gráfico.
		 * Cuenta con un atributo texto, que sirve para actualizar el texto de los botones
		 * segun vayan produciendose eventos, y un entero que sirve para saber que opción ha
		 * elegido el usuario
		 */
	    @SuppressWarnings("unused")
		private String texto;
	       private int o;
	       /**
	        * Constructor del oyente. Recibe un String "t" y un entero "opc" que representa la opción del botón
	        * @param t - Texto del botón	
	        * @param opc - opcion del boton
	        */
	       public OyenteInteraccion(String t, int opc) {
	         this.texto = t;  
	         this.o=opc;
	       }
	       /**
	        * Hace que la interfaz grafica cambie cuando el usuario interaccione con ella. Escucha el evento e
	        * @param e - Evento que hay que escuchar
	        */
	        @Override
	       public void actionPerformed(ActionEvent e) {
	         opcion = o;
	         transita();
	       }
	}
	
	/**
	 * Constructor que recibe la etapa que quieres mandar al interprete en modo grafico.
	 * Llama a la función inicializa() para que coloque todos los elementos de la interfaz gráfica.
	 * @param e = Etapa principal que va a usar el interprete
	 */
	public InterpretePullGUI(Etapa e) {
		super(e);
		initializa();
	}


	/**
	 * Coloca todos los componentes de la interfaz gráfica: Tantos botones como continuaciones tenga la etapa,
	 * una foto que representa la imagen del recurso de la etapa, y un texto con la descripción de la imagen
	 * debajo de la imagen.
	 */
	private void initializa() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Pongo la correspondiente foto
		this.foto = new JLabel(new ImageIcon("src\\fotos\\" + this.etapa.recurso().imagen()));
		this.foto.setHorizontalAlignment(SwingConstants.CENTER);
		this.foto.setBounds(125, 11, 299, 125);
		frame.getContentPane().add(this.foto);
		
		//Pongo la correspondiente descripcion
		this.descripcionFoto = new JLabel(this.etapa.recurso().descripcion());
		this.descripcionFoto.setHorizontalAlignment(SwingConstants.CENTER);
		this.descripcionFoto.setBounds(125, 173, 299, 77);
		frame.getContentPane().add(this.descripcionFoto);
		this.frame.setVisible(true);
		
	}
	/**
	 * Actualiza los componentes de la interfaz gráfica de acuerdo a la etapa "e"
	 * @param e - Etapa que vas a ejecutar
	 */
	@Override
	protected void ejecuta(Etapa e) {
			//Pongo la correspondiente foto
			this.foto.setIcon(new ImageIcon("src\\fotos\\" + this.etapa.recurso().imagen()));
			this.foto.setHorizontalAlignment(SwingConstants.CENTER);
			this.foto.setBounds(150, 20, 299, 125);
			frame.getContentPane().add(this.foto);
			
			//Pongo la correspondiente descripcion
			this.descripcionFoto.setText(this.etapa.recurso().descripcion());
			this.descripcionFoto.setHorizontalAlignment(SwingConstants.CENTER);
			this.descripcionFoto.setBounds(125, 173, 299, 77);
			frame.getContentPane().add(this.descripcionFoto);

			this.interactua(this.etapa.continuaciones(), this.etapa.numContinuaciones());
	}
	/**
	 * Muestra al usuario los botones con las posibles continuaciones que tiene la etapa
	 * @param array - Array de continuaciones posibles de la etapa
	 * @param n - Numero de continuaciones que tiene la etapa
	 */
	@Override
	protected void interactua(Continuacion[] array, int n) {
		this.limpiaBotones();
		this.botones = new JButton[n];
		for(int i=1; i<=n; i++){
			this.botones[i-1] = new JButton("");
			this.botones[i-1].setBounds(10, 11+(34*(i-1)), 150, 23);
			this.botones[i-1].setText(i+"."+array[i-1].texto());
			this.botones[i-1].setName(Integer.toString(i-1));
			this.botones[i-1].addActionListener(new OyenteInteraccion(this.botones[i-1].getText(), 
													Integer.parseInt(this.botones[i-1].getName())));
			frame.getContentPane().add(this.botones[i-1]);
		}
		this.numBotones=n;
	}
	/**
	 * En esta interfaz no se usa esta funcion. 
	 */
	@Override
	protected int leeOpcion(int numOp) {
		return this.opcion;
	}
	/**
	 * Finaliza la aplicación en modo gráfico. Solo muestra por consola un mensaje para que sepas que ha acabado el programa.
	 */
	@Override
	protected void finaliza() {
		System.out.println("Fin finaliza");
		
	}
	/**
	 * Transita por las diferentes etapas de la visita. Actualiza la etapa en la que estamos y vuelve a iniciar el interprete.
	 */
	@Override
	public void transita() {
		this.etapa = this.etapa.continuaciones()[opcion].etapa();
	    this.ejecuta(this.etapa);
		
	}
	/**
	 * Esconde todos los botones que haya en la interfaz gráfica.
	 */
	private void limpiaBotones(){
		for(int i=0; i<numBotones; i++){
			this.botones[i].setVisible(false);
			
		}
	}
}
