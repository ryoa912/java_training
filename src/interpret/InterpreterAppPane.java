/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class InterpreterAppPane extends JPanel {
	//インスタンス一覧
	private JList instanceList;
    private DefaultListModel instanceListModel;

    private JTextField instanceNameInputField;

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

    @SuppressWarnings("unchecked")
	public InterpreterAppPane() {
        super(new BorderLayout());

        //インスタンス一覧を生成
        instanceListModel = new DefaultListModel();
        instanceList = new JList(instanceListModel);
        JScrollPane instanceListScrollPane = new JScrollPane(instanceList);

        //追加用テキストフィールドの生成
        instanceNameInputField = new JTextField();

        //クラス用ボタンパネルの生成
        JPanel classButtonPanel = new JPanel();
        addInstanceButton = new JButton("追加");
        modifyInstanceButton = new JButton("編集");
        removeInstanceButton = new JButton("削除");
        classButtonPanel.add(addInstanceButton);
        classButtonPanel.add(modifyInstanceButton);
        classButtonPanel.add(removeInstanceButton);

        //ボタンにリスナを設定
        addInstanceButton.addActionListener(new AddActionHandler());

        //クラスパネルの生成
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BorderLayout());
        classPanel.add(instanceNameInputField, BorderLayout.NORTH);
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
    private class AddActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // テキストフィールドの内容をリストモデルに追加
            instanceListModel.addElement(instanceNameInputField.getText());
        }
    }
}
