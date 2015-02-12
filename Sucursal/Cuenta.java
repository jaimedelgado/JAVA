package sucursal;

public class Cuenta {
	private int numCuenta; 
	private int saldo; 
	
	//CONSTRUCTORAS
	public Cuenta(){ //Constructora por defecto
		this.numCuenta=0;
		this.saldo=0;
	}
	public Cuenta(int numCuenta, int saldo){ //Constructora con argumentos
		this.numCuenta=numCuenta;
		this.saldo=saldo;
	}
	public Cuenta(Cuenta cuenta){
		this.numCuenta = cuenta.numCuenta;
		this.saldo = cuenta.saldo;
	}
	//FUNCIONES
	public boolean igual(int numCuenta){
		return (this.numCuenta==numCuenta);
	}
	
	public boolean mayor(int numCuenta){
		return (this.numCuenta>numCuenta);
	}
	public boolean mayorD(int dinero){
		return (this.saldo>dinero);
	}
	public void ingresar(int saldo){
		this.saldo = this.saldo + saldo;
	}
	public int sacar(int dinero){
		if(this.saldo>dinero){
			this.saldo = this.saldo - dinero;
		}else{
			dinero = this.saldo;
			this.saldo = this.saldo - dinero;;
		}
		return dinero;
	}
	public boolean vacia(){
		return (this.saldo==0);
	}
	public int getSaldo(){
		return this.saldo; 
	}
	
}