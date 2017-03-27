/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByteFilter extends FilterInputStream {
	public TranslateByteFilter(InputStream in) {
		super(in);
	}
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toUpperCase((char)c));
	}
	public int read(byte[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i = offset; i < last; i++) {
			buf[i] = (byte) Character.toUpperCase((char)buf[i]);
		}
		return nread;
	}
}
