package com.school.project.gui.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class FrameView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel pnlBtns, pnlCard;
	private JSplitPane split;
	private JMenuBar menuBar;
	private JMenu menuOptions, menuFile;
	private JMenuItem mnDisconnect;
	
	public FrameView() {
		setTitle("FrameView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initLayout();
		initMenu();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(640,480));
	}
	
	private void initLayout() {
		pnlBtns = new JPanel(new GridLayout(10, 1));
		pnlCard = new JPanel(new CardLayout());
		split = new JSplitPane();
		split.setRightComponent(pnlCard);
		split.setLeftComponent(pnlBtns);
		add(split);
	}	
	
	private void initMenu(){
		menuBar = new JMenuBar();
		menuOptions = new JMenu("Options");
		menuBar.add(menuFile = new JMenu("File"));
		menuBar.add(menuOptions);
		menuFile.add(mnDisconnect = new JMenuItem("Disconnect"));
		this.setJMenuBar(menuBar);
	}
	
	public JPanel getPanelBtns() {
		return pnlBtns;
	}
	
	public JPanel getPanelCard() {
		return pnlCard;
	}

	public JMenu getMenuOptions() {
		return menuOptions;
	}

	public JMenuItem getMnDisconnect() {
		return mnDisconnect;
	}

	public JMenu getMenuFile() {
		return menuFile;
	}
}
