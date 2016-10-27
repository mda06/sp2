package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.gui.view.UserView;

public class UserController extends BaseController<UserView> {

	public UserController() {
		super(new UserView());
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
