/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeDesc {
	public static void main(String[] args) {
		TypeDesc desc = new TypeDesc();
		for (String name : args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e){
				System.err.println(e);	//report the error
			}
		}
	}

	//デフォルトで標準出力に表示する
	private java.io.PrintStream out = System.out;

	//型名にラベル付けする printType() で使用される
	private static String[]
			basic = { "class", "interface", "enum", "annotation"},
			supercl = {"extends", "implements"},
			iFace = {"null", "extends"};
	private void printType(Type type, int depth, String[] labels) {
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

		//Objectクラスの場合、return
		if (cls.getCanonicalName() == Object.class.getName())
			return;


		//この型を表示
		for (int i=0; i<depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3:
			cls.isEnum() ? 2 :
			cls.isInterface() ? 1 : 0;
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		//ネストした型の場合、続けてどの型の中にネストしているか表示
		Class<?> declaring = cls.getDeclaringClass();
		if (declaring != null) {
			out.print(" declaring " + declaring.getCanonicalName());
		}

		//あれば、ジェネリック型パラメータを表示
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
			out.print('<');
			for (TypeVariable<?> param : params) {
				out.print(param.getName());
				out.print(" ");
			}
			out.println("\b\b>");
		} else {
			out.println();
		}

		//このクラスが実装している全てのインターフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface : interfaces) {
			printType(iface, depth + 1,
					cls.isInterface() ? iFace : supercl);
		}
		//スーパークラスに対して再帰
		printType(cls.getGenericSuperclass(),
				depth + 1, supercl);
	}
}
