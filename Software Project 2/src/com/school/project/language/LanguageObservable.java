package com.school.project.language;

import java.util.Observable;

public class LanguageObservable extends Observable{
	private LanguageHandler handler;
	
	public LanguageObservable() {
		handler = new LanguageHandler();
		handler.setLanguageObservable(this);
	}
	
	public void languageChanged() {
		setChanged();
		notifyObservers();
	}
	
	public LanguageHandler getLanguageHandler() {
		return handler;
	}
}
