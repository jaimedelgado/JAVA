package interpreteExpresiones;

import expresiones.*;

public class InterpreteExpresiones extends Procesamiento {
  private Valor valor; 
  private Ambito ambito;
  public InterpreteExpresiones(){
	  this.ambito=new Ambito();
  }
  public Valor interpreta(Exp exp) {
    ambito = new Ambito();  
    exp.acepta(this);
    return valor;
  }
  public Valor valor(){ return valor;}
  public Ambito ambito(){ return ambito;}
  public void procesa(Num exp) {
     valor = new ValorNumerico(exp.valor()); 
  }
  public void procesa(Var exp) {
     valor = ambito.valorDe(exp.var()); 
  }
  public void procesa(Suma exp) {
     exp.opnd1().acepta(this);
     Valor v1 = valor;
     exp.opnd2().acepta(this);
     if (v1.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en suma:"+v1);  
     if (valor.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en suma:"+valor);
     valor = new ValorNumerico(v1.valor()+valor.valor());
  }
  public void procesa(Resta exp) {
     exp.opnd1().acepta(this);
     Valor v1 = valor;
     exp.opnd2().acepta(this);
     if (v1.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en resta:"+v1);  
     if (valor.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en resta:"+valor);
     valor = new ValorNumerico(v1.valor()-valor.valor());
  }
  public void procesa(Mul exp) {
     exp.opnd1().acepta(this);
     Valor v1 = valor;
     exp.opnd2().acepta(this);
     if (v1.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en multiplicacion:"+v1);  
     if (valor.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en multiplicacion:"+valor);
     valor = new ValorNumerico(v1.valor()*valor.valor());
  }
  public void procesa(Menor exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()<valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(MenorOIgual exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()<=valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(Mayor exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()>valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(MayorOIgual exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()>=valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(Igual exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()==valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(Not exp){
	  exp.opnd1().acepta(this);
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  if(valor.valor()== 0){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(1); } 
  }
  public void procesa(Or exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en OR:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en OR:"+valor);
	  
	  if(v1.valor()!=0 | valor.valor()!=0){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(Distinto exp){
	  exp.opnd1().acepta(this);
	  Valor v1 = valor;
	  exp.opnd2().acepta(this);
	  if (v1.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
	  if (valor.tipo() != TVALOR.NUMERICO) 
		  throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
	  
	  if(v1.valor()!=valor.valor()){ valor = new ValorNumerico(1);}
	  else{ valor = new ValorNumerico(0); } 
  }
  public void procesa(Div exp) {
     exp.opnd1().acepta(this);
     Valor v1 = valor;
     exp.opnd2().acepta(this);
     if (v1.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
     if (valor.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
     valor = new ValorNumerico(v1.valor()/valor.valor());
  }
  public void procesa(Mod exp) {
     exp.opnd1().acepta(this);
     Valor v1 = valor;
     exp.opnd2().acepta(this);
     if (v1.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en division:"+v1);  
     if (valor.tipo() != TVALOR.NUMERICO) 
        throw new RuntimeException("Valor de tipo erróneo en division:"+valor);
     valor = new ValorNumerico(v1.valor()%valor.valor());
  }
  public void procesa(Seq exp) {
     valor = null;
     for(Exp e: exp.exps()) {
       e.acepta(this); 
     }
  }
  public void procesa(Write exp) {
     exp.exp().acepta(this);
     System.out.println(valor);
  }
  public void procesa(Asig exp) {
     exp.exp().acepta(this);
     ambito.fijaValor(exp.var(),valor);
  }
  public void procesa(IfThenElse exp) {
     exp.condicion().acepta(this);
     if (valor.tipo() == TVALOR.NUMERICO && valor.valor()==0)
        exp.pelse().acepta(this);
     else 
        exp.pif().acepta(this); 
  }
  public void procesa(While exp) {
     exp.condicion().acepta(this);
     while (!(valor.tipo() == TVALOR.NUMERICO && valor.valor()==0)){
        exp.cuerpo().acepta(this);
     	exp.condicion().acepta(this);
     }
  }
  public void procesa(Fun exp) {
    valor = new CierreLexico(ambito,exp);  
  }
  public void procesa(Call exp) {
    exp.cierre().acepta(this);
    Valor cierre = valor;
    if (cierre.tipo() != TVALOR.CIERRE)
       throw new RuntimeException("Se está intentando llamar a:"+cierre); 
    if (cierre.funcion().params().length != exp.args().length)
        throw new RuntimeException("Numero de parámetros incorrectos en llamada a:"+cierre);
    Valor[] vargs = new Valor[exp.args().length];        
    for (int i=0; i < vargs.length; i++) {
         exp.args()[i].acepta(this);
         vargs[i] = valor;
    }   
    Ambito ambitoActual = ambito;
    ambito = new Ambito(cierre.ambito());
    for(int i=0; i < vargs.length; i++) 
         ambito.fijaValorEnLocal(cierre.funcion().params()[i],vargs[i]);
    cierre.funcion().cuerpo().acepta(this);
    ambito = ambitoActual;
  }
}
