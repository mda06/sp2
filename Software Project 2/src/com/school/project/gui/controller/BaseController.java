package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.school.project.gui.controller.listener.LanguageListener;
import com.school.project.gui.events.AddCardListener;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.language.LanguageObservable;

public class BaseController implements ActionListener, AddCardListener {
	private BaseModel model;
	private BaseFrame frame;
	private LanguageObservable languageObservable;
	
	public BaseController(BaseModel model, BaseFrame frame,	LanguageObservable languageObservable) {
		this.model = model;
		this.frame = frame;
		this.model.setAddCardListener(this);
		this.languageObservable = languageObservable;
		initLanguageEvents();
	}

	private void initLanguageEvents(){
		LanguageListener ll = new LanguageListener(frame, languageObservable);
		frame.getMiEn().addActionListener(ll);
		frame.getMiFr().addActionListener(ll);
		frame.getMiNl().addActionListener(ll);
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
