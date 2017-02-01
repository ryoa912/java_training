package jpl.ch13.ex03;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	public static String delimitedString(
			String from, char start, char end) {
		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end);
		if (startPos == -1) {
			return null;
		} else if (endPos == -1) {
			return null;
		} else if (startPos > endPos) {
			return null;
		} else {
			return from.substring(startPos,  endPos+1);
		}
	}

	public static List<String> delimitedStringArray(
			String from, char start, char end) {
		List<String> list = new ArrayList<String>();
		int s = 0;
		while (from.indexOf(start,s) != -1) {
			int o = from.indexOf(start,s);
			int c = from.indexOf(end, s+1);
			if (c != -1) {
				list.add(from.substring(o, c+1));
				s = c + 1;
			} else {
				break;
			}
		}
		return list;
	}
}
