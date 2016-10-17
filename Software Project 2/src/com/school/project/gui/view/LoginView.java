package com.school.project.gui.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginView extends JFrame{
	private static final long serialVersionUID = 1L;

	private JButton btnConnect;
	private JLabel lblIsConnected;
	
	public LoginView() {
		setTitle("LoginView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setLocationRelativeTo(null);
		
		btnConnect = new JButton("Connect");
		lblIsConnected = new JLabel("Not connected");
		
		add(btnConnect, BorderLayout.NORTH);
		add(lblIsConnected, BorderLayout.SOUTH);
	}
	
	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JLabel getLblIsConnected() {
		return lblIsConnected;
	}
}
