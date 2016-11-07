package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.school.project.gui.view.custom.AutoComboBox;

public class PaymentPanelRailcard extends JPanel{
	private JButton btnBack, btnPay, btnSelectUser;
	private JTextField txtName, txtSoldBy, txtValidFrom, txtValidTo, txtPrice, txtInNameOf;
	private JTextArea txtDesc;
	private AutoComboBox txtFromStation, txtToStation;
	private JLabel lblName, lblDesc, lblSoldBy, lblValidFrom, lblValidTo, lblPrice, lblFromStation, lblToStation; 
	private JRadioButton rdPricePerMonth, rdPricePer3Month, rdPricePerYear;
	
	public PaymentPanelRailcard(){
		initLayout();
	}
	private void initLayout(){
		setLayout(new BorderLayout());
		
		JPanel pnlLeft = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lblName = new JLabel("Name: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 35;
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 0;
		pnlLeft.add(lblName, c);
		txtName = new JTextField(20);
		txtName.setEditable(false);
		c.gridx = 1;
		c.weightx = 1;
		pnlLeft.add(txtName, c);
		lblDesc = new JLabel("Description: ");
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 1;
		pnlLeft.add(lblDesc, c);
		txtDesc = new JTextArea(2, 20);
		txtDesc.setEditable(false);
		c.weightx = 1;
		c.gridx = 1;
		pnlLeft.add(txtDesc, c);
		
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	public JButton getBtnPay() {
		return btnPay;
	}
	public void setBtnPay(JButton btnPay) {
		this.btnPay = btnPay;
	}
	public JButton getBtnSelectUser() {
		return btnSelectUser;
	}
	public void setBtnSelectUser(JButton btnSelectUser) {
		this.btnSelectUser = btnSelectUser;
	}
	public JTextField getTxtName() {
		return txtName;
	}
	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}
	public JTextField getTxtSoldBy() {
		return txtSoldBy;
	}
	public void setTxtSoldBy(JTextField txtSoldBy) {
		this.txtSoldBy = txtSoldBy;
	}
	public JTextField getTxtValidFrom() {
		return txtValidFrom;
	}
	public void setTxtValidFrom(JTextField txtValidFrom) {
		this.txtValidFrom = txtValidFrom;
	}
	public JTextField getTxtValidTo() {
		return txtValidTo;
	}
	public void setTxtValidTo(JTextField txtValidTo) {
		this.txtValidTo = txtValidTo;
	}
	public JTextField getTxtPrice() {
		return txtPrice;
	}
	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}
	public JTextField getTxtInNameOf() {
		return txtInNameOf;
	}
	public void setTxtInNameOf(JTextField txtInNameOf) {
		this.txtInNameOf = txtInNameOf;
	}
	public JTextArea getTxtDesc() {
		return txtDesc;
	}
	public void setTxtDesc(JTextArea txtDesc) {
		this.txtDesc = txtDesc;
	}
	public AutoComboBox getTxtFromStation() {
		return txtFromStation;
	}
	public void setTxtFromStation(AutoComboBox txtFromStation) {
		this.txtFromStation = txtFromStation;
	}
	public AutoComboBox getTxtToStation() {
		return txtToStation;
	}
	public void setTxtToStation(AutoComboBox txtToStation) {
		this.txtToStation = txtToStation;
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
	public JLabel getLblSoldBy() {
		return lblSoldBy;
	}
	public void setLblSoldBy(JLabel lblSoldBy) {
		this.lblSoldBy = lblSoldBy;
	}
	public JLabel getLblValidFrom() {
		return lblValidFrom;
	}
	public void setLblValidFrom(JLabel lblValidFrom) {
		this.lblValidFrom = lblValidFrom;
	}
	public JLabel getLblValidTo() {
		return lblValidTo;
	}
	public void setLblValidTo(JLabel lblValidTo) {
		this.lblValidTo = lblValidTo;
	}
	public JLabel getLblPrice() {
		return lblPrice;
	}
	public void setLblPrice(JLabel lblPrice) {
		this.lblPrice = lblPrice;
	}
	public JLabel getLblFromStation() {
		return lblFromStation;
	}
	public void setLblFromStation(JLabel lblFromStation) {
		this.lblFromStation = lblFromStation;
	}
	public JLabel getLblToStation() {
		return lblToStation;
	}
	public void setLblToStation(JLabel lblToStation) {
		this.lblToStation = lblToStation;
	}
	public JRadioButton getRdPricePerMonth() {
		return rdPricePerMonth;
	}
	public void setRdPricePerMonth(JRadioButton rdPricePerMonth) {
		this.rdPricePerMonth = rdPricePerMonth;
	}
	public JRadioButton getRdPricePer3Month() {
		return rdPricePer3Month;
	}
	public void setRdPricePer3Month(JRadioButton rdPricePer3Month) {
		this.rdPricePer3Month = rdPricePer3Month;
	}
	public JRadioButton getRdPricePerYear() {
		return rdPricePerYear;
	}
	public void setRdPricePerYear(JRadioButton rdPricePerYear) {
		this.rdPricePerYear = rdPricePerYear;
	}
	
	
}
