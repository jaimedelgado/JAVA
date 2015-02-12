package Utilidades;

public class Textos {
	//Mensajes
	public static final String INICIAR_SESION = "iniciarSesion";
	public static final String FINALIZAR_SESION = "finalizarSesion";
	public static final String DESCARGAR_ARCHIVO = "descargarArchivo";
	public static final String BUSCAR_ARCHIVO = "buscarArchivo";
	// ENTRADA CLIENTE
	public static final String EXISTE_USUARIO = "existeUsuario";
	public static final String NO_EXISTE_USUARIO = "noExisteUsuario";
	public static final String EXISTE_ARCHIVO = "existeArchivo";
	public static final String NO_EXISTE_ARCHIVO = "noExisteArchivo";
	public static final String COMPARTE_ARCHIVO = "comparteArchivo";
	public static final String comparteArchivo(String archivo, int puerto){ 
		return Textos.COMPARTE_ARCHIVO + " " + archivo + " " + puerto;
	}
	public static final String DESCARGA_ARCHIVO = "descargaArchivo";
	public static final String descargaArchivo(String archivo, int puerto){ 
		return Textos.COMPARTE_ARCHIVO + " " + archivo + " " + puerto;
	}
	public static final String DESCARGA_FINALIZADA = "descargaFinalizada";
}
