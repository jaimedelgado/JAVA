package sucursal;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Sucursal sucursal = new Sucursal();
		int men = menu();
		while(men!=0){
			switch(men){
			case 1: 
				System.out.println("1.Dar de alta a un cliente");
				System.out.println("Introduzca dni:");
				int nif = scan.nextInt();
				System.out.println("Introduzca un saldo inicial:");
				int cantidad = scan.nextInt();
				boolean darAlta = sucursal.darAltaCliente(nif, cantidad);
				if(!darAlta){
					System.out.println("No se ha podido dar de alta");
				}else{
					System.out.println("Dado de alta con exito");
				}
				break;
			case 2:
				System.out.println("2.Realiza un ingreso");
				System.out.println("Introduzca dni:");
				nif = scan.nextInt();
				System.out.println("Introduzca numero de cuenta:");
				int numCuen = scan.nextInt();
				System.out.println("Introduzca cantidad a ingresar:");
				cantidad = scan.nextInt();
				sucursal.realizarIngreso(nif, numCuen, cantidad);
			    break;
			case 3:
				System.out.println("3.Realiza un reintegro");
				System.out.println("Introduzca dni:");
				nif = scan.nextInt();
				System.out.println("Introduzca numero de cuenta:");
				numCuen = scan.nextInt();
				System.out.println("Introduzca cantidad a ingresar:");
				cantidad = scan.nextInt();
				sucursal.realizarReintegro(nif, numCuen, cantidad);
				break;
			default:
				break;
			}
			men = menu();
			
		}
		scan.close();
	}
	
	public static int menu(){
		System.out.println("1.Dar de alta a un cliente");
		System.out.println("2.Realiza un ingreso");
		System.out.println("3.Realiza un reintegro");
		System.out.println("Eliga una opcion:");
		int opcion = scan.nextInt();
		return opcion;
	}

}
