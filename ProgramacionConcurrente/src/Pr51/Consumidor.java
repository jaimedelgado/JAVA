package Pr51;

public class Consumidor extends Thread{

	private AlmacenN a;
	private int numeProd; //numero de productos a consumir
	
	public Consumidor(){
		this.a = new AlmacenN();
		this.numeProd = 0;
	}
	
	public Consumidor(AlmacenN a, int numeProd){
		this.a = a;
		this.numeProd = numeProd;
	}
	
	public void run(){
		//System.out.println("Thread: " + this.numeProd);
		for(int i = 0; i < this.numeProd; i++){
			Producto p = a.extraer(this.numeProd);
			this.consumir(p);
		}
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
