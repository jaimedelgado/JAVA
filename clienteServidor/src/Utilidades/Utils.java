package Utilidades;

import java.util.Scanner;

public class Utils {
	public static final int PUERTO1 = 9956;
	public static final int PUERTO2 = 9967;
	public static Scanner sc = new Scanner(System.in);
	public static void limpiaBuffer(Scanner sc){
		sc.nextLine();
	}
	public static final int OPCION_SALIR = 0;
	public static final int OPCION_INICIAR_SESION = 1;
	public static final int BUSCAR_ARCHIVO = 1;
	public static final int DESCARGAR_ARCHIVO = 2;
}
