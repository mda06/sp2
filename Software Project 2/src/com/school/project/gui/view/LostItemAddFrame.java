package com.school.project.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.gui.view.custom.AutoComboBox;
import com.school.project.nmbs.model.StationCache;
import com.school.project.util.FontUtil;

public class LostItemAddFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtType;
	private JPanel pnlAddItem;
	private JTextArea txtDescription;
	private AutoComboBox txtLocation;
	private JLabel lblType, lblDescription, lblLocation;
	private JButton btnSave, btnCancel;
	
	public LostItemAddFrame() {
		initLayout();
		setSize(500,700);
		setTitle("Add a lost item");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
	}
	
	private void initLayout() {

		lblType = new JLabel("Type: ", JLabel.TRAILING);
		lblDescription = new JLabel("Description: ", JLabel.TRAILING);
		lblLocation = new JLabel("Location: ", JLabel.TRAILING);
		txtType = new JTextField(20);
		txtDescription = new JTextArea(2, 20);
		txtLocation = new AutoComboBox(StationCache.getInstance().getStationsNames());
		btnSave = new JButton("Save");
		btnCancel = new JButton("Cancel");
		SpringLayout sp = new SpringLayout();
		pnlAddItem = new JPanel(sp);
		
		pnlAddItem.add(txtType);
		pnlAddItem.add(txtDescription);
		pnlAddItem.add(txtLocation);
		pnlAddItem.add(lblType);
		pnlAddItem.add(lblDescription);
		pnlAddItem.add(lblLocation);
		pnlAddItem.add(btnSave);
		pnlAddItem.add(btnCancel);	
		
		sp.putConstraint(SpringLayout.NORTH, lblType, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lblType, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.EAST, lblType, 50, SpringLayout.WEST, this);
		
		sp.putConstraint(SpringLayout.NORTH, lblDescription, 10, SpringLayout.SOUTH, lblType);
		sp.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, lblType);
		sp.putConstraint(SpringLayout.EAST, lblDescription, 0, SpringLayout.EAST, lblType);
		
		sp.putConstraint(SpringLayout.NORTH, lblLocation, 10, SpringLayout.SOUTH, lblDescription);
		sp.putConstraint(SpringLayout.WEST, lblLocation, 0, SpringLayout.WEST, lblType);
		sp.putConstraint(SpringLayout.EAST, lblLocation, 0, SpringLayout.EAST, lblType);
		
		sp.putConstraint(SpringLayout.NORTH, txtType, 0, SpringLayout.NORTH, lblType);
		sp.putConstraint(SpringLayout.WEST, txtType, 15, SpringLayout.EAST, lblType);
		sp.putConstraint(SpringLayout.EAST, txtType, 10, SpringLayout.EAST, this);

		sp.putConstraint(SpringLayout.NORTH, txtDescription, 10, SpringLayout.SOUTH, txtType);
		sp.putConstraint(SpringLayout.WEST, txtDescription, 0, SpringLayout.WEST, txtType);
		sp.putConstraint(SpringLayout.EAST, txtDescription, 0, SpringLayout.EAST, txtType);
		
		sp.putConstraint(SpringLayout.NORTH, txtLocation, 10, SpringLayout.SOUTH, txtDescription);
		sp.putConstraint(SpringLayout.WEST, txtLocation, 0, SpringLayout.WEST, txtType);
		sp.putConstraint(SpringLayout.EAST, txtLocation, 0, SpringLayout.EAST, txtType);
		
		sp.putConstraint(SpringLayout.NORTH, btnCancel, 10, SpringLayout.SOUTH, txtLocation);
		sp.putConstraint(SpringLayout.WEST, btnCancel, 0, SpringLayout.WEST, lblLocation);
		sp.putConstraint(SpringLayout.EAST, btnCancel, 0, SpringLayout.EAST, txtLocation);
		
		sp.putConstraint(SpringLayout.NORTH, btnSave, 10, SpringLayout.SOUTH, btnCancel);
		sp.putConstraint(SpringLayout.WEST, btnSave, 0, SpringLayout.WEST, btnCancel);
		sp.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, btnCancel);
		
		FontUtil.getInstance().bindSmallFont(lblType);
		FontUtil.getInstance().bindSmallFont(lblDescription);
		FontUtil.getInstance().bindSmallFont(lblLocation);
		FontUtil.getInstance().bindSmallFont(txtType);
		FontUtil.getInstance().bindSmallFont(txtDescription);
		FontUtil.getInstance().bindSmallFont(txtLocation);
		FontUtil.getInstance().bindSmallFont(btnSave);
		FontUtil.getInstance().bindSmallFont(btnCancel);
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
