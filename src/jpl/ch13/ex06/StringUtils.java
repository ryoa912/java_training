package jpl.ch13.ex06;

public class StringUtils {
	public static String insertSpacer(String src, String spacer, int num) {
		int length = src.length();
		StringBuilder sb = new StringBuilder("");

		for (int i=0; i<length; i++) {
			sb.insert(0, src.charAt(length-i-1));
			int j = i % num;
			if (j == (num-1) && i != length-1) {
				sb.insert(0, spacer);
			}
		}
		return sb.toString();
	}
}
