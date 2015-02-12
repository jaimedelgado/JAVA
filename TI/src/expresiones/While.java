package expresiones;

public class While extends Exp{
	private Exp condicion;
   private Exp cuerpo;
   public While(Exp condicion,Exp cuerpo) {
     fijaCondicion(condicion);
     fijaCuerpo(cuerpo);
   }
   public void fijaCondicion(Exp condicion) {
     this.condicion = condicion;  
   }
   public void fijaCuerpo(Exp exp) {
     this.cuerpo = exp;  
   }

   public Exp condicion() {return condicion;}
   public Exp cuerpo() {return cuerpo;}
   public void acepta(Procesamiento p) {p.procesa(this);}

}
