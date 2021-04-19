package org.xtext.example.mydsl.ide.contentassist;

import com.google.inject.Inject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslIdeContentProposalProvider extends IdeContentProposalProvider {
  @Inject
  @Extension
  private MyDslGrammarAccess _myDslGrammarAccess;
  
  @Inject
  private IScopeProvider scopeProvider;
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    super._createProposals(ruleCall, context, acceptor);
  }
}
