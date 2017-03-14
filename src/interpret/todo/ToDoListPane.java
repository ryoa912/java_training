/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.todo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListPane extends JPanel {
	private JList toDoList;
    private DefaultListModel toDoListModel;
    private JTextField toDoInputField;
    private JButton addButton;
    private JButton modifyButton;
    private JButton removeButton;
    public ToDoListPane() {
        super(new BorderLayout());
        // 一覧を生成
        toDoListModel = new DefaultListModel();
        toDoList = new JList(toDoListModel);
        JScrollPane listScrollPane = new JScrollPane(toDoList);
        // ToDo追加用テキストフィールドの生成
        toDoInputField = new JTextField();
        // 各ボタンの生成
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("追加");
        modifyButton = new JButton("編集");
        removeButton = new JButton("削除");
        // ボタンにリスナを設定
        addButton.addActionListener(new AddActionHandler());
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(removeButton);
        add(listScrollPane, BorderLayout.NORTH);
        add(toDoInputField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    /**
    * 追加ボタンアクションのハンドラ
    */
    private class AddActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // テキストフィールドの内容をリストモデルに追加
            toDoListModel.addElement(toDoInputField.getText());
        }
    }
}
