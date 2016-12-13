package com.school.project.gui.controller.settings;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.TicketPriceEditorPanel;
import com.school.project.model.price.Formula;

public class TicketPriceEditorController extends BaseController<TicketPriceEditorPanel>{
	private Formula formula;
	private String strFormula;
	
	public TicketPriceEditorController() {
		super(new TicketPriceEditorPanel());
		formula = new Formula();
		strFormula = "";
		initEvents();
	}
	
	private void initEvents() {
		view.getBtnTkVal().addActionListener((l) -> {
			strFormula += "val ";
			showFormula();
		});
		view.getBtnTkPrice().addActionListener((l) -> {
			strFormula += "price ";
			showFormula();
		});
		view.getBtnTkFixRoute().addActionListener((l) -> {
			strFormula += "fixroute ";
			showFormula();
		});
		view.getBtnStDst().addActionListener((l) -> {
			strFormula += "dst ";
			showFormula();
		});
		view.getBtnStDur().addActionListener((l) -> {
			strFormula += "dur ";
			showFormula();
		});
		view.getBtnStStops().addActionListener((l) -> {
			strFormula += "nbstops ";
			showFormula();
		});
		view.getBtnDiv().addActionListener((l) -> {
			strFormula += "/ ";
			showFormula();
		});
		view.getBtnPlus().addActionListener((l) -> {
			strFormula += "+ ";
			showFormula();
		});
		view.getBtnMin().addActionListener((l) -> {
			strFormula += "- ";
			showFormula();
		});
		view.getBtnTimes().addActionListener((l) -> {
			strFormula += "* ";
			showFormula();
		});
		view.getBtnOpenParentheses().addActionListener((l) -> {
			strFormula += "(";
			showFormula();
		});
		view.getBtnOpenParentheses().addActionListener((l) -> {
			strFormula += ")";
			showFormula();
		});
		view.getBtnAddConst().addActionListener((l) -> {
			strFormula += view.getTxtConst().getText() + " ";
			showFormula();
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
			} catch(RuntimeException e) {
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

	@Override
	public void update(Observable o, Object arg) {}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TicketPriceEditorController().getBaseView());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
