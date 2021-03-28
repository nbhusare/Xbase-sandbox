package org.xtext.example.mydsl.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

public class MyDslImportSectionNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {

	public static final QualifiedName MYDSL_LIB = QualifiedName.create("org", "xtext", "example", "mydsl", "libs");

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> implicitImports = new ArrayList<>(super.getImplicitImports(ignoreCase));
		implicitImports.add(doCreateImportNormalizer(MYDSL_LIB, true, ignoreCase));
		return implicitImports;
	}

}
