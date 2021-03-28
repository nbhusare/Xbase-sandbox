package org.xtext.example.mydsl.compiler;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.xtext.example.mydsl.myDsl.XIfExpression;

@SuppressWarnings("restriction")
public class MyDslTypeComputer extends XbaseTypeComputer {

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XIfExpression) {
			_computeTypes((XIfExpression) expression, state);
		} else if (expression instanceof org.eclipse.xtext.xbase.XIfExpression) {
			// Do nothing
			return;
		} else
			super.computeTypes(expression, state);
	}

	protected void _computeTypes(final XIfExpression object, ITypeComputationState state) {
		XExpression ifCondition = object.getIf();
		state.withExpectation(getRawTypeForName(Boolean.TYPE, state)).computeTypes(ifCondition);

		XExpression thenExpression = object.getThen();
		if (thenExpression != null) {
			ITypeComputationState thenState = reassignCheckedType(ifCondition, thenExpression, state);
			thenState.computeTypes(thenExpression);
		}
	}
}
