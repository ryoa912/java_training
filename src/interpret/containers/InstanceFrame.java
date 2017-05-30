/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.containers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interpret.components.MyWindow;

public class InstanceFrame extends MyWindow {
	private static final String DEFAULT_INSTANCE_NAME = "obj";

	private MainFrame mainFrame;
	private Class<?> cls;
	private Set<Constructor<?>> constructors;
	private JList<String> constructorList;
	private JTextField nameField, paramField;
	private JButton okButton, cancelButton;
	private boolean array = false;
	private String arrayName;
	private int index;

	public InstanceFrame(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		setTitle("インスタンス生成");
		setResizable(false);
        pack();
	}

	public void setClass(Class<?> cls) {
		this.cls = cls;

		// Constructors label
		addGrid(new JLabel("コンストラクタ:"), 1, 1);

		// Constructor list
		constructors = new HashSet<>();
		for (Constructor<?> c : cls.getConstructors())
			constructors.add(c);
		for (Constructor<?> c : cls.getDeclaredConstructors())
			constructors.add(c);
		Set<String> constructorNames = new HashSet<>();
		for (Constructor<?> c : constructors)
			constructorNames.add(c.toString());
		constructorList = new JList<>(
				constructorNames.toArray(new String[constructors.size()]));
		constructorList
				.addListSelectionListener(new ConstructorSelectListener());
		JScrollPane scrollPane = new JScrollPane(constructorList);
		addGrid(scrollPane, 1, 2);

		// Parameters pane
		addGrid(new JLabel("パラメータ:"), 1, 3);
		paramField = new JTextField("");
		if (!cls.isPrimitive())
			paramField.setEnabled(false);
		paramField.addActionListener(new TextFieldActionListener());
		paramField.setDropMode(DropMode.INSERT);
		paramField.setDropTarget(new ObjectDropTarget());
		addGrid(paramField, 1, 4);

		// Name
		addGrid(new JLabel("インスタンス名:"), 1, 5);
		nameField = new JTextField(DEFAULT_INSTANCE_NAME);
		nameField.addActionListener(new TextFieldActionListener());
		addGrid(nameField, 1, 6);

		// Button pane
		JPanel buttonPanel = new JPanel();
		ButtonActionListener listener = new ButtonActionListener();
		okButton = new JButton("OK");
		if (!cls.isPrimitive())
			okButton.setEnabled(false);
		okButton.addActionListener(listener);
		buttonPanel.add(okButton);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(listener);
		buttonPanel.add(cancelButton);
		addGrid(buttonPanel, 1, 7);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setClass(Class<?> class1, String name, int index) {
		this.setClass(class1);

		array = true;
		arrayName = name;
		this.index = index;

		nameField.setText(name + "[" + index + "]");
		nameField.setEnabled(false);

	}

	private void addObject() {
		String name = nameField.getText();
		if (name == null || name.length() == 0) {
			showErrorMessage("Please input name");
			return;
		}
		if (constructorList.getSelectedValue() == null) {
			showErrorMessage("Please select constructor");
			return;
		}
		Constructor<?> selected = getSelectedConstructor();
		if (selected == null) {
			showErrorMessage("Please select constructor");
			return;
		}
		Class<?>[] params = selected.getParameterTypes();

		List<String> inputParams = getParameters();
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
						paramData[i] = (char) Integer
								.parseInt(inputParam);
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
				try {
					Object p = params[i].getConstructor(String.class)
							.newInstance(inputParam);
					paramData[i] = p;
					continue;
				} catch (ReflectiveOperationException e1) {
					System.err
							.println("Parameter #"
									+ (i + 1)
									+ " hasn't string constructor. Inserting null.");
				} catch (SecurityException e1) {
					showErrorMessage("SecurityException");
					return;
				}
				// insert null
				System.out.println("paramData[" + i + "]=(null)");
				paramData[i] = null;
			}
		}
		try {
			if (array) {
				mainFrame.addArrayCell(selected.newInstance(paramData), arrayName, index);
			} else {
				mainFrame.addObject(cls, selected.newInstance(paramData), name);
			}
			setVisible(false);
		} catch (InstantiationException e) {
			showErrorMessage("InstantiationException: " + e.getMessage());
			return;
		} catch (IllegalAccessException e) {
			showErrorMessage("IllegalAccessException: " + e.getMessage());
			return;
		} catch (IllegalArgumentException e) {
			showErrorMessage("IllegalArgumentException: " + e.getMessage());
			return;
		} catch (InvocationTargetException e) {
			showErrorMessage("Exception caught:"
					+ System.getProperty("line.separator") + e.getCause());
			return;
		} catch (OutOfMemoryError e) {
			showErrorMessage("OutOfMemoryError: " + e.getMessage());
			return;
		} catch (VirtualMachineError e) {
			showErrorMessage("VirtualMachineError: " + e.getMessage());
			return;
		} catch (Error e) {
			showErrorMessage("Error: " + e.getMessage());
			return;
		} catch (RuntimeException e) {
			showErrorMessage("RuntimeException: " + e.getMessage());
			return;
		}
	}

	private Constructor<?> getSelectedConstructor() {
		String selectedName = constructorList.getSelectedValue();
		for (Constructor<?> c : constructors)
			if (c.toString().equals(selectedName))
				return c;
		return null;
	}

	private List<String> getParameters() {
		if (paramField.getText() == null)
			return null;
		List<String> list = new ArrayList<>();
		StringTokenizer token = new StringTokenizer(paramField.getText(), ",");
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
		}
		return list;
	}

	private class ConstructorSelectListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (constructorList.getSelectedValue() == null) {
				okButton.setEnabled(false);
			} else {
				Constructor<?> selected = getSelectedConstructor();
				if (selected != null) {
					Class<?>[] params = selected.getParameterTypes();
					if (params == null || params.length == 0) {
						paramField.setEnabled(false);
					} else {
						paramField.setEnabled(true);
					}
					okButton.setEnabled(true);
				}
			}
		}
	}

	private class TextFieldActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(paramField)) {
				if (nameField.isEnabled())
					nameField.requestFocus();
				else
					addObject();
			} else if (e.getSource().equals(nameField)) {
				addObject();
			}
		}
	}

	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(okButton)) {
				addObject();
			} else if (e.getSource().equals(cancelButton)) {
				setVisible(false);
			}
		}
	}

	private class ObjectDropTarget extends DropTarget {
		@Override
		public void drop(DropTargetDropEvent e) {
			Transferable t = e.getTransferable();
			if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				e.acceptDrop(DnDConstants.ACTION_REFERENCE);
				try {
					String s = (String) t
							.getTransferData(DataFlavor.stringFlavor);
					String text = paramField.getText();
					if (text.length() == 0)
						paramField.setText("=" + s);
					else
						paramField.setText(text + ",=" + s);
				} catch (UnsupportedFlavorException e1) {
					showErrorMessage("UnsupportedFlavorException");
					return;
				} catch (IOException e1) {
					showErrorMessage("IOException");
					return;
				}
			}
		}
	}
}
