package com.school.project.gui.controller.settings;

import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.LayoutSettingsView;

public class LayoutSettingsController extends BaseController<LayoutSettingsView> {
	
	public LayoutSettingsController() {
		super(new LayoutSettingsView());
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
