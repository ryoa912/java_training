/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex08;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MyScanner {
	static final int CELLS = 4;
	static final String COM = ",";

	/**
	 * CSVファイルを読み込み、要素のリストで出力する
	 * @param source CSVファイル
	 * @return 要素のリスト
	 * @throws IOException 4つ以上のカンマを持つ行が存在する
	 */
	public static List<String[]> readCSVTable(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		List <String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				int c = countChar(line, COM);
				if (c >= CELLS) {
					throw new IllegalArgumentException();
				}
				String[] cells = new String[CELLS];
				MatchResult match = in.match();
				for (int i=0; i<CELLS; i++) {
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
			}
			if (in.hasNextLine())
				in.nextLine();	//改行を読み飛ばし
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}

	/**
	 * 文字列内の対象文字列の出現回数を返す
	 * @param src 探す先の文字列
	 * @param target 対象文字列
	 * @return 出現回数
	 */
	public static final int countChar(String src, String target) {
		String targets = src;
	    String item = target;
	    int count = 0;
	    int s = 0;
	    while (s < targets.length()) {
	        int index = targets.indexOf(item, s);
	        if (index <= 0) {
	        	return count;
	        }
	        s = (index + item.length());
	        count++;
	    }
	    return count;
	}

	public static final void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.out.println("Argument Exception.");
			return;
		}

		FileReader r = new FileReader(args[0]);
		List<String[]> ret = null;
		try {
			ret = readCSVTable(r);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return;
		}

		for (String[] strs : ret) {
			for (String str: strs) {
				System.out.println(str);
			}
		}
	}
}
