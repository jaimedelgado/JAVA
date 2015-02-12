package Pr41_pr33;

public class Consumidor extends Thread{

	private AlmacenN a;
	
	public Consumidor(){
		this.a = new AlmacenN();
	}
	
	public Consumidor(AlmacenN a){
		this.a = a;
	}
	
	public void run(){
		Producto p = a.extraer();
		this.consumir(p);
	}
	
	public void consumir(Producto p){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
