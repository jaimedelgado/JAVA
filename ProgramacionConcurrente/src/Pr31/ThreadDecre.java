package Pr31;
import java.util.concurrent.Semaphore;

public class ThreadDecre extends Thread{

	private Contador c;
	private Semaphore mutex;
	
	public ThreadDecre(){
		this.c = new Contador();
		this.mutex = null;
	}
	
	public ThreadDecre(Contador c, Semaphore mutex){
		this.c = c;
		this.mutex = mutex;
	}
	
	public void run(){
		try {
			this.mutex.acquire();
			this.SeccionCriticaD(10);
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SeccionCriticaD(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadDecre:" + c.getValor());
			c.decrementar();	
		}
	}
}
