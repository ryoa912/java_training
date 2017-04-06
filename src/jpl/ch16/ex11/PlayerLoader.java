/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlayerLoader extends ClassLoader {
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] buf = byteForClass(name);
			return defineClass(name, buf, 0, buf.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}

	protected byte[] byteForClass(String name) throws IOException, ClassNotFoundException {
		FileInputStream in = null;
		try {
			in = streamFor(name + ".class");
			int length = in.available();	//バイト数を得る
			if (length == 0) {
				throw new ClassNotFoundException(name);
			}
			byte[] buf = new byte[length];
			in.read(buf);	//バイト列を読み込む
			return buf;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private FileInputStream streamFor(String string) throws IOException {
		File file = new File(string);
		if (file.length() <= 0) {
			throw new IOException();
		}
		return new FileInputStream(file);
	}
}
