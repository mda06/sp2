package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.school.project.gui.events.AddCardListener;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.view.BaseFrame;

public class BaseController implements ActionListener, AddCardListener {
	private BaseModel model;
	@SuppressWarnings("unused")
	private BaseFrame frame;
	
	public BaseController(BaseModel model, BaseFrame frame) {
		this.model = model;
		this.frame = frame;
		this.model.setAddCardListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		boolean isFromCard = false;
		if(e.getActionCommand() != null) {
			isFromCard = model.showCard(e.getActionCommand());
		}
	}

	@Override
	public void addCard(JButton btn) {
		btn.addActionListener(this);
	}
}
