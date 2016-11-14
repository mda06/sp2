package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class ActiveRailCardView extends BaseView {
	private static final long serialVersionUID = 1L;
	public final String KEY_BTNS = "buttons", KEY_PAY = "payment";
	private JButton btnSelectUser;
	private JLabel lblSelectUser;
	private JTable table;
	private JPanel pnlTop;
	
	
	
	public ActiveRailCardView() {
		super("ActiveRailCard");
		initLayout();
	}

	private void initLayout(){
		
		btnSelectUser = new JButton();
		lblSelectUser = new JLabel();
		table = new JTable();
		SpringLayout sp = new SpringLayout();
		pnlTop = new JPanel(sp);
		pnlTop.add(btnSelectUser);
		pnlTop.add(lblSelectUser);
	}
}
