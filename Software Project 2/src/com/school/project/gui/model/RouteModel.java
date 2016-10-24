package com.school.project.gui.model;

import java.util.Observable;
import java.util.Observer;

import com.school.project.gui.view.RouteView;

public class RouteModel implements Observer {
@SuppressWarnings("unused")
private RouteView view;

	public RouteModel(RouteView view) {
	this.view = view;
}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
