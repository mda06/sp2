package com.school.project.gui.controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.PaymentPanel;
import com.school.project.model.Ticket;
import com.school.project.model.TicketSale;
import com.school.project.model.User;
import com.school.project.nmbs.model.StationCache;

public class TicketSaleController{
	private PaymentPanel pnl;
	private PaymentBackListener list;
	private Ticket ticket;
	private User user;
	
	public TicketSaleController(PaymentPanel pnl, PaymentBackListener lst, User user) {
		this.pnl = pnl;
		this.list = lst;
		this.user = user;
		ticket = null;

		pnl.getTxtFromStation().setItems(StationCache.getInstance().getStationsNames());
		pnl.getTxtToStation().setItems(StationCache.getInstance().getStationsNames());
		
		initEvents();
	}
	
	private void initEvents() {
		pnl.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.backToPreviousView();
			}
		});
		
		pnl.getBtnPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = pnl.getTxtFromStation().getText();
				String to = pnl.getTxtToStation().getText();
				Date validFrom = new Date(new java.util.Date().getTime());
				Date soldOn = new Date(new java.util.Date().getTime());
				Calendar cal = Calendar.getInstance();
				cal.setTime(new java.util.Date());
				cal.add(Calendar.DATE, ticket.getValidityPeriod());
				Date validTo = new Date(cal.getTime().getTime());
				
				if(ticket.isHasFixedRoute() && (from.isEmpty() || to.isEmpty())) {
					JOptionPane.showMessageDialog(pnl, "Please enter from and to stations");
				} else {
					TicketSale sale = new TicketSale(-1, validFrom, validTo, soldOn, from, to, false, ticket, user);
					TicketSaleDAO.getInstance().add(sale);
					list.backToPreviousView();
				}
			}
		});
	}
	
	public void showTicket(Ticket t) {
		if(t == null) return;
		ticket = t;
		pnl.getTxtName().setText(ticket.getName());
		pnl.getTxtDesc().setText(ticket.getDescription());
		pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()));
		pnl.getTxtValidFrom().setText(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(Calendar.DATE, ticket.getValidityPeriod());
		pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
		pnl.getTxtSoldBy().setText(user.getFirstName() + " " + user.getLastName());
		pnl.getTxtToStation().setText("");
		pnl.getTxtFromStation().setText("");
		if(ticket.isHasFixedRoute()) {
			pnl.getTxtToStation().setEnabled(true);
			pnl.getTxtFromStation().setEnabled(true);
		} else {
			pnl.getTxtToStation().setEnabled(false);
			pnl.getTxtFromStation().setEnabled(false);
		}
	}

}
