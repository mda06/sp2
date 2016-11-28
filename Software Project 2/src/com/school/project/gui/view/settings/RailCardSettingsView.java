package com.school.project.gui.view.settings;

import java.awt.Color;

import javax.swing.JButton;

import com.school.project.gui.view.BaseView;
import com.school.project.gui.view.RailCardView;

public class RailCardSettingsView extends RailCardView{
	private static final long serialVersionUID = 1L;
	
	private JButton btnNewRailCard;
	
	private TicketEditorPanel pnlRailCardEditor;
	
	public final String KEY_EDIT = "editor";
	
	public RailCardSettingsView() {
		this.getPnlBtns().add(btnNewRailCard = new JButton("New Railcard"));
		add(pnlRailCardEditor = new RailCardEditorPanel(), KEY_EDIT);
	}
}
