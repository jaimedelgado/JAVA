/**
 */
package visitas.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import visitas.Recurso;
import visitas.VisitasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recurso</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link visitas.impl.RecursoImpl#getHtmlRecurso <em>Html Recurso</em>}</li>
 *   <li>{@link visitas.impl.RecursoImpl#getImagenRecurso <em>Imagen Recurso</em>}</li>
 *   <li>{@link visitas.impl.RecursoImpl#getDescripcionRecurso <em>Descripcion Recurso</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecursoImpl extends MinimalEObjectImpl.Container implements Recurso {
	/**
	 * The default value of the '{@link #getHtmlRecurso() <em>Html Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlRecurso()
	 * @generated
	 * @ordered
	 */
	protected static final String HTML_RECURSO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHtmlRecurso() <em>Html Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlRecurso()
	 * @generated
	 * @ordered
	 */
	protected String htmlRecurso = HTML_RECURSO_EDEFAULT;

	/**
	 * The default value of the '{@link #getImagenRecurso() <em>Imagen Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagenRecurso()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGEN_RECURSO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImagenRecurso() <em>Imagen Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagenRecurso()
	 * @generated
	 * @ordered
	 */
	protected String imagenRecurso = IMAGEN_RECURSO_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescripcionRecurso() <em>Descripcion Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescripcionRecurso()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPCION_RECURSO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescripcionRecurso() <em>Descripcion Recurso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescripcionRecurso()
	 * @generated
	 * @ordered
	 */
	protected String descripcionRecurso = DESCRIPCION_RECURSO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecursoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitasPackage.Literals.RECURSO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHtmlRecurso() {
		return htmlRecurso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHtmlRecurso(String newHtmlRecurso) {
		String oldHtmlRecurso = htmlRecurso;
		htmlRecurso = newHtmlRecurso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.RECURSO__HTML_RECURSO, oldHtmlRecurso, htmlRecurso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImagenRecurso() {
		return imagenRecurso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImagenRecurso(String newImagenRecurso) {
		String oldImagenRecurso = imagenRecurso;
		imagenRecurso = newImagenRecurso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.RECURSO__IMAGEN_RECURSO, oldImagenRecurso, imagenRecurso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescripcionRecurso() {
		return descripcionRecurso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescripcionRecurso(String newDescripcionRecurso) {
		String oldDescripcionRecurso = descripcionRecurso;
		descripcionRecurso = newDescripcionRecurso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.RECURSO__DESCRIPCION_RECURSO, oldDescripcionRecurso, descripcionRecurso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisitasPackage.RECURSO__HTML_RECURSO:
				return getHtmlRecurso();
			case VisitasPackage.RECURSO__IMAGEN_RECURSO:
				return getImagenRecurso();
			case VisitasPackage.RECURSO__DESCRIPCION_RECURSO:
				return getDescripcionRecurso();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VisitasPackage.RECURSO__HTML_RECURSO:
				setHtmlRecurso((String)newValue);
				return;
			case VisitasPackage.RECURSO__IMAGEN_RECURSO:
				setImagenRecurso((String)newValue);
				return;
			case VisitasPackage.RECURSO__DESCRIPCION_RECURSO:
				setDescripcionRecurso((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VisitasPackage.RECURSO__HTML_RECURSO:
				setHtmlRecurso(HTML_RECURSO_EDEFAULT);
				return;
			case VisitasPackage.RECURSO__IMAGEN_RECURSO:
				setImagenRecurso(IMAGEN_RECURSO_EDEFAULT);
				return;
			case VisitasPackage.RECURSO__DESCRIPCION_RECURSO:
				setDescripcionRecurso(DESCRIPCION_RECURSO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VisitasPackage.RECURSO__HTML_RECURSO:
				return HTML_RECURSO_EDEFAULT == null ? htmlRecurso != null : !HTML_RECURSO_EDEFAULT.equals(htmlRecurso);
			case VisitasPackage.RECURSO__IMAGEN_RECURSO:
				return IMAGEN_RECURSO_EDEFAULT == null ? imagenRecurso != null : !IMAGEN_RECURSO_EDEFAULT.equals(imagenRecurso);
			case VisitasPackage.RECURSO__DESCRIPCION_RECURSO:
				return DESCRIPCION_RECURSO_EDEFAULT == null ? descripcionRecurso != null : !DESCRIPCION_RECURSO_EDEFAULT.equals(descripcionRecurso);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (htmlRecurso: ");
		result.append(htmlRecurso);
		result.append(", imagenRecurso: ");
		result.append(imagenRecurso);
		result.append(", descripcionRecurso: ");
		result.append(descripcionRecurso);
		result.append(')');
		return result.toString();
	}

} //RecursoImpl
