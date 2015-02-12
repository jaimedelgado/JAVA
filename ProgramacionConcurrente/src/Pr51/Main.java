package Pr51;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Creo tamaño de los vectores de los threads(Productor, Consumidor) y el almacen1.
		Productor tProd[] = new Productor[Integer.valueOf(args[0])];
		Consumidor tCons[] = new Consumidor[Integer.valueOf(args[0])];
		AlmacenN aN = new AlmacenN();
		
		//Crear array(s) de productos.(TODO)
		Producto aProd[] = new Producto[10];
		for(int l = 0; l < 10; l++){
			aProd[l] = new Producto(l);
		}
		
		//Crear N Threads.
		for(int i = 0; i < Integer.valueOf(args[0]); i++){
			tProd[i] = new Productor(aN, aProd, i);
			tCons[i] =  new Consumidor(aN, i);
		}
		
		//Arrancar los N Threads.
		for(int k = 0; k < Integer.valueOf(args[0]); k++){
			tProd[k].start();
			tCons[k].start();
		}
			
		//Esperar a que todos los threads terminen.
		for(int j = 0; j < Integer.valueOf(args[0]); j++){
			tProd[j].join();
			tCons[j].join();
		}
			
		System.out.println("Fin!");
	}

}
