package com.school.project.nfc.runnable;

import java.security.InvalidParameterException;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;

import com.school.project.nfc.event.CardConnected;

public class CardConnectedRunnable implements Runnable {

	private CardConnected cc;
	private CardTerminal terminal;
	private boolean running;
	private boolean isConnected;

	public CardConnectedRunnable(CardConnected cc, CardTerminal t) {
		this.cc = cc;
		terminal = t;
		running = true;
		if (cc == null || t == null) throw new InvalidParameterException();
	}
	
	public void kill() {
		running = false;
	}

	@Override
	public void run() {
		while (running) {
			try {
				boolean cardThere = terminal.waitForCardPresent(500);
				if(!isConnected && cardThere) 
					cc.cardConnected(null);
				
				isConnected = cardThere;
			} catch (CardException e) {
				// We don't want to print each 500ms a error msg...
			}
		}
	}
}
