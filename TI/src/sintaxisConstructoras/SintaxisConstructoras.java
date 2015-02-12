package sintaxisConstructoras;

import expresiones.*;
import modelo.Continuacion;
import modelo.Etapa;
import modelo.Recurso;

public class SintaxisConstructoras {
	//Modelo
	public Etapa etapa(Recurso rec, Continuacion[] array, int num, String h){
		return new Etapa(rec,array,num,h);
	}
	public Recurso recurso(String i, String d, String h){
		return new Recurso(i,d,h);
	}
	public Continuacion[] continuaciones(Continuacion ... cs ){
		return cs;
	}
	public Continuacion continuacion(String t, Etapa e){
		return new Continuacion(t,e);
	}
	public Continuacion continuacion(Exp pre, Exp acc, String t, Etapa e){
		return new Continuacion(pre, acc, t, e);
	}
	public Etapa visita(Exp exp, Etapa e){ return new Etapa(exp, e);}
	public Etapa visita(Etapa e){ return e;}
	public Exp precondicion(Exp exp){ return exp;}
	public Exp accion(Exp exp){ return exp;}
	
	//Expresiones
	public Exp distinto(Exp exp1, Exp exp2){ return new Distinto(exp1, exp2);}
	public Exp div(Exp exp1, Exp exp2){ return new Div(exp1, exp2);}
	public Exp igual(Exp exp1, Exp exp2){ return new Igual(exp1, exp2); }
	public Exp mayor(Exp exp1, Exp exp2){ return new Mayor(exp1, exp2); }
	public Exp mayoroigual(Exp exp1, Exp exp2){ return new MayorOIgual(exp1, exp2); }
	public Exp menor(Exp exp1, Exp exp2){ return new Menor(exp1, exp2); }
	public Exp menoroigual(Exp exp1, Exp exp2){ return new MenorOIgual(exp1, exp2); }
	public Exp mod(Exp exp1, Exp exp2){ return new Mod(exp1, exp2); }
	public Exp not(Exp exp1){ return new Not(exp1); }
	public Exp or(Exp exp1, Exp exp2){ return new Or(exp1, exp2); }
	public Exp mientras(Exp exp1, Exp exp2){ return new While(exp1, exp2); }
	
	public Exp var(String var) {return new Var(var);} 
	public Exp num(double val) {return new Num(val);} 
	public Exp suma(Exp opnd1,Exp opnd2) {return new Suma(opnd1,opnd2);} 
	public Exp resta(Exp opnd1,Exp opnd2) {return new Resta(opnd1,opnd2);} 
	public Exp mul(Exp opnd1,Exp opnd2) {return new Mul(opnd1,opnd2);} 
	public Exp write(Exp exp) {return new Write(exp);} 
	public Exp seq(Exp ... exps) {return new Seq(exps);} 
	public Exp asig(String var, Exp exp) {return new Asig(var,exp);} 
	public Exp lambda(String[] params, Exp exp) {return new Fun(params,exp);}
	public Exp lambda(Exp exp) {return new Fun(new String[]{},exp);}
   	public Exp fun(String nombre,String[] params, Exp exp) {
   		return asig(nombre,lambda(params,exp)); 
   	}
   	public Exp fun(String nombre,Exp exp) {
   		return asig(nombre,lambda(exp)); 
   	}
   	public String[] ps(String ... params) {return params;}
   	public Exp call(String fun,Exp ... args) {
   		return apply(var(fun),args); 
   	}
   	public Exp apply(Exp cierre, Exp ... args) {return new Call(cierre,args);}
   	public Exp ifthenelse(Exp condicion, Exp pif, Exp pelse) {
   		return new IfThenElse(condicion,pif,pelse);  
   	}
}
