package com.school.project.gui.controller.settings;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.RailCardSettingsView;
import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;
import com.school.project.util.FontUtil;

public class RailCardSettingsController extends BaseController<RailCardSettingsView> implements PaymentBackListener{
	
	RailCardEditorController rcEdit;
	
	public RailCardSettingsController() {
		super(new RailCardSettingsView());
		
		rcEdit = new RailCardEditorController(view.getPnlRailCardEditor(), this);
		initButtons();
	}
	
	private void initButtons() {
		for(RailCard rc : RailCardCache.getInstance().getCache()){
			JButton btn = new JButton(rc.getName());
			btn.setActionCommand(String.valueOf(rc.getId()));
			view.getPnlBtns().add(btn);
			FontUtil.getInstance().bindSmallFont(btn);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					RailCard rc = RailCardCache.getInstance().getRailCard(Integer.parseInt(e.getActionCommand()));
					showCard(view.KEY_EDIT);
					rcEdit.showRailCard(rc);
				}
			});
		}
		view.getBtnNewRailCard().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showCard(view.KEY_EDIT);
				rcEdit.newTicket();
			}
		});
	}

	
	private void showCard(String key) {
		CardLayout card = (CardLayout)view.getLayout();
		card.show(view, key);
	}

	@Override
	public void update(Observable o, Object arg) {
		rcEdit.update(o, arg);
	}
	
	@Override
	public void backToPreviousView() {
		showCard(view.KEY_BTNS);
	}
}
