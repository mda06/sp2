package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.school.project.dao.TicketDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.TicketEditorPanel;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;

public class TicketEditorController {
	private TicketEditorPanel pnl;
	private PaymentBackListener list;
	private Ticket ticket;
	private String strErrorFillIn, strSaveSuccess, strUpdateSuccess;

	public TicketEditorController(TicketEditorPanel pnl, PaymentBackListener list) {
		this.pnl = pnl;
		this.list = list;
		ticket = null;
		strErrorFillIn = "Error, please fill in all the fiels";
		strSaveSuccess = "Ticket saved";
		strUpdateSuccess = "Ticket updated";

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
				if(!isValid()) {
					JOptionPane.showMessageDialog(pnl, strErrorFillIn);
					return;
				}
				boolean newTicket = false;
				
				if(ticket == null){
					newTicket = true;
					ticket = new Ticket(0, "", "", 0, 0, true, false);
				}

				ticket.setPrice(Double.parseDouble(pnl.getTxtPrice().getText()));
				ticket.setName(pnl.getTxtName().getText());
				ticket.setDescription(pnl.getTxtDesc().getText());
				ticket.setHasFixedRoute(pnl.getCbHasFixedRoute().isSelected());

				if(!newTicket) {
					TicketDAO.getInstance().update(ticket);
					JOptionPane.showMessageDialog(pnl, strUpdateSuccess);
				} else {
					TicketDAO.getInstance().add(ticket);
					JOptionPane.showMessageDialog(pnl, strSaveSuccess);
				}
				
				TicketCache.getInstance().addTicket(ticket);
				
				ticket = null;
				pnl.getTxtDesc().setText("");
				pnl.getTxtName().setText("");
				pnl.getTxtPrice().setText("0");
				pnl.getCbHasFixedRoute().setSelected(false);
				list.backToPreviousView();
			}
		});
	}
	
	private boolean isValid() {
		if(pnl.getTxtName().getText().isEmpty()) return false;
		if(pnl.getTxtDesc().getText().isEmpty()) return false;
		try {
			Double.parseDouble(pnl.getTxtPrice().getText());
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void showTicket(Ticket t) {
		if (t == null)
			return;
		ticket = t;
		pnl.getTxtName().setText(ticket.getName());
		pnl.getTxtDesc().setText(ticket.getDescription());
		pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()));
		pnl.getCbHasFixedRoute().setSelected(ticket.isHasFixedRoute());
	}

	public void newTicket() {
		ticket = null;
		pnl.getTxtName().setText("");
		pnl.getTxtDesc().setText("");
		pnl.getTxtPrice().setText("");
		pnl.getCbHasFixedRoute().setSelected(false);
	}

}
