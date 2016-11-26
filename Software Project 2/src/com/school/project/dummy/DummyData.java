package com.school.project.dummy;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;
import com.school.project.model.TicketSale;
import com.school.project.model.User;
import com.school.project.nmbs.model.Station;
import com.school.project.nmbs.model.StationCache;

public class DummyData {
	private static DummyData instance;
	private DummyData() {}
	
	public static DummyData getInstance() {
		if(instance == null) instance = new DummyData();
		return instance;
	}
	
	public void insertDummyTicketSale(String secureCheck) {
		if(!secureCheck.equals("BE_SURE_WITH_WHAT_YOU_DO")) return;
		
		List<Station> sts = StationCache.getInstance().getStations();
		Random rand = new Random();
		int[] userIDs = {24,20,18,30,2,13,12,11,10,9,8,1};
		int[] ticketIDs = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,6,7,8,9,10,11,12,13,14,15,16,17,18,19,10,10,15,15,15,18,18,19,7,10,11,15};
		for(int i = 0; i < 100; i++) {
			long msBegin = 1451902093000L;
			long ms = msBegin + (Math.abs(rand.nextLong()) % (1L * 365 * 24 * 60 * 60 * 1000));
			Date validFrom = new Date(ms);
			Date validTo = new Date(validFrom.getTime());
			Date soldOn = validFrom;
			
			int userId = userIDs[rand.nextInt(userIDs.length)];
			int ticketId = ticketIDs[rand.nextInt(ticketIDs.length)];
			User user = new User(userId, null, null, "", "", null, false);
			Ticket ticket = TicketCache.getInstance().getTicket(ticketId);
			String from = "";
			String to = "";
			if(ticket == null) {
				continue;
			}
			if(ticket.isHasFixedRoute()) {
				from = sts.get(rand.nextInt(sts.size())).getName();
				to = sts.get(rand.nextInt(sts.size())).getName();
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(validTo);
			cal.add(Calendar.DATE, ticket.getValidityPeriod());
			validTo.setTime(cal.getTime().getTime());
			
			TicketSale ts = new TicketSale(-1, validFrom, validTo, soldOn, from, to, false, ticket, user);
			TicketSaleDAO.getInstance().add(ts);
		}
	}
}
