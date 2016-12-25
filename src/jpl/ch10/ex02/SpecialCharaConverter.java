package jpl.ch10.ex02;

public class SpecialCharaConverter {
	public final String convert(String value) {
		String answer = "";
		for (int i=0; i<value.length(); i++) {
			String n = answer.concat(convertSpecialChara(value.charAt(i)));
			answer = n;
		}
		return answer;
	}

	private final String convertSpecialChara(char b) {
		String ans;
		switch (b) {
			case '\n': ans = "\\n";		//改行\u000A
			case '\t': ans = "\\t";		//タブ\u0009
			case '\b': ans = "\\b";//バックスペース\u0008
			case '\r': ans = "\\r";//復帰\u000D
			case '\f': ans = "\\f";//フォームフィールド\u000C
			case '\\': ans = "\\\\";//バックスラッシュ自身\u005C
			case '\'': ans = "\\\'";//シングルクォート\u0027
			case '\"': ans = "\\\"";//ダブルクォート\u0022
			default: ans = String.valueOf(b);
		}
		return ans;
	}
}
