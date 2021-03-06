package gui.ex14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class MenuClock extends Window implements MouseListener, MouseMotionListener, ActionListener {
	public Dimension dim;		//サイズ
	public Image buf;			//ダブルバッファ用
	public Graphics ct;			//オフスクリーン描画用

	public Font f_font;			//フォント
	public Color f_color;		//文字色
	public Color f_back_color;	//背景色
	public int f_window_x = 100;			//ウィンドウX座標
	public int f_window_y = 100;			//ウィンドウY座標
	public int f_click_position_x = 0;		//クリックX座標
	public int f_click_position_y = 0;		//クリックY座標
	public int f_width = 600;				//幅
	public int f_height = 120;				//高さ

	private PopupMenu pop;	//ポップアップメニュー
	private PropertyDialog pd;	//プロパティダイアログ
	private Preferences prefs;	//Preference

	public static final int RIGHT_CLICK = 1;
	public static final int CENTER_CLICK = 2;
	public static final int LEFT_CLICK = 3;
	public static final String FONT_FAMILY = "font_family";
	public static final String FONT_SIZE = "font_size";
	public static final String FONT_COLOR = "font_color";
	public static final String BACKGROUND_COLOR = "background_color";
	public static final String X_POSITION = "x_position";
	public static final String Y_POSITION = "y_position";

	public MenuClock(Frame owner) {
		super(owner);
		//Prefs
		prefs = Preferences.userRoot().node("ra_app");

		//初期設定
		f_font = this.getFontFamily(prefs.get(FONT_FAMILY, "Arial"), prefs.get(FONT_SIZE, "36pt"));
		f_color = this.getColor(prefs.get(FONT_COLOR, "黒"));
		f_back_color = this.getColor(prefs.get(BACKGROUND_COLOR, "白"));
		f_window_x = prefs.getInt(X_POSITION, 100);
		f_window_y = prefs.getInt(Y_POSITION, 100);
		setSize(600, 120);
		setLocation(f_window_x, f_window_y);

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

		//プロパティダイアログの設定
		pd = new PropertyDialog(owner);
		pd.setActionListener(this);
		pd.addMouseListener(this);

		//---プロパティ---
		MenuItem mi = new MenuItem("プロパティ");
		mi.addActionListener(this);
		pop.add(mi);

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
		//設定の保存
		prefs.putInt(X_POSITION, f_window_x);
		prefs.putInt(Y_POSITION, f_window_y);
		try {
			prefs.flush();
		} catch (BackingStoreException e1) {
			e1.printStackTrace();
		}
		this.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {} //Nothing.

	//ActionListenerのabstract methods
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "プロパティ":
			pd.setProperty(f_font, f_color, f_back_color);
			if (pd != null) pd.setVisible(true);
			break;
		case "終了":
			System.exit(0);
			break;
		case "OK":
			f_font = getFontFamily(pd.c1.getSelectedItem(), pd.c2.getSelectedItem());
			f_color = getColor(pd.c3.getSelectedItem());
			f_back_color = getColor(pd.c4.getSelectedItem());

			//設定の保存
			prefs.put(FONT_FAMILY, pd.c1.getSelectedItem());
			prefs.put(FONT_SIZE, pd.c2.getSelectedItem());
			prefs.put(FONT_COLOR, pd.c3.getSelectedItem());
			prefs.put(BACKGROUND_COLOR, pd.c4.getSelectedItem());
			try {
				prefs.flush();
			} catch (BackingStoreException e1) {
				e1.printStackTrace();
			}
			pd.setVisible(false);
			break;
		case "キャンセル":
			pd.setVisible(false);
			break;
		default:
			System.out.println("内部エラー");
			break;
		}
		this.repaint();
	}
	private Font getFontFamily(String family, String size_str) {
		if (size_str.equals("36pt"))
			return new Font(family, Font.PLAIN, 36);
		else if (size_str.equals("18pt"))
			return new Font(family, Font.PLAIN, 18);
		else
			return null;
	}
	private Color getColor(String s) {
		if (s.equals("黒")) {
			return Color.black;
		} else if (s.equals("白")) {
			return Color.white;
		} else if (s.equals("グレー")) {
			return Color.gray;
		} else {
			return null;
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public static void main(String[] args) {
		//Frameインスタンスの生成
		Frame f = new Frame();

		//MenuClockインスタンスの生成
		MenuClock clock = new MenuClock(f);

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
