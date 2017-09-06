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
		//VoiceroidPlayer vp = new VoiceroidPlayer();
		//vp.setAndPlay("おはようございます。弦巻マキです。よろしくお願いします。");
	}
	private static void createAndShowWindow() {
		JFrame mainWindow = new MainWindow();
	}
}
