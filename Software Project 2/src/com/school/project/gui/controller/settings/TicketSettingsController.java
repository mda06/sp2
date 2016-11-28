package com.school.project.gui.controller.settings;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.TicketSettingsView;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;
import com.school.project.util.FontUtil;

public class TicketSettingsController extends BaseController<TicketSettingsView> implements PaymentBackListener {
	 
	private TicketEditorController tEdit;
	
	public TicketSettingsController() {
		super(new TicketSettingsView());
		tEdit = new TicketEditorController(view.getPnlTicketEditor(), this);
		initButtons();
		
	}
	
	private void initButtons() {
		for(Ticket t : TicketCache.getInstance().getCache()) {
			JButton btn = new JButton(t.getName());
			view.getPnlBtns().add(btn);

			FontUtil.getInstance().bindSmallFont(btn);
			btn.setActionCommand(String.valueOf(t.getId()));
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ticket t = TicketCache.getInstance().getTicket(Integer.parseInt(e.getActionCommand()));
					showCard(view.KEY_EDIT);
					tEdit.showTicket(t);
				}
			});
		}
		
		view.getBtnNewticket().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showCard(view.KEY_EDIT);
				tEdit.newTicket();
			}
		});
	}
	
	private void showCard(String key) {
		CardLayout card = (CardLayout)view.getLayout();
		card.show(view, key);
	}

	@Override
	public void update(Observable o, Object arg) {
		tEdit.update(o, arg);
	}
	
	@Override
	public void backToPreviousView() {
		showCard(view.KEY_BTNS);
	}
}
