/**
 * Representación de un montículo binomial con arraylist de arboles binomiales y un puntero al mínimo árbol.
 */
package monticuloBinomial;

import java.util.ArrayList;

import arbolBinomial.ArbolBinomial;
/**
 * 
 * @author Jaime Delgado Linares
 *
 */
public class MonticuloBinomial {
	//Atributos
	private ArrayList<ArbolBinomial> lista;	//Lista de árboles binomiales que tiene el montículo
	private ArbolBinomial minimo; //Puntero al árbol mínimo
	
	//Constructoras
	/**
	 * Constructora vacía. Crea un montículo vacío.
	 */
	public MonticuloBinomial(){
		this.lista = new ArrayList<ArbolBinomial>();
	}
	/**
	 * Constructora que recibe una clave y crea un montículo con un elemento.
	 * @param clave - Clave a introducir en el montículo.
	 */
	public MonticuloBinomial(int clave){
		this.lista = new ArrayList<ArbolBinomial>();
		ArbolBinomial a = new ArbolBinomial(clave);
		this.lista.add(a);
		this.minimo = a;
	}
	/**
	 * Constructora que recibe una lista de árboles binomiales y un entero que dice cual es el mínimo.
	 * @param l - lista de árboles binomiales del montículo.
	 * @param min - índice del árbol mínimo.
	 */
	public MonticuloBinomial(ArrayList<ArbolBinomial> l, int min){
		this.lista = l;
		this.minimo = this.lista.get(min);
	}
	/**
	 * Constructora que recibe una lista de árboles binomiales y calcula su mínimo.
	 * @param l - Lista de árboles binomiales del montículo.
	 */
	public MonticuloBinomial(ArrayList<ArbolBinomial> l){
		this.lista = l;
		this.minimo = this.buscaMin();
	}
	//////////////////////////////////////////////////////////
	// min, inserta, borramin, decrecerClave
	//////////////////////////////////////////////////////////
	/**
	 * Inserta un elemento en el montículo.
	 * @param clave - clave del elemento a insertar.
	 */
	public void inserta(int clave){
		MonticuloBinomial m = new MonticuloBinomial(clave);
		this.union(m);
	}
	/**
	 * Devuelve el arbol mínimo.
	 * @return el árbol mínimo.
	 */
	public ArbolBinomial min(){
		return this.minimo;
	}
	/**
	 * Borra el mínimo del árbol. Para ello borra la raíz del mínimo árbol, pone sus hijos en la lista,
	 * y los une con la función union(m).
	 */
	public void borrarMin(){
		if(!this.esVacio()){ //Si el árbol NO esta vacío
			if(this.minimo.grado()>0){ //Si tiene hijos, poner sus hijos en la lista y borrarlo
				MonticuloBinomial m = new MonticuloBinomial(this.minimo.hijos(), 0);
				this.lista.remove(this.minimo);
				this.minimo = this.minimo.hijos().get(0); //Cogemos primer hijo como minimo (Unión pondrá el mínimo bueno)
				this.union(m); 
				this.quicksort(0, this.numArboles()-1); //Ordena por grados del árbol
			}else{ // si no tiene hijos solo borramos y actualizamos el mínimo
				this.lista.remove(this.minimo);
				this.minimo = this.buscaMin();
			}
		}
		//Si el árbol esta vacío no hacer nada
	}
	/**
	 * Decrece la clave del árbol "a" "resta" veces. El nuevo valor de a será a-resta. Una vez cambiado
	 * el valor se irá flotando con su padre hasta que no tenga padre o su padre sea menor. 
	 * @param a - Puntero al árbol que quieres decrecer.
	 * @param resta - Valor a restar a la clave.
	 * @return Montículo después de decrecer la clave.
	 */
	public MonticuloBinomial decrecerClave(ArbolBinomial a, int resta){
		a.cambiaRaiz(a.raiz()-resta);
		while(a.padre()!=null && a.raiz()<a.padre().raiz()){
			a.flotar(a.padre());
			a = a.padre();
		}
		if(a.padre()==null){ this.minimo = this.buscaMin();}
		return this;
	}
	//////////////////////////////////////////////////////////
	
	//Funciones públicas auxiliares
	/**
	 * Devuelve el número de árboles en la lista.
	 * @return número de árboles en la lista.
	 */
	public int numArboles(){
		return this.lista.size();
	}
	/**
	 * Devuelve true si el montículo esta vacío y false si no.
	 * @return true si el montículo esta vacío y false si no.
	 */
	public boolean esVacio(){
		return this.lista.size()==0;
	}
	/**
	 * Devuelve la lista de los árboles que forman el montículo.
	 * @return lista de árboles del montículo.
	 */
	public ArrayList<ArbolBinomial> lista(){
		return this.lista;
	}
	
	//Funciones privadas
	/**
	 * Ordena la lista de árboles del montículo por grados con el algoritmo quicksort.
	 * @param izq - índice donde empieza la búsqueda.
	 * @param der - índice donde termina la búsqueda.
	 */
	private void quicksort(int izq, int der) {
		ArbolBinomial pivote=this.lista.get(izq); // tomamos primer elemento como pivote
		int i=izq; // i realiza la búsqueda de izquierda a derecha
		int j=der; // j realiza la búsqueda de derecha a izquierda
		ArbolBinomial aux;
		while(i<j){            // mientras no se crucen las búsquedas
			while(this.lista.get(i).grado()<=pivote.grado() && i<j) i++; // busca elemento mayor que pivote
				while(this.lista.get(j).grado()>pivote.grado()) j--;         // busca elemento menor que pivote
					if (i<j) {                      // si no se han cruzado                      
						aux= this.lista.get(i);                  // los intercambia
						this.lista.set(i,this.lista.get(j));
						this.lista.set(j, aux);
					}
		}
		this.lista.set(izq, this.lista.get(j)); // se coloca el pivote en su lugar de forma que tendremos
		this.lista.set(j, pivote); // los menores a su izquierda y los mayores a su derecha
		if(izq<j-1)
			quicksort(izq,j-1); // ordenamos subarray izquierdo
		if(j+1 <der)
			quicksort(j+1,der); // ordenamos subarray derecho
	}
	/**
	 * Devuelve el árbol mínimo del montículo.
	 * @return árbol mínimo del montículo.
	 */
	private ArbolBinomial buscaMin(){
		ArbolBinomial a = null;
		if(!this.esVacio()){
			a = new ArbolBinomial(Integer.MAX_VALUE); //Árbol con un elemento muy grande
			for(ArbolBinomial ai: this.lista){
				int min = a.raiz();
				int raiz = ai.raiz();
				if(raiz<min){ a=ai; }
			}
		}
		return a;
	}
	/**
	 * Devuelve el árbol de la posición i en la lista del montículo.
	 * @param i - Índice del elemento que quieres borrar de la lista de árboles del montículo.
	 * @return El árbol i de la lista de árboles del montículo.
	 */
	private ArbolBinomial arbol(int i){
		return this.lista.get(i);
	}
	/**
	 * Elimina el elemento i de la lista de árboles del montículo.
	 * @param i - Índice del elemento que quieres borrar de la lista de árboles del montículo.
	 */
	private void elimina(int i){
		this.lista.remove(i);
	}
	/**
	 * Crea una copia del montículo "m" copiando sus atributos.
	 * @param m - Montículo a copiar.
	 */
	private void igualaMonticuloBinomial(MonticuloBinomial m){
		this.lista = m.lista;
		this.minimo = m.minimo;
	}
	/**
	 * Une el montículo con el montículo que le pases por parámetro. Para ello hace un merge y luego va uniendo los nodos.
	 * También actualiza el mínimo del montículo.
	 * @param m - Montículo a unir.
	 */
	private void union(MonticuloBinomial m){
		if(this.esVacio()){
			this.igualaMonticuloBinomial(m);
			this.minimo = m.buscaMin();
		}else if(!m.esVacio()){
			this.merge(m);
			int x = 0;
			int nextx = 1, raiz, min;
			ArbolBinomial minimo=new ArbolBinomial(Integer.MAX_VALUE); //árbol con un mínimo muy grande
			while(x<this.numArboles()){
				int aumento=0;
				if(x==this.numArboles()-1){
					aumento++;
				}else if(arbol(x).grado()!=arbol(nextx).grado()){
					aumento++;
				}else if(arbol(x).raiz()<=arbol(nextx).raiz()){
					arbol(x).unir(arbol(nextx));
					this.elimina(nextx);
				}else if(arbol(x).raiz()>arbol(nextx).raiz()){
					arbol(nextx).unir(arbol(x));
					this.elimina(x);
				}
				raiz = arbol(x).raiz();
				min = minimo.raiz();
				if(raiz<min){ minimo = arbol(x);}
				x+=aumento;
				nextx+=aumento;
			}
			if(this.minimo.raiz()!=Integer.MAX_VALUE){ this.minimo = minimo;}
			else{ this.minimo=this.buscaMin();}
		}else{
			this.minimo = this.buscaMin();
		}
	}
	/**
	 * Une dos montículos binomiales en uno pero no los une. (De eso se encarga la función union).
	 * @param m - Monticulo a unir.
	 */
	private void merge(MonticuloBinomial m){
		int i=0, recorreListaM=0, numArboles=this.numArboles();
		ArbolBinomial arbol;
		while(i<numArboles && recorreListaM<m.numArboles()){
			arbol = m.lista.get(recorreListaM);
			int gradoArbolM = arbol.grado();
			int gradoArbol = this.arbol(i).grado();
			if(i==numArboles){ 
				this.lista.add(arbol);
				recorreListaM++;
			}else if(gradoArbolM<gradoArbol){
				this.lista.add(i, arbol);
				i++;
				recorreListaM++;
			}else if(gradoArbolM==gradoArbol){
				this.lista.add(i, arbol);
				recorreListaM++;
				i+=2;
			}else if(gradoArbolM>gradoArbol){
				i++;
			}
		}
		while(recorreListaM<m.numArboles()){
			arbol = m.lista.get(recorreListaM);
			this.lista.add(arbol);
			recorreListaM++;
		}
		
	}
	/**
	 * Muestra el montículo binomial mostrando todos sus árboles.
	 * @return String con la representación del montículo.
	 */
	public String muestra(){
		String texto="";
		String salto = System.getProperty("line.separator");
		for(ArbolBinomial a: this.lista){
			texto += a.muestra();
			texto += salto + "-------------------------------" + salto;
		}
		return texto;
	}
}
