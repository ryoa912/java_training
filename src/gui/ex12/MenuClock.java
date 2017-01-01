package gui.ex12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	public Dimension dim;
	public Image buf;
	public Graphics ct;

	public Font f_font;
	public Color f_color;
	public Color f_back_color;
	public static void main(String[] args) {
    	MenuClock clock = new MenuClock();
    	clock.f_font = new Font("Arial", Font.PLAIN, 36);
    	clock.setResizable(false);

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
		setSize(600, 150);
		setLayout(new FlowLayout());
		addWindowListener(new ClosingWindowListener());
		setVisible(true);

		//ダブルバッファ用のバッファ作成
		dim = getSize();
		buf = createImage(dim.width , dim.height);

		//初期設定
		f_color = Color.black;
		f_back_color = Color.white;

		//メニューバーの設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		//設定
		Menu settings = new Menu("設定");
		settings.addActionListener(this);
		menuBar.add(settings);

		//フォント設定
		Menu fontFamily = new Menu("フォント");
		fontFamily.addActionListener(this);
		settings.add(fontFamily);
		MenuItem fontFamilyArial = new MenuItem("Arial");
		fontFamily.add(fontFamilyArial);
		MenuItem fontFamilyCentury = new MenuItem("Century");
		fontFamily.add(fontFamilyCentury);

		//文字サイズ設定
		Menu fontSize = new Menu("文字サイズ");
		fontSize.addActionListener(this);
		settings.add(fontSize);
		MenuItem fontSizeLarge = new MenuItem("36pt");
		fontSize.add(fontSizeLarge);
		MenuItem fontSizeSmall = new MenuItem("18pt");
		fontSize.add(fontSizeSmall);

		//文字色設定
		Menu fontColor = new Menu("文字色");
		fontColor.addActionListener(this);
		settings.add(fontColor);
		MenuItem fontColorBlack = new MenuItem("黒");
		fontColor.add(fontColorBlack);
		MenuItem fontColorWhite = new MenuItem("白");
		fontColor.add(fontColorWhite);

		//背景色設定
		Menu theme = new Menu("	背景色");
		theme.addActionListener(this);
		settings.add(theme);
		MenuItem themeWhite = new MenuItem("白");
		theme.add(themeWhite);
		MenuItem themeBlack = new MenuItem("黒");
		theme.add(themeBlack);
    }
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
				f_back_color = Color.black;
			} else {
				f_back_color = Color.white;
				f_color = Color.black;
			}
			break;
		case "黒":
			if (obj.getLabel() == "文字色") {
				f_back_color = Color.white;
				f_color = Color.black;
			} else {
				f_color = Color.white;
				f_back_color = Color.black;
			}
			break;
		case "36pt":
			this.setSize(600, 150);
	    	this.f_font = new Font(f_font.getFamily(), f_font.getStyle(), 36);
			break;
		case "18pt":
			this.setSize(350, 150);
	    	this.f_font = new Font(f_font.getFamily(), f_font.getStyle(), 18);
			break;
		default:
			System.out.println("内部エラー");
			break;
		}
		this.repaint();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(1);
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
