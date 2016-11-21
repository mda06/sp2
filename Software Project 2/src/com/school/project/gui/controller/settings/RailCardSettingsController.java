package com.school.project.gui.controller.settings;

import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.RailCardSettingsView;

public class RailCardSettingsController extends BaseController<RailCardSettingsView> {
	
	public RailCardSettingsController() {
		super(new RailCardSettingsView());
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
