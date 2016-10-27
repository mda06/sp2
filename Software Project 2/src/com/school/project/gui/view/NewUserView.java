package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class NewUserView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JLabel lbFirstName, lbLastName, lbUsername, lbPassword, lbPasswordControl, lbStreetNumber, lbZipcode;
	private JPasswordField pfPassword, pfPasswordControl;
	private JTextField txtFirstName, txtLastName, txtUsername, txtStreetNumber, txtZipcode;
	private JButton btnComplete, btnBack;

	public NewUserView(String key) {
		super("New user");
		initLayout();
	}

	private void initLayout() {
		lbFirstName = new JLabel("Firs name");
		lbLastName = new JLabel("Last name");
		lbUsername = new JLabel("Username");
		lbPassword = new JLabel("Password");
		lbPasswordControl = new JLabel("Repeat password");
		lbStreetNumber = new JLabel("Street + number");
		lbZipcode = new JLabel("Zipcode");
		pfPassword = new JPasswordField(10);
		pfPasswordControl = new JPasswordField(10);
		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtUsername = new JTextField(10);
		txtStreetNumber = new JTextField(10);
		txtZipcode = new JTextField(5);
		btnComplete = new JButton("Complete");
		btnBack = new JButton("Back");
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(lbFirstName);
		add(lbLastName);
		add(lbUsername);
		add(lbPassword);
		add(lbPasswordControl);
		add(lbStreetNumber);
		add(lbZipcode);
		add(pfPassword);
		add(pfPasswordControl);
		add(txtFirstName);
		add(txtLastName);
		add(txtUsername);
		add(txtStreetNumber);
		add(txtZipcode);
		add(btnComplete);
		add(btnBack);
		
	}

}
