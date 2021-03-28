package org.xtext.example.mydsl.scoping;

import java.util.List;

import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;
import org.xtext.example.mydsl.libs.MyDslExtensions;

@SuppressWarnings("restriction")
public class MyDslImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
	
	@Override
	protected List<Class<?>> getExtensionClasses() {
		List<Class<?>> extensionClasses = super.getExtensionClasses();
		extensionClasses.add(MyDslExtensions.class);
		return extensionClasses;
	}
	
}
 