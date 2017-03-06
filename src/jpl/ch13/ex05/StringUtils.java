package jpl.ch13.ex05;

public class StringUtils {
	public static String insertComma(String src) {
		int length = src.length();
		StringBuilder sb = new StringBuilder("");

		for (int i=0; i<length; i++) {
			sb.insert(0, src.charAt(length-i-1));
			int j = i % 3;
			if (j == 2 && i != length-1) {
				sb.insert(0,",");
			}
		}
		return sb.toString();
	}
	
	//Ä‹AŒÄ‚Ño‚µ‚ÅŽÀŒ»‚·‚é•û–@
	public static String insertCommaAnswer(String src) {
		StringBuilder sb = new StringBuilder(src);

		for (int i=src.length()-3; i>0; i-=3) {
			sb.insert(i, ',');
		}
		return sb.toString();
	}
}
