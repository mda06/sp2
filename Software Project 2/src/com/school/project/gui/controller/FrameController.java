package com.school.project.gui.controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.school.project.gui.controller.listener.LanguageListener;
import com.school.project.gui.view.FrameView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class FrameController implements ActionListener, Observer {
	private FrameView frame;
	private LanguageObservable languageObservable;
	private ArrayList<String> lstCardKeys;
	
	public FrameController(LanguageObservable languageObservable) {
		frame = new FrameView();
		this.languageObservable = languageObservable;
		lstCardKeys = new ArrayList<String>();
		initLanguageEvents();
	}

	private void initLanguageEvents(){
		LanguageListener ll = new LanguageListener(frame, languageObservable);
		frame.getMiEn().addActionListener(ll);
		frame.getMiFr().addActionListener(ll);
		frame.getMiNl().addActionListener(ll);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != null) {
			String key = e.getActionCommand();
			//Check if the key is present before else we can get an exception
			for(String str : lstCardKeys){
				if(str.equals(key)) {
					((CardLayout)frame.getPanelCard().getLayout()).show(frame.getPanelCard(), key);
					break;
				}
			}
		}
	}
	
	public void addCard(BaseController<?> controller) {
		final String KEY = controller.getBaseView().CARD_KEY; 
		JButton btn = new JButton(KEY);
		btn.addActionListener(this);
		btn.setActionCommand(KEY);
		lstCardKeys.add(KEY);
		frame.getPanelBtns().add(btn);
		frame.getPanelCard().add(controller.getBaseView(), KEY);
	}
	
	@Override
	public void update(Observable observable, Object obj) {
		if(observable instanceof LanguageObservable){
			LanguageHandler handler = ((LanguageObservable)observable).getLanguageHandler();
			frame.getMenuOptions().setText(handler.getString("options"));
			for(Component c : frame.getPanelBtns().getComponents()) {
				if(c instanceof JButton) {
					JButton btn = (JButton)c;
					String acc = btn.getActionCommand();
					btn.setText(handler.getString(acc));
				}
			}
		}		
	}
	
	public FrameView getFrameView() {
		return frame;
	}
}