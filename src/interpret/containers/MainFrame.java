/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interpret.components.MyList;

/*
 * ・コンストラクタがスローする例外を正しく表示すること（例：java.lang.Integer(String str)に"aaa"でNumberFormatException）
 * ・toStringなどのObjectクラスのメソッドも表示させる。
 * ・toStringの戻りも表示させること
 * ・配列の生成、配列にNULLが入っていることも表示させる。
 * ・java.awt.Frameをnew, setVisible:trueで、表示されること
 * ・static finalフィールドは書き直せなくて良い
 */

public class MainFrame extends JPanel {
    private static final String DEFAULT_TYPE = "java.lang.Integer";

	JButton createInstanceButton;			//インスタンス生成ボタン
	JButton createInstanceArrayButton;		//インスタンス配列生成ボタン

	MyList constructorList;					//コンストラクタ一覧
	DefaultListModel constructorListModel;
	Constructor[] constructors;		//コンストラクタデータ

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
    ListSelectionHandler listHandler;

    //画面
    InstanceFrame instanceFrame = new InstanceFrame(actionHandler, listHandler);

    @SuppressWarnings("unchecked")
	public MainFrame() {
        super(new BorderLayout());

        //アクションハンドラを生成
        actionHandler = new ActionHandler();
        listHandler = new ListSelectionHandler();

        //---第1パネル---
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        //インスタンス生成ボタン用パネル
        JPanel createInstanceButtonPanel = new JPanel();
        createInstanceButton = new JButton("インスタンス追加");
        createInstanceArrayButton = new JButton("インスタンス配列追加");
        createInstanceButtonPanel.add(createInstanceButton);
        createInstanceButtonPanel.add(createInstanceArrayButton);
        createInstanceButton.addActionListener(actionHandler);
        createInstanceArrayButton.addActionListener(actionHandler);

        constructorListModel = new DefaultListModel();
        constructorList = new MyList(constructorListModel);
        constructorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane constructorListScrollPane = new JScrollPane(constructorList);
        ListSelectionModel constructorSelectionModel = constructorList.getSelectionModel();
        constructorSelectionModel.addListSelectionListener(listHandler);

        firstPanel.add(createInstanceButtonPanel, BorderLayout.CENTER);
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
    public class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // テキストフィールドの内容をリストモデルに追加
            if (event.getActionCommand() == "インスタンス追加") {
            	String value = JOptionPane.showInputDialog(MainFrame.this,
                        "クラス名を入力してください。", DEFAULT_TYPE);
                if (value == null) {
                    return;
                }
            }
        }
    }

    class ListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
	        int index = e.getFirstIndex();
	        Constructor obj = constructors[index];
	        instanceFrame.setConstructor(obj);
		}
    }
}
