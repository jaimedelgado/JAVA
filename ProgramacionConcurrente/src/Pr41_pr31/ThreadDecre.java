package Pr41_pr31;

public class ThreadDecre extends Thread{

	private Contador c;
	
	public ThreadDecre(){
		this.c = new Contador();
	}
	
	public ThreadDecre(Contador c){
		this.c = c;
	}
	
	public void run(){
		c.decrementar();
	}

	public void SeccionCriticaD(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadDecre:" + c.getValor());
			c.decrementar();	
		}
	}
}
