package Pr23;

import Pr23.Contador;

public class Main {
		
	public static void main(String[] args) throws InterruptedException{
		
		
		//Variables Compartidas.
		Contador c = new Contador();
		
		//Creo tamaño de los vectores de los threads.
		ThreadIncre ti[] = new ThreadIncre[Constantes.NUM_PROCESOS/2];
		ThreadDecre td[] = new ThreadDecre[Constantes.NUM_PROCESOS/2];
				
		//Crear N Threads.
		for(int i = 0; i < Constantes.NUM_PROCESOS/2; i++){
			ti[i] = new ThreadIncre(c, i);
			td[i] =  new ThreadDecre(c, i+(Constantes.NUM_PROCESOS/2));
		}
		
		//Arrancar los N Threads.
		for(int k = 0; k < Constantes.NUM_PROCESOS/2; k++){
			ti[k].start();
			td[k].start();
		}
		
		//Esperar a que todos los threads terminen.
		for(int j = 0; j < Constantes.NUM_PROCESOS/2; j++){
			ti[j].join();
			td[j].join();
		}
		
		System.out.println("Variable compartida: " + c.getValor());
		
	}

}
