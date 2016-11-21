package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.gui.controller.settings.LayoutSettingsController;
import com.school.project.gui.controller.settings.RailCardSettingsController;
import com.school.project.gui.controller.settings.TicketSettingsController;
import com.school.project.gui.view.SettingsView;
import com.school.project.language.LanguageObservable;

public class SettingsController extends BaseController<SettingsView>{
	private LanguageObservable observable;
	
	public SettingsController(LanguageObservable obs) {
		super(new SettingsView());
		observable = obs;
		initSettings();
	}
	
	private void initSettings() {
		addSetting(new TicketSettingsController());
		addSetting(new RailCardSettingsController());
		addSetting(new LayoutSettingsController());
	}
	
	private void addSetting(BaseController<?> bc) {
		view.getTabbedPane().add(bc.getBaseView().CARD_KEY, bc.getBaseView());
		observable.addObserver(bc);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
