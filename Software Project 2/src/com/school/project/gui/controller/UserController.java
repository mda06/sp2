package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.school.project.gui.controller.runnable.RouteConnectionRunnable;
import com.school.project.gui.view.UserView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.User;
import com.school.project.dao.UserDAO;

public class UserController extends BaseController<UserView>{
	
	private Boolean useCred = false;
	private String strErrorFillInTheBlanks, strErrorMatchingPassword;
	
	public UserController() {
		super(new UserView());
		view.getPnlCredentials().setVisible(useCred);
		initOptions();
	} 
	
	public void initOptions(){
		view.getcBUseCredentials().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useCred = view.getcBUseCredentials().getModel().isSelected();
				view.getPnlCredentials().setVisible(useCred);
			}
		});
		view.getBtnComplete().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean accInfoOk = checkAccountInfo();
				if(accInfoOk && !useCred){
					//User newUser = new User( )
					//User newUser = new User(-1, view.getTxtFirstName(), view.getTxtLastName(), accountInfoOk, accountInfoOk, null, useCred);
					//UserDAO.getInstance().add(newUser);
				}
				else if(accInfoOk){
					if(checkUserCredentials()){
						
					}
				}
			}
		});
	}
	
	private boolean checkAccountInfo(){
		if(view.getTxtCity().getText().isEmpty() || view.getTxtFirstName().getText().isEmpty() || 
				view.getTxtLastName().getText().isEmpty() || view.getTxtStreetNumber().getText().isEmpty() ||
				view.getTxtZipcode().getText().isEmpty()){
			JOptionPane.showMessageDialog(view.getPnlAccount(),strErrorFillInTheBlanks );
			return false;
		}
			
		return true;
	}
	
	private boolean checkUserCredentials(){
		if(view.getTxtUsername().getText().isEmpty() || view.getPfPassword().getPassword().length == 0 || view.getPfPasswordControl().getPassword().length == 0){
			JOptionPane.showMessageDialog(view.getPnlAccount(),strErrorFillInTheBlanks );
			return false;
		}
		if(!view.getPfPassword().getPassword().equals(view.getPfPasswordControl().getPassword())){
			JOptionPane.showMessageDialog(view.getPnlAccount(),strErrorMatchingPassword);
			return false;
		}
		return true;
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
			view.getLblDate().setText(lh.getString("birthDate"));
			view.getLbZipcode().setText(lh.getString("zipcode"));
			view.getLbCity().setText(lh.getString("city"));
			view.getcBUseCredentials().setText(lh.getString("makeAccount"));
			view.getBtnComplete().setText(lh.getString("save"));
			//view.getCBUseCredentials().removeAll();
			view.getCbUserType().addItem("this item was added in the controller");
			
			
			strErrorFillInTheBlanks = lh.getString("fillInTheBlanks");
			strErrorMatchingPassword = lh.getString("matchingPasswords");
			
			((TitledBorder)view.getPnlOptions().getBorder()).setTitle(lh.getString("options"));
			view.getPnlOptions().repaint();
			((TitledBorder)view.getPnlAccount().getBorder()).setTitle(lh.getString("account"));
			view.getPnlAccount().repaint();
			((TitledBorder)view.getPnlCredentials().getBorder()).setTitle(lh.getString("credentials"));
			view.getPnlCredentials().repaint();
		}
	}

}
