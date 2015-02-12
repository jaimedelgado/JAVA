package visitas.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import visitas.diagram.providers.VisitasElementTypes;
import visitas.diagram.providers.VisitasModelingAssistantProvider;

/**
 * @generated
 */
public class VisitasModelingAssistantProviderOfVisitaEditPart extends
		VisitasModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(VisitasElementTypes.Recurso_2001);
		types.add(VisitasElementTypes.Etapa_2002);
		types.add(VisitasElementTypes.Continuacion_2003);
		return types;
	}

}
