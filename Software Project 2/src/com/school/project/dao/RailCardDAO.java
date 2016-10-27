package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.RailCard;

public class RailCardDAO implements BaseDAO<RailCard>{
	
	private static RailCardDAO instance;
	private RailCardDAO(){}
	
	public static RailCardDAO getInstance(){
		if(instance == null){
			instance = new RailCardDAO();
		}
		return instance;
	}

	@Override
	public RailCard getByResultSet(ResultSet res) throws SQLException {
		if(res == null){
			return null;
		}
		int id = res.getInt("id");
		String name = res.getString("name");
		String description = res.getString("description");
		double pricePerMonth = res.getDouble("pricePerMonth");
		double pricePer3Month = res.getDouble("pricePer3Month");
		double pricePerYear = res.getDouble("pricePerYear"); 
		boolean hasFixedRoute = res.getBoolean("hasFixedRoute");
		boolean archived = res.getBoolean("archived");
		
		return new RailCard(id, name, description, pricePerMonth, pricePer3Month, pricePerYear, hasFixedRoute, archived);
	}

	@Override
	public void add(RailCard obj) {
		if(obj == null) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			String[] returnId = {"BATCHID"};
			stat = connection.prepareStatement("INSERT INTO railCards (id, name, description, pricePerMonth, pricePer3Month, pricePerYear, hasFixedRoute, archived;", returnId);
			stat.setString(1, obj.getName());
			stat.setString(2, obj.getDescription());
			stat.setDouble(3, obj.getPricePerMonth());
			stat.setDouble(4, obj.getPricePer3Month());
			stat.setDouble(5, obj.getPricePerYear());
			stat.setBoolean(6, obj.isHasFixedRoute());
			stat.setBoolean(7, obj.isArchived());
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
				if(genKeys != null) genKeys.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				if(stat != null) stat.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<RailCard> getAll() {
		List<RailCard> lst = new ArrayList<RailCard>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM railCards WHERE archived = 0;");
		
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
	public RailCard get(int id) {
		RailCard card = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM railCards WHERE id = " + id + ";");
			if(res.next()){
				card = getByResultSet(res);
			}
		}
		catch(SQLException e){ e.printStackTrace(); }
		finally{
			try{
				if(stat != null) stat.close();
				if(res != null) res.close();
			}
			catch(SQLException e){ e.printStackTrace(); }
		}
		return card;
	}

	@Override
	public void update(RailCard obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;		
		
		try{
			stat = connection.prepareStatement("UPDATE railCards SET name = ?, description = ?, pricePerMonth = ?, pricePer3Month = ?, pricePerYear = ?, hasFixedRoute = ?, archived = ? WHERE id = ?;");
			stat.setString(1, obj.getName());
			stat.setString(2, obj.getDescription());
			stat.setDouble(3, obj.getPricePerMonth());
			stat.setDouble(4, obj.getPricePer3Month());
			stat.setDouble(5, obj.getPricePerYear());
			stat.setBoolean(6, obj.isHasFixedRoute());
			stat.setBoolean(7, obj.isArchived());
			stat.executeUpdate();
		}
		catch(SQLException e){ e.printStackTrace(); }
		finally{
			try{
				if(stat != null){ stat.close(); }
			}catch(SQLException e){	e.printStackTrace(); }
		}
	}

	@Override
	public void delete(RailCard obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE railCards SET archived = 1 WHERE id = ");
			stat.setInt(1, obj.getId());
			stat.executeUpdate();
		}
		catch(SQLException e){ e.printStackTrace(); }
		finally{
			try{
				if(stat != null)stat.close();
			}
			catch(SQLException e){ e.printStackTrace(); }
		}
		
	}
}
