package com.school.project.gui.view.settings;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RailCardEditorPanel extends TicketEditorPanel {
	
	private JLabel lblPricePerMonth, lblPricePer3Month, lblPricePerYear;
	private JTextField txtPricePerMonth, txtPricePer3Month, txtPricePerYear;
	
	private static final long serialVersionUID = 1L;
	
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
		
		pnlLeft.removeAll();
		
	}
	
	

}
