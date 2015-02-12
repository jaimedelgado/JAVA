/**
 */
package visitas.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import visitas.Etapa;
import visitas.VisitasFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Etapa</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtapaTest extends TestCase {

	/**
	 * The fixture for this Etapa test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Etapa fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EtapaTest.class);
	}

	/**
	 * Constructs a new Etapa test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtapaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Etapa test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Etapa fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Etapa test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Etapa getFixture() {
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
		setFixture(VisitasFactory.eINSTANCE.createEtapa());
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

} //EtapaTest
