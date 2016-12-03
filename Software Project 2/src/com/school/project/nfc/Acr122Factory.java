package com.school.project.nfc;

import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

public class Acr122Factory {
	private static Acr122Factory instance;	
	
	private CardTerminal terminal;
	private byte keyNumber;
	private byte keyType;
	
	private Acr122Factory() {
		keyNumber = KEY_LOCATION.ZERO.getValue(); 
		keyType = KEY_TYPE.A.getValue(); 
	}
	
	public static Acr122Factory getInstance() {
		if(instance == null) instance = new Acr122Factory();
		return instance;
	}
	
	public void setKeyNumber(KEY_LOCATION loc) {
		keyNumber = loc.getValue();
	}
	
	public void setKeyType(KEY_TYPE type) {
		keyType = type.getValue();
	}
	
	public byte getKeyNumber() {
		return keyNumber;
	}
	
	public byte getKeyType() {
		return keyType;
	}
	
	public CardTerminal getAcr122() {
		if(terminal != null) return terminal;
		
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminals = factory.terminals().list();
			terminal = terminals.get(0);
		} catch (CardException e) {
			e.printStackTrace();
			terminal = null;
		}
		return terminal;
	}
	
	public CardMifare1K getMifare1K() {
		CardTerminal t = getAcr122();
		if(t == null) return null;
		
		CardMifare1K c = null;
		try {
			c = new CardMifare1K(t.connect("*"), keyNumber, keyType);
		} catch (CardException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
}
