package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.RailCard;

public class BestSoldRailcardStatistic extends AbstractPieChartModel {

	public BestSoldRailcardStatistic() {
		super("Best-selling railcards");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<RailCard, Integer> map = ActiveRailCardDAO.getInstance().getBestSoldRailcardStatistic();
		for(Entry<RailCard, Integer> e : map.entrySet()){
			dataset.setValue(e.getKey().getName(), e.getValue());
		}
		return dataset;
	}

}
