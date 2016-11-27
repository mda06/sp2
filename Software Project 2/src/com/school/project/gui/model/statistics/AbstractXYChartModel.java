package com.school.project.gui.model.statistics;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;

public abstract class AbstractXYChartModel extends AbstractChartModel {

	protected String xAxis, yAxis;

	public AbstractXYChartModel(String title, String x, String y) {
		super(title);
		xAxis = x;
		yAxis = y;
	}

	protected abstract XYDataset createDataset();

	public JFreeChart createChart() {
		final JFreeChart chart = ChartFactory.createXYLineChart(title, xAxis, yAxis, createDataset(), PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

	public String getxAxis() {
		return xAxis;
	}

	public String getyAxis() {
		return yAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}
}
