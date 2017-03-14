/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MainWindow extends JFrame implements ActionListener{
	Choice c1;
	Choice c2;
	Choice c3;
	TextField c4;
	Button ok_button;
	Button cancel_button;


	public static final int RIGHT_CLICK = 1;
	public static final int CENTER_CLICK = 2;
	public static final int LEFT_CLICK = 3;

	MainWindow() {
		//ウィンドウの初期設定
		setTitle("Interpreter");
		setSize(1000, 600);
		setResizable(false);
		setVisible(true);

		//閉じるボタンの設定
		addWindowListener(new ClosingWindowListener());

		//要素の配置のためにGBLを使用
		GridBagLayout layout = new GridBagLayout();
		JPanel p = new JPanel();
	    p.setLayout(layout);

	    GridBagConstraints gbc = new GridBagConstraints();

	    Label label1 = new Label("フォント");
	    gbc = addConstraints(0, 0, 1, 1, 1.0d, 1.0d, GridBagConstraints.NONE, 0, 50, 0, 25);
	    gbc.anchor = GridBagConstraints.EAST;
	    layout.setConstraints(label1, gbc);

	    c1 = new Choice();
	    c1.add("Arial");
	    c1.add("Century");
	    gbc = addConstraints(1, 0, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(c1, gbc);

	    Label label2 = new Label("フォントサイズ");
	    gbc = addConstraints(0, 1, 1, 1, 1.0d, 1.0d, GridBagConstraints.NONE, 0, 50, 0, 25);
	    gbc.anchor = GridBagConstraints.EAST;
	    layout.setConstraints(label2, gbc);

	    c2 = new Choice();
	    c2.add("18");
	    c2.add("36");
	    c2.add("72");
	    gbc = addConstraints(1, 1, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(c2, gbc);

	    Label label3 = new Label("文字色");
	    gbc = addConstraints(0, 2, 1, 1, 1.0d, 1.0d, GridBagConstraints.NONE, 0, 50, 0, 25);
	    gbc.anchor = GridBagConstraints.EAST;
	    layout.setConstraints(label3, gbc);

	    c3 = new Choice();
	    c3.add("黒");
	    c3.add("白");
	    c3.add("グレー");
	    gbc = addConstraints(1, 2, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(c3, gbc);

	    Label label4 = new Label("背景色");
	    gbc = addConstraints(0, 3, 1, 1, 1.0d, 1.0d, GridBagConstraints.NONE, 0, 50, 0, 25);
	    gbc.anchor = GridBagConstraints.EAST;
	    layout.setConstraints(label4, gbc);

	    c4 = new TextField();
	    gbc = addConstraints(1, 3, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(c4, gbc);

	    ok_button = new Button("OK");
	    gbc = addConstraints(0, 4, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 50, 0, 25);
	    layout.setConstraints(ok_button, gbc);

	    cancel_button = new Button("キャンセル");
	    gbc = addConstraints(1, 4, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(cancel_button, gbc);

	    /* JListの初期データ */
	    String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
	    @SuppressWarnings("unchecked")
		JList list = new JList(initData);
	    JScrollPane sp = new JScrollPane();
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(200, 80));
	    gbc = addConstraints(0, 5, 1, 1, 1.0d, 1.0d, GridBagConstraints.HORIZONTAL, 0, 25, 0, 50);
	    layout.setConstraints(sp, gbc);

	    p.add(label1);
	    p.add(c1);
	    p.add(label2);
	    p.add(c2);
	    p.add(label3);
	    p.add(c3);
	    p.add(label4);
	    p.add(c4);
	    p.add(ok_button);
	    p.add(cancel_button);
	    p.add(sp);

	    this.add(p, BorderLayout.CENTER);
	}
	private GridBagConstraints addConstraints(int x, int y, int width, int height,
			double weightx, double weighty, int fill,
			int mergin_top, int mergin_left, int mergin_bottom, int mergin_right) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
	    gbc.gridy = y;
	    gbc.gridwidth = width;
	    gbc.gridheight = height;
	    gbc.weightx = weightx;
	    gbc.weighty = weighty;
	    gbc.fill = fill;
	    gbc.insets = new Insets(mergin_top, mergin_left, mergin_bottom, mergin_right);
		return gbc;
	}

	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	//ActionListenerのabstract methods
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
