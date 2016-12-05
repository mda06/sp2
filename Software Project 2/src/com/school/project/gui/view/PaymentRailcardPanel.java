package com.school.project.gui.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
	private JScrollPane scrollPane;

	public PaymentRailcardPanel() {
		initLayout();

	}

	private void initLayout() {
		SpringLayout sp = new SpringLayout();
		JPanel pnlLeft = new JPanel(sp);
		setLayout(sp);

		lblName = new JLabel("Name: ");
		txtName = new JTextField(20);
		txtName.setEditable(false);
		lblDesc = new JLabel("Description: ");
		txtDesc = new JTextArea(5, 20);
		txtDesc.setLineWrap(true);
		txtDesc.setEditable(false);
		rdPricePerMonth = new JRadioButton("Price per month");
		rdPricePer3Month = new JRadioButton("Price per 3 month");
		rdPricePerYear = new JRadioButton("Price per year");
		timePeriod = new ButtonGroup();
		timePeriod.add(rdPricePerMonth);
		timePeriod.add(rdPricePer3Month);
		timePeriod.add(rdPricePerYear);
		rdPricePerMonth.setSelected(true);
		lblPricePerMonth = new JLabel("One Month");
		lblPricePer3Month = new JLabel("Three Month");
		lblPricePerYear = new JLabel("Price Year");
		btnPay = new JButton("Pay");
		btnPay.setPreferredSize(new Dimension(0, 70));
		lblSoldBy = new JLabel("Sold by: ");
		txtSoldBy = new JTextField(12);
		txtSoldBy.setEditable(false);
		lblInNameOf = new JLabel("In name of: ");
		txtInNameOf = new JTextField(12);
		txtInNameOf.setEditable(false);
		lblValidFrom = new JLabel("Valid from: ");
		txtValidFrom = new JTextField();
		txtValidFrom.setEditable(false);
		lblValidTo = new JLabel("Valid by: ");
		txtValidTo = new JTextField();
		txtValidTo.setEditable(false);
		btnBack = new JButton("Back");
		btnSelectUser = new JButton("User");
		setScrollPane(new JScrollPane(txtDesc));

		JPanel pnlDepartures = new JPanel(new GridLayout(2, 2));
		pnlDepartures.add(lblFromStation = new JLabel("From station: "));
		pnlDepartures.add(txtFromStation = new AutoComboBox());
		pnlDepartures.add(lblToStation = new JLabel("To station: "));
		pnlDepartures.add(txtToStation = new AutoComboBox());
		pnlDepartures.setBorder(BorderFactory.createTitledBorder(""));

		pnlLeft.add(lblName);
		pnlLeft.add(txtName);
		pnlLeft.add(btnBack);
		pnlLeft.add(lblDesc);
		pnlLeft.add(scrollPane);
		pnlLeft.add(pnlDepartures);
		pnlLeft.add(lblPricePerMonth);
		pnlLeft.add(rdPricePerMonth);
		pnlLeft.add(lblPricePer3Month);
		pnlLeft.add(rdPricePer3Month);
		pnlLeft.add(lblPricePerYear);
		pnlLeft.add(rdPricePerYear);
		pnlLeft.add(btnPay);
		pnlLeft.add(lblSoldBy);
		pnlLeft.add(txtSoldBy);
		pnlLeft.add(lblValidFrom);
		pnlLeft.add(txtValidFrom);
		pnlLeft.add(lblValidTo);
		pnlLeft.add(txtValidTo);
		pnlLeft.add(btnSelectUser);
		pnlLeft.add(lblInNameOf);
		pnlLeft.add(txtInNameOf);

		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBack, 0, SpringLayout.HORIZONTAL_CENTER, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblName, 120, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblName, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtName, 170, SpringLayout.WEST, lblName);
		sp.putConstraint(SpringLayout.NORTH, txtName, 110, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, txtName, -400, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblDesc, 30, SpringLayout.SOUTH, lblName);
		sp.putConstraint(SpringLayout.WEST, lblDesc, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, scrollPane, 170, SpringLayout.WEST, lblDesc);
		sp.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, txtName);
		sp.putConstraint(SpringLayout.EAST, scrollPane, -400, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, pnlDepartures, 30, SpringLayout.SOUTH, scrollPane);
		sp.putConstraint(SpringLayout.WEST, pnlDepartures, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, pnlDepartures, -400, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, rdPricePerMonth, 30, SpringLayout.SOUTH, pnlDepartures);
		sp.putConstraint(SpringLayout.WEST, rdPricePerMonth, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblPricePerMonth, 150, SpringLayout.WEST, rdPricePerMonth);
		sp.putConstraint(SpringLayout.NORTH, lblPricePerMonth, 30, SpringLayout.SOUTH, pnlDepartures);

		sp.putConstraint(SpringLayout.NORTH, rdPricePer3Month, 30, SpringLayout.SOUTH, rdPricePerMonth);
		sp.putConstraint(SpringLayout.WEST, rdPricePer3Month, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblPricePer3Month, 150, SpringLayout.WEST, rdPricePer3Month);
		sp.putConstraint(SpringLayout.NORTH, lblPricePer3Month, 30, SpringLayout.SOUTH, rdPricePerMonth);
		
		sp.putConstraint(SpringLayout.NORTH, rdPricePerYear, 30, SpringLayout.SOUTH, rdPricePer3Month);
		sp.putConstraint(SpringLayout.WEST, rdPricePerYear, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblPricePerYear, 150, SpringLayout.WEST, rdPricePerYear);
		sp.putConstraint(SpringLayout.NORTH, lblPricePerYear, 30, SpringLayout.SOUTH, lblPricePer3Month);
		
		sp.putConstraint(SpringLayout.NORTH, btnPay, 30, SpringLayout.SOUTH, lblPricePerYear);
		sp.putConstraint(SpringLayout.WEST, btnPay, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, btnPay, -400, SpringLayout.EAST, pnlLeft);
		add(pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, pnlLeft, 1, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlLeft, 1, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlLeft, 1, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlLeft, 1, SpringLayout.EAST, this);
		
		sp.putConstraint(SpringLayout.EAST, btnSelectUser, -15, SpringLayout.EAST, pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, btnSelectUser, 60, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, btnSelectUser, 0, SpringLayout.WEST, lblSoldBy);
		
		sp.putConstraint(SpringLayout.NORTH, lblSoldBy, 10, SpringLayout.SOUTH, btnSelectUser);
		sp.putConstraint(SpringLayout.WEST, lblSoldBy, 25, SpringLayout.EAST, txtName);
		sp.putConstraint(SpringLayout.WEST, txtSoldBy, 125, SpringLayout.WEST, lblSoldBy);
		sp.putConstraint(SpringLayout.NORTH, txtSoldBy, 5, SpringLayout.SOUTH, btnSelectUser);
		sp.putConstraint(SpringLayout.EAST, txtSoldBy, -15, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblInNameOf, 5, SpringLayout.SOUTH, lblSoldBy);
		sp.putConstraint(SpringLayout.WEST, lblInNameOf, 25, SpringLayout.EAST, scrollPane);
		sp.putConstraint(SpringLayout.NORTH, txtInNameOf, 5, SpringLayout.SOUTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, txtInNameOf, -15, SpringLayout.EAST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtInNameOf, 125, SpringLayout.WEST, lblInNameOf);
		
		sp.putConstraint(SpringLayout.NORTH, lblValidFrom, 50, SpringLayout.SOUTH, lblInNameOf);
		sp.putConstraint(SpringLayout.WEST, lblValidFrom, 25, SpringLayout.EAST, scrollPane);
		sp.putConstraint(SpringLayout.NORTH, txtValidFrom, 45, SpringLayout.SOUTH, lblInNameOf);
		sp.putConstraint(SpringLayout.WEST, txtValidFrom, 125, SpringLayout.WEST, lblValidFrom);
		sp.putConstraint(SpringLayout.EAST, txtValidFrom, -15, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblValidTo, 10, SpringLayout.SOUTH, lblValidFrom);
		sp.putConstraint(SpringLayout.WEST, lblValidTo, 25, SpringLayout.EAST, scrollPane);
		sp.putConstraint(SpringLayout.NORTH, txtValidTo, 5, SpringLayout.SOUTH, lblValidFrom);
		sp.putConstraint(SpringLayout.WEST, txtValidTo, 125, SpringLayout.WEST, lblValidFrom);
		sp.putConstraint(SpringLayout.EAST, txtValidTo, -15, SpringLayout.EAST, pnlLeft);
	
		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 18));

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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
