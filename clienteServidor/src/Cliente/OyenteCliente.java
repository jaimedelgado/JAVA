package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

import Utilidades.Textos;

/*
 * usada para proporcionar concurrencia respecto a las sesiones de casa
   usuario con el servidor. El metodo \run()" se limita a hacer lecturas del 
   flujo de entrada correspondiente, realizar las acciones oportunas, y devolver los resultados
   en forma de mensajes que seran enviados al usuario o usuarios involucrados.
*/
public class OyenteCliente extends Thread {
	private Cliente cliente; 
	private int puerto;
	private Socket s;
	private BufferedReader fin;
	private PrintWriter fout;
	
	public OyenteCliente(Cliente cliente, int puerto, Socket s, BufferedReader fin) throws IOException{
		this.cliente=cliente;
		this.s = s;
		this.fin = fin;
		this.fout = new PrintWriter (s.getOutputStream());
	}
	
	public void run() {
		try{
			while ( true){
					String l=null;
					while((l=fin.readLine())!=null){
						System.out.println(l);
						if(!l.equals("")){
							String[] strs = l.split(" ");
							switch(strs[0]){
							case Textos.EXISTE_USUARIO: 
								this.cliente.respuestaInicioSesion(true);
								break;
							case Textos.NO_EXISTE_USUARIO: 
								this.cliente.respuestaInicioSesion(false);
								break;
							case Textos.EXISTE_ARCHIVO: 
								System.out.println("SI existe el archivo"); 
								this.cliente.respuestaBuscarArchivo();
								break;					
							case Textos.NO_EXISTE_ARCHIVO: 
								System.out.println("NO existe el archivo"); 
								this.cliente.respuestaBuscarArchivo();
								break;
							case Textos.DESCARGA_FINALIZADA:
								System.out.println("Descarga finalizada");
								this.cliente.respuestaDescargaArchivo();
								break;
							default: break;
							}
						}else{ l=null;}
					}
					fin.close();
					fout.close();
					s.close();
			
			}
		}catch(SocketException s){
			// TODO Auto-generated catch block
			//s.printStackTrace();
			//pw.println("Servidor: Socket Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

}
