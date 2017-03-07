/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex05;

public class ScreenColor {
	private Object myColor; //変換される前の色

	public ScreenColor(Object value) {
		this.myColor = value;
	}

	public Object getValue() {
		return this.myColor;
	}
}
