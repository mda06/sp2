package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.school.project.dao.RailCardDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.RailCardEditorPanel;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;

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
				
				rc.setName(pnl.getTxtName().getText());
				rc.setDescription(pnl.getTxtDesc().getText());
				rc.setPricePerMonth(Double.parseDouble(pnl.getTxtPricePerMonth().getText()));
				rc.setPricePer3Month(Double.parseDouble(pnl.getTxtPricePer3Month().getText()));
				rc.setPricePerYear(Double.parseDouble(pnl.getTxtPricePerYear().getText()));
				rc.setHasFixedRoute(pnl.getCbHasFixedRoute().isSelected());
				
				if(!newRc){
					RailCardDAO.getInstance().update(rc);
					JOptionPane.showMessageDialog(pnl, strUpdateSuccess);
				}
				else{
					RailCardDAO.getInstance().add(rc);
					JOptionPane.showMessageDialog(pnl, strSaveSuccess);
				}
				RailCardCache.getInstance().addRailCard(rc);
				
				rc = null;
				pnl.getTxtDesc().setText("");
				pnl.getTxtName().setText("");
				pnl.getTxtPricePerMonth().setText("");
				pnl.getTxtPricePer3Month().setText("");
				pnl.getTxtPricePerYear().setText("");
				
				pnl.getCbHasFixedRoute().setSelected(false);
				list.backToPreviousView();
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
	
	public void showRailCard(RailCard rc) {
		if (rc == null)
			return;
		this.rc = rc;
		pnl.getTxtName().setText(rc.getName());
		pnl.getTxtDesc().setText(rc.getDescription());
		pnl.getTxtPricePerMonth().setText(String.valueOf(rc.getPricePerMonth()));
		pnl.getTxtPricePer3Month().setText(String.valueOf(rc.getPricePer3Month()));
		pnl.getTxtPricePerYear().setText(String.valueOf(rc.getPricePerYear()));
		pnl.getCbHasFixedRoute().setSelected(rc.isHasFixedRoute());
		pnl.getBtnDelete().setVisible(true);
	}
	
	public void newTicket(){
		rc = null;
		pnl.getTxtDesc().setText("");
		pnl.getTxtName().setText("");
		pnl.getTxtPricePerMonth().setText("");
		pnl.getTxtPricePer3Month().setText("");
		pnl.getTxtPricePerYear().setText("");
		pnl.getCbHasFixedRoute().setSelected(false);
		
		pnl.getBtnDelete().setVisible(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable) o).getLanguageHandler();
			pnl.getLblName().setText(lh.getString("name"));
			pnl.getBtnBack().setText(lh.getString("back"));
			pnl.getBtnSave().setText(lh.getString("save"));
			pnl.getBtnDelete().setText(lh.getString("delete"));
			pnl.getLblDesc().setText(lh.getString("description"));
			pnl.getCbHasFixedRoute().setText(lh.getString("hasFixedRoute"));
			pnl.getLblPricePerMonth().setText(lh.getString("pricePerMonth"));
			pnl.getLblPricePer3Month().setText(lh.getString("pricePer3Month"));
			pnl.getLblPricePerYear().setText(lh.getString("pricePerYear"));
			strErrorFillIn = lh.getString("errorAddLostItem");
			strSaveSuccess = lh.getString("saveSucces");
			strUpdateSuccess = lh.getString("updateSucces");
			strConfirmDelete = lh.getString("confirmDelete");
		}
		

	}

}
