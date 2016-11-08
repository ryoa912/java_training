package gui.ex11;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Frame {
	Clock() {
        super("Clock");
        setSize(300, 250);
        addWindowListener(new ClosingWindowListener());
    }

	public void paint(Graphics g){
		Date date = new Date();

        //(50,100)をベースラインの先頭にして文字列を描く
        g.drawString(date.toString(),50,100);

        //左上の位置が(10,50)で縦150,横120ピクセルの矩形を描く
        g.drawRect(10,50,150,120);

        //左上の位置が(100,100)で縦100,横100の矩形に内接する円を描く
        g.drawOval(100,100,100,100);

        System.out.println("paint done.");

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