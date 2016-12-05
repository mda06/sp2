package com.school.project.gui.view.settings;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.util.FontUtil;

public class TicketEditorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnBack, btnSave, btnDelete;
	private JTextField txtName, txtPrice;
	private JTextArea txtDesc;
	
	private JScrollPane scrollPane;
	
	protected JPanel pnlLeft;

	private JLabel lblName, lblDesc, lblPrice, lblValidityPer, lblDays;

	private JCheckBox cbHasFixedRoute;
	
	private JComboBox<Integer> jcValidityPer;

	public TicketEditorPanel() {
		cbHasFixedRoute = new JCheckBox("fixed route");
		initLayout();
	}

	private void initLayout() {
		SpringLayout sp = new SpringLayout();
		pnlLeft = new JPanel(sp);
		setLayout(sp);
		
		lblName = new JLabel("Name");
		txtName = new JTextField(20);
		lblDesc = new JLabel("Desc");
		txtDesc = new JTextArea(5, 20);
		txtDesc.setLineWrap(true);
		lblPrice = new JLabel("Price: ");
		txtPrice = new JTextField(20);
		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(0, 70));
		btnDelete = new JButton("Delete ticket");
		lblValidityPer = new JLabel("Validity period: ");
		lblDays = new JLabel("Days");
		cbHasFixedRoute = new JCheckBox("Has fixed route");
		jcValidityPer = new JComboBox<>();
		jcValidityPer.setPreferredSize(new Dimension(100,30));
		btnBack = new JButton("Back");
		scrollPane = new JScrollPane(txtDesc);
		
		pnlLeft.add(lblName);
		pnlLeft.add(txtName);
		pnlLeft.add(lblDesc);
		pnlLeft.add(scrollPane);
		pnlLeft.add(lblPrice);
		pnlLeft.add(txtPrice);
		pnlLeft.add(btnSave);
		pnlLeft.add(btnDelete);
		pnlLeft.add(btnBack);
		pnlLeft.add(lblValidityPer);
		//pnlLeft.add(lblDays);
		pnlLeft.add(cbHasFixedRoute);
		pnlLeft.add(jcValidityPer);
		
		sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBack, 0, SpringLayout.HORIZONTAL_CENTER, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, lblValidityPer, 100, SpringLayout.SOUTH, btnBack);
		sp.putConstraint(SpringLayout.WEST, lblValidityPer, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.NORTH, jcValidityPer, 95, SpringLayout.SOUTH, btnBack);
		sp.putConstraint(SpringLayout.WEST, jcValidityPer, 15, SpringLayout.EAST, lblValidityPer);
		
		sp.putConstraint(SpringLayout.NORTH, cbHasFixedRoute, 95, SpringLayout.SOUTH, btnBack);
		sp.putConstraint(SpringLayout.EAST, cbHasFixedRoute, -500, SpringLayout.EAST, pnlLeft);
		
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
		
		sp.putConstraint(SpringLayout.NORTH, lblPrice, 30, SpringLayout.SOUTH, scrollPane);
		sp.putConstraint(SpringLayout.WEST, lblPrice, 25, SpringLayout.WEST, pnlLeft);
		sp.putConstraint(SpringLayout.WEST, txtPrice, 170, SpringLayout.WEST, lblPrice);
		sp.putConstraint(SpringLayout.NORTH, txtPrice, 20, SpringLayout.SOUTH, scrollPane);
		sp.putConstraint(SpringLayout.EAST, txtPrice, -200, SpringLayout.EAST, pnlLeft);

		sp.putConstraint(SpringLayout.NORTH, btnSave, 30, SpringLayout.SOUTH, lblPrice);
		sp.putConstraint(SpringLayout.WEST, btnSave, 170, SpringLayout.WEST, lblPrice);
		sp.putConstraint(SpringLayout.EAST, btnSave, -200, SpringLayout.EAST, pnlLeft);
		
		sp.putConstraint(SpringLayout.NORTH, btnDelete, 50, SpringLayout.SOUTH, txtName);
		sp.putConstraint(SpringLayout.WEST, btnDelete, 20, SpringLayout.EAST, scrollPane);
		sp.putConstraint(SpringLayout.EAST, btnDelete, -20, SpringLayout.EAST, pnlLeft);

		add(pnlLeft);		
		sp.putConstraint(SpringLayout.NORTH, pnlLeft, 1, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, pnlLeft, 1, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.SOUTH, pnlLeft, 1, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.WEST, pnlLeft, 1, SpringLayout.EAST, this);
		
		btnBack.setPreferredSize(new Dimension(200, 70));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 18));

		FontUtil.getInstance().bindBigFont(txtName);
		FontUtil.getInstance().bindBigFont(txtPrice);
		FontUtil.getInstance().bindBigFont(btnBack);
		
		FontUtil.getInstance().bindSmallFont(btnDelete);
		FontUtil.getInstance().bindSmallFont(lblDays);
		FontUtil.getInstance().bindSmallFont(lblValidityPer);
		FontUtil.getInstance().bindSmallFont(cbHasFixedRoute);
		FontUtil.getInstance().bindSmallFont(lblDesc);
		FontUtil.getInstance().bindSmallFont(lblPrice);
		FontUtil.getInstance().bindSmallFont(lblName);
		FontUtil.getInstance().bindSmallFont(btnSave);
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JLabel getLblValidityPer() {
		return lblValidityPer;
	}

	public void setLblValidityPer(JLabel lblValidityPer) {
		this.lblValidityPer = lblValidityPer;
	}

	public JLabel getLblDays() {
		return lblDays;
	}

	public void setLblDays(JLabel lblDays) {
		this.lblDays = lblDays;
	}

	public JComboBox<Integer> getJcValidityPer() {
		return jcValidityPer;
	}

	public void setJcValidityPer(JComboBox<Integer> jcValidityPer) {
		this.jcValidityPer = jcValidityPer;
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

	public JScrollPane getScrollpane() {
		return scrollPane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollPane = scrollpane;
	}

}
