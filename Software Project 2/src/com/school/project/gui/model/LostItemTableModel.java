package com.school.project.gui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.school.project.model.LostItem;

public class LostItemTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;	

	public static final int COLUMN_TYPE = 0, COLUMN_DESCRIPTION = 1, COLUMN_LOCATION = 2;
	public static String[] COLUMN_NAMES = {"Type", "Description", "Location"};

	public LostItemTableModel() {}
	
	public boolean isCellEditable(int row, int col) { 
		return false;//true; 
	}
	
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
	
	public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }
	
	public Class<?> getColumnClass(int columnIndex) {
		Object o = getValueAt(0, columnIndex);
		if(o == null) return LostItem.class;
        return o.getClass();
    }
	
	public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        if(((Vector<?>)getDataVector()).size() == 0) return returnValue;
        if(((Vector<?>)getDataVector().elementAt(rowIndex)).size() == 0) return returnValue;

        switch (columnIndex) {
        case COLUMN_TYPE:
            returnValue = getLostItemAt(rowIndex).getType();
            break;
        case COLUMN_DESCRIPTION:
            returnValue = getLostItemAt(rowIndex).getDescription();
            break;
        case COLUMN_LOCATION:
            returnValue = getLostItemAt(rowIndex).getLocation();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
        
        return returnValue;
	}
	
	public void addLostItem(LostItem item) {
		addRow(new Object[]{item});
	}
	
	public LostItem getLostItemAt(int rowIndex) {
		return ((LostItem)(((Vector<?>)getDataVector().elementAt(rowIndex)).elementAt(0)));
	}
}
