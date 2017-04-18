/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex02;

import java.util.HashSet;
import java.util.Iterator;

public class MyWhichChars {
	private HashSet<Character> used = new HashSet<Character>();

	public MyWhichChars(String str) {
		for (int i=0; i<str.length(); i++)
			used.add(str.charAt(i));
	}

	public String toString() {
		String desc = "[";
		Iterator<Character> it = used.iterator();
		while (it.hasNext()) {
			desc += (char) it.next();
		}
		return desc + "]";
	}
	public static void main(String[] args) {
		String str = "Testing 1 2 3";
		MyWhichChars obj = new MyWhichChars(str);
		System.out.println(obj.toString());
	}
}
