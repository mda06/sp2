package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.school.project.dao.AddressDAO;
import com.school.project.dao.UserCredentialsDAO;
import com.school.project.dao.UserDAO;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.view.UserView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.Address;
import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;
import com.school.project.model.UserCredential;
import com.school.project.util.HashUtil;

public class UserController extends BaseController<UserView> implements SelectedUserListener {

	private Boolean useCred = false;
	private String strErrorFillInTheBlanks, strErrorMatchingPassword, stdConfirmUserSaved, stdConfirmUserUpdated,
			strErrorCannotEdit;
	private UserType connectedUserType;
	private ArrayList<String> availableTypes;
	private SelectUserController selectUserController;
	private User selectedUser;

	public UserController(User connectedUser) {
		super(new UserView());
		availableTypes = new ArrayList<>();
		selectedUser = null;
		
		/* Editting rights for the connected usertype:
		 * Employee can edit customers only!
		 * Customers should not have acces to editting users in this view, currently they can edit other customers
		 * 		(The connected user being a customer is actually not a use case)
		 * Admins can edit and PROMOTE any users
		 */

		if (connectedUser != null) {
			connectedUserType = connectedUser.getType();
			switch (connectedUser.getType()) {
			case CUSTOMER:
				break;
			case EMPLOYEE:
				availableTypes.add("Customer");
				break;
			case ADMIN:
				availableTypes.add("Customer");
				availableTypes.add("Employee");
				availableTypes.add("Admin");
				break;
			}
		}
		view.getPnlCredentials().setVisible(useCred);
		initOptions();
		selectUserController = new SelectUserController(this);
	}

	public void initOptions() {
		view.getBtnSelectUser().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUserController.showPopup();
			}
		});
		view.getcBUseCredentials().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useCred = view.getcBUseCredentials().getModel().isSelected();
				view.getPnlCredentials().setVisible(useCred);
			}
		});
		view.getBtnComplete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean accInfoOk = checkAccountInfo();
				if (selectedUser == null) {
					if (accInfoOk && !useCred) {
						User newUser = getUserFromView();
						AddressDAO.getInstance().add(newUser.getAddress());
						UserDAO.getInstance().add(newUser);
						clearFields();
						JOptionPane.showMessageDialog(view, stdConfirmUserSaved);
					} else if (accInfoOk && useCred && checkUserCredentials()) {
						User newUser = getUserFromView();
						AddressDAO.getInstance().add(newUser.getAddress());
						UserDAO.getInstance().add(newUser);
						UserCredentialsDAO.getInstance().add(newUser.getCredentials());
						clearFields();
						JOptionPane.showMessageDialog(view, stdConfirmUserSaved);
					}
				} else {
					if (accInfoOk && !useCred) {
						User newUser = getUserFromView();
						AddressDAO.getInstance().update(newUser.getAddress());
						UserDAO.getInstance().update(newUser);
						clearFields();
						JOptionPane.showMessageDialog(view, stdConfirmUserUpdated);
					} else if (accInfoOk && useCred && checkUserCredentials()) {
						User newUser = getUserFromView();
						AddressDAO.getInstance().update(newUser.getAddress());
						UserDAO.getInstance().update(newUser);
						if (newUser.getCredentials().getId() > 0)
							UserCredentialsDAO.getInstance().update(newUser.getCredentials());
						else
							UserCredentialsDAO.getInstance().add(newUser.getCredentials());
						clearFields();
						JOptionPane.showMessageDialog(view, stdConfirmUserUpdated);
					}
				}
			}
		});
	}

	private void clearFields() {
		selectedUser = null;
		view.getPfPassword().setText("");
		view.getPfPasswordControl().setText("");
		view.getTxtFirstName().setText("");
		view.getTxtLastName().setText("");
		view.getTxtUsername().setText("");
		view.getTxtStreetNumber().setText("");
		view.getTxtZipcode().setText("");
		view.getTxtCity().setText("");
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
		if (!Arrays.equals(view.getPfPassword().getPassword(), view.getPfPasswordControl().getPassword())) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), strErrorMatchingPassword);
			return false;
		}
		return true;
	}

	private User getUserFromView() {
		// TODO: Lacks country and streetline2
		Address address = new Address(0, view.getTxtStreetNumber().getText(), "", view.getTxtCity().getText(),
				view.getTxtZipcode().getText(), "country", false);
		User.Gender gender = (view.getcBGenderM().isSelected() ? User.Gender.MALE : User.Gender.FEMALE);
		User.UserType userType;

		// No need to check user authentication level, handled in constructor.
		switch (view.getCbUserType().getSelectedIndex()) {
		case 1:
			userType = User.UserType.CUSTOMER;
			break;
		case 2:
			userType = User.UserType.ADMIN;
			break;
		default:
			userType = User.UserType.EMPLOYEE;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		try {
			String userInput = view.getTxtDate().getText();
			java.util.Date utilDate = formatter.parse(userInput);

			java.sql.Date date = new java.sql.Date(utilDate.getTime());

			User user = null;
			if (selectedUser == null) {
				user = new User(0, gender, userType, view.getTxtFirstName().getText(), view.getTxtLastName().getText(),
						date, false);
				user.setAddress(address);
			} else {
				user = selectedUser;
				user.setGender(gender);
				user.setType(userType);
				user.setFirstName(view.getTxtFirstName().getText());
				user.setLastName(view.getTxtLastName().getText());
				user.setDateOfBirth(date);
				Address adr = user.getAddress();
				adr.setCity(address.getCity());
				adr.setCountry(address.getCountry());
				adr.setPostalCode(address.getPostalCode());
				adr.setStreetline1(address.getStreetline1());
				adr.setStreetline2(address.getStreetline2());
			}

			UserCredential userCred = new UserCredential(0, view.getTxtUsername().getText(),
					HashUtil.getSHA512SecurePassword(new String(view.getPfPassword().getPassword())), false);
			if (useCred) {
				if (selectedUser == null || !selectedUser.hasCredentials())
					user.setCredentials(userCred);
				else {
					UserCredential uc = user.getCredentials();
					uc.setPassword(userCred.getPassword());
					uc.setUsername(userCred.getUsername());
				}
			}
			return user;
		} catch (ParseException | UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(view.getPnlAccount(), "Fill in a valid date : dd/mm/yyyy");

			return null;
		}

	}

	public void update(Observable o, Object arg) {
		if (o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
			view.getBtnSelectUser().setText(lh.getString("selectUser"));
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
			view.getLblGender().setText(lh.getString("gender"));
			view.getLbStreetline2().setText(lh.getString("streetLine2"));
			view.getLbCountry().setText(lh.getString("country"));
			view.getLblSoortuser().setText(lh.getString("userType"));
			view.getcBGenderM().setText(lh.getString("genderInitialM"));
			view.getcBGenderW().setText(lh.getString("genderInitialF"));

			strErrorFillInTheBlanks = lh.getString("fillInTheBlanks");
			strErrorMatchingPassword = lh.getString("matchingPasswords");
			stdConfirmUserSaved = lh.getString("confirmUserSaved");
			stdConfirmUserUpdated = lh.getString("confirmUserUpdated");
			strErrorCannotEdit = lh.getString("cannotEditUser");

			// Filling the userType combobox:
			view.getCbUserType().removeAllItems();
			for (int i = 0; i < availableTypes.size(); i++) {
				view.getCbUserType().addItem(lh.getString(availableTypes.get(i)));
			}

			((TitledBorder) view.getPnlOptions().getBorder()).setTitle(lh.getString("options"));
			view.getPnlOptions().repaint();
			((TitledBorder) view.getPnlAccount().getBorder()).setTitle(lh.getString("account"));
			view.getPnlAccount().repaint();
			((TitledBorder) view.getPnlCredentials().getBorder()).setTitle(lh.getString("credentials"));
			view.getPnlCredentials().repaint();
		}
	}

	@Override
	public void userIsSelected(User user) {
		selectedUser = user;

		int index = 0;
		switch (user.getType()) {
		case CUSTOMER:
			index = 0;
			break;
		case EMPLOYEE:
			index = 1;
			break;
		case ADMIN:
			index = 2;
			break;
		}

		if (connectedUserType == UserType.CUSTOMER) {
			view.getCbUserType().setEnabled(false);
			if (user.getType() == UserType.ADMIN || user.getType() == UserType.EMPLOYEE) {
				JOptionPane.showMessageDialog(view, strErrorCannotEdit);
				return;
			}
		} else if (connectedUserType == UserType.EMPLOYEE) {
			if (user.getType() == UserType.ADMIN || user.getType() == UserType.EMPLOYEE) { // EMP cannot edit ADMIN Acc
				JOptionPane.showMessageDialog(view, strErrorCannotEdit);
				return;
			} else {
				view.getCbUserType().setSelectedIndex(index); //This will always be 0
			}
		} else if (connectedUserType == UserType.ADMIN) {
			view.getCbUserType().setSelectedIndex(index);
		}

		view.getTxtFirstName().setText(user.getFirstName());
		view.getTxtLastName().setText(user.getLastName());
		view.getTxtStreetNumber().setText(user.getAddress().getStreetline1());
		view.getTxtStreetline2().setText(user.getAddress().getStreetline2());
		view.getTxtDate().setText(new SimpleDateFormat("dd/MM/yyyy").format(user.getDateOfBirth()));
		view.getTxtZipcode().setText(user.getAddress().getPostalCode());
		view.getTxtCity().setText(user.getAddress().getCity());
		view.getTxtCountry().setText(user.getAddress().getCountry());
		user.getGender();
		if (user.getGender() == Gender.MALE) {
			view.getcBGenderM().setSelected(true);
		} else {
			view.getcBGenderW().setSelected(true);
		}
		view.getTxtUsername().setText(user.getCredentials().getUsername());

	}

}