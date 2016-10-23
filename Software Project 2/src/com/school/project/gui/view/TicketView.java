package com.school.project.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicketView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton btnStandaardBiljet, btnBiljetKind, btnBiljetGroteGezinnen;

	public TicketView() {
		super("ticketView");
		
		initLayout();
	}

	private void initLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		btnStandaardBiljet = new JButton("Standaard Biljet");
		btnBiljetKind = new JButton("Biljet Kind");
		btnBiljetGroteGezinnen = new JButton("Biljet Grote Gezinnen");

		GridLayout gr = new GridLayout(0,2,5,5);
		setLayout(gr);
		add(btnStandaardBiljet);
		add(btnBiljetKind);
		add(btnBiljetGroteGezinnen);
		

		setVisible(true);
	}
	public static void main(String[] args) {
		new TicketView();
	}

}
