package com.school.project.gui;

import javax.swing.JOptionPane;

import com.school.project.dao.RailCardDAO;
import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.FrameController;
import com.school.project.gui.controller.LoginController;
import com.school.project.gui.controller.LostItemController;
import com.school.project.gui.controller.RailCardController;
import com.school.project.gui.controller.RouteController;
import com.school.project.gui.controller.TicketController;
import com.school.project.gui.controller.UserController;
import com.school.project.gui.controller.listener.ConnectionListener;
import com.school.project.language.LanguageObservable;
import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;
import com.school.project.model.TicketCache;
import com.school.project.model.User;
import com.school.project.nmbs.dao.StationDAO;

public class MainFactory implements ConnectionListener{
	private User connectedUser;
	private LoginController login;
	private LanguageObservable languageObservable;
	
	public MainFactory() {
		//TODO: Put it in another thread
		StationDAO.loadCache();
		TicketCache.getInstance().loadCache();
		RailCardCache.getInstance().loadCache();
		
		RailCard c = RailCardDAO.getInstance().get(4);
		c.setArchived(false);
		RailCardDAO.getInstance().update(c);
		
		connectedUser = null;
		languageObservable = new LanguageObservable();
	}
	
	public void showLoginFrame() {
		login = new LoginController(this);
		languageObservable.addObserver(login);
		login.getLoginView().setVisible(true);
		languageObservable.languageChanged();
	}
	
	public void showBaseFrame() {
		FrameController frame = new FrameController(languageObservable);
		languageObservable.addObserver(frame);
		initBaseModels(frame);
		frame.getFrameView().setVisible(true);
	}
	
	private void initBaseModels(FrameController base) {
		addCard(base, new LostItemController());
		addCard(base, new TicketController());
		addCard(base, new RailCardController());
		addCard(base, new RouteController());
		addCard(base, new UserController());
	}
	
	private void addCard(FrameController base, BaseController<?> bc) {
		languageObservable.addObserver(bc);
		base.addCard(bc);
	}
	
	@Override
	public void connect(User user) {
		connectedUser = user;
		if (login.getLoginView() != null){
			login.getLoginView().dispose();
		}
		showBaseFrame();
		languageObservable.languageChanged();
		if(connectedUser != null)
			JOptionPane.showMessageDialog(null, connectedUser.getFirstName() + " is connected.");
	}
}
