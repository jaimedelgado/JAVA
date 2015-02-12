package Pr33;

public class Productor extends Thread{

	private AlmacenN a;
	private Producto p;
	
	public Productor(){
		this.a = new AlmacenN();
		this.p = new Producto();
	}
	
	public Productor(AlmacenN a, int codigo){
		this.a = a;
		this.p = new Producto(codigo);
	}
	
	public void run(){
		Producto prod = this.producirProd();
		this.a.almacenar(prod);
	}
	
	public Producto producirProd(){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.p;
	}
}
