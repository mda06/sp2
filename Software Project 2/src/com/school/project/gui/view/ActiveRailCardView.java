package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class ActiveRailCardView extends BaseView {
	private static final long serialVersionUID = 1L;
	public final String KEY_BTNS = "buttons", KEY_PAY = "payment";
	private JButton btnSelectUser;
	private JLabel lblSelectUser, lblUser;
	private JTable table;
	
	
	
	public ActiveRailCardView() {
		super("ActiveRailCard");
		initLayout();
	}

	private void initLayout(){
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		
		btnSelectUser = new JButton();
		lblSelectUser = new JLabel();
		lblUser = new JLabel();
		
		add(btnSelectUser);
		add(lblSelectUser);
		add(lblUser);
		
		table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll);
		
		sp.putConstraint(SpringLayout.WEST, btnSelectUser, 40, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, btnSelectUser, 30, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, btnSelectUser, 90, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, btnSelectUser, 200, SpringLayout.WEST, btnSelectUser);

		sp.putConstraint(SpringLayout.WEST, lblSelectUser, 50, SpringLayout.EAST, btnSelectUser);
		sp.putConstraint(SpringLayout.NORTH, lblSelectUser, 0, SpringLayout.NORTH, btnSelectUser);
		sp.putConstraint(SpringLayout.SOUTH, lblSelectUser, 0, SpringLayout.SOUTH, btnSelectUser);
		sp.putConstraint(SpringLayout.EAST, lblSelectUser, 200, SpringLayout.WEST, lblSelectUser);
		
		sp.putConstraint(SpringLayout.NORTH, lblUser, 0, SpringLayout.NORTH, lblSelectUser);
		sp.putConstraint(SpringLayout.WEST, lblUser, 20, SpringLayout.EAST, lblSelectUser);
		sp.putConstraint(SpringLayout.EAST, lblUser, 700, SpringLayout.WEST, lblUser);
		sp.putConstraint(SpringLayout.SOUTH, lblUser, 0, SpringLayout.SOUTH, btnSelectUser);
		
		sp.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, scroll, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.EAST, scroll, -30, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -30, SpringLayout.SOUTH, this);

		
		btnSelectUser.setFont(FontUtil.getInstance().getBig());
		lblSelectUser.setFont(FontUtil.getInstance().getBig());
		lblUser.setFont(FontUtil.getInstance().getBig());
		table.setFont(FontUtil.getInstance().getSmall());
		table.getTableHeader().setFont(FontUtil.getInstance().getSmall());
		table.setRowHeight(30);
		
	}

	public JButton getBtnSelectUser() {
		return btnSelectUser;
	}

	public JLabel getLblSelectUser() {
		return lblSelectUser;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public JTable getTable() {
		return table;
	}

	
	
}
