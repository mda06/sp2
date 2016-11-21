package com.school.project.gui.view.statistics;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;

import com.school.project.gui.model.statistics.AbstractChartModel;
import com.school.project.gui.model.statistics.data.TicketSaleByUsersStatistic;
import com.school.project.gui.view.BaseView;

public class StatisticsView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private List<ChartPanel> charts;

	public StatisticsView() {
		super("statistics");
		initLayout();
	}

	private void initLayout() {
		tabbedPane = new JTabbedPane();
		charts = new ArrayList<ChartPanel>();
		setLayout(new BorderLayout());
		add(tabbedPane);
		charts.add((ChartPanel) tabbedPane.add("Ticket Sales", createChartModel(new TicketSaleByUsersStatistic())));
	}

	public void updateDataset() {
		new Thread(() -> {
			for(ChartPanel cp : charts)
				cp.getChart().setNotify(true);
		}).start();
	}

	public ChartPanel createChartModel(AbstractChartModel model) {
		JFreeChart chart = model.createChart();
		chart.setPadding(new RectangleInsets());
		ChartPanel c = new ChartPanel(chart);
		c.setMouseWheelEnabled(true);
		c.setMouseZoomable(true);
		return c;
	}

}
