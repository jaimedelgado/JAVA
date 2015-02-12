package Pr31;
import java.util.concurrent.Semaphore;

public class ThreadIncre extends Thread{

	private Contador c;
	private Semaphore mutex;
	
	public ThreadIncre(){
		this.c = new Contador();
		this.mutex = null;
	}
	
	public ThreadIncre(Contador c, Semaphore mutex){
		this.c = c;
		this.mutex = mutex;
	}
	
	public void run(){
		try {
			this.mutex.acquire();
			this.SeccionCriticaI(10);
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SeccionCriticaI(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadIncre:" + c.getValor());
			c.incrementar();	
		}
	}
}
