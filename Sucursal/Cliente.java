package sucursal;

public class Cliente {
	private final int MAX_CUENTAS=10; 
	private int dni; 
	private Cuenta[] coleccionCuentas = new Cuenta[this.MAX_CUENTAS]; 
	private int numCuentas;
	
	//CONSTRUCTORAS
	public Cliente(){ //Constructora por defecto
		this.dni=0;
		for(int i=0; i<this.MAX_CUENTAS; ++i){
			Cuenta cuenta = new Cuenta();
			this.coleccionCuentas[i]=cuenta;
		}
		this.numCuentas=0;
	}
	
	public Cliente(Cuenta cuentas, int nif){ //Constructora con argumentos
		int n = this.numCuentas;
		Cuenta c = new Cuenta(cuentas);
		this.coleccionCuentas[n]=c;
		this.dni = nif;
		this.numCuentas++;
	}
	
	//FUNCIONES
	
	public boolean igual(int nif){
		return (this.dni==nif);
	}
	
	public boolean mayor(int nif){
		return (this.dni>nif);
	}
	public void ingresar(int numcuenta, int posicion, int saldo){
		int pos = buscarCuenta(numcuenta);
		if(pos!=-1){
			this.coleccionCuentas[pos].ingresar(saldo);
		}
	}
	public void sacar(int numcuenta, int pos, int cantidad, Sucursal sucursal){
		if(this.coleccionCuentas[pos].mayorD(cantidad)){
			ingresar(numcuenta,pos,cantidad*-1);
			System.out.println("Reintegro realizado con exito");
		}else{
			this.borrarCuenta(numcuenta, sucursal);
		}
	}
	public void borrarCuenta(int num, Sucursal sucursal){
		for(int i=num; i<this.numCuentas; i++){
			this.coleccionCuentas[num]=this.coleccionCuentas[num+1];
		}
		Cuenta cuenta = new Cuenta();
		this.coleccionCuentas[this.numCuentas]=cuenta;
		this.numCuentas--;
		System.out.println("Cuenta borrada por saldo insuficiente");
		if(this.numCuentas==0){
			sucursal.borrarCliente(this.dni);
		}
	}
	public int buscarCuenta(int numCuenta){
		int ini=0;
		int fin=this.numCuentas;
		int mitad = (ini+fin)/2;
		int encontrado = -1;
		while(encontrado==-1&&ini<=fin){
			if(this.coleccionCuentas[mitad].igual(numCuenta)){
				encontrado=mitad;
			}else if(this.coleccionCuentas[0].mayor(numCuenta)){
				fin = mitad-1;
			}else{
				ini = mitad+1;
			}
			mitad = (ini+fin)/2;
		}
		return encontrado;
	}
	
	public boolean agregarCuenta (Cuenta cuenta){
		if(this.numCuentas<this.MAX_CUENTAS){
			this.coleccionCuentas[this.numCuentas] = cuenta;
			this.numCuentas++;
			return true;
		}else{
			System.out.println("No se puede agregar cuenta");
			return false;
		}
	}
}