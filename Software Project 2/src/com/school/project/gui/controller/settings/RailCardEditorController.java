package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.school.project.dao.RailCardDAO;
import com.school.project.dao.TicketDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.RailCardEditorPanel;
import com.school.project.gui.view.settings.TicketEditorPanel;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.RailCard;
import com.school.project.model.Ticket;

public class RailCardEditorController implements Observer {
	private RailCardEditorPanel pnl;
	private PaymentBackListener list;
	private RailCard rc;
	private String strErrorFillIn, strSaveSuccess, strUpdateSuccess, strConfirmDelete;

	public RailCardEditorController(RailCardEditorPanel pnl, PaymentBackListener list) {
		this.pnl = pnl;
		this.list = list;

		this.rc = null;

		initEvents();
	}

	private void initEvents() {
		pnl.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.backToPreviousView();
			}
		});
		pnl.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(pnl, strConfirmDelete);
				if (response == JOptionPane.OK_OPTION && rc != null) {
					RailCardDAO.getInstance().delete(rc);
					list.backToPreviousView();
				}
				// TODO: Cache updaten anders problemen!
			}
		});
		pnl.getBtnSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isValid()){
					JOptionPane.showMessageDialog(pnl, strErrorFillIn);
					return;
				}
				Boolean newRc = false;
				if(rc == null){
					newRc  = true;
					rc = new RailCard(0,"","",0,0,0,false,false);
				}
				
				pnl.getTxtDesc().setText(rc.getDescription());
				pnl.getTxtName().setText(rc.getName());
				pnl.getTxtPricePerMonth().setText(rc.getPricePerMonth());
				
			}
		});
	}
	
	private boolean isValid(){
		if(pnl.getTxtName().getText().isEmpty()) return false;
		if(pnl.getTxtDesc().getText().isEmpty()) return false;
		
		try {
			Double.parseDouble(pnl.getTxtPricePerMonth().getText());
			Double.parseDouble(pnl.getTxtPricePer3Month().getText());
			Double.parseDouble(pnl.getTxtPricePerYear().getText());
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
		strErrorFillIn = lh.getString("errorAddLostItem");
		strSaveSuccess = lh.getString("saveSucces");
		strUpdateSuccess = lh.getString("updateSucces");
		strConfirmDelete = lh.getString("confirmDelete");

	}

}
