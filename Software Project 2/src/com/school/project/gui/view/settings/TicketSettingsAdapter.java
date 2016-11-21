package com.school.project.gui.view.settings;

import java.awt.Panel;

import javax.swing.JButton;

import com.school.project.gui.view.PaymentPanel;
import com.school.project.gui.view.TicketView;

public class TicketSettingsAdapter extends Panel {
	private TicketView tv;
	private PaymentPanel paymentPnl;
	private JButton btnSave;

	public TicketSettingsAdapter() {
		this.tv = new TicketView();
		
	}
	
	
}
