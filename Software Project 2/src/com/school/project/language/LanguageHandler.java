package com.school.project.language;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class LanguageHandler {
	
	private String currentLanguage;
	private LanguageObservable observable;
	private HashMap<String, HashMap<String, String>> words;

	public LanguageHandler() {
		currentLanguage = "en";
		words = new HashMap<String, HashMap<String, String>>();
		initWords();
	}

	private void initWords() {
		// source:
		// https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();

			// DTD validation source:
			// http://stackoverflow.com/questions/8699620/how-to-validate-xml-with-dtd-using-java
			domFactory.setValidating(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();

			builder.setErrorHandler(new ErrorHandler() {
				@Override
				public void error(SAXParseException exception) throws SAXException {
					exception.printStackTrace();
				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					exception.printStackTrace();
				}

				@Override
				public void warning(SAXParseException exception) throws SAXException {
					exception.printStackTrace();
				}
			});
			Document doc = dBuilder.parse(getClass().getResource("/languages.xml").openStream());
			doc.getDocumentElement().normalize();

			NodeList stringNodes = doc.getElementsByTagName("string");

			for (int i = 0; i < stringNodes.getLength(); i++) {
				Element stringEl = (Element) stringNodes.item(i);
				String key = stringEl.getAttribute("name");
				NodeList valueNodes = stringEl.getElementsByTagName("value");
				for (int j = 0; j < valueNodes.getLength(); j++) {
					Element valueEl = (Element) valueNodes.item(j);
					String lang = valueEl.getAttribute("lang");
					if(words.get(lang) == null) 
						words.put(lang, new HashMap<>());
					
						
					if (!valueEl.getTextContent().isEmpty()) // DTD checkt niet alles
						words.get(lang).put(key, valueEl.getTextContent());
					else 
						words.get(lang).put(key, "!" + key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLanguage(String l) {
		currentLanguage = l;
		observable.languageChanged();
	}

	public String getString(String key) {
		return words.get(currentLanguage).get(key);
	}
	
	public String getCurrentLanguage() {
		return currentLanguage;
	}
	
	public List<String> getLanguages() {
		return words.keySet().stream().collect(Collectors.toList());
	}

	public void addNewLanguage(String key, HashMap<String, String> newWords) {
		words.put(key, newWords);
	}
	
	public void setLanguageObservable(LanguageObservable languageObservable) {
		observable = languageObservable;
	}
	
	public HashMap<String, HashMap<String, String>> getWords() {
		return words;
	}
}
