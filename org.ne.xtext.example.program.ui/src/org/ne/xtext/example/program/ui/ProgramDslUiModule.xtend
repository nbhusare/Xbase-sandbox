/*
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider
import org.ne.xtext.example.program.ui.documentprovider.ProgramDocumentProvider

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class ProgramDslUiModule extends AbstractProgramDslUiModule {

	override Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return ProgramDocumentProvider
	}
}
