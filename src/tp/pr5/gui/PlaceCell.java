/**
 * Representa un lugar en la ciudad en la interfaz Swing. Es un boton, cuyo nombre es el nombre del lugar.
 * Un placeCell necesita almacenar una referencia a la informacion del sitio que representa. 
 * Ademas, este lugar nunca debe ser modificado por el placeCell. Cuando el usuario clickee en un 
 * placeCell, el NavigationPanel mostrará la descripcion del sitio en el log, 
 * si el sitio ya había sido visitado anteriormente.
 */

package tp.pr5.gui;

import java.awt.Color;

import javax.swing.JButton;

import tp.pr5.PlaceInfo;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */
@SuppressWarnings("serial")
public class PlaceCell extends JButton{
	private PlaceInfo placeInfo;
	private boolean actual;
	private boolean visitado;
	/**
	 * Contructora que deja sin inicializar el placeInfo. Se utiliza solo para evitar
	 * fallos cuando pulsas un placeCell. 
	 */
	public PlaceCell(){
		this.actual = false;
		this.visitado = false;
	}
	/**
	 * Constructor de la celda que inicializa su informacion del lugar y pone su atributo visitado a false
	 */
	public PlaceCell(PlaceInfo placeInfo){
		this.actual = false;
		this.visitado = false;
	}
	
	/**
	 * Si el parametro v esta a true, pondrá la casilla de color verde, mostrará su información del lugar,
	 * y pasará a ser la celda actual. Si esta a false se pondrá de color gris
	 * @param v
	 * @param n
	 */
	public void visitaLugar(boolean v, PlaceInfo placeInfo){
		if(!v){
			this.setBackground(Color.gray);
		}else{
			this.actual=true;
			this.setBackground(Color.green);
			this.setText(this.placeInfo.getName());
		}
	}
	/**
	 * Informa si el lugar es el actual o no
	 * @return true si el lugar ya ha sido visitado y false si no
	 */
	public boolean esActual(){
		return this.actual;
	}
	/**
	 * Informa si el lugar ha sido visitado alguna vez o no
	 * @return true si el lugar ha sido visitado alguna vez y false si no
	 */
	public boolean estaVisitado(){
		return this.visitado;
	}
	/**
	 * Devuelve la informacion del lugar que contiene la celda
	 * @return la informacion del lugar que contiene la celda
	 */
	public PlaceInfo placeInfo(){
		return this.placeInfo;
	}
	/**
	 * Inicializa la informaci�n del lugar de la celda y lo visita
	 * @param place - informacion del lugar de la celda
	 */
	public void setPlaceInfo(PlaceInfo place){
		this.visitado = true;
		this.placeInfo = place;
	}
}
