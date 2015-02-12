/**
 * Clase que representa un vinculador Dom. 
 * Sirve para parsear un archivo xml y construir el modelo a partir de los datos del archivo. 
 * Los recursos los procesa por tag y los guarda en una tabla de recursos.
 * Las etapas se van procesando segun se va leyendo de forma secuencial y se van actualizando sus continuaciones.
 */
package apidom;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullConsola;
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
import modelo.Visita;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import expresiones.*;
import traductor.Traductor;
/**
 * 
 * @author Jaime Delgado Linares
 *
 */
@SuppressWarnings("unused")
public class VinculadorDomExtendido {
	private HashMap<String, Recurso> tablaRecursos;
	private HashMap<String, Etapa> tablaEtapas;
	private Etapa etapaIni;
	private Document doc;
	private String etapaActual; //Etapa que estamos leyendo
	private Exp expresionIni;
    
    //Constructor
	/**
	 * Constructora sin argumentos de un vinculador stax
	 */
    public VinculadorDomExtendido(){
    	this.tablaRecursos = new HashMap<String, Recurso>();
    	this.tablaEtapas = new HashMap<String, Etapa>();
    }
    
   
    /**
     * Ejecuta el vinculador Dom. Crea el flujo con el archivo que recibe por parï¿½metro, crea todo el modelo, y devuelve la etapa
     * principal.
     * @param file - Ruta del archivo xml que quieres leer
     */
   public Visita ejecutaVinculador(String file){
	   try{
		   	// Creo flujo con el archivo xml
		   	this.creaFlujoArchivo(file);
		   	//Creo expresion inicial si la hay
		   	this.creaExpresionIni();
			//Creo tabla de recursos
			this.creaRecursos();			
			//Creo etapas
			this.creaEtapas();
			
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    
	   return new Visita(this.expresionIni, this.etapaIni);
   	} 
   /**
    * Ejecuta el vinculador Dom. Crea el flujo con el archivo que recibe por parï¿½metro, crea todo el modelo, y devuelve la etapa
    * principal. También crea en la carpeta "carpeta" los archivos html necesarios para crear la version web
    * @param file - Ruta del archivo xml que quieres leer
    * @param carpeta - Ruta donde quieres guardar los archivos html en la carpeta src
    */
  public Visita ejecutaVinculadorHtml(String file, String carpeta){
	   try{
		   	// Creo flujo con el archivo xml
		   	this.creaFlujoArchivo(file);
		  //Creo expresion inicial si la hay
		   	this.creaExpresionIni();
			//Creo tabla de recursos
			this.creaRecursos();			
			//Creo etapas
			this.creaEtapas();
			//Traduce creando los archivos html y los mete en la carpeta que le digas
			this.traduce(carpeta);
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    
	   return new Visita(this.expresionIni, this.etapaIni);
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
   private void creaExpresionIni(){
	   NodeList expresion = doc.getElementsByTagName("expresionIni");
		for(int i=0; i<expresion.getLength(); i++){
			Node r = expresion.item(i);
			this.expresionIni = leeExpresion(primerElementoHijo(r));
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
   private Node primerElementoHijo(Node n) {
       n = n.getFirstChild();
       while (n == null || n.getNodeType() != Node.ELEMENT_NODE) n = n.getNextSibling();
       return n;
   }
   private Node siguienteElementoHermano(Node n) {
      n = n.getNextSibling(); 
      while (n == null || n.getNodeType() != Node.ELEMENT_NODE) n = n.getNextSibling();
      return n;  
   }
   /**
    * Lee un elemento Continuacion del archivo xml que estamos leyendo.
    * Suponemos que si estamos leyendo una continuacion es porque ya se ha leido la etapa que contiene esta continuacion.
    * Si la etapa a la que refiere no esta creada, la creamos y ya serï¿½ actualizada cuando leamos la correspondiente etapa.
    * Si la etapa a la que refiere ya esta creada aï¿½adimos dicha etapa a la continuacion.
    */
   	private void leeContinuacion(Node continuacion) {
   		Exp precondicion=null, accion=null;
   		String descripcionContinuacion = continuacion.getAttributes().getNamedItem("descripcion").getNodeValue();
   		String etapaContinuacion = continuacion.getAttributes().getNamedItem("etapaSiguiente").getNodeValue();
   		Etapa e = this.tablaEtapas.get(this.etapaActual);
   		if(continuacion.hasChildNodes()){
   			Node pre = primerElementoHijo(primerElementoHijo(continuacion));
   			Node a = primerElementoHijo(siguienteElementoHermano(primerElementoHijo(continuacion)));
   			precondicion=leeExpresion(pre);
   			accion=leeExpresion(a);
   		}
   		if(this.tablaEtapas.containsKey(etapaContinuacion)){
   			e.addContinuacion(new Continuacion(precondicion, accion, descripcionContinuacion, this.tablaEtapas.get(etapaContinuacion)));
   		}else{
   			Etapa etapaNueva = new Etapa();
   			this.tablaEtapas.put(etapaContinuacion, etapaNueva);
   			e.addContinuacion(new Continuacion(precondicion, accion, descripcionContinuacion, etapaNueva));
   		}
   	}
 
   	private Exp leeExpresion(Node expNode){
   		Exp exp=null; 
   		String tipo = expNode.getNodeName();
   		Node op1;
		switch(tipo){
   		case "asig": 
   			String variable = expNode.getAttributes().getNamedItem("variable").getNodeValue();
   			exp = new Asig(variable, leeExpresion(primerElementoHijo(expNode)));
   			break;
   		case "call": 
   			String nombre = expNode.getAttributes().getNamedItem("nombre").getNodeValue();
   			int numArgs = Integer.parseInt(expNode.getAttributes().getNamedItem("numArgs").getNodeValue());
   			Exp[] args = new Exp[numArgs];
   			for(int i=0; i<numArgs; i++){
   				if(i==0){
   					expNode = primerElementoHijo(expNode); 
   					args[i]=leeExpresion(expNode);
   				}else{
	   				expNode = siguienteElementoHermano(expNode);
	   				args[i] = leeExpresion(expNode);
   				}
   			}
   			exp = new Call(new Var(nombre), args);
   			break;
   		case "distinto": 
   			op1 = primerElementoHijo(expNode);
   			exp = new Distinto(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "div": 
   			op1 = primerElementoHijo(expNode);
   			exp = new Div(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "igual":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Igual(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "mayoroigual":  
   			op1 = primerElementoHijo(expNode);
   			exp = new MayorOIgual(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "menor":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Menor(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "menoroigual":  
   			op1 = primerElementoHijo(expNode);
   			exp = new MenorOIgual(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "mod":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Mod(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "mul":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Mul(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "or":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Or(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "resta":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Resta(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "suma":  
   			op1 = primerElementoHijo(expNode);
   			exp = new Suma(leeExpresion(op1), leeExpresion(siguienteElementoHermano(op1)));
   			break;
   		case "fun": 
   			String nombre1 = expNode.getAttributes().getNamedItem("nombre").getNodeValue();
   			int numParams = Integer.parseInt(expNode.getAttributes().getNamedItem("numParams").getNodeValue());
   			String params[] = new String[numParams];
   			Exp cuerpo=null;
   			if(numParams==0){ 
   				cuerpo = leeExpresion(primerElementoHijo(expNode));
   			}else{
   				for(int i=0; i<params.length; i++){
	   				if(i==0){ 
	   					expNode = primerElementoHijo(expNode);
	   					params[i] = expNode.getTextContent();
	   				}else{ 
	   					expNode = siguienteElementoHermano(expNode);
	   					params[i] = expNode.getNodeValue();
	   				}
	   			}
   				cuerpo = leeExpresion(siguienteElementoHermano(expNode));
   			}
   			exp = new Asig(nombre1, new Fun(params, cuerpo));
   			break;
   		case "ifthenelse": ;
   			Node condicion=primerElementoHijo(expNode);
   			Node If=siguienteElementoHermano(condicion);
   			Node Else=siguienteElementoHermano(If);
   			exp=new IfThenElse(leeExpresion(primerElementoHijo(condicion)), leeExpresion(primerElementoHijo(If)),
   					leeExpresion(primerElementoHijo(Else)));
   			break;
   		case "not": exp=new Not(leeExpresion(expNode.getAttributes().getNamedItem("exp"))); break;
   		case "num": exp=new Num(Double.parseDouble(expNode.getAttributes().getNamedItem("valor").getNodeValue())); break;
   		case "seq":
   			int numExps = Integer.parseInt(expNode.getAttributes().getNamedItem("numExps").getTextContent());
   			Exp[] exps = new Exp[numExps];
   			for(int i=0; i<numExps; i++){
   				if(i==0){ 
   					expNode = primerElementoHijo(expNode); 
   					exps[i] = leeExpresion(expNode);
   				}else{ 
   					expNode = siguienteElementoHermano(expNode);
   					exps[i] = leeExpresion(expNode);
   				}
   			}
   			exp = new Seq(exps);
   			break;
   		case "var": exp=new Var(expNode.getAttributes().getNamedItem("nombre").getNodeValue());break;
   		case "while": 
   			Node cond = primerElementoHijo(expNode);
   			Exp condicion1 = leeExpresion(primerElementoHijo(cond));
   			Exp cuerpo1 = leeExpresion(siguienteElementoHermano(cond));
   			exp = new While(condicion1, cuerpo1);
   			break;
   		case "write": exp=new Write(leeExpresion(primerElementoHijo(expNode)));break;
   		case "cuerpo": 
   			if(expNode.hasChildNodes()){exp = leeExpresion(primerElementoHijo(expNode));} break;
   		default: System.out.println("MAL");break;
   		}
   		return exp;
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
	   VinculadorDomExtendido vinculador = new VinculadorDomExtendido();
	   Visita visita= vinculador.ejecutaVinculadorHtml("src/SintaxisXML/ejemploExtendido.xml", "pruebaFinal");
	   //InterpreteConsola interprete = new InterpreteConsola(etapa);
	   //interprete.muestraConsola();
	   InterpretePull i = new InterpretePullConsola(visita);
	   i.inicia();
	   while(true){ i.transita();}
   }
}
