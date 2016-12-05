package com.school.project.gui.controller.statistics;

import java.util.Observable;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.model.statistics.AbstractChartModel;
import com.school.project.gui.model.statistics.data.ActiveRailCardByUsersStatistic;
import com.school.project.gui.model.statistics.data.AddressFromUserStatistic;
import com.school.project.gui.model.statistics.data.BestActiveRailCardStatistic;
import com.school.project.gui.model.statistics.data.BestSoldRailcardStatistic;
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
			view.getTabbedPane().add("Tickets sold by user", createChartModel(new TicketSaleByUsersStatistic()));
			view.getTabbedPane().add("Best-selling tickets", createChartModel(new BestTicketSaleStatistic()));
			view.getTabbedPane().add("Active railcards sold by user", createChartModel(new ActiveRailCardByUsersStatistic()));
			view.getTabbedPane().add("Best-selling active railcards", createChartModel(new BestSoldRailcardStatistic()));
			view.getTabbedPane().add("Railcards in name of", createChartModel(new BestActiveRailCardStatistic()));
			view.getTabbedPane().add("Origin Customer", createChartModel(new AddressFromUserStatistic()));
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
