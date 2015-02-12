package Pr32;
import java.util.concurrent.Semaphore;

public class Almacen1 implements Almacen{

	private Producto p;
	private Semaphore full;
	private Semaphore empty;
	
	public Almacen1(){
		this.p = null;
		this.full = new Semaphore(0);
		this.empty = new Semaphore(1);
	}
	
	@Override
	public void almacenar(Producto producto) {
		try {
			this.empty.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.p = producto;
		System.out.println("Almacenando producto: " + this.p.getCodigo() + "...");
		this.full.release();
	}

	@Override
	public Producto extraer() {
		try {
			this.full.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Extrayendo producto: " + this.p.getCodigo() + "...");
		Producto p1 = p;
		this.p = null;
		this.empty.release();
		return p1;
	}
	
}
