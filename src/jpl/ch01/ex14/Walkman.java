package jpl.ch01.ex14;

public class Walkman {
	private Boolean terminal = false;

	public Boolean play() {
		if (terminal == false) {
			System.out.println("no listener, end.");
			return false;
		} else {
			System.out.println("start.");
			return true;
		}
	}

	public void connectTerminal() {
		System.out.println("connected terminal.");
		terminal = true;
	}

	public void disconnectTerminal() {
		System.out.println("disconnected terminal.");
		terminal = false;
	}
}
