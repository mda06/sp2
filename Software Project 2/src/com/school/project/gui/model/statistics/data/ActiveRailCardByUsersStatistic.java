package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.User;

public class ActiveRailCardByUsersStatistic extends AbstractPieChartModel {

	public ActiveRailCardByUsersStatistic() {
		super("Active Railcard by users");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<User, Integer> map = ActiveRailCardDAO.getInstance().getActiveRailCardByUserStatistic();
		for(Entry<User, Integer> e : map.entrySet()){
			dataset.setValue(e.getKey().getLastName() + " " + e.getKey().getFirstName(), e.getValue());
		}
		return dataset;
	}
}
