/**
 */
package visitas.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import visitas.Continuacion;
import visitas.VisitasFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Continuacion</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContinuacionTest extends TestCase {

	/**
	 * The fixture for this Continuacion test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Continuacion fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ContinuacionTest.class);
	}

	/**
	 * Constructs a new Continuacion test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinuacionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Continuacion test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Continuacion fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Continuacion test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Continuacion getFixture() {
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
		setFixture(VisitasFactory.eINSTANCE.createContinuacion());
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

} //ContinuacionTest
