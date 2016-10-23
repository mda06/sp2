package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.school.project.gui.events.AddCardListener;
import com.school.project.gui.model.BaseModel;
import com.school.project.gui.view.BaseFrame;
import com.school.project.language.LanguageHandler.Language;
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
		frame.getMiEn().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				languageObservable.getLanguageHandler().setLanguage(Language.EN);
			}
			
		});
		frame.getMiFr().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				languageObservable.getLanguageHandler().setLanguage(Language.FR);
			}
			
		});
		frame.getMiNl().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				languageObservable.getLanguageHandler().setLanguage(Language.NL);
			}
			
		});
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
