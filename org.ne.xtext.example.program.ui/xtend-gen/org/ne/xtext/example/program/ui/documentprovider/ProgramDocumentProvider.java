package org.ne.xtext.example.program.ui.documentprovider;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Iterator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.ne.xtext.example.program.interpreter.ProgramInterpreter;
import org.ne.xtext.example.program.programDsl.Program;

@SuppressWarnings("all")
public class ProgramDocumentProvider extends XtextDocumentProvider {
  @Inject
  private ProgramInterpreter programInterpreter;
  
  @Override
  protected void doSaveDocument(final IProgressMonitor monitor, final Object element, final IDocument document, final boolean overwrite) throws CoreException {
    if ((document instanceof IXtextDocument)) {
      final IUnitOfWork<Object, XtextResource> _function = (XtextResource it) -> {
        Object _xifexpression = null;
        if (((!it.getContents().isEmpty()) && (!this.hasError(((IEditorInput) element))))) {
          EList<EObject> _contents = it.getContents();
          EObject _head = IterableExtensions.<EObject>head(_contents);
          _xifexpression = this.programInterpreter.run(((Program) _head));
        }
        return _xifexpression;
      };
      ((IXtextDocument)document).<Object>readOnly(_function);
    }
    super.doSaveDocument(monitor, element, document, overwrite);
  }
  
  public boolean hasError(final IEditorInput editorInput) {
    boolean _xblockexpression = false;
    {
      IAnnotationModel _annotationModel = this.getAnnotationModel(editorInput);
      Iterator<Annotation> _annotationIterator = null;
      if (_annotationModel!=null) {
        _annotationIterator=_annotationModel.getAnnotationIterator();
      }
      final Iterator<Annotation> annotations = _annotationIterator;
      while (((!Objects.equal(annotations, null)) && annotations.hasNext())) {
        {
          final Annotation annotation = annotations.next();
          if (((annotation instanceof Annotation) && Objects.equal(annotation.getType(), XtextEditor.ERROR_ANNOTATION_TYPE))) {
            return true;
          }
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
}
