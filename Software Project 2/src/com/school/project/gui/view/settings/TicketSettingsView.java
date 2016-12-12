package com.school.project.gui.view.settings;

import javax.swing.JButton;

import com.school.project.gui.view.TicketView;
import com.school.project.util.FontUtil;

public class TicketSettingsView extends TicketView {

	private static final long serialVersionUID = 1L;
	private JButton btnNewticket;
	private TicketEditorPanel pnlTicketEditor;
	
	public final String KEY_EDIT = "editor";
	
	public TicketSettingsView(){
		this.getPnlBtns().add(btnNewticket = new JButton("New ticket"));
		//remove(this.getPnlPayment());
		add(pnlTicketEditor = new TicketEditorPanel(),KEY_EDIT);
		FontUtil.getInstance().bindSmallFont(btnNewticket);
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

	public void setBtnNewticket(JButton btnNewticket) {
		this.btnNewticket = btnNewticket;
	}
	
}
