package Pr1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MiThread t[] = new MiThread[Integer.valueOf(args[0])];
		
		//Crear N Threads.
		for(int i = 0; i < Integer.valueOf(args[0]); i++){
			t[i] = new MiThread(i, Integer.valueOf(args[1]));
		}
		
		//Arrancar los N Threads.
		for(int k = 0; k < Integer.valueOf(args[0]); k++){
			t[k].start();
		}
		
		//Esperar a que todos los threads terminen.
		for(int j = 0; j < Integer.valueOf(args[0]); j++){
			t[j].join();
		}
		
		//Imprimir linea de que todos han terminado.
		System.out.println("Todos los threads han terminado.");
	}
		
}
