/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex11;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class MyReader {
	static final int CELLS = 4;
	static final String COM = ",";
	private static StreamTokenizer tokenizer;

	/**
	 * CSVファイルを読み込み、要素のリストで出力する
	 * @param source CSVファイル
	 * @return 要素のリスト
	 * @throws IllegalArgumentException 4つ以上のカンマを持つ行が存在する
	 */
	public static List<String[]> readCSVTable(String inputFileName) throws IOException {
		FileReader fr = new FileReader(inputFileName);
		tokenizer = new StreamTokenizer(fr);
		tokenizer.resetSyntax();
		tokenizer.wordChars('0', '9');
		tokenizer.wordChars('a', 'z');
		tokenizer.wordChars('A', 'Z');
		tokenizer.wordChars('_', '_');

		List <String[]> vals = new ArrayList<String[]>();
		String[] strs = new String[CELLS];
		int token;
		int i=0;
		while ((token = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
			switch (token) {
			case StreamTokenizer.TT_EOL:
				vals.add(strs.clone());
				strs = new String[CELLS];
				i = 0;
				break;
			case StreamTokenizer.TT_WORD:
				strs[i] = tokenizer.sval;
				i++;
				break;
			default:
			}
		}

		return vals;
	}


	public static final void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.out.println("Argument Exception.");
			return;
		}
		List<String[]> ret = readCSVTable(args[0]);
		for (String[] strs : ret) {
			for (String str: strs) {
				System.out.println(str);
			}
		}
	}
}
