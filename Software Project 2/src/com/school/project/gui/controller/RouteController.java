package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.table.TableColumnModel;

import com.school.project.gui.controller.runnable.RouteConnectionRunnable;
import com.school.project.gui.model.ConnectionTableModel;
import com.school.project.gui.view.RouteView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.StationCache;

public class RouteController extends BaseController<RouteView> {
	private ConnectionTableModel tblModel;
	private ConnectionDetailsController detailsController;
	
	public RouteController() {
		super(new RouteView());
		initDepartureAndArrivalComboBox();
		initShowConnections();	
		initTablePreferences();
		initTableEvents();
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
	
	private void initTableEvents() {
		detailsController = new ConnectionDetailsController();
		view.getTblConnection().addMouseListener(new MouseAdapter(){ 
			public void mouseClicked(MouseEvent e) { 
				if(e.getClickCount() == 2){
					Connection c = tblModel.getConnectionAt(view.getTblConnection().getSelectedRow());
					if(c != null)
						detailsController.showConnection(c);
				}
			}
		});
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
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o). getLanguageHandler();
			view.getLbArrival().setText(lh.getString("arrival"));
			view.getLbDeparture().setText(lh.getString("departure"));
			view.getLbDate().setText(lh.getString("date"));
			view.getLbNumber().setText(lh.getString("number"));
			view.getLbUur().setText(lh.getString("uur"));
			view.getRbSingle().setText(lh.getString("single"));
			view.getRbReturn().setText(lh.getString("return"));
			view.getRbDeparture().setText(lh.getString("departure"));
			view.getRbArrival().setText(lh.getString("arrival"));
			view.getBtnShowConnections().setText(lh.getString("showConnections"));
			
			view.getTblConnection().getColumnModel().getColumn(tblModel.COLUMN_ARRIVAL_TIME).setHeaderValue(lh.getString("arrivalTime"));
			view.getTblConnection().getColumnModel().getColumn(tblModel.COLUMN_DEPARTURE_TIME).setHeaderValue(lh.getString("departureTime"));
			view.getTblConnection().getColumnModel().getColumn(tblModel.COLUMN_DURATION).setHeaderValue(lh.getString("duration"));
			view.getTblConnection().getColumnModel().getColumn(tblModel.COLUMN_NUMBER_OF_VIAS).setHeaderValue(lh.getString("numberOfVias"));
			view.getTblConnection().getColumnModel().getColumn(tblModel.COLUMN_FROM_TO).setHeaderValue(lh.getString("fromTo"));
			view.getTblConnection().getTableHeader().repaint();
			
			
		}
		
	}

}
