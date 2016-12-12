package com.school.project.gui.controller.settings;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.LanguageSettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.util.NetUtil;

public class LanguageSettingsController extends BaseController<LanguageSettingsView> {

	private String strErrorSelectALanguage, strErrorLoadLanguage;
	private String newLanguage;
	private HashMap<String, String> newWords;
	private LanguageHandler languageHandler;
	private DefaultTableModel model;

	public LanguageSettingsController(LanguageHandler lh) {
		super(new LanguageSettingsView());
		languageHandler = lh;
		newLanguage = null;
		newWords = null;
		strErrorSelectALanguage = "Error please select a language";
		strErrorLoadLanguage = "Error loading language";
		model = new DefaultTableModel();
		model.addColumn("Key");
		model.addColumn("Translation");
		view.getTblTranslated().setModel(model);
		
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
					
					for(String key : newWords.keySet()){
						String[] rowData = {from.get(key), newWords.get(key)};
						model.addRow(rowData);
					}
					view.getTblTranslated().setModel(model);
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
			for(int i = 0; i < model.getRowCount(); i++){
				if(newWords.get(model.getValueAt(i, 0)) != model.getValueAt(i, 1)){
					newWords.put((String)model.getValueAt(i, 0), (String) model.getValueAt(i, 1));
					System.out.println("Er werd iets aangepast");
				}
			}
			view.getScrollLst().setVisible(false);
			view.getTblTranslated();
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
