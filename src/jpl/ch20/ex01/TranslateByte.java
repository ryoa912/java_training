/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex01;

import java.io.IOException;

public class TranslateByte {
	public static void translate(String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		int b;
		while((b = System.in.read()) != -1) {
			System.out.write(b == from ? to : b);
		}
	}

	public static void main(String[] args) {
		String[] strs = new String[2];
		strs[0] = "b";
		strs[1] = "B";
		try {
			TranslateByte.translate(strs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
