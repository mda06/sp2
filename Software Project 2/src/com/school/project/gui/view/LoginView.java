package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoginView extends JFrame{
	private static final long serialVersionUID = 1L;

	private JButton btnLogin;
	private JLabel lUsername, lPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	public LoginView() {
		super("loginView");
		initLayout();
	}

	private void initLayout() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);


		txtUsername = new JTextField( 20);
		txtPassword = new JPasswordField(20);
		btnLogin = new JButton("Login");
		lUsername = new JLabel("Username: ");
		lPassword = new JLabel("Password: ");

		SpringLayout sp = new SpringLayout();
		JPanel pnl = new JPanel(sp);
		add(pnl);
		pnl.add(txtUsername);
		pnl.add(txtPassword);
		pnl.add(btnLogin);
		pnl.add(lUsername);
		pnl.add(lPassword);
	
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, btnLogin, 0, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnLogin, 30, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, txtUsername, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtUsername, 0, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, txtPassword, -35, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtPassword, 0, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lUsername, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lUsername, -100, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lPassword, -35, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lPassword, -98, SpringLayout.HORIZONTAL_CENTER, pnl);

		this.setVisible(true);
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton login) {
		this.btnLogin = login;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField username) {
		this.txtUsername = username;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField password) {
		this.txtPassword = password;
	}

}
