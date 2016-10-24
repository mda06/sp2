package com.school.project.gui.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class TicketView extends BaseView {
	private static final long serialVersionUID = 1L;

	List<JButton> buttonList = new ArrayList<>();

	public TicketView() {
		super("TicketView");

		initLayout();
	}

	private void initLayout() {
		buttonList.add(new JButton("Standaard Biljet"));
		buttonList.add(new JButton("Biljet Kind"));
		buttonList.add(new JButton("Biljet Grote Gezinnen"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Standaard Biljet"));
		buttonList.add(new JButton("Biljet Kind"));
		buttonList.add(new JButton("Biljet Grote Gezinnen"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));
		buttonList.add(new JButton("Test"));

		GridLayout gr = new GridLayout(0, 4, 5, 5);
		setLayout(gr);
		add(buttonList);
	}

	private void add(List<JButton> buttonList2) {
		for (JButton button : buttonList)
			add(button);
	}

}
