/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import specialclock.components.Clock;
import specialclock.components.MyPanel;

public class ClockPanel extends MyPanel {
	private int width = 400;
	private int height = 150;
	public Graphics ct;			//オフスクリーン描画用
	public Font font = new Font("Arial", Font.PLAIN, 36);	//フォント
	public Color color = Color.BLACK;		//文字色
	public Color back_color = Color.WHITE;	//背景色

	public ClockPanel() {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.white);
	}
	public void paint(Graphics g){
		g.setColor(back_color);
	    g.fillRect(0, 0, width, height);
	    g.setColor(color);
	    g.setFont(font);
	    drawStringCenter(g, Clock.getDate() + "   " + Clock.getTime(), width/2, height/2);
	}
	public static void drawStringCenter(Graphics g,String text,int x,int y){
		FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, g).getBounds();
		x=x-rectText.width/2;
		y=y-rectText.height/2+fm.getMaxAscent();

        g.drawString(text, x, y);
	}
}
