package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.school.project.dao.AddressDAO;
import com.school.project.dao.UserCredentialsDAO;
import com.school.project.dao.UserDAO;
import com.school.project.gui.view.UserView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.Address;
import com.school.project.model.User;
import com.school.project.model.UserCredential;

public class UserController extends BaseController<UserView> {

	private Boolean useCred = false;
	private String strErrorFillInTheBlanks, strErrorMatchingPassword;

	public UserController() {
		super(new UserView());
		view.getPnlCredentials().setVisible(useCred);
		initOptions();
	}

	public void initOptions() {
		view.getcBUseCredentials().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useCred = view.getcBUseCredentials().getModel().isSelected();
				view.getPnlCredentials().setVisible(useCred);
			}
		});
		view.getBtnComplete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean accInfoOk = checkAccountInfo();
				if (accInfoOk && !useCred) {
					User newUser = getUserFromView();
					AddressDAO.getInstance().add(newUser.getAddress());
					UserDAO.getInstance().add(newUser);
					
				}
				else if(accInfoOk && useCred && checkUserCredentials()){
					User newUser = getUserFromView();
					AddressDAO.getInstance().add(newUser.getAddress());
					UserDAO.getInstance().add(newUser);
					UserCredentialsDAO.getInstance().add(newUser.getCredentials());
				}
				
			}
		});
	}

	private boolean checkAccountInfo() {
		if (view.getTxtCity().getText().isEmpty() || view.getTxtFirstName().getText().isEmpty()
				|| view.getTxtLastName().getText().isEmpty() || view.getTxtStreetNumber().getText().isEmpty()
				|| view.getTxtZipcode().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), strErrorFillInTheBlanks);
			return false;
		}

		return true;
	}

	private boolean checkUserCredentials() {
		if (view.getTxtUsername().getText().isEmpty() || view.getPfPassword().getPassword().length == 0
				|| view.getPfPasswordControl().getPassword().length == 0) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), strErrorFillInTheBlanks);
			return false;
		}
		if (!Arrays.equals(view.getPfPassword().getPassword(),view.getPfPasswordControl().getPassword())) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), strErrorMatchingPassword);
			return false;
		}
		return true;
	}

	private User getUserFromView() {
		
		Integer zipCode = Integer.parseInt(view.getTxtZipcode().getText());
		Address address = new Address(0, view.getTxtStreetNumber().getText(), "",view.getTxtCity().getText(), (int) zipCode,"country",false);User.Gender gender = (view.getcBGenderM().isSelected() ? User.Gender.MALE : User.Gender.FEMALE);

		User.UserType userType = User.UserType.CUSTOMER;

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		try {
			String userInput = view.getTxtDate().getText();
			java.util.Date utilDate = formatter.parse(userInput);

			java.sql.Date date = new java.sql.Date(utilDate.getTime());

			User user = new User(0, gender, userType, view.getTxtFirstName().getText(), view.getTxtLastName().getText(),
					date, false);
			user.setAddress(address);
			
			if(useCred){
				UserCredential userCred = new UserCredential(0, view.getTxtUsername().getText(),new String(view.getPfPassword().getPassword()), false);
				user.setCredentials(userCred);
			}
			return user;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), "Fill in a valid date : dd/mm/yyyy");

			return null;
		}
		
		

	}

	public void update(Observable o, Object arg) {
		if (o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
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

			strErrorFillInTheBlanks = lh.getString("fillInTheBlanks");
			strErrorMatchingPassword = lh.getString("matchingPasswords");

			// Filling the userType combobox:
			// view.getCbUserType().addItem("Admin");

			((TitledBorder) view.getPnlOptions().getBorder()).setTitle(lh.getString("options"));
			view.getPnlOptions().repaint();
			((TitledBorder) view.getPnlAccount().getBorder()).setTitle(lh.getString("account"));
			view.getPnlAccount().repaint();
			((TitledBorder) view.getPnlCredentials().getBorder()).setTitle(lh.getString("credentials"));
			view.getPnlCredentials().repaint();
		}
	}

}
