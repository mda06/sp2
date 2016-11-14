package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;

public class ActiveUserRailCardController extends BaseController<ActiveRailCardView>{
	private ActiveRailCardTableModel tableModel;
	private String strErrorAdd, strRemove;
	
	public ActiveUserRailCardController(){
		super(new ActiveRailCardView());
		tableModel = new ActiveRailCardTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setAutoCreateRowSorter(true);
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
