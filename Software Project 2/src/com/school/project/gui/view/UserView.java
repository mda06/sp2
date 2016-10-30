package com.school.project.gui.view;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class UserView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JLabel lbFirstName, lbLastName, lbUsername, lbPassword, lbPasswordControl, lbStreetNumber, lbZipcode,
			lbCity;
	private JPasswordField pfPassword, pfPasswordControl;
	private JTextField txtFirstName, txtLastName, txtUsername, txtStreetNumber, txtZipcode, txtCity;
	private JButton btnComplete, btnBack;
	private JPanel pnlCredentials, pnlAccount;
	private Component txtPassword;

	public UserView() {
		super("New user");
		initLayout();
	}

	private void initLayout() {
		lbFirstName = new JLabel("First name");
		txtFirstName = new JTextField(10);
		lbLastName = new JLabel("Last name");
		lbUsername = new JLabel("Username");
		lbPassword = new JLabel("Password");
		lbPasswordControl = new JLabel("Repeat password");
		lbStreetNumber = new JLabel("Street + number");
		lbZipcode = new JLabel("Zipcode");
		lbCity = new JLabel("City");
		pfPassword = new JPasswordField(10);
		pfPasswordControl = new JPasswordField(10);
		txtLastName = new JTextField(10);
		txtUsername = new JTextField(10);
		txtStreetNumber = new JTextField(10);
		txtZipcode = new JTextField(5);
		txtCity = new JTextField(10);
		btnComplete = new JButton("Complete");
		btnBack = new JButton("Back");
		

		SpringLayout sp = new SpringLayout();
		pnlCredentials = new JPanel(sp);
		pnlAccount = new JPanel(sp);
		
		pnlCredentials.add(lbFirstName);
		pnlCredentials.add(txtFirstName);
		pnlCredentials.add(lbLastName);
		pnlCredentials.add(txtLastName);
		pnlCredentials.add(lbStreetNumber);
		pnlCredentials.add(lbZipcode);
		pnlCredentials.add(lbCity);
		pnlCredentials.add(txtStreetNumber);
		pnlCredentials.add(txtZipcode);
		pnlCredentials.add(txtCity);
		pnlAccount.add(lbUsername);
		pnlAccount.add(txtUsername);
		
		/*
	 
	 	
		add(lbPassword);
		add(lbPasswordControl);
		add(pfPassword);
		add(pfPasswordControl);
		
		add(btnComplete);
		*/
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtFirstName, 20, SpringLayout.NORTH, lbFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbLastName, 30, SpringLayout.NORTH, txtFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtLastName, 20, SpringLayout.NORTH, lbLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbStreetNumber, 30, SpringLayout.NORTH, txtLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtStreetNumber, 20, SpringLayout.NORTH, lbStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbZipcode, 30, SpringLayout.NORTH, txtStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtZipcode, 20, SpringLayout.NORTH, lbZipcode);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbCity, 30, SpringLayout.NORTH, txtZipcode);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtCity, 20, SpringLayout.NORTH, lbCity);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtUsername, 20, SpringLayout.NORTH, lbUsername);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbPassword, 30, SpringLayout.NORTH, txtUsername);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtPassword, 20, SpringLayout.NORTH, lbPassword);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPasswordControl, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbPasswordControl, 30, SpringLayout.NORTH, txtPassword);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtPassword, 20, SpringLayout.NORTH, lbPassword);
		
		pnlCredentials.setBorder(BorderFactory.createTitledBorder("Credentials"));
		pnlAccount.setBorder(BorderFactory.createTitledBorder("Account"));

		
		sp = new SpringLayout();
		setLayout(sp);	
		add(pnlCredentials);
		add(pnlAccount);
		sp.putConstraint(SpringLayout.WEST, pnlCredentials, 500, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlCredentials, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlCredentials, -500, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlCredentials, 300, SpringLayout.NORTH, this);
		
		sp.putConstraint(SpringLayout.WEST, pnlAccount, 500, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlAccount, 300, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlAccount, -500, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlAccount, 600, SpringLayout.NORTH, this);
			
	}

}
