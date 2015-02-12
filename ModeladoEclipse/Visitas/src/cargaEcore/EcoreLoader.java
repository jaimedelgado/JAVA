/**
 * Esta clase crea a partir de un modelo ecore, nuestro modelo original.
 * Podemos usar los métodos Etapa:load(String uri) y Etapa:loadAndWeb(String uri)
 */

package cargaEcore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Etapa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import traductor.Traductor;
import visitas.Visita;
import visitas.VisitasPackage;
/**
 * @author Jaime Delgado linares
 *
 */
public class EcoreLoader {
	private visitas.Visita visita;
	private HashMap<String, modelo.Recurso> tablaRecursos;
	private HashMap<String, modelo.Etapa> tablaEtapas;
	private Etapa etapaIni;
	private String etapaActual;
	/**
	 * Constructor sin parametros
	 */
	public EcoreLoader(){
		this.tablaRecursos = new HashMap<String, modelo.Recurso>();
		this.tablaEtapas = new HashMap<String, modelo.Etapa>();
	}
	/**
	 * Carga el archivo especificado por uri y devuelve la primera etapa
	 * @param uri - ruta del archivo .visitas que quieres leer
	 * @return Primera etapa del modelo
	 */
   public modelo.Etapa load(String uri) {
	   // Initialize the model
	    VisitasPackage.eINSTANCE.eClass();
	    
	    // Register the XMI resource factory for the .dialogossv extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("visitas", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(URI
	        .createURI(uri), true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    this.visita = (Visita) resource.getContents().get(0);
	    return cambiaModelo(this.visita);
	   
   }	
   /**
    * Introduce todos los recursos de la visita en una tabla de recursos con clave la id del recurso.
    * Recorre la lista de elementos "recurso" y va leyendo sus atributos y creando los recursos para luego meterlos
    * en la tabla de recursos.
    */ 
   private void creaRecursos() {
	   EList<visitas.Recurso> recursos = this.visita.getRecursosVisita();
		for(int contRecursos=0; contRecursos<recursos.size(); contRecursos++){
			visitas.Recurso r = recursos.get(contRecursos);
			this.tablaRecursos.put(r.toString(), 
					new modelo.Recurso(r.getImagenRecurso(), 
							r.getDescripcionRecurso(),
							r.getHtmlRecurso()));
		}
	
   }


   /**
    * Procesa todas las etapas con la ayuda de una tabla de etapas. Recorre todos los elementos etapa de la visita,
    * coge todos sus elementos y va actualizando la etapa segun lo va procesando de forma secuencial.
    */
   private void creaEtapas() {
	   EList<visitas.Etapa> nodosEtapas = this.visita.getEtapasVisita();
		for(int contNodosEtapas=0; contNodosEtapas<nodosEtapas.size(); contNodosEtapas++){
			visitas.Etapa etapa = nodosEtapas.get(contNodosEtapas);
			this.leeEtapa(etapa);
			EList<visitas.Continuacion> continuaciones = etapa.getContinuacionEtapa();
			for(int numContinuaciones=0; numContinuaciones<continuaciones.size(); numContinuaciones++){
				visitas.Continuacion elem = continuaciones.get(numContinuaciones);
				
				this.leeContinuacion(elem);
				
			}
		}
	
   }



/**
    * Lee la etapa referente a un nodo etapa
    * @param etapa - Nodo de la etapa que quieres leer
    * @return La etapa leida
    */
   private void leeEtapa(visitas.Etapa etapa){
	   
	   	boolean primeraEtapa = false;
		String idEtapa = etapa.toString();
  		String recursoEtapa = etapa.getRecursoEtapa().toString();
  		String htmlEtapa = etapa.getHtmlEtapa().toString();
  		this.etapaActual = idEtapa;
  		//Comprueba si es la primera etapa para actualizar la primera etapa y poder lanzar la aplicacion
  		if(this.tablaEtapas.isEmpty()){
		   primeraEtapa=true;
  		}
  		if(!this.tablaEtapas.containsKey(idEtapa)){ //La etapa es nueva, nunca ha sido referenciada
  			modelo.Etapa e = new Etapa();
			e.setRecurso(this.tablaRecursos.get(recursoEtapa));
			e.setHtml(htmlEtapa);
		   	this.tablaEtapas.put(idEtapa, e);
  			if(primeraEtapa){etapaIni=e;} //Pongo primera etapa que va a ser lanzada
  			
  		}else{ //La etapa ha podido ser creada por una Continuacion y entonces tenemos que actualizar esa etapa ya creada
  			modelo.Etapa e = this.tablaEtapas.get(idEtapa);
			e.setRecurso(this.tablaRecursos.get(recursoEtapa));
			e.setHtml(htmlEtapa);
			this.tablaEtapas.put(idEtapa, e);
  			
  		}
   }
   /**
    * Lee un elemento Continuacion de la visita.
    * Suponemos que si estamos leyendo una continuacion es porque ya se ha leido la etapa que contiene esta continuacion.
    * Si la etapa a la que refiere no esta creada, la creamos y ya serï¿½ actualizada cuando leamos la correspondiente etapa.
    * Si la etapa a la que refiere ya esta creada aï¿½adimos dicha etapa a la continuacion.
    */
   	private void leeContinuacion(visitas.Continuacion continuacion) {
   		String descripcionContinuacion = continuacion.getTextoContinuacion();
   		String etapaContinuacion = continuacion.getEtapaContinuacion().toString();
   		modelo.Etapa e = this.tablaEtapas.get(this.etapaActual);
   		if(this.tablaEtapas.containsKey(etapaContinuacion)){
   			e.addContinuacion(new modelo.Continuacion(descripcionContinuacion, this.tablaEtapas.get(etapaContinuacion)));
   		}else{
   			Etapa etapaNueva = new Etapa();
   			this.tablaEtapas.put(etapaContinuacion, etapaNueva);
   			e.addContinuacion(new modelo.Continuacion(descripcionContinuacion, etapaNueva));
   		}
   	}
   	/**
   	 * Traduce el modelo ecore al modelo original
   	 * @param v - Visita del modelo ecore
   	 * @return Primera etapa de nuestro modelo
   	 */
   private modelo.Etapa cambiaModelo(visitas.Visita v){
	   //Creo tabla de recursos
		this.creaRecursos();			
		//Creo etapas
		this.creaEtapas();
		return this.etapaIni;
   }
   /**
    * Carga el archivo uri y crea los archivos html necesarios para la version web
    * y los introduce en la ruta carpeta
    * @param uri - archivo .visitas
    * @param carpeta - nombre de la carpeta (dentro de src)
    * @return Primera etapa del modelo
    */
	public modelo.Etapa loadAndWeb(String uri, String carpeta) {
		// Initialize the model
	    VisitasPackage.eINSTANCE.eClass();
	    
	    // Register the XMI resource factory for the .dialogossv extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("visitas", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(URI
	        .createURI(uri), true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    this.visita = (Visita) resource.getContents().get(0);
	    return cambiaModeloWeb(this.visita, carpeta);
	}
	   private modelo.Etapa cambiaModeloWeb(Visita miVisita, String carpeta) {
		   //Creo tabla de recursos
			this.creaRecursos();
		   //Creo etapas
			this.creaEtapas();			
			
			this.traduce(carpeta);
			return this.etapaIni;
	}

	/**
	    * Crea los archivos html en la carpeta src/carpeta
	    * @param carpeta - Nombre de la carpeta (dentro de src)
	    */
	   private void traduce(String carpeta) {
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
		   Iterator<Entry<String, modelo.Etapa>> it = this.tablaEtapas.entrySet().iterator();
			while (it.hasNext()) {
				modelo.Etapa e = (Etapa) it.next().getValue();
				Traductor.traduceEtapa(e, dir);
			}
			
		}


	   /**
	    * Crea los documentos html de los recursos en el directorio dir dentro de src
	    * @param dir - Nombre del directorio donde se van a guardar los archivos html dentro de src
	    */
	   private void creaHtmlRecursos(String dir) {
		   Iterator<Entry<String, modelo.Recurso>> it = this.tablaRecursos.entrySet().iterator();
			while (it.hasNext()) {
				modelo.Recurso r = it.next().getValue();
				Traductor.traduceRecurso(r, dir);
			}
			
			
		}
}