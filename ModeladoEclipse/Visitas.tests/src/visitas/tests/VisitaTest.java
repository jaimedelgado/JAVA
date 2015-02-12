/**
 */
package visitas.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import visitas.Visita;
import visitas.VisitasFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Visita</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisitaTest extends TestCase {

	/**
	 * The fixture for this Visita test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visita fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VisitaTest.class);
	}

	/**
	 * Constructs a new Visita test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Visita test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Visita fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Visita test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visita getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VisitasFactory.eINSTANCE.createVisita());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //VisitaTest
