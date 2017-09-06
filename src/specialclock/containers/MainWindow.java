/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.containers;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import specialclock.components.MyWindow;
import specialclock.panels.ClockPanel;
import specialclock.panels.SpeechPanel;

public class MainWindow extends MyWindow {
	public int f_window_x = 100;			//ウィンドウX座標
	public int f_window_y = 100;			//ウィンドウY座標
	private Font font = new Font("Arial", Font.PLAIN, 36);
	private Color backgroundColor = Color.WHITE;
	private Color fontColor = Color.BLACK;

	public MainWindow() {
		//TODO 設定ファイルを読み込めるようにする

		setLocation(f_window_x, f_window_y);

		//時計パネル
		JPanel clockPanel = new ClockPanel();
		addGrid(clockPanel, 1, 1);

		//発話パネル
		JPanel speechPanel = new SpeechPanel();
		addGrid(speechPanel, 1, 2);

		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Special Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//タイマタスクの生成
		TimerTask task = new TimerTask() {
			public void run() {
				Date date = new Date();
			    System.out.println(date.toString());
			    clockPanel.repaint();
			}
		};
        Timer timer = new Timer();
		timer.schedule(task, 1000L, 1000L);
	}
}
