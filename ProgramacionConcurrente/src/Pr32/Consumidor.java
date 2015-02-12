package Pr32;

public class Consumidor extends Thread{

	private Almacen1 a;
	
	public Consumidor(){
		this.a = new Almacen1();
	}
	
	public Consumidor(Almacen1 a){
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
