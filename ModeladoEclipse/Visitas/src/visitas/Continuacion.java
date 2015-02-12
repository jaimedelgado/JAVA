/**
 */
package visitas;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Continuacion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link visitas.Continuacion#getTextoContinuacion <em>Texto Continuacion</em>}</li>
 *   <li>{@link visitas.Continuacion#getEtapaContinuacion <em>Etapa Continuacion</em>}</li>
 * </ul>
 * </p>
 *
 * @see visitas.VisitasPackage#getContinuacion()
 * @model
 * @generated
 */
public interface Continuacion extends EObject {
	/**
	 * Returns the value of the '<em><b>Texto Continuacion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texto Continuacion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texto Continuacion</em>' attribute.
	 * @see #setTextoContinuacion(String)
	 * @see visitas.VisitasPackage#getContinuacion_TextoContinuacion()
	 * @model
	 * @generated
	 */
	String getTextoContinuacion();

	/**
	 * Sets the value of the '{@link visitas.Continuacion#getTextoContinuacion <em>Texto Continuacion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texto Continuacion</em>' attribute.
	 * @see #getTextoContinuacion()
	 * @generated
	 */
	void setTextoContinuacion(String value);

	/**
	 * Returns the value of the '<em><b>Etapa Continuacion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Etapa Continuacion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etapa Continuacion</em>' reference.
	 * @see #setEtapaContinuacion(Etapa)
	 * @see visitas.VisitasPackage#getContinuacion_EtapaContinuacion()
	 * @model required="true"
	 * @generated
	 */
	Etapa getEtapaContinuacion();

	/**
	 * Sets the value of the '{@link visitas.Continuacion#getEtapaContinuacion <em>Etapa Continuacion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etapa Continuacion</em>' reference.
	 * @see #getEtapaContinuacion()
	 * @generated
	 */
	void setEtapaContinuacion(Etapa value);

} // Continuacion
