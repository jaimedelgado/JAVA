/**
 */
package visitas.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import visitas.Recurso;
import visitas.VisitasFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Recurso</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecursoTest extends TestCase {

	/**
	 * The fixture for this Recurso test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Recurso fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RecursoTest.class);
	}

	/**
	 * Constructs a new Recurso test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecursoTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Recurso test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Recurso fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Recurso test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Recurso getFixture() {
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
		setFixture(VisitasFactory.eINSTANCE.createRecurso());
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

} //RecursoTest
