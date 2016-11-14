package com.school.project.gui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.Via;
import com.school.project.util.DateUtil;

public class ConnectionDetailsTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public final int COLUMN_TRAIN_DIR = 0, COLUMN_STEP_OFF = 1, COLUMN_ARRIVAL_PLATFORM = 2, COLUMN_ARRIVAL_DELAY = 3, COLUMN_ARRIVAL_TIME = 4,
			COLUMN_NEXT_PLATFORM = 5, COLUMN_NEXT_DELAY = 6, COLUMN_NEXT_TIME = 7;
	public String[] COLUMN_NAMES = { "Train Direction", "Step off", "Arrival Platform", "Arrival Delay(s)", "Arrival Time", "Next Platform", "Next Delay(s)", "Next Time" };

	public ConnectionDetailsTableModel() {
	}

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
		if (o == null) return Connection.class;
		return o.getClass();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object returnValue = null;
		if (((Vector<?>) getDataVector()).size() == 0) return returnValue;
		if (((Vector<?>) getDataVector().elementAt(rowIndex)).size() == 0) return returnValue;

		Via v = getViaAt(rowIndex);
		switch (columnIndex) {
		case COLUMN_TRAIN_DIR:
			returnValue = v.getDirection();
			break;
		case COLUMN_STEP_OFF:
			returnValue = v.getStation().getName();
			break;
		case COLUMN_NEXT_PLATFORM:
			returnValue = v.getDepInfo().getPlatform().getName();
			break;
		case COLUMN_NEXT_TIME:
			returnValue = DateUtil.timeStampToDate(v.getDepInfo().getTimeStamp());
			break;
		case COLUMN_NEXT_DELAY:
			returnValue = v.getDepInfo().getDelay();
			break;
		case COLUMN_ARRIVAL_TIME:
			returnValue = DateUtil.timeStampToDate(v.getArrInfo().getTimeStamp());
			break;
		case COLUMN_ARRIVAL_PLATFORM:
			returnValue = v.getArrInfo().getPlatform().getName();
			break;
		case COLUMN_ARRIVAL_DELAY:
			returnValue = v.getArrInfo().getDelay();
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}

		return returnValue;
	}

	public void addVia(Via via) {
		addRow(new Object[] { via });
	}

	public Via getViaAt(int rowIndex) {
		return ((Via) (((Vector<?>) getDataVector().elementAt(rowIndex)).elementAt(0)));
	}
}
