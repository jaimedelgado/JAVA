package Pr22;

public class ThreadIncre extends Thread{

	private Contador c;
	private boolean in1;
	private boolean in2;
	private int last;
	
	public ThreadIncre(){
		this.c = new Contador();
		this.setIn1(false);
		this.in2 = false;
		this.last = 0;
	}
	
	public ThreadIncre(Contador c, boolean in1, boolean in2, int last){
		this.c = c;
		this.setIn1(in1);
		this.in2 = in2;
		this.last = last;
	}
	
	public void run(){
		this.setIn1(true);
		this.last = 1;
		while(this.in2 && (this.last == 1));
		this.SeccionCriticaI(10);
		this.setIn1(false);
	}
	
	public void SeccionCriticaI(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadIncre:" + c.getValor());
			c.incrementar();	
		}
	}

	public boolean isIn1() {
		return in1;
	}

	public void setIn1(boolean in1) {
		this.in1 = in1;
	}

}
