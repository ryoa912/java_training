/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.components;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class MyList extends JList {
	@SuppressWarnings("unchecked")
	public MyList(DefaultListModel listModel) {
		super(listModel);
	}
}
