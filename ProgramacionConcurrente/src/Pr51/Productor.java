package Pr51;

public class Productor extends Thread{

	private AlmacenN a;
	private Producto[] p;
	private int numeProd;
	
	public Productor(){
		this.a = new AlmacenN();
		this.numeProd = 0;
		this.p = new Producto[this.numeProd];
	}
	
	public Productor(AlmacenN a, Producto[] prod, int numeProd){
		this.a = a;
		this.numeProd = numeProd;
		this.p = new Producto[this.numeProd];
		for(int i = 0; i < this.numeProd; i++){
			this.p[i] = prod[i];
		}

	}
	
	public void run(){
		//System.out.println("Thread: " + this.numeProd);
		for(int i = 0; i < this.numeProd; i++){
			Producto prod = this.producirProd(i);
			this.a.almacenar(prod, this.numeProd);
		}
	}
	
	public Producto producirProd(int i){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.p[i];
	}
}
