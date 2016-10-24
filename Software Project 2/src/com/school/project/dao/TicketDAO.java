package com.school.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.Ticket;

public class TicketDAO implements BaseDAO<Ticket> {

	private static TicketDAO instance;
	private TicketDAO(){}
	
	public static TicketDAO getInstance(){
		if(instance == null){
			instance = new TicketDAO();
		}
		return instance;
	}
	
	@Override
	public Ticket getByResultSet(ResultSet res) throws SQLException {
		if(res == null){return null;}
		int id = res.getInt("id");
		String name = res.getString("name");
		String description = res.getString("description");
		double price = res.getDouble("price");
		int validityPeriod = res.getInt("validityPeriod");
		boolean hasFixedRoute = res.getBoolean("hasFixedRoute");
		boolean archived = res.getBoolean("archived");
		return new Ticket(id, name, description, price, validityPeriod, hasFixedRoute, archived);
	}

	@Override
	public void add(Ticket obj) {
		/*if(obj == null){ return; }
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			String[] returnId = {"BATCHID"};
			stat = connection.prepareStatement("INSERT INTO tickets (.....) VALUES (....);", returnId);
			
		}*/
	}

	@Override
	public List<Ticket> getAll() {
		List<Ticket> lst = new ArrayList<Ticket>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM tickets WHERE archived = 0 AND hasFixedRoute = 0;");
			
			while(res.next()){
				lst.add(getByResultSet(res));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null) stat.close();
				if(res != null) res.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return lst;
	}

	@Override
	public Ticket get(int id) {
		Ticket item = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM tickets WHERE id = " + id + ";");
			if(res.next()){
				item = getByResultSet(res);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null) stat.close();
				if(res != null) res.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return item;
	}

	@Override
	public void update(Ticket obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ticket obj) {
		if(obj == null || obj.getId() == -1){return;}
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE tickets SET archived = 1 WHERE id = ");
			stat.setInt(1, obj.getId());
			stat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){stat.close();}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	

}
