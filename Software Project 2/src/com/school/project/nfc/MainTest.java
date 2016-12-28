package com.school.project.nfc;

import javax.smartcardio.CardException;

public class MainTest {
	public static void main(String[] args) {
		CardMifare1K card = Acr122Factory.getInstance().getMifare1K();
		try {
			card.print();
			card.getCard().disconnect(false);
		} catch (CardException e) {
			e.printStackTrace();
		}
	}
}
