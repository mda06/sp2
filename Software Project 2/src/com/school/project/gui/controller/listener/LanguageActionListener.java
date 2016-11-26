package com.school.project.gui.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.school.project.language.LanguageObservable;

public class LanguageActionListener implements ActionListener {
	private LanguageObservable languageObservable;
	
	public LanguageActionListener(LanguageObservable obs) {
		languageObservable = obs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if(ac != null && !ac.isEmpty()) {
			languageObservable.getLanguageHandler().setLanguage(ac);
		}
	}
}