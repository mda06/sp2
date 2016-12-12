package com.school.project.nfc;

import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

import com.school.project.nfc.event.CardConnected;
import com.school.project.nfc.runnable.CardConnectedRunnable;

public class Acr122Factory implements CardConnected {
	private static Acr122Factory instance;	
	
	private CardTerminal terminal;
	private List<CardConnected> listeners;
	private CardConnectedRunnable listenersRunnable;
	private byte keyNumber;
	private byte keyType;
	
	private Acr122Factory() {
		keyNumber = KEY_LOCATION.ONE.getValue(); 
		keyType = KEY_TYPE.A.getValue(); 
		listeners = new ArrayList<>();
	}
	
	public static Acr122Factory getInstance() {
		if(instance == null) instance = new Acr122Factory();
		return instance;
	}
	
	public void addCardListener(CardConnected cc) {
		if(cc != null)
			listeners.add(cc);
	}
	
	public void removeCardListener(CardConnected cc) {
		if(cc != null)
			listeners.remove(cc);
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
	
	public void loadListeners() {
		getAcr122();
	}
	
	public CardTerminal getAcr122() {
		if(terminal != null) return terminal;
		
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminals = factory.terminals().list();
			terminal = terminals.get(0);
			
			if(listenersRunnable != null)
				listenersRunnable.kill();
			listenersRunnable = new CardConnectedRunnable(this, terminal);
			new Thread(listenersRunnable).start();;
		} catch (Exception e) {
			e.printStackTrace();
			listeners.clear();
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

	@Override
	public void cardConnected(CardMifare1K c) {
		listeners.stream().forEach((lst) -> lst.cardConnected(getMifare1K()));
	}
	
}
