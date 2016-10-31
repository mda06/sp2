package com.school.project.gui.controller;

import java.util.Observable;

import javax.swing.border.TitledBorder;

import com.school.project.gui.view.UserView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class UserController extends BaseController<UserView> {

	public UserController() {
		super(new UserView());
	}

	
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable)o).getLanguageHandler();
			view.getLbFirstName().setText(lh.getString("firstName"));
			view.getLbLastName().setText(lh.getString("lastName"));
			view.getLbUsername().setText(lh.getString("username"));
			view.getLbPassword().setText(lh.getString("password"));
			view.getLbPasswordControl().setText(lh.getString("passwordControl"));
			view.getLbStreetNumber().setText(lh.getString("streetNumber"));
			view.getLbStreetLine2().setText(lh.getString("streetLine2"));
			view.getLbZipcode().setText(lh.getString("zipcode"));
			view.getLbCity().setText(lh.getString("city"));
			((TitledBorder)view.getpnlAccount().getBorder()).setTitle(lh.getString("account"));
			view.getpnlAccount().repaint();
			((TitledBorder)view.getpnlCredentials().getBorder()).setTitle(lh.getString("credentials"));
			view.getpnlCredentials().repaint();
		}
	}

}
