package com.school.project.gui.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.RailCardView;
import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;
import com.school.project.model.User;

public class RailCardController extends BaseController<RailCardView> implements PaymentBackListener {
	
	private ActiveRailCardController railcardController;
	
	public RailCardController(User connectedUser) {
		super(new RailCardView());
		
		railcardController = new ActiveRailCardController(view.getPnlPay(), this, connectedUser);
		initButtons();
	}

	private void initButtons() {
		for(RailCard rc : RailCardCache.getInstance().getCache()){
			JButton btn = new JButton(rc.getName());
			btn.setActionCommand(String.valueOf(rc.getId()));
			view.getPnlBtns().add(btn);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					RailCard rc = RailCardCache.getInstance().getRailCard(Integer.parseInt(e.getActionCommand()));
					showCard(view.KEY_PAY);
					railcardController.showRailCard(rc);
				}
			});
		}
	}
	private void showCard(String key) {
		CardLayout card = (CardLayout)view.getLayout();
		card.show(view, key);
	}
	
	@Override
	public void backToPreviousView() {
		showCard(view.KEY_BTNS);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		railcardController.update(o, arg);
	}
}