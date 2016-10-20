package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class LoginView extends JFrame{
	private static final long serialVersionUID = 1L;

	private JButton btnConnect, test;
	private JLabel lblIsConnected;
	private JTextField username, password;
	
	public LoginView() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		JPanel p = new JPanel();
		p.setLayout(null);
		JButton button = new JButton("Button");
		p.add(button);
		add(p);
		
	/*	btnConnect = new JButton("Connect");
		lblIsConnected = new JLabel("Not connected");
		add(btnConnect, BorderLayout.NORTH);
		add(lblIsConnected, BorderLayout.SOUTH);*/
	}
	
	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JLabel getLblIsConnected() {
		return lblIsConnected;
	}
	
}
