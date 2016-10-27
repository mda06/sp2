package com.school.project.gui.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
		initSearchBoxEvents();
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
	
	private void initSearchBoxEvents(){
		view.getTxtSearch().addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	view.getTxtSearch().setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (view.getTxtSearch().getText().isEmpty()){
		    		view.getTxtSearch().setText("Search");
		    	}
		    }
		});
	}
}
