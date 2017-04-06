/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interpret.components.MyButton;
import interpret.components.MyList;
import interpret.components.MyTextField;

public class MainFrame extends JPanel {
	MyTextField classNameInputTextField;	//クラス名入力テキストフィールド

	MyButton searchButton;					//クラス候補検索ボタン

	MyList constructorList;					//コンストラクタ一覧
	DefaultListModel constructorListModel;

	MyList instanceList;				//インスタンス一覧
    DefaultListModel instanceListModel;

    private JButton addInstanceButton;
    private JButton modifyInstanceButton;
    private JButton removeInstanceButton;

    private JButton editFieldButton;
    private JButton callMethodButton;

    //フィールド一覧
	private JList fieldList;
    private DefaultListModel fieldListModel;

    //メソッド一覧
	private JList methodList;
    private DefaultListModel methodListModel;

    //アクションハンドラ
    ActionHandler actionHandler;

    @SuppressWarnings("unchecked")
	public MainFrame() {
        super(new BorderLayout());

        //アクションハンドラを生成
        actionHandler = new ActionHandler();

        //---第1パネル---
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        classNameInputTextField = new MyTextField();

        searchButton = new MyButton("検索");
        searchButton.addActionListener(actionHandler);

        constructorListModel = new DefaultListModel();
        constructorList = new MyList(constructorListModel);
        JScrollPane constructorListScrollPane = new JScrollPane(constructorList);

        firstPanel.add(classNameInputTextField, BorderLayout.NORTH);
        firstPanel.add(searchButton, BorderLayout.CENTER);
        firstPanel.add(constructorListScrollPane, BorderLayout.SOUTH);

        //インスタンス一覧を生成
        instanceListModel = new DefaultListModel();
        instanceList = new MyList(instanceListModel);
        JScrollPane instanceListScrollPane = new JScrollPane(instanceList);


        //クラス用ボタンパネルの生成
        JPanel classButtonPanel = new JPanel();
        addInstanceButton = new JButton("追加");
        modifyInstanceButton = new JButton("編集");
        removeInstanceButton = new JButton("削除");
        classButtonPanel.add(addInstanceButton);
        classButtonPanel.add(modifyInstanceButton);
        classButtonPanel.add(removeInstanceButton);

        //ボタンにリスナを設定
        addInstanceButton.addActionListener(actionHandler);

        //クラスパネルの生成
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BorderLayout());
        classPanel.add(firstPanel, BorderLayout.NORTH);
        classPanel.add(classButtonPanel, BorderLayout.CENTER);
        classPanel.add(instanceListScrollPane, BorderLayout.SOUTH);

        //インスタンスパネルの生成
        JPanel instancePanel = new JPanel();
        instancePanel.setLayout(new BorderLayout());
        //インスタンス用ボタンパネルの生成
        JPanel instanceButtonPanel = new JPanel();
        editFieldButton = new JButton("編集");
        callMethodButton = new JButton("call");
        instanceButtonPanel.add(editFieldButton);
        instanceButtonPanel.add(callMethodButton);

        //フィールド一覧を生成
        methodListModel = new DefaultListModel();
        methodList = new JList(methodListModel);
        JScrollPane methodListScrollPane = new JScrollPane(methodList);

        //メソッド一覧を生成
        fieldListModel = new DefaultListModel();
        fieldList = new JList(fieldListModel);
        JScrollPane fieldListScrollPane = new JScrollPane(fieldList);

        instancePanel.add(instanceButtonPanel, BorderLayout.NORTH);
        instancePanel.add(fieldListScrollPane, BorderLayout.CENTER);
        instancePanel.add(methodListScrollPane, BorderLayout.SOUTH);


        setLayout(new BorderLayout());
        add(classPanel, BorderLayout.WEST);
        add(instancePanel, BorderLayout.EAST);
    }
    /**
    * 追加ボタンアクションのハンドラ
    */
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // テキストフィールドの内容をリストモデルに追加
            if (event.getActionCommand() == "検索") {
            	//検索時の処理（クラス名入力テキストフィールドの文字を見て、部分一致のクラスを取得）
            	String className = classNameInputTextField.getText();
            	System.out.println("検索名：" + className);
            	Class<?> clazz;
            	try {
            		clazz = Class.forName(className);
            	} catch (ClassNotFoundException e) {
            		throw new RuntimeException(e);
            	}
            	Method[] methods = clazz.getMethods();
            	for (int i=0; i<methods.length; i++) {
            		constructorListModel.addElement(methods[i].getName());
            	}
            } else if (event.getActionCommand() == "追加") {
            	instanceListModel.addElement(classNameInputTextField.getText());
            }
        }
    }
}
