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
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interpret.components.MyWindow;

public class ArrayFrame extends MyWindow {
    private static final String DEFAULT_ARRAY_NAME = "array";

	private MainFrame mainFrame;
	private Class<?> cls;
	private Set<Constructor<?>> constructors;
	private JList<String> constructorList;
	private JTextField nameField, paramField;
	private JButton okButton, cancelButton;
	private int size;

	public ArrayFrame(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		setTitle("配列生成");
		setResizable(false);
        pack();
	}

	/**
	 * @param forName
	 */
	public void setClass(Class<?> cls, int size) {
		this.cls = cls;
		this.size = size;

		// Name
		addGrid(new JLabel("配列名:"), 1, 5);
		nameField = new JTextField(DEFAULT_ARRAY_NAME);
		nameField.addActionListener(new TextFieldActionListener());
		addGrid(nameField, 1, 6);

		// Button pane
		JPanel buttonPanel = new JPanel();
		ButtonActionListener listener = new ButtonActionListener();
		okButton = new JButton("OK");
		if (!cls.isPrimitive())
			okButton.setEnabled(true);
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

	private void addArray() {
		String name = nameField.getText();
		if (name == null || name.length() == 0) {
			showErrorMessage("Please input name");
			return;
		}
		if (mainFrame.exists(name)) {
			showErrorMessage("\"" + name + "\" already used.");
			return;
		}
		// Instantiate array
		try {
			mainFrame.addArray(cls, Array.newInstance(cls, size), name, size);
			setVisible(false);
		} catch (IllegalArgumentException e1) {
			showErrorMessage("IllegalArgumentException: " + e1.getMessage());
			return;
		} catch (NegativeArraySizeException e1) {
			showErrorMessage("NegativeArraySizeException");
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
					addArray();
			} else if (e.getSource().equals(nameField)) {
				addArray();
			}
		}
	}

	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(okButton)) {
				addArray();
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
