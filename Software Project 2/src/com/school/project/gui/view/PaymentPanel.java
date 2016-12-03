package com.school.project.gui.view;

import java.awt.Dimension;
import java.awt.Font;
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
		SpringLayout sp = new SpringLayout();
		JPanel pnlLeft = new JPanel(sp);
		setLayout(sp);

		lblName = new JLabel("Name: ");
		txtName = new JTextField();
		txtName.setEditable(false);
		lblDesc = new JLabel("Description: ");
		txtDesc = new JTextArea(2, 20);
		lblPrice = new JLabel("Price: ");
		txtPrice = new JTextField(20);
		btnPay = new JButton("Pay");
		btnPay.setPreferredSize(new Dimension(0, 70));
		lblSoldBy = new JLabel("Sold by: ");
		txtSoldBy = new JTextField();
		lblValidFrom = new JLabel("Valid from: ");
		txtValidFrom = new JTextField();
		lblValidTo = new JLabel("Valid to: ");
		txtValidTo = new JTextField();
		btnBack = new JButton("Back");

		JPanel pnlDepartures = new JPanel(new GridLayout(2, 2));
		pnlDepartures.setBorder(BorderFactory.createTitledBorder(""));
		pnlDepartures.add(lblFromStation = new JLabel("From station: "));
		pnlDepartures.add(txtFromStation = new AutoComboBox());
		pnlDepartures.add(lblToStation = new JLabel("To station: "));
		pnlDepartures.add(txtToStation = new AutoComboBox());

		pnlLeft.add(lblName);
		pnlLeft.add(txtName);
		pnlLeft.add(lblDesc);
		pnlLeft.add(txtDesc);
		pnlLeft.add(lblPrice);
		pnlLeft.add(txtPrice);
		pnlLeft.add(btnPay);
		pnlLeft.add(pnlDepartures);
		pnlLeft.add(btnBack);

		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBack, 0, SpringLayout.HORIZONTAL_CENTER, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblName, 200, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, lblName, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtName, 170, SpringLayout.WEST, lblName);
		sp.putConstraint(SpringLayout.NORTH, txtName, 190, SpringLayout.NORTH, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, txtName, 0, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblDesc, 30, SpringLayout.SOUTH, lblName);
		sp.putConstraint(SpringLayout.WEST, lblDesc, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtDesc, 170, SpringLayout.WEST, lblDesc);
		sp.putConstraint(SpringLayout.NORTH, txtDesc, 20, SpringLayout.SOUTH, txtName);
		sp.putConstraint(SpringLayout.EAST, txtDesc, 0, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, pnlDepartures, 30, SpringLayout.SOUTH, txtDesc);
		sp.putConstraint(SpringLayout.WEST, pnlDepartures, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, pnlDepartures, 0, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblPrice, 30, SpringLayout.SOUTH, pnlDepartures);
		sp.putConstraint(SpringLayout.WEST, lblPrice, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtPrice, 170, SpringLayout.WEST, lblPrice);
		sp.putConstraint(SpringLayout.NORTH, txtPrice, 20, SpringLayout.SOUTH, pnlDepartures);
		sp.putConstraint(SpringLayout.EAST, txtPrice, 0, SpringLayout.EAST, pnlLeft);

		sp.putConstraint(SpringLayout.NORTH, btnPay, 30, SpringLayout.SOUTH, lblPrice);
		sp.putConstraint(SpringLayout.WEST, btnPay, 20, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.EAST, btnPay, 0, SpringLayout.EAST, pnlLeft);
		
		add(pnlLeft);
		pnlLeft.setBorder(BorderFactory.createTitledBorder("left"));
		
		sp.putConstraint(SpringLayout.NORTH, pnlLeft, 1, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlLeft, -300, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlLeft, 1, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlLeft, 1, SpringLayout.EAST, this);
		
		
		
		
		sp = new SpringLayout();
		JPanel pnlRight = new JPanel(sp);
		sp.putConstraint(SpringLayout.NORTH, pnlRight, 1, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlRight, 1, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlRight, 1, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlRight, 1, SpringLayout.EAST, this);
		
		pnlRight.setBorder(BorderFactory.createTitledBorder("right"));
		
		pnlRight.add(lblSoldBy);
		pnlRight.add(txtSoldBy);
		//pnlRight.add(lblValidFrom);
		//pnlRight.add(txtValidTo);
		//pnlRight.add(lblValidTo);
		//pnlRight.add(txtValidTo);
		
		sp.putConstraint(SpringLayout.NORTH, lblSoldBy, 100, SpringLayout.NORTH, pnlRight);
		sp.putConstraint(SpringLayout.WEST, lblSoldBy, 20, SpringLayout.WEST, pnlRight);
		sp.putConstraint(SpringLayout.WEST, txtSoldBy, 50, SpringLayout.WEST, lblSoldBy);
		sp.putConstraint(SpringLayout.NORTH, txtSoldBy, 90, SpringLayout.NORTH, pnlRight);
		sp.putConstraint(SpringLayout.EAST, txtSoldBy, -10, SpringLayout.EAST, pnlRight);
		
		//add(pnlRight);
		
		

		/*
		 * JPanel pnlRight = new JPanel(new SpringLayout());
		 * pnlRight.setPreferredSize(new Dimension(350, 500));
		 * pnlRight.add(lblSoldBy = new JLabel("Sold by: "));
		 * pnlRight.add(txtSoldBy = new JTextField());
		 * txtSoldBy.setEditable(false); pnlRight.add(lblValidFrom = new
		 * JLabel("Valid from: ")); pnlRight.add(txtValidFrom = new
		 * JTextField()); txtValidFrom.setEditable(false);
		 * pnlRight.add(lblValidTo = new JLabel("Valid by: "));
		 * pnlRight.add(txtValidTo = new JTextField());
		 * txtValidTo.setEditable(false);
		 * 
		 * sp.putConstraint(SpringLayout.NORTH, txtSoldBy, 30,
		 * SpringLayout.NORTH, pnlRight); sp.putConstraint(SpringLayout.EAST,
		 * txtSoldBy, -30, SpringLayout.EAST, pnlRight);
		 * sp.putConstraint(SpringLayout.NORTH, lblSoldBy, 5,
		 * SpringLayout.NORTH, txtSoldBy); sp.putConstraint(SpringLayout.EAST,
		 * lblSoldBy, -10, SpringLayout.WEST, txtSoldBy);
		 * sp.putConstraint(SpringLayout.NORTH, txtValidFrom, 230,
		 * SpringLayout.NORTH, txtSoldBy); sp.putConstraint(SpringLayout.EAST,
		 * txtValidFrom, 0, SpringLayout.EAST, txtSoldBy);
		 * sp.putConstraint(SpringLayout.NORTH, lblValidFrom, 0,
		 * SpringLayout.NORTH, txtValidFrom);
		 * sp.putConstraint(SpringLayout.EAST, lblValidFrom, -10,
		 * SpringLayout.WEST, txtValidFrom);
		 * sp.putConstraint(SpringLayout.NORTH, txtValidTo, 50,
		 * SpringLayout.NORTH, txtValidFrom);
		 * sp.putConstraint(SpringLayout.EAST, txtValidTo, 0, SpringLayout.EAST,
		 * txtValidFrom); sp.putConstraint(SpringLayout.NORTH, lblValidTo, 0,
		 * SpringLayout.NORTH, txtValidTo); sp.putConstraint(SpringLayout.EAST,
		 * lblValidTo, -10, SpringLayout.WEST, txtValidTo);
		 * 
		 * add(pnlLeft);
		 * 
		 * sp.putConstraint(SpringLayout.NORTH, pnlLeft, 1, SpringLayout.NORTH,
		 * this); sp.putConstraint(SpringLayout.EAST, pnlLeft, 1,
		 * SpringLayout.WEST, pnlRight); sp.putConstraint(SpringLayout.SOUTH,
		 * pnlLeft, 1, SpringLayout.SOUTH, this);
		 * sp.putConstraint(SpringLayout.WEST, pnlLeft, 1, SpringLayout.WEST,
		 * this);
		 */

		// add(pnlRight, BorderLayout.EAST);
		// JPanel pnlBack = new JPanel();
		// pnlBack.add(btnBack);
		// add(pnlBack, BorderLayout.NORTH);

		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 18));

		FontUtil.getInstance().bindBigFont(txtName);
		FontUtil.getInstance().bindBigFont(txtPrice);
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
		FontUtil.getInstance().bindSmallFont(lblPrice);
		FontUtil.getInstance().bindSmallFont(lblName);
		FontUtil.getInstance().bindSmallFont(btnPay);
		FontUtil.getInstance().bindSmallFont(txtFromStation);
		FontUtil.getInstance().bindSmallFont(txtToStation);

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
