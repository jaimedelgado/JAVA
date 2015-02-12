package expresiones;

public class Call extends Exp {
   private Exp cierre;
   private Exp[] args;
   public Call(Exp cierre, Exp[] args) {
     this.cierre = cierre;
     this.args = args;
   }
   public void fijaCierre(Exp cierre) {this.cierre = cierre;}
   public void fijaArgs(Exp[] args) {this.args = args;}
   public Exp cierre() {return cierre;}
   public Exp[] args() {return args;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
