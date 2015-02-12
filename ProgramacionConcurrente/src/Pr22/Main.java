package Pr22;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		//Variables Compartidas.
		Contador c = new Contador();
		boolean in1 = false;
		boolean in2 = false;
		int last = 0;
		
		//Creo tamaño de los vectores de los threads.
		ThreadIncre ti[] = new ThreadIncre[Integer.valueOf(args[0])];
		ThreadDecre td[] = new ThreadDecre[Integer.valueOf(args[0])];
		
		//Crear N Threads.
		for(int i = 0; i < Integer.valueOf(args[0]); i++){
			ti[i] = new ThreadIncre(c, in1, in2, last);
			td[i] =  new ThreadDecre(c, in1, in2, last);
		}
		
		//Arrancar los N Threads.
		for(int k = 0; k < Integer.valueOf(args[0]); k++){
			ti[k].start();
			td[k].start();
		}
		
		//Esperar a que todos los threads terminen.
		for(int j = 0; j < Integer.valueOf(args[0]); j++){
			ti[j].join();
			td[j].join();
		}
		
		System.out.println("Variable compartida: " + c.getValor());
		
	}

}
