package com.school.project.gui.view.custom;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AutoComboBoxListener extends KeyAdapter {
	private JComboBox<String> cbListener;
	private Vector<String> vector;

	public AutoComboBoxListener(JComboBox<String> cbListenerParam, String[] items) {
		cbListener = cbListenerParam;
		vector = new Vector<String>();
		for(String item : items)
			vector.add(item);
	}

	public void keyReleased(KeyEvent key) {
		final int KEY_CODE = key.getKeyCode();
		if(KEY_CODE == KeyEvent.VK_LEFT || KEY_CODE == KeyEvent.VK_RIGHT) return;
		if(KEY_CODE == KeyEvent.VK_ESCAPE) {
			cbListener.setPopupVisible(false);
			return;
		}
		
		if(KEY_CODE == KeyEvent.VK_DOWN) {
			int i = cbListener.getSelectedIndex() + 1;
			if(i >= cbListener.getModel().getSize()) i = 0;
			cbListener.setSelectedIndex(i);
			return;
		}
		
		if(KEY_CODE == KeyEvent.VK_UP) {
			int i = cbListener.getSelectedIndex() - 1;
			if(i < 0) i = cbListener.getModel().getSize();
			cbListener.setSelectedIndex(i);
			return;
		}
		
		String text = ((JTextField) key.getSource()).getText();
		Vector<String> v = getFilteredList(text);
		cbListener.setModel(new DefaultComboBoxModel<String>(v));
		
		if(KEY_CODE == KeyEvent.VK_BACK_SPACE || KEY_CODE == KeyEvent.VK_DELETE) {
			cbListener.showPopup();
			((JTextField) cbListener.getEditor().getEditorComponent()).setText(text);
			return;
		}
		
		cbListener.setSelectedIndex(-1);
		cbListener.showPopup();
		((JTextField) cbListener.getEditor().getEditorComponent()).setText(text);
	}

	public Vector<String> getFilteredList(String text) {
		Vector<String> v = new Vector<String>();
		for (int a = 0; a < vector.size(); a++) {
			if (vector.get(a).toString().toLowerCase().startsWith(text.toLowerCase())) {
				v.add(vector.get(a).toString());
			} 
		}
		return v;
	}
}