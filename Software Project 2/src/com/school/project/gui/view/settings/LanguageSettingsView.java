package com.school.project.gui.view.settings;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import com.school.project.gui.view.BaseView;

public class LanguageSettingsView extends BaseView {
	private static final long serialVersionUID = 1L;

	private ImageIcon imgLoading;
	private JLabel lblLoading;
	private JComboBox<String> comboLanguages;
	private JButton btnLoad, btnSave;
	private JTable tblTranslated;
	private JScrollPane scroll;

	public LanguageSettingsView() {
		super("LanguageSettings");

		initLayout();
	}

	private void initLayout() {
		SpringLayout sp = new SpringLayout();
		setLayout(sp);

		String[] columnNames = { "Key", "New Language" };
		Object[][] data = { };

		String[] items = { "fr", "az", "be", "bg", "ca", "cs", "da", "de", "el", "en", "es", "et", "fi", "fr", "hr",
				"hu", "hy", "it", "lt", "lv", "mk", "nl", "no", "pl", "pt", "ro", "ru", "sk", "sl", "sq", "sr", "sv",
				"tr", "uk" };
		add(btnLoad = new JButton("Add this language"));
		add(comboLanguages = new JComboBox<String>(items));
		add(btnSave = new JButton("Save"));
		btnSave.setVisible(false);
		scroll = new JScrollPane(tblTranslated = new JTable(data, columnNames));
		add(scroll);
		scroll.setVisible(false);
		add(lblLoading = new JLabel("Loading...",
				imgLoading = new ImageIcon(getClass().getResource("/ajax-loader.gif")), JLabel.CENTER));
		lblLoading.setVisible(false);

		sp.putConstraint(SpringLayout.WEST, comboLanguages, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, comboLanguages, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.NORTH, btnLoad, 0, SpringLayout.NORTH, comboLanguages);
		sp.putConstraint(SpringLayout.WEST, btnLoad, 20, SpringLayout.EAST, comboLanguages);
		sp.putConstraint(SpringLayout.NORTH, lblLoading, 0, SpringLayout.NORTH, btnLoad);
		sp.putConstraint(SpringLayout.WEST, lblLoading, 20, SpringLayout.EAST, btnLoad);
		sp.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, btnLoad);
		sp.putConstraint(SpringLayout.WEST, btnSave, 20, SpringLayout.EAST, lblLoading);
		sp.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, comboLanguages);
		sp.putConstraint(SpringLayout.NORTH, scroll, 20, SpringLayout.SOUTH, btnLoad);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -20, SpringLayout.SOUTH, this);
		sp.putConstraint(SpringLayout.EAST, scroll, -20, SpringLayout.EAST, this);
	}

	public JComboBox<String> getComboLanguages() {
		return comboLanguages;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public ImageIcon getImgLoading() {
		return imgLoading;
	}

	public JLabel getLblLoading() {
		return lblLoading;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JScrollPane getScrollLst() {
		return scroll;
	}

	public JTable getTblTranslated() {
		return tblTranslated;
	}

}
