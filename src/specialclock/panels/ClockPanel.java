/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import specialclock.components.MyPanel;

public class ClockPanel extends MyPanel {
	private int width = 400;
	private int height = 150;
	public Dimension dim;		//サイズ
	public Image buf;			//ダブルバッファ用
	public Graphics ct;			//オフスクリーン描画用
	public Font font = new Font("Arial", Font.PLAIN, 36);	//フォント
	public Color color = Color.BLACK;		//文字色
	public Color back_color = Color.WHITE;	//背景色

	public ClockPanel() {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.white);
		//ダブルバッファ用のバッファ作成
		dim = new Dimension(width, height);
		buf = createImage(dim.width, dim.height);
	}
	public void paint(Graphics g){
		g.setColor(back_color);
	    g.fillRect(0, 0, width, height);

	    g.setColor(color);
	    g.setFont(font);
	    drawStringCenter(g, getDate() + "   " + getTime(), width/2, height/2);
/*
		//ダブルバッファ不能の場合は抜ける
		if (buf == null) return;

		//描画位置の指定
		setBounds(0, 0, width, height);

		//オフスクリーンの描画領域を取得
		if (ct == null) ct = buf.getGraphics();

		//アンチエイリアス機能ON
		Graphics2D ct2 = (Graphics2D)ct;
		ct2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		//オフスクリーンに描画
		ct.setColor(back_color);
		ct.fillRect(0 , 0 , dim.width , dim.height);

		ct.setColor(color);
		ct.setFont(font);

		//ct.drawString(getDate() + "   " + getTime(), 50, 75);

		drawStringCenter(ct, getDate() + "   " + getTime(), width/2, height/2);

		//オフスクリーンの中身をオンスクリーンに描画する
		g.drawImage(buf , 0 , 0 ,this);
		*/
	}
	public static void drawStringCenter(Graphics g,String text,int x,int y){
		FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, g).getBounds();
		x=x-rectText.width/2;
		y=y-rectText.height/2+fm.getMaxAscent();

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

}
