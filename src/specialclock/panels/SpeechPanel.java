/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import specialclock.components.MyPanel;
import specialclock.components.SoundFilePlayer;

public class SpeechPanel extends MyPanel {
	private int width = 400;
	private int height = 150;

	private final JButton playButton;

	public SpeechPanel() {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.green);

		//再生ボタン
		playButton = new JButton("再生");
		playButton.addActionListener(new ButtonActionListener());
		addGrid(playButton);
	}

	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.toString());
			SoundFilePlayer.play("src/specialclock/voice/sample_voice.wav");
		}
	}
}
