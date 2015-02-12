package expresiones;

public class Fun extends Exp {
   private String[] params;
   private Exp cuerpo;
   public Fun(String[] params,Exp cuerpo) {
    fijaParams(params);
    fijaCuerpo(cuerpo);
   }
   public void fijaParams(String[] params) {this.params = params;}
   public void fijaCuerpo(Exp cuerpo) {this.cuerpo = cuerpo;}
   public String[] params() {return params;}
   public Exp cuerpo() {return cuerpo;}
   public void acepta(Procesamiento p) {p.procesa(this);}
}
