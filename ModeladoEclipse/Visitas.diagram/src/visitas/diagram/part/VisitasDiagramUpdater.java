package visitas.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import visitas.Continuacion;
import visitas.Etapa;
import visitas.Recurso;
import visitas.Visita;
import visitas.VisitasPackage;
import visitas.diagram.edit.parts.ContinuacionEditPart;
import visitas.diagram.edit.parts.ContinuacionEtapaContinuacionEditPart;
import visitas.diagram.edit.parts.EtapaContinuacionEtapaEditPart;
import visitas.diagram.edit.parts.EtapaEditPart;
import visitas.diagram.edit.parts.EtapaRecursoEtapaEditPart;
import visitas.diagram.edit.parts.RecursoEditPart;
import visitas.diagram.edit.parts.VisitaEditPart;
import visitas.diagram.providers.VisitasElementTypes;

/**
 * @generated
 */
public class VisitasDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<VisitasNodeDescriptor> getSemanticChildren(View view) {
		switch (VisitasVisualIDRegistry.getVisualID(view)) {
		case VisitaEditPart.VISUAL_ID:
			return getVisita_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasNodeDescriptor> getVisita_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Visita modelElement = (Visita) view.getElement();
		LinkedList<VisitasNodeDescriptor> result = new LinkedList<VisitasNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursosVisita().iterator(); it
				.hasNext();) {
			Recurso childElement = (Recurso) it.next();
			int visualID = VisitasVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RecursoEditPart.VISUAL_ID) {
				result.add(new VisitasNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getEtapasVisita().iterator(); it
				.hasNext();) {
			Etapa childElement = (Etapa) it.next();
			int visualID = VisitasVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EtapaEditPart.VISUAL_ID) {
				result.add(new VisitasNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getContinuacionesVisita().iterator(); it
				.hasNext();) {
			Continuacion childElement = (Continuacion) it.next();
			int visualID = VisitasVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ContinuacionEditPart.VISUAL_ID) {
				result.add(new VisitasNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getContainedLinks(View view) {
		switch (VisitasVisualIDRegistry.getVisualID(view)) {
		case VisitaEditPart.VISUAL_ID:
			return getVisita_1000ContainedLinks(view);
		case RecursoEditPart.VISUAL_ID:
			return getRecurso_2001ContainedLinks(view);
		case EtapaEditPart.VISUAL_ID:
			return getEtapa_2002ContainedLinks(view);
		case ContinuacionEditPart.VISUAL_ID:
			return getContinuacion_2003ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getIncomingLinks(View view) {
		switch (VisitasVisualIDRegistry.getVisualID(view)) {
		case RecursoEditPart.VISUAL_ID:
			return getRecurso_2001IncomingLinks(view);
		case EtapaEditPart.VISUAL_ID:
			return getEtapa_2002IncomingLinks(view);
		case ContinuacionEditPart.VISUAL_ID:
			return getContinuacion_2003IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getOutgoingLinks(View view) {
		switch (VisitasVisualIDRegistry.getVisualID(view)) {
		case RecursoEditPart.VISUAL_ID:
			return getRecurso_2001OutgoingLinks(view);
		case EtapaEditPart.VISUAL_ID:
			return getEtapa_2002OutgoingLinks(view);
		case ContinuacionEditPart.VISUAL_ID:
			return getContinuacion_2003OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getVisita_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getRecurso_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getEtapa_2002ContainedLinks(
			View view) {
		Etapa modelElement = (Etapa) view.getElement();
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Etapa_ContinuacionEtapa_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Etapa_RecursoEtapa_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getContinuacion_2003ContainedLinks(
			View view) {
		Continuacion modelElement = (Continuacion) view.getElement();
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Continuacion_EtapaContinuacion_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getRecurso_2001IncomingLinks(
			View view) {
		Recurso modelElement = (Recurso) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Etapa_RecursoEtapa_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getEtapa_2002IncomingLinks(
			View view) {
		Etapa modelElement = (Etapa) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Continuacion_EtapaContinuacion_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getContinuacion_2003IncomingLinks(
			View view) {
		Continuacion modelElement = (Continuacion) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Etapa_ContinuacionEtapa_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getRecurso_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getEtapa_2002OutgoingLinks(
			View view) {
		Etapa modelElement = (Etapa) view.getElement();
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Etapa_ContinuacionEtapa_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Etapa_RecursoEtapa_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<VisitasLinkDescriptor> getContinuacion_2003OutgoingLinks(
			View view) {
		Continuacion modelElement = (Continuacion) view.getElement();
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Continuacion_EtapaContinuacion_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getIncomingFeatureModelFacetLinks_Continuacion_EtapaContinuacion_4001(
			Etapa target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == VisitasPackage.eINSTANCE
					.getContinuacion_EtapaContinuacion()) {
				result.add(new VisitasLinkDescriptor(setting.getEObject(),
						target,
						VisitasElementTypes.ContinuacionEtapaContinuacion_4001,
						ContinuacionEtapaContinuacionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getIncomingFeatureModelFacetLinks_Etapa_ContinuacionEtapa_4002(
			Continuacion target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == VisitasPackage.eINSTANCE
					.getEtapa_ContinuacionEtapa()) {
				result.add(new VisitasLinkDescriptor(setting.getEObject(),
						target,
						VisitasElementTypes.EtapaContinuacionEtapa_4002,
						EtapaContinuacionEtapaEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getIncomingFeatureModelFacetLinks_Etapa_RecursoEtapa_4003(
			Recurso target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == VisitasPackage.eINSTANCE
					.getEtapa_RecursoEtapa()) {
				result.add(new VisitasLinkDescriptor(setting.getEObject(),
						target, VisitasElementTypes.EtapaRecursoEtapa_4003,
						EtapaRecursoEtapaEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getOutgoingFeatureModelFacetLinks_Continuacion_EtapaContinuacion_4001(
			Continuacion source) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		Etapa destination = source.getEtapaContinuacion();
		if (destination == null) {
			return result;
		}
		result.add(new VisitasLinkDescriptor(source, destination,
				VisitasElementTypes.ContinuacionEtapaContinuacion_4001,
				ContinuacionEtapaContinuacionEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getOutgoingFeatureModelFacetLinks_Etapa_ContinuacionEtapa_4002(
			Etapa source) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		for (Iterator<?> destinations = source.getContinuacionEtapa()
				.iterator(); destinations.hasNext();) {
			Continuacion destination = (Continuacion) destinations.next();
			result.add(new VisitasLinkDescriptor(source, destination,
					VisitasElementTypes.EtapaContinuacionEtapa_4002,
					EtapaContinuacionEtapaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<VisitasLinkDescriptor> getOutgoingFeatureModelFacetLinks_Etapa_RecursoEtapa_4003(
			Etapa source) {
		LinkedList<VisitasLinkDescriptor> result = new LinkedList<VisitasLinkDescriptor>();
		Recurso destination = source.getRecursoEtapa();
		if (destination == null) {
			return result;
		}
		result.add(new VisitasLinkDescriptor(source, destination,
				VisitasElementTypes.EtapaRecursoEtapa_4003,
				EtapaRecursoEtapaEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<VisitasNodeDescriptor> getSemanticChildren(View view) {
			return VisitasDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<VisitasLinkDescriptor> getContainedLinks(View view) {
			return VisitasDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<VisitasLinkDescriptor> getIncomingLinks(View view) {
			return VisitasDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<VisitasLinkDescriptor> getOutgoingLinks(View view) {
			return VisitasDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
