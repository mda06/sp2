package com.school.project.gui.model.statistics.data;

import java.util.HashMap;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;

import com.school.project.dao.UserDAO;
import com.school.project.gui.model.statistics.AbstractPieChartModel;
import com.school.project.model.Address;

public class AddressFromUserStatistic extends AbstractPieChartModel{

	public AddressFromUserStatistic() {
		super("Origin customers");
	}

	@Override
	protected DefaultPieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<Address, Integer> map = UserDAO.getInstance().getAddressUserStatistic();
		for(Entry<Address, Integer> e : map.entrySet()){
			dataset.setValue(e.getKey().getCity(), e.getValue());
		}
		return dataset;
	}
	

}
