package com.school.project.gui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.school.project.nmbs.model.Connection;
import com.school.project.util.DateUtil;

public class ConnectionTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public final int COLUMN_FROM_TO = 0, COLUMN_DEPARTURE_TIME = 1, COLUMN_ARRIVAL_TIME = 2, COLUMN_DURATION = 3,
			COLUMN_NUMBER_OF_VIAS = 4;
	public String[] COLUMN_NAMES = { "From - To", "Departure time", "Arrival time", "Duration", "Number of vias" };

	public ConnectionTableModel() {}

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
		case COLUMN_FROM_TO:
			returnValue = getConnectionAt(rowIndex).getArrival().getToStation().getName() + " - " + getConnectionAt(rowIndex).getDeparture().getToStation().getName();;
			break;
		case COLUMN_DEPARTURE_TIME:
			returnValue = DateUtil.timeStampToDate(getConnectionAt(rowIndex).getDeparture().getDepartureInfo().getTimeStamp());
			break;
		case COLUMN_ARRIVAL_TIME:
			returnValue = DateUtil.timeStampToDate(getConnectionAt(rowIndex).getArrival().getDepartureInfo().getTimeStamp());
			break;
		case COLUMN_DURATION:
			int min = (int) getConnectionAt(rowIndex).getDurationInMinutes();
			int hour = min / 60;
			min %= 60;
			returnValue = String.format("%d:%02d", hour,min);
			break;
		case COLUMN_NUMBER_OF_VIAS:
			returnValue = getConnectionAt(rowIndex).getVias().size();
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}

		return returnValue;
	}

	public void addConnection(Connection connection) {
		addRow(new Object[] { connection });
	}

	public Connection getConnectionAt(int rowIndex) {
		return ((Connection) (((Vector<?>) getDataVector().elementAt(rowIndex)).elementAt(0)));
	}
}
