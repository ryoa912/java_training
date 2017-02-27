package gui.ex14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PropertyDialog extends Dialog implements ActionListener {
	GridBagLayout gbl = new GridBagLayout();

	public PropertyDialog(Frame owner) {
		super(owner, true);
		//初期設定
		setSize(600, 600);				//ダイアログサイズ
		this.setTitle("プロパティ");	//タイトル
		this.setResizable(false);		//リサイズ禁止

		//閉じるボタンの設定
		addWindowListener(new ClosingWindowListener(this));

		GridBagLayout layout = new GridBagLayout();
		Panel p = new Panel();
	    p.setLayout(layout);

	    GridBagConstraints gbc = new GridBagConstraints();

	    Button button1 = new Button("OK");


	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 2;
	    gbc.weightx = 1.0d;
	    gbc.weighty = 1.0d;
	    gbc.fill = GridBagConstraints.BASELINE;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    layout.setConstraints(button1, gbc);
	    button1.addActionListener(this);

	    Button button2 = new Button("Cancel");

	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.gridheight = 1;
	    gbc.weightx = 1.0d;
	    gbc.weighty = 1.0d;
	    gbc.fill = GridBagConstraints.SOUTHEAST;
	    layout.setConstraints(button2, gbc);
	    button2.addActionListener(this);

	    p.add(button1);
	    p.add(button2);

	    this.add(p, BorderLayout.CENTER);
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
