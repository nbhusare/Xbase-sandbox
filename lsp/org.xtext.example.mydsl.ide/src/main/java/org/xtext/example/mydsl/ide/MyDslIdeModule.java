/*
 * generated by Xtext 2.25.0
 */
package org.xtext.example.mydsl.ide;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.xtext.example.mydsl.ide.contentassist.MyDslIdeContentProposalProvider;

/**
 * Use this class to register ide components.
 */
public class MyDslIdeModule extends AbstractMyDslIdeModule {
	
	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return MyDslIdeContentProposalProvider.class;
	}
}
