/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package gui.ex21;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public final class DigitalClock extends JFrame{
	private int frameWidth = 400;
	private int frameHeight = 150;
	private Color backgroundColor = Color.WHITE;
	private Font font1 = new Font("Arial", Font.PLAIN, 36);

	DigitalClock() {
		this.setTitle("デジタル時計");
		this.setSize(frameWidth, frameHeight);
		this.setResizable(false);
        addWindowListener(new ClosingWindowListener());
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;

	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setFont(font1);

	    g2.setBackground(backgroundColor);
	    g2.clearRect(0, 0, this.getWidth(), this.getHeight());

        g.drawString(getDate() + "   " + getTime(),30,100);
   }

	public static void main(String[] args) {
		JFrame obj = new DigitalClock();
		obj.setVisible(true);
		TimerTask task = new TimerTask() {
            public void run() {
            	Date date = new Date();
                System.out.println(date.toString());
                obj.repaint();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000L, 1000L);
	}

	private String getTime() {
		Date date = new Date();
		return date.toString().substring(11, 19);
	}

	private String getDate() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("y/M/d");
        return sdf.format(cal.getTime());
	}
	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
