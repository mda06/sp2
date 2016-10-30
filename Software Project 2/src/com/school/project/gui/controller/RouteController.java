package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

import com.school.project.gui.model.ConnectionTableModel;
import com.school.project.gui.view.RouteView;
import com.school.project.nmbs.dao.ConnectionDAO;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.StationCache;

public class RouteController extends BaseController<RouteView> {
	private ConnectionTableModel tblModel;
	
	public RouteController() {
		super(new RouteView());
		initDepartureAndArrivalComboBox();
		initShowConnections();	
		initTablePreferences();
	}

	private void initDepartureAndArrivalComboBox(){
		view.getTxtDeparture().setItems(StationCache.getInstance().getStationsNames());
		view.getTxtArrival().setItems(StationCache.getInstance().getStationsNames());
	}
	
	private void initTablePreferences(){
		tblModel = new ConnectionTableModel();
		view.getTblConnection().setModel(tblModel);
		TableColumnModel tcm = view.getTblConnection().getColumnModel();
		
		tcm.getColumn(0).setPreferredWidth(500);
		tcm.getColumn(tblModel.COLUMN_ARRIVAL_TIME).setPreferredWidth(200);
		tcm.getColumn(tblModel.COLUMN_DEPARTURE_TIME).setPreferredWidth(200);
		tcm.getColumn(tblModel.COLUMN_DURATION).setPreferredWidth(100);
		tcm.getColumn(tblModel.COLUMN_NUMBER_OF_VIAS).setPreferredWidth(50);
	}
	
	private void initShowConnections(){
		view.getBtnShowConnections().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departure = view.getTxtDeparture().getText();
				String arrival = view.getTxtArrival().getText();
				String date = view.getTxtDate().getText();
				String hour = view.getTxtUur().getText();
				String departureSelect = "departure";
				if(view.getRbArrival().isSelected()){
					departureSelect = "arrival";
				}
				if(departure.isEmpty() || arrival.isEmpty()|| date.equals("  /  /    ")||hour.equals("  :  ")){
					JOptionPane.showMessageDialog(view, "Please fill in the blanks!");
				} else{
					departure = StationCache.getInstance().getFormattedIDByStationName(departure);
					arrival = StationCache.getInstance().getFormattedIDByStationName(arrival);
					hour = hour.replace(":", "");
					date = date.replace("/20", "");
					date = date.replace("/", "");
					for(int i = tblModel.getRowCount() - 1; i >= 0; i--){
						tblModel.removeRow(i);
					}
					try {
						List<Connection> lstConnections = ConnectionDAO.getConnections(departure, arrival, date, hour, departureSelect);
						for (Connection connection : lstConnections) {
							tblModel.addConnection(connection);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
