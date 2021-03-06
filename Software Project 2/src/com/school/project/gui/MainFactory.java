package com.school.project.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import com.school.project.gui.controller.SettingsController;
import com.school.project.gui.controller.TicketController;
import com.school.project.gui.controller.UserController;
import com.school.project.gui.controller.listener.ConnectionListener;
import com.school.project.gui.controller.listener.DisconnectListener;
import com.school.project.gui.controller.statistics.StatisticsController;
import com.school.project.language.LanguageObservable;
import com.school.project.model.RailCardCache;
import com.school.project.model.TicketCache;
import com.school.project.model.User;
import com.school.project.model.User.UserType;
import com.school.project.nfc.Acr122Factory;
import com.school.project.nmbs.dao.StationDAO;

public class MainFactory implements ConnectionListener, DisconnectListener {
	private User connectedUser;
	private LoginController login;
	private FrameController frame;
	private LanguageObservable languageObservable;
	
	private static boolean isCacheLoaded;
	
	private static synchronized void setCacheLoaded(boolean b) {
		isCacheLoaded = b;
	}
	private static synchronized boolean isCacheLoaded() {
		return isCacheLoaded;
	}

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
		
		Acr122Factory.getInstance().loadListeners();
		//We use 2 separated threads because they come from different servers
		//If NMBS is down our MYSQL DB will work
		//If the TicketCache is loaded after the baseframe is isn't bad
		//There's a listener to the cache that will update the GUI
		isCacheLoaded = false;
		new Thread(() -> {
			StationDAO.loadCache(true);
			System.out.println("Cache is now loaded");
			setCacheLoaded(true);
		}).start();
		new Thread(() -> {
			TicketCache.getInstance().loadCache();
			RailCardCache.getInstance().loadCache();
		}).start();
		
		connectedUser = null;
		languageObservable = new LanguageObservable();
	}

	public void showLoginFrame() {
		login = new LoginController(this);
		languageObservable.addObserver(login);
		login.getLoginView().setVisible(true);
		languageObservable.languageChanged();
		login.getLoginView().addWindowListener(new WindowListener(){
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
	
	public void showBaseFrame() {
		JFrame loadFrame = null;
		if(!isCacheLoaded()) {
			loadFrame = new JFrame("Loading");
			loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadFrame.getContentPane().add(new JLabel("Please wait until the cache is loaded..."));
			loadFrame.pack();
			loadFrame.setLocationRelativeTo(null);
			loadFrame.setVisible(true);
		}
		while(!isCacheLoaded()) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		frame = new FrameController(languageObservable, this);
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

		if(loadFrame != null)
			loadFrame.dispose();
	}

	private void initBaseModels(FrameController base) {
		addCard(base, new TicketController(connectedUser));
		addCard(base, new RailCardController(connectedUser));
		addCard(base, new RouteController());
		addCard(base, new UserController(connectedUser));
		addCard(base, new ActiveUserRailCardController());
		addCard(base, new LostItemController());
		if(connectedUser != null && connectedUser.getType() == UserType.ADMIN) {
			addCard(base, new SettingsController(languageObservable));
			addCard(base, new StatisticsController());
		}
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

	@Override
	public void disconnect() {
		connectedUser = null;
		frame.getFrameView().dispose();
		showLoginFrame();
	}
}