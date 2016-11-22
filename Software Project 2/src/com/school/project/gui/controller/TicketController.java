package com.school.project.gui.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.TicketView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;
import com.school.project.model.User;
import com.school.project.util.FontUtil;

public class TicketController extends BaseController<TicketView> implements PaymentBackListener {

	private TicketSaleController ticketSale;
	
	public TicketController(User user) {
		super(new TicketView());
		ticketSale = new TicketSaleController(view.getPnlPayment(), this, user);
		
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
					showCard(view.KEY_PAY);
					ticketSale.showTicket(t);
				}
			});
		}
	}

	private void showCard(String key) {
		CardLayout card = (CardLayout)view.getLayout();
		card.show(view, key);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o). getLanguageHandler();
			view.getPnlPayment().getBtnBack().setText(lh.getString("back"));
			view.getPnlPayment().getLblName().setText(lh.getString("name"));
			view.getPnlPayment().getLblSoldBy().setText(lh.getString("soldBy"));
			view.getPnlPayment().getLblDesc().setText(lh.getString("description"));
			view.getPnlPayment().getLblFromStation().setText(lh.getString("from"));
			view.getPnlPayment().getLblToStation().setText(lh.getString("to"));
			view.getPnlPayment().getLblPrice().setText(lh.getString("price"));
			view.getPnlPayment().getLblValidFrom().setText(lh.getString("validFrom"));
			view.getPnlPayment().getLblValidTo().setText(lh.getString("validTo"));
			view.getPnlPayment().getBtnPay().setText(lh.getString("Pay"));
			
		}
	}

	@Override
	public void backToPreviousView() {
		showCard(view.KEY_BTNS);
	}
}
