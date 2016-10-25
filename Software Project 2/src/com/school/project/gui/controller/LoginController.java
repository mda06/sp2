package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Observable;
import java.util.Observer;

import com.school.project.dao.UserDAO;
import com.school.project.gui.ConnectionListener;
import com.school.project.gui.view.LoginView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.User;
import com.school.project.util.HashUtil;

public class LoginController implements ActionListener, Observer {
	private LoginView view;
	private ConnectionListener connectListener;

	public LoginController(ConnectionListener list) {
		view = new LoginView();
		this.connectListener = list;

		initEvents();
	}

	private void initEvents() {
		view.getBtnLogin().addActionListener(this);
		view.getTxtPassword().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getBtnLogin() || e.getSource() == view.getTxtPassword()) {
			handleConnect();
		}
	}

	private void handleConnect() {
		if (connectListener != null) {
			try {
				String username = view.getTxtUsername().getText();
				String password = HashUtil.getSHA512SecurePassword(String.valueOf(view.getTxtPassword().getPassword()));
				User user = UserDAO.getInstance().get(username, password);
				// if(user != null && user.getType() != UserType.CUSTOMER)
				connectListener.connect(user);
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable)o).getLanguageHandler();
			view.getBtnLogin().setText(lh.getString("login"));
			view.getlPassword().setText(lh.getString("password"));
			view.getlUsername().setText(lh.getString("username"));
		}
	}
	
	public LoginView getLoginView() {
		return view;
	}
}
