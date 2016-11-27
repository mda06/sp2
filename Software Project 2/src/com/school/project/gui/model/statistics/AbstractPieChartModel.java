package com.school.project.gui.model.statistics;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Point;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;

public abstract class AbstractPieChartModel extends AbstractChartModel {

	public AbstractPieChartModel(String title) {
		super(title);
	}

	protected abstract DefaultPieDataset createDataset();

	@Override
	public JFreeChart createChart() {
		JFreeChart chart = ChartFactory.createPieChart(title, createDataset(), false, true, false);
		chart.setBackgroundPaint(new GradientPaint(new Point(), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

		TextTitle t = chart.getTitle();
		t.setHorizontalAlignment(HorizontalAlignment.LEFT);
		t.setPaint(new Color(240, 240, 240));
		return chart;
	}
}
