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
import com.school.project.gui.model.statistics.data.TotalSoldTicketsByUserStatistic;
import com.school.project.gui.view.statistics.StatisticsView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;

public class StatisticsController extends BaseController<StatisticsView> {

	private String strTicketsSold = "Tickets sold";
	private String strBestSellingTk = "Best-selling tickets";
	private String strACRSold = "Active railcards sold by user";
	private String strBestSellingACR = "Best-selling active railcards";
	private String strRailcardInNameOf = "Railcards in name of";
	private String strOriginCust = "Origin customers";
	private String strTicketRevenue = "Ticket revenue by user";
	
	public StatisticsController() {
		super(new StatisticsView());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o).getLanguageHandler();
			strTicketsSold = lh.getString("ticketsSold");
			strBestSellingTk = lh.getString("bestSellingTickets");
			strACRSold = lh.getString("acrSold");
			strBestSellingACR = lh.getString("bestSellingACR");
			strRailcardInNameOf = lh.getString("railcardInNameOf");
			strOriginCust = lh.getString("originCustomers");
			strTicketRevenue = lh.getString("ticketRevenue");
		}
	}
	
	private void updateDataset() {
		new Thread(() -> {
			view.getTabbedPane().removeAll();
			view.getTabbedPane().add(strTicketsSold, createChartModel(new TicketSaleByUsersStatistic()));
			view.getTabbedPane().add(strBestSellingTk, createChartModel(new BestTicketSaleStatistic()));
			view.getTabbedPane().add(strACRSold, createChartModel(new ActiveRailCardByUsersStatistic()));
			view.getTabbedPane().add(strBestSellingACR, createChartModel(new BestSoldRailcardStatistic()));
			view.getTabbedPane().add(strRailcardInNameOf, createChartModel(new BestActiveRailCardStatistic()));
			view.getTabbedPane().add(strOriginCust, createChartModel(new AddressFromUserStatistic()));
			view.getTabbedPane().add(strTicketRevenue, createChartModel(new TotalSoldTicketsByUserStatistic()));
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
