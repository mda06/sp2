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

		put(Language.NL, "add", "Toevoegen");
		put(Language.FR, "add", "Ajouter");
		put(Language.EN, "add", "Add");

		put(Language.NL, "type", "Type");
		put(Language.FR, "type", "Type");
		put(Language.EN, "type", "Type");

		put(Language.NL, "description", "Descriptie");
		put(Language.FR, "description", "Description");
		put(Language.EN, "description", "Description");
		
		put(Language.NL, "location", "Locatie");
		put(Language.FR, "location", "Emplacement");
		put(Language.EN, "location", "Location");
		
		put(Language.NL, "options", "Opties");
		put(Language.FR, "options", "Options");
		put(Language.EN, "options", "Options");
		
		put(Language.NL, "lostItemView", "Verloren Voorwerpen");
		put(Language.FR, "lostItemView", "Objets Perdus");
		put(Language.EN, "lostItemView", "Lost Objects");
		
		put(Language.NL, "RailCard", "Abonements");
		put(Language.FR, "RailCard", "Abonnements");
		put(Language.EN, "RailCard", "Railcards");

		put(Language.NL, "TicketView", "Tickets");
		put(Language.FR, "TicketView", "Ticket");
		put(Language.EN, "TicketView", "Tickets");
		
		put(Language.NL, "Route", "Route");
		put(Language.FR, "Route", "Route");
		put(Language.EN, "Route", "Route");
		
		put(Language.NL, "login", "Log in");
		put(Language.FR, "login", "S'identifier");
		put(Language.EN, "login", "Login");

		put(Language.NL, "password", "Wachtwoord");
		put(Language.FR, "password", "Mot de passe");
		put(Language.EN, "password", "Password");

		put(Language.NL, "username", "Gebruikersnaam");
		put(Language.FR, "username", "Nom d'utilisateur");
		put(Language.EN, "username", "Username");
		
		put(Language.NL, "New user", "Nieuwe gebruiker");
		put(Language.FR, "New user", "Nouvel utilisateur");
		put(Language.EN, "New user", "New user");

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
