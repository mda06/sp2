package com.school.project.gui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.school.project.model.User;
import com.school.project.nmbs.model.Connection;

public class SelectUserTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public final int COLUMN_USER = 0;
	public String[] COLUMN_NAMES = { "User" };

	public SelectUserTableModel() {}

	public boolean isCellEditable(int row, int col) {
		return false;// true;
	}

	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	public String getColumnName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		Object o = getValueAt(0, columnIndex);
		if (o == null)
			return Connection.class;
		return o.getClass();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object returnValue = null;
		if (((Vector<?>) getDataVector()).size() == 0)
			return returnValue;
		if (((Vector<?>) getDataVector().elementAt(rowIndex)).size() == 0)
			return returnValue;

		switch (columnIndex) {
		case COLUMN_USER:
			User u = getUserAt(rowIndex);
			returnValue = u.getFirstName() + " " + u.getLastName();
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}

		return returnValue;
	}

	public void addUser(User user) {
		addRow(new Object[] { user });
	}

	public User getUserAt(int rowIndex) {
		return ((User) (((Vector<?>) getDataVector().elementAt(rowIndex)).elementAt(0)));
	}
}
