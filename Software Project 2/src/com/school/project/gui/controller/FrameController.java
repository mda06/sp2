package com.school.project.gui.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.school.project.gui.controller.listener.DisconnectListener;
import com.school.project.gui.controller.listener.LanguageActionListener;
import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.FrameView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.util.FontUtil;

public class FrameController implements Observer {
	private FrameView frame;
	private LanguageObservable languageObservable;
	private ArrayList<String> lstCardKeys;
	private HashMap<BaseView, BaseController<?>> controllers;
	private Color oldButtonColor;
	private DisconnectListener disconnectListener;

	public FrameController(LanguageObservable languageObservable, DisconnectListener disconnectListener) {
		frame = new FrameView();
		this.disconnectListener = disconnectListener;
		this.oldButtonColor = null;
		this.languageObservable = languageObservable;
		lstCardKeys = new ArrayList<String>();
		controllers = new HashMap<>();
		initLanguageEvents();
		initDisconnectEvent();
	}
	
	private void initDisconnectEvent() {
		frame.getMnDisconnect().addActionListener((e) -> disconnectListener.disconnect());
	}

	private void initLanguageEvents() {
		LanguageActionListener ll = new LanguageActionListener(languageObservable);
		for(String l : languageObservable.getLanguageHandler().getLanguages()) {
			JMenuItem mi = new JMenuItem(l);
			mi.setActionCommand(l);
			mi.addActionListener(ll);
			frame.getMenuOptions().add(mi);
		}
	}

	public void addCard(BaseController<?> controller) {
		final String KEY = controller.getBaseView().CARD_KEY;
		JButton btn = new JButton(KEY);
		FontUtil.getInstance().bindSmallFont(btn);
		if(oldButtonColor == null){
			oldButtonColor = btn.getBackground();
		}
		btn.setActionCommand(KEY);
		lstCardKeys.add(KEY);
		frame.getPanelBtns().add(btn);
		frame.getPanelCard().add(controller.getBaseView(), KEY);
		controllers.put(controller.getBaseView(), controller);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() != null) {
					String key = e.getActionCommand();
					// Check if the key is present before else we can get an
					// exception
					for (String str : lstCardKeys) {
						if (str.equals(key)) {
							BaseController<?> bc = controllers.get(getCurrentCard());
							if(bc != null) 
								bc.hide();
							((CardLayout) frame.getPanelCard().getLayout()).show(frame.getPanelCard(), key);
							bc = controllers.get(getCurrentCard());
							if(bc != null)
								bc.show();
							break;
						}
					}
					// Change color of the button
					update(languageObservable, frame);
					btn.setBackground(new Color(50, 111, 209));
				}
			}
		});
	}

	private BaseView getCurrentCard() {
		BaseView card = null;
		for (Component comp : frame.getPanelCard().getComponents()) {
			if (comp.isVisible() == true) {
				card = (BaseView) comp;
			}
		}
		return card;
	}

	@Override
	public void update(Observable observable, Object obj) {
		if (observable instanceof LanguageObservable) {
			LanguageHandler handler = ((LanguageObservable) observable).getLanguageHandler();
			frame.getMenuOptions().setText(handler.getString("options"));
			frame.getMenuFile().setText(handler.getString("file"));
			frame.getMnDisconnect().setText(handler.getString("disconnect"));
			for (Component c : frame.getPanelBtns().getComponents()) {
				if (c instanceof JButton) {
					JButton btn = (JButton) c;
					String acc = btn.getActionCommand();
					btn.setText(handler.getString(acc));
					btn.setBackground(this.oldButtonColor);
				}
			}
		}
	}

	public FrameView getFrameView() {
		return frame;
	}
}
