/**
 * Clase que contiene un ejemplo de Etapa para poder hacer pruebas de ejecución del programa.
 * Contiene un atributo estatico de la clase que se llama "etapaEjemplo"
 */
package modelo;

/**
 * @author Jaime Delgado Linares
 *
 */
public class EtapaEjemplo {
	public final static Etapa etapaEjemplo =
		new Etapa(
				new Recurso(
						"walleNorth.png" , 
						"Walle-Norte", 
						"RWalleNorte.html"),
				new Continuacion[]{
					new Continuacion("SUR",
									 	new Etapa(
									 			new Recurso(
									 					"walleSouth.png",
									 					"Walle-Sur",
									 					"RWalleSur.html"),
									 			new Continuacion[]{
									 				new Continuacion("EAST",
														 	new Etapa(
														 			new Recurso(
														 					"walleEast.png",
														 					"Walle-Este",
														 					"RWalleEste.html"),
														 			new Continuacion[]{},
														 			0,
														 			"EtapaWalleEste.html") )
									 			},
									 			1,
									 			"EtapaWalleSur.html") ),
		 			new Continuacion("OESTE",
						 	new Etapa(
						 			new Recurso(
						 					"walleWest.png",
						 					"Walle-Oeste",
						 					"RWalleOeste.html"),
						 			new Continuacion[]{},
						 			0,
						 			"EtapaWalleOeste.html"))},
				2,
				"EtapaWalleNorthTraductor.html");
					
			
				
				
	
}
