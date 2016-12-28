package com.school.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;

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
		if(obj == null){ return; }
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			String[] returnId = {"BATCHID"};
			stat = connection.prepareStatement("INSERT INTO tickets (id, name, description, price, validityPeriod, hasFixedRoute, archived) VALUES (null,?,?,?,?,?,?);", returnId);
			stat.setString(1, obj.getName());
			stat.setString(2, obj.getDescription());
			stat.setDouble(3, obj.getPrice());
			stat.setInt(4, obj.getValidityPeriod());
			stat.setBoolean(5, obj.isHasFixedRoute());
			stat.setBoolean(6, obj.isArchived());
			stat.executeUpdate();
			
			ResultSet genKeys = null;
			try{
				genKeys = stat.getGeneratedKeys();
				if(genKeys.next()){
					obj.setId(genKeys.getInt(1));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				if(genKeys != null){genKeys.close();}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){ stat.close(); }
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Ticket> getAll() {
		List<Ticket> lst = new ArrayList<Ticket>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM tickets WHERE archived = 0;");
			
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
		Ticket ticket = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM tickets WHERE id = " + id + ";");
			if(res.next()){
				ticket = getByResultSet(res);
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
		return ticket;
	}

	@Override
	public void update(Ticket obj) {
		if(obj == null || obj.getId() == -1) return;
		
		Ticket other = get(obj.getId());
		if(other.getPrice() != obj.getPrice()) {
			delete(other);
			TicketCache.getInstance().remove(other.getId());
			add(obj);
			TicketCache.getInstance().addTicket(obj);
			return;
		}
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE tickets SET name = ?, description = ?, price = ?, validityPeriod = ?, hasFixedRoute = ?, archived = ? WHERE id = ?;");
			stat.setString(1, obj.getName());
			stat.setString(2, obj.getDescription());
			stat.setDouble(3, obj.getPrice());
			stat.setInt(4, obj.getValidityPeriod());
			stat.setBoolean(5, obj.isHasFixedRoute());
			stat.setBoolean(6, obj.isArchived());
			stat.setInt(7, obj.getId());
			stat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){ stat.close(); }
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Ticket obj) {
		if(obj == null || obj.getId() == -1){return;}
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE tickets SET archived = 1 WHERE id = ?");
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

	public void deleteDummies(){
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE tickets SET archived = 1 WHERE name LIKE '%test_%';");
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
