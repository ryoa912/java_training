/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class RowFilterReader extends FilterReader {
	public RowFilterReader(Reader in) {
		super(in);
	}
	public int read() throws IOException {
		int c = super.read();
		return c;
	}
	public int read(char[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i=offset; i< last; i++) {
			buf[i] = buf[i];
		}
		return nread;
	}
	public String readRow() throws IOException {
		String str = "";
		int c = 0;
		while (true) {
			c = this.read();
			if (c == -1) {
				return str;
			}
			str += (char)c;
			if (str.contains("\\n")) {
				return str;
			}
		}

	}
	public static void main(String[] args) throws IOException {
		StringReader src = new StringReader(args[0]);
		RowFilterReader f = new RowFilterReader(src);
		String s = f.readRow();
		System.out.print(s);
		System.out.println();
	}
}
