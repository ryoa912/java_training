package jpl.ch10.ex05;

public class BetweenCharToChar {
	public static final String printBetweenCharToChar (char c1, char c2) {
		String ret = "";
		if (c1 <= c2) {
			char tmp = c1;
			while (true) {
				tmp++;
				if (tmp >= c2) {
					break;
				}
				String new_ret = ret.concat(String.valueOf(tmp));
				ret = new_ret;
			}
		} else {		//(c1 > c2)
			char tmp = c2;
			while (true) {
				tmp++;
				if (tmp >= c1) {
					break;
				}
				String new_ret = ret.concat(String.valueOf(tmp));
				ret = new_ret;
			}
		}
		System.out.println(ret);
		return ret;
	}
}
