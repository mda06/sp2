package com.school.project.language;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;



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
		//source: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
		try {
			File fXmlFile = new File("./res/languages.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			
			//DTD validation source: http://stackoverflow.com/questions/8699620/how-to-validate-xml-with-dtd-using-java
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
			
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList stringNodes = doc.getElementsByTagName("string");
			
			for(int i = 0; i < stringNodes.getLength(); i ++){
				Element stringEl = (Element) stringNodes.item(i);
				String key = stringEl.getAttribute("name");
				NodeList valueNodes = stringEl.getElementsByTagName("value");
				for(int j = 0; j < valueNodes.getLength(); j ++){
					Element valueEl = (Element) valueNodes.item(j);
					Language lang = Language.valueOf(valueEl.getAttribute("lang").toUpperCase());
					if(!valueEl.getTextContent().isEmpty()) //DTD checkt niet alles
						words.get(lang).put(key,valueEl.getTextContent());
					else
						words.get(lang).put(key, "!"+key);
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}
	
	public void setLanguage(Language l) {
		currentLanguage = l;
		observable.languageChanged();
	}
	
	public String getString(String key) {
		return words.get(currentLanguage).get(key);
	}

	public void setLanguageObservable(LanguageObservable languageObservable) {
		observable = languageObservable;
	}
}
