package com.school.project.nfc.event;

import com.school.project.nfc.CardMifare1K;

public interface CardConnected {
	void cardConnected(CardMifare1K c);
}
