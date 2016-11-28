package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.dao.AddressDAO;
import com.school.project.dao.LostItemDAO;
import com.school.project.dao.RailCardDAO;
import com.school.project.dao.TicketDAO;
import com.school.project.dao.TicketSaleDAO;
import com.school.project.dao.UserDAO;
import com.school.project.gui.controller.BaseController;
import com.school.project.gui.view.settings.BackupView;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.Address;
import com.school.project.model.LostItem;
import com.school.project.model.RailCard;
import com.school.project.model.Ticket;
import com.school.project.model.TicketSale;
import com.school.project.model.User;

public class BackupController extends BaseController<BackupView>{

	public BackupController() {
		super(new BackupView());
		initEvents();
	}

	private void initEvents(){
		view.getBtnBackup().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveToCSV();
			}
			
		});
	}
	
	private void saveToCSV(){
		List<Ticket> tickets = TicketDAO.getInstance().getAll();
		List<ActiveRailCard> activeRailCards = ActiveRailCardDAO.getInstance().getAll();
		List<Address> addresses = AddressDAO.getInstance().getAll();
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		List<RailCard> railCards = RailCardDAO.getInstance().getAll();
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		List<User> users = UserDAO.getInstance().getAll();
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("test.csv"));
			//ActiveRailCards
			for(int i = 0; i < activeRailCards.size(); i++){
				ActiveRailCard arc = activeRailCards.get(i);
				bw.write(arc.getId() + "," + arc.getRailCard().getId() + "," + arc.getInNameOf().getId()
					+ "," + arc.getUser().getId() + "," + arc.getValidFrom() + "," + arc.getValidTo()
					+ "," + arc.getFrom() + "," + arc.getTo() + "," + arc.isArchived());
				bw.newLine();
			}
			bw.newLine();
			
			//Addresses
			for(int i = 0; i < addresses.size(); i++){
				Address a = addresses.get(i);
				bw.write(a.getId() + "," + a.getCountry() + "," + a.getPostalCode() + "," + a.getCity()
				 + "," + a.getStreetline1() + "," + a.getStreetline2() + "," + a.isArchived());
				bw.newLine();
			}
			bw.newLine();
			
			//Tickets
			for(int i = 0; i < tickets.size(); i++){
				Ticket t = tickets.get(i);
				bw.write(t.getId() + "," + t.getName() + "," + t.getDescription() + "," + t.getPrice()
					+ "," + t.getValidityPeriod() + "," + t.isHasFixedRoute() + "," + t.isArchived());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	@Override
	public void update(Observable o, Object arg) {
		
	}

}
