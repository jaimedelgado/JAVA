/**
 */
package visitas;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Etapa</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link visitas.Etapa#getHtmlEtapa <em>Html Etapa</em>}</li>
 *   <li>{@link visitas.Etapa#getRecursoEtapa <em>Recurso Etapa</em>}</li>
 *   <li>{@link visitas.Etapa#getContinuacionEtapa <em>Continuacion Etapa</em>}</li>
 * </ul>
 * </p>
 *
 * @see visitas.VisitasPackage#getEtapa()
 * @model
 * @generated
 */
public interface Etapa extends EObject {
	/**
	 * Returns the value of the '<em><b>Html Etapa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Html Etapa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Html Etapa</em>' attribute.
	 * @see #setHtmlEtapa(String)
	 * @see visitas.VisitasPackage#getEtapa_HtmlEtapa()
	 * @model
	 * @generated
	 */
	String getHtmlEtapa();

	/**
	 * Sets the value of the '{@link visitas.Etapa#getHtmlEtapa <em>Html Etapa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Html Etapa</em>' attribute.
	 * @see #getHtmlEtapa()
	 * @generated
	 */
	void setHtmlEtapa(String value);

	/**
	 * Returns the value of the '<em><b>Recurso Etapa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recurso Etapa</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recurso Etapa</em>' reference.
	 * @see #setRecursoEtapa(Recurso)
	 * @see visitas.VisitasPackage#getEtapa_RecursoEtapa()
	 * @model required="true"
	 * @generated
	 */
	Recurso getRecursoEtapa();

	/**
	 * Sets the value of the '{@link visitas.Etapa#getRecursoEtapa <em>Recurso Etapa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recurso Etapa</em>' reference.
	 * @see #getRecursoEtapa()
	 * @generated
	 */
	void setRecursoEtapa(Recurso value);

	/**
	 * Returns the value of the '<em><b>Continuacion Etapa</b></em>' reference list.
	 * The list contents are of type {@link visitas.Continuacion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continuacion Etapa</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continuacion Etapa</em>' reference list.
	 * @see visitas.VisitasPackage#getEtapa_ContinuacionEtapa()
	 * @model
	 * @generated
	 */
	EList<Continuacion> getContinuacionEtapa();

} // Etapa
