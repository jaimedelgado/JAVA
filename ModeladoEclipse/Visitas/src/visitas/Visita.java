/**
 */
package visitas;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visita</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link visitas.Visita#getEtapasVisita <em>Etapas Visita</em>}</li>
 *   <li>{@link visitas.Visita#getContinuacionesVisita <em>Continuaciones Visita</em>}</li>
 *   <li>{@link visitas.Visita#getRecursosVisita <em>Recursos Visita</em>}</li>
 * </ul>
 * </p>
 *
 * @see visitas.VisitasPackage#getVisita()
 * @model
 * @generated
 */
public interface Visita extends EObject {
	/**
	 * Returns the value of the '<em><b>Etapas Visita</b></em>' containment reference list.
	 * The list contents are of type {@link visitas.Etapa}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Etapas Visita</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etapas Visita</em>' containment reference list.
	 * @see visitas.VisitasPackage#getVisita_EtapasVisita()
	 * @model containment="true"
	 * @generated
	 */
	EList<Etapa> getEtapasVisita();

	/**
	 * Returns the value of the '<em><b>Continuaciones Visita</b></em>' containment reference list.
	 * The list contents are of type {@link visitas.Continuacion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continuaciones Visita</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continuaciones Visita</em>' containment reference list.
	 * @see visitas.VisitasPackage#getVisita_ContinuacionesVisita()
	 * @model containment="true"
	 * @generated
	 */
	EList<Continuacion> getContinuacionesVisita();

	/**
	 * Returns the value of the '<em><b>Recursos Visita</b></em>' containment reference list.
	 * The list contents are of type {@link visitas.Recurso}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursos Visita</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursos Visita</em>' containment reference list.
	 * @see visitas.VisitasPackage#getVisita_RecursosVisita()
	 * @model containment="true"
	 * @generated
	 */
	EList<Recurso> getRecursosVisita();

} // Visita
