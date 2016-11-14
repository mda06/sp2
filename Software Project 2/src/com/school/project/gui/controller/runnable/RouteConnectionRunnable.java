package com.school.project.gui.controller.runnable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.school.project.gui.model.ConnectionTableModel;
import com.school.project.gui.view.RouteView;
import com.school.project.nmbs.dao.ConnectionDAO;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.StationCache;

public class RouteConnectionRunnable implements Runnable {
	private RouteView view;

	public RouteConnectionRunnable(RouteView view) {
		this.view = view;
	}

	@Override
	public void run() {
		String departure = view.getTxtDeparture().getText();
		String arrival = view.getTxtArrival().getText();
		Date selectedDate = (Date) view.getTxtDate().getModel().getValue();
		String date = new SimpleDateFormat("dd/MM/yyyy").format(selectedDate);
		System.out.println(date);
		String hour = view.getTxtUur().getText();
		String departureSelect = "depart";
		if (view.getRbArrival().isSelected()) {
			departureSelect = "arrive";
		}
		if (departure.isEmpty() || arrival.isEmpty() || date.equals("  /  /    ") || hour.equals("  :  ")) {
			JOptionPane.showMessageDialog(view, "Please fill in the blanks!");
		} else {
			departure = StationCache.getInstance().getFormattedIDByStationName(departure);
			arrival = StationCache.getInstance().getFormattedIDByStationName(arrival);
			hour = hour.replace(":", "");
			date = date.replace("/20", "");
			date = date.replace("/", "");

			try {
				List<Connection> lstConnections = ConnectionDAO.getConnections(departure, arrival, date, hour, departureSelect);
				ConnectionTableModel tblModel = (ConnectionTableModel) view.getTblConnection().getModel();
				for (Connection connection : lstConnections) {
					tblModel.addConnection(connection);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
