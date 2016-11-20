package com.school.project.gui.view;

import java.awt.CardLayout;
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
	private JMenu menuOptions;
	private JMenuItem miEn, miNl, miFr;
	
	public FrameView() {
		setTitle("FrameView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initLayout();
		initMenu();
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
	
	private void initMenu(){
		menuBar = new JMenuBar();
		menuOptions = new JMenu("Options");
		miEn = new JMenuItem("English");
		miFr = new JMenuItem("Francais");
		miNl = new JMenuItem("Nederlands");
		menuOptions.add(miNl);
		menuOptions.add(miFr);
		menuOptions.add(miEn);
		menuBar.add(menuOptions);
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

	public void setMenuOptions(JMenu menuOptions) {
		this.menuOptions = menuOptions;
	}

	public JMenuItem getMiEn() {
		return miEn;
	}

	public void setMiEn(JMenuItem miEn) {
		this.miEn = miEn;
	}

	public JMenuItem getMiNl() {
		return miNl;
	}

	public void setMiNl(JMenuItem miNl) {
		this.miNl = miNl;
	}

	public JMenuItem getMiFr() {
		return miFr;
	}

	public void setMiFr(JMenuItem miFr) {
		this.miFr = miFr;
	}
	
	
}
