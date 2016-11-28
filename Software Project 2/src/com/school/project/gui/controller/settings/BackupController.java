package com.school.project.gui.controller.settings;

import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.BackupView;

public class BackupController extends BaseController<BackupView>{

	public BackupController() {
		super(new BackupView());
		initEvents();
	}

	private void initEvents(){
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

}
