/**
 */
package visitas.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import visitas.Continuacion;
import visitas.Etapa;
import visitas.VisitasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Continuacion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link visitas.impl.ContinuacionImpl#getTextoContinuacion <em>Texto Continuacion</em>}</li>
 *   <li>{@link visitas.impl.ContinuacionImpl#getEtapaContinuacion <em>Etapa Continuacion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContinuacionImpl extends MinimalEObjectImpl.Container implements Continuacion {
	/**
	 * The default value of the '{@link #getTextoContinuacion() <em>Texto Continuacion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextoContinuacion()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXTO_CONTINUACION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextoContinuacion() <em>Texto Continuacion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextoContinuacion()
	 * @generated
	 * @ordered
	 */
	protected String textoContinuacion = TEXTO_CONTINUACION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEtapaContinuacion() <em>Etapa Continuacion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtapaContinuacion()
	 * @generated
	 * @ordered
	 */
	protected Etapa etapaContinuacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContinuacionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitasPackage.Literals.CONTINUACION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextoContinuacion() {
		return textoContinuacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextoContinuacion(String newTextoContinuacion) {
		String oldTextoContinuacion = textoContinuacion;
		textoContinuacion = newTextoContinuacion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.CONTINUACION__TEXTO_CONTINUACION, oldTextoContinuacion, textoContinuacion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Etapa getEtapaContinuacion() {
		if (etapaContinuacion != null && etapaContinuacion.eIsProxy()) {
			InternalEObject oldEtapaContinuacion = (InternalEObject)etapaContinuacion;
			etapaContinuacion = (Etapa)eResolveProxy(oldEtapaContinuacion);
			if (etapaContinuacion != oldEtapaContinuacion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisitasPackage.CONTINUACION__ETAPA_CONTINUACION, oldEtapaContinuacion, etapaContinuacion));
			}
		}
		return etapaContinuacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Etapa basicGetEtapaContinuacion() {
		return etapaContinuacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtapaContinuacion(Etapa newEtapaContinuacion) {
		Etapa oldEtapaContinuacion = etapaContinuacion;
		etapaContinuacion = newEtapaContinuacion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.CONTINUACION__ETAPA_CONTINUACION, oldEtapaContinuacion, etapaContinuacion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisitasPackage.CONTINUACION__TEXTO_CONTINUACION:
				return getTextoContinuacion();
			case VisitasPackage.CONTINUACION__ETAPA_CONTINUACION:
				if (resolve) return getEtapaContinuacion();
				return basicGetEtapaContinuacion();
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
			case VisitasPackage.CONTINUACION__TEXTO_CONTINUACION:
				setTextoContinuacion((String)newValue);
				return;
			case VisitasPackage.CONTINUACION__ETAPA_CONTINUACION:
				setEtapaContinuacion((Etapa)newValue);
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
			case VisitasPackage.CONTINUACION__TEXTO_CONTINUACION:
				setTextoContinuacion(TEXTO_CONTINUACION_EDEFAULT);
				return;
			case VisitasPackage.CONTINUACION__ETAPA_CONTINUACION:
				setEtapaContinuacion((Etapa)null);
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
			case VisitasPackage.CONTINUACION__TEXTO_CONTINUACION:
				return TEXTO_CONTINUACION_EDEFAULT == null ? textoContinuacion != null : !TEXTO_CONTINUACION_EDEFAULT.equals(textoContinuacion);
			case VisitasPackage.CONTINUACION__ETAPA_CONTINUACION:
				return etapaContinuacion != null;
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
		result.append(" (textoContinuacion: ");
		result.append(textoContinuacion);
		result.append(')');
		return result.toString();
	}

} //ContinuacionImpl
