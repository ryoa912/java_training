/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import interpret.components.MyArray;
import interpret.components.MyField;
import interpret.components.MyInstance;
import interpret.components.MyMethod;
import interpret.components.MyWindow;
import interpret_sample.InterpretObject;

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
    private static final String DEFAULT_ARRAY_NAME = "array";
    private static final int COMPONENT_WIDTH = 400;
    private static final int COMPONENT_HEIGHT = 100;
    static final String OBJECT_PREFIX = "=";
    private static final String BR = System.getProperty("line.separator");


	JButton createInstanceButton;			//インスタンス生成ボタン
	JButton createInstanceArrayButton;		//インスタンス配列生成ボタン

	private List<MyInstance> instances;
    private final JTree objectTree;
    private final DefaultTreeModel objectTreeModel;
    private final DefaultMutableTreeNode objectRootNode;
    private Dimension treePreferredSize;

	//インスタンス一覧
    JList instanceList;
    DefaultListModel instanceListModel;
    private JScrollPane objectList;

    //配列一覧
    private List<MyArray> arrays = null;
    private JTree arrayTree;
    private DefaultTreeModel arrayTreeModel;
    private DefaultMutableTreeNode arrayRootNode;
    private JList<InterpretObject> arrayCellList;
    private DefaultListModel<InterpretObject> arrayCellListModel;

    //配列操作パネル
    private JButton insertNewButton;
    private JLabel cellIsNullLabel;

    //フィールド一覧
	private JList<MyField> fieldList;
    private DefaultListModel<MyField> fieldListModel;

    //メソッド一覧
	private JList<MyMethod> methodList;
    private DefaultListModel<MyMethod> methodListModel;

    //フィールド操作パネル
    private final JLabel valueLabel;
    private final JButton changeFieldButton;

    //メソッド操作パネル
    private final JTextField invokeParamsField;
    private final JButton invokeMethodButton;

    //アクションハンドラ
    ActionHandler actionHandler = new ActionHandler();

    public MainFrame() {
        instances = new ArrayList<MyInstance>();
        treePreferredSize = new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT);
        arrays = new ArrayList<MyArray>();

        //インスタンス一覧
        objectRootNode = new DefaultMutableTreeNode("Instances");
        objectTree = new JTree(objectRootNode);
        objectList = new JScrollPane(objectTree);
        objectList.setPreferredSize(treePreferredSize);
        objectTree.addTreeSelectionListener(new ObjectSelectionListener());
        objectTree.addMouseListener(new ObjectMouseAdapter());
        objectTree.setRootVisible(false);
        objectTree.setDragEnabled(true);
        objectTreeModel = (DefaultTreeModel) objectTree.getModel();
        addGrid(new JLabel("Instances"), 1, 3);
        addGrid(objectList, 1, 4, 1, 4);

        //配列一覧
        addGrid(new JLabel("Arrays"), 2, 3);
        arrayRootNode = new DefaultMutableTreeNode("Arrays");
        arrayTree = new JTree(arrayRootNode);
        arrayTree.setRootVisible(false);
        arrayTree.addTreeSelectionListener(new ArrayObjectSelectionListener());
        arrayTree.addMouseListener(new ArrayMouseAdapter());
        arrayTree.setDragEnabled(true);
        arrayTree.setPreferredSize(new Dimension(COMPONENT_WIDTH, 100));
        arrayTreeModel = (DefaultTreeModel) arrayTree.getModel();
        JScrollPane arrayTreeScroll = new JScrollPane(arrayTree);
        arrayTreeScroll.setPreferredSize(new Dimension(COMPONENT_WIDTH, 100));
        addGrid(arrayTreeScroll, 2, 4);

        //配列内インスタンス一覧
        addGrid(new JLabel("Cells"), 2, 5);
        arrayCellListModel = new DefaultListModel<>();
        arrayCellList = new JList<>();
        arrayCellList.setModel(arrayCellListModel);
        arrayCellList
                .addListSelectionListener(new ArrayCellSelectionListener());
        arrayCellList.setDragEnabled(true);
        addGrid(new JScrollPane(arrayCellList), 2, 6);

        //配列操作パネル
        JPanel arrayCellControlPanel = new JPanel();
        FlowLayout arrayCellControlPanelLayout = new FlowLayout();
        arrayCellControlPanelLayout.setAlignment(FlowLayout.LEFT);
        arrayCellControlPanel.setPreferredSize(new Dimension(200, 200));
        arrayCellControlPanel.setLayout(arrayCellControlPanelLayout);
        cellIsNullLabel = new JLabel("");
        cellIsNullLabel.setForeground(Color.red);
        arrayCellControlPanel.add(cellIsNullLabel);
        addGrid(arrayCellControlPanel, 2, 7);
        insertNewButton = new JButton("Insert new...");
        insertNewButton.setEnabled(false);
        insertNewButton.addActionListener(new InsertNewActionListener());
        arrayCellControlPanel.add(insertNewButton);

        //フィールド一覧
        fieldList = new JList<>();
        fieldListModel = new DefaultListModel<>();
        fieldList.setModel(fieldListModel);
        fieldList.addListSelectionListener(new FieldSelectionListener());
        addGrid(new JLabel("Fields"), 1, 8);
        addGrid(new JScrollPane(fieldList), 1, 9);

        //フィールド操作パネル
        JPanel fieldControlPanel = new JPanel();
        fieldControlPanel.setLayout(new BoxLayout(fieldControlPanel, BoxLayout.Y_AXIS));
        fieldControlPanel.setPreferredSize(new Dimension(COMPONENT_WIDTH, 100));
        JLabel valueDescLabel = new JLabel("Value: ");
        fieldControlPanel.add(valueDescLabel);
        valueLabel = new JLabel("");
        valueLabel.setPreferredSize(new Dimension(200, 100));
        fieldControlPanel.add(valueLabel);
        changeFieldButton = new JButton("Change");
        changeFieldButton.addActionListener(new ChangeFieldActionListener());
        changeFieldButton.setEnabled(false);
        fieldControlPanel.add(changeFieldButton);
        addGrid(fieldControlPanel, 2, 9);

        //メソッド一覧
        methodList = new JList<>();
        methodListModel = new DefaultListModel<>();
        methodList.setModel(methodListModel);
        methodList.addListSelectionListener(new MethodSelectionListener());
        addGrid(new JLabel("Methods"), 1, 10);
        addGrid(new JScrollPane(methodList), 1, 11);

        //メソッド操作パネル
        JPanel methodControlpanel = new JPanel();
        methodControlpanel.setLayout(new BoxLayout(methodControlpanel, BoxLayout.Y_AXIS));
        methodControlpanel.setPreferredSize(new Dimension(400, 100));
        methodControlpanel.add(new JLabel("Parameters:"));
        invokeParamsField = new JTextField();
        invokeParamsField.setMaximumSize(new Dimension(800, 20));
        invokeParamsField.addActionListener(new TextFieldActionListener());
        methodControlpanel.add(invokeParamsField);
        invokeMethodButton = new JButton("Call");
        invokeMethodButton.setEnabled(false);
        invokeMethodButton.addActionListener(new InvokeMethodActionListener());
        methodControlpanel.add(invokeMethodButton);
        addGrid(methodControlpanel, 2, 11);

        //インスタンス生成ボタン
        JPanel createInstanceButtonPanel = new JPanel();
        createInstanceButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        createInstanceButton = new JButton("インスタンス生成");
        createInstanceButtonPanel.add(createInstanceButton);
        createInstanceButton.addActionListener(actionHandler);
        addGrid(createInstanceButtonPanel, 1, 1);


        //インスタンス生成ボタン
        JPanel createInstanceArrayButtonPanel = new JPanel();
        createInstanceArrayButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        createInstanceArrayButton = new JButton("インスタンス配列生成");
        createInstanceArrayButtonPanel.add(createInstanceArrayButton);
        createInstanceArrayButton.addActionListener(actionHandler);
        addGrid(createInstanceArrayButtonPanel, 2, 1);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("インタープリタ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }

    void addArray(Class<?> cls, Object instance, String name, int length) {
        arrays.add(new MyArray(instance, name, length));
        DefaultMutableTreeNode arrayNode = getArrayClassNode(cls);
        if (arrayNode == null) {
            arrayNode = new DefaultMutableTreeNode(cls.getName());
            arrayRootNode.add(arrayNode);
        }
        DefaultMutableTreeNode objectNode = new DefaultMutableTreeNode(name);
        arrayNode.add(objectNode);
        arrayTreeModel.reload();
        expandAll(arrayTree, 0, arrayTree.getRowCount());
        pack();
        setLocationRelativeTo(null);
    }

    private DefaultMutableTreeNode getClassNode(Class<?> cls) {
        for (int i = 0; i < objectRootNode.getChildCount(); i++)
            if (objectRootNode.getChildAt(i).toString().equals(cls.getName()))
                return (DefaultMutableTreeNode) objectRootNode.getChildAt(i);
        return null;
    }

    private DefaultMutableTreeNode getArrayClassNode(Class<?> cls) {
        for (int i = 0; i < arrayRootNode.getChildCount(); i++)
            if (arrayRootNode.getChildAt(i).toString().equals(cls.getName()))
                return (DefaultMutableTreeNode) arrayRootNode.getChildAt(i);
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

    private void invoke() {
    	MyMethod method = methodList.getSelectedValue();
        if (method == null) {
            showErrorMessage("Method not selected.");
            return;
        }

        //引数の読み込み
        List<String> inputParams = getParameters(invokeParamsField);
        Class<?>[] params = method.getParameterTypes();
        Object[] paramData = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            String inputParam;
            try {
                inputParam = inputParams.get(i);
            } catch (IndexOutOfBoundsException ioobe) {
                paramData[i] = null;
                System.out.println("paramData[" + i + "]=(null)");
                continue;
            }
            if (inputParam.equals("null")) {
                paramData[i] = null;
                System.out.println("paramData[" + i + "]=(null)");
                continue;
            }
            //インスタンスを引数にする場合
            if (inputParam.startsWith(OBJECT_PREFIX)) {
                String name = inputParam.substring(OBJECT_PREFIX.length());
                if (name.contains("[") && name.endsWith("]")) {
                    String arrayName = name.substring(0, name.indexOf("["));
                    String indexStr = name.substring(name.indexOf("[") + 1,
                            name.lastIndexOf("]"));
                    MyArray arrayElement = getArrayElement(arrayName);
                    if (arrayElement == null) {
                        showErrorMessage("Array not found: " + name);
                        return;
                    }
                    try {
                        int index = Integer.parseInt(indexStr);
                        paramData[i] = arrayElement.getObjectAt(index);
                    } catch (NumberFormatException ex) {
                        showErrorMessage("Illegal index: " + indexStr);
                        return;
                    }
                } else {
                    MyInstance element = getObjectElement(name);
                    MyArray arrayElement = getArrayElement(name);
                    if (element == null && arrayElement == null) {
                        showErrorMessage("Object not found: " + name);
                        return;
                    }
                    if (element != null)
                        paramData[i] = element.getObject();
                    if (arrayElement != null)
                        paramData[i] = arrayElement.getObject();
                }
            } else {
                //プリミティブな引数の場合
                if (params[i].isPrimitive()) {
                    try {
                        if (params[i].equals(int.class))
                            paramData[i] = Integer.parseInt(inputParam);
                        else if (params[i].equals(double.class))
                            paramData[i] = Double.parseDouble(inputParam);
                        else if (params[i].equals(float.class))
                            paramData[i] = Float.parseFloat(inputParam);
                        else if (params[i].equals(short.class))
                            paramData[i] = Short.parseShort(inputParam);
                        else if (params[i].equals(char.class))
                            paramData[i] = (char) Integer.parseInt(inputParam);
                        else if (params[i].equals(byte.class))
                            paramData[i] = Byte.parseByte(inputParam);
                        else if (params[i].equals(boolean.class))
                            paramData[i] = Boolean.parseBoolean(inputParam);
                        else {
                            showErrorMessage("Unknown type");
                            return;
                        }
                        System.out.println("paramData[" + i + "]="
                                + paramData[i]);
                        continue;
                    } catch (NumberFormatException e1) {
                        showErrorMessage("NumberFormatException");
                        return;
                    }
                } else {
                    //文字列の引数の場合
                    try {
                        Object p = params[i].getConstructor(String.class)
                                .newInstance(inputParam);
                        paramData[i] = p;
                        System.out.println("paramData[" + i + "]=" + p);
                        continue;
                    } catch (ReflectiveOperationException e1) {
                        System.err
                                .println("Parameter No."
                                        + (i + 1)
                                        + " hasn't string constructor. Inserting null.");
                    } catch (SecurityException e1) {
                        showErrorMessage("SecurityException");
                        return;
                    }
                    System.out.println("paramData[" + i + "]=(null)");
                    paramData[i] = null;
                }
            }
        }

        Object result;
        try {
            result = method.invoke(paramData);
        } catch (IllegalAccessException e1) {
            showErrorMessage("IllegalAccessException");
            return;
        } catch (IllegalArgumentException e1) {
            showErrorMessage("IllegalArgumentException");
            return;
        } catch (InvocationTargetException e1) {
            showErrorMessage("Exception cought: " + BR + e1.getCause());
            return;
        } catch (OutOfMemoryError e1) {
            showErrorMessage("OutOfMemoryError: " + e1.getMessage());
            return;
        } catch (VirtualMachineError e1) {
            showErrorMessage("VirtualMachineError: " + e1.getMessage());
            return;
        } catch (Error e1) {
            showErrorMessage("Error: " + e1.getMessage());
            return;
        } catch (RuntimeException e1) {
            showErrorMessage("RuntimeException: " + e1.getMessage());
            return;
        }
        if (result == null)
            result = "(none)";
        if (method.isReturnVoid())
            result = "(void)";
        JOptionPane
                .showMessageDialog(MainFrame.this, "Result: " + result);
    }

    private List<String> getParameters(JTextField textField) {
        List<String> list = new ArrayList<>();
        if (textField.getText() == null)
            return list;
        StringTokenizer token = new StringTokenizer(textField.getText(), ",");
        while (token.hasMoreTokens()) {
            list.add(token.nextToken());
        }
        return list;
    }

    MyArray getArrayElement(String name) {
    	if (arrays == null)
    		return null;
        for (MyArray e : arrays)
            if (e.getName().equals(name))
                return e;
        return null;
    }

    boolean exists(String name) {
        return getObjectElement(name) != null || getArrayElement(name) != null;
    }

    /**
    * 追加ボタンアクションのハンドラ
    */
    public class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand() == "インスタンス生成") {
            	String value = JOptionPane.showInputDialog(MainFrame.this,
                        "クラス名を入力してください。", DEFAULT_TYPE);
                if (value == null) {
                    return;
                }
                try {
                	new InstanceFrame(MainFrame.this).setClass(Class.forName(value));
                } catch (ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "ClassNotFoundException", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (event.getActionCommand() == "インスタンス配列生成") {
            	String value = JOptionPane.showInputDialog(MainFrame.this,
                        "クラス名を入力してください。", DEFAULT_TYPE);
                if (value == null) {
                    return;
                }
            	String size = JOptionPane.showInputDialog(MainFrame.this,
                        "配列サイズを入力してください。", 3);
                if (size == null) {
                    return;
                }
                try {
                	int iSize = Integer.parseInt(size);
                	new ArrayFrame(MainFrame.this).setClass(Class.forName(value), iSize);
                } catch (ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "ClassNotFoundException", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                	showErrorMessage("NumberFormatException");
                    return;
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
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) objectTree.getLastSelectedPathComponent();
            //選択なし
            if (selectedNode == null) {
                fieldListModel.clear();
                fieldList.setEnabled(false);
                methodListModel.clear();
                methodList.setEnabled(false);
            }
            //クラスを選択
            else if (selectedNode.getParent().equals(objectRootNode)) {
                fieldListModel.clear();
                fieldList.setEnabled(false);
                methodListModel.clear();
                methodList.setEnabled(false);
            }
            //インスタンスを選択
            else if (selectedNode.getParent().getParent().equals(objectRootNode)) {
            	MyInstance element = getObjectElement(selectedNode.toString());
                if (element == null) {
                    System.out.println("Error: element == null");
                    return;
                }
                //フィールドの読み込み
                fieldListModel.clear();
                List<MyField> fl = element.getFields();
                for (MyField f : fl)
                    fieldListModel.addElement(f);
                fieldList.setEnabled(true);
                //メソッドの読み込み
                methodListModel.clear();
                for (MyMethod m : element.getMethods())
                    methodListModel.addElement(m);
                methodList.setEnabled(true);
            }
        }
    }

    private class ChangeFieldActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MyField field = fieldList.getSelectedValue();
            if (field == null) {
                showErrorMessage("Field not selected.");
                return;
            }
            Object value;
            try {
                value = field.getData();
            } catch (IllegalArgumentException e1) {
                showErrorMessage("IllegalArgumentException");
                return;
            } catch (IllegalAccessException e1) {
                showErrorMessage("IllegalAccessException");
                return;
            } catch (ExceptionInInitializerError e1) {
                showErrorMessage("ExceptionInInitializerError");
                return;
            }

            //入力ダイアログから値を受け取る
            while (true) {
                String newValue = JOptionPane.showInputDialog("変更したい値を入力してください。",
                        value == null ? "(null)" : value);
                if (newValue == null)
                    return;
                if (newValue.isEmpty()) {
                    showErrorMessage("Value is empty.");
                    continue;
                }
                try {
                    field.setData(newValue);
                    valueLabel.setText(field.getData().toString());
                    pack();
                    break;
                } catch (NumberFormatException e1) {
                    showErrorMessage("NumberFormatException");
                    continue;
                } catch (IllegalArgumentException e1) {
                    showErrorMessage("IllegalArgumentException");
                    e1.printStackTrace();
                    continue;
                } catch (IllegalAccessException e1) {
                    showErrorMessage("IllegalAccessException");
                    break;
                } catch (SecurityException e1) {
                    showErrorMessage("SecurityException");
                    break;
                } catch (ExceptionInInitializerError e1) {
                    showErrorMessage("ExceptionInInitializerError");
                    return;
                } catch (OutOfMemoryError e1) {
                    showErrorMessage("OutOfMemoryError: " + e1.getMessage());
                    return;
                } catch (VirtualMachineError e1) {
                    showErrorMessage("VirtualMachineError: " + e1.getMessage());
                    return;
                } catch (Error e1) {
                    showErrorMessage("Error: " + e1.getMessage());
                    return;
                } catch (RuntimeException e1) {
                    showErrorMessage("RuntimeException: " + e1.getMessage());
                    return;
                }
            }
        }
    }

    private class ArrayObjectSelectionListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
        }
    }

    private class ArrayMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            new ArrayObjectSelectionListener().valueChanged(null);
        }
    }


    private class InvokeMethodActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            invoke();
        }
    }

    private class TextFieldActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(invokeParamsField))
                invoke();
        }
    }

    private class FieldSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			MyField field = fieldList.getSelectedValue();
            if (field == null) {
                valueLabel.setText("");
                valueLabel.setForeground(Color.black);
                changeFieldButton.setEnabled(false);
            } else {
                try {
                    Object value = field.getData();
                    valueLabel.setText(value.toString());
                    valueLabel.setForeground(Color.black);
                    changeFieldButton.setEnabled(true);
                } catch (IllegalArgumentException e1) {
                    valueLabel.setText("(IllegalArgument)");
                    valueLabel.setForeground(Color.red);
                    changeFieldButton.setEnabled(false);
                } catch (NullPointerException e1) {
                    valueLabel.setText("(null)");
                    valueLabel.setForeground(Color.darkGray);
                    changeFieldButton.setEnabled(true);
                } catch (SecurityException e1) {
                    valueLabel.setText("(SecurityException)");
                    valueLabel.setForeground(Color.red);
                    changeFieldButton.setEnabled(false);
                } catch (IllegalAccessException e1) {
                    valueLabel.setText("(IllegalAccess)");
                    valueLabel.setForeground(Color.red);
                    changeFieldButton.setEnabled(false);
                }
            }
		}
    }

    private class MethodSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			MyMethod method = methodList.getSelectedValue();
            if (method == null) {
                invokeMethodButton.setEnabled(false);
            } else if (method.getParameterTypes().length == 0) {
                invokeMethodButton.setEnabled(true);
                invokeParamsField.setEnabled(false);
            } else {
                invokeMethodButton.setEnabled(true);
                invokeParamsField.setEnabled(true);
            }
		}
    }

    private class ObjectMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent arg0) {
            new ObjectSelectionListener().valueChanged(null);
        }
    }

    private class ArrayCellSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    private class InsertNewActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
