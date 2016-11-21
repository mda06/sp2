package com.school.project.gui.view.settings;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.TicketView;

public class TicketSettingsView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JPanel pnlPanel;
	private JButton btnTest;
	
	public TicketSettingsView() {
		super("ticketSettings");
		initLayout();
		}

	private void initLayout() {
		TicketSettingsAdapter tsa = new TicketSettingsAdapter();
		pnlPanel = new JPanel();
		
	}
}
