package gui.ex12;

import java.awt.Color;
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


public class Clock extends Frame {
	Clock() {
        super("Clock");
        setSize(600, 250);
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

class MenuListener extends WindowAdapter implements ActionListener {
	Clock frm;
	private void start() {
		frm = new Clock();
		frm.setSize(400 , 400);
		frm.setVisible(true);
		frm.addWindowListener(this);

		//フォント変更メニュー
		MenuBar mb = new MenuBar();
		Menu fontFamily = mb.add(new Menu("Font Family"));
		MenuItem gothic = fontFamily.add(new MenuItem("Gothic"));
		MenuItem arial = fontFamily.add(new MenuItem("Arial"));
		MenuItem timesNewRoman = fontFamily.add(new MenuItem("Times New Roman"));
		gothic.addActionListener(this);
		arial.addActionListener(this);
		timesNewRoman.addActionListener(this);
		frm.setMenuBar(mb);

		//背景色変更メニュー
		Menu kitty = mb.add(new Menu("Background color"));

		MenuItem rena = kitty.add(new MenuItem("Red"));
		MenuItem yuki = kitty.add(new MenuItem("Blue"));
		MenuItem mimi = kitty.add(new MenuItem("Green"));

		rena.addActionListener(this);
		yuki.addActionListener(this);
		mimi.addActionListener(this);

		frm.setMenuBar(mb);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Red") frm.setBackground(Color.red);
		if (e.getActionCommand() == "Blue") frm.setBackground(Color.blue);
		if (e.getActionCommand() == "Green") frm.setBackground(Color.green);
	}
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}
	public static void main(String args[]) {
		MenuListener win = new MenuListener();
		win.start();
	}
}
