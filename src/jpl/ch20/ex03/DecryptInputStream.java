/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex03;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
	public DecryptInputStream(InputStream in) {
		super(in);
	}
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : 'a');		//TODO：暗号化処理
	}
	public int read(byte[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i = offset; i < last; i++) {
			buf[i] = 'a';	//TODO：暗号化処理
		}
		return nread;
	}
	public static void main(String[] args) throws IOException {
		InputStream in;
		if (args.length == 0) {
			in = System.in;
		} else {
			in = new FileInputStream(args[0]);
		}
		FilterInputStream f = new DecryptInputStream(in);
		int c;
		while ((c = f.read()) != -1) {
			System.out.println((char)c);
		}
		System.out.println();
	}
}
