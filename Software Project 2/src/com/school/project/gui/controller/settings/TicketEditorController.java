package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.school.project.dao.TicketDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.TicketEditorPanel;
import com.school.project.model.Ticket;

public class TicketEditorController {
	private TicketEditorPanel pnl;
	private PaymentBackListener list;
	private Ticket ticket;

	public TicketEditorController(TicketEditorPanel pnl, PaymentBackListener list) {
		this.pnl = pnl;
		this.list = list;
		ticket = null;

		initEvents();
	}

	private void initEvents() {
		pnl.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.backToPreviousView();
			}
		});

		pnl.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean newTicket = false;
				
				if(ticket == null){
					newTicket = true;
					ticket = new Ticket(0, "", "", 0, 0, true, false);
				}
				// TODO: catch parsing errors & safe input
				ticket.setPrice(Double.parseDouble(pnl.getTxtPrice().getText()));
				ticket.setDescription(pnl.getTxtDesc().getText());
				ticket.setHasFixedRoute(pnl.getCbHasFixedRoute().isSelected());

				if(!newTicket) TicketDAO.getInstance().update(ticket);
				else TicketDAO.getInstance().add(ticket);

			}
		});
	}

	public void showTicket(Ticket t) {
		if (t == null)
			return;
		ticket = t;
		pnl.getTxtName().setText(ticket.getName());
		pnl.getTxtDesc().setText(ticket.getDescription());
		pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()));
	}

	public void newTicket() {
		ticket = null;
		pnl.getTxtName().setText("");
		pnl.getTxtDesc().setText("");
		pnl.getTxtPrice().setText("");
	}

}
