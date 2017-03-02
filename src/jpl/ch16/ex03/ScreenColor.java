package jpl.ch16.ex03;

public class ScreenColor {
	private Object myColor; //変換される前の色

	public ScreenColor(Object value) {
		this.myColor = value;
	}

	public Object getValue() {
		return this.myColor;
	}
}
