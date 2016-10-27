package com.school.project.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LostItemAddFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtType,txtDescription, txtLocation;
	private JLabel lblType, lblDescription, lblLocation;
	private JButton btnSave, btnCancel;
	
	public LostItemAddFrame() {
		initLayout();
		setTitle("Add a lost item");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
	}
	
	private void initLayout() {
		getContentPane().setLayout(new GridLayout(4, 2));

		lblType = new JLabel("Type: ", JLabel.TRAILING);
		lblDescription = new JLabel("Description: ", JLabel.TRAILING);
		lblLocation = new JLabel("Location: ", JLabel.TRAILING);
		txtType = new JTextField(20);
		txtDescription = new JTextField(20);
		txtLocation = new JTextField(20);
		btnSave = new JButton("Save");
		btnCancel = new JButton("Cancel");
		
		getContentPane().add(lblType);
		getContentPane().add(txtType);
		getContentPane().add(lblDescription);
		getContentPane().add(txtDescription);
		getContentPane().add(lblLocation);
		getContentPane().add(txtLocation);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		
		pack();
	}
	
	public JTextField getTxtType() {
		return txtType;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public JTextField getTxtLocation() {
		return txtLocation;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public JLabel getLblDescription() {
		return lblDescription;
	}

	public JLabel getLblLocation() {
		return lblLocation;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
}
