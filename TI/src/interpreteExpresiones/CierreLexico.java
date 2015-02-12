package interpreteExpresiones;

import expresiones.Fun;

public class CierreLexico extends Valor {
  private Ambito ambito;
  private Fun funcion;
  public TVALOR tipo() {return TVALOR.CIERRE;};   
  public CierreLexico(Ambito ambito,Fun funcion) {
   this.ambito = ambito;
   this.funcion = funcion;
  }
  public Ambito ambito() {return ambito;}
  public Fun funcion() {return funcion;}
  public String toString() {
    StringBuffer b = new StringBuffer();
    b.append(super.toString());
    b.append("(");
    for(String p: funcion.params()) 
       b.append(p+"  ");
    b.append(")"); 
    return b.toString();
  }
}
