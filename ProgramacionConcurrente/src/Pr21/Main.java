package Pr21;

public class Main {

	static int varComp = 0;
	
	public static void main(String[] args) {
		for(int j=0; j<Integer.valueOf(args[0]); j++){
		ThreadIncre ti[] = new ThreadIncre[Integer.valueOf(args[0])];
		ThreadDecre td[] = new ThreadDecre[Integer.valueOf(args[0])];
		
		
		//Crear N Threads.
		for(int i = 0; i < Integer.valueOf(args[0]); i++){
			ti[i] = new ThreadIncre();
			td[i] =  new ThreadDecre();
		}
		
		//Arrancar los N Threads.
		for(int k = 0; k < Integer.valueOf(args[0]); k++){
			ti[k].start();
			td[k].start();
		}
		
		System.out.println("Variable compartida: " + varComp);}
		
	}

}
