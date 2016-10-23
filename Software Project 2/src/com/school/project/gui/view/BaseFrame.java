package com.school.project.gui.view;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class BaseFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel pnlBtns, pnlCard;
	private JSplitPane split;
	
	public BaseFrame() {
		setTitle("Baseframe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initLayout();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	private void initLayout() {
		pnlBtns = new JPanel(new GridLayout(10, 1));
		pnlCard = new JPanel(new CardLayout());
		split = new JSplitPane();
		split.setRightComponent(pnlCard);
		split.setLeftComponent(pnlBtns);
		add(split);
	}	
	
	public JPanel getPanelBtns() {
		return pnlBtns;
	}
	
	public JPanel getPanelCard() {
		return pnlCard;
	}
}
