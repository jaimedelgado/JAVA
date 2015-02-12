package interpreteExpresiones;

import java.util.HashMap;
import java.util.Map;

public class Ambito {
  private Ambito padre;
  private Map<String,Valor> vinculos;
  public Ambito(Ambito padre) {
   this.padre = padre;
   vinculos = new HashMap<String,Valor>(); 
  }    
  public Ambito() {
     this(null); 
  }
  public Valor valorDe(String var) {
    Ambito actual = this;
    while (actual != null) {
     Valor valor = actual.vinculos.get(var);
     if (valor != null) return valor;
     actual = actual.padre;
    }
    throw new RuntimeException("Variable no existente:"+var);
  }
  public void fijaValor(String var, Valor valor) {
    Ambito actual = this;
    while (actual != null) {
      if (actual.vinculos.containsKey(var)) break; 
      actual = actual.padre;
    }
    if (actual == null) 
       vinculos.put(var, valor);
    else
       actual.vinculos.put(var,valor);        
  }
  public void fijaValorEnLocal(String var,Valor valor) {
     vinculos.put(var,valor); 
  } 
}
