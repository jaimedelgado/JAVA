package IntercambioDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DescargaArchivo extends Thread {
	private String file;
	private String ip;
	private int puerto;
	public DescargaArchivo(String ip, int puerto, String file) {
		this.ip=ip; this.file=file; this.puerto=puerto;
	}
	public void run(){
		while(true){
			try{
				boolean leido = false;
				File f = new File("src\\ArchivosDescargados\\"+this.file);
				FileWriter file = new FileWriter("src\\ArchivosDescargados\\"+this.file);
				PrintWriter fileWriter = new PrintWriter(file);
				String linea = null;
				Socket socket = new Socket(this.ip, this.puerto);
				BufferedReader socketReader = new BufferedReader(new InputStreamReader (socket.getInputStream()));
				while((linea=socketReader.readLine())!=null){
					fileWriter.println(linea);
					//System.out.println(linea);
					leido=true;
				}
				
				file.close();
				fileWriter.close();
				//socketReader.close();
				//if(leido){
					//System.exit(0);}
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		
	}
}
