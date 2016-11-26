package com.school.project.gui.view.settings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.school.project.util.FontUtil;

public class TicketEditorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnBack, btnSave;
	private JTextField txtName, txtPrice;
	private JTextArea txtDesc;

	private JLabel lblName, lblDesc, lblPrice;

	private JCheckBox cbHasFixedRoute;

	public TicketEditorPanel() {
		cbHasFixedRoute = new JCheckBox("fixed route");
		initLayout();
	}

	private void initLayout() {
		setLayout(new BorderLayout());

		JPanel pnlLeft = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lblName = new JLabel("Name");
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 35;
		c.ipadx = 15;
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 0;
		pnlLeft.add(lblName, c);
		txtName = new JTextField(20);
		c.gridx = 1;
		c.weightx = 1;
		pnlLeft.add(txtName, c);
		lblDesc = new JLabel("Desc");
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 1;
		pnlLeft.add(lblDesc, c);
		txtDesc = new JTextArea();
		c.weightx = 1;
		c.gridx = 1;
		pnlLeft.add(txtDesc, c);

		lblPrice = new JLabel("Price: ");
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pnlLeft.add(lblPrice, c);
		txtPrice = new JTextField(20);
		c.gridx = 1;
		c.weightx = 1;
		pnlLeft.add(txtPrice, c);
		btnSave = new JButton("Save");
		c.gridx = 1;
		c.gridy = 5;
		pnlLeft.add(btnSave, c);

		add(pnlLeft, BorderLayout.WEST);
		JPanel pnlBack = new JPanel();
		pnlBack.add(btnBack = new JButton("Back"));
		add(pnlBack, BorderLayout.NORTH);
		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 18));

		FontUtil.getInstance().bindBigFont(txtName);
		FontUtil.getInstance().bindBigFont(txtPrice);
		FontUtil.getInstance().bindBigFont(btnBack);

		FontUtil.getInstance().bindSmallFont(lblDesc);
		FontUtil.getInstance().bindSmallFont(lblPrice);
		FontUtil.getInstance().bindSmallFont(lblName);
		FontUtil.getInstance().bindSmallFont(btnSave);
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
