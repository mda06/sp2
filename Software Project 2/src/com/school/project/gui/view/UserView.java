package com.school.project.gui.view;

import java.awt.Component;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class UserView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JLabel lbFirstName, lbLastName, lbUsername, lbPassword, lbPasswordControl, lbStreetNumber, lbZipcode,
			lbCity, lblDate, lblGender, lblSoortuser, lbCountry, lbStreetline2;
	private JPasswordField pfPassword, pfPasswordControl;
	private JTextField txtFirstName, txtLastName, txtUsername, txtStreetNumber, txtZipcode, txtCity, txtCountry, txtStreetline2;
	private JButton btnComplete, btnBack, btnSelectUser;
	private JPanel pnlAccount, pnlCredentials, pnlOptions;
	private Component txtPassword;
	private JCheckBox cBUseCredentials;
	private JRadioButton cBGenderM, cBGenderW;
	private ButtonGroup groupGender;
	private JFormattedTextField txtDate;
	private JComboBox<String> cbUserType;
	private String[] userType = {"Admin", "Employee", "Customer"};

	public UserView() {
		super("UserView");
		initLayout();
	}

	public void initLayout() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		lbFirstName = new JLabel("First name");
		txtFirstName = new JTextField(10);
		lbLastName = new JLabel("Last name");
		lbUsername = new JLabel("Username");
		lbPassword = new JLabel("Password");
		lbPasswordControl = new JLabel("Repeat password");
		lbStreetNumber = new JLabel("Street + number");
		lblDate = new JLabel("Date");
		lbZipcode = new JLabel("Zipcode");
		lbCity = new JLabel("City");
		pfPassword = new JPasswordField(10);
		pfPasswordControl = new JPasswordField(10);
		txtLastName = new JTextField(10);
		txtUsername = new JTextField(10);
		txtStreetNumber = new JTextField(10);
		txtDate = new JFormattedTextField(dateFormat);
		txtDate.setColumns(8);
		txtDate.setText(dateFormat.format(date));
		txtZipcode = new JTextField(5);
		txtCity = new JTextField(10);
		btnComplete = new JButton("Complete");
		btnBack = new JButton("Back");
		lblGender = new JLabel("Gender");
		groupGender = new ButtonGroup();
		lblSoortuser = new JLabel("User type");
		btnSelectUser = new JButton("Select user");
		cBUseCredentials = new JCheckBox("useCredentials");
		cBGenderM = new JRadioButton("M");
		cBGenderM.setSelected(true);
		cBGenderW = new JRadioButton("W");
		cbUserType = new JComboBox<String>(userType);
		cbUserType.setSelectedIndex(2);
		lbCountry = new JLabel("Country");
		txtCountry = new JTextField(10);
		lbStreetline2 = new JLabel("Streetline 2");
		txtStreetline2 = new JTextField(10);
		
		groupGender.add(cBGenderM);
		groupGender.add(cBGenderW);
		
		
		

		SpringLayout sp = new SpringLayout();
		pnlAccount = new JPanel(sp);
		pnlCredentials = new JPanel(sp);
		
		//new
		pnlOptions = new JPanel(sp);
		
		pnlAccount.add(lbFirstName);
		pnlAccount.add(txtFirstName);
		pnlAccount.add(lbLastName);
		pnlAccount.add(txtLastName);
		pnlAccount.add(lbStreetNumber);
		pnlAccount.add(lbZipcode);
		pnlAccount.add(lbCity);
		pnlAccount.add(lblDate);
		pnlAccount.add(txtStreetNumber);
		pnlAccount.add(txtZipcode);
		pnlAccount.add(txtCity);
		pnlAccount.add(txtDate);
		pnlAccount.add(cBGenderM);
		pnlAccount.add(cBGenderW);
		pnlAccount.add(lblGender);
		pnlAccount.add(cbUserType);
		pnlAccount.add(lblSoortuser);
		pnlAccount.add(lbCountry);
		pnlAccount.add(txtCountry);
		pnlAccount.add(lbStreetline2);
		pnlAccount.add(txtStreetline2);
		pnlCredentials.add(lbUsername);
		pnlCredentials.add(txtUsername);
		pnlCredentials.add(lbPassword);
		pnlCredentials.add(lbPasswordControl);
		pnlCredentials.add(pfPassword);
		pnlCredentials.add(pfPasswordControl);
		pnlOptions.add(cBUseCredentials);
		pnlOptions.add(btnComplete);
		pnlOptions.add(btnSelectUser);
		
		
		//new buttons
		//pnlCredentials.add(btnBack); //Do we need a back button? => no, i guess (Illya)
		
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtFirstName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtFirstName, 5, SpringLayout.SOUTH, lbFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbLastName, 5, SpringLayout.SOUTH, txtFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtLastName, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtLastName, 5, SpringLayout.SOUTH, lbLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbStreetNumber, 5, SpringLayout.SOUTH, txtLastName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetNumber, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtStreetNumber, 5, SpringLayout.SOUTH, lbStreetNumber);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbStreetline2, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbStreetline2, 5, SpringLayout.SOUTH, txtStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtStreetline2, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtStreetline2, 5, SpringLayout.SOUTH, lbStreetline2);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblDate, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblDate, 5, SpringLayout.SOUTH, txtStreetline2);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtDate, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtDate, 5, SpringLayout.SOUTH, lblDate);
		sp.putConstraint(SpringLayout.WEST, txtDate, 0, SpringLayout.WEST, txtFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbZipcode, 5, SpringLayout.SOUTH, txtDate);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtZipcode, 5, SpringLayout.SOUTH, lbZipcode);
		sp.putConstraint(SpringLayout.WEST, txtZipcode, 0, SpringLayout.WEST, txtFirstName);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbCity, 5, SpringLayout.SOUTH, txtZipcode);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtCity, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtCity, 5, SpringLayout.SOUTH, lbCity);		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbCountry, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbCountry, 5, SpringLayout.SOUTH, txtCity);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtCountry, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtCountry, 5, SpringLayout.SOUTH, lbCountry);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblGender, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblGender, 5, SpringLayout.SOUTH, txtCountry);
		sp.putConstraint(SpringLayout.NORTH, cBGenderM, 5, SpringLayout.SOUTH, lblGender);
		sp.putConstraint(SpringLayout.WEST, cBGenderM, -25, SpringLayout.WEST, lblGender);
		sp.putConstraint(SpringLayout.NORTH, cBGenderW, 5, SpringLayout.SOUTH, lblGender);
		sp.putConstraint(SpringLayout.WEST, cBGenderW, 15, SpringLayout.EAST, cBGenderM);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblSoortuser, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblSoortuser, 5, SpringLayout.SOUTH, cBGenderW);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, cbUserType, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, cbUserType, 5, SpringLayout.SOUTH, lblSoortuser);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, txtUsername, 5, SpringLayout.SOUTH, lbUsername);	
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbPassword, 5, SpringLayout.SOUTH, txtUsername);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, pfPassword, 5, SpringLayout.SOUTH, lbPassword);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbPasswordControl, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, lbPasswordControl, 5, SpringLayout.SOUTH, pfPassword);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfPasswordControl, 0, SpringLayout.HORIZONTAL_CENTER, pnlCredentials);
		sp.putConstraint(SpringLayout.NORTH, pfPasswordControl, 5, SpringLayout.SOUTH, lbPasswordControl);
		
		//new stuff
		sp.putConstraint(SpringLayout.NORTH, cBUseCredentials, 20, SpringLayout.NORTH, pnlOptions);
		sp.putConstraint(SpringLayout.NORTH, btnComplete, 20, SpringLayout.SOUTH, cBUseCredentials);
		
		sp.putConstraint(SpringLayout.WEST, btnSelectUser, 0, SpringLayout.WEST, cBUseCredentials);
		sp.putConstraint(SpringLayout.WEST, btnComplete, 0, SpringLayout.WEST, cBUseCredentials);
		sp.putConstraint(SpringLayout.EAST, btnSelectUser, 0, SpringLayout.EAST, cBUseCredentials);
		sp.putConstraint(SpringLayout.NORTH, btnSelectUser, 10, SpringLayout.SOUTH, btnComplete);
		sp.putConstraint(SpringLayout.EAST, btnComplete, 0, SpringLayout.EAST, cBUseCredentials);
		
		pnlAccount.setBorder(BorderFactory.createTitledBorder("Account"));
		pnlCredentials.setBorder(BorderFactory.createTitledBorder("Credentials"));
		pnlOptions.setBorder(BorderFactory.createTitledBorder("Options"));

		
		sp = new SpringLayout();
		setLayout(sp);	
		pnlAccount.setPreferredSize(new Dimension(300,800));
		pnlCredentials.setPreferredSize(new Dimension(300,280));
		pnlOptions.setPreferredSize(new Dimension(300,200));
		add(pnlAccount);
		add(pnlCredentials);
		add(pnlOptions);
		sp.putConstraint(SpringLayout.WEST, pnlOptions, 20, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlOptions, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlAccount, 40, SpringLayout.EAST, pnlOptions);
		sp.putConstraint(SpringLayout.NORTH, pnlAccount, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlAccount, 750, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, pnlCredentials, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlCredentials, 40, SpringLayout.EAST, pnlAccount);
		
		lbFirstName.setFont(FontUtil.getInstance().getSmall());
		lbLastName.setFont(FontUtil.getInstance().getSmall());
		lbUsername.setFont(FontUtil.getInstance().getSmall());
		lbPassword.setFont(FontUtil.getInstance().getSmall());
		lbPasswordControl.setFont(FontUtil.getInstance().getSmall());
		lbStreetNumber.setFont(FontUtil.getInstance().getSmall());
		lbZipcode.setFont(FontUtil.getInstance().getSmall());
		lbCity.setFont(FontUtil.getInstance().getSmall());
		lblDate.setFont(FontUtil.getInstance().getSmall());
		lblGender.setFont(FontUtil.getInstance().getSmall());
		lblSoortuser.setFont(FontUtil.getInstance().getSmall());
		pfPassword.setFont(FontUtil.getInstance().getSmall());
		pfPasswordControl.setFont(FontUtil.getInstance().getSmall());
		txtFirstName.setFont(FontUtil.getInstance().getSmall());
		txtLastName.setFont(FontUtil.getInstance().getSmall());
		txtUsername.setFont(FontUtil.getInstance().getSmall());
		txtStreetNumber.setFont(FontUtil.getInstance().getSmall());
		txtZipcode.setFont(FontUtil.getInstance().getSmall());
		txtCity.setFont(FontUtil.getInstance().getSmall());
		btnComplete.setFont(FontUtil.getInstance().getSmall());
		btnBack.setFont(FontUtil.getInstance().getSmall());
		btnSelectUser.setFont(FontUtil.getInstance().getSmall());
		cBUseCredentials.setFont(FontUtil.getInstance().getSmall());
		cBGenderM.setFont(FontUtil.getInstance().getSmall());
		cBGenderW.setFont(FontUtil.getInstance().getSmall());
		txtDate.setFont(FontUtil.getInstance().getSmall());
		cbUserType.setFont(FontUtil.getInstance().getSmall());
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

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JLabel getLblGender() {
		return lblGender;
	}

	public void setLblGender(JLabel lblGender) {
		this.lblGender = lblGender;
	}

	public JLabel getLblSoortuser() {
		return lblSoortuser;
	}

	public void setLblSoortuser(JLabel lblSoortuser) {
		this.lblSoortuser = lblSoortuser;
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

	public JPanel getPnlAccount() {
		return pnlAccount;
	}

	public void setPnlAccount(JPanel pnlAccount) {
		this.pnlAccount = pnlAccount;
	}

	public JPanel getPnlCredentials() {
		return pnlCredentials;
	}

	public void setPnlCredentials(JPanel pnlCredentials) {
		this.pnlCredentials = pnlCredentials;
	}

	public JPanel getPnlOptions() {
		return pnlOptions;
	}

	public void setPnlOptions(JPanel pnlOptions) {
		this.pnlOptions = pnlOptions;
	}

	public Component getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(Component txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JCheckBox getcBUseCredentials() {
		return cBUseCredentials;
	}

	public void setcBUseCredentials(JCheckBox cBUseCredentials) {
		this.cBUseCredentials = cBUseCredentials;
	}

	public JRadioButton getcBGenderM() {
		return cBGenderM;
	}

	public void setcBGenderM(JRadioButton cBGenderM) {
		this.cBGenderM = cBGenderM;
	}

	public JRadioButton getcBGenderW() {
		return cBGenderW;
	}

	public void setcBGenderW(JRadioButton cBGenderW) {
		this.cBGenderW = cBGenderW;
	}

	public ButtonGroup getGroupGender() {
		return groupGender;
	}

	public void setGroupGender(ButtonGroup groupGender) {
		this.groupGender = groupGender;
	}

	public JFormattedTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JFormattedTextField txtDate) {
		this.txtDate = txtDate;
	}

	public JComboBox<String> getCbUserType() {
		return cbUserType;
	}

	public void setCbUserType(JComboBox<String> cbUserType) {
		this.cbUserType = cbUserType;
	}

	public String[] getUserType() {
		return userType;
	}

	public void setUserType(String[] userType) {
		this.userType = userType;
	}
	
	public JButton getBtnSelectUser() {
		return btnSelectUser;
	}

	public void setBtnSelectUser(JButton btnSelectUser) {
		this.btnSelectUser = btnSelectUser;
	}

	public JLabel getLbCountry() {
		return lbCountry;
	}

	public void setLbCountry(JLabel lbCountry) {
		this.lbCountry = lbCountry;
	}

	public JLabel getLbStreetline2() {
		return lbStreetline2;
	}

	public void setLbStreetline2(JLabel lbStreetline2) {
		this.lbStreetline2 = lbStreetline2;
	}

	public JTextField getTxtCountry() {
		return txtCountry;
	}

	public void setTxtCountry(JTextField txtCountry) {
		this.txtCountry = txtCountry;
	}

	public JTextField getTxtStreetline2() {
		return txtStreetline2;
	}

	public void setTxtStreetline2(JTextField txtStreetline2) {
		this.txtStreetline2 = txtStreetline2;
	}

}
