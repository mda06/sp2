package com.school.project.gui.controller.runnable;

import com.school.project.dao.UserDAO;
import com.school.project.gui.model.SelectUserTableModel;
import com.school.project.gui.view.SelectUserPopup;
import com.school.project.model.User;

public class SelectUserRunnable implements Runnable {

	private SelectUserPopup view;
	
	public SelectUserRunnable(SelectUserPopup view) {
		this.view = view;
	}
	
	@Override
	public void run() {
		if(view == null) return;
		String first = view.getTxtFirstName().getText();
		String last = view.getTxtLastName().getText();
		
		SelectUserTableModel model = (SelectUserTableModel)view.getTblUsers().getModel();
		for(User u : UserDAO.getInstance().getUsersLike(first, last)) {
			model.addUser(u);
		}
	}

}
