package Pr33;
import java.util.concurrent.Semaphore;

public class AlmacenN implements Almacen{

	private Producto[] p;
	private int capacidad;
	private int ini;
	private int fin;
	private Semaphore full;
	private Semaphore empty;
	private Semaphore mutexP;
	private Semaphore mutexC;
	
	public AlmacenN(){
		this.capacidad = 10;
		this.p = new Producto [this.capacidad];
		this.ini = 0;
		this.fin = 0;
		this.full = new Semaphore(0);
		this.empty = new Semaphore(this.capacidad);
		this.mutexP = new Semaphore(1);
		this.mutexC = new Semaphore(1);
	}
	
	@Override
	public void almacenar(Producto producto) {
		try {
			this.empty.acquire();
			this.mutexP.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.p[this.fin] = producto;
		this.fin = (this.fin+1)%this.capacidad;
		System.out.println("Almacenando producto: " + producto.getCodigo() + "...");
		this.mutexP.release();
		this.full.release();
	}

	@Override
	public Producto extraer() {
		try {
			this.full.acquire();
			this.mutexC.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Producto p1 = this.p[this.ini];
		System.out.println("Extrayendo producto: " + p1.getCodigo() + "...");
		this.p[this.ini] = null;
		this.ini = (this.ini+1)%this.capacidad;
		this.mutexC.release();
		this.empty.release();
		return p1;
	}
	
}
