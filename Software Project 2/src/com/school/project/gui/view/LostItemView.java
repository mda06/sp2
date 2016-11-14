package com.school.project.gui.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LostItemView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JPanel pnlSearch, pnlAdd;
	private JButton btnSearch, btnAdd;
	private JTable table;

	public LostItemView() {
		super("lostItemView");
		initLayout();
	}
	
	private void initLayout() {
		
		
		txtSearch = new JTextField("Search");		    
		btnSearch = new JButton("Search");
		SpringLayout sp = new SpringLayout();
		pnlSearch = new JPanel(sp);
		pnlSearch.add(txtSearch);
		pnlSearch.add(btnSearch);	
		btnSearch.setPreferredSize(new Dimension(100, 150));
		sp.putConstraint(SpringLayout.WEST, txtSearch, 0, SpringLayout.WEST, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, txtSearch, 0, SpringLayout.NORTH, pnlSearch);
		sp.putConstraint(SpringLayout.SOUTH, txtSearch, 0, SpringLayout.SOUTH, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, txtSearch);
		sp.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, txtSearch);
		sp.putConstraint(SpringLayout.WEST, btnSearch, -120, SpringLayout.EAST, pnlSearch);
		sp.putConstraint(SpringLayout.EAST, txtSearch, -20, SpringLayout.WEST, btnSearch);
		
		pnlSearch.setBorder(BorderFactory.createTitledBorder("Search"));
		pnlAdd = new JPanel();
		pnlAdd.setBorder(BorderFactory.createTitledBorder("Add"));
		pnlAdd.add(btnAdd = new JButton("Add a item"));
		btnAdd.setPreferredSize(new Dimension(100, 30));
		table = new JTable();	
		JScrollPane scroll = new JScrollPane(table);
		
		

		sp = new SpringLayout();

		setLayout(sp);
		add(pnlSearch);
		add(pnlAdd);
		add(scroll);	
		sp.putConstraint(SpringLayout.WEST, pnlSearch, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlSearch, 5, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlSearch, -150, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlSearch, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlAdd, 15, SpringLayout.EAST, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, pnlAdd, 0, SpringLayout.NORTH, pnlSearch);
		sp.putConstraint(SpringLayout.SOUTH, pnlAdd, 0, SpringLayout.SOUTH, pnlSearch);
		sp.putConstraint(SpringLayout.EAST, pnlAdd, -15, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.SOUTH, pnlSearch);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, pnlSearch);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, pnlAdd);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JPanel getPnlAdd() {
		return pnlAdd;
	}

	public JPanel getPnlSearch() {
		return pnlSearch;
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
