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
			/*try {
				String username = view.getTxtUsername().getText();
				String password = HashUtil.getSHA512SecurePassword(view.getTxtPassword().getPassword().toString());
				User u = UserDAO.getInstance().get(username, password);
				connectListener.connect(u);
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}*/
			
			connectListener.connect(null);
		}
	}
}
