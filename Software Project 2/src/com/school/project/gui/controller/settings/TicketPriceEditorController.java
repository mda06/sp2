package com.school.project.gui.controller.settings;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.TicketPriceEditorPanel;
import com.school.project.model.price.Formula;

public class TicketPriceEditorController extends BaseController<TicketPriceEditorPanel> {
	private Formula formula;
	private String strFormula;

	public TicketPriceEditorController() {
		super(new TicketPriceEditorPanel());
		formula = new Formula();
		strFormula = "";
		initEvents();
	}

	private void initEvents() {
		KeyAdapter onlyNumbers = new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) {
					e.consume();
				}
			}
		};
		view.getTxtConst().addKeyListener(onlyNumbers);
		view.getTxtStDst().addKeyListener(onlyNumbers);
		view.getTxtStDur().addKeyListener(onlyNumbers);
		view.getTxtStStops().addKeyListener(onlyNumbers);
		view.getTxtTkVal().addKeyListener(onlyNumbers);
		view.getTxtTkPrice().addKeyListener(onlyNumbers);
		view.getTxtTkFixRoute().addKeyListener(onlyNumbers);
		
		view.getBtnTkVal().addActionListener((l) -> {
			strFormula += "val ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnTkPrice().addActionListener((l) -> {
			strFormula += "price ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnTkFixRoute().addActionListener((l) -> {
			strFormula += "fixroute ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStDst().addActionListener((l) -> {
			strFormula += "dst ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStDur().addActionListener((l) -> {
			strFormula += "dur ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStStops().addActionListener((l) -> {
			strFormula += "nbstops ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnDiv().addActionListener((l) -> {
			strFormula += "/ ";
			showFormula();
			enableBtnsArithmetics(false);
			enableBtnsNumbers(true);
		});
		view.getBtnPlus().addActionListener((l) -> {
			strFormula += "+ ";
			showFormula();
			enableBtnsArithmetics(false);
			enableBtnsNumbers(true);
		});
		view.getBtnMin().addActionListener((l) -> {
			strFormula += "- ";
			showFormula();
			enableBtnsArithmetics(false);
			enableBtnsNumbers(true);
		});
		view.getBtnTimes().addActionListener((l) -> {
			strFormula += "* ";
			showFormula();
			enableBtnsArithmetics(false);
			enableBtnsNumbers(true);
		});
		view.getBtnOpenParentheses().addActionListener((l) -> {
			strFormula += "(";
			showFormula();
		});
		view.getBtnCloseParentheses().addActionListener((l) -> {
			strFormula += ")";
			showFormula();
		});
		view.getBtnAddConst().addActionListener((l) -> {
			strFormula += view.getTxtConst().getText() + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});

		view.getBtnTest().addActionListener((l) -> {
			formula.addVar("dst", Double.parseDouble(view.getTxtStDst().getText()));
			formula.addVar("dur", Double.parseDouble(view.getTxtStDur().getText()));
			formula.addVar("nbstops", Double.parseDouble(view.getTxtStStops().getText()));
			formula.addVar("val", Double.parseDouble(view.getTxtTkVal().getText()));
			formula.addVar("price", Double.parseDouble(view.getTxtTkPrice().getText()));
			formula.addVar("fixroute", Double.parseDouble(view.getTxtTkFixRoute().getText()));

			String msg = "";
			try {
				double out = formula.parse(strFormula);
				msg = "The price is: " + out;
			} catch (RuntimeException e) {
				msg = "Error in the formula !";
			}

			JOptionPane.showMessageDialog(view, msg);
			view.getBtnSave().setEnabled(true);
		});
	}

	private void showFormula() {
		view.getBtnSave().setEnabled(false);
		view.getTxtFormula().setText(strFormula);
	}
	
	private void enableBtnsArithmetics(boolean en) {
		view.getBtnMin().setEnabled(en);
		view.getBtnDiv().setEnabled(en);
		view.getBtnPlus().setEnabled(en);
		view.getBtnTimes().setEnabled(en);
	}
	
	private void enableBtnsNumbers(boolean en) {
		view.getBtnAddConst().setEnabled(en);
		view.getBtnStDst().setEnabled(en);
		view.getBtnStDur().setEnabled(en);
		view.getBtnStStops().setEnabled(en);
		view.getBtnTkVal().setEnabled(en);
		view.getBtnTkPrice().setEnabled(en);
		view.getBtnTkFixRoute().setEnabled(en);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TicketPriceEditorController().getBaseView());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
