package expresiones;

public class Seq extends Exp {
   private Exp[] exps;
   public Seq(Exp[] exps) {
      fijaExps(exps);  
   }
   public void fijaExps(Exp[] exps) {this.exps = exps;}
   public Exp[] exps() {return exps;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
