package gui.ex14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PropertyDialog extends Dialog implements ActionListener {
	Window f_window;
	GridBagLayout gbl = new GridBagLayout();
	Choice c1;
	Choice c2;
	Choice c3;
	Choice c4;
	Button ok_button;
	Button cancel_button;
	Font f_font;
	Color f_font_color;
	Color f_background_color;

	public void setActionListener(ActionListener al) {
	    ok_button.addActionListener(al);
	    cancel_button.addActionListener(al);
	}
	public PropertyDialog(Frame owner) {
		super(owner, true);

		//初期設定
		setSize(400, 300);				//ダイアログサイズ
		this.setTitle("プロパティ");	//タイトル
		this.setResizable(false);		//リサイズ禁止

		//閉じるボタンの設定
		addWindowListener(new ClosingWindowListener(this));

		GridBagLayout layout = new GridBagLayout();
		Panel p = new Panel();
	    p.setLayout(layout);

	    GridBagConstraints gbc = new GridBagConstraints();

	    Label label1 = new Label("フォント");
	    gbc = addConstraints(0, 0, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(label1, gbc);

	    c1 = new Choice();
	    c1.add("Arial");
	    c1.add("Century");
	    gbc = addConstraints(1, 0, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(c1, gbc);

	    Label label2 = new Label("フォントサイズ");
	    gbc = addConstraints(0, 1, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(label2, gbc);

	    c2 = new Choice();
	    c2.add("36pt");
	    c2.add("18pt");
	    gbc = addConstraints(1, 1, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(c2, gbc);

	    Label label3 = new Label("文字色");
	    gbc = addConstraints(0, 2, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(label3, gbc);

	    c3 = new Choice();
	    c3.add("黒");
	    c3.add("白");
	    c3.add("グレー");
	    gbc = addConstraints(1, 2, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(c3, gbc);

	    Label label4 = new Label("背景色");
	    gbc = addConstraints(0, 3, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(label4, gbc);

	    c4 = new Choice();
	    c4.add("黒");
	    c4.add("白");
	    c4.add("グレー");
	    gbc = addConstraints(1, 3, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(c4, gbc);

	    ok_button = new Button("OK");
	    gbc = addConstraints(0, 4, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(ok_button, gbc);

	    cancel_button = new Button("キャンセル");
	    gbc = addConstraints(1, 4, 1, 1, 1.0d, 1.0d, GridBagConstraints.BASELINE, 0, 0, 0, 0);
	    layout.setConstraints(cancel_button, gbc);

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

	    this.add(p, BorderLayout.CENTER);
	}
	private GridBagConstraints addConstraints(int x, int y, int width, int height,
			double weightx, double weighty, int fill,
			int mergin_top, int mergin_left, int mergin_right, int mergin_bottom) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
	    gbc.gridy = y;
	    gbc.gridwidth = width;
	    gbc.gridheight = height;
	    gbc.weightx = weightx;
	    gbc.weighty = weighty;
	    gbc.fill = fill;
	    gbc.insets = new Insets(mergin_top, mergin_left, mergin_right, mergin_bottom);
		return gbc;
	}
	private String getFontSizeString(int s) {
		if (s == 18) {
			return "18pt";
		} else if (s == 36) {
			return "36pt";
		} else {
			return "内部エラー";
		}
	}
	private String getColorString(Color c) {
		if (c == Color.black) {
			return "黒";
		} else if (c == Color.white) {
			return "白";
		} else if (c == Color.gray) {
			return "グレー";
		} else {
			return "内部エラー";
		}
	}

	public void setProperty(Font font, Color font_color, Color background_color) {
		f_font = font;
		f_font_color = font_color;
		f_background_color = background_color;

		c1.select(f_font.getFamily());
		c2.select(getFontSizeString(f_font.getSize()));
		c3.select(getColorString(font_color));
		c4.select(getColorString(background_color));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "OK":
			this.setVisible(false);
			break;
		case "キャンセル":
			this.setVisible(false);
			break;
		default:
			System.out.println("内部エラー");
			break;
		}
	}
	class ClosingWindowListener extends WindowAdapter {
		Dialog f_frame;
		ClosingWindowListener (Dialog f) {
			f_frame = f;
		}
		public void windowClosing(WindowEvent e) {
			f_frame.setVisible(false);
		}
	}
}
