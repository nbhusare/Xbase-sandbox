
package org.xtext.example.mydsl.compiler;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.xtext.example.mydsl.myDsl.XIfExpression;
import org.xtext.example.mydsl.scoping.MyDslOperatorMapping;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class MyDslCompiler extends XbaseCompiler {

	@Inject
	private XExpressionHelper expressionHelper;

	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XIfExpression) {
			_toJavaExpression((XIfExpression) obj, appendable);
		} else if (obj instanceof org.eclipse.xtext.xbase.XIfExpression) {
			// Do Nothing
			return;
		} else
			super.internalToConvertedExpression(obj, appendable);
	}

	protected void _toJavaExpression(XIfExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XIfExpression) {
			_toJavaStatement((XIfExpression) obj, appendable, isReferenced);
		} else if (obj instanceof org.eclipse.xtext.xbase.XIfExpression) {
			// Do Nothing
			return;
		} else
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
	}

	protected void _toJavaStatement(XIfExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (isReferenced)
			declareSyntheticVariable(expr, b);
		internalToJavaStatement(expr.getIf(), b, true);

		b.newLine().append("if (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getThen());
		internalToJavaStatement(expr.getThen(), b, canBeReferenced);
		if (canBeReferenced) {
			b.newLine();
			b.append(getVarName(expr, b));
			b.append(" = ");
			internalToConvertedExpression(expr.getThen(), b, getLightweightType(expr));
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("}");
	}

	@Override
	protected void _toJavaStatement(XAbstractFeatureCall expr, ITreeAppendable b, boolean isReferenced) {
		if (expressionHelper.isOperatorFromExtension(expr, MyDslOperatorMapping.IN, MyDslOperatorMapping.class)) {
			final XBinaryOperation binaryOperation = (XBinaryOperation) expr;
			final XExpression leftOperand = binaryOperation.getLeftOperand();
			final XExpression rightOperand = binaryOperation.getRightOperand();

			//TODO: Pending work.
		} else {
			super._toJavaStatement(expr, b, isReferenced);
		}
	}

}
