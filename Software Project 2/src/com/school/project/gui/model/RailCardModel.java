package com.school.project.gui.model;

import java.util.Observable;
import java.util.Observer;

import com.school.project.gui.view.RailCardView;

public class RailCardModel implements Observer {
	@SuppressWarnings("unused")
	private RailCardView view;

	public RailCardModel(RailCardView view) {
		this.view = view;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
