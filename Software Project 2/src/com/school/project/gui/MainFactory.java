package com.school.project.gui;

import java.awt.Color;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.LoginController;
import com.school.project.gui.controller.LostItemController;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.model.LoginModel;
import com.school.project.gui.model.LostItemModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.LoginView;
import com.school.project.gui.view.LostItemView;
import com.school.project.model.User;

public class MainFactory implements ConnectionListener{
	@SuppressWarnings("unused")
	private User connectedUser;
	private LoginView loginView;
	
	public MainFactory() {
		//Init caches
		connectedUser = null;
		loginView = null;
	}
	
	public void showLoginFrame() {
		loginView = new LoginView();
		new LoginController(loginView, new LoginModel(loginView, this));
		loginView.setVisible(true);
	}
	
	public void showBaseFrame() {
		BaseFrame frame = new BaseFrame();
		BaseModel model = new BaseModel(frame);
		new BaseController(model, frame);
		initBaseModels(model);
		frame.setVisible(true);
	}
	
	private void initBaseModels(BaseModel model) {
		LostItemView lv = new LostItemView();
		new LostItemController(new LostItemModel(lv), lv);
		model.addCard(lv);
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
