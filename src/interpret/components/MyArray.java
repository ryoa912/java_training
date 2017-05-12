/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.components;

import java.lang.reflect.Array;

import interpret_sample.InterpretObject;

public class MyArray extends MyInstance {
	protected final int length;

	public MyArray(Object object, String name, int length) {
	    super(object, name);
		this.length = length;
	}

	public Object getObjectAt(int index) {
		return Array.get(object, index);
	}

	public InterpretObject getObjectElementAt(int index) {
		return new InterpretObject(Array.get(object, index), name + "[" + index
				+ "]");
	}

	public void setObjectElementAt(int index, Object value) {
		Array.set(object, index, value);
	}

	public int length() {
		return length;
	}
}
