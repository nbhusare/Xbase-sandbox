/*
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ProgramDslAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/ne/xtext/example/program/parser/antlr/internal/InternalProgramDsl.tokens");
	}
}
