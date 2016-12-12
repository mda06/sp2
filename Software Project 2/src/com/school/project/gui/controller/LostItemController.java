package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

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
	private String strErrorAdd, strRemove;

	public LostItemController() {

		super(new LostItemView());
		tableModel = new LostItemTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setAutoCreateRowSorter(true);

		view.getTxtSearchType().setFocusable(true);
		new Thread(() -> initLostItemsToTable()).start();;
		initSearchBoxEvents();
		initAddLostItem();
		initRemoveLostItem();
	}

	private void initAddLostItem() {
		strErrorAdd = "Error: please fill in all the fields";
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

						if (!type.isEmpty() && !desc.isEmpty() && !loc.isEmpty()) {
							LostItem item = new LostItem(1, type, desc, loc, false, false);
							LostItemDAO.getInstance().add(item);
							tableModel.addLostItem(item);
							addFrame.resetFields();
							addFrame.dispose();
						} else {
							JOptionPane.showMessageDialog(addFrame, strErrorAdd);
						}
					}
				});
			}
		});
	}

	public void initLostItemsToTable() {
		for (LostItem item : LostItemDAO.getInstance().getAll()) {
			tableModel.addLostItem(item);
		}
	}

	public void initRemoveLostItem() {
		strRemove = "Remove ";
		ListSelectionModel listSelectionModel = view.getTable().getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // No
																					// multiple
																					// selections
																					// allowed

		view.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					LostItem selectedItem = tableModel
							.getLostItemAt(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow()));
					int confirmed = JOptionPane.showConfirmDialog(view.getTable(),
							strRemove + selectedItem.getType() + "?");
					if (confirmed == JOptionPane.OK_OPTION) {
						selectedItem.setPickedUp(true);
						LostItemDAO.getInstance().delete(selectedItem);
						tableModel.removeRow(view.getTable().getSelectedRow());
					}
				}
			}
		});
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof LanguageObservable) {
			LanguageHandler handler = ((LanguageObservable) observable).getLanguageHandler();
			view.getBtnSearch().setText(handler.getString("search"));
			view.getBtnAdd().setText(handler.getString("add"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_TYPE)
					.setHeaderValue(handler.getString("type"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_DESCRIPTION)
					.setHeaderValue(handler.getString("description"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_LOCATION)
					.setHeaderValue(handler.getString("location"));
			view.getTable().getTableHeader().repaint();
		
			addFrame.getBtnCancel().setText(handler.getString("cancel"));
			addFrame.getBtnSave().setText(handler.getString("save"));
			addFrame.getLblType().setText(handler.getString("type"));
			addFrame.getLblDescription().setText(handler.getString("description"));
			addFrame.getLblLocation().setText(handler.getString("location"));

			strErrorAdd = handler.getString("errorAddLostItem");
			strRemove = handler.getString("removeLostItem");
			
			view.getTxtSearchType().setToolTipText(handler.getString("tooltipLostItem"));
		}
	}

	private void initSearchBoxEvents() {
		
		view.getTxtSearchType().addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				view.getTxtSearchType().setText("");
			}

			public void focusLost(FocusEvent e) {
				if (view.getTxtSearchType().getText().isEmpty()) {
					//view.getTxtSearch().setText("Search");
				}
			}
		});
		view.getTxtSearchDesc().addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				view.getTxtSearchDesc().setText("");
				
			}

			public void focusLost(FocusEvent e) {				
			}
		});
		view.getTxtSearchLoc().addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				view.getTxtSearchLoc().setText("");
				
			}

			public void focusLost(FocusEvent e) {				
			}
		});
		
		ActionListener searchAction = new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}
				if (!view.getTxtSearchType().getText().isEmpty()) {
					for (LostItem item : LostItemDAO.getInstance().getByType(view.getTxtSearchType().getText())) {
						tableModel.addLostItem(item);
					}
					view.getTxtSearchType().setText("");
				}
				else if(!view.getTxtSearchDesc().getText().isEmpty()){
					for (LostItem item : LostItemDAO.getInstance().getByDescription(view.getTxtSearchDesc().getText())) {
						tableModel.addLostItem(item);
					}
					view.getTxtSearchDesc().setText("");
				}
				else if(!view.getTxtSearchLoc().getText().isEmpty()){
					for (LostItem item : LostItemDAO.getInstance().getByLocation(view.getTxtSearchLoc().getText())) {
						tableModel.addLostItem(item);
					}
					view.getTxtSearchLoc().setText("");
				}					
				else {
					initLostItemsToTable();
				}
			}
		};
		
//		KeyListener searchEnter = new KeyListener(){
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER){
//					view.getBtnSearch().addActionListener(searchAction);
//				}
//				
//			}
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		};
//		
//		view.getBtnSearch().addKeyListener(searchEnter);
		
		view.getBtnSearch().addActionListener(searchAction);
		view.getTxtSearchType().addActionListener(searchAction);
		view.getTxtSearchDesc().addActionListener(searchAction);
		view.getTxtSearchLoc().addActionListener(searchAction);
	}
}
