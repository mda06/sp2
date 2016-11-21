package com.school.project.gui.controller.statistics;

import java.util.Observable;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.statistics.StatisticsView;

public class StatisticsController extends BaseController<StatisticsView> {

	public StatisticsController() {
		super(new StatisticsView());
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
