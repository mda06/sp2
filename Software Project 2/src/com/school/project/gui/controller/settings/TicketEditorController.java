package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.school.project.dao.TicketDAO;
import com.school.project.gui.controller.listener.PaymentBackListener;
import com.school.project.gui.view.settings.TicketEditorPanel;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;

public class TicketEditorController implements Observer{
	private TicketEditorPanel pnl;
	private PaymentBackListener list;
	private Ticket ticket;
	private String strErrorFillIn, strSaveSuccess, strUpdateSuccess, strConfirmDelete;

	public TicketEditorController(){
		super();
	}
	public TicketEditorController(TicketEditorPanel pnl, PaymentBackListener list) {
		this.pnl = pnl;
		this.list = list;
		ticket = null;
		strErrorFillIn = "Error, please fill in all the fiels";
		strSaveSuccess = "Ticket saved";
		strUpdateSuccess = "Ticket updated";
		strConfirmDelete = "Delete this ticket?";
		
		
		
		for(int i = 0; i < 999; i++){
			pnl.getJcValidityPer().addItem(i+1);
		}
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
				if(response == JOptionPane.OK_OPTION && ticket != null){
					TicketDAO.getInstance().delete(ticket);
				}
				list.backToPreviousView();
				//TODO: Cache updaten anders problemen!
			}
		});

		pnl.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isValid()) {
					JOptionPane.showMessageDialog(pnl, strErrorFillIn);
					return;
				}
				boolean newTicket = false;
				
				if(ticket == null){
					newTicket = true;
					ticket = new Ticket(0, "", "", 0, 0, true, false);
				}

				ticket.setPrice(Double.parseDouble(pnl.getTxtPrice().getText()));
				ticket.setName(pnl.getTxtName().getText());
				ticket.setDescription(pnl.getTxtDesc().getText());
				ticket.setValidityPeriod(pnl.getJcValidityPer().getSelectedIndex()+1);
				ticket.setHasFixedRoute(pnl.getCbHasFixedRoute().isSelected());

				if(!newTicket) {
					TicketDAO.getInstance().update(ticket);
					JOptionPane.showMessageDialog(pnl, strUpdateSuccess);
				} else {
					TicketDAO.getInstance().add(ticket);
					JOptionPane.showMessageDialog(pnl, strSaveSuccess);
				}
				
				TicketCache.getInstance().addTicket(ticket);
				
				ticket = null;
				pnl.getTxtDesc().setText("");
				pnl.getTxtName().setText("");
				pnl.getTxtPrice().setText("0");
				pnl.getCbHasFixedRoute().setSelected(false);
				list.backToPreviousView();
			}
		});
	}
	
	private boolean isValid() {
		if(pnl.getTxtName().getText().isEmpty()) return false;
		if(pnl.getTxtDesc().getText().isEmpty()) return false;
		try {
			Double.parseDouble(pnl.getTxtPrice().getText());
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void showTicket(Ticket t) {
		if (t == null)
			return;
		ticket = t;
		pnl.getTxtName().setText(ticket.getName());
		pnl.getTxtDesc().setText(ticket.getDescription());
		pnl.getTxtPrice().setText(String.valueOf(ticket.getPrice()));
		pnl.getCbHasFixedRoute().setSelected(ticket.isHasFixedRoute());
		System.out.println(ticket.getValidityPeriod());
		pnl.getJcValidityPer().setSelectedIndex(ticket.getValidityPeriod()-1);
		pnl.getBtnDelete().setVisible(true);
	}

	public void newTicket() {
		ticket = null;
		pnl.getTxtName().setText("");
		pnl.getTxtDesc().setText("");
		pnl.getTxtPrice().setText("");
		pnl.getCbHasFixedRoute().setSelected(false);
		
		pnl.getBtnDelete().setVisible(false);
	}

	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o).getLanguageHandler();
			pnl.getLblName().setText(lh.getString("name"));
			pnl.getBtnBack().setText(lh.getString("back"));
			pnl.getBtnSave().setText(lh.getString("save"));
			pnl.getBtnDelete().setText(lh.getString("delete"));
			pnl.getLblDesc().setText(lh.getString("description"));
			pnl.getLblPrice().setText(lh.getString("price"));
		}
	}
	
	

}
