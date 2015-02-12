package Pr32;

public class Producto {
	
	private int codigo;
	
	public Producto(){
		this.codigo = 0;
	}
	
	public Producto(int codigo){
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
}
