package com.school.project.gui.controller.settings;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.LanguageSettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.util.NetUtil;

public class LanguageSettingsController extends BaseController<LanguageSettingsView> {

	private String strErrorSelectALanguage, strErrorLoadLanguage;
	private String newLanguage;
	private HashMap<String, String> newWords;
	private LanguageHandler languageHandler;

	public LanguageSettingsController(LanguageHandler lh) {
		super(new LanguageSettingsView());
		languageHandler = lh;
		newLanguage = null;
		newWords = null;
		strErrorSelectALanguage = "Error please select a language";
		strErrorLoadLanguage = "Error loading language";
		initEvent();
	}

	private void initEvent() {
		view.getBtnLoad().addActionListener((e) -> {
			newLanguage = (String) view.getComboLanguages().getSelectedItem();
			if (newLanguage != null && !newLanguage.isEmpty()) {
				view.getBtnLoad().setEnabled(false);
				view.getComboLanguages().setEnabled(false);
				view.getLblLoading().setVisible(true);
				
				new Thread(() -> {
					newWords = new HashMap<>();
					try {
						HashMap<String, String> en = languageHandler.getWords().get("en");
						for (Entry<String, String> entry : en.entrySet()) {
							String translated = NetUtil.translateWord(entry.getValue(),  "en-" + newLanguage);
							newWords.put(entry.getKey(), translated);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(view, strErrorLoadLanguage);
					} finally {
						view.getBtnLoad().setEnabled(true);
						view.getComboLanguages().setEnabled(true);
						view.getLblLoading().setVisible(false);
					}
					
					view.getScrollLst().setVisible(true);
					HashMap<String, String> from = languageHandler.getWords().get(languageHandler.getCurrentLanguage());
					String[] lst = new String[newWords.size()];
					for(int i = 0; i < newWords.size(); i++)
						lst[i] = from.values().toArray()[i] + " -> " + newWords.values().toArray()[i];
					view.getLstTranslated().setListData(lst);
					view.getBtnSave().setVisible(true);
				}).start();
			} else {
				JOptionPane.showMessageDialog(view, strErrorSelectALanguage);
			}
		});
		
		view.getBtnSave().addActionListener((ev) -> {
			if(newLanguage == null || newWords == null) {
				return;
			}
			view.getScrollLst().setVisible(false);
			view.getLstTranslated().setListData(new String[0]);
			view.getBtnSave().setVisible(false);
			languageHandler.addNewLanguage(newLanguage, newWords);
			languageHandler.setLanguage(newLanguage);
			newLanguage = null;
			newWords = null;
		});
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
