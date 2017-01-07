package gui.ex13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class WindowClock extends Window {

	public WindowClock(Frame owner) {
		super(owner);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Dimension dim;
	public Image buf;
	public Graphics ct;

	public Font f_font;
	public Color f_color;
	public Color f_back_color;

	public static void main(String[] args) {
		//Frameインスタンスの生成
		Frame f = new Frame();

		//WindowClockインスタンスの生成
		WindowClock clock = new WindowClock(f);
		clock.setSize(600, 150);
		clock.setVisible(true);


		//初期フォントの指定
		clock.f_font = new Font("Arial", Font.PLAIN, 36);

		//タイマタスクの生成
		TimerTask task = new TimerTask() {
			public void run() {
				Date date = new Date();
			    System.out.println(date.toString());
			    clock.repaint();
			}
		};
        Timer timer = new Timer();
		timer.schedule(task, 1000L, 1000L);
    }

	public void paint(Graphics g){
		if (ct == null) ct = buf.getGraphics();

		//アンチエイリアス機能ON
		Graphics2D ct2 = (Graphics2D)ct;
		ct2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		//オフスクリーンに描画
		ct.setColor(f_back_color);
		ct.fillRect(0 , 0 , dim.width , dim.height);

		ct.setColor(f_color);
		ct.setFont(f_font);
		Date date = new Date();
		ct.drawString(date.toString(),50,115);

		//オフスクリーンの中身をオンスクリーンに描画する
		g.drawImage(buf , 0 , 0 ,this);
	}

	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}
