package jpl.ch01.ex14;

public class Walkman2 extends Walkman {
	private Boolean terminal2 = false;

	public Boolean play() {
		if (terminal2 == false) {
			return super.play();
		} else {
			System.out.println("start.");
			return true;
		}
	}

	public void connectTerminal2() {
		System.out.println("connected terminal2.");
		terminal2 = true;
	}

	public void disconnectTerminal2() {
		System.out.println("disconnected terminal2.");
		terminal2 = false;
	}

}
