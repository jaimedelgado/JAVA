package expresiones;

public class Not extends Exp {
   private Exp opnd1;

   public Not(Exp opnd1) {
     fijaOpnd1(opnd1);
   }
   public void fijaOpnd1(Exp opnd1) {this.opnd1 = opnd1;}
   public Exp opnd1() {return opnd1;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
