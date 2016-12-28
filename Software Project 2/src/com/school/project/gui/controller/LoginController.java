package com.school.project.gui.controller;

import java.util.Observable;
import java.util.Observer;

import com.school.project.dao.NFCDAO;
import com.school.project.gui.controller.listener.ConnectionActionListener;
import com.school.project.gui.controller.listener.ConnectionListener;
import com.school.project.gui.view.LoginView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.User;
import com.school.project.nfc.Acr122Factory;
import com.school.project.nfc.CardMifare1K;
import com.school.project.nfc.event.CardConnected;

public class LoginController implements Observer, CardConnected {
	private LoginView view;
	private ConnectionListener connectListener;

	public LoginController(ConnectionListener list) {
		view = new LoginView();
		this.connectListener = list;
		
		setBaseCredentials();
		initEvents();
		Acr122Factory.getInstance().addCardListener(this);
	}
	
	private void setBaseCredentials() {
		//Nobody
	}

	private void initEvents() {
		ConnectionActionListener cl = new ConnectionActionListener(view, connectListener);
		view.getBtnLogin().addActionListener(cl);
		view.getTxtPassword().addActionListener(cl);
		view.getTxtUsername().addActionListener(cl);
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

	@Override
	public void cardConnected(CardMifare1K c) {
		if(view.isVisible()) {
			String uid = c.getUIDString();
			User user = NFCDAO.getInstance().get(uid);
			if(user != null)
				connectListener.connect(user);
		}
	}
}
