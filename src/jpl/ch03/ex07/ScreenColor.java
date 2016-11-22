package jpl.ch03.ex07;

public class ScreenColor {
	private Object myColor; //変換される前の色

	public ScreenColor(Object value) {
		this.myColor = value;
	}

	public Object getValue() {
		return this.myColor;
	}
}
