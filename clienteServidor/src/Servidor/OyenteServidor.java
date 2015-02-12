package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import Utilidades.Textos;
import Utilidades.Utils;

/*será usada para llevar a cabo una escucha continua en el canal de comunicación con el servidor, en un hilo diferente, proporcionándose así concurrencia.*/
public class OyenteServidor extends Thread{
	private Servidor server;
	private int puerto;
	public OyenteServidor(Servidor server, int puerto) {
		this.server = server; this.puerto=puerto;
	}

	public void run() {
		try{
			ServerSocket listen = new ServerSocket (this.puerto);
			while ( true){
					Socket s = listen.accept ();
					BufferedReader fin = new BufferedReader ( new InputStreamReader ( s.getInputStream()));
					PrintWriter fout = new PrintWriter (s.getOutputStream(), true);
					String l=null;
					while((l=fin.readLine())!=null){
						System.out.println(l);
						if(!l.equals("")){
							String[] strs = l.split(" ");
							String origen = strs[0];
							String destino = strs[1];
							String tipoMensaje = strs[2];
							switch(tipoMensaje){
							case Textos.BUSCAR_ARCHIVO: 
								server.atiendeBusquedaArchivo(origen, destino, strs[3], fout); break;
							case Textos.DESCARGAR_ARCHIVO: 
								server.atiendeDescargaArchivo(origen, destino, strs[3], fout); break;
							case Textos.FINALIZAR_SESION: server.atiendeFinalizarSesion(origen, destino); break;
							case Textos.INICIAR_SESION: server.atiendeIniciarSesion(origen, destino, strs[3], strs[4], fout);
							default: break;
							}
						}else{ l=null;}
					}
					fin.close();
					fout.close();
					//s.close();
					listen.close();
			
			}
		}catch(SocketException s){
			// TODO Auto-generated catch block
			s.printStackTrace();
			//pw.println("Servidor: Socket Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
