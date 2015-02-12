/**
 * Clase que contiene todos los textos que van a salir en las vistas de la aplicacion
 */
package tp.pr5.utilidades;
/**
 * 
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
public class Texts {

	/* Main window title */
	public static String TITULO_MAIN_WINDOW = "WALL·E The garbage collector";
	
	/* Head */
	public static String FILE = "file";
	
	/*RobotPanel texts */
	public static String ROBOT_INFO = "Robot info";
	public static String FUEL = "Fuel";
	public static String RECYCLED = "Recycled";
	public static String ID = "Id";
	public static String DESCRIPTION = "Description";
	
	/*InstructionsPanel texts */
	public static String INSTRUCTIONS = "Instructions";
	public static String MOVE = "MOVE";
	public static String QUIT = "QUIT";
	public static String TURN = "TURN";
	public static String LEFT = "LEFT";
	public static String RIGHT = "RIGHT";
	public static String PICK = "PICK";
	public static String DROP = "DROP";
	public static String OPERATE = "OPERATE";
	
	/*NavigationPanel texts*/
	public static String CITY_MAP = "City Map";
	public static String LOG = "Log";
	
	/*Error messages*/
	public static String ERROR_FUEL_EMPTY = "WALL·E says: I have communication problems. Bye bye";
	public static String ERROR_GENERAL = "Error, this action can't be done";
	public static String ERROR_SPACESHIP = "WALL·E says: I am at my spaceship. Bye bye";
	
	//Fuel y material recilcado inicial del robotPanel
	public static int fuelInicial = 100;
	public static int recycledInicial = 0;
	
	//Avisos de walle
	public static String AVISO_NO_TENGO = "You do not have any ";
	public static String AVISO_ESTA_MIRANDO = "WALL·E is looking at direction ";
	public static String WALLE_SAYS = "WALL·E says: ";
	public static String WALLE_FUEL = "      * My power is ";
	public static String WALLE_MATERIAL = "      * My recycled material is ";
	public static String PLACE_OBJECTS = "The place contains these objects:";
	public static String WALLE_ATTRIBUTES = "Robot attributes has been updated";
	public static String WALLE_DROPPED = "WALL·E says: Great! I have dropped ";
	public static String WALLE_PICKED = "WALL·E says: I am happy! Now I have ";
	public static String WALLE_MOVING = "WALL·E says: Moving in direction ";
	public static String WALLE_CARRYING = "WALL·E says: I am carrying the following items";
}
