package com.school.project.gui.view.settings;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.school.project.gui.view.BaseView;
import com.school.project.util.FontUtil;

public class TicketPriceEditorPanel extends BaseView {
	private static final long serialVersionUID = 1L;

	private JButton btnTkVal, btnTkPrice, btnTkFixRoute, btnStDst, btnStDur, btnStStops;
	private JButton btnPlus, btnMin, btnDiv, btnTimes, btnOpenParentheses, btnCloseParentheses, btnAddConst, btnRemove;
	private JLabel lblDst, lblDur, lblStops, lblVal, lblPrice, lblFixed;
	private JTextField txtConst, txtStDst, txtStDur, txtStStops;
	private JTextField txtTkVal, txtTkPrice, txtTkFixRoute;
	private JButton btnTest, btnSave;
	private JTextArea txtFormula;
	
	public TicketPriceEditorPanel() {
		super("TicketPriceEditorPanel");
		initLayout();
	}
	
	private void initLayout() {
		JPanel pnlTk = new JPanel(), pnlSt = new JPanel(), pnlAri = new JPanel();
		pnlTk.setBorder(BorderFactory.createTitledBorder("Ticket"));
		pnlTk.setLayout(new GridLayout(3, 1));
		pnlTk.add(btnTkVal = new JButton("Validity Period"));
		pnlTk.add(btnTkPrice = new JButton("Price"));
		pnlTk.add(btnTkFixRoute = new JButton("Fixed route"));
		
		pnlSt.setBorder(BorderFactory.createTitledBorder("Station"));
		pnlSt.setLayout(new GridLayout(3, 1));
		pnlSt.add(btnStDst = new JButton("Distance"));
		pnlSt.add(btnStDur = new JButton("Duration"));
		pnlSt.add(btnStStops = new JButton("Nb of stops"));
		
		pnlAri.setBorder(BorderFactory.createTitledBorder("Arithmetics"));
		pnlAri.setLayout(new GridLayout(2, 4));
		pnlAri.add(btnPlus = new JButton("+"));
		pnlAri.add(btnMin = new JButton("-"));
		pnlAri.add(btnDiv = new JButton("/"));
		pnlAri.add(btnTimes = new JButton("*"));
		pnlAri.add(btnOpenParentheses = new JButton("("));
		pnlAri.add(btnCloseParentheses = new JButton(")"));
		pnlAri.add(txtConst = new JTextField("0"));
		pnlAri.add(btnAddConst = new JButton("Add"));
		
		JPanel pnlTest = new JPanel(), pnlFormula = new JPanel(), pnlBtns = new JPanel();
		pnlTest.setBorder(BorderFactory.createTitledBorder("Test Data"));
		pnlTest.setLayout(new GridLayout(3, 4));
		pnlTest.add(lblDst = new JLabel("Distance: ", JLabel.TRAILING));
		pnlTest.add(txtStDst = new JTextField("0", 20));
		pnlTest.add(lblVal = new JLabel("Validity: ", JLabel.TRAILING));
		pnlTest.add(txtTkVal = new JTextField("0", 20));
		pnlTest.add(lblDur = new JLabel("Duration: ", JLabel.TRAILING));
		pnlTest.add(txtStDur = new JTextField("0", 20));
		pnlTest.add(lblPrice = new JLabel("Price: ", JLabel.TRAILING));
		pnlTest.add(txtTkPrice = new JTextField("0", 20));
		pnlTest.add(lblStops = new JLabel("Stops: ", JLabel.TRAILING));
		pnlTest.add(txtStStops = new JTextField("0", 20));
		pnlTest.add(lblFixed = new JLabel("Fixed route: ", JLabel.TRAILING));
		pnlTest.add(txtTkFixRoute = new JTextField("0", 20));
		
		pnlFormula.setBorder(BorderFactory.createTitledBorder("Formula"));
		pnlFormula.setLayout(new BorderLayout());
		pnlFormula.add(txtFormula = new JTextArea(5, 20));
		txtFormula.setFont(FontUtil.getInstance().getBigFont());
		
		pnlBtns.add(btnTest = new JButton("Test formula"));
		pnlBtns.add(btnSave = new JButton("Save formula"));
		btnSave.setEnabled(false);
		
		JPanel pnlToolbox = new JPanel();
		pnlToolbox.setBorder(BorderFactory.createTitledBorder("Toolbox"));
		pnlToolbox.setLayout(new BoxLayout(pnlToolbox, BoxLayout.Y_AXIS));
		pnlToolbox.add(pnlTk);
		pnlToolbox.add(pnlSt);
		pnlToolbox.add(pnlAri);
		pnlToolbox.add(btnRemove = new JButton("Remove"));
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.add(pnlTest, BorderLayout.NORTH);
		pnlCenter.add(pnlFormula);
		pnlCenter.add(pnlBtns, BorderLayout.SOUTH);
		
		setLayout(new BorderLayout());
		add(pnlToolbox, BorderLayout.WEST);
		add(pnlCenter);
		
		FontUtil.getInstance().bindSmallFont(btnTkVal);
		FontUtil.getInstance().bindSmallFont(btnTkPrice);
		FontUtil.getInstance().bindSmallFont(btnTkFixRoute);
		FontUtil.getInstance().bindSmallFont(btnStDst);
		FontUtil.getInstance().bindSmallFont(btnStDur);
		FontUtil.getInstance().bindSmallFont(btnStStops);
		FontUtil.getInstance().bindSmallFont(btnMin);
		FontUtil.getInstance().bindSmallFont(btnDiv);
		FontUtil.getInstance().bindSmallFont(btnOpenParentheses);
		FontUtil.getInstance().bindSmallFont(btnCloseParentheses);
		FontUtil.getInstance().bindSmallFont(btnAddConst);
		FontUtil.getInstance().bindSmallFont(btnRemove);
		FontUtil.getInstance().bindSmallFont(lblDst);
		FontUtil.getInstance().bindSmallFont(lblDur);
		FontUtil.getInstance().bindSmallFont(lblStops);
		FontUtil.getInstance().bindSmallFont(lblPrice);
		FontUtil.getInstance().bindSmallFont(lblFixed);
		FontUtil.getInstance().bindSmallFont(txtConst);
		FontUtil.getInstance().bindSmallFont(txtStDst);
		FontUtil.getInstance().bindSmallFont(txtStStops);
		FontUtil.getInstance().bindSmallFont(txtTkVal);
		FontUtil.getInstance().bindSmallFont(txtTkFixRoute);
		FontUtil.getInstance().bindSmallFont(btnSave);
		FontUtil.getInstance().bindSmallFont(txtFormula);
		FontUtil.getInstance().bindSmallFont(lblVal);
		FontUtil.getInstance().bindSmallFont(txtTkVal);
		FontUtil.getInstance().bindSmallFont(txtTkPrice);
		FontUtil.getInstance().bindSmallFont(btnTest);
		FontUtil.getInstance().bindSmallFont(txtStDur);
		
	}
	
	public JLabel getLblDst() {
		return lblDst;
	}

	public JLabel getLblDur() {
		return lblDur;
	}

	public JLabel getLblStops() {
		return lblStops;
	}

	public JLabel getLblVal() {
		return lblVal;
	}

	public JLabel getLblPrice() {
		return lblPrice;
	}

	public JLabel getLblFixed() {
		return lblFixed;
	}

	public JButton getBtnTkVal() {
		return btnTkVal;
	}

	public JButton getBtnTkPrice() {
		return btnTkPrice;
	}

	public JButton getBtnTkFixRoute() {
		return btnTkFixRoute;
	}

	public JButton getBtnStDst() {
		return btnStDst;
	}

	public JButton getBtnStDur() {
		return btnStDur;
	}

	public JButton getBtnStStops() {
		return btnStStops;
	}

	public JButton getBtnPlus() {
		return btnPlus;
	}

	public JButton getBtnMin() {
		return btnMin;
	}

	public JButton getBtnDiv() {
		return btnDiv;
	}

	public JButton getBtnTimes() {
		return btnTimes;
	}

	public JButton getBtnOpenParentheses() {
		return btnOpenParentheses;
	}

	public JButton getBtnCloseParentheses() {
		return btnCloseParentheses;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnAddConst() {
		return btnAddConst;
	}

	public JTextField getTxtConst() {
		return txtConst;
	}

	public JTextField getTxtStDst() {
		return txtStDst;
	}

	public JTextField getTxtStDur() {
		return txtStDur;
	}

	public JTextField getTxtStStops() {
		return txtStStops;
	}

	public JTextField getTxtTkVal() {
		return txtTkVal;
	}

	public JTextField getTxtTkPrice() {
		return txtTkPrice;
	}

	public JTextField getTxtTkFixRoute() {
		return txtTkFixRoute;
	}

	public JButton getBtnTest() {
		return btnTest;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JTextArea getTxtFormula() {
		return txtFormula;
	}
}