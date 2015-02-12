package expresiones;

public class Var extends Exp {
    private String var;
    public Var(String var) {
       fijaVar(var);   
    }
    public void fijaVar(String var) {this.var = var;}
    public String var() {return var;}
    public void acepta(Procesamiento p) {p.procesa(this);}
}
