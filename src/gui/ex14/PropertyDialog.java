package gui.ex14;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PropertyDialog extends Dialog implements ActionListener {
	GridBagLayout gbl = new GridBagLayout();

	public PropertyDialog(Frame owner) {
		super(owner, true);
		//初期設定
		setSize(600, 120);				//ダイアログサイズ
		this.setTitle("プロパティ");	//タイトル
		this.setResizable(false);		//リサイズ禁止

		//閉じるボタンの設定
		addWindowListener(new ClosingWindowListener(this));

		Button but = (Button)this.add(new Button("OK"));
		but.addActionListener(this);
		but = (Button)this.add(new Button("キャンセル"));
		but.addActionListener(this);

		setLayout(gbl);
		Button b1 = new Button();
		addButton(b1, 0, 0, 1, 3);
	}

	private void addButton(Button b, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(b, gbc);
        add(b);
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
