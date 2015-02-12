/**
 * Clase que representa un vinculador stax.
 * Sirve para parsear un archivo xml y construir el modelo a partir de los datos del archivo. 
 * Va procesando los elementos secuencialmente ayudandose de una tabla de recursos y una tabla de etapas.
 * Se va creando todo segun se va encontrando, y se va actualizando segï¿½n vuelve a aparecer.
 */
package apistax;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import traductor.Traductor;
import modelo.Continuacion;
import modelo.Etapa;
import modelo.Recurso;
/**
 * 
 * @author Jaime Delgado Linares
 *
 */
public class VinculadorStax {
	private HashMap<String, Recurso> tablaRecursos;
	private HashMap<String, Etapa> tablaEtapas;
	private Etapa etapaIni;
	private XMLStreamReader xmlsr;
	private String etapaActual; //Etapa que estamos leyendo
    
    //Constructor
	/**
	 * Constructor del vinculador Stax
	 */
    public VinculadorStax(){
    	this.tablaRecursos = new HashMap<String, Recurso>();
    	this.tablaEtapas = new HashMap<String, Etapa>();
    }
    /**
     * Ejecuta el vinculados stax. Lee el archivo xml representado por el string "file" y crea todo el modelo.
     * Devuelve una etapa null si el archivo no es correcto
     * @param file - ruta del archivo xml que quieres leer
     * @return La etapa principal de la visita
     */
   public Etapa ejecutaVinculador(String file){
	   try {
		   	this.creaFlujoArchivo(file);     
	        while(xmlsr.hasNext()){
	        	int event = xmlsr.next();
	        	switch(event){
	        	case XMLEvent.START_ELEMENT: 
	        		String tag = xmlsr.getLocalName();
	        		switch(tag){
	        		case "etapa":
	        			this.leeEtapa();
	        			break;
	        		case "visita":
	        			break;
	        		case "continuacion":
	        			this.leeContinuacion();
	        			break;
	        		case "recurso":
	        			this.leeRecurso();
	        			break;
	        		default: break;
	        				
	        		}
	        		break;
	        	
	        	default: break;
	        		
	        	}
	        		
	        }
	        
	        
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    return this.etapaIni;
   	} 
   /**
    * Ejecuta el vinculados stax. Lee el archivo xml representado por el string "file" y crea todo el modelo.
    * También crea una carpeta "carpeta" dentro de src con todos los archivos html necesarios para representar el modelo.
    * Devuelve una etapa null si el archivo no es correcto
    * @param file - ruta del archivo xml que quieres leer
    * @param carpeta - nombre de la carpeta donde quieres que se guarden los archivos html
    * @return La etapa principal de la visita
    */
  public Etapa ejecutaVinculadorHtml(String file, String carpeta){
	   try {
		   	this.creaFlujoArchivo(file);     
	        while(xmlsr.hasNext()){
	        	int event = xmlsr.next();
	        	switch(event){
	        	case XMLEvent.START_ELEMENT: 
	        		String tag = xmlsr.getLocalName();
	        		switch(tag){
	        		case "etapa":
	        			this.leeEtapa();
	        			break;
	        		case "visita":
	        			break;
	        		case "continuacion":
	        			this.leeContinuacion();
	        			break;
	        		case "recurso":
	        			this.leeRecurso();
	        			break;
	        		default: break;
	        				
	        		}
	        		break;
	        	
	        	default: break;
	        		
	        	}
	        		
	        }
	        this.traduce(carpeta);
	        
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    return this.etapaIni;
  	} 
   /**
    * Crea los archivos html en la carpeta src/carpeta
    * @param carpeta - Nombre de la carpeta (dentro de src)
    */
   private void traduce(String carpeta) {
	   	File directorio = new File("src\\"+carpeta);
		directorio.mkdirs();
		//Creo los archivos html de los recursos
		this.creaHtmlRecursos(carpeta);
		//Creo los archivos html de las etapas
		this.creaHtmlEtapas(carpeta);
	}
/**
    * Crea los documentos html de las etapas en el directorio dir
    * @param dir - Nombre del directorio donde quieres guardar los archivos html
    */
   private void creaHtmlEtapas(String dir) {
	   Iterator<Entry<String, Etapa>> it = this.tablaEtapas.entrySet().iterator();
		while (it.hasNext()) {
			Etapa e = it.next().getValue();
			Traductor.traduceEtapa(e, dir);
		}
		
	}


   /**
    * Crea los documentos html de los recursos dentro del directorio dir
    * @param dir - Nombre del directorio donde quieres que se guarden los archivos html
    */
   private void creaHtmlRecursos(String dir) {
		Iterator<Entry<String, Recurso>> it = this.tablaRecursos.entrySet().iterator();
		while (it.hasNext()) {
			Recurso r = it.next().getValue();
			Traductor.traduceRecurso(r, dir);
		}
		
	}
   /**
    * Lee un elemento Recurso del archivo xml que estamos leyendo.
    * 
    */
   private void leeRecurso() {
	   String idRecurso = xmlsr.getAttributeValue(0);
	   String descripcionRecurso = xmlsr.getAttributeValue(1);
	   String imagenRecurso = xmlsr.getAttributeValue(2);
	   String htmlRecurso = xmlsr.getAttributeValue(3);
	   if(!this.tablaRecursos.containsKey(idRecurso)){
		   this.tablaRecursos.put(xmlsr.getAttributeValue(0), new Recurso(descripcionRecurso, imagenRecurso, htmlRecurso));
	   }else{
		   Recurso r = this.tablaRecursos.get(idRecurso);
		   r.setDescripcion(descripcionRecurso);
		   r.setImagen(imagenRecurso);
		   r.setHtml(htmlRecurso);
	   }
	
   }
   /**
    * Lee un elemento Continuacion del archivo xml que estamos leyendo.
    * Suponemos que si estamos leyendo una continuacion es porque ya se ha leido la etapa que contiene esta continuacion.
    * Si la etapa a la que refiere no esta creada, la creamos y ya serï¿½ actualizada cuando leamos la correspondiente etapa.
    * Si la etapa a la que refiere ya esta creada aï¿½adimos dicha etapa a la continuacion.
    */
   	private void leeContinuacion() {
   		String descripcionContinuacion = xmlsr.getAttributeValue(0);
   		String etapaContinuacion = xmlsr.getAttributeValue(1);
   		Etapa e = this.tablaEtapas.get(this.etapaActual);
   		if(this.tablaEtapas.containsKey(etapaContinuacion)){
   			e.addContinuacion(new Continuacion(descripcionContinuacion, this.tablaEtapas.get(etapaContinuacion)));
   		}else{
   			Etapa etapaNueva = new Etapa();
   			this.tablaEtapas.put(etapaContinuacion, etapaNueva);
   			e.addContinuacion(new Continuacion(descripcionContinuacion, etapaNueva));
   		}
   	}
   	/**
   	 * Lee un elemento etapa del archivo xml que se esta leyendo.
   	 * Comprueba si es la primera etapa que se lee, para que esa sea la etpa inicial que se ejecute en la visita.
   	 * Si la tabla de etapas ya contenia esta etapa porque la habia creado una Continuacion actualizamos esta etapa.
   	 * Tambien comprobamos si el recurso de la etapa ya esta creado o no, y si no estaba creado, lo creamos (Ya se actualizara
   	 * cuando leamos ese recurso)
   	 */
   	private void leeEtapa(){
   		boolean primeraEtapa = false;
   		String idEtapa = xmlsr.getAttributeValue(0);
   		String recursoEtapa = xmlsr.getAttributeValue(1);
   		String htmlEtapa = xmlsr.getAttributeValue(2);
   		this.etapaActual = idEtapa;
   		//Comprueba si es la primera etapa para actualizar la primera etapa y poder lanzar la aplicacion
   		if(this.tablaEtapas.isEmpty()){
		   primeraEtapa=true;
   		}
   		if(!this.tablaEtapas.containsKey(idEtapa)){ //La etapa es nueva, nunca ha sido referenciada
   			Etapa e = new Etapa();
   			if(this.tablaRecursos.containsKey(recursoEtapa)){
   				e.setRecurso(this.tablaRecursos.get(recursoEtapa));
   				e.setHtml(htmlEtapa);
			   	this.tablaEtapas.put(idEtapa, e);
   			}else{
   				Recurso r = new Recurso();
   				this.tablaRecursos.put(recursoEtapa, r);
   				e.setRecurso(r);
   				e.setHtml(htmlEtapa);
   				this.tablaEtapas.put(idEtapa, e);
   			}
   			if(primeraEtapa){etapaIni=e;} //Pongo primera etapa que va a ser lanzada
   			
   		}else{ //La etapa ha podido ser creada por una Continuacion y entonces tenemos que actualizar esa etapa ya creada
   			Etapa e = this.tablaEtapas.get(idEtapa);
   			if(this.tablaRecursos.containsKey(recursoEtapa)){
   				e.setRecurso(this.tablaRecursos.get(recursoEtapa));
   				e.setHtml(htmlEtapa);
   				this.tablaEtapas.put(idEtapa, e);
   			}else{
   				Recurso r = new Recurso();
   				this.tablaRecursos.put(recursoEtapa, r);
   				e.setRecurso(r);
   				e.setHtml(htmlEtapa);
   				this.tablaEtapas.put(idEtapa, e);
   			}
   		}
   	}
	/**
    * Crea el flujo a traves de la ruta de un archivo xml especificado por el atributo file
    * @param file - String con ela ruta del archivo xml que quieres leer
    * @throws FileNotFoundException - Si no se encuentra el archivo especificado
    * @throws XMLStreamException - Si hay algun fallo en el archivo xml
    */
   private void creaFlujoArchivo(String file) throws FileNotFoundException, XMLStreamException{
	   //Creamos el flujo
       XMLInputFactory xmlif = XMLInputFactory.newFactory();

       this.xmlsr = xmlif.createXMLStreamReader(new FileInputStream(file));
   }
   /**
    * Ejemplo de ejecucion del vinculador stax
    * @param args
    */
   public static void main(String args[]){
	   VinculadorStax vinculador = new VinculadorStax();
	   Etapa etapa= vinculador.ejecutaVinculadorHtml("src/SintaxisConcreta/ejemplo.xml", "otraPrueba");
	   InterpretePull i = new InterpretePullGUI(etapa);
	   i.inicia();
	   //InterpreteConsola interprete = new InterpreteConsola(etapa);
	   //interprete.muestraConsola();
	   
   }
}
