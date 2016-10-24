package com.school.project.gui.controller;

import com.school.project.gui.model.TicketModel;
import com.school.project.gui.view.TicketView;

public class TicketController {
	@SuppressWarnings("unused")
	private TicketModel model;
	@SuppressWarnings("unused")
	private TicketView view;

	public TicketController(TicketModel model, TicketView view) {
		this.model = model;
		this.view = view;
	}
}
