package expresiones;

public class Num extends Exp {
    private double val;
    public Num(double val) {
       fijaValor(val); 
    }
    public void fijaValor(double val) {this.val = val;}
    public double valor() {return val;}
    public void acepta(Procesamiento p) {p.procesa(this);}

}
