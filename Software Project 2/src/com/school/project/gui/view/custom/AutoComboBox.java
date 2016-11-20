package com.school.project.gui.view.custom;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AutoComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;

	public AutoComboBox(){
	
	}
	public AutoComboBox(String[] items) {
		setItems(items);
	}
	
	public void setItems(String [] items){
		setModel(new DefaultComboBoxModel<String>(items));
		setSelectedIndex(-1);
		setEditable(true);
		JTextField text = (JTextField) this.getEditor().getEditorComponent();
		text.setFocusable(true);
		text.setText("");
		AutoComboBoxListener list = new AutoComboBoxListener(this, items);
		text.addKeyListener(list);
		
		text.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				setPopupVisible(true);
			}
		});
	}

	public String getText() {
		return ((JTextField) this.getEditor().getEditorComponent()).getText();
	}

	public void setText(String string) {
		((JTextField) this.getEditor().getEditorComponent()).setText(string);		
	}

}