package Pr22;

public class Contador {

	private int var;
	
	public Contador(){
		this.var = 0;
	}
	
	public void incrementar(){
		this.var++;
	}
	
	public void decrementar(){
		this.var--;
	}
	
	public int getValor(){
		return this.var;
	}
}
