package gui.ex11;

import java.awt.Frame;

public class FrameTest extends Frame {

	FrameTest() {
        super("FrameTest");
        setSize(200, 100);
    }


	public static void main(String[] args){
		FrameTest obj = new FrameTest();
		obj.setVisible(true);
	}
}
