package com.school.project.gui.view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class RailCardView extends BaseView {
	private static final long serialVersionUID = 1L;
	public final String KEY_BTNS = "buttons", KEY_PAY = "payment";
	private JPanel pnlBtns;
	private PaymentRailcardPanel pnlPay;
	
	public RailCardView() {
		super("RailCard");
		
		initLayout();
	}

	private void initLayout() {
		setLayout(new CardLayout());
		add(pnlBtns = new JPanel(new GridLayout(0, 4, 5, 5)), KEY_BTNS);
		add(pnlPay = new PaymentRailcardPanel(), KEY_PAY);
	}

	public JPanel getPnlBtns() {
		return pnlBtns;
	}

	public PaymentRailcardPanel getPnlPay() {
		return pnlPay;
	}

}