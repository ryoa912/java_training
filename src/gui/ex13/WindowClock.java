package gui.ex13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class WindowClock extends Window implements MouseListener, MouseMotionListener, ActionListener{
	public Dimension dim;		//サイズ
	public Image buf;			//ダブルバッファ用
	public Graphics ct;			//オフスクリーン描画用

	public Font f_font;			//フォント
	public Color f_color = Color.black;		//文字色
	public Color f_back_color = Color.white;	//背景色
	public int f_window_x = 100;			//ウィンドウX座標
	public int f_window_y = 100;			//ウィンドウY座標
	public int f_click_position_x = 0;		//クリックX座標
	public int f_click_position_y = 0;		//クリックY座標
	public int f_width = 600;				//幅
	public int f_height = 120;				//高さ

	PopupMenu pop;	//ポップアップメニュー

	public static final int RIGHT_CLICK = 1;
	public static final int CENTER_CLICK = 2;
	public static final int LEFT_CLICK = 3;

	public WindowClock(Frame owner) {
		super(owner);

		//初期設定
		setSize(600, 120);
		setLocation(f_window_x, f_window_y);
		f_font = new Font("Arial", Font.PLAIN, 36);

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
		mi = new MenuItem("36pt");
		m.add(mi);
		mi = new MenuItem("18pt");
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

	public void paint(Graphics g){
		//ダブルバッファ不能の場合は抜ける
		if (buf == null) return;

		//描画位置の指定
		setBounds(f_window_x, f_window_y, f_width, f_height);

		//オフスクリーンの描画領域を取得
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
		ct.drawString(date.toString(),50,75);

		//オフスクリーンの中身をオンスクリーンに描画する
		g.drawImage(buf , 0 , 0 ,this);
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
			this.f_font = new Font("Arial", f_font.getStyle(), f_font.getSize());
			break;
		case "Century":
			this.f_font = new Font("Century", f_font.getStyle(), f_font.getSize());
			break;
		case "白":
			if (obj.getLabel() == "文字色") {
				f_color = Color.white;
			} else {
				f_back_color = Color.white;
			}
			break;
		case "黒":
			if (obj.getLabel() == "文字色") {
				f_color = Color.black;
			} else {
				f_back_color = Color.black;
			}
			break;
		case "グレー":
			if (obj.getLabel() == "文字色") {
				f_color = Color.gray;
			} else {
				f_back_color = Color.gray;
			}
			break;
		case "36pt":
			this.f_width = 600;
			this.f_height = 120;
	    	this.f_font = new Font(f_font.getFamily(), f_font.getStyle(), 36);
			break;
		case "18pt":
			this.f_width = 350;
			this.f_height = 120;
	    	this.f_font = new Font(f_font.getFamily(), f_font.getStyle(), 18);
			break;
		case "終了":
			System.exit(0);
			break;
		default:
			System.out.println("内部エラー");
			break;
		}
		this.repaint();
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
