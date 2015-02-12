/**
 * Clase que representa un vinculador Dom. 
 * Sirve para parsear un archivo xml y construir el modelo a partir de los datos del archivo. 
 * Los recursos los procesa por tag y los guarda en una tabla de recursos.
 * Las etapas se van procesando segun se va leyendo de forma secuencial y se van actualizando sus continuaciones.
 */
package apidom;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullGUI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelo.Continuacion;
import modelo.Etapa;
import modelo.Recurso;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import traductor.Traductor;
/**
 * 
 * @author Jaime Delgado Linares
 *
 */
public class VinculadorDom {
	private HashMap<String, Recurso> tablaRecursos;
	private HashMap<String, Etapa> tablaEtapas;
	private Etapa etapaIni;
	private Document doc;
	private String etapaActual; //Etapa que estamos leyendo
    
    //Constructor
	/**
	 * Constructora sin argumentos de un vinculador stax
	 */
    public VinculadorDom(){
    	this.tablaRecursos = new HashMap<String, Recurso>();
    	this.tablaEtapas = new HashMap<String, Etapa>();
    }
    
   
    /**
     * Ejecuta el vinculador Dom. Crea el flujo con el archivo que recibe por parï¿½metro, crea todo el modelo, y devuelve la etapa
     * principal.
     * @param file - Ruta del archivo xml que quieres leer
     */
   public Etapa ejecutaVinculador(String file){
	   try{
		   	// Creo flujo con el archivo xml
		   	this.creaFlujoArchivo(file);
			//Creo tabla de recursos
			this.creaRecursos();			
			//Creo etapas
			this.creaEtapas();
			
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    
	   return this.etapaIni;
   	} 
   /**
    * Ejecuta el vinculador Dom. Crea el flujo con el archivo que recibe por parï¿½metro, crea todo el modelo, y devuelve la etapa
    * principal. También crea en la carpeta "carpeta" los archivos html necesarios para crear la version web
    * @param file - Ruta del archivo xml que quieres leer
    * @param carpeta - Ruta donde quieres guardar los archivos html en la carpeta src
    */
  public Etapa ejecutaVinculadorHtml(String file, String carpeta){
	   try{
		   	// Creo flujo con el archivo xml
		   	this.creaFlujoArchivo(file);
			//Creo tabla de recursos
			this.creaRecursos();			
			//Creo etapas
			this.creaEtapas();
			//Traduce creando los archivos html y los mete en la carpeta que le digas
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
    * Crea los documentos html de las etapas en el directorio dir (dentro de src)
    * @param dir - Nombre del directorio donde se van a guardar los archivos html (dentro de src)
    */
   private void creaHtmlEtapas(String dir) {
	   Iterator<Entry<String, Etapa>> it = this.tablaEtapas.entrySet().iterator();
		while (it.hasNext()) {
			Etapa e = it.next().getValue();
			Traductor.traduceEtapa(e, dir);
		}
		
	}


   /**
    * Crea los documentos html de los recursos en el directorio dir dentro de src
    * @param dir - Nombre del directorio donde se van a guardar los archivos html dentro de src
    */
   private void creaHtmlRecursos(String dir) {
		Iterator<Entry<String, Recurso>> it = this.tablaRecursos.entrySet().iterator();
		while (it.hasNext()) {
			Recurso r = it.next().getValue();
			Traductor.traduceRecurso(r, dir);
		}
		
		
	}


/**
    * Introduce todos los recursos del archivo xml en una tabla de recursos con clave la id del recurso.
    * Recorre la lista de elementos "recurso" y va leyendo sus atributos y creando los recursos para luego meterlos
    * en la tabla de recursos.
    */ 
   private void creaRecursos() {
	   NodeList recursos = doc.getElementsByTagName("recurso");
		for(int contRecursos=0; contRecursos<recursos.getLength(); contRecursos++){
			Node r = recursos.item(contRecursos);
			this.tablaRecursos.put(r.getAttributes().getNamedItem("id").getTextContent(), 
					new Recurso(r.getAttributes().getNamedItem("imagen").getTextContent(), 
							r.getAttributes().getNamedItem("descripcion").getTextContent(),
							r.getAttributes().getNamedItem("html").getTextContent()));
		}
	
   }



   /**
    * Procesa todas las etapas con la ayuda de una tabla de etapas. Recorre todos los elementos etapa,
    * coge todos sus hijos y va actualizando la etapa segun lo va procesando de forma secuencial.
    */
   private void creaEtapas() {
	   NodeList nodosEtapas = doc.getElementsByTagName("etapa");
		for(int contNodosEtapas=0; contNodosEtapas<nodosEtapas.getLength(); contNodosEtapas++){
			Node etapa = nodosEtapas.item(contNodosEtapas);
			this.leeEtapa(etapa);
			NodeList continuaciones = etapa.getChildNodes();
			for(int numContinuaciones=0; numContinuaciones<continuaciones.getLength(); numContinuaciones++){
				Node elem = continuaciones.item(numContinuaciones);
				if(elem.getNodeType()==Node.ELEMENT_NODE){
					this.leeContinuacion(elem);
				}
			}
		}
	
   }



/**
    * Lee la etapa referente a un nodo etapa
    * @param etapa - Nodo de la etapa que quieres leer
    * @return La etapa leida
    */
   private void leeEtapa(Node etapa){
	   
	   	boolean primeraEtapa = false;
		String idEtapa = etapa.getAttributes().getNamedItem("id").getNodeValue();
  		String recursoEtapa = etapa.getAttributes().getNamedItem("recurso").getNodeValue();
  		String htmlEtapa = etapa.getAttributes().getNamedItem("html").getNodeValue();
  		this.etapaActual = idEtapa;
  		//Comprueba si es la primera etapa para actualizar la primera etapa y poder lanzar la aplicacion
  		if(this.tablaEtapas.isEmpty()){
		   primeraEtapa=true;
  		}
  		if(!this.tablaEtapas.containsKey(idEtapa)){ //La etapa es nueva, nunca ha sido referenciada
  			Etapa e = new Etapa();
			e.setRecurso(this.tablaRecursos.get(recursoEtapa));
			e.setHtml(htmlEtapa);
		   	this.tablaEtapas.put(idEtapa, e);
  			if(primeraEtapa){etapaIni=e;} //Pongo primera etapa que va a ser lanzada
  			
  		}else{ //La etapa ha podido ser creada por una Continuacion y entonces tenemos que actualizar esa etapa ya creada
  			Etapa e = this.tablaEtapas.get(idEtapa);
			e.setRecurso(this.tablaRecursos.get(recursoEtapa));
			e.setHtml(htmlEtapa);
			this.tablaEtapas.put(idEtapa, e);
  			
  		}
   }
   /**
    * Lee un elemento Continuacion del archivo xml que estamos leyendo.
    * Suponemos que si estamos leyendo una continuacion es porque ya se ha leido la etapa que contiene esta continuacion.
    * Si la etapa a la que refiere no esta creada, la creamos y ya serï¿½ actualizada cuando leamos la correspondiente etapa.
    * Si la etapa a la que refiere ya esta creada aï¿½adimos dicha etapa a la continuacion.
    */
   	private void leeContinuacion(Node continuacion) {
   		String descripcionContinuacion = continuacion.getAttributes().getNamedItem("descripcion").getNodeValue();
   		String etapaContinuacion = continuacion.getAttributes().getNamedItem("etapaSiguiente").getNodeValue();
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
    * Crea flujo con el archivo dado
    * @param file
    * @throws SAXException
    * @throws IOException
    * @throws ParserConfigurationException
    */
   private void creaFlujoArchivo(String file) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(new File(file));
		doc.getDocumentElement().normalize();
   }
   
   /**
    * Ejemplo de ejecuciï¿½n del vinculador Dom
    * @param args
    */
   public static void main(String args[]){
	   VinculadorDom vinculador = new VinculadorDom();
	   Etapa etapa= vinculador.ejecutaVinculadorHtml("src/SintaxisConcreta/ejemplo.xml", "pruebaFinal");
	   //InterpreteConsola interprete = new InterpreteConsola(etapa);
	   //interprete.muestraConsola();
	   InterpretePull i = new InterpretePullGUI(etapa);
	   while(true){i.inicia();}
   }
}
