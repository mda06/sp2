package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;
import com.school.project.language.LanguageObservable;
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
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			//LanguageHandler
			
		}
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
				
				
				/* Tabel leegmaken
				 * 
				for(int i = tableModel.getRowCount() - 1; i >= 0; i--){
					tableModel.removeRow(i);
				}
				*/
				
				
				/*
					Toevoegen van ActiveRailCards verkocht door geselecteerde user
					
				if(!view.getLblUser().getText().isEmpty()){
					for(ActiveRailCard item : ActiveRailCardDAO.getInstance().getByName(view.getLblUser().getName())){
						tableModel.addActiveRailCard(item);
					}
				}
				*/
			}
		});
	}

	@Override
	public void userIsSelected(User user) {
		inNameOf = user;
		view.getLblUser().setText(user.getFirstName() + " " + user.getLastName());
	}
}
