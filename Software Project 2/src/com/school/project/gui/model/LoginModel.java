package com.school.project.gui.model;

import com.school.project.gui.view.LoginView;

public class LoginModel {
	private LoginView view;
	
	public LoginModel(LoginView view) {
		this.view = view;
	}
	
	public void handleBtnConnect() {
		view.getLblIsConnected().setText("Connected");
	}
}
