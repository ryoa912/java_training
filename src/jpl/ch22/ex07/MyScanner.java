/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MyScanner {
	public static List<String[]> readCSVTable(Readable source, int cell_num) throws IOException {
		Scanner in = new Scanner(source);
		List <String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cell_num];
				MatchResult match = in.match();
				for (int i=0; i<cell_num; i++) {
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
				in.nextLine();	//改行を読み飛ばし
			} else {
				throw new IOException("Input format error.");
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}
}
