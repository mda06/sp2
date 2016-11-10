package com.school.project.gui.controller;

import javax.swing.table.TableColumnModel;

import com.school.project.gui.model.ConnectionDetailsTableModel;
import com.school.project.gui.view.ConnectionDetailsFrame;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.Via;
import com.school.project.util.DateUtil;

public class ConnectionDetailsController {
	private ConnectionDetailsFrame frame;
	private ConnectionDetailsTableModel tblModel;
	
	public ConnectionDetailsController() {
		frame = new ConnectionDetailsFrame();
		
		initTablePreferences();
	}
	
	private void initTablePreferences(){
		tblModel = new ConnectionDetailsTableModel();
		frame.getTblDetails().setModel(tblModel);
		TableColumnModel tcm = frame.getTblDetails().getColumnModel();
		
		tcm.getColumn(tblModel.COLUMN_TRAIN_DIR).setPreferredWidth(300);
		tcm.getColumn(tblModel.COLUMN_STEP_OFF).setPreferredWidth(300);
		tcm.getColumn(tblModel.COLUMN_ARRIVAL_PLATFORM).setPreferredWidth(50);
		tcm.getColumn(tblModel.COLUMN_ARRIVAL_DELAY).setPreferredWidth(50);
		tcm.getColumn(tblModel.COLUMN_ARRIVAL_TIME).setPreferredWidth(200);
		tcm.getColumn(tblModel.COLUMN_NEXT_PLATFORM).setPreferredWidth(50);
		tcm.getColumn(tblModel.COLUMN_NEXT_DELAY).setPreferredWidth(50);
		tcm.getColumn(tblModel.COLUMN_NEXT_TIME).setPreferredWidth(200);
	}
	
	public void showConnection(Connection c) {
		for(int i = 0; i < tblModel.getRowCount(); i++)
			tblModel.removeRow(i);
		
		for(Via v : c.getVias())
			tblModel.addVia(v);
		
		frame.setVisible(true);
		String str = c.getArrival().getToStation().getName();
		str += " on " + DateUtil.timeStampToDate(c.getArrival().getDepartureInfo().getTimeStamp());
		str += " at platform " + c.getArrival().getDepartureInfo().getPlatform().getName();
		str += " with " + c.getArrival().getDepartureInfo().getDelay() + " delay";
		frame.getTxtArrival().setText(str);
		str = c.getDeparture().getToStation().getName();
		str += " on " + DateUtil.timeStampToDate(c.getDeparture().getDepartureInfo().getTimeStamp());
		str += " at platform " + c.getDeparture().getDepartureInfo().getPlatform().getName();
		str += " with " + c.getDeparture().getDepartureInfo().getDelay() + " delay";
		frame.getTxtDeparture().setText(str);
		int min = (int) c.getDurationInMinutes();
		int hour = min / 60;
		min %= 60;
		frame.getTxtDuration().setText(String.format("%d:%02d", hour,min));
	}
}
