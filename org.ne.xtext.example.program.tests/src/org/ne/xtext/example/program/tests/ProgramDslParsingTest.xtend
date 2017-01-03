/*
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.ne.xtext.example.program.programDsl.Program

@RunWith(XtextRunner)
@InjectWith(ProgramDslInjectorProvider)
class ProgramDslParsingTest{

	@Inject
	ParseHelper<Program> parseHelper

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
	}

}
