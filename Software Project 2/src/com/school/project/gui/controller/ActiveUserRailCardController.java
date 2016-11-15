package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;
import com.school.project.language.LanguageHandler;
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
			LanguageHandler handler = ((LanguageObservable) o).getLanguageHandler();
			view.getBtnSelectUser().setText(handler.getString("selectUser"));
			view.getLblSelectUser().setText(handler.getString("selectedUser"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_RAILCARD).setHeaderValue(handler.getString("RailCard"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_FROM).setHeaderValue(handler.getString("from"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_TO).setHeaderValue(handler.getString("to"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_VALID_FROM).setHeaderValue(handler.getString("validFrom"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_VALID_TO).setHeaderValue(handler.getString("validTo"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_SOLD_BY_USER).setHeaderValue(handler.getString("soldByUser"));
			view.repaint();
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
			}
		});
	}

	@Override
	public void userIsSelected(User user) {
		inNameOf = user;
		view.getLblUser().setText(user.getFirstName() + " " + user.getLastName());
		
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--){
			tableModel.removeRow(i);
		}

		//	Toevoegen van ActiveRailCards verkocht door geselecteerde user	
			for(ActiveRailCard item : ActiveRailCardDAO.getInstance().getByName(user.getId())){
				tableModel.addActiveRailCard(item);
			}
	}
}
