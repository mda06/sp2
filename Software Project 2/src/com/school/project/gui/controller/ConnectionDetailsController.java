package com.school.project.gui.controller;

import com.school.project.gui.model.ConnectionDetailsTableModel;
import com.school.project.gui.view.ConnectionDetailsFrame;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.Via;

public class ConnectionDetailsController {
	private ConnectionDetailsFrame frame;
	private ConnectionDetailsTableModel tblModel;
	
	public ConnectionDetailsController() {
		frame = new ConnectionDetailsFrame();
		tblModel = new ConnectionDetailsTableModel();
		
		frame.getTblDetails().setModel(tblModel);
	}
	
	public void showConnection(Connection c) {
		for(int i = 0; i < tblModel.getRowCount(); i++)
			tblModel.removeRow(i);
		
		for(Via v : c.getVias())
			tblModel.addVia(v);
		
		frame.setVisible(true);
		frame.getTxtArrival().setText(c.getArrival().getToStation().getName());
		frame.getTxtDeparture().setText(c.getDeparture().getToStation().getName());
		int min = (int) c.getDurationInMinutes();
		int hour = min / 60;
		min %= 60;
		frame.getTxtDuration().setText(String.format("%d:%02d", hour,min));
	}
}
