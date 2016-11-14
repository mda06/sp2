package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.PaymentPanelRailcard;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;
import com.school.project.nmbs.model.StationCache;

public class ActiveRailCardController {
	private PaymentPanelRailcard pnl;
	private PaymentBackListener list;
	private RailCard railcard;
	private User user;
	public ActiveRailCardController(PaymentPanelRailcard pnl, PaymentBackListener list, User user) {
		this.pnl = pnl;
		this.list = list;
		this.user = user;
		this.railcard = null;
		
		pnl.getTxtFromStation().setItems(StationCache.getInstance().getStationsNames());
		pnl.getTxtToStation().setItems(StationCache.getInstance().getStationsNames());
		
		initEvents();
	}
	
	private void initEvents(){
		pnl.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.backToPreviousView();
			}
		});
		
		pnl.getBtnPay().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String from = pnl.getTxtFromStation().getText();
				String to = pnl.getTxtToStation().getText();
				Date validFrom = new Date(new java.util.Date().getTime());
				Date soldOn = new Date(new java.util.Date().getTime());
				Calendar cal = Calendar.getInstance();
				cal.setTime(new java.util.Date());
				//cal.add(Calendar.DATE, railcard.getValidityPeriod());
				Date validTo = new Date(cal.getTime().getTime());
				
				if(railcard.isHasFixedRoute() && (from.isEmpty() || to.isEmpty())) {
					JOptionPane.showMessageDialog(pnl, "Please enter from and to stations");
				}
				else if(pnl.getRdPricePerMonth().isSelected() == false && pnl.getRdPricePer3Month().isSelected() == false && pnl.getRdPricePerYear().isSelected() == false){
					JOptionPane.showMessageDialog(pnl, "Please select a time period");
				}
				else{
					ActiveRailCard activeRailCard = new ActiveRailCard(-1, validFrom, validTo, from, to, user, user, railcard, false);
					ActiveRailCardDAO.getInstance().add(activeRailCard);
					list.backToPreviousView();
				}
			}
		});
	}
	
	public void showRailCard(RailCard r){
		if(r == null) return;
		railcard = r;
		pnl.getTxtName().setText(railcard.getName());
		pnl.getTxtDesc().setText(railcard.getDescription());
		pnl.getRdPricePerMonth().setText(String.valueOf(railcard.getPricePerMonth()));
		pnl.getRdPricePer3Month().setText(String.valueOf(railcard.getPricePer3Month()));
		pnl.getRdPricePerYear().setText(String.valueOf(railcard.getPricePerYear()));
		pnl.getTxtValidFrom().setText(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		//cal.add(Calendar.DATE, railcard.getValidityPeriod());
		pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
		pnl.getTxtSoldBy().setText(user.getFirstName() + " " + user.getLastName());
		pnl.getTxtToStation().setText("");
		pnl.getTxtFromStation().setText("");
		if(railcard.isHasFixedRoute()){
			pnl.getTxtToStation().setEnabled(true);
			pnl.getTxtFromStation().setEnabled(true);
		}
		else{
			pnl.getTxtToStation().setEnabled(false);
			pnl.getTxtFromStation().setEnabled(false);
		}
	}
	
}
