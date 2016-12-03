package com.school.project.gui.view.settings;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.school.project.gui.view.BaseView;
import com.school.project.nfc.KEY_LOCATION;
import com.school.project.nfc.KEY_TYPE;

public class NFCSettingsView extends BaseView {
	private static final long serialVersionUID = 1L;

	private JLabel lblLoc, lblType;
	private JComboBox<KEY_LOCATION> cbLoc;
	private JComboBox<KEY_TYPE> cbType;
	private JTextField txtReader, txtCard;
	private JButton btnReader, btnCard, btnDump;
	private JList<String> listDump;
	
	public NFCSettingsView() {
		super("NFC");
		
		initLayout();
	}
	
	private void initLayout() {
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		JScrollPane scroll = new JScrollPane(listDump = new JList<>());
		add(lblLoc = new JLabel("Key location: "));
		add(lblType = new JLabel("Key type: "));
		add(cbLoc = new JComboBox<>());
		add(cbType = new JComboBox<>());
		add(txtReader = new JTextField(20));
		add(txtCard = new JTextField(20));
		add(btnReader = new JButton("Check reader"));
		add(btnCard = new JButton("Check card"));
		add(btnDump = new JButton("Create dump"));
		add(scroll);
		
		sp.putConstraint(SpringLayout.WEST, lblType, 20, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lblType, 20, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, lblType, 150, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, cbType, 0, SpringLayout.NORTH, lblType);
		sp.putConstraint(SpringLayout.WEST, cbType, 20, SpringLayout.EAST, lblType);
		sp.putConstraint(SpringLayout.EAST, cbType, 100, SpringLayout.WEST, cbType);
		
		sp.putConstraint(SpringLayout.WEST, lblLoc, 0, SpringLayout.WEST, lblType);
		sp.putConstraint(SpringLayout.EAST, lblLoc, 0, SpringLayout.EAST, lblType);
		sp.putConstraint(SpringLayout.NORTH, lblLoc, 10, SpringLayout.SOUTH, lblType);
		sp.putConstraint(SpringLayout.NORTH, cbLoc, 0, SpringLayout.NORTH, lblLoc);
		sp.putConstraint(SpringLayout.EAST, cbLoc, 0, SpringLayout.EAST, cbType);
		sp.putConstraint(SpringLayout.WEST, cbLoc, 0, SpringLayout.WEST, cbType);

		sp.putConstraint(SpringLayout.EAST, btnReader, 0, SpringLayout.EAST, lblType);
		sp.putConstraint(SpringLayout.WEST, btnReader, 0, SpringLayout.WEST, lblType);
		sp.putConstraint(SpringLayout.NORTH, btnReader, 20, SpringLayout.SOUTH, lblLoc);
		sp.putConstraint(SpringLayout.NORTH, txtReader, 0, SpringLayout.NORTH, btnReader);
		sp.putConstraint(SpringLayout.WEST, txtReader, 0, SpringLayout.WEST, cbType);

		sp.putConstraint(SpringLayout.EAST, btnCard, 0, SpringLayout.EAST, lblType);
		sp.putConstraint(SpringLayout.WEST, btnCard, 0, SpringLayout.WEST, lblType);
		sp.putConstraint(SpringLayout.NORTH, btnCard, 20, SpringLayout.SOUTH, btnReader);
		sp.putConstraint(SpringLayout.NORTH, txtCard, 0, SpringLayout.NORTH, btnCard);
		sp.putConstraint(SpringLayout.WEST, txtCard, 0, SpringLayout.WEST, cbType);
		
		sp.putConstraint(SpringLayout.NORTH, btnDump, 0, SpringLayout.NORTH, lblType);
		sp.putConstraint(SpringLayout.EAST, btnDump, -20, SpringLayout.EAST, this);
		sp.putConstraint(SpringLayout.WEST, btnDump, -150, SpringLayout.EAST, btnDump);

		sp.putConstraint(SpringLayout.NORTH, scroll, 50, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, btnDump);
		sp.putConstraint(SpringLayout.WEST, scroll, 30, SpringLayout.HORIZONTAL_CENTER, this);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -20, SpringLayout.SOUTH, this);
	}

	public JLabel getLblLoc() {
		return lblLoc;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public JComboBox<KEY_LOCATION> getCbLoc() {
		return cbLoc;
	}

	public JComboBox<KEY_TYPE> getCbType() {
		return cbType;
	}

	public JTextField getTxtReader() {
		return txtReader;
	}

	public JTextField getTxtCard() {
		return txtCard;
	}

	public JButton getBtnReader() {
		return btnReader;
	}

	public JButton getBtnCard() {
		return btnCard;
	}

	public JButton getBtnDump() {
		return btnDump;
	}

	public JList<String> getListDump() {
		return listDump;
	}
	
}
