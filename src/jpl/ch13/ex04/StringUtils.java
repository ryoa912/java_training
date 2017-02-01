package jpl.ch13.ex04;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	static final String LF = "\n";
	static final String WS = " ";
	static final int pairSize = 2;
	static final int typeIndex = 0;
	static final int valueIndex = 1;

	public static List<Object> delimitedObjectArray(String src) {
		List<Object> list = new ArrayList<Object>();
		String[] tmp;
		String[] ret = src.split(LF);
		for (int i=0; i<ret.length; i++) {
			tmp = ret[i].split(WS);
			if (tmp.length == pairSize) {
				switch (tmp[typeIndex]) {
					case "Boolean": {
						list.add(new Boolean(tmp[valueIndex]));
						break;
					}
					case "Integer": {
						list.add(new Integer(tmp[valueIndex]));
						break;
					}
					case "Character": {
						list.add(new Character(tmp[valueIndex].charAt(0)));
						break;
					}
					default: {
						break;
					}
				}
			}
		}
		return list;
	}
}
