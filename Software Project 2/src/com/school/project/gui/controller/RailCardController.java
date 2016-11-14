package com.school.project.gui.controller;

import java.awt.CardLayout;
import java.util.Observable;

import javax.swing.JButton;

import com.school.project.gui.view.RailCardView;
import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;
import com.school.project.model.User;

public class RailCardController extends BaseController<RailCardView> {

	private ActiveRailCardController activeRailCard;

	
	public RailCardController() {
		super(new RailCardView());
		initButtons();
	}

	private void initButtons() {
		for(RailCard rc : RailCardCache.getInstance().getCache()){
			JButton btn = new JButton(rc.getName());
			view.getPnlBtns().add(btn);
			btn.setActionCommand(String.valueOf(rc.getId()));
			/*btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					RailCard rc = RailCardCache.getInstance().getRailCard(Integer.parseInt(e.getActionCommand()));
					showCard(view.KEY_PAY);
				}
				
			});*/
		}
		
	}
	private void showCard(String key) {
		CardLayout card = (CardLayout)view.getLayout();
		card.show(view, key);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
