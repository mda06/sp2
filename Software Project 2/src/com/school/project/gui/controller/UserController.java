package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.border.TitledBorder;

import com.school.project.gui.controller.runnable.RouteConnectionRunnable;
import com.school.project.gui.view.UserView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class UserController extends BaseController<UserView> {
	
	Boolean useCred = false;
	public UserController() {
		super(new UserView());
		view.getpnlCredentials().setVisible(useCred);
		initOptions();
	}
	
	public void initOptions(){
		view.getCBUseCredentials().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useCred = view.getCBUseCredentials().getModel().isSelected();
				view.getpnlCredentials().setVisible(useCred);
			}
		});
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
			view.getCBUseCredentials().setText(lh.getString("makeAccount"));
			view.getBtnComplete().setText(lh.getString("save"));
			
			((TitledBorder)view.getPnlOptions().getBorder()).setTitle(lh.getString("options"));
			view.getPnlOptions().repaint();
			((TitledBorder)view.getpnlAccount().getBorder()).setTitle(lh.getString("account"));
			view.getpnlAccount().repaint();
			((TitledBorder)view.getpnlCredentials().getBorder()).setTitle(lh.getString("credentials"));
			view.getpnlCredentials().repaint();
		}
	}

}
