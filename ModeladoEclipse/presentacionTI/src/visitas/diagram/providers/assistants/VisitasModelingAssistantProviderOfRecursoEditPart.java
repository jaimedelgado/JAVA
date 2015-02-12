package visitas.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import visitas.diagram.edit.parts.RecursoEditPart;
import visitas.diagram.providers.VisitasElementTypes;
import visitas.diagram.providers.VisitasModelingAssistantProvider;

/**
 * @generated
 */
public class VisitasModelingAssistantProviderOfRecursoEditPart extends
		VisitasModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((RecursoEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(RecursoEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(VisitasElementTypes.EtapaRecursoEtapa_4003);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((RecursoEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(RecursoEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == VisitasElementTypes.EtapaRecursoEtapa_4003) {
			types.add(VisitasElementTypes.Etapa_2002);
		}
		return types;
	}

}
