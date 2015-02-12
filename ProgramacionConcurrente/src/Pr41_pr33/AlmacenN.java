package Pr41_pr33;
//import java.util.concurrent.Semaphore;

public class AlmacenN implements Almacen{

	private Producto[] p;
	private int capacidad;
	private int ini;
	private int fin;
	private int count;
	
	public AlmacenN(){
		this.capacidad = 10;
		this.p = new Producto [this.capacidad];
		this.ini = 0;
		this.fin = 0;
		this.count = 0;
	}
	
	@Override
	public synchronized void almacenar(Producto producto) {
		while(this.capacidad == count){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.p[this.fin] = producto;
		this.fin = (this.fin+1)%this.capacidad;
		this.count++;
		System.out.println("Almacenando producto: " + producto.getCodigo() + "...");
		notify();
	}

	@Override
	public synchronized Producto extraer() {
		while(this.count == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Producto p1 = this.p[this.ini];
		System.out.println("Extrayendo producto: " + p1.getCodigo() + "...");
		this.p[this.ini] = null;
		this.ini = (this.ini+1)%this.capacidad;
		this.count--;
		notify();
		return p1;
	}
	
}
