/**
 * generated by Xtext 2.10.1
 */
package org.ne.xtext.example.program;

import org.ne.xtext.example.program.ProgramDslStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class ProgramDslStandaloneSetup extends ProgramDslStandaloneSetupGenerated {
  public static void doSetup() {
    ProgramDslStandaloneSetup _programDslStandaloneSetup = new ProgramDslStandaloneSetup();
    _programDslStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
