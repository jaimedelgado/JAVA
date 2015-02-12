/**
 * 
 */
package modelo;

import interpretePull.InterpretePullConsola;

/**
 * @author Jaime Delgado Linares
 *
 */
public class EtapaEjemploTecnicaConstructores extends Etapa{

	/**
	 * 
	 */
	public EtapaEjemploTecnicaConstructores() {
		// TODO Auto-generated constructor stub
	}
	public void ejecuta(){
		Etapa e = etapa(
				recurso(
						"walleNorth.png" , 
						"Walle-Norte", 
						"index.html"),
				continuaciones(
					continuacion(
							
							"SUR",
									 	etapa(
									 			recurso(
									 					"walleSouth.png",
									 					"Walle-Sur",
									 					"recursoWalleSouth.html"),
									 			continuaciones(
									 				continuacion("EAST",
														 	etapa(
														 			recurso(
														 					"walleEast.png",
														 					"Walle-Este",
														 					"recursoWalleEast.html"),
														 			continuaciones(),
														 			0,
														 			"etapaWalleEast.html") )
									 			),
									 			1,
									 			"etapaWalleSouth.html") ),
		 			continuacion("OESTE",
						 	etapa(
						 			recurso(
						 					"walleWest.png",
						 					"Walle-Oeste",
						 					"recursoWalleWest.html"),
						 			continuaciones(),
						 			0,
						 			"etapaWalleWest.html"))),
				2,
				"etapaWalleNorth.html");
		
		InterpretePullConsola interprete = new InterpretePullConsola(e);
        interprete.inicia();
        
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EtapaEjemploTecnicaConstructores().ejecuta();

	}

}
