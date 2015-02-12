package interpreteExpresiones;


import expresiones.Fun;

public abstract class Valor {
   public abstract TVALOR tipo(); 
   public double valor() {throw new UnsupportedOperationException();}  
   public Ambito ambito() {throw new UnsupportedOperationException();} 
   public Fun funcion() {throw new UnsupportedOperationException();} 
}
