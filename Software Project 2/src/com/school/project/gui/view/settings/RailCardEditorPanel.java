package com.school.project.gui.view.settings;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class RailCardEditorPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblPricePerMonth, lblPricePer3Month, lblPricePerYear;
	private JTextField txtPricePerMonth, txtPricePer3Month, txtPricePerYear, txtName;
	private JButton btnBack, btnSave, btnDelete;
	private JTextArea txtDesc;
	private JScrollPane scrollPane;
	protected JPanel pnlLeft;
	private JLabel lblName, lblDesc;
	private JCheckBox cbHasFixedRoute;
	
	private void initRcLayout(){
		SpringLayout sp = new SpringLayout();
		pnlLeft = new JPanel(sp);
		setLayout(sp);
		
		lblPricePerMonth = new JLabel("price per month");
		lblPricePer3Month = new JLabel("price per 3 motnhs");
		lblPricePerYear = new JLabel("Price per year");
		txtPricePerMonth = new JTextField(5);
		txtPricePer3Month = new JTextField(5);
		txtPricePerYear = new JTextField(5);
		lblName = new JLabel("Name");
		txtName = new JTextField(20);
		lblDesc = new JLabel("Desc");
		txtDesc = new JTextArea(5, 20);
		txtDesc.setLineWrap(true);
		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(0, 70));
		btnDelete = new JButton("Delete ticket");
		cbHasFixedRoute = new JCheckBox("Has fixed route");
		btnBack = new JButton("Back");
		scrollPane = new JScrollPane(txtDesc);
		

		pnlLeft.add(lblName);
		pnlLeft.add(txtName);
		pnlLeft.add(lblDesc);
		pnlLeft.add(scrollPane);
		pnlLeft.add(btnSave);
		pnlLeft.add(btnDelete);
		pnlLeft.add(btnBack);
		pnlLeft.add(cbHasFixedRoute);
		pnlLeft.add(lblPricePerMonth);
		pnlLeft.add(lblPricePer3Month);
		pnlLeft.add(lblPricePerYear);
		pnlLeft.add(txtPricePerMonth);
		pnlLeft.add(txtPricePer3Month);
		pnlLeft.add(txtPricePerYear);
		
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBack, 0, SpringLayout.HORIZONTAL_CENTER, pnlLeft);

		sp.putConstraint(SpringLayout.SOUTH, cbHasFixedRoute, -30, SpringLayout.NORTH, txtName);
		sp.putConstraint(SpringLayout.EAST, cbHasFixedRoute, 0, SpringLayout.EAST, txtName);
		
		sp.putConstraint(SpringLayout.NORTH, lblName, 250, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblName, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtName, 170, SpringLayout.WEST, lblName);
		sp.putConstraint(SpringLayout.NORTH, txtName, 240, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, txtName, -200, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblDesc, 30, SpringLayout.SOUTH, lblName);
		sp.putConstraint(SpringLayout.WEST, lblDesc, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, scrollPane, 175, SpringLayout.WEST, lblDesc);
		sp.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, txtName);
		sp.putConstraint(SpringLayout.EAST, scrollPane, -200, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblPricePerMonth, 30, SpringLayout.SOUTH, scrollPane);
		sp.putConstraint(SpringLayout.WEST, lblPricePerMonth, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, txtPricePerMonth, 25, SpringLayout.SOUTH, scrollPane);
		sp.putConstraint(SpringLayout.WEST, txtPricePerMonth, 220, SpringLayout.WEST, lblPricePerMonth);
		
		sp.putConstraint(SpringLayout.NORTH, lblPricePer3Month, 30, SpringLayout.SOUTH, lblPricePerMonth);
		sp.putConstraint(SpringLayout.WEST, lblPricePer3Month, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, txtPricePer3Month, 20, SpringLayout.SOUTH, txtPricePerMonth);
		sp.putConstraint(SpringLayout.WEST, txtPricePer3Month, 220, SpringLayout.WEST, lblPricePer3Month);
		
		sp.putConstraint(SpringLayout.NORTH, lblPricePerYear, 30, SpringLayout.SOUTH, lblPricePer3Month);
		sp.putConstraint(SpringLayout.WEST, lblPricePerYear, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, txtPricePerYear, 20, SpringLayout.SOUTH, txtPricePer3Month);
		sp.putConstraint(SpringLayout.WEST, txtPricePerYear, 220, SpringLayout.WEST, lblPricePerYear);
		
		sp.putConstraint(SpringLayout.NORTH, btnDelete, 50, SpringLayout.SOUTH, txtName);
		sp.putConstraint(SpringLayout.WEST, btnDelete, 20, SpringLayout.EAST, scrollPane);
		sp.putConstraint(SpringLayout.EAST, btnDelete, -20, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, btnSave, 30, SpringLayout.SOUTH, lblPricePerYear);
		sp.putConstraint(SpringLayout.WEST, btnSave, 170, SpringLayout.WEST, lblPricePerYear);
		sp.putConstraint(SpringLayout.EAST, btnSave, -200, SpringLayout.EAST, pnlLeft);

		add(pnlLeft);		
		sp.putConstraint(SpringLayout.NORTH, pnlLeft, 1, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlLeft, 1, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlLeft, 1, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlLeft, 1, SpringLayout.EAST, this);
		
		btnBack
		.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 18));

		FontUtil.getInstance().bindBigFont(txtName);
		FontUtil.getInstance().bindBigFont(btnBack);
		
		FontUtil.getInstance().bindSmallFont(btnDelete);
		FontUtil.getInstance().bindSmallFont(cbHasFixedRoute);
		FontUtil.getInstance().bindSmallFont(lblDesc);
		FontUtil.getInstance().bindSmallFont(lblName);
		FontUtil.getInstance().bindSmallFont(btnSave);
		FontUtil.getInstance().bindSmallFont(lblPricePerMonth);
		FontUtil.getInstance().bindSmallFont(lblPricePer3Month);
		FontUtil.getInstance().bindSmallFont(lblPricePerYear);
		FontUtil.getInstance().bindSmallFont(txtPricePerMonth);
		FontUtil.getInstance().bindSmallFont(txtPricePer3Month);
		FontUtil.getInstance().bindSmallFont(txtPricePerYear);
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

	public JLabel getLblPricePerYear() {
		return lblPricePerYear;
	}

	public void setLblPricePerYear(JLabel lblPricePerYear) {
		this.lblPricePerYear = lblPricePerYear;
	}

	public JTextField getTxtPricePerMonth() {
		return txtPricePerMonth;
	}

	public void setTxtPricePerMonth(JTextField txtPricePerMonth) {
		this.txtPricePerMonth = txtPricePerMonth;
	}

	public JTextField getTxtPricePer3Month() {
		return txtPricePer3Month;
	}

	public void setTxtPricePer3Month(JTextField txtPricePer3Month) {
		this.txtPricePer3Month = txtPricePer3Month;
	}

	public JTextField getTxtPricePerYear() {
		return txtPricePerYear;
	}

	public void setTxtPricePerYear(JTextField txtPricePerYear) {
		this.txtPricePerYear = txtPricePerYear;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
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

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JTextArea getTxtDesc() {
		return txtDesc;
	}

	public void setTxtDesc(JTextArea txtDesc) {
		this.txtDesc = txtDesc;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
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

	public JCheckBox getCbHasFixedRoute() {
		return cbHasFixedRoute;
	}

	public void setCbHasFixedRoute(JCheckBox cbHasFixedRoute) {
		this.cbHasFixedRoute = cbHasFixedRoute;
	}

	
	
	public RailCardEditorPanel(){
		super();
		initRcLayout();
	}
	

	
}
