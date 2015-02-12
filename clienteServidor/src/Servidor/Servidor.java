package Servidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import Cliente.Cliente;
import IntercambioDatos.DescargaArchivo;
import IntercambioDatos.PropietarioArchivo;
import Usuario.Usuario;
import Utilidades.Textos;
import Utilidades.Utils;

public class Servidor{
	private Map<String, Usuario> usuarios;
	private OyenteServidor oyente;
	public Servidor(int puerto) throws IOException{
		this.leeUsuarios();
		this.oyente = new OyenteServidor(this, puerto);
		this.oyente.start();
	}
	private void leeUsuarios() throws IOException{
		this.usuarios = new HashMap<String, Usuario>();
		File users = new File("users.txt");
		FileReader fr = new FileReader(users);
		BufferedReader br = new BufferedReader(fr);
		int puerto = 12000;
		Usuario u = null;
		String nombre = null, password = null, fileName = null;
		String linea=br.readLine();
		while(linea!=null){
			switch(linea){
			case "usuario": 
				nombre = br.readLine();
				password = br.readLine();
				u = new Usuario(nombre, password, InetAddress.getLocalHost().getHostAddress());
				linea=br.readLine();
				break;
			case "archivos":
				linea=br.readLine();
				while(!linea.equals("finusuario")){
					u.addFichero(new File("/src/Archivos/"+linea));
					linea = br.readLine();
				}
				break;
			case "finusuario":
				this.usuarios.put(nombre, u);
				linea = br.readLine();
				break;
			default: break;
			}
		}
		fr.close(); 
		br.close();
	}
	public Usuario buscaQuienTieneArchivo(String archivo){
		Iterator<Usuario> it = this.usuarios.values().iterator();
		Usuario u=null;
		boolean encontrado=false;
		while(!encontrado && it.hasNext()){
			u = it.next();
			encontrado = u.existeFichero(archivo);
		}
		if(encontrado){ return u;}
		else{ return null;}
	}
	public void atiendeBusquedaArchivo(String origen, String destino, String archivo, PrintWriter fout) {
		Usuario u = this.buscaQuienTieneArchivo(archivo);
		if(u!=null){ fout.println(Textos.EXISTE_ARCHIVO);
		}else{ fout.println(Textos.NO_EXISTE_ARCHIVO); }
	}
	public void atiendeDescargaArchivo(String origen, String destino, String archivo, PrintWriter fout) throws NumberFormatException, IOException, InterruptedException {
		Thread t1 = new PropietarioArchivo(Utils.PUERTO2, new File("src\\Archivos\\"+archivo));
		Thread t2 = new DescargaArchivo(InetAddress.getLocalHost().getHostAddress(), Utils.PUERTO2, archivo);
		t2.start();
		t1.start();
		
		fout.println(Textos.DESCARGA_FINALIZADA);
	}
	public void atiendeFinalizarSesion(String origen, String destino) {
		
	}
	public void atiendeIniciarSesion(String origen, String destino, String nombre, String contrasenya, PrintWriter fout) {
		Usuario u = this.usuarios.get(nombre);
		if(this.usuarios.containsKey(nombre) && this.usuarios.get(nombre).contrasenya().equals(contrasenya)){
			fout.println(Textos.EXISTE_USUARIO);
		}else{
			fout.println(Textos.NO_EXISTE_USUARIO);
		}
		
	}
	public static void main(String[] args) throws IOException{
		Servidor s = new Servidor(Utils.PUERTO1);
	}
}
