package org.xtext.example.mydsl.libs;

import java.util.List;

public class MyDslExtensions {

	public static boolean operator_in(Object a, List<Object> b) {
		return b.contains(a);
	}
}
