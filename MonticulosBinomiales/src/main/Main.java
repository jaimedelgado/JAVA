/**
 * Aplicación que muestra las principales funciones de un montículo binomial.
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import arbolBinomial.ArbolBinomial;
import monticuloBinomial.MonticuloBinomial;

/**
 * @author Jaime Delgado Linares
 *
 */
public class Main {
	private static FileWriter fichero;
	private static PrintWriter pw;
	/** Aplicación que muestra las funciones de un montículo binomial.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int opc = -1;
			MonticuloBinomial m = new MonticuloBinomial();
			while(opc!=0){
				System.out.println("Elige una opción:");
				System.out.println("1. Nuevo montículo");
				System.out.println("2. MultiInsertar \"x\" elementos");
				System.out.println("3. MultiBorrar \"x\" mínimos");
				System.out.println("4. Multidecrecer aleatorio");
				System.out.println("5. Insertar");
				System.out.println("6. BorrarMin");
				System.out.println("7. DecrecerClave");
				System.out.println("8. Mínimo");
				System.out.println("9. Calcular tiempos insertar");
				System.out.println("10. Calcular tiempos borrarMin");
				System.out.println("11. Calcular tiempos minimo");
				System.out.println("12. Calcular tiempos decrecer");
				System.out.println("0. SALIR");
				System.out.print("> ");
				opc = sc.nextInt();
				switch(opc){
				case 1: m = new MonticuloBinomial(); break;
				case 2: opcion2(m); break;
				case 3: opcion3(m); break;
				case 4: opcion4(m); break;
				case 5: opcion5(m); break;
				case 6: opcion6(m); break;
				case 7: opcion7(m); break;
				case 8: opcion8(m); break;
				case 9: opcion9(); break;
				case 10: opcion10(); break;
				case 11: opcion11(); break;
				case 12: opcion12(); break;
				default: break;
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * MultiInsertar en el montículo.
	 * @param m - montículo.
	 * @throws IOException 
	 */
	private static void opcion2(MonticuloBinomial m) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Número elementos a insertar: ");
		int n = sc.nextInt();
		fichero = new FileWriter("Insertar.dat");
		pw = new PrintWriter(fichero);
		for(int i=1; i<=n; i++){
			pw.print(i+"\t");
			long time_start = System.nanoTime();
			m.inserta((int)(Math.random()*n+1));
			long time_end = System.nanoTime();
			pw.println((time_end-time_start));
		}	
		
		System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Multiborrar mínimo en el montículo.
	 * @param m - montículo.
	 * @throws IOException 
	 */
	private static void opcion3(MonticuloBinomial m) throws IOException {
		fichero = new FileWriter("BorrarMin.dat");
		pw = new PrintWriter(fichero);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Número elementos a borrar: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++){
			pw.print(i+"\t");
			long time_start = System.nanoTime();
			m.borrarMin();
			long time_end = System.nanoTime();
			pw.println((time_end-time_start));
		}	
		System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Multidecrecer aleatorio
	 * @param m - montículo
	 * @throws IOException 
	 */
	private static void opcion4(MonticuloBinomial m) throws IOException {
		fichero = new FileWriter("Decrecer.dat");
		pw = new PrintWriter(fichero);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Número elementos a decrecer: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++){
			if(m==null || m.esVacio()){ System.out.println("Montículo vacío");}
			else{
				int num=(int)(Math.random()*(m.numArboles())+1);
				ArbolBinomial a = m.lista().get(num-1); //Arbol Aleatorio
				num=(int)(Math.random()*(a.hijos().size())+0);
				while(num!=0 && !a.hijos().isEmpty()){ //Elijo subárboles aleatorios o si sale 0, el anterior
					a = a.hijos().get(num-1);
					num = (int)(Math.random()*(a.hijos().size())+0);
				}
				num = (int)(Math.random()*50+1); //cantidad a restar
				pw.print(i+"\t");
				System.out.println("El árbol \"" + a.toString() + " con raíz " + a.raiz() + " ha decrecido un valor de " + num );
				long time_start = System.nanoTime();
				m.decrecerClave(a, num);
				long time_end = System.nanoTime();
				pw.println((time_end-time_start));
			}
		}
		System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Insertar en el montículo.
	 * @param m - montículo.
	 */
	private static void opcion5(MonticuloBinomial m) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Elemento a insertar: ");
		int n = sc.nextInt();
		m.inserta(n);
		System.out.println(m.muestra());
	}
	/**
	 * Borrarmin.
	 * @param m - montículo.
	 */
	private static void opcion6(MonticuloBinomial m) {
		m.borrarMin();	
		System.out.println(m.muestra());
	}
	/**
	 * DecrecerClave.
	 * @param m - montículo.
	 */
	private static void opcion7(MonticuloBinomial m) {
		if(m==null || m.esVacio()){ System.out.println("Montículo vacío");}
		else{
			System.out.print("Elige un árbol ");
			for(int i=0; i<m.numArboles(); i++){
				System.out.print(i+1 + " ");
			}
			System.out.print(":");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			ArbolBinomial a = m.lista().get(num-1);
			while(num!=0 && !a.hijos().isEmpty()){
				System.out.print("Confirmar(0) Hijos(");
				for(int j=0; j<a.hijos().size(); j++){
					System.out.print(j+1 + " ");
				}
				System.out.print("): ");
				num = sc.nextInt();
				if(num!=0){	a = a.hijos().get(num-1); }
			}
			System.out.print("Cantidad a restar: ");
			num = sc.nextInt();
			m.decrecerClave(a, num);
			System.out.println(m.muestra());
		}
	}
	/**
	 * Mínimo.
	 * @param m - montículo.
	 */
	private static void opcion8(MonticuloBinomial m) {
		if(m.esVacio()){ System.out.println("El montículo está vacío.");
		}else{ System.out.println("El mínimo del montículo es: " + m.min().raiz() + ".");}
	}
	/**
	 * Calcula los tiempos de insertar un millón de veces números aleatorios (1-1.000.000)
	 * @throws IOException
	 */
	private static void opcion9() throws IOException{
		MonticuloBinomial m = new MonticuloBinomial();
		fichero = new FileWriter("Insertar.dat");
		pw = new PrintWriter(fichero);
		int n = 5000000;
		long time = 0;
		for(int i=1; i<=n; i++){
			long time_start = System.nanoTime();
			m.inserta((int)(Math.random()*n+1));
			long time_end = System.nanoTime();
			time += time_end-time_start;
			pw.println(time);
		}	
		//System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Calcula los tiempos de borrarMin un millón de veces
	 * @throws IOException
	 */
	private static void opcion10() throws IOException{
		MonticuloBinomial m = new MonticuloBinomial();
		fichero = new FileWriter("BorrarMin.dat");
		pw = new PrintWriter(fichero);
		int n = 5000000;
		long time = 0;
		for(int i=1; i<=n; i++){
			m.inserta((int)(Math.random()*n+1));
		}	
		for(int i=1; i<=n; i++){
			long time_start = System.nanoTime();
			m.borrarMin();
			long time_end = System.nanoTime();
			time += time_end-time_start;
			pw.println(time);
		}	
		//System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Calcula los tiempos de minimo un millón de veces
	 * @throws IOException
	 */
	private static void opcion11() throws IOException{
		MonticuloBinomial m = new MonticuloBinomial();
		fichero = new FileWriter("Minimo.dat");
		pw = new PrintWriter(fichero);
		int n = 5000000;
		long time = 0;
		for(int i=1; i<=n; i++){
			m.inserta((int)(Math.random()*n+1));
			long time_start = System.nanoTime();
			m.min();
			long time_end = System.nanoTime();
			time += time_end-time_start;
			pw.println(time);
		}	
		//System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
	/**
	 * Calcula los tiempos de decrecer un millón de veces
	 * @throws IOException
	 */
	private static void opcion12() throws IOException{
		MonticuloBinomial m = new MonticuloBinomial();
		fichero = new FileWriter("Decrecer.dat");
		pw = new PrintWriter(fichero);
		int n = 5000000;
		long time=0;
		//long time = 0;
		for(int j=0; j<=n; j++){
			m.inserta((int)(Math.random()*n+1));
		}
		for(int i=1; i<=n; i++){
			if(m==null || m.esVacio()){}// System.out.println("Montículo vacío");}
			else{
				int num=(int)(Math.random()*(m.numArboles())+1);
				ArbolBinomial a = m.lista().get(num-1); //Arbol Aleatorio
				num=(int)(Math.random()*(a.hijos().size())+0);
				while(num!=0 && !a.hijos().isEmpty()){ //Elijo subárboles aleatorios o si sale 0, el anterior
					a = a.hijos().get(num-1);
					num = (int)(Math.random()*(a.hijos().size())+0);
				}
				num = (int)(Math.random()*n+1); //cantidad a restar
				pw.print(i+"\t");
				//System.out.println("El árbol \"" + a.toString() + " con raíz " + a.raiz() + " ha decrecido un valor de " + num );
				long time_start = System.nanoTime();
				m.decrecerClave(a, num);
				long time_end = System.nanoTime();
				time += time_end - time_start;
				pw.println(time);
			}
		}	
		//System.out.println(m.muestra());
		fichero.close();
		pw.close();
	}
}
