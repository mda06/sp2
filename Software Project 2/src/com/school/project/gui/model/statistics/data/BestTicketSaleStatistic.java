package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.Ticket;

public class BestTicketSaleStatistic extends AbstractPieChartModel {

	public BestTicketSaleStatistic() {
		super("Best ticket sale");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<Ticket, Integer> map = TicketSaleDAO.getInstance().getBestTicketSaleStatistic();
		for(Entry<Ticket, Integer> e : map.entrySet()) {
			dataset.setValue(e.getKey().getName(), e.getValue());
		}
		return dataset;
	}


}
