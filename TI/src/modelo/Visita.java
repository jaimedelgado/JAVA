package modelo;

import expresiones.Exp;

public class Visita {
	private Exp expresion;
	private Etapa etapaInicial;
	public Visita(){}
	public Visita(Exp exp, Etapa etapa){ this.expresion=exp; this.etapaInicial=etapa;}
	public Etapa etapaInicial(){ return this.etapaInicial;}
	public boolean tieneExpresion(){ return expresion!=null;}
	public Exp expresion(){ return this.expresion;}
	public void add(Exp exp, Etapa etapa){ this.expresion=exp; this.etapaInicial=etapa;}
}
