package visitas.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import visitas.diagram.edit.commands.ContinuacionCreateCommand;
import visitas.diagram.edit.commands.EtapaCreateCommand;
import visitas.diagram.edit.commands.RecursoCreateCommand;
import visitas.diagram.providers.VisitasElementTypes;

/**
 * @generated
 */
public class VisitaItemSemanticEditPolicy extends
		VisitasBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VisitaItemSemanticEditPolicy() {
		super(VisitasElementTypes.Visita_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VisitasElementTypes.Recurso_2001 == req.getElementType()) {
			return getGEFWrapper(new RecursoCreateCommand(req));
		}
		if (VisitasElementTypes.Etapa_2002 == req.getElementType()) {
			return getGEFWrapper(new EtapaCreateCommand(req));
		}
		if (VisitasElementTypes.Continuacion_2003 == req.getElementType()) {
			return getGEFWrapper(new ContinuacionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
