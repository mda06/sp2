package com.school.project.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.smartcardio.ResponseAPDU;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.dao.UserDAO;
import com.school.project.gui.controller.listener.SelectedUserListener;
import com.school.project.gui.model.ActiveRailCardTableModel;
import com.school.project.gui.view.ActiveRailCardView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.User;
import com.school.project.nfc.Acr122Factory;
import com.school.project.nfc.CardMifare1K;
import com.school.project.nfc.RailCardToNFCSettings;
import com.school.project.nfc.event.CardConnected;

public class ActiveUserRailCardController extends BaseController<ActiveRailCardView> implements SelectedUserListener, CardConnected {
	private ActiveRailCardTableModel tableModel;
	private SelectUserController selectUserController;
	private boolean isAlreadyInNFCListener;

	public ActiveUserRailCardController() {
		super(new ActiveRailCardView());
		tableModel = new ActiveRailCardTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setAutoCreateRowSorter(true);
		initEvents();
		isAlreadyInNFCListener = false;
		selectUserController = new SelectUserController(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof LanguageObservable) {
			LanguageHandler handler = ((LanguageObservable) o).getLanguageHandler();
			view.getBtnSelectUser().setText(handler.getString("selectUser"));
			view.getLblSelectUser().setText(handler.getString("selectedUser"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_RAILCARD).setHeaderValue(handler.getString("RailCard"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_FROM).setHeaderValue(handler.getString("from"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_TO).setHeaderValue(handler.getString("to"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_VALID_FROM).setHeaderValue(handler.getString("validFrom"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_VALID_TO).setHeaderValue(handler.getString("validTo"));
			view.getTable().getColumnModel().getColumn(tableModel.COLUMN_SOLD_BY_USER).setHeaderValue(handler.getString("soldByUser"));
			view.repaint();
			selectUserController.update(o, arg);
		}
	}

	public void initEvents() {
		view.getBtnSelectUser().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUserController.showPopup();
			}
		});
	}

	@Override
	public void userIsSelected(User user) {
		view.getLblUser().setText(user.getFirstName() + " " + user.getLastName());

		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		// Toevoegen van ActiveRailCards verkocht door geselecteerde user
		for (ActiveRailCard item : ActiveRailCardDAO.getInstance().getByName(user.getId())) {
			tableModel.addActiveRailCard(item);
		}
	}
	
	private void clearContent() {
		view.getLblUser().setText("");
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	@Override
	public void show() {
		if (!isAlreadyInNFCListener) {
			Acr122Factory.getInstance().addCardListener(this);
			isAlreadyInNFCListener = true;
		}
	}

	private static final int byteArrayToInt(byte[] bytes) {
		int tot = 0;
		for(int i = 0; i < bytes.length; i++)
			tot += bytes[i];
		return tot;
	}

	
	@Override
	public void cardConnected(CardMifare1K c) {
		if(c == null) return;
		try {
			c.authentificate(RailCardToNFCSettings.BLOCK_NUMBER_RAILCARD);
			ResponseAPDU res = c.readBinaryBlock(RailCardToNFCSettings.BLOCK_NUMBER_RAILCARD);
			if(res != null) {
				byte[] data = res.getData();
				if(data.length != 0) {
					byte[] bytes = {data[0], data[1], data[2], data[3]};
					int userId = byteArrayToInt(bytes);
					User user = UserDAO.getInstance().get(userId);
					if(user != null)
						userIsSelected(user);
					else
						clearContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
