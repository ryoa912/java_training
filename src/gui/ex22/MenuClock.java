/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package gui.ex22;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class MenuClock extends JFrame {
	private int frameWidth = 400;
	private int frameHeight = 150;

	private Font font1 = new Font("Arial", Font.PLAIN, 36);
	private Color backgroundColor = Color.WHITE;
	private Color fontColor = Color.BLACK;

	ActionHandler actionHandler = new ActionHandler();

	MenuClock() {
		setTitle("MenuClock");
		setSize(frameWidth, frameHeight);
		setLayout(new FlowLayout());
		setVisible(true);

		//メニューバーの設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		//設定
		Menu settings = new Menu("設定");
		settings.addActionListener(actionHandler);
		menuBar.add(settings);

		//フォント設定
		Menu fontFamily = new Menu("フォント");
		fontFamily.addActionListener(actionHandler);
		settings.add(fontFamily);
		MenuItem fontFamilyArial = new MenuItem("Arial");
		fontFamily.add(fontFamilyArial);
		MenuItem fontFamilyCentury = new MenuItem("Century");
		fontFamily.add(fontFamilyCentury);

		//文字サイズ設定
		Menu fontSize = new Menu("文字サイズ");
		fontSize.addActionListener(actionHandler);
		settings.add(fontSize);
		MenuItem fontSizeSmall = new MenuItem("18pt");
		fontSize.add(fontSizeSmall);
		MenuItem fontSizeLarge = new MenuItem("36pt");
		fontSize.add(fontSizeLarge);
		MenuItem fontSizeLargest = new MenuItem("72pt");
		fontSize.add(fontSizeLargest);

		//文字色設定
		Menu fontColor = new Menu("文字色");
		fontColor.addActionListener(actionHandler);
		settings.add(fontColor);
		MenuItem fontColorBlack = new MenuItem("黒");
		fontColor.add(fontColorBlack);
		MenuItem fontColorWhite = new MenuItem("白");
		fontColor.add(fontColorWhite);

		//背景色設定
		Menu theme = new Menu("	背景色");
		theme.addActionListener(actionHandler);
		settings.add(theme);
		MenuItem themeWhite = new MenuItem("白");
		theme.add(themeWhite);
		MenuItem themeBlack = new MenuItem("黒");
		theme.add(themeBlack);

		//setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			Menu obj = (Menu) e.getSource();
			switch (e.getActionCommand()) {
			case "Arial":
				font1 = new Font("Arial", font1.getStyle(), font1.getSize());
				break;
			case "Century":
				font1 = new Font("Century", font1.getStyle(), font1.getSize());
				break;
			case "白":
				if (obj.getLabel() == "文字色") {
					fontColor = Color.white;
				} else {
					backgroundColor = Color.white;
				}
				break;
			case "黒":
				if (obj.getLabel() == "文字色") {
					fontColor = Color.black;
				} else {
					backgroundColor = Color.black;
				}
				break;
			case "18pt":
				font1 = new Font(font1.getFamily(), font1.getStyle(), 18);
				break;
			case "36pt":
				font1 = new Font(font1.getFamily(), font1.getStyle(), 36);
				break;
			case"72pt":
				font1 = new Font(font1.getFamily(), font1.getStyle(), 72);
				break;
			default:
				System.out.println("内部エラー");
				break;
			}
			repaint();
		}
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setFont(font1);
		g2.setColor(fontColor);
		g2.setBackground(backgroundColor);
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());

		//g.drawString(getDate() + "   " + getTime(),30,100);
		drawStringCenter(g, getDate() + "   " + getTime());
	}

	public void drawStringCenter(Graphics g,String text){
		FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, g).getBounds();
		Dimension d = getSize();
		int x=d.width/2-rectText.width/2;
		int y=d.height/2+fm.getAscent()+fm.getDescent()+fm.getLeading();

        g.drawString(text, x, y);
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
}
