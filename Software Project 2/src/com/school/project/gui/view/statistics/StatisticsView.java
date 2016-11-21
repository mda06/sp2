package com.school.project.gui.view.statistics;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import com.school.project.gui.view.BaseView;

public class StatisticsView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	
	public StatisticsView() {
		super("statistics");
		initLayout();
	}
	
	private void initLayout() {
		tabbedPane = new JTabbedPane();
		setLayout(new BorderLayout());
		add(tabbedPane);
	}
	
	private void showStatistics() {
		//New thread...
	}

	@Override
	public void show() {
		showStatistics();
	}
}
