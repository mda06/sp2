package com.school.project.gui.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class LostItemView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JTextField txtSearchType, txtSearchDesc, txtSearchLoc;
	private JButton btnSearch, btnAdd;
	private JTable table;
	private JCheckBox cbtnType, cbtnDescription, cbtnLocation;

	public LostItemView() {
		super("lostItemView");
		initLayout();
	}
	
	private void initLayout() {
		
		txtSearchType = new JTextField("Type");
		txtSearchDesc = new JTextField("Description");
		txtSearchLoc = new JTextField("Location");
		btnSearch = new JButton("Search");
		btnAdd = new JButton("Add an item");
		table = new JTable();	
		JScrollPane scroll = new JScrollPane(table);
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		
		add(txtSearchType);
		add(txtSearchDesc);
		add(txtSearchLoc);
		add(btnSearch);
		add(btnAdd);
		add(scroll);
		
		btnSearch.setMinimumSize(new Dimension(300,100));
		btnAdd.setMinimumSize(new Dimension(300,100));
		
		sp.putConstraint(SpringLayout.WEST, txtSearchType, 10, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.EAST, txtSearchType, -630, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.NORTH, txtSearchType, 10, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, txtSearchType);
		sp.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.WEST, btnSearch, 10, SpringLayout.EAST, txtSearchType);
		sp.putConstraint(SpringLayout.EAST, btnSearch, 300, SpringLayout.WEST, btnSearch);
		
		sp.putConstraint(SpringLayout.NORTH, txtSearchDesc, 10, SpringLayout.SOUTH, txtSearchType);
		sp.putConstraint(SpringLayout.WEST, txtSearchDesc, 0, SpringLayout.WEST, txtSearchType);
		sp.putConstraint(SpringLayout.EAST, txtSearchDesc, 0, SpringLayout.EAST, txtSearchType);
		
		sp.putConstraint(SpringLayout.NORTH, txtSearchLoc, 10, SpringLayout.SOUTH, txtSearchDesc);
		sp.putConstraint(SpringLayout.WEST, txtSearchLoc, 0, SpringLayout.WEST, txtSearchDesc);
		sp.putConstraint(SpringLayout.EAST, txtSearchLoc, 0, SpringLayout.EAST, txtSearchDesc);
		
		sp.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.EAST, btnSearch);
		sp.putConstraint(SpringLayout.NORTH, btnAdd, 0, SpringLayout.NORTH, txtSearchType);
		sp.putConstraint(SpringLayout.SOUTH, btnAdd, 0, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.EAST, btnAdd, -10, SpringLayout.EAST, this);
		
		sp.putConstraint(SpringLayout.NORTH, scroll, 20, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, txtSearchType);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, btnAdd);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);
		
		FontUtil.getInstance().bindSmallFont(txtSearchType);
		FontUtil.getInstance().bindSmallFont(txtSearchDesc);
		FontUtil.getInstance().bindSmallFont(txtSearchLoc);
		FontUtil.getInstance().bindSmallFont(btnSearch);
		FontUtil.getInstance().bindSmallFont(btnAdd);
		FontUtil.getInstance().bindSmallFont(table);
		table.setRowHeight(30);
		FontUtil.getInstance().bindSmallFont(table.getTableHeader());
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public JTextField getTxtSearchType() {
		return txtSearchType;
	}

	public JTextField getTxtSearchDesc() {
		return txtSearchDesc;
	}

	public JTextField getTxtSearchLoc() {
		return txtSearchLoc;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JTable getTable() {
		return table;
	}

	public JCheckBox getCbtnType() {
		return cbtnType;
	}

	public void setCbtnType(JCheckBox cbtnType) {
		this.cbtnType = cbtnType;
	}

	public JCheckBox getCbtnDescription() {
		return cbtnDescription;
	}

	public void setCbtnDescription(JCheckBox cbtnDescription) {
		this.cbtnDescription = cbtnDescription;
	}

	public JCheckBox getCbtnLocation() {
		return cbtnLocation;
	}

	public void setCbtnLocation(JCheckBox cbtnLocation) {
		this.cbtnLocation = cbtnLocation;
	}
	
	

}
