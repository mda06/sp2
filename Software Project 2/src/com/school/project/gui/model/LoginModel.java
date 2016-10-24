package com.school.project.gui.model;

import java.io.UnsupportedEncodingException;

import com.school.project.dao.UserDAO;
import com.school.project.gui.ConnectionListener;
import com.school.project.gui.view.LoginView;
import com.school.project.model.User;
import com.school.project.util.HashUtil;

public class LoginModel {
	private LoginView view;
	private ConnectionListener connectListener;
	
	public LoginModel(LoginView view, ConnectionListener connectListener) {
		this.view = view;
		this.connectListener = connectListener;
	}
	
	public void handleBtnConnect() {
		if(connectListener != null){
			try {
				String username = view.getTxtUsername().getText();
				System.out.println(String.valueOf(view.getTxtPassword().getPassword()));
				String password = HashUtil.getSHA512SecurePassword(String.valueOf(view.getTxtPassword().getPassword()));
				User user = UserDAO.getInstance().get(username, password);
				//if(user != null && user.getType() != UserType.CUSTOMER)
				connectListener.connect(user);
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
	}
}
