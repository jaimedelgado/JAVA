/**
 */
package visitas.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import visitas.Continuacion;
import visitas.Etapa;
import visitas.Recurso;
import visitas.Visita;
import visitas.VisitasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visita</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link visitas.impl.VisitaImpl#getEtapasVisita <em>Etapas Visita</em>}</li>
 *   <li>{@link visitas.impl.VisitaImpl#getContinuacionesVisita <em>Continuaciones Visita</em>}</li>
 *   <li>{@link visitas.impl.VisitaImpl#getRecursosVisita <em>Recursos Visita</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisitaImpl extends MinimalEObjectImpl.Container implements Visita {
	/**
	 * The cached value of the '{@link #getEtapasVisita() <em>Etapas Visita</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtapasVisita()
	 * @generated
	 * @ordered
	 */
	protected EList<Etapa> etapasVisita;

	/**
	 * The cached value of the '{@link #getContinuacionesVisita() <em>Continuaciones Visita</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContinuacionesVisita()
	 * @generated
	 * @ordered
	 */
	protected EList<Continuacion> continuacionesVisita;

	/**
	 * The cached value of the '{@link #getRecursosVisita() <em>Recursos Visita</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecursosVisita()
	 * @generated
	 * @ordered
	 */
	protected EList<Recurso> recursosVisita;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisitaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitasPackage.Literals.VISITA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Etapa> getEtapasVisita() {
		if (etapasVisita == null) {
			etapasVisita = new EObjectContainmentEList<Etapa>(Etapa.class, this, VisitasPackage.VISITA__ETAPAS_VISITA);
		}
		return etapasVisita;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Continuacion> getContinuacionesVisita() {
		if (continuacionesVisita == null) {
			continuacionesVisita = new EObjectContainmentEList<Continuacion>(Continuacion.class, this, VisitasPackage.VISITA__CONTINUACIONES_VISITA);
		}
		return continuacionesVisita;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Recurso> getRecursosVisita() {
		if (recursosVisita == null) {
			recursosVisita = new EObjectContainmentEList<Recurso>(Recurso.class, this, VisitasPackage.VISITA__RECURSOS_VISITA);
		}
		return recursosVisita;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VisitasPackage.VISITA__ETAPAS_VISITA:
				return ((InternalEList<?>)getEtapasVisita()).basicRemove(otherEnd, msgs);
			case VisitasPackage.VISITA__CONTINUACIONES_VISITA:
				return ((InternalEList<?>)getContinuacionesVisita()).basicRemove(otherEnd, msgs);
			case VisitasPackage.VISITA__RECURSOS_VISITA:
				return ((InternalEList<?>)getRecursosVisita()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisitasPackage.VISITA__ETAPAS_VISITA:
				return getEtapasVisita();
			case VisitasPackage.VISITA__CONTINUACIONES_VISITA:
				return getContinuacionesVisita();
			case VisitasPackage.VISITA__RECURSOS_VISITA:
				return getRecursosVisita();
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
			case VisitasPackage.VISITA__ETAPAS_VISITA:
				getEtapasVisita().clear();
				getEtapasVisita().addAll((Collection<? extends Etapa>)newValue);
				return;
			case VisitasPackage.VISITA__CONTINUACIONES_VISITA:
				getContinuacionesVisita().clear();
				getContinuacionesVisita().addAll((Collection<? extends Continuacion>)newValue);
				return;
			case VisitasPackage.VISITA__RECURSOS_VISITA:
				getRecursosVisita().clear();
				getRecursosVisita().addAll((Collection<? extends Recurso>)newValue);
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
			case VisitasPackage.VISITA__ETAPAS_VISITA:
				getEtapasVisita().clear();
				return;
			case VisitasPackage.VISITA__CONTINUACIONES_VISITA:
				getContinuacionesVisita().clear();
				return;
			case VisitasPackage.VISITA__RECURSOS_VISITA:
				getRecursosVisita().clear();
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
			case VisitasPackage.VISITA__ETAPAS_VISITA:
				return etapasVisita != null && !etapasVisita.isEmpty();
			case VisitasPackage.VISITA__CONTINUACIONES_VISITA:
				return continuacionesVisita != null && !continuacionesVisita.isEmpty();
			case VisitasPackage.VISITA__RECURSOS_VISITA:
				return recursosVisita != null && !recursosVisita.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VisitaImpl
