package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ListSelectionModel;

import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.controller.runnable.SelectUserRunnable;
import com.school.project.gui.model.SelectUserTableModel;
import com.school.project.gui.view.SelectUserPopup;
import com.school.project.language.LanguageObservable;
import com.school.project.model.User;

public class SelectUserController implements Observer{
	private SelectUserPopup popup;
	private SelectUserRunnable runnable;
	private SelectedUserListener list;
	private SelectUserTableModel tableModel;
	
	public SelectUserController(SelectedUserListener lst) {
		popup = new SelectUserPopup();
		tableModel = new SelectUserTableModel();
		popup.getTblUsers().setModel(tableModel);
		ListSelectionModel listSelectionModel = popup.getTblUsers().getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		runnable = new SelectUserRunnable(popup);
		list = lst;
			
		initEvents();
	}
	
	private void selectEvent(){
			if(list != null) {
				User user = tableModel.getUserAt(popup.getTblUsers().getSelectedRow());
				list.userIsSelected(user);
				popup.dispose();
			}
	}
	
	private void initEvents() {
		ActionListener searchAction = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i = tableModel.getRowCount() - 1; i >= 0; i--){
					tableModel.removeRow(i);
				}
				new Thread(runnable).start();
			}
		};
		popup.getBtnSearch().addActionListener(searchAction);
		popup.getTxtFirstName().addActionListener(searchAction);
		popup.getTxtLastName().addActionListener(searchAction);
		
		ActionListener selectAction = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				selectEvent();	
			}
			
		};
		popup.getBtnSelect().addActionListener(selectAction);
		
		MouseListener selectDoubleClick = new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				if(me.getClickCount() == 2){
					selectEvent();
				}
			}
		};
		popup.getTblUsers().addMouseListener(selectDoubleClick);
	}
	
	public void showPopup() {
		popup.setVisible(true);
	}
	
	public SelectUserPopup getPopup() {
		return popup;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable) {
			//Translate everything...
		}
	}
	
	public static void main(String[] args) {
		SelectUserController controller = new SelectUserController(new SelectedUserListener() {
			public void userIsSelected(User user) {
				System.out.println("A user is selected ! \n" + user);
			}
		});
		
		controller.showPopup();
	}
}
