package Pr41_pr31;

public class Contador {

	private int var;
	
	public Contador(){
		this.var = 0;
	}
	
	public synchronized void incrementar(){
		while(this.var != 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Valor del contador antes de incrementar:" + this.var);
		this.var++;
		System.out.println("Valor del contador despues de incrementar:" + this.var);
		notify();
	}
	
	public synchronized void decrementar(){
		while(this.var == 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Valor del contador antes de decrementar:" + this.var);
		this.var--;
		System.out.println("Valor del contador despues de decrementar:" + this.var);
		notifyAll();
	}
	
	public synchronized int getValor(){
		return this.var;
	}
}
