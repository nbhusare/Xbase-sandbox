package org.ne.xtext.example.program.ui.documentprovider

import com.google.inject.Inject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.source.Annotation
import org.eclipse.ui.IEditorInput
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider
import org.ne.xtext.example.program.interpreter.ProgramInterpreter
import org.ne.xtext.example.program.programDsl.Program

class ProgramDocumentProvider extends XtextDocumentProvider {

	@Inject ProgramInterpreter programInterpreter

	override protected doSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
		boolean overwrite) throws CoreException {
		if (document instanceof IXtextDocument) {
			document.readOnly [
				if (!contents.empty && !(element as IEditorInput).hasError) {
					programInterpreter.run(contents.head as Program)
				}
			]
		}
		super.doSaveDocument(monitor, element, document, overwrite)
	}

	def hasError(IEditorInput editorInput) {
		val annotations = getAnnotationModel(editorInput)?.annotationIterator
		while (annotations != null && annotations.hasNext) {
			val annotation = annotations.next
			if (annotation instanceof Annotation && annotation.type == XtextEditor.ERROR_ANNOTATION_TYPE)
				return true
		}
		false
	}
}
