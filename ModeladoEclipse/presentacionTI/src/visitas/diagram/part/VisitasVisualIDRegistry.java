package visitas.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import visitas.Visita;
import visitas.VisitasPackage;
import visitas.diagram.edit.parts.ContinuacionEditPart;
import visitas.diagram.edit.parts.ContinuacionTextoContinuacionEditPart;
import visitas.diagram.edit.parts.EtapaEditPart;
import visitas.diagram.edit.parts.EtapaHtmlEtapaEditPart;
import visitas.diagram.edit.parts.RecursoEditPart;
import visitas.diagram.edit.parts.RecursoHtmlRecursoEditPart;
import visitas.diagram.edit.parts.VisitaEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class VisitasVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "Visitas.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (VisitaEditPart.MODEL_ID.equals(view.getType())) {
				return VisitaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return visitas.diagram.part.VisitasVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				VisitasDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (VisitasPackage.eINSTANCE.getVisita().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Visita) domainElement)) {
			return VisitaEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = visitas.diagram.part.VisitasVisualIDRegistry
				.getModelID(containerView);
		if (!VisitaEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (VisitaEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = visitas.diagram.part.VisitasVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = VisitaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case VisitaEditPart.VISUAL_ID:
			if (VisitasPackage.eINSTANCE.getRecurso().isSuperTypeOf(
					domainElement.eClass())) {
				return RecursoEditPart.VISUAL_ID;
			}
			if (VisitasPackage.eINSTANCE.getEtapa().isSuperTypeOf(
					domainElement.eClass())) {
				return EtapaEditPart.VISUAL_ID;
			}
			if (VisitasPackage.eINSTANCE.getContinuacion().isSuperTypeOf(
					domainElement.eClass())) {
				return ContinuacionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = visitas.diagram.part.VisitasVisualIDRegistry
				.getModelID(containerView);
		if (!VisitaEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (VisitaEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = visitas.diagram.part.VisitasVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = VisitaEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case VisitaEditPart.VISUAL_ID:
			if (RecursoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EtapaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ContinuacionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RecursoEditPart.VISUAL_ID:
			if (RecursoHtmlRecursoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EtapaEditPart.VISUAL_ID:
			if (EtapaHtmlEtapaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContinuacionEditPart.VISUAL_ID:
			if (ContinuacionTextoContinuacionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Visita element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case VisitaEditPart.VISUAL_ID:
			return false;
		case RecursoEditPart.VISUAL_ID:
		case EtapaEditPart.VISUAL_ID:
		case ContinuacionEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return visitas.diagram.part.VisitasVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
