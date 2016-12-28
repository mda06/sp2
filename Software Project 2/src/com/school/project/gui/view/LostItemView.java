package com.school.project.gui.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class LostItemView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JLabel lblSearchType, lblSearchDesc, lblSearchLoc;
	private JTextField txtSearchType, txtSearchDesc, txtSearchLoc;
	private JButton btnSearch, btnAdd;
	private JTable table;
	static TabThroughComponents travPol;

	public LostItemView() {
		super("lostItemView");
		initLayout();
	}
	
	private void initLayout() {
		lblSearchType = new JLabel("Type:");
		lblSearchDesc = new JLabel("Description:");
		lblSearchLoc = new JLabel("Location:");
		txtSearchType = new JTextField();
		txtSearchDesc = new JTextField();
		txtSearchLoc = new JTextField();
		btnSearch = new JButton();
		btnAdd = new JButton("Add an item");
		table = new JTable();	
		JScrollPane scroll = new JScrollPane(table);
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		
		add(txtSearchType);
		add(txtSearchDesc);
		add(txtSearchLoc);
		add(lblSearchType);
		add(lblSearchDesc);
		add(lblSearchLoc);
		add(btnSearch);
		add(btnAdd);
		add(scroll);
		
		Vector<Component> tabOrder = new Vector<Component>(6);
		tabOrder.add(txtSearchType);
		tabOrder.add(txtSearchDesc);
		tabOrder.add(txtSearchLoc);
		tabOrder.add(btnSearch);
		tabOrder.add(btnAdd);
		tabOrder.add(table);
		travPol = new TabThroughComponents(tabOrder);
		setFocusTraversalPolicy(travPol);
		setFocusTraversalPolicyProvider(true);		
		
		btnSearch.setMinimumSize(new Dimension(300,100));
		btnAdd.setMinimumSize(new Dimension(300,100));
		

		sp.putConstraint(SpringLayout.WEST, lblSearchType, 10, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.WEST, txtSearchType, 80, SpringLayout.EAST, lblSearchType);
		sp.putConstraint(SpringLayout.EAST, txtSearchType, -600, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.NORTH, txtSearchType, 10, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, txtSearchType);
		sp.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.WEST, btnSearch, 10, SpringLayout.EAST, txtSearchType);
		sp.putConstraint(SpringLayout.EAST, btnSearch, 300, SpringLayout.WEST, btnSearch);
		sp.putConstraint(SpringLayout.NORTH, lblSearchType, 0, SpringLayout.NORTH, txtSearchType);
		sp.putConstraint(SpringLayout.SOUTH, lblSearchType, 0, SpringLayout.SOUTH, txtSearchType);

		sp.putConstraint(SpringLayout.WEST, lblSearchDesc, 0, SpringLayout.WEST, lblSearchType);
		sp.putConstraint(SpringLayout.NORTH, txtSearchDesc, 10, SpringLayout.SOUTH, txtSearchType);
		sp.putConstraint(SpringLayout.WEST, txtSearchDesc, 0, SpringLayout.WEST, txtSearchType);
		sp.putConstraint(SpringLayout.EAST, txtSearchDesc, 0, SpringLayout.EAST, txtSearchType);
		sp.putConstraint(SpringLayout.NORTH, lblSearchDesc, 0, SpringLayout.NORTH, txtSearchDesc);
		sp.putConstraint(SpringLayout.SOUTH, lblSearchDesc, 0, SpringLayout.SOUTH, txtSearchDesc);

		sp.putConstraint(SpringLayout.WEST, lblSearchLoc, 0, SpringLayout.WEST, lblSearchType);
		sp.putConstraint(SpringLayout.NORTH, txtSearchLoc, 10, SpringLayout.SOUTH, txtSearchDesc);
		sp.putConstraint(SpringLayout.WEST, txtSearchLoc, 0, SpringLayout.WEST, txtSearchDesc);
		sp.putConstraint(SpringLayout.EAST, txtSearchLoc, 0, SpringLayout.EAST, txtSearchDesc);
		sp.putConstraint(SpringLayout.NORTH, lblSearchLoc, 0, SpringLayout.NORTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.SOUTH, lblSearchLoc, 0, SpringLayout.SOUTH, txtSearchLoc);
		
		sp.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.EAST, btnSearch);
		sp.putConstraint(SpringLayout.NORTH, btnAdd, 0, SpringLayout.NORTH, txtSearchType);
		sp.putConstraint(SpringLayout.SOUTH, btnAdd, 0, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.EAST, btnAdd, -10, SpringLayout.EAST, this);
		
		sp.putConstraint(SpringLayout.NORTH, scroll, 20, SpringLayout.SOUTH, txtSearchLoc);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, lblSearchType);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, btnAdd);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);

		FontUtil.getInstance().bindSmallFont(lblSearchType);
		FontUtil.getInstance().bindSmallFont(lblSearchDesc);
		FontUtil.getInstance().bindSmallFont(lblSearchLoc);
		FontUtil.getInstance().bindSmallFont(txtSearchType);
		FontUtil.getInstance().bindSmallFont(txtSearchDesc);
		FontUtil.getInstance().bindSmallFont(txtSearchLoc);
		FontUtil.getInstance().bindSmallFont(btnSearch);
		FontUtil.getInstance().bindSmallFont(btnAdd);
		FontUtil.getInstance().bindSmallFont(table);
		table.setRowHeight(30);
		FontUtil.getInstance().bindSmallFont(table.getTableHeader());
	}
	
	public static class TabThroughComponents extends FocusTraversalPolicy{ //template code from http://docs.oracle.com/javase/tutorial/uiswing/misc/focus.html#customFocusTraversal
		Vector<Component> tabOrder;
		
		public TabThroughComponents(Vector<Component> tabOrder) {
			this.tabOrder = new Vector<Component>(tabOrder.size());
			this.tabOrder.addAll(tabOrder);
		}
		@Override
		public Component getLastComponent(Container aContainer) {
			return tabOrder.lastElement();
		}
		
		@Override
		public Component getFirstComponent(Container aContainer) {
			return tabOrder.firstElement();
		}
		
		@Override
		public Component getDefaultComponent(Container aContainer) {
			return tabOrder.get(0);
		}
		
		@Override
		public Component getComponentBefore(Container aContainer, Component aComponent) {
			int idx = tabOrder.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = tabOrder.size() - 1;
            }
            return tabOrder.get(idx);
		}
		
		@Override
		public Component getComponentAfter(Container aContainer, Component aComponent) {
			int idx = (tabOrder.indexOf(aComponent) + 1) % tabOrder.size();
            return tabOrder.get(idx);
		}
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

	public JLabel getLblSearchType() {
		return lblSearchType;
	}

	public JLabel getLblSearchDesc() {
		return lblSearchDesc;
	}

	public JLabel getLblSearchLoc() {
		return lblSearchLoc;
	}
}
