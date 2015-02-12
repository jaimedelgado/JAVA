/**
 * Esta clase representa una aplicación que integra el resto de paquetes. 
 * La aplicación te deja elegir entre ejecutar un interprete pull o push, una interfaz por consola
 * o en modo gráfico, o crear los html de una página web.
 */
package aplicacionIntegradora;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullConsola;
import interpretePull.InterpretePullGUI;
import interpretePush.InterpretePush;
import interpretePush.InterpretePushConsola;

import java.util.Scanner;

import modelo.Etapa;
import cargaEcore.EcoreLoader;

/**
 * @author Jaime Delgado linares
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Aplicación principal que muestra el menu con las distintas opciones (Interprete PULL o PUSH,
	 * interzaf por consola o en modo gráfico, web)
	 * @param args
	 */
	public static void main(String[] args) {
		
		int opc = 1;
		while(opc!=0){
			Main.menu();
			opc = Main.leeOpcion();
			switch(opc){
			case 0: break;
			case 1: Main.guiPull(); break;
			case 2: Main.consolaPull(); break;
			case 3: Main.consolaPush(); break;
			case 4: Main.web(); break;
			default: System.out.print("     Elige una opcion:");break;
			}
		}
		System.out.println("Fin ejecución");
	}

	private static void web() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre carpeta: ");
		String carpeta = sc.nextLine();
		System.out.print("Nombre visita: ");
		String visita = sc.nextLine();
		EcoreLoader loader = new EcoreLoader();
		@SuppressWarnings("unused")
		Etapa e = loader.loadAndWeb("file://D:/UCM/WorkspaceModelado/Visitas/src/ejemplosVisitas/" + visita, carpeta);
	}

	/**
	 * Ejecuta la aplicación en modo consola con un vinculador stax y un interprete push
	 */
	private static void consolaPush() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre visita: ");
		String visita = sc.nextLine();
		EcoreLoader loader = new EcoreLoader();
		Etapa e = loader.load("file://D:/UCM/WorkspaceModelado/Visitas/src/ejemplosVisitas/" + visita);;
		InterpretePush i = new InterpretePushConsola(e);
		i.inicia();
	}

	/**
	 * Ejecuta la aplicación en modo gráfico con un vinculador dom y un interprete pull
	 */
	private static void guiPull() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre visita: ");
		String visita = sc.nextLine();
		EcoreLoader loader = new EcoreLoader();
		Etapa e = loader.load("file://D:/UCM/WorkspaceModelado/Visitas/src/ejemplosVisitas/" + visita);;
		InterpretePull i = new InterpretePullGUI(e);
		i.inicia();
		
	}
	/**
	 * Ejecuta la aplicación en modo consola con un vinculador dom y un interprete pull
	 */
	private static void consolaPull() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre visita: ");
		String visita = sc.nextLine();
		EcoreLoader loader = new EcoreLoader();
		Etapa e = loader.load("file://D:/UCM/WorkspaceModelado/Visitas/src/ejemplosVisitas/" + visita);;
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
		System.out.println("|   1. GUI PULL            |");
		System.out.println("|   2. Consola PULL        |");
		System.out.println("|   3. Consola PUSH        |");
		System.out.println("|   4. WEB                 |");
		System.out.println("----------------------------");
		System.out.print("     Elige una opcion:");
		
	}

}
