package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.User;

public class TotalSoldTicketsByUserStatistic extends AbstractPieChartModel {

	public TotalSoldTicketsByUserStatistic() {
		super("Total price of tickets by user");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<User, Double> map = TicketSaleDAO.getInstance().getTotalTicketsSoldByUser();
		for(Entry<User,Double> e : map.entrySet()){
			dataset.setValue(String.format("%s %s: %.2f$", e.getKey().getFirstName(), e.getKey().getLastName(), e.getValue()), e.getValue());
		}
		return dataset;
	}
}
