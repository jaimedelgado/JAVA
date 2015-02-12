/**
 */
package visitas.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import visitas.Continuacion;
import visitas.Etapa;
import visitas.Recurso;
import visitas.Visita;
import visitas.VisitasFactory;
import visitas.VisitasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisitasPackageImpl extends EPackageImpl implements VisitasPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass etapaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recursoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuacionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitaEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see visitas.VisitasPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisitasPackageImpl() {
		super(eNS_URI, VisitasFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VisitasPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisitasPackage init() {
		if (isInited) return (VisitasPackage)EPackage.Registry.INSTANCE.getEPackage(VisitasPackage.eNS_URI);

		// Obtain or create and register package
		VisitasPackageImpl theVisitasPackage = (VisitasPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisitasPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisitasPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theVisitasPackage.createPackageContents();

		// Initialize created meta-data
		theVisitasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisitasPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisitasPackage.eNS_URI, theVisitasPackage);
		return theVisitasPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEtapa() {
		return etapaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEtapa_HtmlEtapa() {
		return (EAttribute)etapaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEtapa_RecursoEtapa() {
		return (EReference)etapaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEtapa_ContinuacionEtapa() {
		return (EReference)etapaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecurso() {
		return recursoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecurso_HtmlRecurso() {
		return (EAttribute)recursoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecurso_ImagenRecurso() {
		return (EAttribute)recursoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecurso_DescripcionRecurso() {
		return (EAttribute)recursoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuacion() {
		return continuacionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuacion_TextoContinuacion() {
		return (EAttribute)continuacionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContinuacion_EtapaContinuacion() {
		return (EReference)continuacionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisita() {
		return visitaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisita_EtapasVisita() {
		return (EReference)visitaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisita_ContinuacionesVisita() {
		return (EReference)visitaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisita_RecursosVisita() {
		return (EReference)visitaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitasFactory getVisitasFactory() {
		return (VisitasFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		etapaEClass = createEClass(ETAPA);
		createEAttribute(etapaEClass, ETAPA__HTML_ETAPA);
		createEReference(etapaEClass, ETAPA__RECURSO_ETAPA);
		createEReference(etapaEClass, ETAPA__CONTINUACION_ETAPA);

		recursoEClass = createEClass(RECURSO);
		createEAttribute(recursoEClass, RECURSO__HTML_RECURSO);
		createEAttribute(recursoEClass, RECURSO__IMAGEN_RECURSO);
		createEAttribute(recursoEClass, RECURSO__DESCRIPCION_RECURSO);

		continuacionEClass = createEClass(CONTINUACION);
		createEAttribute(continuacionEClass, CONTINUACION__TEXTO_CONTINUACION);
		createEReference(continuacionEClass, CONTINUACION__ETAPA_CONTINUACION);

		visitaEClass = createEClass(VISITA);
		createEReference(visitaEClass, VISITA__ETAPAS_VISITA);
		createEReference(visitaEClass, VISITA__CONTINUACIONES_VISITA);
		createEReference(visitaEClass, VISITA__RECURSOS_VISITA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(etapaEClass, Etapa.class, "Etapa", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEtapa_HtmlEtapa(), ecorePackage.getEString(), "htmlEtapa", null, 0, 1, Etapa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEtapa_RecursoEtapa(), this.getRecurso(), null, "recursoEtapa", null, 1, 1, Etapa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEtapa_ContinuacionEtapa(), this.getContinuacion(), null, "continuacionEtapa", null, 0, -1, Etapa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recursoEClass, Recurso.class, "Recurso", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecurso_HtmlRecurso(), ecorePackage.getEString(), "htmlRecurso", null, 0, 1, Recurso.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecurso_ImagenRecurso(), ecorePackage.getEString(), "imagenRecurso", null, 0, 1, Recurso.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecurso_DescripcionRecurso(), ecorePackage.getEString(), "descripcionRecurso", null, 0, 1, Recurso.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(continuacionEClass, Continuacion.class, "Continuacion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinuacion_TextoContinuacion(), ecorePackage.getEString(), "textoContinuacion", null, 0, 1, Continuacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContinuacion_EtapaContinuacion(), this.getEtapa(), null, "etapaContinuacion", null, 1, 1, Continuacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitaEClass, Visita.class, "Visita", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisita_EtapasVisita(), this.getEtapa(), null, "etapasVisita", null, 0, -1, Visita.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisita_ContinuacionesVisita(), this.getContinuacion(), null, "continuacionesVisita", null, 0, -1, Visita.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisita_RecursosVisita(), this.getRecurso(), null, "recursosVisita", null, 0, -1, Visita.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VisitasPackageImpl
