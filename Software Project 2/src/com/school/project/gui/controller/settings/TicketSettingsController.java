package com.school.project.gui.controller.settings;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.controller.listener.CacheUpdateListener;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.TicketSettingsView;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;
import com.school.project.util.FontUtil;

public class TicketSettingsController extends BaseController<TicketSettingsView> implements PaymentBackListener, CacheUpdateListener<Ticket> {
	 
	private TicketEditorController tEdit;
	
	public TicketSettingsController() {
		super(new TicketSettingsView());
		tEdit = new TicketEditorController(view.getPnlTicketEditor(), this);
		initButtons();
		
	}
	
	private void initButtons() {
		TicketCache.getInstance().addListener(this);
		for(Ticket t : TicketCache.getInstance().getCache()) {
			addTicketToView(t);
		}
		
		view.getBtnNewticket().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showCard(view.KEY_EDIT);
				tEdit.newTicket();
			}
		});
	}
	
	private void addTicketToView(Ticket t) {
		if(t == null) return;
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

	@Override
	public void added(Ticket t) {
		addTicketToView(t);
	}

	@Override
	public void removed(Ticket t) {
		Component toRemove = null;
		for(Component c : view.getPnlBtns().getComponents()) {
			if(c instanceof JButton) {
				int id = Integer.parseInt(((JButton) c).getActionCommand());
				if(id == t.getId()) {
					toRemove = c;
					break;
				}
			}
		}
		if(toRemove != null) {
			view.getPnlBtns().remove(toRemove);
			view.getPnlBtns().invalidate();
		}
	}
}
