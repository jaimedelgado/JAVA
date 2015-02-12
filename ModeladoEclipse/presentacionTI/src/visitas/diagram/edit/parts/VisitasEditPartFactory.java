package visitas.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import visitas.diagram.part.VisitasVisualIDRegistry;

/**
 * @generated
 */
public class VisitasEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (VisitasVisualIDRegistry.getVisualID(view)) {

			case VisitaEditPart.VISUAL_ID:
				return new VisitaEditPart(view);

			case RecursoEditPart.VISUAL_ID:
				return new RecursoEditPart(view);

			case RecursoHtmlRecursoEditPart.VISUAL_ID:
				return new RecursoHtmlRecursoEditPart(view);

			case EtapaEditPart.VISUAL_ID:
				return new EtapaEditPart(view);

			case EtapaHtmlEtapaEditPart.VISUAL_ID:
				return new EtapaHtmlEtapaEditPart(view);

			case ContinuacionEditPart.VISUAL_ID:
				return new ContinuacionEditPart(view);

			case ContinuacionTextoContinuacionEditPart.VISUAL_ID:
				return new ContinuacionTextoContinuacionEditPart(view);

			case ContinuacionEtapaContinuacionEditPart.VISUAL_ID:
				return new ContinuacionEtapaContinuacionEditPart(view);

			case EtapaContinuacionEtapaEditPart.VISUAL_ID:
				return new EtapaContinuacionEtapaEditPart(view);

			case EtapaRecursoEtapaEditPart.VISUAL_ID:
				return new EtapaRecursoEtapaEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
