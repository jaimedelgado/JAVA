package sintaxisConstructoras;

import interpretePull.InterpretePull;
import interpretePull.InterpretePullConsola;
import interpretePull.InterpretePullGUI;
import interpretePush.InterpretePush;
import interpretePush.InterpretePushConsola;
import modelo.Etapa;
import expresiones.Exp;

@SuppressWarnings("unused")
public class EjemploConstructoras extends SintaxisConstructoras{

	public EjemploConstructoras() {
		// TODO Auto-generated constructor stub
	}
	private Exp precondicionEtapaSur(){
		return
				seq(
			             fun("NuevoContador",ps("valor"),
			                  lambda(
			                     seq(
			                       asig("valorActual",var("valor")),
			                       asig("valor",suma(var("valor"),num(1))),
			                       var("valorActual")))),
			             asig("contador",call("NuevoContador",num(5))),
			             asig("contador2",call("NuevoContador",num(8))),
			             write(apply(var("contador"))),
			             write(apply(var("contador2"))),
			             write(apply(var("contador"))),
			             write(apply(var("contador2"))),
			             write(apply(var("contador"))),
			             write(apply(var("contador2")))
			            );
	}
	private Exp accionEtapaSur(){
		return
				seq(fun("CuentaAtras", ps("num"),
	    				seq(
	    					mientras(distinto(var("num"), num(0)), 
	    						seq(
	    							write(var("num")),
	    							asig("num", resta(var("num"), num(1)))
	    								)
	    							)
	    					)
						),
    			call("CuentaAtras",num(9)));
	}
	
	public Etapa etapaEjemplo(){
		return 
			visita(
					seq(
					           fun("factorial",ps("n"),
					                ifthenelse(var("n"),
					                   mul(var("n"),
					                       call("factorial",resta(var("n"),num(1)))),
					                   num(1))),
					           write(call("factorial",num(5)))),
				etapa(
					recurso(
							"walleNorth.png" , 
							"Walle-Norte", 
							"index.html"),
					continuaciones(
						continuacion(
								precondicion(this.precondicionEtapaSur()),
								accion(this.accionEtapaSur()),
				    			
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
			 			continuacion(
			 					precondicion(null),
			 					accion(null),
			 					"OESTE",
							 	etapa(
							 			recurso(
							 					"walleWest.png",
							 					"Walle-Oeste",
							 					"recursoWalleWest.html"),
							 			continuaciones(),
							 			0,
							 			"etapaWalleWest.html"))),
					2,
					"etapaWalleNorth.html")
				);
	}
	
	public static void main(String[] args){
		/*InterpretePush i = new InterpretePushConsola(new EjemploConstructoras().etapaEjemplo());
		i.inicia();*/
		/*InterpretePull i2 = new InterpretePullGUI(new EjemploConstructoras().etapaEjemplo());
		i2.inicia();*/
		InterpretePull i1 = new InterpretePullConsola(new EjemploConstructoras().etapaEjemplo());
		i1.inicia();
		while(true){ i1.transita();}
		
	}
}
