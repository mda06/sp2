package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.school.project.gui.model.LoginModel;
import com.school.project.gui.view.LoginView;

public class LoginController implements ActionListener {
	private LoginView view;
	private LoginModel model;
	
	public LoginController(LoginView view, LoginModel model) {
		this.view = view;
		this.model = model;
		
		initEvents();
	}
	
	private void initEvents() {
		view.getBtnConnect().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBtnConnect()) {
			model.handleBtnConnect();
		}
	}
}
