package com.school.project.gui.controller.settings;

import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.TicketSettingsView;

public class TicketSettingsController extends BaseController<TicketSettingsView> {
	  
	public TicketSettingsController() {
		super(new TicketSettingsView());
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
