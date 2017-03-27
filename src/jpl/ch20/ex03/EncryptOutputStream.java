/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {
	public EncryptOutputStream(OutputStream out) {
		super(out);
	}
	public void write(int c) throws IOException {
		super.write(c);		//TODO：復号化処理
	}
	public void write(byte[] buf, int offset, int count) throws IOException {
		super.write(buf, offset, count);	//TODO：復号化処理
	}
}
