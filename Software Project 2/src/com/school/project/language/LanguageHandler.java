package com.school.project.language;

import java.util.HashMap;

public class LanguageHandler {
	public enum Language {
		NL, FR, EN;
	}
	
	private Language currentLanguage;
	private LanguageObservable observable;
	private HashMap<Language, HashMap<String, String>> words;
	
	public LanguageHandler() {
		currentLanguage = Language.EN;
		words = new HashMap<Language, HashMap<String, String>>();
		initWords();
	}
	
	private void initWords() {
		words.put(Language.NL, new HashMap<String, String>());
		words.put(Language.FR, new HashMap<String, String>());
		words.put(Language.EN, new HashMap<String, String>());
		put(Language.NL, "search", "Zoeken");
		put(Language.FR, "search", "Chercher");
		put(Language.EN, "search", "Search");
		
		put(Language.NL, "options", "Opties");
		put(Language.FR, "options", "Options");
		put(Language.EN, "options", "Options");
		
		put(Language.NL, "lostItemView", "Verloren Voorwerpen");
		put(Language.FR, "lostItemView", "Objet Perdu");
		put(Language.EN, "lostItemView", "Lost Objects");
		
		put(Language.NL, "RailCard", "Abonement");
		put(Language.FR, "RailCard", "Abonnement");
		put(Language.EN, "RailCard", "Railcard");
		
		put(Language.NL, "TicketView", "Tickets");
		put(Language.FR, "TicketView", "Ticket");
		put(Language.EN, "TicketView", "Tickets");

	}
	
	public void setLanguage(Language l) {
		currentLanguage = l;
		observable.languageChanged();
	}
	
	private void put(Language lan, String key, String value) {
		words.get(lan).put(key, value);
	}
	
	public String getString(String key) {
		return words.get(currentLanguage).get(key);
	}

	public void setLanguageObservable(LanguageObservable languageObservable) {
		observable = languageObservable;
	}
}
