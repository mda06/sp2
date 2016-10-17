package com.school.project;

import com.school.project.gui.controller.LoginController;
import com.school.project.gui.model.LoginModel;
import com.school.project.gui.view.LoginView;

public class Main {

	public static void main(String[] args) {
		LoginView view = new LoginView();
		view.setVisible(true);
		LoginModel model = new LoginModel(view);
		LoginController controller = new LoginController(view, model);
	}

}
