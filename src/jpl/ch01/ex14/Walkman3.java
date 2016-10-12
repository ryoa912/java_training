package jpl.ch01.ex14;

public class Walkman3 extends Walkman2 {
	private Boolean communicationMode;

	public Boolean play() {
		if (communicationMode == true) {
			System.out.println("[Walkman3::play] communicationMode == true.");
		} else {
			System.out.println("[Walkman3::play] communicationMode == false.");
		}
		return super.play();
	}

	public void setCommunicationMode(Boolean mode) {
		System.out.println("set communication mode: " +  mode);
		communicationMode = mode;
	}
}
