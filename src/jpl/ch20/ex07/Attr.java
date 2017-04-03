/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	public void writeData(DataOutputStream out) throws IOException {
		out.writeChars(this.name);
		out.writeChars(this.value.toString());
	}

	public void readData(DataInputStream in) throws IOException {
		String[] data = new String[in.readInt()];
		for (int i=0; i<data.length; i++) {
			data[i] = in.readUTF();
		}
		//オブジェクトを作成する処理
		in.close();
	}
}
