/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShortStrings implements Iterator<String> {
	private Iterator<String> strings;		//元の文字列
	private String nextShort;				//次が不明ならばnull
	private final int maxLen;				//この長さ以下の文字列だけ返す

	public ShortStrings(Iterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
	}

	public boolean hasNext() {
		if (nextShort != null)	//すでに見つけている
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;		//見つけられなかった
		return false;
	}

	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;	//nextShortを記憶する
		nextShort = null;		//nextShortを消費する
		return n;				//nextShortを返す
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
