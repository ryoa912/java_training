package gui.ex11;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Frame {
	Clock() {
        super("Clock");
        setSize(600, 250);
        addWindowListener(new ClosingWindowListener());
    }

	public void paint(Graphics g){
		Date date = new Date();

		Graphics2D g2 = (Graphics2D)g;

	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		Font font1 = new Font("Arial", Font.PLAIN, 36);
	    g2.setFont(font1);

        //(50,100)をベースラインの先頭にして文字列を描く
        g.drawString(date.toString(),30,100);
   }

	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	static public void main(String[] args) {
		Clock obj = new Clock();
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
}