package com.school.project.gui.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import com.school.project.dao.UserDAO;
import com.school.project.gui.view.LoginView;
import com.school.project.model.User;
import com.school.project.util.HashUtil;

public class ConnectionActionListener implements ActionListener {

	private LoginView view;
	private ConnectionListener connectListener;
	
	public ConnectionActionListener(LoginView view, ConnectionListener cl) {
		this.view = view;
		connectListener = cl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (connectListener != null) {
			try {
				String username = view.getTxtUsername().getText();
				String password = HashUtil.getSHA512SecurePassword(String.valueOf(view.getTxtPassword().getPassword()));
				User user = UserDAO.getInstance().get(username, password);
				// if(user != null && user.getType() != UserType.CUSTOMER)
				connectListener.connect(user);
				// else
				//show error dialog
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
