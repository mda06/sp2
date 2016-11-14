package com.school.project.gui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.school.project.model.ActiveRailCard;
import com.school.project.model.LostItem;

public class ActiveRailCardTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public final int COLUMN_RAILCARD = 0, COLUMN_FROM = 1, COLUMN_TO = 2, COLUMN_VALID_FROM = 3, COLUMN_VALID_TO = 4, COLUMN_SOLD_BY_USER = 5; 	
	public String[] COLUMN_NAMES = {"Railcard", "From", "To", "Start Date", "End Date", "Sold by user"};

	public ActiveRailCardTableModel(){}
	
	public boolean isCellEditable(int row, int col){
		return false;
	}
	
	public int getColumnCount(){
		return COLUMN_NAMES.length;
	}
	
	public String getColumnName(int columnIndex){
		return COLUMN_NAMES[columnIndex];
	}
	
	public Class<?> getColumnClass(int columnIndex){
		Object o = getValueAt(0, columnIndex);
		if(o == null) return LostItem.class;
		return o.getClass();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex){
		Object returnValue = null;
		if(((Vector<?>)getDataVector()).size() == 0) return returnValue;
	    if(((Vector<?>)getDataVector().elementAt(rowIndex)).size() == 0) return returnValue;
	    
	    switch(columnIndex){
	    case COLUMN_RAILCARD:
	    	returnValue = getActiveRailCard(rowIndex).getRailCard().getName();
	    	break;
	    case COLUMN_FROM:
	    	returnValue = getActiveRailCard(rowIndex).getFrom();
	    	break;
	    case COLUMN_TO:
	    	returnValue = getActiveRailCard(rowIndex).getTo();
	    	break;
	    case COLUMN_VALID_FROM:
	    	returnValue = getActiveRailCard(rowIndex).getValidFrom();
	    	break;
	    case COLUMN_VALID_TO:
	    	returnValue = getActiveRailCard(rowIndex).getValidTo();
	    	break;
	    case COLUMN_SOLD_BY_USER:
	    	returnValue = getActiveRailCard(rowIndex).getUser().getFirstName() + " " + getActiveRailCard(rowIndex).getUser().getLastName();
	    	break;
	    default:
	    	throw new IllegalArgumentException("Invalid column index");	
	    }
	    
	    return returnValue;
	}
	public void addActiveRailCard(ActiveRailCard item){
		addRow(new Object[]{item});
	}
	
	public ActiveRailCard getActiveRailCard(int rowIndex){
		return ((ActiveRailCard)(((Vector<?>)getDataVector().elementAt(rowIndex)).elementAt(0)));
	}
	
}
