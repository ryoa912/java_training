package gui.ex14;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PropertyDialog extends Dialog{
	GridBagLayout gbl = new GridBagLayout();

	public PropertyDialog(Frame owner) {
		super(owner);

		setLayout(gbl);
		Button b1 = new Button();
		addButton(b1, 0, 0, 1, 3);
	}

	private void addButton(Button b, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(b, gbc);
        add(b);
	}
}
