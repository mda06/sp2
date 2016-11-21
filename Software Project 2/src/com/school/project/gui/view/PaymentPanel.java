package com.school.project.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.gui.view.custom.AutoComboBox;
import com.school.project.util.FontUtil;

public class PaymentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton btnBack, btnPay;
	private JTextField txtName, txtSoldBy, txtValidFrom, txtValidTo, txtPrice;
	private JTextArea txtDesc;
	private AutoComboBox txtFromStation, txtToStation;
	private JLabel lblName, lblDesc, lblSoldBy, lblValidFrom, lblValidTo, lblPrice, lblFromStation, lblToStation;
	
	public PaymentPanel() {
		initLayout();
		
	}
	
	private void initLayout() {
		setLayout(new BorderLayout());
		
		JPanel pnlLeft = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lblName = new JLabel("Name: ");
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 35;
		c.ipadx = 15;
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
		pnlDepartures.setBorder(BorderFactory.createTitledBorder(""));
		pnlDepartures.add(lblFromStation = new JLabel("From station: "));
		pnlDepartures.add(txtFromStation = new AutoComboBox());
		pnlDepartures.add(lblToStation = new JLabel("To station: "));
		pnlDepartures.add(txtToStation = new AutoComboBox());

		c.weightx = 1;
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		pnlLeft.add(pnlDepartures, c);
		
		lblPrice = new JLabel("Price: ");
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(lblPrice, c);
		txtPrice = new JTextField(20);
		txtPrice.setEditable(false);
		c.gridx = 1;
		c.weightx = 1;
		pnlLeft.add(txtPrice, c);
		c.gridx = 1;
		c.gridy = 5;
		btnPay = new JButton("Pay");
		pnlLeft.add(btnPay, c);
		
		SpringLayout sp = new SpringLayout();
		JPanel pnlRight = new JPanel(sp);
		pnlRight.setPreferredSize(new Dimension(350, 500));
		pnlRight.add(lblSoldBy = new JLabel("Sold by: "));
		pnlRight.add(txtSoldBy = new JTextField());
		txtSoldBy.setEditable(false);
		pnlRight.add(lblValidFrom = new JLabel("Valid from: "));
		pnlRight.add(txtValidFrom = new JTextField());
		txtValidFrom.setEditable(false);
		pnlRight.add(lblValidTo = new JLabel("Valid by: "));
		pnlRight.add(txtValidTo = new JTextField());
		txtValidTo.setEditable(false);
		
		
		sp.putConstraint(SpringLayout.NORTH, txtSoldBy, 30, SpringLayout.NORTH, pnlRight);
		sp.putConstraint(SpringLayout.EAST, txtSoldBy, -30, SpringLayout.EAST, pnlRight);
		sp.putConstraint(SpringLayout.NORTH, lblSoldBy, 5, SpringLayout.NORTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, lblSoldBy, -10, SpringLayout.WEST, txtSoldBy);
		sp.putConstraint(SpringLayout.NORTH, txtValidFrom, 230, SpringLayout.NORTH, txtSoldBy);
		sp.putConstraint(SpringLayout.EAST, txtValidFrom, 0, SpringLayout.EAST, txtSoldBy);
		sp.putConstraint(SpringLayout.NORTH, lblValidFrom, 0, SpringLayout.NORTH, txtValidFrom);
		sp.putConstraint(SpringLayout.EAST, lblValidFrom, -10, SpringLayout.WEST, txtValidFrom);
		sp.putConstraint(SpringLayout.NORTH, txtValidTo, 50, SpringLayout.NORTH, txtValidFrom);
		sp.putConstraint(SpringLayout.EAST, txtValidTo, 0, SpringLayout.EAST, txtValidFrom);
		sp.putConstraint(SpringLayout.NORTH, lblValidTo, 0, SpringLayout.NORTH, txtValidTo);
		sp.putConstraint(SpringLayout.EAST, lblValidTo, -10, SpringLayout.WEST, txtValidTo);

		add(pnlLeft);
		add(pnlRight, BorderLayout.EAST);
		JPanel pnlBack = new JPanel();
		pnlBack.add(btnBack = new JButton("Back"));
		add(pnlBack, BorderLayout.NORTH);
		
		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN,18));
		
		txtName.setFont(FontUtil.getInstance().getBig());
		txtPrice.setFont(FontUtil.getInstance().getBig());
		btnBack.setFont(FontUtil.getInstance().getBig());
		
		txtSoldBy.setFont(FontUtil.getInstance().getSmall());
		lblSoldBy.setFont(FontUtil.getInstance().getSmall());
		txtValidFrom.setFont(FontUtil.getInstance().getSmall());
		txtValidTo.setFont(FontUtil.getInstance().getSmall());
		lblValidFrom.setFont(FontUtil.getInstance().getSmall());
		lblValidTo.setFont(FontUtil.getInstance().getSmall());
		lblFromStation.setFont(FontUtil.getInstance().getSmall());
		lblToStation.setFont(FontUtil.getInstance().getSmall());
		lblDesc.setFont(FontUtil.getInstance().getSmall());
		lblPrice.setFont(FontUtil.getInstance().getSmall());
		lblName.setFont(FontUtil.getInstance().getSmall());
		btnPay.setFont(FontUtil.getInstance().getSmall());
		txtFromStation.setFont(FontUtil.getInstance().getSmall()); 
		txtToStation.setFont(FontUtil.getInstance().getSmall());
		
		
		
		
	}
	
	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblDesc() {
		return lblDesc;
	}

	public JLabel getLblSoldBy() {
		return lblSoldBy;
	}

	public JLabel getLblValidFrom() {
		return lblValidFrom;
	}

	public JLabel getLblValidTo() {
		return lblValidTo;
	}

	public JLabel getLblPrice() {
		return lblPrice;
	}

	public JLabel getLblFromStation() {
		return lblFromStation;
	}

	public JLabel getLblToStation() {
		return lblToStation;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextArea getTxtDesc() {
		return txtDesc;
	}

	public JTextField getTxtSoldBy() {
		return txtSoldBy;
	}

	public JTextField getTxtValidFrom() {
		return txtValidFrom;
	}

	public JTextField getTxtValidTo() {
		return txtValidTo;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public AutoComboBox getTxtFromStation() {
		return txtFromStation;
	}

	public AutoComboBox getTxtToStation() {
		return txtToStation;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnPay() {
		return btnPay;
	}

}
