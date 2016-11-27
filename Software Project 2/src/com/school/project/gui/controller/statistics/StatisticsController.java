package com.school.project.gui.controller.statistics;

import java.util.Observable;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.model.statistics.AbstractChartModel;
import com.school.project.gui.model.statistics.data.BestTicketSaleStatistic;
import com.school.project.gui.model.statistics.data.TicketSaleByUsersStatistic;
import com.school.project.gui.view.statistics.StatisticsView;

public class StatisticsController extends BaseController<StatisticsView> {

	public StatisticsController() {
		super(new StatisticsView());
	}

	@Override
	public void update(Observable o, Object arg) {
	}
	
	private void updateDataset() {
		new Thread(() -> {
			view.getTabbedPane().removeAll();
			view.getTabbedPane().add("Ticket Sales", createChartModel(new TicketSaleByUsersStatistic()));
			view.getTabbedPane().add("Best Ticket Sales", createChartModel(new BestTicketSaleStatistic()));
			view.repaint();
		}).start();
	}
	
	private ChartPanel createChartModel(AbstractChartModel model) {
		JFreeChart chart = model.createChart();
		chart.setPadding(new RectangleInsets());
		ChartPanel c = new ChartPanel(chart);
		c.setMouseWheelEnabled(true);
		c.setMouseZoomable(true);
		return c;
	}
	
	@Override
	public void show() {
		updateDataset();
	}
}
