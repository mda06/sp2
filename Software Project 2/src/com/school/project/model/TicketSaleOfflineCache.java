package com.school.project.model;

import java.util.ArrayList;
import java.util.List;

import com.school.project.dao.TicketSaleDAO;
import com.school.project.util.NetUtil;

public class TicketSaleOfflineCache {
	private static TicketSaleOfflineCache instance;
	private List<TicketSale> cache;
	
	private TicketSaleOfflineCache() {
		cache = new ArrayList<>();
	}
	
	public static TicketSaleOfflineCache getInstance() {
		if(instance == null) instance = new TicketSaleOfflineCache();
		return instance;
	}
	
	public void add(TicketSale ts) {
		if(ts != null)
			cache.add(ts);
	}
	
	public void saveCache() {
		if(!NetUtil.hasInternet()) return;
		cache.stream().forEach((c) -> TicketSaleDAO.getInstance().add(c));
		cache.clear();
	}
}
