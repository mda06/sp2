package com.school.project.gui.controller;

import java.util.Observable;
import java.util.Observer;

import com.school.project.gui.controller.listener.ConnectionActionListener;
import com.school.project.gui.controller.listener.ConnectionListener;
import com.school.project.gui.view.LoginView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class LoginController implements Observer {
	private LoginView view;
	private ConnectionListener connectListener;

	public LoginController(ConnectionListener list) {
		view = new LoginView();
		this.connectListener = list;

		setBaseCredentials();
		initEvents();
	}
	
	private void setBaseCredentials() {
		view.getTxtUsername().setText("Illya");
		view.getTxtPassword().setText("illy");
	}

	private void initEvents() {
		ConnectionActionListener cl = new ConnectionActionListener(view, connectListener);
		view.getBtnLogin().addActionListener(cl);
		view.getTxtPassword().addActionListener(cl);
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
