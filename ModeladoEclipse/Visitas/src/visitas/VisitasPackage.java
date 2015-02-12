/**
 */
package visitas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see visitas.VisitasFactory
 * @model kind="package"
 * @generated
 */
public interface VisitasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visitas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://visitas/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visitas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisitasPackage eINSTANCE = visitas.impl.VisitasPackageImpl.init();

	/**
	 * The meta object id for the '{@link visitas.impl.EtapaImpl <em>Etapa</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see visitas.impl.EtapaImpl
	 * @see visitas.impl.VisitasPackageImpl#getEtapa()
	 * @generated
	 */
	int ETAPA = 0;

	/**
	 * The feature id for the '<em><b>Html Etapa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAPA__HTML_ETAPA = 0;

	/**
	 * The feature id for the '<em><b>Recurso Etapa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAPA__RECURSO_ETAPA = 1;

	/**
	 * The feature id for the '<em><b>Continuacion Etapa</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAPA__CONTINUACION_ETAPA = 2;

	/**
	 * The number of structural features of the '<em>Etapa</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAPA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Etapa</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAPA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link visitas.impl.RecursoImpl <em>Recurso</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see visitas.impl.RecursoImpl
	 * @see visitas.impl.VisitasPackageImpl#getRecurso()
	 * @generated
	 */
	int RECURSO = 1;

	/**
	 * The feature id for the '<em><b>Html Recurso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSO__HTML_RECURSO = 0;

	/**
	 * The feature id for the '<em><b>Imagen Recurso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSO__IMAGEN_RECURSO = 1;

	/**
	 * The feature id for the '<em><b>Descripcion Recurso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSO__DESCRIPCION_RECURSO = 2;

	/**
	 * The number of structural features of the '<em>Recurso</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Recurso</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link visitas.impl.ContinuacionImpl <em>Continuacion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see visitas.impl.ContinuacionImpl
	 * @see visitas.impl.VisitasPackageImpl#getContinuacion()
	 * @generated
	 */
	int CONTINUACION = 2;

	/**
	 * The feature id for the '<em><b>Texto Continuacion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUACION__TEXTO_CONTINUACION = 0;

	/**
	 * The feature id for the '<em><b>Etapa Continuacion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUACION__ETAPA_CONTINUACION = 1;

	/**
	 * The number of structural features of the '<em>Continuacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUACION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Continuacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUACION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link visitas.impl.VisitaImpl <em>Visita</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see visitas.impl.VisitaImpl
	 * @see visitas.impl.VisitasPackageImpl#getVisita()
	 * @generated
	 */
	int VISITA = 3;

	/**
	 * The feature id for the '<em><b>Etapas Visita</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITA__ETAPAS_VISITA = 0;

	/**
	 * The feature id for the '<em><b>Continuaciones Visita</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITA__CONTINUACIONES_VISITA = 1;

	/**
	 * The feature id for the '<em><b>Recursos Visita</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITA__RECURSOS_VISITA = 2;

	/**
	 * The number of structural features of the '<em>Visita</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Visita</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link visitas.Etapa <em>Etapa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Etapa</em>'.
	 * @see visitas.Etapa
	 * @generated
	 */
	EClass getEtapa();

	/**
	 * Returns the meta object for the attribute '{@link visitas.Etapa#getHtmlEtapa <em>Html Etapa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Html Etapa</em>'.
	 * @see visitas.Etapa#getHtmlEtapa()
	 * @see #getEtapa()
	 * @generated
	 */
	EAttribute getEtapa_HtmlEtapa();

	/**
	 * Returns the meta object for the reference '{@link visitas.Etapa#getRecursoEtapa <em>Recurso Etapa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recurso Etapa</em>'.
	 * @see visitas.Etapa#getRecursoEtapa()
	 * @see #getEtapa()
	 * @generated
	 */
	EReference getEtapa_RecursoEtapa();

	/**
	 * Returns the meta object for the reference list '{@link visitas.Etapa#getContinuacionEtapa <em>Continuacion Etapa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Continuacion Etapa</em>'.
	 * @see visitas.Etapa#getContinuacionEtapa()
	 * @see #getEtapa()
	 * @generated
	 */
	EReference getEtapa_ContinuacionEtapa();

	/**
	 * Returns the meta object for class '{@link visitas.Recurso <em>Recurso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recurso</em>'.
	 * @see visitas.Recurso
	 * @generated
	 */
	EClass getRecurso();

	/**
	 * Returns the meta object for the attribute '{@link visitas.Recurso#getHtmlRecurso <em>Html Recurso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Html Recurso</em>'.
	 * @see visitas.Recurso#getHtmlRecurso()
	 * @see #getRecurso()
	 * @generated
	 */
	EAttribute getRecurso_HtmlRecurso();

	/**
	 * Returns the meta object for the attribute '{@link visitas.Recurso#getImagenRecurso <em>Imagen Recurso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imagen Recurso</em>'.
	 * @see visitas.Recurso#getImagenRecurso()
	 * @see #getRecurso()
	 * @generated
	 */
	EAttribute getRecurso_ImagenRecurso();

	/**
	 * Returns the meta object for the attribute '{@link visitas.Recurso#getDescripcionRecurso <em>Descripcion Recurso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion Recurso</em>'.
	 * @see visitas.Recurso#getDescripcionRecurso()
	 * @see #getRecurso()
	 * @generated
	 */
	EAttribute getRecurso_DescripcionRecurso();

	/**
	 * Returns the meta object for class '{@link visitas.Continuacion <em>Continuacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuacion</em>'.
	 * @see visitas.Continuacion
	 * @generated
	 */
	EClass getContinuacion();

	/**
	 * Returns the meta object for the attribute '{@link visitas.Continuacion#getTextoContinuacion <em>Texto Continuacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Texto Continuacion</em>'.
	 * @see visitas.Continuacion#getTextoContinuacion()
	 * @see #getContinuacion()
	 * @generated
	 */
	EAttribute getContinuacion_TextoContinuacion();

	/**
	 * Returns the meta object for the reference '{@link visitas.Continuacion#getEtapaContinuacion <em>Etapa Continuacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Etapa Continuacion</em>'.
	 * @see visitas.Continuacion#getEtapaContinuacion()
	 * @see #getContinuacion()
	 * @generated
	 */
	EReference getContinuacion_EtapaContinuacion();

	/**
	 * Returns the meta object for class '{@link visitas.Visita <em>Visita</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visita</em>'.
	 * @see visitas.Visita
	 * @generated
	 */
	EClass getVisita();

	/**
	 * Returns the meta object for the containment reference list '{@link visitas.Visita#getEtapasVisita <em>Etapas Visita</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Etapas Visita</em>'.
	 * @see visitas.Visita#getEtapasVisita()
	 * @see #getVisita()
	 * @generated
	 */
	EReference getVisita_EtapasVisita();

	/**
	 * Returns the meta object for the containment reference list '{@link visitas.Visita#getContinuacionesVisita <em>Continuaciones Visita</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Continuaciones Visita</em>'.
	 * @see visitas.Visita#getContinuacionesVisita()
	 * @see #getVisita()
	 * @generated
	 */
	EReference getVisita_ContinuacionesVisita();

	/**
	 * Returns the meta object for the containment reference list '{@link visitas.Visita#getRecursosVisita <em>Recursos Visita</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recursos Visita</em>'.
	 * @see visitas.Visita#getRecursosVisita()
	 * @see #getVisita()
	 * @generated
	 */
	EReference getVisita_RecursosVisita();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisitasFactory getVisitasFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link visitas.impl.EtapaImpl <em>Etapa</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see visitas.impl.EtapaImpl
		 * @see visitas.impl.VisitasPackageImpl#getEtapa()
		 * @generated
		 */
		EClass ETAPA = eINSTANCE.getEtapa();

		/**
		 * The meta object literal for the '<em><b>Html Etapa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETAPA__HTML_ETAPA = eINSTANCE.getEtapa_HtmlEtapa();

		/**
		 * The meta object literal for the '<em><b>Recurso Etapa</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETAPA__RECURSO_ETAPA = eINSTANCE.getEtapa_RecursoEtapa();

		/**
		 * The meta object literal for the '<em><b>Continuacion Etapa</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETAPA__CONTINUACION_ETAPA = eINSTANCE.getEtapa_ContinuacionEtapa();

		/**
		 * The meta object literal for the '{@link visitas.impl.RecursoImpl <em>Recurso</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see visitas.impl.RecursoImpl
		 * @see visitas.impl.VisitasPackageImpl#getRecurso()
		 * @generated
		 */
		EClass RECURSO = eINSTANCE.getRecurso();

		/**
		 * The meta object literal for the '<em><b>Html Recurso</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSO__HTML_RECURSO = eINSTANCE.getRecurso_HtmlRecurso();

		/**
		 * The meta object literal for the '<em><b>Imagen Recurso</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSO__IMAGEN_RECURSO = eINSTANCE.getRecurso_ImagenRecurso();

		/**
		 * The meta object literal for the '<em><b>Descripcion Recurso</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSO__DESCRIPCION_RECURSO = eINSTANCE.getRecurso_DescripcionRecurso();

		/**
		 * The meta object literal for the '{@link visitas.impl.ContinuacionImpl <em>Continuacion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see visitas.impl.ContinuacionImpl
		 * @see visitas.impl.VisitasPackageImpl#getContinuacion()
		 * @generated
		 */
		EClass CONTINUACION = eINSTANCE.getContinuacion();

		/**
		 * The meta object literal for the '<em><b>Texto Continuacion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUACION__TEXTO_CONTINUACION = eINSTANCE.getContinuacion_TextoContinuacion();

		/**
		 * The meta object literal for the '<em><b>Etapa Continuacion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTINUACION__ETAPA_CONTINUACION = eINSTANCE.getContinuacion_EtapaContinuacion();

		/**
		 * The meta object literal for the '{@link visitas.impl.VisitaImpl <em>Visita</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see visitas.impl.VisitaImpl
		 * @see visitas.impl.VisitasPackageImpl#getVisita()
		 * @generated
		 */
		EClass VISITA = eINSTANCE.getVisita();

		/**
		 * The meta object literal for the '<em><b>Etapas Visita</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITA__ETAPAS_VISITA = eINSTANCE.getVisita_EtapasVisita();

		/**
		 * The meta object literal for the '<em><b>Continuaciones Visita</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITA__CONTINUACIONES_VISITA = eINSTANCE.getVisita_ContinuacionesVisita();

		/**
		 * The meta object literal for the '<em><b>Recursos Visita</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITA__RECURSOS_VISITA = eINSTANCE.getVisita_RecursosVisita();

	}

} //VisitasPackage
