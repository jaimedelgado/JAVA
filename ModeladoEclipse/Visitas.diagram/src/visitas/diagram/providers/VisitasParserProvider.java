package visitas.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import visitas.VisitasPackage;
import visitas.diagram.edit.parts.ContinuacionTextoContinuacionEditPart;
import visitas.diagram.edit.parts.EtapaHtmlEtapaEditPart;
import visitas.diagram.edit.parts.RecursoHtmlRecursoEditPart;
import visitas.diagram.parsers.MessageFormatParser;
import visitas.diagram.part.VisitasVisualIDRegistry;

/**
 * @generated
 */
public class VisitasParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser recursoHtmlRecurso_5001Parser;

	/**
	 * @generated
	 */
	private IParser getRecursoHtmlRecurso_5001Parser() {
		if (recursoHtmlRecurso_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { VisitasPackage.eINSTANCE
					.getRecurso_HtmlRecurso() };
			MessageFormatParser parser = new MessageFormatParser(features);
			recursoHtmlRecurso_5001Parser = parser;
		}
		return recursoHtmlRecurso_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser etapaHtmlEtapa_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEtapaHtmlEtapa_5002Parser() {
		if (etapaHtmlEtapa_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { VisitasPackage.eINSTANCE
					.getEtapa_HtmlEtapa() };
			MessageFormatParser parser = new MessageFormatParser(features);
			etapaHtmlEtapa_5002Parser = parser;
		}
		return etapaHtmlEtapa_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser continuacionTextoContinuacion_5003Parser;

	/**
	 * @generated
	 */
	private IParser getContinuacionTextoContinuacion_5003Parser() {
		if (continuacionTextoContinuacion_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { VisitasPackage.eINSTANCE
					.getContinuacion_TextoContinuacion() };
			MessageFormatParser parser = new MessageFormatParser(features);
			continuacionTextoContinuacion_5003Parser = parser;
		}
		return continuacionTextoContinuacion_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case RecursoHtmlRecursoEditPart.VISUAL_ID:
			return getRecursoHtmlRecurso_5001Parser();
		case EtapaHtmlEtapaEditPart.VISUAL_ID:
			return getEtapaHtmlEtapa_5002Parser();
		case ContinuacionTextoContinuacionEditPart.VISUAL_ID:
			return getContinuacionTextoContinuacion_5003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(VisitasVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(VisitasVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (VisitasElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
