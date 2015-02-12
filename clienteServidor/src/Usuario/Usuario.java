package Usuario;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	private String idUsuario;
	private String password;
	private String ipMaquina;
	private Map<String,File> ficheros;

	public Usuario(String id, String password, String ip){
		this.idUsuario = id;
		this.password = password;
		this.ipMaquina = ip;
		this.ficheros = new HashMap<String,File>();

	}
	public String id(){ return this.idUsuario;}
	public String contrasenya(){ return this.password; }
	public String ip(){ return this.ipMaquina; }
	public boolean existeFichero(String arch){ 
		return this.ficheros.containsKey(arch);	}
	public void addFichero(File file){	this.ficheros.put(file.getName(), file);}
	public File fichero(String a){	return this.ficheros.get(a);}
}
