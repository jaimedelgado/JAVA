package sucursal;

public class Sucursal {
	private final int MAX_CLIENTES = 200; 
	private Cliente[] coleccionClientes = new Cliente[this.MAX_CLIENTES]; 
	private int numCuentaActual;
	private int numClientes = 0;
	
	// CONSTRUCTORAS
	public Sucursal(){ 
		for(int i=0; i<this.MAX_CLIENTES; i++){
			Cliente cliente = new Cliente();
			this.coleccionClientes[i]=cliente;
		}
		this.numCuentaActual=1;
		this.numClientes=0;
	}
	
	// FUNCIONES 
	
	public int buscarCliente(int nif){
		int ini=0;
		int fin = this.numClientes;
		int mitad = (ini+fin)/2;
		int encontrado = -1;
		while(encontrado==-1&&ini<=fin){
			if(this.coleccionClientes[mitad].igual(nif)){
				encontrado=mitad;
			}else if(this.coleccionClientes[mitad].mayor(nif)){
				fin = mitad-1;
			}else{
				ini = mitad+1;
			}
			mitad = (ini+fin)/2;
		}
		return encontrado;
	}

	
	
	public boolean darAltaCliente(int nif, int saldo){
		int pos = buscarCliente(nif);
		if(pos!=-1){
			System.out.println("El cliente ya existe");
			Cuenta cuenta = new Cuenta(this.numCuentaActual, saldo);
			this.coleccionClientes[pos].agregarCuenta(cuenta);
			return true;
		}else{
			if(this.numClientes<this.MAX_CLIENTES){ // Comprobamos si podemos introducirlo
				Cuenta cuent = new Cuenta (this.numCuentaActual, saldo);
				Cliente cl = new Cliente(cuent, nif);
				this.numCuentaActual++;
				this.coleccionClientes[this.numClientes]=cl;
				this.numClientes++;
				return true;
			}else{
				System.out.println("No se pueden introducir mas usuarios");
				return false;
			}
		}
	}
	
	public void realizarIngreso(int nif, int numCuenta, int ingreso){
		int posicion = this.buscarCliente(nif);
		if(posicion != -1){
			int posicion1 = this.coleccionClientes[posicion].buscarCuenta(numCuenta); 
			if(posicion1!=-1){
				this.coleccionClientes[posicion1].ingresar(numCuenta, posicion1, ingreso);
			}else{
				System.out.println("No se ha encontrado la cuenta");
			}
		}else{
			System.out.println("No se ha encontrado el cliente");
		}
	}
	
	public void realizarReintegro(int nif, int numCuenta, int ingreso){
		int posicion = this.buscarCliente(nif);
		if(posicion != -1){
			int posicion1 = this.coleccionClientes[posicion].buscarCuenta(numCuenta); 
			if(posicion1!=-1){
				this.coleccionClientes[posicion1].sacar(numCuenta, posicion1, ingreso, this);
			}else{
				System.out.println("No se ha encontrado la cuenta");
			}
		}else{
			System.out.println("No se ha encontrado el cliente");
		}
	}
	
	public void borrarCliente(int nif){
		int pos = this.buscarCliente(nif); 
		if(pos!=-1){
			for(int i=pos; i<this.numClientes; i++){
				this.coleccionClientes[i]=this.coleccionClientes[i+1];
			}
			this.numClientes--;
			System.out.println("Cliente borrado por no tener ninguna cuenta activa");
		}else{
			System.out.println("No existe el cliente");
		}
		
	}

}
