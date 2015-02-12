package Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import Mensaje.*;
import Servidor.Servidor;
import Utilidades.Textos;
import Utilidades.Utils;

/*
 * Es responsable de llevar a cabo todas las comunicaciones con el servidor, y cuando sea necesario ejecutar el env�o o recepci�n de ficheros.
Adem�s ofrece el soporte para la interacci�n con el usuario del sistema.*/
public class Cliente {
	private String nombre;
	private String ipMaquina;
	//Oyente
	private OyenteCliente oyente;
	//Sockets y flujos
	private Socket s;
	private BufferedReader fin;
	private PrintWriter fout;
	//Sem
	public static Semaphore sem = new Semaphore(1);
	private boolean sesionIniciada;
	private boolean peticionInicioSesion;
	private boolean peticionFinalizarSesion;
	private boolean peticionBuscarArchivo;
	private boolean peticionDescargarArchivo;

	public Cliente() throws IOException{
		this.sesionIniciada=false; this.peticionInicioSesion=false;
		this.peticionBuscarArchivo=false; this.peticionDescargarArchivo=false;
		this.peticionFinalizarSesion=false;
		this.s = new Socket (InetAddress.getLocalHost().getHostAddress(), Utils.PUERTO1);
		this.fin = new BufferedReader (new InputStreamReader (s.getInputStream()));
		this.fout = new PrintWriter (s.getOutputStream());
		this.oyente = new OyenteCliente(this, Utils.PUERTO1, this.s, this.fin);
		this.oyente.start();
	}
	public Cliente(String nombre, String ip, int puerto) throws IOException{
		this.nombre=nombre; this.ipMaquina=ip; this.sesionIniciada=false; this.peticionInicioSesion=false;
		this.s = new Socket (ip, puerto);
		this.fin = new BufferedReader (new InputStreamReader (s.getInputStream()));
		this.fout = new PrintWriter (s.getOutputStream());
		this.oyente = new OyenteCliente(this, puerto, this.s, this.fin);
		this.oyente.start();
	}
	public void inicializaCliente(String nombre, String ip, int puerto) throws IOException{
		this.nombre=nombre; this.ipMaquina=ip; 
	}
	public String ip(){ return this.ipMaquina;}
	public String nombre(){ return this.nombre;}
	public void respuestaInicioSesion(boolean b){ this.sesionIniciada=b; this.peticionInicioSesion=true; }
	public void respuestaFinSesion(){ this.sesionIniciada=false; this.peticionFinalizarSesion=true; }
	public void respuestaDescargaArchivo(){ this.peticionDescargarArchivo=true; }
	public void respuestaBuscarArchivo(){ this.peticionBuscarArchivo=true; }
	
	public void comparteFichero(String fileName, int puerto) throws IOException{
		ServerSocket listen = new ServerSocket (puerto);
		this.s = listen.accept();
		File file = new File("/src/Archivos/"+fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea = null;
		PrintWriter fout = new PrintWriter (this.s.getOutputStream());
		while((linea=br.readLine())!=null){
			fout.println(linea);
		}
	}
	public void descargaFichero(String fileName, int puerto) throws IOException{
		FileWriter file = new FileWriter("/src/ArchivosDescargados/"+fileName);
		@SuppressWarnings("resource")
		PrintWriter fileWriter = new PrintWriter(file);
		String linea = null;
		BufferedReader socketReader = new BufferedReader(new InputStreamReader (this.s.getInputStream()));
		while((linea=socketReader.readLine())!=null){
			fileWriter.println(linea);
		}
	}

	private String pideNombreCliente(){
		System.out.print("Nombre de usuario: ");
		String l;
		while((l=Utils.sc.nextLine())==""){ l=Utils.sc.nextLine();}
		return l;
	}
	private String pideContrasenyaCliente(){
		System.out.print("Contrasenya: ");
		String l;
		while((l=Utils.sc.nextLine())==""){ l=Utils.sc.nextLine();}
		return l;
	}
	private String pideNombreArchivo(){
		System.out.print("Nombre del archivo: ");
		String l;
		while((l=Utils.sc.nextLine())==""){ l=Utils.sc.nextLine();}
		return l;
	}
	private void iniciaSesion() throws InterruptedException, IOException{
		int opcion = Cliente.menuInicioSesion();
		while(opcion!=0){
			switch(opcion){
			case Utils.OPCION_SALIR: System.exit(0); break;
			case Utils.OPCION_INICIAR_SESION: 
				String nombre = this.pideNombreCliente();
				String password = this.pideContrasenyaCliente();
				this.peticionServidor(new IniciarSesion(this.ipMaquina, nombre, password).toString());
				while(this.peticionInicioSesion==false){}
				if(this.sesionIniciada) {
					this.inicializaCliente(nombre, InetAddress.getLocalHost().getHostAddress(), Utils.PUERTO1);
					opcion=0;
				}
				this.peticionInicioSesion=false;
				break;
			default: opcion = Cliente.menuInicioSesion(); break;
			}
		}
	}
	public void iniciaAplicacion() throws InterruptedException, IOException{
		this.iniciaSesion();
		this.aplicacion();
	}
	public Mensaje creaMensaje(Mensaje m){
		return null;
	}
	public void aplicacion() throws InterruptedException{
		int opcion = Cliente.menuAplicacion();
		while(opcion!=Utils.OPCION_SALIR){
			switch(opcion){
			case Utils.OPCION_SALIR: System.exit(0); break;
			case Utils.BUSCAR_ARCHIVO: 
				this.peticionServidor(new BuscarArchivo(this.ipMaquina, this.pideNombreArchivo()).toString());
				while(this.peticionBuscarArchivo==false){}
				break;
			case Utils.DESCARGAR_ARCHIVO:
				this.peticionServidor(new DescargarArchivo(this.ipMaquina, this.pideNombreArchivo()).toString());
				while(this.peticionDescargarArchivo==false){}
				break;
			default: break;
			}
			opcion=Cliente.menuAplicacion();
		}
	}
	public void peticionServidor(String peticion) throws InterruptedException{
		Cliente.sem.acquire();
		//fout.flush();
		fout.println(peticion);
		fout.flush();
		Cliente.sem.release();
	}
	public static int menuInicioSesion(){
		System.out.println("--------------------------------");
		System.out.println("|           Cliente             |");
		System.out.println("--------------------------------");
		System.out.println("|    0. Salir                   |");
		System.out.println("|    1. Iniciar Sesion          |");
		System.out.println("|                               |");
		System.out.println("--------------------------------");
		System.out.print("Elige una opcion: ");
		int opcion = Utils.sc.nextInt();
		Utils.limpiaBuffer(Utils.sc);
		return opcion;
	}
	public static int menuAplicacion(){
		System.out.println("--------------------------------");
		System.out.println("|           Cliente             |");
		System.out.println("--------------------------------");
		System.out.println("|    0. Salir                   |");
		System.out.println("|    1. Buscar archivo          |");
		System.out.println("|    2. Descargar archivo       |");
		System.out.println("|                               |");
		System.out.println("--------------------------------");
		System.out.print("Elige una opcion: ");
		int opcion = Utils.sc.nextInt();
		Utils.limpiaBuffer(Utils.sc);
		return opcion;
	}
	public static void main(String[] args) throws Exception{
		Cliente c1 = new Cliente();
		c1.iniciaAplicacion();
	}
	
}

