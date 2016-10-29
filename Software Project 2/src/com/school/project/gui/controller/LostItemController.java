package com.school.project.gui.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
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
	private LostItemAddFrame addFrame;
	ListSelectionModel listSelectionModel;
	
	public LostItemController() {
		super(new LostItemView());
		tableModel = new LostItemTableModel();
		view.getTable().setModel(tableModel);
		
        
		view.getTxtSearch().setFocusable(true);
		initLostItemsToTable();
		initAddLostItem();
		initRemoveLostItem();
	}
	
	private void initAddLostItem() {
		addFrame = new LostItemAddFrame();
		view.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame.setVisible(true);
				addFrame.getBtnCancel().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addFrame.dispose();
					}
				});
				addFrame.getBtnSave().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String type = addFrame.getTxtType().getText();
						String desc = addFrame.getTxtDescription().getText();
						String loc = addFrame.getTxtLocation().getText();
						
						if(!type.isEmpty() && !desc.isEmpty() && !loc.isEmpty()) {
							LostItem item = new LostItem(1, type, desc, loc, false, false);
							LostItemDAO.getInstance().add(item);
							tableModel.addLostItem(item);
							addFrame.resetFields();
							addFrame.dispose();
						} else {
							//TODO: translated text (buttons?)
							JOptionPane.showMessageDialog(addFrame, "Error: please fill in all the fields");
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
	
	public void initRemoveLostItem(){
		listSelectionModel = view.getTable().getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //No multiple selections allowed
		
		view.getTable().addMouseListener(new MouseAdapter(){ 
			public void mouseClicked(MouseEvent e) { 
				if(e.getClickCount() == 2){
					//TODO: Get translated option text
					int confirmed = JOptionPane.showConfirmDialog(view.getTable(), "Remove this item?");
					if(confirmed == JOptionPane.OK_OPTION){
						LostItem selectedItem = tableModel.getLostItemAt(view.getTable().getSelectedRow());
						selectedItem.setPickedUp(true);
						LostItemDAO.getInstance().update(selectedItem);
						tableModel.removeRow(view.getTable().getSelectedRow());
					}
				}
			}
		});
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
