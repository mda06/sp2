package com.school.project.gui.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RouteView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTextField txtDeparture, txtArrival, txtUur, txtDate;
	private JLabel lbDeparture, lbArrival, lbNumber, lbUur, lbDate;
	private JRadioButton rbSingle, rbReturn, rbDeparture, rbArrival;
	private JComboBox<Integer> cbNumber;
	private JButton btnShowTickets, btnBack;

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
		txtDeparture = new JTextField(20);
		txtArrival = new JTextField(20);
		txtUur = new JTextField(houreFormat.format(hour));
		txtDate = new JTextField(dateFormat.format(date));
		lbDeparture = new JLabel("Departure:");
		lbArrival = new JLabel("Arrival:");
		lbNumber = new JLabel("Number");
		lbUur = new JLabel("Uur:");
		lbDate = new JLabel("Date: ");
		rbSingle = new JRadioButton("Single");
		rbReturn = new JRadioButton("Return");
		rbDeparture = new JRadioButton("Departure");
		rbArrival = new JRadioButton("Arrival");
		cbNumber = new JComboBox<Integer>();
		btnShowTickets = new JButton("Show Tickets");
		btnBack = new JButton("Back");

		// buttongroup
		ButtonGroup singleReturn = new ButtonGroup();
		singleReturn.add(rbSingle);
		singleReturn.add(rbReturn);
		rbReturn.setSelected(true);

		ButtonGroup deparArriv = new ButtonGroup();
		deparArriv.add(rbArrival);
		deparArriv.add(rbDeparture);
		rbDeparture.setSelected(true);

		// opvullen combobox
		for (int i = 1; i < 11; i++) {
			cbNumber.addItem(i);
		}

		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(txtDeparture);
		add(txtArrival);
		add(txtUur);
		add(lbDeparture);
		add(lbArrival);
		add(lbNumber);
		add(lbUur);
		add(rbSingle);
		add(rbReturn);
		add(rbDeparture);
		add(rbArrival);
		add(cbNumber);
		add(btnShowTickets);
		add(btnBack);
		add(lbDate);
		add(txtDate);

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
		sp.putConstraint(SpringLayout.WEST, lbNumber, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbNumber, 245, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, cbNumber, 100, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, cbNumber, 240, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, btnShowTickets, 250, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, btnShowTickets, 240, SpringLayout.NORTH, this);
	}

	public JTextField getTxtDeparture() {
		return txtDeparture;
	}

	public void setTxtDeparture(JTextField txtDeparture) {
		this.txtDeparture = txtDeparture;
	}

	public JTextField getTxtArrival() {
		return txtArrival;
	}

	public void setTxtArrival(JTextField txtArrival) {
		this.txtArrival = txtArrival;
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

	public JLabel getLbNumber() {
		return lbNumber;
	}

	public void setLbNumber(JLabel lbNumber) {
		this.lbNumber = lbNumber;
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

	public JComboBox<Integer> getCbNumber() {
		return cbNumber;
	}

	public void setCbNumber(JComboBox<Integer> cbNumber) {
		this.cbNumber = cbNumber;
	}

	public JButton getBtnShowTickets() {
		return btnShowTickets;
	}

	public void setBtnShowTickets(JButton btnShowTickets) {
		this.btnShowTickets = btnShowTickets;
	}

}
