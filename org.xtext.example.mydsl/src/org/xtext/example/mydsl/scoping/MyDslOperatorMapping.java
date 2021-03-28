package org.xtext.example.mydsl.scoping;

import static org.eclipse.xtext.naming.QualifiedName.create;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Singleton;

@SuppressWarnings("restriction")
@Singleton
public class MyDslOperatorMapping extends OperatorMapping {

	public static final QualifiedName EQUALS_02 = create("is");
	public static final QualifiedName IN = create("IN");

	@Override
	protected void initializeMapping() {
		map.put(IN, create("operator_in"));
		super.initializeMapping();
	}

	@Override
	public QualifiedName getMethodName(QualifiedName operator) {
		if (EQUALS_02.equals(operator)) {
			return getMethodName(EQUALS);
		}

		return super.getMethodName(operator);
	}

}
