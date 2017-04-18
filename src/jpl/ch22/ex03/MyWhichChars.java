/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;

public class MyWhichChars {
	private HashMap<Byte, BitSet> used = new HashMap<Byte, BitSet>();

	public MyWhichChars(String str) {
		char c;
		byte b1;	//上位バイト
		byte b2;	//下位バイト
		BitSet bs = null;
		for (int i=0; i<str.length(); i++) {
			c = str.charAt(i);
			b1 = (byte) ((c >>> 8) & 0xFF);
			b2 = (byte) ( c & 0xFF);

			bs = used.get(b1);
			if (bs != null) {
				bs.set(b2);
			} else {
				bs = new BitSet();
				bs.set(b2);
				used.put(b1, bs);
			}
		}
	}

	public void print() {
		for (Byte key : used.keySet()) {
		    System.out.println(key + " => " + used.get(key));
		}
	}
	public static void main(String[] args) {
		String str = "Testing 1 2 3";
		MyWhichChars obj = new MyWhichChars(str);
		obj.print();
	}
}
