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
		put(Language.NL, "search", "zoeken");
		put(Language.FR, "search", "chercher");
		put(Language.EN, "search", "search");
		put(Language.NL, "options", "opties");
		put(Language.FR, "options", "options");
		put(Language.EN, "options", "options");

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
