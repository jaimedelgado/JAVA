package expresiones;

public class Write extends Exp {
   private Exp exp;
   public Write(Exp exp) {
      fijaExp(exp); 
   }
   public void fijaExp(Exp exp) {this.exp = exp;}
   public Exp exp() {return this.exp;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
