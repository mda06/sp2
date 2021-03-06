package com.school.project.gui.view;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TicketView extends BaseView {
	private static final long serialVersionUID = 1L;
	public final String KEY_BTNS = "buttons", KEY_PAY = "payment";
	
	private JPanel pnlBtns;
	private PaymentPanel pnlPay;	
	public TicketView() {
		super("TicketView");

		initLayout();
	}

	private void initLayout() {
		setLayout(new CardLayout());
		pnlBtns = new JPanel(new GridLayout(0, 4, 5, 5));
		add(new JScrollPane(pnlBtns), KEY_BTNS);
		add(pnlPay = new PaymentPanel(), KEY_PAY);
	}
	
	public JPanel getPnlBtns() {
		return pnlBtns;
	}
	
	public PaymentPanel getPnlPayment() {
		return pnlPay;
	}

}
