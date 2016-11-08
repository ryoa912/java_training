package gui.ex11;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest extends Frame {

	FrameTest() {
        super("FrameTest");
        setSize(300, 250);
        addWindowListener(new ClosingWindowListener());
    }

    public void paint(Graphics g){
       //(50,100)をベースラインの先頭にして文字列を描く
       g.drawString("矩形と円を描く",50,100);

       //左上の位置が(10,50)で縦150,横120ピクセルの矩形を描く
       g.drawRect(10,50,150,120);

       //左上の位置が(100,100)で縦100,横100の矩形に内接する円を描く
       g.drawOval(100,100,100,100);
   }

	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args){
		FrameTest obj = new FrameTest();
		obj.setVisible(true);
	}
}
