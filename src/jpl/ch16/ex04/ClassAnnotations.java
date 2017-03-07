/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex04;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassAnnotations {
	public static void printAnnotations(Type type) {
		if (type == null)
			return;

		//TypeをClassオブジェクトに変換する
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>)
			((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		try {
			Annotation[] annotations = cls.getAnnotations();
			for (int i=0; i<annotations.length ; i++) {
				System.out.println(annotations[i].annotationType());
			}

		} catch (TypeNotPresentException e) {
			throw new Error("Unexpected annotation type");
		}

	}

	public static void main(String[] args) {
		printAnnotations((Class<Foo>)Foo.class);
	}
}
