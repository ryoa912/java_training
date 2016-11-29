package jpl.ch06.ex04;
import java.awt.Color;

public enum SignalColor {
	RED(Color.red),
	YELLOW(Color.yellow),
	BLUE(Color.blue);

	Color color;
	SignalColor(Color color) { this.color = color; }

	public Color getColor() { return color; }
}
