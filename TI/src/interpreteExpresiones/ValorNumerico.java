package interpreteExpresiones;

public class ValorNumerico extends Valor {
  private double val;
  public TVALOR tipo() {return TVALOR.NUMERICO;}; 
  public ValorNumerico(double val) {
    this.val = val;  
  }
  public double valor() {return val;}
  public String toString() {return val+"";}
}
