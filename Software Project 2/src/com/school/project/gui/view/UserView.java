package com.school.project.gui.view;

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

	public UserView() {
		super("New user");
		initLayout();
	}

	private void initLayout() {
		lbFirstName = new JLabel("First name");
		lbLastName = new JLabel("Last name");
		lbUsername = new JLabel("Username");
		lbPassword = new JLabel("Password");
		lbPasswordControl = new JLabel("Repeat password");
		lbStreetNumber = new JLabel("Street + number");
		lbZipcode = new JLabel("Zipcode");
		lbCity = new JLabel("City");
		pfPassword = new JPasswordField(10);
		pfPasswordControl = new JPasswordField(10);
		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtUsername = new JTextField(10);
		txtStreetNumber = new JTextField(10);
		txtZipcode = new JTextField(5);
		txtCity = new JTextField(10);
		btnComplete = new JButton("Complete");
		btnBack = new JButton("Back");

		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(sp);
		
		
		pnl.add(lbFirstName);
		pnl.add(lbLastName);
		add(lbUsername);
		add(lbPassword);
		add(lbPasswordControl);
		add(lbStreetNumber);
		add(lbZipcode);
		add(lbCity);
		add(pfPassword);
		add(pfPasswordControl);
		add(txtFirstName);
		add(txtLastName);
		add(txtUsername);
		add(txtStreetNumber);
		add(txtZipcode);
		add(txtCity);
		add(btnComplete);
		add(btnBack);

		/*sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbFirstName, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, lbFirstName, 30, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtFirstName, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, txtFirstName, 50, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbLastName, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, lbLastName, 100, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtLastName, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, txtLastName, 120, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, lbStreetNumber, 170, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, txtStreetNumber, 190, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbZipcode, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, lbZipcode, 240, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtZipcode, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, txtZipcode, 260, SpringLayout.NORTH, this);*/
		
	}

}
