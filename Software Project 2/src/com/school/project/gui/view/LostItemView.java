package com.school.project.gui.view;

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
	private JTextField txtSearch;
	private JPanel pnlSearch;
	private JButton btnSearch, btnAdd;
	private JTable table;
	private JCheckBox cbtnType, cbtnDescription, cbtnLocation;

	public LostItemView() {
		super("lostItemView");
		initLayout();
	}
	
	private void initLayout() {
		
		txtSearch = new JTextField("Search");		    
		btnSearch = new JButton("Search");
		cbtnType = new JCheckBox("by type");
		cbtnDescription = new JCheckBox("by description");
		cbtnLocation = new JCheckBox("by location");
		SpringLayout sp = new SpringLayout();
		pnlSearch = new JPanel(sp);
		pnlSearch.add(txtSearch);
		pnlSearch.add(btnSearch);
		
		pnlSearch.add(cbtnType);
		pnlSearch.add(cbtnDescription);
		pnlSearch.add(cbtnLocation);
		
		sp.putConstraint(SpringLayout.WEST, txtSearch, 0, SpringLayout.WEST, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, txtSearch, 0, SpringLayout.NORTH, pnlSearch);
		sp.putConstraint(SpringLayout.SOUTH, txtSearch, 0, SpringLayout.SOUTH, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, txtSearch);
		sp.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, txtSearch);
		sp.putConstraint(SpringLayout.WEST, btnSearch, -170, SpringLayout.EAST, pnlSearch);
		sp.putConstraint(SpringLayout.EAST, txtSearch, -20, SpringLayout.WEST, btnSearch);
			
		btnAdd = new JButton("Add a item");
		table = new JTable();	
		JScrollPane scroll = new JScrollPane(table);		

		sp = new SpringLayout();

		setLayout(sp);
		add(pnlSearch);
		add(btnAdd);
		add(scroll);	
		sp.putConstraint(SpringLayout.WEST, pnlSearch, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, pnlSearch, 5, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlSearch, -200, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlSearch, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, btnAdd, 15, SpringLayout.EAST, pnlSearch);
		sp.putConstraint(SpringLayout.NORTH, btnAdd, 5, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, btnAdd, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, btnAdd, -15, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.SOUTH, pnlSearch);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, pnlSearch);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, btnAdd);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);
		
		FontUtil.getInstance().bindSmallFont(txtSearch);
		FontUtil.getInstance().bindSmallFont(btnSearch);
		FontUtil.getInstance().bindSmallFont(btnAdd);
		FontUtil.getInstance().bindSmallFont(table);
		table.setRowHeight(30);
		FontUtil.getInstance().bindSmallFont(table.getTableHeader());
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
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
