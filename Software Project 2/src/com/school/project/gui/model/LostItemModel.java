package com.school.project.gui.model;

import java.util.Observable;
import java.util.Observer;

import com.school.project.dao.LostItemDAO;
import com.school.project.gui.view.LostItemView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.LostItem;

public class LostItemModel implements Observer {
	private LostItemView view;
	private LostItemTableModel tableModel;

	public LostItemModel(LostItemView view) {
		tableModel = new LostItemTableModel();
		this.view = view;
		this.view.getTable().setModel(tableModel);
		initLostItemsToTable();
	}
	
	public void initLostItemsToTable() {
		for(LostItem item : LostItemDAO.getInstance().getAll()) {
			tableModel.addLostItem(item);
		}
	}

	@Override
	public void update(Observable observable, Object obj) {
		if(observable instanceof LanguageObservable){
			LanguageHandler handler = ((LanguageObservable)observable).getLanguageHandler();
			view.getBtnSearch().setText(handler.getString("search"));
		}
	}	
}
