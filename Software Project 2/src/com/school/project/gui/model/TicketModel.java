package com.school.project.gui.model;

import java.util.Observable;
import java.util.Observer;

import com.school.project.gui.view.TicketView;

public class TicketModel implements Observer {
	@SuppressWarnings("unused")
	private TicketView view;

	public TicketModel(TicketView view) {
		this.view = view;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
