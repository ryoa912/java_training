/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex04;

import java.util.ListIterator;

public class MyShortStrings implements ListIterator<String>{
	//ShortStringsを拡張すべきか
	//→No.privateな変数にアクセスできないため。

	@Override
	public boolean hasNext() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public String next() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public String previous() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void remove() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void set(String e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void add(String e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
