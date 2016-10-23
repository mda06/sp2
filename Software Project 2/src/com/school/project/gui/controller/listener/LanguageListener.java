package com.school.project.gui.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.school.project.gui.view.BaseFrame;
import com.school.project.language.LanguageHandler.Language;
import com.school.project.language.LanguageObservable;

public class LanguageListener implements ActionListener {

	private BaseFrame frame;
	private LanguageObservable languageObservable;
	
	public LanguageListener(BaseFrame frame, LanguageObservable obs) {
		this.frame = frame;
		languageObservable = obs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frame.getMiEn()) languageObservable.getLanguageHandler().setLanguage(Language.EN);
		else if(e.getSource() == frame.getMiNl()) languageObservable.getLanguageHandler().setLanguage(Language.NL);
		else if(e.getSource() == frame.getMiFr()) languageObservable.getLanguageHandler().setLanguage(Language.FR);
	}

}
