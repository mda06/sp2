package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.smartcardio.ResponseAPDU;
import javax.swing.JOptionPane;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.view.PaymentRailcardPanel;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;
import com.school.project.nfc.CardMifare1K;
import com.school.project.nfc.RailCardToNFCSettings;
import com.school.project.nfc.event.CardConnected;
import com.school.project.nmbs.model.StationCache;

public class ActiveRailCardController implements SelectedUserListener, Observer, CardConnected {
	private PaymentRailcardPanel pnl;
	private PaymentBackListener list;
	private RailCard railcard;
	private User user, inNameOf;
	private SelectUserController selectUserController;
	private CardMifare1K nfcCard;
	private String fillInTheBlanks;

	public ActiveRailCardController(PaymentRailcardPanel pnl, PaymentBackListener list, User user) {
		this.pnl = pnl;
		this.list = list;
		this.user = user;
		this.railcard = null;
		nfcCard = null;
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

				if (inNameOf == null) {
					JOptionPane.showMessageDialog(pnl, fillInTheBlanks);
				} else if (railcard.isHasFixedRoute() && (from.isEmpty() || to.isEmpty())) {
					JOptionPane.showMessageDialog(pnl, fillInTheBlanks);
				} else {
					ActiveRailCard activeRailCard = new ActiveRailCard(-1, validFrom, validTo, from, to, user, inNameOf, railcard, false);
					ActiveRailCardDAO.getInstance().add(activeRailCard);
					if (nfcCard != null) setActiveRailCardOnNFC(activeRailCard);
					nfcCard = null;
					list.backToPreviousView();
				}
			}
		});
		
		ActionListener actRad = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = getValidityPeriod();
				pnl.getTxtValidTo().setText(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()));
			}
		};

		pnl.getRdPricePer3Month().addActionListener(actRad);
		pnl.getRdPricePerMonth().addActionListener(actRad);
		pnl.getRdPricePerYear().addActionListener(actRad);
	}

	private void setActiveRailCardOnNFC(ActiveRailCard activeRailCard) {
		if (activeRailCard == null || nfcCard == null) return;
		try {
			byte data[] = new byte[16];
			byte id[] = intToByteArray(activeRailCard.getInNameOf().getId());
			for (int i = 0; i < 4; i++)
				data[i] = id[i];
			for(int i = 0; i < 12; i++)
				data[4+i] = 0;
			nfcCard.authentificate(RailCardToNFCSettings.BLOCK_NUMBER_RAILCARD).getSW();
			ResponseAPDU res = nfcCard.updateBinaryBlock(RailCardToNFCSettings.BLOCK_NUMBER_RAILCARD, data);
			if (CardMifare1K.isSucces(res)) JOptionPane.showMessageDialog(null, "Success saved to NFC !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final byte[] intToByteArray(int value) {
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
	}

	public Calendar getValidityPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		if (pnl.getRdPricePer3Month().isSelected()) {
			cal.add(Calendar.MONTH, 3);
		} else if (pnl.getRdPricePerMonth().isSelected()) {
			cal.add(Calendar.MONTH, 1);
		} else {
			cal.add(Calendar.MONTH, 12);
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
		if (o instanceof LanguageObservable) {
			LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
			fillInTheBlanks = lh.getString("fillInTheBlanks");

			pnl.getBtnPay().setText(lh.getString("Pay"));
			pnl.getBtnSelectUser().setText(lh.getString("user"));
			pnl.getLblDesc().setText(lh.getString("description"));
			pnl.getLblFromStation().setText(lh.getString("from"));
			pnl.getLblToStation().setText(lh.getString("to"));
			pnl.getLblPricePer3Month().setText(lh.getString("pricePer") + " 3 " + lh.getString("months"));
			pnl.getLblPricePerMonth().setText(lh.getString("pricePer") + " " + lh.getString("month"));
			pnl.getLblPricePerYear().setText(lh.getString("pricePer") + " " + lh.getString("year"));
			pnl.getLblSoldBy().setText(lh.getString("soldBy"));
			pnl.getLblValidFrom().setText(lh.getString("validFrom"));
			pnl.getLblValidTo().setText(lh.getString("validTo"));
			pnl.getLblInNameOf().setText(lh.getString("inNameOf"));
			pnl.getBtnBack().setText(lh.getString("back"));

		}

	}

	@Override
	public void cardConnected(CardMifare1K c) {
		nfcCard = c;
	}

}