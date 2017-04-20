/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex06;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Random;

public class NextGaussianInspecter extends Applet {
	private static Random rand = new Random();

	public void paint(Graphics g) {
		this.setSize(800, 600);

		int midHeight = this.getHeight() / 2;

		for(int x = 0; x < this.getWidth(); x++) {
			int y = (int) (rand.nextGaussian() * 50 + midHeight);
			g.drawLine(x, y, x, midHeight);
		}
	}

	public static void main(String[] args) {
		NextGaussianInspecter obj = new NextGaussianInspecter();
		obj.paint(null);
	}
}
