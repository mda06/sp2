package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.school.project.util.FontUtil;

public class ConnectionDetailsFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblDuration, lblDeparture, lblArrival;
	private JTextField txtDuration, txtDeparture, txtArrival;
	private JTable tblDetails;
	
	public ConnectionDetailsFrame() {
		initLayout();
		setAlwaysOnTop(true);
		setTitle("Details");
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initLayout() {
		lblDuration = new JLabel("Duration: ", JLabel.TRAILING);
		lblDeparture = new JLabel("Departure: ", JLabel.TRAILING);
		lblArrival = new JLabel("Arrival: ", JLabel.TRAILING);
		txtDuration = new JTextField(20);
		txtDuration.setEditable(false);
		txtArrival = new JTextField(20);
		txtArrival.setEditable(false);
		txtDeparture = new JTextField(20);
		txtDeparture.setEditable(false);
		tblDetails = new JTable();
		tblDetails.setRowHeight(30);
		JScrollPane scroll = new JScrollPane(tblDetails);
		
		JPanel pnlNorth = new JPanel(new GridLayout(3, 2));
		pnlNorth.add(lblDuration);
		pnlNorth.add(txtDuration);
		pnlNorth.add(lblDeparture);
		pnlNorth.add(txtDeparture);
		pnlNorth.add(lblArrival);
		pnlNorth.add(txtArrival);
		
		FontUtil.getInstance().bindSmallFont(lblDuration);
		FontUtil.getInstance().bindSmallFont(lblDeparture);
		FontUtil.getInstance().bindSmallFont(lblArrival);
		FontUtil.getInstance().bindSmallFont(txtDuration);
		FontUtil.getInstance().bindSmallFont(txtArrival);
		FontUtil.getInstance().bindSmallFont(txtDeparture);
		FontUtil.getInstance().bindSmallFont(tblDetails);
		FontUtil.getInstance().bindSmallFont(tblDetails.getTableHeader());
		
		add(pnlNorth, BorderLayout.NORTH);
		add(scroll);
	}

	public JLabel getLblDuration() {
		return lblDuration;
	}

	public JLabel getLblDeparture() {
		return lblDeparture;
	}

	public JLabel getLblArrival() {
		return lblArrival;
	}

	public JTextField getTxtDuration() {
		return txtDuration;
	}

	public JTextField getTxtDeparture() {
		return txtDeparture;
	}

	public JTextField getTxtArrival() {
		return txtArrival;
	}

	public JTable getTblDetails() {
		return tblDetails;
	}
}
