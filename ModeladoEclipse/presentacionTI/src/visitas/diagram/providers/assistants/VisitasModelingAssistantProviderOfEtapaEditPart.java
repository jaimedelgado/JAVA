package visitas.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import visitas.diagram.edit.parts.ContinuacionEditPart;
import visitas.diagram.edit.parts.EtapaEditPart;
import visitas.diagram.edit.parts.RecursoEditPart;
import visitas.diagram.providers.VisitasElementTypes;
import visitas.diagram.providers.VisitasModelingAssistantProvider;

/**
 * @generated
 */
public class VisitasModelingAssistantProviderOfEtapaEditPart extends
		VisitasModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EtapaEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(EtapaEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(VisitasElementTypes.EtapaContinuacionEtapa_4002);
		types.add(VisitasElementTypes.EtapaRecursoEtapa_4003);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((EtapaEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			EtapaEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ContinuacionEditPart) {
			types.add(VisitasElementTypes.EtapaContinuacionEtapa_4002);
		}
		if (targetEditPart instanceof RecursoEditPart) {
			types.add(VisitasElementTypes.EtapaRecursoEtapa_4003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EtapaEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(EtapaEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == VisitasElementTypes.EtapaContinuacionEtapa_4002) {
			types.add(VisitasElementTypes.Continuacion_2003);
		} else if (relationshipType == VisitasElementTypes.EtapaRecursoEtapa_4003) {
			types.add(VisitasElementTypes.Recurso_2001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EtapaEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(EtapaEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(VisitasElementTypes.ContinuacionEtapaContinuacion_4001);
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
		return doGetTypesForSource((EtapaEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(EtapaEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == VisitasElementTypes.ContinuacionEtapaContinuacion_4001) {
			types.add(VisitasElementTypes.Continuacion_2003);
		}
		return types;
	}

}
