package IntercambioDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import Utilidades.Textos;

public class PropietarioArchivo extends Thread{
	private int puerto;
	private File file;
	public PropietarioArchivo(int puerto, File file) {
		this.puerto=puerto; this.file=file;
	}
	
	@SuppressWarnings("deprecation")
	public void run(){
		while(true){
			try{
				ServerSocket listen = new ServerSocket (this.puerto);
				Socket s = listen.accept ();
				BufferedReader fin = new BufferedReader ( new InputStreamReader ( s.getInputStream()));
				PrintWriter fout = new PrintWriter (s.getOutputStream());
				FileReader fr = new FileReader(this.file);
				BufferedReader br = new BufferedReader(fr);
				String linea = null;
				while((linea=br.readLine())!=null){
					fout.println(linea);
					//System.out.println(linea);
				}
				fin.close();
				fout.close();
				fr.close();
				br.close();
				//s.close();
				//listen.close();
			
			}catch(SocketException s){
				// TODO Auto-generated catch block
				s.printStackTrace();
				//pw.println("Servidor: Socket Exception");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	
}
