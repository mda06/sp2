package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.User;

public class ActiveUserRailCardController extends BaseController<ActiveRailCardView> implements SelectedUserListener{
	private ActiveRailCardTableModel tableModel;
	private SelectUserController selectUserController;
	private User inNameOf;
	
	public ActiveUserRailCardController(){
		super(new ActiveRailCardView());
		tableModel = new ActiveRailCardTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setAutoCreateRowSorter(true);
		initActiveRailCardstoTable();
		initEvents();
		selectUserController = new SelectUserController(this);
	}

	@Override
	public void update(Observable arg, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initActiveRailCardstoTable(){
		for(ActiveRailCard item : ActiveRailCardDAO.getInstance().getAll()){
			tableModel.addActiveRailCard(item);
		}
	}
	
	public void initEvents(){
		view.getBtnSelectUser().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selectUserController.showPopup();
			}
		});
	}

	@Override
	public void userIsSelected(User user) {
		inNameOf = user;
		view.getLblUser().setText(user.getFirstName() + " " + user.getLastName());
	}
}
