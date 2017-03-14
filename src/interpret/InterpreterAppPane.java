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
	private JList instanceList;
    private DefaultListModel instanceListModel;

    private JTextField instanceNameInputField;

    private JButton addInstanceButton;
    private JButton modifyInstanceButton;
    private JButton removeInstanceButton;

    private JButton editFieldButton;
    private JButton callMethodButton;

	private JList fieldList;
    private DefaultListModel fieldListModel;

    @SuppressWarnings("unchecked")
	public InterpreterAppPane() {
        super(new BorderLayout());
        // インスタンス一覧を生成
        instanceListModel = new DefaultListModel();
        instanceList = new JList(instanceListModel);
        JScrollPane listScrollPane = new JScrollPane(instanceList);

        // 追加用テキストフィールドの生成
        instanceNameInputField = new JTextField();

        //ボタンパネルの生成
        JPanel buttonPanel = new JPanel();
        addInstanceButton = new JButton("追加");
        modifyInstanceButton = new JButton("編集");
        removeInstanceButton = new JButton("削除");
        buttonPanel.add(addInstanceButton);
        buttonPanel.add(modifyInstanceButton);
        buttonPanel.add(removeInstanceButton);

        // ボタンにリスナを設定
        addInstanceButton.addActionListener(new AddActionHandler());

        //クラスパネルの生成
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BorderLayout());
        classPanel.add(instanceNameInputField, BorderLayout.NORTH);
        classPanel.add(buttonPanel, BorderLayout.CENTER);
        classPanel.add(listScrollPane, BorderLayout.SOUTH);

        //インスタンスパネルの生成
        JPanel instancePanel = new JPanel();
        editFieldButton = new JButton("編集");
        callMethodButton = new JButton("call");
        instancePanel.add(editFieldButton);
        instancePanel.add(callMethodButton);

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
