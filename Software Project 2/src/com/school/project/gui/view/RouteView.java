package com.school.project.gui.view;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.school.project.gui.model.DateRouteFormatter;
import com.school.project.gui.view.custom.AutoComboBox;

public class RouteView extends BaseView {
	private static final long serialVersionUID = 1L;
	private AutoComboBox txtDeparture, txtArrival;
	private JLabel lbDeparture, lbArrival, lbUur, lbDate;
	private JRadioButton rbDeparture, rbArrival;
	private JButton btnShowConnections;
	private JFormattedTextField txtUur;
	private JDatePickerImpl datePicker;
	private JTable tblConnection;

	public RouteView() {
		super("Route");

		initLayout();
	}

	private void initLayout() {
		// Huidig uur
		DateFormat houreFormat = new SimpleDateFormat("HH:mm");
		Date hour = new Date();
		// aanmaken objecten
		txtDeparture = new AutoComboBox();
		txtArrival = new AutoComboBox();
		txtUur = new JFormattedTextField(createFormatter("##:##"));
		txtUur.setColumns(4);
		txtUur.setText(houreFormat.format(hour));
		UtilDateModel dateModel = new UtilDateModel();
		Calendar cal = Calendar.getInstance();
		dateModel.setValue(cal.getTime());
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());
		datePicker = new JDatePickerImpl(datePanel, new DateRouteFormatter());

		lbDeparture = new JLabel("Departure:");
		lbArrival = new JLabel("Arrival:");
		lbUur = new JLabel("Uur:");
		lbDate = new JLabel("Date: ");
		rbDeparture = new JRadioButton("Departure");
		rbArrival = new JRadioButton("Arrival");
		tblConnection = new JTable();
		JScrollPane scroll = new JScrollPane(tblConnection);
		btnShowConnections = new JButton("Show Connections");

		ButtonGroup deparArriv = new ButtonGroup();
		deparArriv.add(rbArrival);
		deparArriv.add(rbDeparture);
		rbDeparture.setSelected(true);

		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(txtDeparture);
		add(txtArrival);
		add(txtUur);
		add(lbDeparture);
		add(lbArrival);
		add(lbUur);
		add(rbDeparture);
		add(rbArrival);
		add(lbDate);
		add(datePicker);
		add(scroll);
		add(btnShowConnections);

		sp.putConstraint(SpringLayout.WEST, txtDeparture, 200, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtDeparture, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtArrival, 200, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtArrival, 100, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbArrival, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbArrival, 105, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbDeparture, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbDeparture, 65, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbDate, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbDate, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, datePicker, 200, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, datePicker, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbUur, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbUur, 185, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtUur, 0, SpringLayout.WEST, txtDeparture);
		sp.putConstraint(SpringLayout.NORTH, txtUur, 180, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbDeparture, 50, SpringLayout.EAST, txtUur);
		sp.putConstraint(SpringLayout.NORTH, rbDeparture, 0, SpringLayout.NORTH, txtUur);
		sp.putConstraint(SpringLayout.WEST, rbArrival, 200, SpringLayout.WEST, rbDeparture);
		sp.putConstraint(SpringLayout.NORTH, rbArrival, 0, SpringLayout.NORTH, rbDeparture);
		sp.putConstraint(SpringLayout.WEST, btnShowConnections, 100, SpringLayout.EAST, txtDeparture);
		sp.putConstraint(SpringLayout.EAST, btnShowConnections, 500, SpringLayout.WEST, btnShowConnections);
		sp.putConstraint(SpringLayout.NORTH, btnShowConnections, 0, SpringLayout.NORTH, txtDeparture);
		sp.putConstraint(SpringLayout.SOUTH, btnShowConnections, 0, SpringLayout.SOUTH, rbArrival);
		sp.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.SOUTH, btnShowConnections);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -30, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.EAST, scroll, -30, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.WEST, scroll, 30, SpringLayout.WEST, this);
		
		Font small = new Font("Arial", Font.PLAIN, 24);
		Font big = new Font("Arial", Font.PLAIN, 30);
		
		txtDeparture.setFont(small);
		txtArrival.setFont(small);
		lbDeparture.setFont(small);
		lbArrival.setFont(small);
		lbUur.setFont(small);
		lbDate.setFont(small);
		rbDeparture.setFont(small);
		rbArrival.setFont(small);
		txtUur.setFont(small);
		datePicker.setFont(small);
		tblConnection.setFont(small);
		tblConnection.getTableHeader().setFont(small);
		tblConnection.setRowHeight(30);
		
		btnShowConnections.setFont(big);
		
	}

	public void setTxtDeparture(AutoComboBox txtDeparture) {
		this.txtDeparture = txtDeparture;
	}

	public JTable getTblConnection() {
		return tblConnection;
	}

	public void setTblConnection(JTable tblConnection) {
		this.tblConnection = tblConnection;
	}

	public void setTxtArrival(AutoComboBox txtArrival) {
		this.txtArrival = txtArrival;
	}

	public AutoComboBox getTxtDeparture() {
		return txtDeparture;
	}

	public AutoComboBox getTxtArrival() {
		return txtArrival;
	}

	public JLabel getLbUur() {
		return lbUur;
	}

	public void setLbUur(JLabel lbUur) {
		this.lbUur = lbUur;
	}

	public JLabel getLbDate() {
		return lbDate;
	}

	public void setLbDate(JLabel lbDate) {
		this.lbDate = lbDate;
	}

	public JFormattedTextField getTxtUur() {
		return txtUur;
	}

	public void setTxtUur(JFormattedTextField txtUur) {
		this.txtUur = txtUur;
	}

	public JDatePickerImpl getTxtDate() {
		return datePicker;
	}

	public JLabel getLbDeparture() {
		return lbDeparture;
	}

	public void setLbDeparture(JLabel lbDeparture) {
		this.lbDeparture = lbDeparture;
	}

	public JLabel getLbArrival() {
		return lbArrival;
	}

	public void setLbArrival(JLabel lbArrival) {
		this.lbArrival = lbArrival;
	}

	public JRadioButton getRbDeparture() {
		return rbDeparture;
	}

	public void setRbDeparture(JRadioButton rbDeparture) {
		this.rbDeparture = rbDeparture;
	}

	public JRadioButton getRbArrival() {
		return rbArrival;
	}

	public void setRbArrival(JRadioButton rbArrival) {
		this.rbArrival = rbArrival;
	}

	public JButton getBtnShowConnections() {
		return btnShowConnections;
	}

	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}

}
