package com.school.project.gui.controller.settings;

import java.awt.event.ItemEvent;
import java.util.Observable;

import javax.smartcardio.CardTerminal;

import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.NFCSettingsView;
import com.school.project.language.LanguageHandler;
import com.school.project.language.LanguageObservable;
import com.school.project.nfc.Acr122Factory;
import com.school.project.nfc.CardMifare1K;
import com.school.project.nfc.KEY_LOCATION;
import com.school.project.nfc.KEY_TYPE;

public class NFCSettingsController extends BaseController<NFCSettingsView>{

	private String noCardFound = "No card found", noReaderFound = "No reader found", noDataFound = "No data found";
	
	public NFCSettingsController() {
		super(new NFCSettingsView());
		
		initLayoutPreferences();
		initEvents();
	}
	
	private void initLayoutPreferences() {
		view.getTxtCard().setText(noCardFound);
		view.getTxtCard().setEditable(false);
		view.getTxtReader().setText(noReaderFound);
		view.getTxtReader().setEditable(false);
		view.getCbLoc().addItem(KEY_LOCATION.ONE);
		view.getCbLoc().addItem(KEY_LOCATION.ZERO);
		view.getCbLoc().setSelectedItem(KEY_LOCATION.valueOfByte(Acr122Factory.getInstance().getKeyNumber()));
		view.getTxtReader().setEditable(false);
		view.getCbType().addItem(KEY_TYPE.A);
		view.getCbType().addItem(KEY_TYPE.B);
		view.getCbType().setSelectedItem(KEY_TYPE.valueOfByte(Acr122Factory.getInstance().getKeyType()));
		resetDump();
	}
	
	private void initEvents() {
		view.getCbLoc().addItemListener((i) -> {
			if(i.getStateChange() == ItemEvent.SELECTED) 
				Acr122Factory.getInstance().setKeyNumber((KEY_LOCATION)i.getItem());
		});
		view.getCbType().addItemListener((i) -> {
			if(i.getStateChange() == ItemEvent.SELECTED)
				Acr122Factory.getInstance().setKeyType((KEY_TYPE)i.getItem());
		});
		view.getBtnCard().addActionListener((e) -> {
			resetDump();
			checkCard();
		});
		view.getBtnReader().addActionListener((e) -> {
			resetDump();
			checkReader();
		});
		view.getBtnDump().addActionListener((e) -> {
			CardMifare1K card = Acr122Factory.getInstance().getMifare1K();
			checkReader();
			if(card != null) {
				view.getListDump().setListData(card.getDump().toString().split("\n"));
				view.getTxtCard().setText(card.toString());
			} else {
				resetDump();
				view.getTxtCard().setText(noCardFound);
			}
		});
	}
	
	private void checkCard() {
		CardMifare1K card = Acr122Factory.getInstance().getMifare1K();
		if(card != null)
			view.getTxtCard().setText(card.getUIDString());
		else
			view.getTxtCard().setText(noCardFound);
	}
	
	private void checkReader() {
		CardTerminal terminal = Acr122Factory.getInstance().getAcr122();
		if(terminal != null)
			view.getTxtReader().setText(terminal.toString());
		else
			view.getTxtReader().setText(noReaderFound);
	}
	
	private void resetDump() {
		view.getListDump().setListData(new String[]{noDataFound});
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageObservable){
			LanguageHandler lh = ((LanguageObservable)o).getLanguageHandler();
			view.getLblType().setText(lh.getString("keyType"));
			view.getLblLoc().setText(lh.getString("keyLoc"));
			view.getBtnReader().setText(lh.getString("checkReader"));
			view.getBtnCard().setText(lh.getString("checkCard"));
			view.getBtnDump().setText(lh.getString("createDump"));

			view.getTxtReader().setText(lh.getString("noReaderFound"));
			view.getTxtCard().setText(lh.getString("noCardFound"));
			view.getListDump().setListData(new String[]{lh.getString("noDataFound")});
		}
	}
}
