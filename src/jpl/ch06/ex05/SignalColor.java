package jpl.ch06.ex05;
import java.awt.Color;

public enum SignalColor {
	RED(Color.red){
		public Color getColor() {
			return Color.red;
		}
	},
	YELLOW(Color.yellow) {
		public Color getColor() {
			return Color.yellow;
		}
	},
	BLUE(Color.blue){
		public Color getColor() {
			return Color.blue;
		}
	};

	Color color;
	SignalColor(Color color) { this.color = color; }

	public abstract Color getColor();
}
