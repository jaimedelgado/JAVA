package Pr41_pr31;

public class ThreadIncre extends Thread{

	private Contador c;
	
	public ThreadIncre(){
		this.c = new Contador();
	}
	
	public ThreadIncre(Contador c){
		this.c = c;
	}
	
	public void run(){
		c.incrementar();
	}
	
	public void SeccionCriticaI(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadIncre:" + c.getValor());
			c.incrementar();	
		}
	}
}
