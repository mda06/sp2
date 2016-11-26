package com.school.project.gui.view.settings;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TicketEditorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	

	private JButton btnBack, btnSave;
	private JTextField txtName, txtPrice;
	private JTextArea txtDesc;

	private JLabel lblName, lblDesc, lblPrice;

	private JCheckBox cbHasFixedRoute;

	public TicketEditorPanel() {
		btnBack = new JButton("Back");
		btnSave = new JButton("Save");

		txtName = new JTextField();
		txtPrice = new JTextField();
		txtDesc = new JTextArea();

		lblName = new JLabel("Name");
		lblDesc = new JLabel("Desc");
		lblPrice = new JLabel("Price");

		cbHasFixedRoute = new JCheckBox("fixed route");

		initLayout();
	}

	private void initLayout() {

		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		//TODO: deftige layout
		add(txtName, BorderLayout.LINE_START);
		add(txtPrice, BorderLayout.LINE_END);
		add(txtDesc, BorderLayout.CENTER);
		add(btnSave, BorderLayout.AFTER_LAST_LINE);
		add(cbHasFixedRoute, BorderLayout.EAST);
		add(btnBack, BorderLayout.NORTH);

		

	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

	public JTextArea getTxtDesc() {
		return txtDesc;
	}

	public void setTxtDesc(JTextArea txtDesc) {
		this.txtDesc = txtDesc;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblDesc() {
		return lblDesc;
	}

	public void setLblDesc(JLabel lblDesc) {
		this.lblDesc = lblDesc;
	}

	public JLabel getLblPrice() {
		return lblPrice;
	}

	public void setLblPrice(JLabel lblPrice) {
		this.lblPrice = lblPrice;
	}

	public JCheckBox getCbHasFixedRoute() {
		return cbHasFixedRoute;
	}

	public void setCbHasFixedRoute(JCheckBox hasFixedRoute) {
		this.cbHasFixedRoute = hasFixedRoute;
	}

}
