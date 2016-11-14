package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;
import com.school.project.model.ActiveRailCard;

public class ActiveUserRailCardController extends BaseController<ActiveRailCardView>{
	private ActiveRailCardTableModel tableModel;
	
	public ActiveUserRailCardController(){
		super(new ActiveRailCardView());
		tableModel = new ActiveRailCardTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setAutoCreateRowSorter(true);
		initActiveRailCardstoTable();
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initActiveRailCardstoTable(){
		for(ActiveRailCard item : ActiveRailCardDAO.getInstance().getAll()){
			tableModel.addActiveRailCard(item);
		}
	}
}
