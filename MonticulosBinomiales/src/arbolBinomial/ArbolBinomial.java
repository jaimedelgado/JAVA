/**
 * Representación de un árbol binomial con una raíz (int), un arraylist de arboles binomiales
 * que representa los hijos, y un puntero al árbol padre.
 */
package arbolBinomial;

import java.util.ArrayList;
/**
 * 
 * @author Jaime Delgado Linares
 *
 */
public class ArbolBinomial {
	//Atributos
	private int raiz;	// Mínimo del árbol. Raíz
	private ArrayList<ArbolBinomial> hijos;	//Hijos del árbol
	private ArbolBinomial padre;	// Padre del árbol
	
	//Constructoras
	/**
	 * Constructora vacía. Crea un árbol con un elemento muy grande.
	 */
	public ArbolBinomial() {
		this.hijos = new ArrayList<ArbolBinomial>();
	}
	/**
	 * Constructora que recibe el valor del primer elemento. Crea un árbol con ese elemento.
	 * @param v - Valor del elemento.
	 */
	public ArbolBinomial(int v){
		this.raiz=v;
		this.hijos = new ArrayList<ArbolBinomial>();
	}
	
	//Métodos
	/**
	 * Une dos árboles poniendo como raíz el elemento más pequeño.
	 * @param a - Árbol a unir.
	 */
	public void unir(ArbolBinomial a){
		if(this.raiz<=a.raiz){
			hijos.add(a);
			a.padre = this;
		}else{
			this.padre = a;
			a.hijos.add(this);
			this.igualaArbolBinomial(a);
		}
	}
	/**
	 * Cambia el valor de la raíz del árbol con la raíz del árbol que le pases por parámetro.
	 * @param a - -Arbol cuya raíz quieres intercambiar.
	 */
	public void flotar(ArbolBinomial a){
		int raiz=a.raiz;
		a.raiz = this.raiz;
		this.raiz = raiz;
	}
	/**
	 * Cambiar el valor de la raiz por el valor k.
	 * @param k - Nuevo valor de la raíz.
	 */
	public void cambiaRaiz(int k){
		this.raiz=k;
	}
	/**
	 * Cambia el padre del árbol.
	 * @param a - Nuevo padre del árbol.
	 */
	public void cambiarPadre(ArbolBinomial a){
		this.padre = a;
	}
	/**
	 * Devuelve el padre del árbol.
	 * @return padre del árbol.
	 */
	public ArbolBinomial padre(){
		return this.padre;
	}
	/**
	 * Devuelve un Arraylist de árboles binomiales que representan los hijos del árbol.
	 * @return un Arraylist de árboles binomiales que representan los hijos del árbol.
	 */
	public ArrayList<ArbolBinomial> hijos(){
		return this.hijos;
	}
	/**
	 * Devuelve el valor de la raíz del árbol. Es el mínimo del árbol.
	 * @return int con la raíz del árbol.
	 */
	public int raiz() {
		return this.raiz;
	}
	/**
	 * Devuelve el grado de un árbol.
	 * @return Grado de un árbol.
	 */
	public int grado(){
		return this.hijos.size();
	}
	/**
	 * Crea una copia del árbol que le pases por parámetro.
	 * @param a - Árbol a copiar.
	 */
	private void igualaArbolBinomial(ArbolBinomial a){
		this.raiz=a.raiz;
		this.hijos=a.hijos;
	}
	/**
	 * Muestra el árbol. Para ello usa el método muestraAux(0) que muestra una barra por nivel y separa cada árbol
	 * de la lista con una serie de guiones.
	 * @return Un String que muestra el árbol.
	 */
	public String muestra(){
		return muestraAux(0);
	}
	/**
	 * Muestra el árbol poniendo una barra en cada nivel. De manera que una línea que tenga una barra más
	 * que la anterior, representa un árbol que es hijo del árbol anterior. Además cada árbol de la lista
	 * esta separado por una serie de guiones.
	 * @param nivel - Nivel por el que va la recursión.
	 * @return Un String que muestra el árbol.
	 */
	private String muestraAux(int nivel){
		nivel++;
		String texto = "";
		String salto = System.getProperty("line.separator");
		texto+=this.raiz+"---";
		for(int i=0; i<this.grado(); i++){
			texto+=this.hijos.get(i).muestraAux(nivel);
			if(i!=this.grado()-1){
				texto+=salto;
				for(int j=0; j<nivel; j++){
					texto+="\\";
				}
			
			}
		}
		return texto;
	}
	
}
