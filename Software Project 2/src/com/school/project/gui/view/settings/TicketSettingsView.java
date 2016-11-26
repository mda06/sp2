package com.school.project.gui.view.settings;

import javax.swing.JButton;

import com.school.project.gui.view.TicketView;

public class TicketSettingsView extends TicketView {

	private static final long serialVersionUID = 1L;
	private JButton btnNewticket;
	private TicketEditorPanel pnlTicketEditor;
	
	public final String KEY_EDIT = "editor";
	
	public TicketSettingsView(){
		this.getPnlBtns().add(btnNewticket = new JButton("new ticket"));
		//remove(this.getPnlPayment());
		add(pnlTicketEditor = new TicketEditorPanel(),KEY_EDIT);
	}

	public TicketEditorPanel getPnlTicketEditor() {
		return pnlTicketEditor;
	}

	public void setPnlTicketEditor(TicketEditorPanel pnlTicketEditor) {
		this.pnlTicketEditor = pnlTicketEditor;
	}

	public JButton getBtnNewticket() {
		return btnNewticket;
	}

	private void initLayout() {
		//add(tsa);
		//pnlPanel = new JPanel();
	}
		
	public void setBtnNewticket(JButton btnNewticket) {
		this.btnNewticket = btnNewticket;
	}
	
}
