/*
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ne.xtext.example.program.programDsl.Program

class ProgramDslJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder

	def dispatch void infer(Program program, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		acceptor.accept(program.toClass(program.name) [
			if (program.body != null) {
				members += program.toMethod("main", typeRef(void)) [
					body = program.body
				]
			}
		])
	}

	private def getName(Program program) {
		program.eResource.URI.trimFileExtension.lastSegment.toFirstUpper
	}
}
