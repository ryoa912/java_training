/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex03;

import java.lang.reflect.Member;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassContents {
	private static final String JAVA_LANG = "java.lang.";
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printContents(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printContents(Type type) {
		if (type == null)	//再帰呼出し停止： スーパータイプが存在しない
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

		//メンバーの表示
		printMembers(cls.getFields());
		printMembers(cls.getConstructors());
		printMembers(cls.getMethods());

		//スーパークラスに対して再帰
		printContents(cls.getGenericSuperclass());
	}

	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, JAVA_LANG));
		}
	}

	private static String strip(String decl, String string) {
		return decl.replaceAll(string, "");
	}
}
