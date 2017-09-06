/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import specialclock.containers.MainWindow;

public class Index {
	public static void main(String[] args) throws IOException {
		createAndShowWindow();

		Runtime rt = Runtime.getRuntime();

		String path = new File(".").getAbsoluteFile().getParent();
		System.out.println(path);

		String[] str = new String[]{"src\\specialclock\\lib\\echoseika.exe",
				"-cv", "TAMMY_EX", "おはようございます。涼しい朝ですね。"};

		rt.exec(str);
	}
	private static void createAndShowWindow() {
		JFrame mainWindow = new MainWindow();
	}
}
