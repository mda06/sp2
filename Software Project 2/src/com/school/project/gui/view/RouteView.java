package com.school.project.gui.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import com.school.project.gui.view.custom.AutoComboBox;

public class RouteView extends BaseView {
	private static final long serialVersionUID = 1L;
	private AutoComboBox txtDeparture, txtArrival;
	private JLabel lbDeparture, lbArrival, lbUur, lbDate;
	private JRadioButton rbSingle, rbReturn, rbDeparture, rbArrival;
	private JButton btnShowConnections;
	private JFormattedTextField txtUur, txtDate;
	private JTable tblConnection;

	public RouteView() {
		super("Route");

		initLayout();
	}

	private void initLayout() {
		// Datum van vandaag
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// Huidig uur
		DateFormat houreFormat = new SimpleDateFormat("HH:mm");
		Date hour = new Date();
		//aanmaken objecten
		txtDeparture = new AutoComboBox();
		txtArrival = new AutoComboBox();
		txtUur = new JFormattedTextField(createFormatter("##:##"));
		txtUur.setColumns(4);
		txtUur.setText(houreFormat.format(hour));
		txtDate = new JFormattedTextField(createFormatter("##/##/####"));
		txtDate.setColumns(8);
		txtDate.setText(dateFormat.format(date));
		lbDeparture = new JLabel("Departure:");
		lbArrival = new JLabel("Arrival:");
		lbUur = new JLabel("Uur:");
		lbDate = new JLabel("Date: ");
		rbSingle = new JRadioButton("Single");
		rbReturn = new JRadioButton("Return");
		rbDeparture = new JRadioButton("Departure");
		rbArrival = new JRadioButton("Arrival");
		tblConnection = new JTable();
		JScrollPane scroll = new JScrollPane(tblConnection);
		btnShowConnections = new JButton("Show Connections");

		// buttongroup
		ButtonGroup singleReturn = new ButtonGroup();
		singleReturn.add(rbSingle);
		singleReturn.add(rbReturn);
		rbReturn.setSelected(true);

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
		add(rbSingle);
		add(rbReturn);
		add(rbDeparture);
		add(rbArrival);
		add(lbDate);
		add(txtDate);
		add(scroll);
		add(btnShowConnections);

		sp.putConstraint(SpringLayout.WEST, txtDeparture, 100, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtDeparture, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtArrival, 100, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtArrival, 100, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbArrival, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbArrival, 105, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbDeparture, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbDeparture, 65, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbSingle, 20, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbSingle, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbReturn, 150, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbReturn, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbDate, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbDate, 185, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtDate, 70, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtDate, 180, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbUur, 210, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbUur, 185, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtUur, 250, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtUur, 180, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbDeparture, 320, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbDeparture, 175, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbArrival, 320, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbArrival, 195, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, btnShowConnections, 250, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, btnShowConnections, 240, SpringLayout.NORTH, this);	
		sp.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.SOUTH, btnShowConnections);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -30, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.EAST, scroll, -30, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.WEST, scroll, 30, SpringLayout.WEST, this);
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
	
	public AutoComboBox getTxtDeparture(){
		return txtDeparture;
	}
	public AutoComboBox getTxtArrival(){
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

	public JFormattedTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JFormattedTextField txtDate) {
		this.txtDate = txtDate;
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

	public JRadioButton getRbSingle() {
		return rbSingle;
	}

	public void setRbSingle(JRadioButton rbSingle) {
		this.rbSingle = rbSingle;
	}

	public JRadioButton getRbReturn() {
		return rbReturn;
	}

	public void setRbReturn(JRadioButton rbReturn) {
		this.rbReturn = rbReturn;
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
	
	public JButton getBtnShowConnections(){
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
