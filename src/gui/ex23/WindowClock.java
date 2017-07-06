/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package gui.ex23;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JWindow;

public class WindowClock extends JWindow implements MouseListener, MouseMotionListener, ActionListener {
	public Dimension dim;		//サイズ
	public Image buf;			//ダブルバッファ用
	public Graphics ct;			//オフスクリーン描画用

	private Font font1 = new Font("Arial", Font.PLAIN, 36);
	private Color backgroundColor = Color.WHITE;
	private Color fontColor = Color.BLACK;

	public int f_window_x = 100;			//ウィンドウX座標
	public int f_window_y = 100;			//ウィンドウY座標
	public int f_click_position_x = 0;		//クリックX座標
	public int f_click_position_y = 0;		//クリックY座標
	private int frameWidth = 400;
	private int frameHeight = 100;

	PopupMenu pop;	//ポップアップメニュー

	public static final int RIGHT_CLICK = 1;
	public static final int CENTER_CLICK = 2;
	public static final int LEFT_CLICK = 3;

	public WindowClock(Frame owner) {
		super(owner);

		//初期設定
		setSize(400, 100);
		setLocation(f_window_x, f_window_y);
		font1 = new Font("Arial", Font.PLAIN, 36);

		//リスナの登録
		addMouseListener(this);
		addMouseMotionListener(this);

		//可視化（バッファ作成前に可視化する必要あり）
		setVisible(true);

		//ダブルバッファ用のバッファ作成
		dim = getSize();
		buf = createImage(dim.width, dim.height);

		//ポップアップメニューの設定
		pop = new PopupMenu("popup menu");
		pop.addActionListener(this);
		add(pop);

		//---フォント---
		Menu m = new Menu("フォント");
		m.addActionListener(this);
		pop.add(m);
		MenuItem mi;
		mi = new MenuItem("Arial");
		m.add(mi);
		mi = new MenuItem("Century");
		m.add(mi);

		//---文字サイズ---
		m = new Menu("文字サイズ");
		m.addActionListener(this);
		pop.add(m);
		mi = new MenuItem("18pt");
		m.add(mi);
		mi = new MenuItem("36pt");
		m.add(mi);
		mi = new MenuItem("72pt");
		m.add(mi);

		//---文字色---
		m = new Menu("文字色");
		m.addActionListener(this);
		pop.add(m);
		mi = new MenuItem("黒");
		m.add(mi);
		mi = new MenuItem("白");
		m.add(mi);
		mi = new MenuItem("グレー");
		m.add(mi);

		//---背景色---
		m = new Menu("背景色");
		m.addActionListener(this);
		pop.add(m);
		mi = new MenuItem("白");
		m.add(mi);
		mi = new MenuItem("黒");
		m.add(mi);
		mi = new MenuItem("グレー");
		m.add(mi);

        pop.addSeparator();

        mi = new MenuItem("終了");
        pop.add(mi);
	}

	public void paint(Graphics g) {
		setBounds(f_window_x, f_window_y, frameWidth, frameHeight);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setFont(font1);
		g2.setColor(fontColor);
		g2.setBackground(backgroundColor);
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());

		drawStringCenter(g, getDate() + "   " + getTime());
	}

	public void drawStringCenter(Graphics g,String text){
		FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, g).getBounds();
		Dimension d = getSize();
		int x=d.width/2-rectText.width/2;
		int y=d.height/2+fm.getAscent()/2+fm.getDescent()+fm.getLeading();

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

	//MouseListenerのabstract methods
	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case RIGHT_CLICK:
			System.out.println("Right pressed.");
			f_click_position_x = e.getX();
			f_click_position_y = e.getY();
			break;
		case CENTER_CLICK:
			System.out.println("System exit.");
			System.exit(0);
			break;
		case LEFT_CLICK:
			System.out.println("Left pressed.");
			if (pop != null) pop.show(this , e.getX() , e.getY());
			break;
		default:
			System.out.println(e.getButton());
			break;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {} //Nothing.
	@Override
	public void mouseClicked(MouseEvent e) {} //Nothing.
	@Override
	public void mouseEntered(MouseEvent e) {} //Nothing.
	@Override
	public void mouseExited(MouseEvent e) {} //Nothing.

	//MouseMotionListenerのabstract methods
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Right dragged."+ e.getX()+"."+e.getY());
		f_window_x = e.getXOnScreen() - f_click_position_x;
		f_window_y = e.getYOnScreen() - f_click_position_y;
		this.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {} //Nothing.

	//ActionListenerのabstract methods
	@Override
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
		case "グレー":
			if (obj.getLabel() == "文字色") {
				fontColor = Color.gray;
			} else {
				backgroundColor = Color.gray;
			}
			break;
		case "18pt":
			font1 = new Font(font1.getFamily(), font1.getStyle(), 18);
			frameWidth = 400;
			frameHeight = 80;
			break;
		case "36pt":
			font1 = new Font(font1.getFamily(), font1.getStyle(), 36);
			frameWidth = 400;
			frameHeight = 100;
			break;
		case"72pt":
			font1 = new Font(font1.getFamily(), font1.getStyle(), 72);
			frameWidth = 800;
			frameHeight = 300;
			break;
		case "終了":
			System.exit(0);
			break;
		default:
			System.out.println("内部エラー");
			break;
		}
		repaint();
	}

	public void update(Graphics g)
	{
		paint(g);
	}

	public static void main(String[] args) {
		//Frameインスタンスの生成
		Frame f = new Frame();

		//WindowClockインスタンスの生成
		WindowClock clock = new WindowClock(f);

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
}
