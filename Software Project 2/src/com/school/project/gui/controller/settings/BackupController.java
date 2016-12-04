package com.school.project.gui.controller.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		view.getBtnSave().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				invokeFilechooser(view.getComboTables().getSelectedItem().toString());
			}	
		});
		
		view.getBtnSaveAll().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invokeFilechooser("");
			}
		});
	}
	
	private void invokeFilechooser(String slctTable){
		JFileChooser fc = new JFileChooser();
		String prefix = view.getTxtPrefix().getText();
		//String slctTable = view.getComboTables().getSelectedItem().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String currentDate = sdf.format(new Date());
		
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		if(slctTable != ""){
			fc.setSelectedFile(new File(prefix + "-" + slctTable + "-" + currentDate));
		}
		else{
			fc.setSelectedFile(new File(prefix + "-" + "allTables" + "-" + currentDate));
		}
		fc.setFileFilter(new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv"));
		int returnVal = fc.showDialog(view, "Save");
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			new Thread(() -> saveToCSV(fc.getSelectedFile().getAbsolutePath(), slctTable)).start();
		}
	}
	
	private void saveToCSV(String filepath, String selectedTable) {		
		List<Ticket> tickets = TicketDAO.getInstance().getAll();
		List<ActiveRailCard> activeRailCards = ActiveRailCardDAO.getInstance().getAll();
		List<Address> addresses = AddressDAO.getInstance().getAll();
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		List<RailCard> railCards = RailCardDAO.getInstance().getAll();
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		List<User> users = UserDAO.getInstance().getAll();
				
		try{	
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath + ".csv"));
			
			if(selectedTable == "activeRailcards" || selectedTable == ""){
				//ActiveRailCards
				for(int i = 0; i < activeRailCards.size(); i++){
					ActiveRailCard arc = activeRailCards.get(i);
					bw.write(arc.getId() + "," + arc.getRailCard().getId() + "," + arc.getInNameOf().getId()
						+ "," + arc.getUser().getId() + "," + arc.getValidFrom() + "," + arc.getValidTo()
						+ "," + arc.getFrom() + "," + arc.getTo() + "," + arc.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			if(selectedTable == "addresses" || selectedTable == ""){
				//Addresses
				for(int i = 0; i < addresses.size(); i++){
					Address a = addresses.get(i);
					bw.write(a.getId() + "," + a.getCountry() + "," + a.getPostalCode() + "," + a.getCity()
					 + "," + a.getStreetline1() + "," + a.getStreetline2() + "," + a.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			
			if(selectedTable == "lostItems" || selectedTable == ""){
				//LostItems
				for(int i = 0; i < lostItems.size(); i++){
					LostItem li = lostItems.get(i);
					bw.write(li.getId() + "," + li.getType() + "," + li.getDescription() + "," + li.getLocation()
					 + "," + li.isPickedUp() + "," + li.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			
			if(selectedTable == "railcards" || selectedTable == ""){
				//RailCards
				for(int i = 0; i < railCards.size(); i++){
					RailCard rc = railCards.get(i);
					bw.write(rc.getId() + "," + rc.getName() + "," + rc.getDescription() + "," + rc.getPricePerMonth()
					 + "," + rc.getPricePer3Month() + "," + rc.getPricePerYear() + "," + rc.isHasFixedRoute() + "," + rc.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			
			if(selectedTable == "tickets" || selectedTable == ""){
				//Tickets
				for(int i = 0; i < tickets.size(); i++){
					Ticket t = tickets.get(i);
					bw.write(t.getId() + "," + t.getName() + "," + t.getDescription() + "," + t.getPrice()
						+ "," + t.getValidityPeriod() + "," + t.isHasFixedRoute() + "," + t.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			
			if(selectedTable == "ticketSales" || selectedTable == ""){
				//TicketSales
				for(int i = 0; i < ticketSales.size(); i++){
					TicketSale ts = ticketSales.get(i);
					bw.write(ts.getId() + "," + ts.getTicket().getId() + "," + ts.getUser().getId() + "," + ts.getValidFrom() 
						+ "," + ts.getValidTo() + "," + ts.getSoldOn() + "," + ts.getFrom() + "," + ts.getTo() + "," + ts.isArchived());
					bw.newLine();
				}
				bw.newLine();
			}
			
			if(selectedTable == "users" || selectedTable == ""){				
				//Users
				for(int i = 0; i < users.size(); i++){
					User u = users.get(i);
						bw.write(u.getId() + "," + u.getAddress().getId() + "," + u.getFirstName() + "," + u.getLastName() + "," + u.getDateOfBirth()
						 + "," + u.getGender() + "," + u.getType() + "," + u.isArchived());
						bw.newLine();
				}
			}
			bw.flush();
			bw.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(view, "File successfully saved");
	}
	
	@Override
	public void update(Observable o, Object arg) {	
	}
}
