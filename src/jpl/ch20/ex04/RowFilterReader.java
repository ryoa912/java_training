/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class RowFilterReader extends FilterReader {
	public RowFilterReader(Reader in) {
		super(in);
	}
	public int read() throws IOException {
		int c = super.read();
		return c;		//TODO：1行貯まるまで待つ処理
	}
	public int read(char[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i=offset; i< last; i++) {
			buf[i] = buf[i];	//TODO：1行貯まるまで待つ処理
		}
		return nread;
	}

}
