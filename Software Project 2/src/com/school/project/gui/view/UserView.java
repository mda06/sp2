package com.school.project.gui.view;

import java.awt.Component;
import java.awt.Dimension;

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
			lbCity, lbStreetLine2;
	private JPasswordField pfPassword, pfPasswordControl;
	private JTextField txtFirstName, txtLastName, txtUsername, txtStreetNumber, txtZipcode, txtCity, txtStreetLine2;
	private JButton btnComplete, btnBack;
	private JPanel pnlAccount, pnlCredentials;
	private Component txtPassword;

	public UserView() {
		super("NewUser");
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
		lbStreetLine2 = new JLabel("Streetline 2");
		lbZipcode = new JLabel("Zipcode");
		lbCity = new JLabel("City");
		pfPassword = new JPasswordField(10);
		pfPasswordControl = new JPasswordField(10);
		txtLastName = new JTextField(10);
		txtUsername = new JTextField(10);
		txtStreetNumber = new JTextField(10);
		txtStreetLine2 = new JTextField(10);
		txtZipcode = new JTextField(5);
		txtCity = new JTextField(10);
		btnComplete = new JButton("Complete");
		btnBack = new JButton("Back");
		

		SpringLayout sp = new SpringLayout();
		pnlAccount = new JPanel(sp);
		pnlCredentials = new JPanel(sp);
		
		pnlAccount.add(lbFirstName);
		pnlAccount.add(txtFirstName);
		pnlAccount.add(lbLastName);
		pnlAccount.add(txtLastName);
		pnlAccount.add(lbStreetNumber);
		pnlAccount.add(lbZipcode);
		pnlAccount.add(lbCity);
		pnlAccount.add(lbStreetLine2);
		pnlAccount.add(txtStreetNumber);
		pnlAccount.add(txtZipcode);
		pnlAccount.add(txtCity);
		pnlAccount.add(txtStreetLine2);
		pnlCredentials.add(lbUsername);
		pnlCredentials.add(txtUsername);
		pnlCredentials.add(lbPassword);
		pnlCredentials.add(lbPasswordControl);
		pnlCredentials.add(pfPassword);
		pnlCredentials.add(pfPasswordControl);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtFirstName, 20, SpringLayout.NORTH, lbFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbLastName, 30, SpringLayout.NORTH, txtFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtLastName, 20, SpringLayout.NORTH, lbLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbStreetNumber, 30, SpringLayout.NORTH, txtLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtStreetNumber, 20, SpringLayout.NORTH, lbStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetLine2, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbStreetLine2, 30, SpringLayout.NORTH, txtStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetLine2, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtStreetLine2, 20, SpringLayout.NORTH, lbStreetLine2);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbZipcode, 30, SpringLayout.NORTH, txtStreetLine2);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtZipcode, 20, SpringLayout.NORTH, lbZipcode);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbCity, 30, SpringLayout.NORTH, txtZipcode);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtCity, 20, SpringLayout.NORTH, lbCity);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtUsername, 20, SpringLayout.NORTH, lbUsername);	
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbPassword, 30, SpringLayout.NORTH, txtUsername);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, pfPassword, 20, SpringLayout.NORTH, lbPassword);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPasswordControl, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbPasswordControl, 30, SpringLayout.NORTH, pfPassword);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfPasswordControl, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, pfPasswordControl, 20, SpringLayout.NORTH, lbPasswordControl);
		
		pnlAccount.setBorder(BorderFactory.createTitledBorder("Account"));
		pnlCredentials.setBorder(BorderFactory.createTitledBorder("Credentials"));

		
		sp = new SpringLayout();
		setLayout(sp);	
		pnlAccount.setPreferredSize(new Dimension(300,300));
		pnlCredentials.setPreferredSize(new Dimension(300,200));
		add(pnlAccount);
		add(pnlCredentials);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnlAccount, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, pnlAccount, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlAccount, 350, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnlCredentials, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, pnlCredentials, 30, SpringLayout.SOUTH, pnlAccount);
		sp.putConstraint(SpringLayout.SOUTH, pnlCredentials, 600, SpringLayout.NORTH, this);
			
	}
	public JPanel getpnlAccount(){
		return pnlAccount;
	}
	
	public JPanel getpnlCredentials(){
		return pnlCredentials;
	}
	public JLabel getLbFirstName() {
		return lbFirstName;
	}

	public void setLbFirstName(JLabel lbFirstName) {
		this.lbFirstName = lbFirstName;
	}

	public JLabel getLbLastName() {
		return lbLastName;
	}

	public void setLbLastName(JLabel lbLastName) {
		this.lbLastName = lbLastName;
	}

	public JLabel getLbUsername() {
		return lbUsername;
	}

	public void setLbUsername(JLabel lbUsername) {
		this.lbUsername = lbUsername;
	}

	public JLabel getLbPassword() {
		return lbPassword;
	}

	public void setLbPassword(JLabel lbPassword) {
		this.lbPassword = lbPassword;
	}

	public JLabel getLbPasswordControl() {
		return lbPasswordControl;
	}

	public void setLbPasswordControl(JLabel lbPasswordControl) {
		this.lbPasswordControl = lbPasswordControl;
	}

	public JLabel getLbStreetNumber() {
		return lbStreetNumber;
	}

	public void setLbStreetNumber(JLabel lbStreetNumber) {
		this.lbStreetNumber = lbStreetNumber;
	}

	public JLabel getLbZipcode() {
		return lbZipcode;
	}

	public void setLbZipcode(JLabel lbZipcode) {
		this.lbZipcode = lbZipcode;
	}

	public JLabel getLbCity() {
		return lbCity;
	}

	public void setLbCity(JLabel lbCity) {
		this.lbCity = lbCity;
	}

	public JPasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(JPasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public JPasswordField getPfPasswordControl() {
		return pfPasswordControl;
	}

	public void setPfPasswordControl(JPasswordField pfPasswordControl) {
		this.pfPasswordControl = pfPasswordControl;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JTextField getTxtStreetNumber() {
		return txtStreetNumber;
	}

	public void setTxtStreetNumber(JTextField txtStreetNumber) {
		this.txtStreetNumber = txtStreetNumber;
	}

	public JTextField getTxtZipcode() {
		return txtZipcode;
	}

	public void setTxtZipcode(JTextField txtZipcode) {
		this.txtZipcode = txtZipcode;
	}

	public JTextField getTxtCity() {
		return txtCity;
	}

	public void setTxtCity(JTextField txtCity) {
		this.txtCity = txtCity;
	}

	public JButton getBtnComplete() {
		return btnComplete;
	}

	public void setBtnComplete(JButton btnComplete) {
		this.btnComplete = btnComplete;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JPanel getPnlCredentials() {
		return pnlAccount;
	}

	public void setPnlCredentials(JPanel pnlCredentials) {
		this.pnlAccount = pnlCredentials;
	}

	public JPanel getPnlAccount() {
		return pnlCredentials;
	}

	public void setPnlAccount(JPanel pnlAccount) {
		this.pnlCredentials = pnlAccount;
	}

	public Component getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(Component txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JLabel getLbStreetLine2() {
		return lbStreetLine2;
	}

	public void setLbStreetLine2(JLabel lbStreetLine2) {
		this.lbStreetLine2 = lbStreetLine2;
	}

	public JTextField getTxtStreetLine2() {
		return txtStreetLine2;
	}

	public void setTxtStreetLine2(JTextField txtStreetLine2) {
		this.txtStreetLine2 = txtStreetLine2;
	}
	

}
