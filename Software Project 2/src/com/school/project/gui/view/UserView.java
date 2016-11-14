package com.school.project.gui.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.Refreshable;
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
import javax.swing.text.MaskFormatter;

public class UserView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JLabel lbFirstName, lbLastName, lbUsername, lbPassword, lbPasswordControl, lbStreetNumber, lbZipcode,
			lbCity, lblDate, lblGender, lblSoortuser;
	private JPasswordField pfPassword, pfPasswordControl;
	private JTextField txtFirstName, txtLastName, txtUsername, txtStreetNumber, txtZipcode, txtCity;
	private JButton btnComplete, btnBack;
	private JPanel pnlAccount, pnlCredentials, pnlOptions;
	private Component txtPassword;
	private JCheckBox cBUseCredentials;
	private JRadioButton cBGenderM, cBGenderW;
	private ButtonGroup groupGender;
	private JFormattedTextField txtDate;
	private JComboBox<String> cbUserType;
	private String[] userType = {"Admin", "Employee", "Customer"};
	private JButton test;

	

	public UserView() {
		super("NewUser");
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
		//txtDate = new JFormattedTextField(createFormatter("##/##/####"));
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
		
		cBUseCredentials = new JCheckBox("useCredentials");
		cBGenderM = new JRadioButton("M");
		cBGenderM.setSelected(true);
		cBGenderW = new JRadioButton("W");
		cbUserType = new JComboBox<String>(userType);
		cbUserType.setSelectedIndex(2);
		
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
		pnlCredentials.add(lbUsername);
		pnlCredentials.add(txtUsername);
		pnlCredentials.add(lbPassword);
		pnlCredentials.add(lbPasswordControl);
		pnlCredentials.add(pfPassword);
		pnlCredentials.add(pfPasswordControl);
		
		
		//new buttons
		//pnlCredentials.add(btnBack); //Do we need a back button? => no, i guess (Illya)
		pnlOptions.add(cBUseCredentials);
		pnlOptions.add(btnComplete);
		
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
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblDate, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, txtStreetNumber);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtDate, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, txtDate, 20, SpringLayout.NORTH, lblDate);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbZipcode, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lbZipcode, 30, SpringLayout.NORTH, txtDate);
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
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblGender, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblGender, 5, SpringLayout.SOUTH, txtCity);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, cBGenderM, -20, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, cBGenderM, 5, SpringLayout.SOUTH, lblGender);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, cBGenderW, 20, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, cBGenderW, 5, SpringLayout.SOUTH, lblGender);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblSoortuser, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, lblSoortuser, 5, SpringLayout.SOUTH, cBGenderW);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, cbUserType, 0, SpringLayout.HORIZONTAL_CENTER, pnlAccount);
		sp.putConstraint(SpringLayout.NORTH, cbUserType, 5, SpringLayout.SOUTH, lblSoortuser);
		
		
		
		//new stuff
		sp.putConstraint(SpringLayout.NORTH, cBUseCredentials, 20, SpringLayout.NORTH, pnlOptions);
		sp.putConstraint(SpringLayout.NORTH, btnComplete, 20, SpringLayout.SOUTH, cBUseCredentials);
		pnlAccount.setBorder(BorderFactory.createTitledBorder("Accountqwerty"));
		pnlCredentials.setBorder(BorderFactory.createTitledBorder("Credentials"));
		pnlOptions.setBorder(BorderFactory.createTitledBorder("Options"));

		
		sp = new SpringLayout();
		setLayout(sp);	
		pnlAccount.setPreferredSize(new Dimension(300,300));
		pnlCredentials.setPreferredSize(new Dimension(300,200));
		pnlOptions.setPreferredSize(new Dimension(300,150));
		add(pnlAccount);
		add(pnlCredentials);
		add(pnlOptions);
		sp.putConstraint(SpringLayout.WEST, pnlOptions, 20, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlOptions, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlAccount, 40, SpringLayout.EAST, pnlOptions);
		sp.putConstraint(SpringLayout.NORTH, pnlAccount, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlAccount, 500, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnlCredentials, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.NORTH, pnlCredentials, 30, SpringLayout.SOUTH, pnlAccount);
		sp.putConstraint(SpringLayout.SOUTH, pnlCredentials, 800, SpringLayout.NORTH, this);
			
		test = new JButton("test");
		add(test);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				initLayout();
				repaint();
				validate();
			}
		});
		sp.putConstraint(SpringLayout.SOUTH, test, 0, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.EAST, test, 0, SpringLayout.EAST, this);
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

	public JButton getTest() {
		return test;
	}

	public void setTest(JButton test) {
		this.test = test;
	}

	private MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
	

}
