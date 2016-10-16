package jpl.ch01.ex15;

public interface Lookup {
	/** name と関連付けされた値を返す。
	 * そのような値がなければnull を返す
	 */
	Object find(String name);

	/** 値を追加する
	 */
	void add(String name, Object value);

	/** name と関連付けされた値を削除する
	 */
	void remove(String name);
}
