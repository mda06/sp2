package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.gui.view.custom.AutoComboBox;
import com.school.project.util.FontUtil;

public class PaymentRailcardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnBack, btnPay, btnSelectUser;
	private JTextField txtName, txtSoldBy, txtValidFrom, txtValidTo, txtInNameOf;
	private JTextArea txtDesc;
	private AutoComboBox txtFromStation, txtToStation;
	private JLabel lblName, lblDesc, lblSoldBy, lblValidFrom, lblValidTo, lblInNameOf;
	private JLabel lblPricePerMonth, lblPricePer3Month, lblPricePerYear, lblFromStation, lblToStation;
	private JRadioButton rdPricePerMonth, rdPricePer3Month, rdPricePerYear;
	private ButtonGroup timePeriod;

	public PaymentRailcardPanel() {
		initLayout();

	}

	private void initLayout() {
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

		JPanel pnlDepartures = new JPanel(new GridLayout(2, 2));
		pnlDepartures.add(lblFromStation = new JLabel("From station: "));
		pnlDepartures.add(txtFromStation = new AutoComboBox());
		pnlDepartures.add(lblToStation = new JLabel("To station: "));
		pnlDepartures.add(txtToStation = new AutoComboBox());

		rdPricePerMonth = new JRadioButton("Price per month");
		rdPricePer3Month = new JRadioButton("Price per 3 month");
		rdPricePerYear = new JRadioButton("Price per year");

		c.weightx = 1;
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		pnlLeft.add(pnlDepartures, c);

		// Toevoegen van radiobuttons en text
		timePeriod = new ButtonGroup();
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		timePeriod.add(rdPricePerMonth);
		timePeriod.add(rdPricePer3Month);
		timePeriod.add(rdPricePerYear);
		rdPricePerMonth.setSelected(true);
		pnlLeft.add(rdPricePerMonth, c);
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(rdPricePer3Month, c);
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(rdPricePerYear, c);

		// Labels toevoegen
		lblPricePerMonth = new JLabel("One Month");
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(lblPricePerMonth, c);
		lblPricePer3Month = new JLabel("Three Month");
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(lblPricePer3Month, c);
		lblPricePerYear = new JLabel("Price Year");
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(lblPricePerYear, c);

		// Toevoegen pay button
		c.gridx = 1;
		c.gridy = 7;
		btnPay = new JButton("Pay");
		pnlLeft.add(btnPay, c);

		SpringLayout sp = new SpringLayout();
		JPanel pnlRight = new JPanel(sp);
		pnlRight.setPreferredSize(new Dimension(500, 500));
		pnlRight.add(lblSoldBy = new JLabel("Sold by: "));
		pnlRight.add(txtSoldBy = new JTextField(12));
		txtSoldBy.setEditable(false);
		pnlRight.add(lblInNameOf = new JLabel("In name of: "));
		pnlRight.add(txtInNameOf = new JTextField(12));
		txtInNameOf.setEditable(false);
		pnlRight.add(lblValidFrom = new JLabel("Valid from: "));
		pnlRight.add(txtValidFrom = new JTextField());
		txtValidFrom.setEditable(false);
		pnlRight.add(lblValidTo = new JLabel("Valid by: "));
		pnlRight.add(txtValidTo = new JTextField());
		txtValidTo.setEditable(false);

		pnlRight.add(btnSelectUser = new JButton("User"));

		sp.putConstraint(SpringLayout.NORTH, txtSoldBy, 50, SpringLayout.NORTH, pnlRight);
		sp.putConstraint(SpringLayout.EAST, txtSoldBy, -30, SpringLayout.EAST, pnlRight);
		sp.putConstraint(SpringLayout.NORTH, lblSoldBy, 0, SpringLayout.NORTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, lblSoldBy, -30, SpringLayout.WEST, txtSoldBy);

		sp.putConstraint(SpringLayout.NORTH, txtInNameOf, 10, SpringLayout.SOUTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, txtInNameOf, 0, SpringLayout.EAST, txtSoldBy);
		sp.putConstraint(SpringLayout.WEST, txtInNameOf, 0, SpringLayout.WEST, txtSoldBy);
		sp.putConstraint(SpringLayout.NORTH, lblInNameOf, 0, SpringLayout.NORTH, txtInNameOf);
		sp.putConstraint(SpringLayout.EAST, lblInNameOf, 0, SpringLayout.EAST, lblSoldBy);
		
		sp.putConstraint(SpringLayout.NORTH, txtValidFrom, 230, SpringLayout.NORTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, txtValidFrom, 0, SpringLayout.EAST, txtSoldBy);
		sp.putConstraint(SpringLayout.NORTH, lblValidFrom, 0, SpringLayout.NORTH, txtValidFrom);
		sp.putConstraint(SpringLayout.EAST, lblValidFrom, -10, SpringLayout.WEST, txtValidFrom);
		sp.putConstraint(SpringLayout.NORTH, txtValidTo, 50, SpringLayout.NORTH, txtValidFrom);
		sp.putConstraint(SpringLayout.EAST, txtValidTo, 0, SpringLayout.EAST, txtValidFrom);
		sp.putConstraint(SpringLayout.NORTH, lblValidTo, 0, SpringLayout.NORTH, txtValidTo);
		sp.putConstraint(SpringLayout.EAST, lblValidTo, -10, SpringLayout.WEST, txtValidTo);
		
		sp.putConstraint(SpringLayout.EAST, btnSelectUser, 0, SpringLayout.EAST, txtSoldBy);
		sp.putConstraint(SpringLayout.SOUTH, btnSelectUser, -10, SpringLayout.NORTH, txtSoldBy);
		sp.putConstraint(SpringLayout.WEST, btnSelectUser, 0, SpringLayout.WEST, lblInNameOf);

		add(pnlLeft);
		add(pnlRight, BorderLayout.EAST);
		JPanel pnlBack = new JPanel();
		pnlBack.add(btnBack = new JButton("Back"));
		add(pnlBack, BorderLayout.NORTH);
		
		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN,18));
		
		FontUtil.getInstance().bindBigFont(txtName);
		FontUtil.getInstance().bindBigFont(btnBack);
		
		FontUtil.getInstance().bindSmallFont(txtSoldBy);
		FontUtil.getInstance().bindSmallFont(lblSoldBy);
		FontUtil.getInstance().bindSmallFont(txtValidFrom);
		FontUtil.getInstance().bindSmallFont(txtValidTo);
		FontUtil.getInstance().bindSmallFont(lblValidFrom);
		FontUtil.getInstance().bindSmallFont(lblValidTo);
		FontUtil.getInstance().bindSmallFont(lblFromStation);
		FontUtil.getInstance().bindSmallFont(lblToStation);
		FontUtil.getInstance().bindSmallFont(lblDesc);
		FontUtil.getInstance().bindSmallFont(lblName);
		FontUtil.getInstance().bindSmallFont(btnPay);
		FontUtil.getInstance().bindSmallFont(txtFromStation); 
		FontUtil.getInstance().bindSmallFont(txtToStation);
		FontUtil.getInstance().bindSmallFont(btnSelectUser);
		FontUtil.getInstance().bindSmallFont(txtInNameOf);
		FontUtil.getInstance().bindSmallFont(lblInNameOf);
		FontUtil.getInstance().bindSmallFont(lblPricePerMonth);
		FontUtil.getInstance().bindSmallFont(lblPricePer3Month);
		FontUtil.getInstance().bindSmallFont(lblPricePerYear);
		FontUtil.getInstance().bindSmallFont(rdPricePerMonth);
		FontUtil.getInstance().bindSmallFont(rdPricePer3Month);
		FontUtil.getInstance().bindSmallFont(rdPricePerYear);
		
	}

	public ButtonGroup getTimePeriod() {
		return timePeriod;
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

	public JLabel getLblInNameOf() {
		return lblInNameOf;
	}
	
	public JTextField getTxtValidTo() {
		return txtValidTo;
	}

	public void setTxtValidTo(JTextField txtValidTo) {
		this.txtValidTo = txtValidTo;
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

	public JLabel getLblPricePerYear() {
		return lblPricePerYear;
	}

	public void setLblPricePerYear(JLabel lblPricePerYear) {
		this.lblPricePerYear = lblPricePerYear;
	}

	public JLabel getLblPricePerMonth() {
		return lblPricePerMonth;
	}

	public void setLblPricePerMonth(JLabel lblPricePerMonth) {
		this.lblPricePerMonth = lblPricePerMonth;
	}

	public JLabel getLblPricePer3Month() {
		return lblPricePer3Month;
	}

	public void setLblPricePer3Month(JLabel lblPricePer3Month) {
		this.lblPricePer3Month = lblPricePer3Month;
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
