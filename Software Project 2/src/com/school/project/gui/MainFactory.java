package com.school.project.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.school.project.dao.DatabaseHandler;
import com.school.project.gui.controller.ActiveUserRailCardController;
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
import com.school.project.model.RailCardCache;
import com.school.project.model.TicketCache;
import com.school.project.model.User;
import com.school.project.nmbs.dao.StationDAO;

public class MainFactory implements ConnectionListener {
	private User connectedUser;
	private LoginController login;
	private LanguageObservable languageObservable;

	public MainFactory() {

		try {
			UIManager.setLookAndFeel(("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
		} catch (UnsupportedLookAndFeelException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (InstantiationException e) {
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			//e.printStackTrace();
		}

		StationDAO.loadCache();
		TicketCache.getInstance().loadCache();
		RailCardCache.getInstance().loadCache();
		
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
		frame.getFrameView().addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				DatabaseHandler.getInstance().closeConnection();
			}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		});
	}

	private void initBaseModels(FrameController base) {
		addCard(base, new LostItemController());
		addCard(base, new TicketController(connectedUser));
		addCard(base, new RailCardController(connectedUser));
		addCard(base, new RouteController());
		addCard(base, new UserController(connectedUser));
		addCard(base, new ActiveUserRailCardController());
	}

	private void addCard(FrameController base, BaseController<?> bc) {
		languageObservable.addObserver(bc);
		base.addCard(bc);
	}

	@Override
	public void connect(User user) {
		connectedUser = user;
		if (login.getLoginView() != null) {
			login.getLoginView().dispose();
		}
		showBaseFrame();
		languageObservable.languageChanged();
	}
}