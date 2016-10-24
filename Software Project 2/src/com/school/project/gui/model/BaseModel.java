package com.school.project.gui.model;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.school.project.gui.events.AddCardListener;
import com.school.project.gui.view.BaseFrame;
import com.school.project.gui.view.BaseView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class BaseModel implements Observer{
	private BaseFrame view;
	private ArrayList<String> lstCardKeys;
	private AddCardListener addCardListener;
	
	public BaseModel(BaseFrame view) {
		this.view = view;
		lstCardKeys = new ArrayList<String>();
		addCardListener = null;
	}

	public void addCard(BaseView bv) {
		JButton btn = new JButton(bv.CARD_KEY);
		btn.setActionCommand(bv.CARD_KEY);
		lstCardKeys.add(bv.CARD_KEY);
		view.getPanelBtns().add(btn);
		view.getPanelCard().add(bv, bv.CARD_KEY);
		if(addCardListener != null)
			addCardListener.addCard(btn);
	}
	
	public boolean showCard(String key) {
		//Check if the key is present before else we can get an exception
		for(String str : lstCardKeys){
			if(str.equals(key)) {
				((CardLayout)view.getPanelCard().getLayout()).show(view.getPanelCard(), key);
				return true;
			}
		}
		
		return false;
	}
	
	public void setAddCardListener(AddCardListener list) {
		addCardListener = list;
	}

	@Override
	public void update(Observable observable, Object obj) {
		if(observable instanceof LanguageObservable){
			LanguageHandler handler = ((LanguageObservable)observable).getLanguageHandler();
			view.getMenuOptions().setText(handler.getString("options"));
			for(Component c : view.getPanelBtns().getComponents()) {
				if(c instanceof JButton) {
					JButton btn = (JButton)c;
					String acc = btn.getActionCommand();
					btn.setText(handler.getString(acc));
				}
			}
		}		
	}
	
}
