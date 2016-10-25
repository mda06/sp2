package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.dao.LostItemDAO;
import com.school.project.gui.model.LostItemTableModel;
import com.school.project.gui.view.LostItemView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.LostItem;

public class LostItemController extends BaseController<LostItemView> {
	private LostItemTableModel tableModel;
	
	public LostItemController() {
		super(new LostItemView());
		tableModel = new LostItemTableModel();
		view.getTable().setModel(tableModel);
		initLostItemsToTable();
	}
	
	//TODO: put it in another thread
	public void initLostItemsToTable() {
		for(LostItem item : LostItemDAO.getInstance().getAll()) {
			tableModel.addLostItem(item);
		}
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof LanguageObservable){
			LanguageHandler handler = ((LanguageObservable)observable).getLanguageHandler();
			view.getBtnSearch().setText(handler.getString("search"));
		}
	}
}
