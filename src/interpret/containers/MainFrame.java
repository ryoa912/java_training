/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import interpret.components.MyField;
import interpret.components.MyInstance;
import interpret.components.MyMethod;
import interpret.components.MyWindow;

/*
 * ・コンストラクタがスローする例外を正しく表示すること（例：java.lang.Integer(String str)に"aaa"でNumberFormatException）
 * ・toStringなどのObjectクラスのメソッドも表示させる。
 * ・toStringの戻りも表示させること
 * ・配列の生成、配列にNULLが入っていることも表示させる。
 * ・java.awt.Frameをnew, setVisible:trueで、表示されること
 * ・static finalフィールドは書き直せなくて良い
 */

public class MainFrame extends MyWindow {
    private static final String DEFAULT_TYPE = "java.lang.Integer";

	JButton createInstanceButton;			//インスタンス生成ボタン
	JButton createInstanceArrayButton;		//インスタンス配列生成ボタン

	private List<MyInstance> instances;
    private final JLabel objectsLabel;
    private final JTree objectTree;
    private final DefaultTreeModel objectTreeModel;
    private final DefaultMutableTreeNode objectRootNode;
    private Dimension treePreferredSize;

	JList instanceList;				//インスタンス一覧
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
    InstanceFrame instanceFrame = new InstanceFrame(this);

    @SuppressWarnings("unchecked")
	public MainFrame() {
        instances = new ArrayList<MyInstance>();
        treePreferredSize = new Dimension(100, 100);

        //インスタンス一覧
        objectRootNode = new DefaultMutableTreeNode("Objects");
        objectTree = new JTree(objectRootNode);
        objectTree.addTreeSelectionListener(new ObjectSelectionListener());
        objectTree.addMouseListener(new ObjectMouseAdapter());
        objectTree.setRootVisible(false);
        objectTree.setSize(300, 300);
        objectTree.setDragEnabled(true);
        objectTreeModel = (DefaultTreeModel) objectTree.getModel();
        objectsLabel = new JLabel("Objects            ");
        addGrid(objectsLabel, 1, 1);
        addGrid(new JScrollPane(objectTree), 1, 2);

        //フィールド一覧
        fieldList = new JList<>();
        fieldListModel = new DefaultListModel<>();
        fieldList.setModel(fieldListModel);
        fieldList.addListSelectionListener(new FieldSelectionListener());
        addGrid(new JLabel("Fields"), 2, 1, 2, 1);
        addGrid(new JScrollPane(fieldList), 2, 2);

        //メソッド一覧
        methodList = new JList<>();
        methodListModel = new DefaultListModel<>();
        methodList.setModel(methodListModel);
        methodList.addListSelectionListener(new MethodSelectionListener());
        addGrid(new JLabel("Methods"), 2, 3, 2, 1);
        addGrid(new JScrollPane(methodList), 2, 4);

        //アクションハンドラを生成
        actionHandler = new ActionHandler();
        listHandler = new ListSelectionHandler();

        //---第1パネル---
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        //インスタンス生成ボタン
        JPanel createInstanceButtonPanel = new JPanel();
        createInstanceButton = new JButton("インスタンス生成");
        createInstanceArrayButton = new JButton("インスタンス配列生成");
        createInstanceButtonPanel.add(createInstanceButton);
        createInstanceButtonPanel.add(createInstanceArrayButton);
        createInstanceButton.addActionListener(actionHandler);
        createInstanceArrayButton.addActionListener(actionHandler);
        addGrid(createInstanceButtonPanel, 3, 2);

        //クラス用ボタンパネルの生成
        JPanel classButtonPanel = new JPanel();
        addInstanceButton = new JButton("追加");
        modifyInstanceButton = new JButton("編集");
        removeInstanceButton = new JButton("削除");
        classButtonPanel.add(addInstanceButton);
        classButtonPanel.add(modifyInstanceButton);
        classButtonPanel.add(removeInstanceButton);

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


        pack();
        setSize(getPreferredSize());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addObject(Class<?> cls, Object instance, String name) {
    	instances.add(new MyInstance(instance, name));
        DefaultMutableTreeNode classNode = getClassNode(cls);
        if (classNode == null) {
            classNode = new DefaultMutableTreeNode(cls.getName());
            objectRootNode.add(classNode);
        }
        DefaultMutableTreeNode objectNode = new DefaultMutableTreeNode(name);
        classNode.add(objectNode);
        objectTreeModel.reload();
        expandAll(objectTree, 0, objectTree.getRowCount());
        pack();
        setLocationRelativeTo(null);
    }

    private void updateCurrentSelectedPane(JLabel label) {
        Font font = objectsLabel.getFont();
        Font plain = new Font(font.getName(), Font.PLAIN, font.getSize());
        Font bold = new Font(font.getName(), Font.BOLD, font.getSize());
        if (label == null) {
            objectsLabel.setFont(plain);
        } else if (label.equals(objectsLabel)) {
            objectsLabel.setFont(bold);
        }
    }

    private DefaultMutableTreeNode getClassNode(Class<?> cls) {
        for (int i = 0; i < objectRootNode.getChildCount(); i++)
            if (objectRootNode.getChildAt(i).toString().equals(cls.getName()))
                return (DefaultMutableTreeNode) objectRootNode.getChildAt(i);
        return null;
    }

    MyInstance getObjectElement(String name) {
        for (MyInstance e : instances)
            if (e.getName().equals(name))
                return e;
        return null;
    }

    private void expandAll(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i)
            tree.expandRow(i);
        if (tree.getRowCount() != rowCount)
            expandAll(tree, rowCount, tree.getRowCount());
    }

    /**
    * 追加ボタンアクションのハンドラ
    */
    public class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // テキストフィールドの内容をリストモデルに追加
            if (event.getActionCommand() == "インスタンス生成") {
            	String value = JOptionPane.showInputDialog(MainFrame.this,
                        "クラス名を入力してください。", DEFAULT_TYPE);
                if (value == null) {
                    return;
                }
                try {
                	instanceFrame.setClass(Class.forName(value));
                } catch (ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "ClassNotFoundException", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class ListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
		}
    }

    private class ObjectSelectionListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) objectTree
                    .getLastSelectedPathComponent();
            updateCurrentSelectedPane(objectsLabel);
            // Not choice
            if (selectedNode == null) {
                fieldListModel.clear();
                fieldList.setEnabled(false);
                methodListModel.clear();
                methodList.setEnabled(false);
            }
            // Class choice
            else if (selectedNode.getParent().equals(objectRootNode)) {
                fieldListModel.clear();
                fieldList.setEnabled(false);
                methodListModel.clear();
                methodList.setEnabled(false);
            } else if (selectedNode.getParent().getParent()
                    .equals(objectRootNode)) {
            	MyInstance element = getObjectElement(selectedNode
                        .toString());
                if (element == null) {
                    System.out.println("Error: element == null");
                    return;
                }
                // Load fields
                fieldListModel.clear();
                for (MyField f : element.getFields())
                    fieldListModel.addElement(f);
                fieldList.setEnabled(true);
                // Load methods
                methodListModel.clear();
                for (MyMethod m : element.getMethods())
                    methodListModel.addElement(m);
                methodList.setEnabled(true);
            }
        }
    }

    private class FieldSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
		}
    }

    private class MethodSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
		}
    }

    private class ObjectMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent arg0) {
            new ObjectSelectionListener().valueChanged(null);
        }
    }
}
