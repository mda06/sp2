package com.school.project;

import java.awt.Color;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.LostItemController;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.model.LostItemModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.LostItemView;

public class Main {

	public static void main(String[] args) {
		BaseFrame frame = new BaseFrame();
		frame.setVisible(true);
		BaseModel model = new BaseModel(frame);
		new BaseController(model, frame);
		addCard(model, "red", Color.RED);
		addCard(model, "yellow", Color.YELLOW);
		addCard(model, "blue", Color.BLUE);
		LostItemView lv = new LostItemView();
		LostItemModel lm = new LostItemModel(lv);
		new LostItemController(lm, lv);
		model.addCard(lv);
	}
	
	public static void addCard(BaseModel m, String title, Color c) {
		BaseView bv = new BaseView(title);
		bv.setBackground(c);
		m.addCard(bv);
	}

}
