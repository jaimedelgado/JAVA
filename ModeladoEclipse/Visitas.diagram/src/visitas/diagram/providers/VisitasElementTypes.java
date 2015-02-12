package visitas.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import visitas.VisitasPackage;
import visitas.diagram.edit.parts.ContinuacionEditPart;
import visitas.diagram.edit.parts.ContinuacionEtapaContinuacionEditPart;
import visitas.diagram.edit.parts.EtapaContinuacionEtapaEditPart;
import visitas.diagram.edit.parts.EtapaEditPart;
import visitas.diagram.edit.parts.EtapaRecursoEtapaEditPart;
import visitas.diagram.edit.parts.RecursoEditPart;
import visitas.diagram.edit.parts.VisitaEditPart;
import visitas.diagram.part.VisitasDiagramEditorPlugin;

/**
 * @generated
 */
public class VisitasElementTypes {

	/**
	 * @generated
	 */
	private VisitasElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			VisitasDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Visita_1000 = getElementType("Visitas.diagram.Visita_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Recurso_2001 = getElementType("Visitas.diagram.Recurso_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Etapa_2002 = getElementType("Visitas.diagram.Etapa_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Continuacion_2003 = getElementType("Visitas.diagram.Continuacion_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ContinuacionEtapaContinuacion_4001 = getElementType("Visitas.diagram.ContinuacionEtapaContinuacion_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EtapaContinuacionEtapa_4002 = getElementType("Visitas.diagram.EtapaContinuacionEtapa_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EtapaRecursoEtapa_4003 = getElementType("Visitas.diagram.EtapaRecursoEtapa_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Visita_1000, VisitasPackage.eINSTANCE.getVisita());

			elements.put(Recurso_2001, VisitasPackage.eINSTANCE.getRecurso());

			elements.put(Etapa_2002, VisitasPackage.eINSTANCE.getEtapa());

			elements.put(Continuacion_2003,
					VisitasPackage.eINSTANCE.getContinuacion());

			elements.put(ContinuacionEtapaContinuacion_4001,
					VisitasPackage.eINSTANCE
							.getContinuacion_EtapaContinuacion());

			elements.put(EtapaContinuacionEtapa_4002,
					VisitasPackage.eINSTANCE.getEtapa_ContinuacionEtapa());

			elements.put(EtapaRecursoEtapa_4003,
					VisitasPackage.eINSTANCE.getEtapa_RecursoEtapa());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Visita_1000);
			KNOWN_ELEMENT_TYPES.add(Recurso_2001);
			KNOWN_ELEMENT_TYPES.add(Etapa_2002);
			KNOWN_ELEMENT_TYPES.add(Continuacion_2003);
			KNOWN_ELEMENT_TYPES.add(ContinuacionEtapaContinuacion_4001);
			KNOWN_ELEMENT_TYPES.add(EtapaContinuacionEtapa_4002);
			KNOWN_ELEMENT_TYPES.add(EtapaRecursoEtapa_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case VisitaEditPart.VISUAL_ID:
			return Visita_1000;
		case RecursoEditPart.VISUAL_ID:
			return Recurso_2001;
		case EtapaEditPart.VISUAL_ID:
			return Etapa_2002;
		case ContinuacionEditPart.VISUAL_ID:
			return Continuacion_2003;
		case ContinuacionEtapaContinuacionEditPart.VISUAL_ID:
			return ContinuacionEtapaContinuacion_4001;
		case EtapaContinuacionEtapaEditPart.VISUAL_ID:
			return EtapaContinuacionEtapa_4002;
		case EtapaRecursoEtapaEditPart.VISUAL_ID:
			return EtapaRecursoEtapa_4003;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return visitas.diagram.providers.VisitasElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return visitas.diagram.providers.VisitasElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return visitas.diagram.providers.VisitasElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
