package org.ne.xtext.example.program.interpreter

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.ne.xtext.example.program.programDsl.Program

class ProgramInterpreter extends XbaseInterpreter {

	@Inject extension IJvmModelAssociations

	def run(Program program) {
		if (program != null) {
			program.jvmElements.filter(JvmOperation).head?.invokeOperation(null, emptyList)
		}
	}

	override protected invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues) {
		val program = operation.sourceElements.head
		if (program instanceof Program) {
			val result = evaluate(program.body)
			if (result.exception != null)
				throw result.exception
			
			result.result	
		} else {
			super.invokeOperation(operation, receiver, argumentValues)
		}
	}

}
