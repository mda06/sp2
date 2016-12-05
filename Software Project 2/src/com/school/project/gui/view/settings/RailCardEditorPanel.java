package com.school.project.gui.view.settings;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class RailCardEditorPanel extends TicketEditorPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblPricePerMonth, lblPricePer3Month, lblPricePerYear;
	private JTextField txtPricePerMonth, txtPricePer3Month, txtPricePerYear;
	
	public RailCardEditorPanel(){
		super();
		initRcLayout();
	}
	
	private void initRcLayout(){
		lblPricePerMonth = new JLabel("price per month");
		lblPricePer3Month = new JLabel("price per 3 motnhs");
		lblPricePerYear = new JLabel("Price per year");
		
		txtPricePerMonth = new JTextField();
		txtPricePer3Month = new JTextField();
		txtPricePerYear = new JTextField();
		
		pnlLeft.remove(this.getLblPrice());
		pnlLeft.remove(this.getTxtPrice());
		pnlLeft.remove(this.getLblValidityPer());
		pnlLeft.remove(this.getJcValidityPer());
		pnlLeft.remove(this.getLblDays());
		
		GridBagConstraints c = new GridBagConstraints();
		//c.gridwidth = c.REMAINDER;
		c.gridx = 0;
		c.gridy = 3;
				
		pnlLeft.add(lblPricePerMonth, c);
		c.gridx = 1;
		pnlLeft.add(txtPricePerMonth, c);
		
		c.gridx = 2;
		pnlLeft.add(lblPricePer3Month, c);
		
		c.gridx = 3;
		pnlLeft.add(txtPricePer3Month, c);
		
		
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

	
}
