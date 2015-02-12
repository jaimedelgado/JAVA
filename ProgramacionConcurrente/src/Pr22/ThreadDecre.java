package Pr22;

public class ThreadDecre extends Thread{

	private Contador c;
	private boolean in1;
	private boolean in2;
	private int last;
	
	public ThreadDecre(){
		this.c = new Contador();
		this.in1 = false;
		this.setIn2(false);
		this.last = 0;
	}
	
	public ThreadDecre(Contador c, boolean in1, boolean in2, int last){
		this.c = c;
		this.in1 = in1;
		this.setIn2(in2);
		this.last = last;
	}
	
	public void run(){
		this.setIn2(true);
		this.last = 2;
		while(this.in1 && (this.last == 2));
		this.SeccionCriticaD(10);
		this.setIn2(false);
	}

	public void SeccionCriticaD(int n){
		for(int i = 0; i < n; i++){
			System.out.println("Valor del contador en el threadDecre:" + c.getValor());
			c.decrementar();	
		}
	}

	public boolean isIn2() {
		return in2;
	}

	public void setIn2(boolean in2) {
		this.in2 = in2;
	}
	
}
