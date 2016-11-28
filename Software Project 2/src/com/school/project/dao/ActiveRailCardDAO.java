package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;

public class ActiveRailCardDAO implements BaseDAO<ActiveRailCard> {
	
	private static ActiveRailCardDAO instance;
	
	public ActiveRailCardDAO(){}
	
	public static ActiveRailCardDAO getInstance(){
		if(instance == null)
			instance = new ActiveRailCardDAO();
		return instance;
	}
	
	@Override
	public ActiveRailCard getByResultSet(ResultSet res) throws SQLException {
		int id = res.getInt("id");
		int railCardId = res.getInt("railcardId");
		int soldByUser = res.getInt("soldByUser");
		int inNameOf = res.getInt("inNameOf"); // ActiveRailCard lacks this attribute
		Date validFrom = res.getDate("validFrom");
		Date validTo = res.getDate("validTo");
		String from = res.getString("departureStation");
		String to = res.getString("arrivalStation");
		boolean archived = res.getBoolean("archived");
		
		User user = UserDAO.getInstance().get(soldByUser);
		User inNameOfUser = UserDAO.getInstance().get(inNameOf);
		RailCard railcard = RailCardDAO.getInstance().get(railCardId);
		
		
		return new ActiveRailCard(id, validFrom, validTo, from, to, user,inNameOfUser, railcard, archived);
		
	}

	@Override
	public void add(ActiveRailCard obj) {
		if(obj == null)return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stmt = null;
		
		try{
			String[] returnId = {"BATCHID"};
			stmt = connection.prepareStatement("INSERT INTO activeRailcards "
					+ "VALUES(null,?,?,?,?,?,?,?,?)",returnId);
			stmt.setInt(1,obj.getRailCard().getId());
			stmt.setInt(2, obj.getInNameOf().getId());
			stmt.setInt(3, obj.getUser().getId());
			stmt.setDate(4, obj.getValidFrom());
			stmt.setDate(5, obj.getValidTo());
			stmt.setString(6, obj.getFrom());
			stmt.setString(7, obj.getTo());
			stmt.setBoolean(8, obj.isArchived());
			stmt.executeUpdate();
			
			ResultSet genKeys = null;
			try{
				genKeys = stmt.getGeneratedKeys();
				if(genKeys.next()){
					obj.setId(genKeys.getInt(1));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(genKeys != null) genKeys.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null)stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<ActiveRailCard> getAll() {
		List<ActiveRailCard> lst = new ArrayList<ActiveRailCard>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM activeRailcards WHERE archived = 0;");
			
			while(res.next()){
				lst.add(getByResultSet(res));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
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
	public ActiveRailCard get(int id) {
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		ActiveRailCard arc = null;
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM activeRailcards WHERE id = " + id + ";");
			
			if(res.next()){
				arc = getByResultSet(res);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stat != null) stat.close();
				if(res != null) res.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return arc;
	}

	@Override
	public void update(ActiveRailCard obj) {
		if(obj == null || obj.getId() == -1) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE activeRailcards SET "
					+ "railcardId = ?, inNameOf = ?, soldByUser = ?, validFrom = ?, validTo = ?, departureStation = ?, arrivalStation = ?, archived = ? WHERE id = ?;");
			stmt.setInt(1,obj.getRailCard().getId());
			stmt.setInt(2, obj.getInNameOf().getId());
			stmt.setInt(3, obj.getUser().getId());
			stmt.setDate(4, obj.getValidFrom());
			stmt.setDate(5, obj.getValidTo());
			stmt.setString(6, obj.getFrom());
			stmt.setString(7, obj.getTo());
			stmt.setBoolean(8, obj.isArchived());
			stmt.setInt(9, obj.getId());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null)stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(ActiveRailCard obj) {
		if(obj == null || obj.getId() == -1) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE activeRailcards SET "
					+ "archived = 1 WHERE id = ?;");
			stmt.setInt(1, obj.getId());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null)stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	// op id zoeken van user in ActiveUserRailCardController
	public List<ActiveRailCard> getByName(int inNameOf){
		List<ActiveRailCard> lst = new ArrayList<ActiveRailCard>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.prepareStatement("SELECT * FROM activeRailcards WHERE archived = 0 AND inNameOf = ?;");
			stat.setInt(1, inNameOf);
			res = stat.executeQuery();
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
	public HashMap<ActiveRailCard, Integer> getBestActiveRailCardStatistic(){
		HashMap<ActiveRailCard, Integer> map = new HashMap<>();
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			String sql = "SELECT count(*) AS total, railcardId FROM activeRailcards GROUP BY railcardId";
			stat = connection.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()){
				ActiveRailCard a = ActiveRailCardDAO.getInstance().get(res.getInt("railcardId"));
				Integer nb = res.getInt("total");
				map.put(a, nb);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){stat.close();}
				if(res != null){ res.close();}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return map;
	}
	public HashMap<User, Integer> getActiveRailCardByUserStatistic(){
		HashMap<User, Integer> map = new HashMap<>();
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			String sql = "SELECT count(*) AS total, soldByUser FROM activeRailcards GROUP BY soldByUser";
			stat = connection.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()){
				User u = UserDAO.getInstance().get(res.getInt("soldByUser"));
				Integer nb = res.getInt("total");
				map.put(u, nb);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){stat.close();}
				if(stat != null){res.close();}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return map;
	}
	
}
