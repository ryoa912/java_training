package gui.ex12;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuListener extends WindowAdapter implements ActionListener{
	Clock frm;
	private void start() {
		frm = new Clock();
		frm.setSize(400 , 400);
		frm.setVisible(true);
		frm.addWindowListener(this);

		MenuBar mb = new MenuBar();

		//フォント変更メニュー
		Menu fontFamily = mb.add(new Menu("Font Family"));

		MenuItem gothic = fontFamily.add(new MenuItem("Gothic"));
		MenuItem arial = fontFamily.add(new MenuItem("Arial"));
		MenuItem timesNewRoman = fontFamily.add(new MenuItem("Times New Roman"));

		gothic.addActionListener(this);
		arial.addActionListener(this);
		timesNewRoman.addActionListener(this);

		frm.setMenuBar(mb);

		//背景色変更メニュー
		Menu backgroundColor = mb.add(new Menu("Background color"));

		MenuItem rena = backgroundColor.add(new MenuItem("Red"));
		MenuItem yuki = backgroundColor.add(new MenuItem("Blue"));
		MenuItem mimi = backgroundColor.add(new MenuItem("Green"));

		rena.addActionListener(this);
		yuki.addActionListener(this);
		mimi.addActionListener(this);

		frm.setMenuBar(mb);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Gothic") frm.setFont(null);
		if (e.getActionCommand() == "Arial") frm.setFont(null);
		if (e.getActionCommand() == "Times New Roman") frm.setFont(null);
		if (e.getActionCommand() == "Red") frm.setBackground(Color.red);
		if (e.getActionCommand() == "Blue") frm.setBackground(Color.blue);
		if (e.getActionCommand() == "Green") frm.setBackground(Color.green);
	}
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}
	public static void main(String args[]) {
		MenuListener win = new MenuListener();
		win.start();
	}
}
