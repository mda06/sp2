package com.school.project.gui.view.settings;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import com.school.project.gui.view.BaseView;

public class BackupView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JButton btnBackup;

	public BackupView() {
		super("Backup");
		initLayout();
	}
	
	private void initLayout(){
		btnBackup = new JButton("Take backup");
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(btnBackup);
	}

	public JButton getBtnBackup() {
		return btnBackup;
	}

	public void setBtnBackup(JButton btnBackup) {
		this.btnBackup = btnBackup;
	}
	
	
	
	
	
	
}
