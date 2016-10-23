package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LostItemView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JTable table;

	public LostItemView() {
		super("lostItemView");
		initLayout();
	}
	
	private void initLayout() {
		txtSearch = new JTextField("Search");
		btnSearch = new JButton("Search");
		table = new JTable();	
		JScrollPane scroll = new JScrollPane(table);
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(txtSearch);
		add(btnSearch);
		add(scroll);
		sp.putConstraint(SpringLayout.WEST, txtSearch, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtSearch, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, txtSearch, -150, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.WEST, btnSearch, 15, SpringLayout.EAST, txtSearch);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, txtSearch);
		sp.putConstraint(SpringLayout.EAST, btnSearch, -15, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.SOUTH, txtSearch);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, txtSearch);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, btnSearch);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JTable getTable() {
		return table;
	}

}
