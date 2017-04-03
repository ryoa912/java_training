/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class NameOpValue {
	public static final String word1 = "first";
	public static final String word2 = "second";
	public static final String word3 = "third";
	static int num1 = 0;
	static int num2 = 0;
	static int num3 = 0;

	static void opStream(InputStream source) throws IOException {
		Reader r = new BufferedReader(new InputStreamReader(source));
		StreamTokenizer in = new StreamTokenizer(r);
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			//オプションに応じた処理を実装

			//終了を受け取った時点でreturn
		}
	}

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;		//入力はコンソールから受ける
		NameOpValue.opStream(in);
		System.out.println("end.");
	}
}
