package com.school.project.gui.model;

import com.school.project.gui.ConnectionListener;
import com.school.project.gui.view.LoginView;

public class LoginModel {
	@SuppressWarnings("unused")
	private LoginView view;
	private ConnectionListener connectListener;
	
	public LoginModel(LoginView view, ConnectionListener connectListener) {
		this.view = view;
		this.connectListener = connectListener;
	}
	
	public void handleBtnConnect() {
		if(connectListener != null){
			connectListener.connect(null);
		}
	}
}
