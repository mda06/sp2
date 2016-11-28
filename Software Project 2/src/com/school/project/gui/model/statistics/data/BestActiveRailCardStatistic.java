package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.ActiveRailCard;

public class BestActiveRailCardStatistic extends AbstractPieChartModel{

	public BestActiveRailCardStatistic() {
		super("Best Active Railcard");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<ActiveRailCard, Integer> map = ActiveRailCardDAO.getInstance().getBestActiveRailCardStatistic();
		for(Entry<ActiveRailCard, Integer> e : map.entrySet()){
			dataset.setValue(e.getKey().getInNameOf().getLastName() + " " + e.getKey().getInNameOf().getFirstName(), e.getValue());
		}
		return dataset;
	}

}
