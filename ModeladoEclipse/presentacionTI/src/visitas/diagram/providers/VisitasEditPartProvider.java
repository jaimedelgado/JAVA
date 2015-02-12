package visitas.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import visitas.diagram.edit.parts.VisitaEditPart;
import visitas.diagram.edit.parts.VisitasEditPartFactory;
import visitas.diagram.part.VisitasVisualIDRegistry;

/**
 * @generated
 */
public class VisitasEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public VisitasEditPartProvider() {
		super(new VisitasEditPartFactory(),
				VisitasVisualIDRegistry.TYPED_INSTANCE, VisitaEditPart.MODEL_ID);
	}

}
