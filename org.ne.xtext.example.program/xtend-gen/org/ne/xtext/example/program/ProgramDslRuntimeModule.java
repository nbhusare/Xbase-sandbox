/**
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program;

import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.ne.xtext.example.program.AbstractProgramDslRuntimeModule;
import org.ne.xtext.example.program.interpreter.ProgramInterpreter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class ProgramDslRuntimeModule extends AbstractProgramDslRuntimeModule {
  public Class<? extends XbaseInterpreter> bindXbaseInterpreter() {
    return ProgramInterpreter.class;
  }
}
