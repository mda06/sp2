package com.school.project.gui.controller;

import java.util.Observable;

import com.school.project.gui.controller.settings.BackupController;
import com.school.project.gui.controller.settings.LanguageSettingsController;
import com.school.project.gui.controller.settings.LayoutSettingsController;
import com.school.project.gui.controller.settings.RailCardSettingsController;
import com.school.project.gui.controller.settings.TicketSettingsController;
import com.school.project.gui.view.SettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class SettingsController extends BaseController<SettingsView> {
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
		addSetting(new LanguageSettingsController(observable.getLanguageHandler()));
		addSetting(new BackupController());
	}

	private void addSetting(BaseController<?> bc) {
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
				view.getTabbedPane().setTitleAt(i, lh.getString(str));
			}
		}
	}
}
