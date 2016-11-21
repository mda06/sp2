package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.User;

public class TicketSaleByUsersStatistic extends AbstractPieChartModel {

	public TicketSaleByUsersStatistic() {
		super("Ticket sale by users");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<User, Integer> map = TicketSaleDAO.getInstance().getTicketSaleByUserStatistic();
		for(Entry<User, Integer> e : map.entrySet()) {
			dataset.setValue(e.getKey().getFirstName(), e.getValue());
		}
		return dataset;
	}

}
