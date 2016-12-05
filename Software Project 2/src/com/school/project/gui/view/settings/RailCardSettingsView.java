package com.school.project.gui.view.settings;

import javax.swing.JButton;

import com.school.project.gui.view.RailCardView;

public class RailCardSettingsView extends RailCardView{
	private static final long serialVersionUID = 1L;
	
	private JButton btnNewRailCard;
	
	private RailCardEditorPanel pnlRailCardEditor;
	

	public RailCardSettingsView() {
		this.getPnlBtns().add(btnNewRailCard = new JButton("New Railcard"));
		add(pnlRailCardEditor = new RailCardEditorPanel(), KEY_EDIT);
	}
	
	public JButton getBtnNewRailCard() {
		return btnNewRailCard;
	}

	public void setBtnNewRailCard(JButton btnNewRailCard) {
		this.btnNewRailCard = btnNewRailCard;
	}

	public RailCardEditorPanel getPnlRailCardEditor() {
		return pnlRailCardEditor;
	}

	public void setPnlRailCardEditor(RailCardEditorPanel pnlRailCardEditor) {
		this.pnlRailCardEditor = pnlRailCardEditor;
	}

	public final String KEY_EDIT = "editor";
	
}
