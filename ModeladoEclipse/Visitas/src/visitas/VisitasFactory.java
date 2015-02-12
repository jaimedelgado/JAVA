/**
 */
package visitas;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see visitas.VisitasPackage
 * @generated
 */
public interface VisitasFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisitasFactory eINSTANCE = visitas.impl.VisitasFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Etapa</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Etapa</em>'.
	 * @generated
	 */
	Etapa createEtapa();

	/**
	 * Returns a new object of class '<em>Recurso</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recurso</em>'.
	 * @generated
	 */
	Recurso createRecurso();

	/**
	 * Returns a new object of class '<em>Continuacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuacion</em>'.
	 * @generated
	 */
	Continuacion createContinuacion();

	/**
	 * Returns a new object of class '<em>Visita</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visita</em>'.
	 * @generated
	 */
	Visita createVisita();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VisitasPackage getVisitasPackage();

} //VisitasFactory
