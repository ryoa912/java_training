/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock;

import java.io.IOException;

import javax.swing.JFrame;

import specialclock.containers.MainWindow;

public class Index {
	public static void main(String[] args) throws IOException, InterruptedException {
		createAndShowWindow();
	}
	private static void createAndShowWindow() {
		JFrame mainWindow = new MainWindow();
	}
}
