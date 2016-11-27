package com.school.project.gui.controller.settings;

import java.awt.Font;
import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.LayoutSettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.util.FontUtil;

import say.swing.JFontChooser;

public class LayoutSettingsController extends BaseController<LayoutSettingsView> {

	public LayoutSettingsController() {
		super(new LayoutSettingsView());
		initEvents();
	}

	private void initEvents() {
		view.getBtnFontBig().addActionListener((e) -> {
			JFontChooser fontChooser = new JFontChooser();
			fontChooser.setSelectedFont(FontUtil.getInstance().getBigFont());
			int result = fontChooser.showDialog(view);
			if (result == JFontChooser.OK_OPTION) {
				Font font = fontChooser.getSelectedFont();
				FontUtil.getInstance().setBigFont(font);
			}
		});
		view.getBtnFontSmall().addActionListener((e) -> {
			JFontChooser fontChooser = new JFontChooser();
			fontChooser.setSelectedFont(FontUtil.getInstance().getSmallFont());
			int result = fontChooser.showDialog(view);
			if (result == JFontChooser.OK_OPTION) {
				Font font = fontChooser.getSelectedFont();
				FontUtil.getInstance().setSmallFont(font);
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o). getLanguageHandler();
			view.getLblFontBig().setText(lh.getString("lblFontBig"));
			view.getLblFontSmall().setText(lh.getString("lblFontSmall"));
			view.getBtnFontBig().setText(lh.getString("btnFontBig"));
			view.getBtnFontSmall().setText(lh.getString("btnFontSmall"));
		}
	}

}
