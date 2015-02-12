package Pr23;

public class Contador {

	public int var;
	public int in[];
	public int last[];
	
	public Contador(){
		this.var = 0;
		this.in = new int[Constantes.NUM_PROCESOS];
		this.last = new int[Constantes.NUM_PROCESOS];
		for(int i=0; i<Constantes.NUM_PROCESOS; i++){
			in[i]=-1; last[i]=-1;
		}
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
