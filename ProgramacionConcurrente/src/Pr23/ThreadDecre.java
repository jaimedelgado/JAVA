package Pr23;

import Pr23.Contador;

public class ThreadDecre extends Thread{

	private Contador c;
	private int i;

	public ThreadDecre(Contador c, int i){
		this.c = c;
		this.i = i;
	}
	
	public void run(){
		for(int j = 0; j < Constantes.NUM_PROCESOS; j++){
			
			c.in[this.i] = j;
			c.last[j] = this.i;
			
			for(int k = 0; k < Constantes.NUM_PROCESOS; k++){
				if(k!=i){
					while((c.in[k] >= c.in[this.i]) && (c.last[j] == this.i)){}
					
				}
			}
			
		}
		this.SeccionCriticaD(1);
		c.in[this.i] = -1;
		
	}

	public void SeccionCriticaD(int n){
		for(int i = 0; i < n; i++){
			c.decrementar();
			System.out.println("ThreadDecre " + this.i + " :" + c.getValor());
				
		}
	}
	
}
