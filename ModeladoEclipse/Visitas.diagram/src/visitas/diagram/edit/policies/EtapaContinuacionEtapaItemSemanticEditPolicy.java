package visitas.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import visitas.diagram.providers.VisitasElementTypes;

/**
 * @generated
 */
public class EtapaContinuacionEtapaItemSemanticEditPolicy extends
		VisitasBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EtapaContinuacionEtapaItemSemanticEditPolicy() {
		super(VisitasElementTypes.EtapaContinuacionEtapa_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
