package com.school.project.gui.controller.settings;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.school.project.dao.FormulaDAO;
import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.TicketPriceEditorPanel;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.price.Formula;
import com.school.project.util.PriceUtil;

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
		
		view.getTxtFormula().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				strFormula = view.getTxtFormula().getText();
				enableBtnsArithmetics(true);
				enableBtnsNumbers(true);
				view.getBtnSave().setEnabled(false);
			}
		});
		
		view.getBtnTkVal().addActionListener((l) -> {
			strFormula += Formula.VAR_VAL + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnTkPrice().addActionListener((l) -> {
			strFormula += Formula.VAR_PRICE + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnTkFixRoute().addActionListener((l) -> {
			strFormula += Formula.VAR_FIXROUTE + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStDst().addActionListener((l) -> {
			strFormula += Formula.VAR_DST + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStDur().addActionListener((l) -> {
			strFormula += Formula.VAR_DUR + " ";
			showFormula();
			enableBtnsArithmetics(true);
			enableBtnsNumbers(false);
		});
		view.getBtnStStops().addActionListener((l) -> {
			strFormula += Formula.VAR_NBSTOPS + " ";
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
			
			formula.addVar(Formula.VAR_DST, Double.parseDouble(view.getTxtStDst().getText()));
			formula.addVar(Formula.VAR_DUR, Double.parseDouble(view.getTxtStDur().getText()));
			formula.addVar(Formula.VAR_NBSTOPS, Double.parseDouble(view.getTxtStStops().getText()));
			formula.addVar(Formula.VAR_VAL, Double.parseDouble(view.getTxtTkVal().getText()));
			formula.addVar(Formula.VAR_PRICE, Double.parseDouble(view.getTxtTkPrice().getText()));
			formula.addVar(Formula.VAR_FIXROUTE, Double.parseDouble(view.getTxtTkFixRoute().getText()));
			
			String msg = "";
			try {
				double out = formula.parse(strFormula);
				msg = "The price is: " + out;
				FormulaDAO.getInstance().setNewFormula(strFormula);
				view.getBtnSave().setEnabled(true);
			} catch (RuntimeException e) {
				msg = "Error in the formula !";
			}
			
			JOptionPane.showMessageDialog(view, msg);
		});
		view.getBtnSave().addActionListener((l) -> {
			PriceUtil.getInstance().setFormula(strFormula);
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
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o). getLanguageHandler();
			view.getBtnTkVal().setText(lh.getString("validityPeriod"));
			view.getBtnTkPrice().setText(lh.getString("btnPrice"));
			view.getBtnTkFixRoute().setText(lh.getString("fixedRoute"));
			
			view.getBtnStDst().setText(lh.getString("distance"));
			view.getBtnStDur().setText(lh.getString("duration"));
			view.getBtnStStops().setText(lh.getString("numberOfVias"));
			
			view.getBtnAddConst().setText(lh.getString("add"));
			
			view.getLblDst().setText(lh.getString("distance") + ":");
			view.getLblDur().setText(lh.getString("duration") + ":");
			view.getLblStops().setText(lh.getString("numberOfVias") + ":");
			view.getLblVal().setText(lh.getString("validityPeriod") + ":");
			view.getLblPrice().setText(lh.getString("price"));
			view.getLblFixed().setText(lh.getString("fixedRoute") + ":");
			
			view.getBtnRemove().setText(lh.getString("remove"));
			view.getBtnTest().setText(lh.getString("test"));
			view.getBtnSave().setText(lh.getString("save"));
			
			((TitledBorder)view.getPnlToolbox().getBorder()).setTitle(lh.getString("toolbox"));
			((TitledBorder)view.getPnlTk().getBorder()).setTitle(lh.getString("ticket"));
			((TitledBorder)view.getPnlSt().getBorder()).setTitle(lh.getString("station"));
			((TitledBorder)view.getPnlAri().getBorder()).setTitle(lh.getString("arithmetics"));
			((TitledBorder)view.getPnlTest().getBorder()).setTitle(lh.getString("testData"));
			((TitledBorder)view.getPnlFormula().getBorder()).setTitle(lh.getString("formula"));
		}
	}
	
	@Override
	public void show() {
		strFormula = PriceUtil.getInstance().getStrFormula();
		showFormula();
		super.show();
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
