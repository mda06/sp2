package com.school.project.gui.model.statistics;

import org.jfree.chart.JFreeChart;

public abstract class AbstractChartModel {
	protected String title;
	
	public AbstractChartModel(String title) {
		this.title = title;
	}
	
	public abstract JFreeChart createChart() ;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
