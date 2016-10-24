package com.school.project.gui.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RouteView extends BaseView {
	private static final long serialVersionUID = 1L;
	private JTextField txtDeparture, txtArrival, txtUur;
	private JLabel lbDeparture, lbArrival, lbNumber, lbUur;
	private JRadioButton rbSingle, rbReturn, rbDeparture, rbArrival;
	private JComboBox<Integer> cbNumber;
	private JButton btnShowTickets, btnBack;

	public RouteView() {
		super("Route");

		initLayout();
	}

	private void initLayout() {
		txtDeparture = new JTextField(20);
		txtArrival = new JTextField(20);
		txtUur = new JTextField(5);
		lbDeparture = new JLabel("Departure:");
		lbArrival = new JLabel("Arrival:");
		lbNumber = new JLabel("Number");
		lbUur = new JLabel("Uur:");
		rbSingle = new JRadioButton("Single");
		rbReturn = new JRadioButton("Return");
		rbDeparture = new JRadioButton("Departure");
		rbArrival = new JRadioButton("Arrival");
		cbNumber = new JComboBox<Integer>();
		btnShowTickets = new JButton("Show Tickets");
		btnBack = new JButton("Back");
		
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
		
		sp.putConstraint(SpringLayout.WEST, txtDeparture, 100, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtDeparture, 60, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtArrival, 100, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtArrival, 100, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbArrival, 30, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbArrival, 105, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbDeparture, 30, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, lbDeparture, 65, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbSingle, 20, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbSingle, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbReturn, 150, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbReturn, 140, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, lbUur, 150, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lbUur, 185, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, txtUur, 180, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, txtUur, 180, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.WEST, rbDeparture, 270, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbDeparture, 175, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.WEST, rbArrival, 270, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, rbArrival, 195, SpringLayout.WEST, this);
		
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