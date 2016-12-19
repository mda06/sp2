package com.school.project.gui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.school.project.gui.controller.settings.BackupController;
import com.school.project.gui.controller.settings.LanguageSettingsController;
import com.school.project.gui.controller.settings.LayoutSettingsController;
import com.school.project.gui.controller.settings.NFCSettingsController;
import com.school.project.gui.controller.settings.RailCardSettingsController;
import com.school.project.gui.controller.settings.TicketPriceEditorController;
import com.school.project.gui.controller.settings.TicketSettingsController;
import com.school.project.gui.view.SettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class SettingsController extends BaseController<SettingsView> {
	private LanguageObservable observable;
	private List<BaseController<?>> controllers;

	public SettingsController(LanguageObservable obs) {
		super(new SettingsView());
		observable = obs;
		controllers = new ArrayList<BaseController<?>>();
		initSettings();
	}

	private void initSettings() {
		addSetting(new TicketSettingsController());
		addSetting(new RailCardSettingsController());
		addSetting(new LayoutSettingsController());
		addSetting(new LanguageSettingsController(observable.getLanguageHandler()));
		addSetting(new BackupController());
		addSetting(new NFCSettingsController());
		addSetting(new TicketPriceEditorController());
	}

	private void addSetting(BaseController<?> bc) {
		controllers.add(bc);
		view.getTabbedPane().add(bc.getBaseView().CARD_KEY, bc.getBaseView());
		observable.addObserver(bc);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
			int tabCounts = view.getTabbedPane().getTabCount();
			for(int i = 0; i < tabCounts; i++){
				String str = "";
				if(i == 0) str ="TicketSettings";
				else if (i == 1) str = "RailcardSettings";
				else if (i == 2) str = "LayoutSettings";
				else if (i == 3) str = "LanguageSettings";
				else if (i == 4) str = "Backup";
				else if (i == 5) str = "NFCSettings";
				else if (i == 6) str = "TicketPrice";
				view.getTabbedPane().setTitleAt(i, lh.getString(str));
			}
		}
	}
	
	@Override
	public void show() {
		controllers.forEach((c) -> c.show());
	}
	
	@Override
	public void hide() {
		controllers.forEach((c) -> c.hide());
	}
}
