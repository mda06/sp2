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
import com.school.project.model.TicketSaleOfflineCache;
import com.school.project.model.User;
import com.school.project.nmbs.model.Station;
import com.school.project.nmbs.model.StationCache;
import com.school.project.util.NetUtil;
import com.school.project.util.PriceUtil;

public class TicketSaleController {
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
				double price = getPrice();
			
				if (ticket.isHasFixedRoute() && (from.isEmpty() || to.isEmpty())) {
					JOptionPane.showMessageDialog(pnl, "Please enter from and to stations");
				} else {
					TicketSale sale = new TicketSale(-1, validFrom, validTo, soldOn, from, to, false, ticket, user, price);
					if(NetUtil.hasInternet()) {
						TicketSaleDAO.getInstance().add(sale);
						TicketSaleOfflineCache.getInstance().saveCache();
					} else {
						JOptionPane.showMessageDialog(pnl, "No internet available, ticket is cached offline");
						TicketSaleOfflineCache.getInstance().add(sale);
					}
					list.backToPreviousView();
				}
			}
		});

		ActionListener actionPrice = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double price = getPrice();
				if(ticket.isHasFixedRoute()) {
					pnl.getTxtPrice().setText(String.format("%1.2f  €", price));
				} else {
					String addToPrice = "€ / KM";
					if (!ticket.isHasFixedRoute()) addToPrice = " €";
					pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()) + addToPrice);
				}
			}
		};

		pnl.getTxtFromStation().addActionListener(actionPrice);
		pnl.getTxtToStation().addActionListener(actionPrice);
	}
	
	private double getPrice() {
		String from = pnl.getTxtFromStation().getText();
		String to = pnl.getTxtToStation().getText();
		double price = 0;
		if (!from.isEmpty() && !to.isEmpty()) {
			Station s1 = StationCache.getInstance().getStationWithName(from);
			Station s2 = StationCache.getInstance().getStationWithName(to);

			if (s1 != null && s2 != null) {
				price = PriceUtil.getPrice(s1, s2, ticket);
			}
		}
		return price;
	}

	public void showTicket(Ticket t) {
		if (t == null) return;
		ticket = t;
		pnl.getTxtName().setText(ticket.getName());
		pnl.getTxtDesc().setText(ticket.getDescription());
		String addToPrice = "€ / KM";
		if (!ticket.isHasFixedRoute()) 
			addToPrice = " €";
		pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()) + addToPrice);
		pnl.getTxtValidFrom().setText(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(Calendar.DATE, ticket.getValidityPeriod());
		pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
		pnl.getTxtSoldBy().setText(user.getFirstName() + " " + user.getLastName());
		pnl.getTxtToStation().setText("");
		pnl.getTxtFromStation().setText("");
		if (ticket.isHasFixedRoute()) {
			pnl.getTxtToStation().setEnabled(true);
			pnl.getTxtFromStation().setEnabled(true);
		} else {
			pnl.getTxtToStation().setEnabled(false);
			pnl.getTxtFromStation().setEnabled(false);
		}
	}

}
