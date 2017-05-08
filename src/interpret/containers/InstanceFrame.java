/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.BorderLayout;
import java.lang.reflect.Constructor;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import interpret.components.MyButton;
import interpret.components.MyList;
import interpret.components.MyTextField;
import interpret.containers.MainFrame.ActionHandler;
import interpret.containers.MainFrame.ListSelectionHandler;

public class InstanceFrame extends JFrame {
	MyTextField classNameInputTextField;	//クラス名入力テキストフィールド
	MyButton searchButton;					//クラス候補検索ボタン

	MyList constructorList;					//コンストラクタ一覧
	DefaultListModel constructorListModel;
	Constructor[] constructors;		//コンストラクタデータ

	public InstanceFrame(ActionHandler actionHandler, ListSelectionHandler listHander) {
		super();
		setTitle("Create instance");
		setResizable(false);

		//---第1パネル---
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        classNameInputTextField = new MyTextField();

        searchButton = new MyButton("完了");
        searchButton.addActionListener(actionHandler);

        constructorListModel = new DefaultListModel();
        constructorList = new MyList(constructorListModel);
        constructorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane constructorListScrollPane = new JScrollPane(constructorList);
        ListSelectionModel constructorSelectionModel = constructorList.getSelectionModel();

        firstPanel.add(classNameInputTextField, BorderLayout.NORTH);
        firstPanel.add(searchButton, BorderLayout.CENTER);
        firstPanel.add(constructorListScrollPane, BorderLayout.SOUTH);

        add(firstPanel);
        pack();
	}

	public void setConstructor(Constructor c) {

	}
}
