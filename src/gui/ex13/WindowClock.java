package gui.ex13;

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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class WindowClock extends Window implements MouseListener{
	public Dimension dim;		//サイズ
	public Image buf;			//ダブルバッファ用
	public Graphics ct;			//オフスクリーン描画用

	public Font f_font;			//フォント
	public Color f_color;		//文字色
	public Color f_back_color;	//背景色

	PopupMenu pop;	//ポップアップメニュー

	public WindowClock(Frame owner) {
		super(owner);

		//初期設定
		setSize(600, 150);
		f_font = new Font("Arial", Font.PLAIN, 36);
		f_color = Color.black;
		f_back_color = Color.white;

		//リスナの登録
		addMouseListener(this);

		//可視化（バッファ作成前に可視化する必要あり）
		setVisible(true);

		//ダブルバッファ用のバッファ作成
		dim = getSize();
		buf = createImage(dim.width, dim.height);

		//ポップアップメニューの設定
		pop = new PopupMenu("popup menu");
		add(pop);

		MenuItem mi;
		mi = new MenuItem("Cut");
        pop.add(mi);

        mi = new MenuItem("Copy");
        pop.add(mi);

        pop.addSeparator();

        mi = new MenuItem("Paste");
        pop.add(mi);
	}

	public void paint(Graphics g){
		//ダブルバッファ不能の場合は抜ける
		if (buf == null) return;

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
		ct.drawString(date.toString(),50,115);

		//オフスクリーンの中身をオンスクリーンに描画する
		g.drawImage(buf , 0 , 0 ,this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.exit(0);
		if (pop != null) pop.show(this , e.getX() , e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

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
