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
			case '\n':
				ans = "\\n";		//改行\u000A
				break;
			case '\t':
				ans = "\\t";		//タブ\u0009
				break;
			case '\b':
				ans = "\\b";//バックスペース\u0008
				break;
			case '\r':
				ans = "\\r";//復帰\u000D
				break;
			case '\f':
				ans = "\\f";//フォームフィールド\u000C
				break;
			case '\\':
				ans = "\\\\";//バックスラッシュ自身\u005C
				break;
			case '\'':
				ans = "\\\'";//シングルクォート\u0027
				break;
			case '\"':
				ans = "\\\"";//ダブルクォート\u0022
				break;
			default:
				ans = String.valueOf(b);
				break;
		}
		return ans;
	}
}
