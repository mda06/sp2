package com.school.project.gui.model;

import com.school.project.gui.view.LostItemView;
import com.school.project.model.LostItem;

public class LostItemModel {
	private LostItemView view;
	private LostItemTableModel tableModel;
	
	public LostItemModel(LostItemView view) {
		tableModel = new LostItemTableModel();
		this.view = view;
		this.view.getTable().setModel(tableModel);
		tableModel.addLostItem(new LostItem(0, "glasses", "white and black", "BX", false, false));
		tableModel.addLostItem(new LostItem(0, "macbook", "Old one", "BX-Central", false, false));
		tableModel.addLostItem(new LostItem(0, "porfolio", "no desc", "Zaventem", false, false));
		tableModel.addLostItem(new LostItem(0, "child", "With name kenny", "Osseghem", false, false));
		tableModel.addLostItem(new LostItem(0, "test", "?", "Ostende", false, false));
		tableModel.addLostItem(new LostItem(0, "othign", "okay", "Charleroi", false, false));
	}
}
