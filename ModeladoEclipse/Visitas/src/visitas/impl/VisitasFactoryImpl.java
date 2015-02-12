/**
 */
package visitas.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import visitas.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisitasFactoryImpl extends EFactoryImpl implements VisitasFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisitasFactory init() {
		try {
			VisitasFactory theVisitasFactory = (VisitasFactory)EPackage.Registry.INSTANCE.getEFactory(VisitasPackage.eNS_URI);
			if (theVisitasFactory != null) {
				return theVisitasFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VisitasFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitasFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VisitasPackage.ETAPA: return createEtapa();
			case VisitasPackage.RECURSO: return createRecurso();
			case VisitasPackage.CONTINUACION: return createContinuacion();
			case VisitasPackage.VISITA: return createVisita();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Etapa createEtapa() {
		EtapaImpl etapa = new EtapaImpl();
		return etapa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recurso createRecurso() {
		RecursoImpl recurso = new RecursoImpl();
		return recurso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Continuacion createContinuacion() {
		ContinuacionImpl continuacion = new ContinuacionImpl();
		return continuacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visita createVisita() {
		VisitaImpl visita = new VisitaImpl();
		return visita;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitasPackage getVisitasPackage() {
		return (VisitasPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VisitasPackage getPackage() {
		return VisitasPackage.eINSTANCE;
	}

} //VisitasFactoryImpl
