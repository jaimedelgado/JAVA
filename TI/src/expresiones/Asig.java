package expresiones;

public class Asig extends Exp {
   private String var;
   private Exp exp;
   public Asig(String var,Exp exp) {
     fijaVar(var);
     fijaExp(exp);
   }
   public void fijaVar(String var) {this.var = var;}
   public void fijaExp(Exp exp) {this.exp = exp;}
   public Exp exp() {return exp;}
   public String var() {return var;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
