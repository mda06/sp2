package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SelectUserPopup extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblFirstName, lblLastName;
	private JTextField txtFirstName, txtLastName;
	private JTable tblUsers;
	private JButton btnSearch, btnSelect;
	
	public SelectUserPopup() {
		initLayout();
	}
	
	private void initLayout() {
		setTitle("Select a user");
		setSize(350, 500);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		
		lblFirstName = new JLabel("First name: ", JLabel.TRAILING);
		lblLastName = new JLabel("Last name: ", JLabel.TRAILING);
		txtFirstName = new JTextField(20);
		txtLastName = new JTextField(20);
		tblUsers = new JTable();
		btnSearch = new JButton("Search");
		btnSelect = new JButton("Select user");
		JScrollPane scroll = new JScrollPane(tblUsers);
		
		SpringLayout sp = new SpringLayout();
		JPanel pnl = new JPanel(sp);
		pnl.add(lblFirstName);
		pnl.add(txtFirstName);
		pnl.add(lblLastName);
		pnl.add(txtLastName);
		pnl.add(btnSearch);
		pnl.add(scroll);
		pnl.add(btnSelect);

		sp.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, pnl);
		sp.putConstraint(SpringLayout.NORTH, lblFirstName, 20, SpringLayout.NORTH, pnl);
		sp.putConstraint(SpringLayout.EAST, lblFirstName, 110, SpringLayout.WEST, pnl);
		sp.putConstraint(SpringLayout.WEST, txtFirstName, 10, SpringLayout.EAST, lblFirstName);
		sp.putConstraint(SpringLayout.NORTH, txtFirstName, 0, SpringLayout.NORTH, lblFirstName);
		sp.putConstraint(SpringLayout.EAST, txtFirstName, -20, SpringLayout.EAST, pnl);
		sp.putConstraint(SpringLayout.EAST, lblLastName, 0, SpringLayout.EAST, lblFirstName);
		sp.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		sp.putConstraint(SpringLayout.NORTH, lblLastName, 10, SpringLayout.SOUTH, lblFirstName);
		sp.putConstraint(SpringLayout.EAST, txtLastName, 0, SpringLayout.EAST, txtFirstName);
		sp.putConstraint(SpringLayout.NORTH, txtLastName, 0, SpringLayout.NORTH, lblLastName);
		sp.putConstraint(SpringLayout.WEST, txtLastName, 0, SpringLayout.WEST, txtFirstName);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 20, SpringLayout.SOUTH, txtLastName);
		sp.putConstraint(SpringLayout.WEST, btnSearch, 0, SpringLayout.WEST, txtLastName);
		sp.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.HORIZONTAL_CENTER, txtLastName);
		sp.putConstraint(SpringLayout.SOUTH, btnSelect, -20, SpringLayout.SOUTH, pnl);
		sp.putConstraint(SpringLayout.EAST, btnSelect, 0, SpringLayout.EAST, btnSearch);
		sp.putConstraint(SpringLayout.WEST, btnSelect, 0, SpringLayout.WEST, btnSearch);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, lblFirstName);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, txtFirstName);
		sp.putConstraint(SpringLayout.NORTH, scroll, 20, SpringLayout.SOUTH, btnSearch);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -20, SpringLayout.NORTH, btnSelect);
		
		
		add(pnl);
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public JLabel getLblLastName() {
		return lblLastName;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTable getTblUsers() {
		return tblUsers;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

}
