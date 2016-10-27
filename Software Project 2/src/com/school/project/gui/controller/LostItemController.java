package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.school.project.dao.LostItemDAO;
import com.school.project.gui.model.LostItemTableModel;
import com.school.project.gui.view.LostItemAddFrame;
import com.school.project.gui.view.LostItemView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.LostItem;

public class LostItemController extends BaseController<LostItemView> {
	private LostItemTableModel tableModel;
	
	public LostItemController() {
		super(new LostItemView());
		tableModel = new LostItemTableModel();
		view.getTable().setModel(tableModel);
		view.getTxtSearch().setFocusable(true);
		initLostItemsToTable();
		initAddLostItem();
	}
	
	private void initAddLostItem() {
		view.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostItemAddFrame frame = new LostItemAddFrame();
				frame.setVisible(true);
				frame.getBtnCancel().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				frame.getBtnSave().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String type = frame.getTxtType().getText();
						String desc = frame.getTxtDescription().getText();
						String loc = frame.getTxtLocation().getText();
						
						if(!type.isEmpty() && !desc.isEmpty() && !loc.isEmpty()) {
							LostItem item = new LostItem(1, type, desc, loc, false, false);
							LostItemDAO.getInstance().add(item);
							tableModel.addLostItem(item);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "Error: please fill in all the fields");
						}
					}
				});
			}
		});
	}
	
	//TODO: put it in another thread
	public void initLostItemsToTable() {
		for(LostItem item : LostItemDAO.getInstance().getAll()) {
			tableModel.addLostItem(item);
		}
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof LanguageObservable){
			LanguageHandler handler = ((LanguageObservable)observable).getLanguageHandler();
			view.getBtnSearch().setText(handler.getString("search"));
			view.getBtnAdd().setText(handler.getString("add"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_TYPE).setHeaderValue(handler.getString("type"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_DESCRIPTION).setHeaderValue(handler.getString("description"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_LOCATION).setHeaderValue(handler.getString("location"));
			view.getTable().getTableHeader().repaint();
			
			((TitledBorder)view.getPnlAdd().getBorder()).setTitle(handler.getString("add"));
			view.getPnlAdd().repaint();
			((TitledBorder)view.getPnlSearch().getBorder()).setTitle(handler.getString("search"));
			view.getPnlSearch().repaint();
		}
	}
}
