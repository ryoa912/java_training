/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex02;

import java.util.BitSet;

public class WhichChars {
	private BitSet used = new BitSet();

	public WhichChars(String str) {
		for (int i=0; i<str.length(); i++)
			used.set(str.charAt(i));
	}

	public String toString() {
		String desc = "[";
		for (int i=0; i>=0; i=used.nextSetBit(i+1)) {
			desc += (char) i;
		}
		return desc + "]";
	}
}
