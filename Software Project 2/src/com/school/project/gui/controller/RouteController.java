package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.table.TableColumnModel;

import com.school.project.gui.controller.runnable.RouteConnectionRunnable;
import com.school.project.gui.model.ConnectionTableModel;
import com.school.project.gui.view.RouteView;
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
				for(int i = tblModel.getRowCount() - 1; i >= 0; i--){
					tblModel.removeRow(i);
				}
				
				RouteConnectionRunnable run = new RouteConnectionRunnable(view);
				new Thread(run).start();
			}
		});
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
