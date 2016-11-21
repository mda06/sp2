package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.view.PaymentRailcardPanel;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;
import com.school.project.nmbs.model.StationCache;

public class ActiveRailCardController implements SelectedUserListener, Observer{
	private PaymentRailcardPanel pnl;
	private PaymentBackListener list;
	private RailCard railcard;
	private User user, inNameOf;
	private SelectUserController selectUserController;

	public ActiveRailCardController(PaymentRailcardPanel pnl, PaymentBackListener list, User user) {
		this.pnl = pnl;
		this.list = list;
		this.user = user;
		this.railcard = null;
		inNameOf = null;
		selectUserController = new SelectUserController(this);
		
		pnl.getTxtFromStation().setItems(StationCache.getInstance().getStationsNames());
		pnl.getTxtToStation().setItems(StationCache.getInstance().getStationsNames());

		initEvents();
	}

	private void initEvents() {
		pnl.getBtnSelectUser().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUserController.showPopup();
			}
		});
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
				Date validTo = new Date(getValidityPeriod().getTime().getTime());

				if(inNameOf == null) {
					JOptionPane.showMessageDialog(pnl, "Please enter a user");
				} else if (railcard.isHasFixedRoute() && (from.isEmpty() || to.isEmpty())) {
					JOptionPane.showMessageDialog(pnl, "Please enter from and to stations");
				} else {
					ActiveRailCard activeRailCard = new ActiveRailCard(-1, validFrom, validTo, from, to, user, inNameOf, railcard, false);
					ActiveRailCardDAO.getInstance().add(activeRailCard);
					list.backToPreviousView();
				}
			}
		});

		for (int i = 0; i < pnl.getTimePeriod().getButtonCount(); i++) {
			JRadioButton btn = (JRadioButton) pnl.getTimePeriod().getElements().nextElement();
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(new java.util.Date());
					if (btn == pnl.getRdPricePer3Month()) {
						cal.add(Calendar.DATE, 3);
					} else if (btn == pnl.getRdPricePerMonth()) {
						cal.add(Calendar.DATE, 1);
					} else {
						cal.add(Calendar.DATE, 12);
					}
					pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
				}
			});
		}
	}

	public Calendar getValidityPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		if (pnl.getRdPricePer3Month().isSelected()) {
			cal.add(Calendar.DATE, 3);
		} else if (pnl.getRdPricePerMonth().isSelected()) {
			cal.add(Calendar.DATE, 1);
		} else {
			cal.add(Calendar.DATE, 12);
		}
		
		return cal;
	}

	@Override
	public void userIsSelected(User user) {
		inNameOf = user;
		pnl.getTxtInNameOf().setText(user.getFirstName() + " " + user.getLastName());
	}

	public void showRailCard(RailCard r) {
		if (r == null) return;
		railcard = r;
		pnl.getTxtName().setText(railcard.getName());
		pnl.getTxtDesc().setText(railcard.getDescription());
		pnl.getRdPricePerMonth().setText(String.valueOf(railcard.getPricePerMonth()));
		pnl.getRdPricePer3Month().setText(String.valueOf(railcard.getPricePer3Month()));
		pnl.getRdPricePerYear().setText(String.valueOf(railcard.getPricePerYear()));
		pnl.getTxtValidFrom().setText(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(Calendar.DATE, 1);
		pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
		pnl.getTxtSoldBy().setText(user.getFirstName() + " " + user.getLastName());
		pnl.getTxtToStation().setText("");
		pnl.getTxtFromStation().setText("");
		if (railcard.isHasFixedRoute()) {
			pnl.getTxtToStation().setEnabled(true);
			pnl.getTxtFromStation().setEnabled(true);
		} else {
			pnl.getTxtToStation().setEnabled(false);
			pnl.getTxtFromStation().setEnabled(false);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		selectUserController.update(o, arg);
	}

}