package com.school.project.gui.controller;

import com.school.project.gui.model.LostItemModel;
import com.school.project.gui.view.LostItemView;

public class LostItemController {
	@SuppressWarnings("unused")
	private LostItemModel model;
	@SuppressWarnings("unused")
	private LostItemView view;
	
	public LostItemController(LostItemModel model, LostItemView view) {
		this.model = model;
		this.view = view;
	}
}
