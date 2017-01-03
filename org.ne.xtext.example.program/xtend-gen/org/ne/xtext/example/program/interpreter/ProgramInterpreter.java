package org.ne.xtext.example.program.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.ne.xtext.example.program.programDsl.Program;

@SuppressWarnings("all")
public class ProgramInterpreter extends XbaseInterpreter {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  public Object run(final Program program) {
    Object _xifexpression = null;
    boolean _notEquals = (!Objects.equal(program, null));
    if (_notEquals) {
      Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(program);
      Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_jvmElements, JvmOperation.class);
      JvmOperation _head = IterableExtensions.<JvmOperation>head(_filter);
      Object _invokeOperation = null;
      if (_head!=null) {
        List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
        _invokeOperation=this.invokeOperation(_head, null, _emptyList);
      }
      _xifexpression = _invokeOperation;
    }
    return _xifexpression;
  }
  
  @Override
  protected Object invokeOperation(final JvmOperation operation, final Object receiver, final List<Object> argumentValues) {
    try {
      Object _xblockexpression = null;
      {
        Set<EObject> _sourceElements = this._iJvmModelAssociations.getSourceElements(operation);
        final EObject program = IterableExtensions.<EObject>head(_sourceElements);
        Object _xifexpression = null;
        if ((program instanceof Program)) {
          Object _xblockexpression_1 = null;
          {
            XBlockExpression _body = ((Program)program).getBody();
            final IEvaluationResult result = this.evaluate(_body);
            Throwable _exception = result.getException();
            boolean _notEquals = (!Objects.equal(_exception, null));
            if (_notEquals) {
              throw result.getException();
            }
            _xblockexpression_1 = result.getResult();
          }
          _xifexpression = _xblockexpression_1;
        } else {
          _xifexpression = super.invokeOperation(operation, receiver, argumentValues);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
