package com.school.project.gui.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseView extends JPanel {
	private static final long serialVersionUID = 1L;

	public final String CARD_KEY;
	
	public BaseView(String key) {
		CARD_KEY = key;
		add(new JLabel(key));
	}
}
