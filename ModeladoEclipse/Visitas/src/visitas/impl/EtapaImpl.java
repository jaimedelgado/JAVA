/**
 */
package visitas.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import visitas.Continuacion;
import visitas.Etapa;
import visitas.Recurso;
import visitas.VisitasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Etapa</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link visitas.impl.EtapaImpl#getHtmlEtapa <em>Html Etapa</em>}</li>
 *   <li>{@link visitas.impl.EtapaImpl#getRecursoEtapa <em>Recurso Etapa</em>}</li>
 *   <li>{@link visitas.impl.EtapaImpl#getContinuacionEtapa <em>Continuacion Etapa</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EtapaImpl extends MinimalEObjectImpl.Container implements Etapa {
	/**
	 * The default value of the '{@link #getHtmlEtapa() <em>Html Etapa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlEtapa()
	 * @generated
	 * @ordered
	 */
	protected static final String HTML_ETAPA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHtmlEtapa() <em>Html Etapa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlEtapa()
	 * @generated
	 * @ordered
	 */
	protected String htmlEtapa = HTML_ETAPA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRecursoEtapa() <em>Recurso Etapa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecursoEtapa()
	 * @generated
	 * @ordered
	 */
	protected Recurso recursoEtapa;

	/**
	 * The cached value of the '{@link #getContinuacionEtapa() <em>Continuacion Etapa</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContinuacionEtapa()
	 * @generated
	 * @ordered
	 */
	protected EList<Continuacion> continuacionEtapa;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EtapaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitasPackage.Literals.ETAPA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHtmlEtapa() {
		return htmlEtapa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHtmlEtapa(String newHtmlEtapa) {
		String oldHtmlEtapa = htmlEtapa;
		htmlEtapa = newHtmlEtapa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.ETAPA__HTML_ETAPA, oldHtmlEtapa, htmlEtapa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recurso getRecursoEtapa() {
		if (recursoEtapa != null && recursoEtapa.eIsProxy()) {
			InternalEObject oldRecursoEtapa = (InternalEObject)recursoEtapa;
			recursoEtapa = (Recurso)eResolveProxy(oldRecursoEtapa);
			if (recursoEtapa != oldRecursoEtapa) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisitasPackage.ETAPA__RECURSO_ETAPA, oldRecursoEtapa, recursoEtapa));
			}
		}
		return recursoEtapa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recurso basicGetRecursoEtapa() {
		return recursoEtapa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecursoEtapa(Recurso newRecursoEtapa) {
		Recurso oldRecursoEtapa = recursoEtapa;
		recursoEtapa = newRecursoEtapa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisitasPackage.ETAPA__RECURSO_ETAPA, oldRecursoEtapa, recursoEtapa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Continuacion> getContinuacionEtapa() {
		if (continuacionEtapa == null) {
			continuacionEtapa = new EObjectResolvingEList<Continuacion>(Continuacion.class, this, VisitasPackage.ETAPA__CONTINUACION_ETAPA);
		}
		return continuacionEtapa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisitasPackage.ETAPA__HTML_ETAPA:
				return getHtmlEtapa();
			case VisitasPackage.ETAPA__RECURSO_ETAPA:
				if (resolve) return getRecursoEtapa();
				return basicGetRecursoEtapa();
			case VisitasPackage.ETAPA__CONTINUACION_ETAPA:
				return getContinuacionEtapa();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VisitasPackage.ETAPA__HTML_ETAPA:
				setHtmlEtapa((String)newValue);
				return;
			case VisitasPackage.ETAPA__RECURSO_ETAPA:
				setRecursoEtapa((Recurso)newValue);
				return;
			case VisitasPackage.ETAPA__CONTINUACION_ETAPA:
				getContinuacionEtapa().clear();
				getContinuacionEtapa().addAll((Collection<? extends Continuacion>)newValue);
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
			case VisitasPackage.ETAPA__HTML_ETAPA:
				setHtmlEtapa(HTML_ETAPA_EDEFAULT);
				return;
			case VisitasPackage.ETAPA__RECURSO_ETAPA:
				setRecursoEtapa((Recurso)null);
				return;
			case VisitasPackage.ETAPA__CONTINUACION_ETAPA:
				getContinuacionEtapa().clear();
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
			case VisitasPackage.ETAPA__HTML_ETAPA:
				return HTML_ETAPA_EDEFAULT == null ? htmlEtapa != null : !HTML_ETAPA_EDEFAULT.equals(htmlEtapa);
			case VisitasPackage.ETAPA__RECURSO_ETAPA:
				return recursoEtapa != null;
			case VisitasPackage.ETAPA__CONTINUACION_ETAPA:
				return continuacionEtapa != null && !continuacionEtapa.isEmpty();
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
		result.append(" (htmlEtapa: ");
		result.append(htmlEtapa);
		result.append(')');
		return result.toString();
	}

} //EtapaImpl
