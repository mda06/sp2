package com.school.project.gui.view.settings;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.gui.view.BaseView;

public class BackupView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JLabel lblPrefix, lblContent;
	private JButton btnBackup;
	private JTextField txtPrefix;
	private JComboBox<String> comboTables;

	public BackupView() {
		super("Backup");
		initLayout();
	}
	
	private void initLayout(){
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		
		String[] tableList = {"activeRailcards","addresses","lostItems","railcards","tickets","ticketSales","users"};
		add(lblPrefix = new JLabel("File Name Prefix:"));
		add(txtPrefix = new JTextField(20));
		add(lblContent = new JLabel("Backup content:"));
		add(comboTables = new JComboBox<String>(tableList));
		add(btnBackup = new JButton("Save"));
	
			
		sp.putConstraint(SpringLayout.WEST, lblPrefix, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lblPrefix, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, txtPrefix, 20, SpringLayout.NORTH, lblPrefix);
		sp.putConstraint(SpringLayout.WEST, txtPrefix, 15, SpringLayout.SOUTH, lblPrefix);
		sp.putConstraint(SpringLayout.NORTH, lblContent, 30, SpringLayout.NORTH, txtPrefix);
		sp.putConstraint(SpringLayout.WEST, lblContent, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, comboTables, 20, SpringLayout.NORTH, lblContent);
		sp.putConstraint(SpringLayout.WEST, comboTables, -35, SpringLayout.SOUTH, lblContent);
		sp.putConstraint(SpringLayout.WEST, btnBackup, 30, SpringLayout.EAST, comboTables);
		sp.putConstraint(SpringLayout.NORTH, btnBackup, 20, SpringLayout.NORTH, lblContent);
		
	}

	public JButton getBtnBackup() {
		return btnBackup;
	}

	public void setBtnBackup(JButton btnBackup) {
		this.btnBackup = btnBackup;
	}

	public JTextField getTxtPrefix() {
		return txtPrefix;
	}

	public void setTxtPrefix(JTextField txtPrefix) {
		this.txtPrefix = txtPrefix;
	}

	public JLabel getLblPrefix() {
		return lblPrefix;
	}

	public void setLblPrefix(JLabel lblPrefix) {
		this.lblPrefix = lblPrefix;
	}

	public JComboBox<String> getComboTables() {
		return comboTables;
	}

	public void setComboTables(JComboBox<String> comboTables) {
		this.comboTables = comboTables;
	}

	
	
	
	
	
}
