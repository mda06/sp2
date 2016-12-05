package com.school.project.gui.view;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import com.school.project.util.FontUtil;

public class SettingsView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabs;
	
	public SettingsView() {
		super("Settings");
		initLayout();
	}	
	
	private void initLayout() {
		tabs = new JTabbedPane();
		setLayout(new BorderLayout());
		add(tabs);
	}
	
	public JTabbedPane getTabbedPane() {
		return tabs;
	}
}
