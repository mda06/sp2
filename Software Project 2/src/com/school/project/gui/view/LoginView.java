package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Toolkit;

import javax.swing.*;

public class LoginView extends JFrame{
	private static final long serialVersionUID = 1L;

	private JButton login;
	private JLabel lUsername, lPassword;
	private JTextField username;
	private JPasswordField password;

	public LoginView() {
		super("loginView");
		initLayout();
	}

	private void initLayout() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		username = new JTextField( 10);
		password = new JPasswordField(10);
		login = new JButton("Login");
		lUsername = new JLabel("Username: ");
		lPassword = new JLabel("Password: ");

		SpringLayout sp = new SpringLayout();
		JPanel pnl = new JPanel(sp);
		add(pnl);
		pnl.add(username);
		pnl.add(password);
		pnl.add(login);
		pnl.add(lUsername);
		pnl.add(lPassword);
	
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, login, 0, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, login, 30, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, username, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, username, 0, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, password, -35, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, password, 0, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lUsername, -60, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lUsername, -100, SpringLayout.HORIZONTAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.VERTICAL_CENTER, lPassword, -35, SpringLayout.VERTICAL_CENTER, pnl);
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lPassword, -98, SpringLayout.HORIZONTAL_CENTER, pnl);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginView();
	}

	/*public JButton getBtnConnect() {
		return btnConnect;
	}

	public JLabel getLblIsConnected() {
		return lblIsConnected;
	}*/

}
