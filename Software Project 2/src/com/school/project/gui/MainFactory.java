package com.school.project.gui;

import java.awt.Color;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.LoginController;
import com.school.project.gui.controller.LostItemController;
import com.school.project.gui.controller.TicketController;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.model.LoginModel;
import com.school.project.gui.model.LostItemModel;
import com.school.project.gui.model.TicketModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.LoginView;
import com.school.project.gui.view.LostItemView;
import com.school.project.gui.view.TicketView;
import com.school.project.language.LanguageObservable;
import com.school.project.model.User;

public class MainFactory implements ConnectionListener{
	@SuppressWarnings("unused")
	private User connectedUser;
	private LoginView loginView;
	private LanguageObservable languageObservable;
	
	public MainFactory() {
		//Init caches
		connectedUser = null;
		loginView = null;
		languageObservable = new LanguageObservable();
	}
	
	public void showLoginFrame() {
		loginView = new LoginView();
		new LoginController(loginView, new LoginModel(loginView, this));
		loginView.setVisible(true);
	}
	
	public void showBaseFrame() {
		BaseFrame frame = new BaseFrame();
		BaseModel model = new BaseModel(frame);
		languageObservable.addObserver(model);
		new BaseController(model, frame, languageObservable);
		initBaseModels(model);
		frame.setVisible(true);
	}
	
	private void initBaseModels(BaseModel model) {
		LostItemView lv = new LostItemView();
		LostItemModel lm = new LostItemModel(lv);
		languageObservable.addObserver(lm);
		new LostItemController(lm, lv);
		model.addCard(lv);
		
		TicketView tv = new TicketView();
		TicketModel tm = new TicketModel(tv);
		languageObservable.addObserver(tm);
		new TicketController(tm, tv);
		model.addCard(tv);
		
		addTestCard(model, "red", Color.RED);
		addTestCard(model, "yellow", Color.YELLOW);
		addTestCard(model, "blue", Color.BLUE);
	}
	
	private static void addTestCard(BaseModel m, String title, Color c) {
		BaseView bv = new BaseView(title);
		bv.setBackground(c);
		m.addCard(bv);
	}

	@Override
	public void connect(User user) {
		if (loginView != null){
			loginView.dispose();
		}
		showBaseFrame();
		
	}
}
