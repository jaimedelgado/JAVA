package expresiones;

public class IfThenElse extends Exp {
   private Exp condicion;
   private Exp expIf;
   private Exp expElse;
   public IfThenElse(Exp condicion,Exp expIf,Exp expElse) {
     fijaCondicion(condicion);
     fijaExpIf(expIf);
     fijaExpElse(expElse);
   }
   public void fijaCondicion(Exp condicion) {
     this.condicion = condicion;  
   }
   public void fijaExpIf(Exp expIf) {
     this.expIf = expIf;  
   }
   public void fijaExpElse(Exp expElse) {
     this.expElse = expElse;  
   }
   public Exp condicion() {return condicion;}
   public Exp pif() {return expIf;}
   public Exp pelse() {return expElse;}
   public void acepta(Procesamiento p) {p.procesa(this);}

}
