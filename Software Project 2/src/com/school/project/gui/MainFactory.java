package com.school.project.gui;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.LoginController;
import com.school.project.gui.controller.LostItemController;
import com.school.project.gui.controller.RailCardController;
import com.school.project.gui.controller.RouteController;
import com.school.project.gui.controller.TicketController;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.model.LoginModel;
import com.school.project.gui.model.LostItemModel;
import com.school.project.gui.model.RailCardModel;
import com.school.project.gui.model.RouteModel;
import com.school.project.gui.model.TicketModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.gui.view.LoginView;
import com.school.project.gui.view.LostItemView;
import com.school.project.gui.view.RailCardView;
import com.school.project.gui.view.RouteView;
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
		
		RailCardView rcv = new RailCardView();
		RailCardModel rcm = new RailCardModel(rcv);
		languageObservable.addObserver(rcm);
		new RailCardController(rcm, rcv);
		model.addCard(rcv);
		
		RouteView rv = new RouteView();
		RouteModel rm = new RouteModel(rv);
		languageObservable.addObserver(rm);
		new RouteController(rm, rv);
		model.addCard(rv);
	}
	
	@Override
	public void connect(User user) {
		if (loginView != null){
			loginView.dispose();
		}
		showBaseFrame();
		
	}
}
