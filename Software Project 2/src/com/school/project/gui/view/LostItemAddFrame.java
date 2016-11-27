package com.school.project.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.school.project.gui.view.custom.AutoComboBox;
import com.school.project.nmbs.model.StationCache;
import com.school.project.util.FontUtil;

public class LostItemAddFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtType;
	private JTextArea txtDescription;
	private AutoComboBox txtLocation;
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
		txtDescription = new JTextArea(2, 20);
		txtLocation = new AutoComboBox(StationCache.getInstance().getStationsNames());
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
		
		FontUtil.getInstance().bindSmallFont(lblType);
		FontUtil.getInstance().bindSmallFont(lblDescription);
		FontUtil.getInstance().bindSmallFont(lblLocation);
		FontUtil.getInstance().bindSmallFont(txtType);
		FontUtil.getInstance().bindSmallFont(txtDescription);
		FontUtil.getInstance().bindSmallFont(txtLocation);
		FontUtil.getInstance().bindSmallFont(btnSave);
		FontUtil.getInstance().bindSmallFont(btnCancel);
		
		pack();
	}
	
	public JTextField getTxtType() {
		return txtType;
	}

	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	public AutoComboBox getTxtLocation() {
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

	public void resetFields() {
		txtType.setText("");
		txtDescription.setText("");
		txtLocation.setText("");
	}
}
