package com.school.project.gui.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

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


		txtUsername = new JTextField( 10);
		txtPassword = new JPasswordField(10);
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
		
		FontUtil.getInstance().bindBigFont(lUsername);
		FontUtil.getInstance().bindBigFont(lPassword);
		FontUtil.getInstance().bindBigFont(btnLogin);
		btnLogin.setPreferredSize(new Dimension(450, 40));
		
		FontUtil.getInstance().bindBigFont(txtUsername);
		FontUtil.getInstance().bindBigFont(txtPassword);
	
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, btnLogin, 40, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnLogin, 14, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, txtUsername, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtUsername, 110, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, txtPassword, -10, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtPassword, 110, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lUsername, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lUsername, -140, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lPassword, -10, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lPassword, -140, SpringLayout.HORIZONTAL_CENTER, pnl);

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

	public JLabel getlUsername() {
		return lUsername;
	}

	public void setlUsername(JLabel lUsername) {
		this.lUsername = lUsername;
	}

	public JLabel getlPassword() {
		return lPassword;
	}

	public void setlPassword(JLabel lPassword) {
		this.lPassword = lPassword;
	}
	
}
