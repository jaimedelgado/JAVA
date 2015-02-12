/**
 * Esta clase representa una aplicación que integra el resto de paquetes. 
 * La aplicación te deja elegir entre ejecutar un vinculador dom o stax, un interprete pull o push, y una interfaz por consola
 * o en modo gráfico.
 */
package aplicacionIntegradora;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullConsola;
import interpretePull.InterpretePullGUI;
import interpretePush.InterpretePush;
import interpretePush.InterpretePushConsola;

import java.util.Scanner;

import modelo.Etapa;
import apidom.VinculadorDom;
import apistax.VinculadorStax;

/**
 * @author Jaime Delgado linares
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Aplicación principal que muestra el menu con las distintas opciones (Vinculador DOM o STAX, Interprete PULL o PUSH, e
	 * interzaf por consola o en modo gráfico)
	 * @param args
	 */
	public static void main(String[] args) {
		Main.menu();
		int opc = 1;
		while(opc!=0){
			opc = Main.leeOpcion();
			switch(opc){
			case 0: break;
			case 1: Main.guiPullDom(); break;
			case 2: Main.consolaPullDom(); break;
			case 3: Main.consolaPushDom(); break;
			case 4: Main.guiPullStax(); break;
			case 5: Main.consolaPullStax(); break;
			case 6: Main.consolaPushStax(); break;
			default: System.out.print("     Elige una opcion:");break;
			}
		}
		System.out.println("Fin ejecución");
	}

	/**
	 * Ejecuta la aplicación en modo consola con un vinculador stax y un interprete push
	 */
	private static void consolaPushStax() {
		VinculadorStax vinculador = new VinculadorStax();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePush i = new InterpretePushConsola(e);
		i.inicia();
	}
	/**
	 * Ejecuta la aplicación en modo gráfico con un vinculador stax y un interprete pull
	 */
	private static void guiPullStax() {
		VinculadorStax vinculador = new VinculadorStax();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePull i = new InterpretePullGUI(e);
		i.inicia();
		
		
	}
	/**
	 * Ejecuta la aplicacion en modo consola con un vinculador stax y un interprete pull
	 */
	private static void consolaPullStax() {
		VinculadorStax vinculador = new VinculadorStax();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePull i = new InterpretePullConsola(e);
		i.inicia();
		while(true){ i.transita();}
	}

	/**
	 * Ejecuta la aplicación en modo consola con un vinculador dom y un interprete push
	 */
	private static void consolaPushDom() {
		VinculadorDom vinculador = new VinculadorDom();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePush i = new InterpretePushConsola(e);
		i.inicia();
		
	}
	/**
	 * Ejecuta la aplicación en modo gráfico con un vinculador dom y un interprete pull
	 */
	private static void guiPullDom() {
		VinculadorDom vinculador = new VinculadorDom();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePull i = new InterpretePullGUI(e);
		i.inicia();
		
	}
	/**
	 * Ejecuta la aplicación en modo consola con un vinculador dom y un interprete pull
	 */
	private static void consolaPullDom() {
		VinculadorDom vinculador = new VinculadorDom();
		Etapa e = vinculador.ejecutaVinculador("src/sintaxisXML/ejemplo.xml");
		InterpretePull i = new InterpretePullConsola(e);
		i.inicia();
		while(true){ i.transita();}
	}
	/**
	 * Devuelve un entero con la opción leida por el usuario
	 * @return
	 */
	private static int leeOpcion() {
		return Main.sc.nextInt();
	}
	/**
	 * Muestra el menu con las distintas opciones que puede usar el usuario
	 */
	private static void menu() {
		System.out.println("----------------------------");
		System.out.println("|           MENU           |");
		System.out.println("----------------------------");
		System.out.println("|   0. SALIR               |");
		System.out.println("|     VINCULADOR DOM       |");
		System.out.println("|   1. GUI PULL            |");
		System.out.println("|   2. Consola PULL        |");
		System.out.println("|   3. Consola PUSH        |");
		System.out.println("|     VINCULADOR STAX      |");
		System.out.println("|   4. GUI PULL            |");
		System.out.println("|   5. Consola PULL        |");
		System.out.println("|   6. Consola PUSH        |");
		System.out.println("----------------------------");
		System.out.print("     Elige una opcion:");
		
	}

}
