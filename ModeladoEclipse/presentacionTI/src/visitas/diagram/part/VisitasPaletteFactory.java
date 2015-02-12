package visitas.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import visitas.diagram.providers.VisitasElementTypes;

/**
 * @generated
 */
public class VisitasPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createVisitas1Group());
	}

	/**
	 * Creates "visitas" palette tool group
	 * @generated
	 */
	private PaletteContainer createVisitas1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Visitas1Group_title);
		paletteContainer.setId("createVisitas1Group"); //$NON-NLS-1$
		paletteContainer.add(createEtapa1CreationTool());
		paletteContainer.add(createRecurso2CreationTool());
		paletteContainer.add(createContinuacion3CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createRecurso5CreationTool());
		paletteContainer.add(createContinuacion6CreationTool());
		paletteContainer.add(createEtapa7CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEtapa1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Etapa1CreationTool_title,
				Messages.Etapa1CreationTool_desc,
				Collections.singletonList(VisitasElementTypes.Etapa_2002));
		entry.setId("createEtapa1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.Etapa_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRecurso2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Recurso2CreationTool_title,
				Messages.Recurso2CreationTool_desc,
				Collections.singletonList(VisitasElementTypes.Recurso_2001));
		entry.setId("createRecurso2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.Recurso_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContinuacion3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Continuacion3CreationTool_title,
				Messages.Continuacion3CreationTool_desc,
				Collections
						.singletonList(VisitasElementTypes.Continuacion_2003));
		entry.setId("createContinuacion3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.Continuacion_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRecurso5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Recurso5CreationTool_title,
				Messages.Recurso5CreationTool_desc,
				Collections
						.singletonList(VisitasElementTypes.EtapaRecursoEtapa_4003));
		entry.setId("createRecurso5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.EtapaRecursoEtapa_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContinuacion6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Continuacion6CreationTool_title,
				Messages.Continuacion6CreationTool_desc,
				Collections
						.singletonList(VisitasElementTypes.EtapaContinuacionEtapa_4002));
		entry.setId("createContinuacion6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.EtapaContinuacionEtapa_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEtapa7CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Etapa7CreationTool_title,
				Messages.Etapa7CreationTool_desc,
				Collections
						.singletonList(VisitasElementTypes.ContinuacionEtapaContinuacion_4001));
		entry.setId("createEtapa7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(VisitasElementTypes
				.getImageDescriptor(VisitasElementTypes.ContinuacionEtapaContinuacion_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
