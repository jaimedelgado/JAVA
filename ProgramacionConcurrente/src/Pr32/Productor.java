package Pr32;

public class Productor extends Thread{

	private Almacen1 a;
	private Producto p;
	
	public Productor(){
		this.a = new Almacen1();
		this.p = new Producto();
	}
	
	public Productor(Almacen1 a, int codigo){
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
		return p;
	}
}
