package gui.ex12;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MenuClock extends Frame implements ActionListener{
    public static void main(String[] args) {
    	MenuClock clock = new MenuClock();

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
    MenuClock() {
		setTitle("MenuClock");
		setSize(600, 250);
		setLayout(new FlowLayout());
		addWindowListener(new ClosingWindowListener());
		show();

		//メニューバーの設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		//設定
		Menu settings = new Menu("設定");
		settings.addActionListener(this);
		menuBar.add(settings);
		//テーマ設定
		Menu theme = new Menu("テーマ");
		theme.addActionListener(this);
		settings.add(theme);
		MenuItem themeWhite = new MenuItem("明");
		theme.add(themeWhite);
		MenuItem themeBlack = new MenuItem("暗");
		theme.add(themeBlack);

		//文字サイズ設定
		Menu fontSize = new Menu("文字サイズ");
		fontSize.addActionListener(this);
		settings.add(fontSize);
		MenuItem fontSizeLarge = new MenuItem("大");
		fontSize.add(fontSizeLarge);
		MenuItem fontSizeSmall = new MenuItem("小");
		fontSize.add(fontSizeSmall);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public void windowClosing(WindowEvent e) {
		System.exit(1);
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
}
