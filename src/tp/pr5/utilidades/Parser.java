package tp.pr5.utilidades;

import java.io.FileInputStream;
/**
 * Clase que sirve para parsear los argumentos del main y ejecuta un programa que 
 * simula que Walle-E va por una ciudad cogiendo objetos. 
 * El comando -i servirá para elegir la interfaz y se podra elegir console, swing, both
 * El comando -m indicará el archivo que quieres leer.
 * El comando -h mostrará una ayuda con las opciones disponibles
 * El comando -d hará que el robot busqué sólo la salida y la muestre por swing y console. Hay que
 * introducir una cantidad de movimientos max para delimitar la busqueda.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import tp.pr5.City;
import tp.pr5.Direction;
import tp.pr5.RobotEngine;
import tp.pr5.cityLoader.CityLoaderFromTxtFile;
import tp.pr5.console.Console;
import tp.pr5.console.ConsoleController;
import tp.pr5.gui.GUIController;
import tp.pr5.gui.MainWindow;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

public class Parser {
	private InputStream file;
    private boolean console;
    private boolean swing;
    private boolean both;
    private boolean buscaSalida;
    private int maxActions;
    private String mapRoute;
    private City city;
    private CityLoaderFromTxtFile mapaArchivo;
    //Create a parser
    private CommandLineParser parser;
    //Create the options
    private Options options;
    
    /**
     * Constructor que inicializa todos los atributos del parser
     */
	public Parser(){
	    console = false;
	    swing = false;
	    both = false;
	    buscaSalida = false;
	    maxActions = 0;
	    mapRoute = "";
	    city=null;
	    mapaArchivo = new CityLoaderFromTxtFile();
	    //Create a parser
	    parser = new BasicParser();
	    //Create the options
	    options = new Options();
	}
    
	
	public void parsea(String[] args){
		addOptions(options);
        setOptions(options);        
	    //Analyse the args
	    analyse(args);	    
	    //Creates the map
	    readMap();	    
	    //If the map is created, strats the game in the mode that has been specified (console, gui or both)
	    stratGame();
	}
	
	/**
	 * Añade las opciones posibles de la linea de comandos.
	 * @param options - Donde se van a añadir las opciones.
	 */
	public void addOptions (Options options){
		options.addOption("h", "help", false, "Shows this help message");
	    options.addOption("i", "interface", true, "The type of interface: console, swing or both");
	    options.addOption("m", "map", true, "File with the description of the city");
	    options.addOption("d", "max-depth", true, "Max number of allowed actions");		
	}
   
    /**
     * Configura las opciones solicitadas al estado al que le corresponden
     * @param options - Donde se inicializan las opciones
     */
    public void setOptions (Options options){
    	//Set the required of the options        
        options.getOption("h").setRequired(false);
        options.getOption("i").setRequired(true);
        options.getOption("m").setRequired(true);
        options.getOption("d").setRequired(true);

    }
    
    /**
     * Parsea y analiza la instruccion que se encunetra en la linea de comandos.
     * En el caso de que un elemento no coincida con los entendibles para el programa 
     * (help, map, interface o bactracking) lanza una excepcion del tipo ParseException,
     * y en el caso de que ningun argumento coincida con el tipo de interfaz swing o console
     * sacara un mensaje de error: Wrong type of interface
     * @param args - Linea de comandos que hay que parsear y analizar
     */
    public void analyse(String[] args){
    	try{
	    	CommandLine commandLine = parser.parse(options, args);
	    	treatHelp(commandLine);
	    	treatMap(commandLine);
	    	treatInterface(commandLine);
	    }catch(ParseException ex){
	    	boolean errorInterface = true;
	    	for(int i=0; i<args.length; i++){
	    		if(args[i].contains("console") || args[i].contains("swing")){
	    			errorInterface=false;
	    		}
	    	}
	    	if(errorInterface){
	    		System.err.println("Wrong type of interface");
            	System.exit(1);
	    	}
	    	
	    }
    	
    }
    
    /**
     * Trata el comando de ayuda de la linea de comandos, mostrandole un mensaje informativo
     * con ayuda acerca de las asignaciones a los comandos que puede realizar.
     * @param commandLine - Linea de comandos que verifica la validez de los comandos
     */
    public void treatHelp(CommandLine commandLine){
    	if(commandLine.hasOption('h')){
        	String cadena = "Execute this assignment with these parameters:\n" +
        			"usage: tp.pr5.Main [-h] [-i <type>] [-m <mapfile>]\n" +
        			" -h,--help               " + options.getOption("h").getDescription() +"\n"+
                    " -i,--interface <type>   " + options.getOption("i").getDescription() +"\n"+
                    " -m,--map <mapfile>      " + options.getOption("m").getDescription();
            System.out.println(cadena);
            System.exit(0);	            
        }
    }
    
    /**
     * Trata el comando de mapa de la linea de comandos. En el caso de que no encuentre el mapa en el
     * directorio en el que esperaba encontrarlo, sacara un mensaje de error notificando que el archivo
     * del mapa no esta especificado.
     * @param commandLine - Linea de comandos que verifica la validez de los comandos
     */
    public void treatMap(CommandLine commandLine){
    	if (commandLine.hasOption('m')){
    		mapRoute=commandLine.getOptionValue("m");
        }else{
        	System.err.println("Map file not specified");
         	System.exit(1);
        }
    }
    
    /**
     * Trata el comando de interfaz de la linea de comandos. En caso de que sea una 'i',
     * comprobara que las interfaces son validas (esta aplicacion se puede ejecutar por medio de
     * swing, de la consola o de las dos a la vez). Si no coincide alguna de las interfaces, se 
     * mostrara un mensaje de error.
     * En caso de que el comando sea 'd',(parte opcional) buscará la salida más proxima a la que pueda acceder wall-e.
     * Si no es ninguno de estos dos comandos, mostrara el siguiente mensaje: Interface not specified
     * @param commandLine - Linea de comandos que verifica la validez de los comandos
     */
    public void treatInterface(CommandLine commandLine){
    	if(commandLine.hasOption('i')){
        	console = (commandLine.getOptionValue("i").contains("console"));
        	swing = (commandLine.getOptionValue("i").contains("swing"));
        	both = (commandLine.getOptionValue("i").contains("both"));
            if(!console&&!swing&&!both){
            	System.err.println("Wrong type of interface");
            	System.exit(3);
            }
        }else if (commandLine.hasOption('d')){
        	buscaSalida = true;
    		maxActions=Integer.parseInt(commandLine.getOptionValue("d"));
        }else{
            System.err.println("Interface not specified");
            System.exit(1);
        }
    }
    
    /**
     * Utiliza un flujo de entrada para leer el mapa de un archivo de texto, llamando al metodo necesario
     * de la clase CityLoaderFromTxtFile. En el caso de que el archivo del mapa no se encuentre en el
     * directorio esperado o haya un problema durante la lectura del archivo, se lanzará una excepcion del tipo
     * FileNotFoundException o IOException, respectivamente.
     */
    public void readMap(){
    	try {
			file = new FileInputStream(mapRoute);
			city = mapaArchivo.loadCity(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error reading the map file: noExiste.txt (No existe el fichero o el directorio)");//Ejec10
            System.exit(2);
		}catch (IOException e) {
			System.err.println("Error reading the map file: noExiste.txt (No existe el fichero o el directorio)");//Ejec10
            System.exit(2);
		}
    }
    
    /**
     * Si todos los pasos anteriores han sido correctos, este metodo se encargará,
     * mientras la ciudad haya sido bien cargada, de comenzar el juego en el tipo de
     * interfaz que haya sido especificada mediante la linea de comandos (swing, consola o ambas)
     * o buscará una salida para wall-e (Parte opcional)
     */
    public void stratGame(){
    	if (city != null ) {
	        RobotEngine robot = new RobotEngine(city, mapaArchivo.getInitialPlace(), Direction.NORTH);
	        if(console){
	        	ConsoleController controlador = new ConsoleController(robot);
	        	@SuppressWarnings("unused")
				Console vista = new Console(controlador);
				controlador.startController();				
	        }else if(swing){
	        	GUIController controlador = new GUIController(robot);
	        	MainWindow vista = new MainWindow(controlador);
	        	MainWindow vista1 = new MainWindow(controlador);
	        	controlador.startController();
	        	vista.arranca();
	        	vista1.arranca();
	         }else if(both){	        	
				 ConsoleController controladorConsola = new ConsoleController(robot);
	        	 GUIController controladorGUI = new GUIController(robot);
	        	 MainWindow vistaGUI = new MainWindow(controladorGUI);
				 @SuppressWarnings("unused")
				 Console vista = new Console(controladorConsola);
	        	 controladorGUI.startController();
	        	 vistaGUI.arranca();	        	
	         }else if(buscaSalida){
	        	 ConsoleController controladorConsola = new ConsoleController(robot);
	        	 GUIController controladorGUI = new GUIController(robot);
	        	 MainWindow vistaGUI = new MainWindow(controladorGUI);
	        	 @SuppressWarnings("unused")
				 Console vista = new Console(controladorConsola);
	        	 controladorGUI.startController();
	        	 vistaGUI.arranca();
	        	 robot.buscaSalida(maxActions);
	         }else{
	        	 System.err.println("Wrong type of interface");
	            System.exit(2);
	         }
	    }
    }
}
