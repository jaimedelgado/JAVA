package expresiones;

public class Mayor extends Exp {
	private Exp opnd1;
	private Exp opnd2;
	public Mayor(Exp opnd1,Exp opnd2) {
		fijaOpnd1(opnd1);
		fijaOpnd2(opnd2);
	}
	public void fijaOpnd1(Exp opnd1) {this.opnd1 = opnd1;}
	public void fijaOpnd2(Exp opnd2) {this.opnd2 = opnd2;}
	public Exp opnd1() {return opnd1;}
	public Exp opnd2() {return opnd2;}
	public void acepta(Procesamiento p) {p.procesa(this);}

}
