package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.LostItem;

public class LostItemDAO implements BaseDAO<LostItem>{
	
	private static LostItemDAO instance;
	private LostItemDAO(){}
	
	public static LostItemDAO getInstance(){
		if(instance == null){
			instance = new LostItemDAO();
		}
		return instance;
		
	}
	@Override
	public void add(LostItem obj) {
		if(obj == null) return;
	
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			String[] returnId = {"BATCHID"};
			stat = connection.prepareStatement("INSERT INTO lostItems (id,type,description,location,pickedUp, archived) VALUES (null,?,?,?,?,?);",returnId );
			stat.setString(1, obj.getType());
			stat.setString(2, obj.getDescription());
			stat.setString(3, obj.getLocation());
			stat.setBoolean(4, obj.isPickedUp());
			stat.setBoolean(5, obj.isArchived());
			stat.executeUpdate();
			
			ResultSet genKeys = null;
			try{
				genKeys = stat.getGeneratedKeys();
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
			try {
				if(stat != null) stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public LostItem getByResultSet(ResultSet res) throws SQLException {
		if(res == null){
			return null;
		}
		int id = res.getInt("id");
		String type = res.getString("type");
		String description = res.getString("description");
		String location = res.getString("location");
		boolean pickedUp = res.getBoolean("pickedUp");
		boolean archived = res.getBoolean("archived");
		return new LostItem(id, type, description, location, pickedUp, archived);
	}
	
	
	@Override
	public List<LostItem> getAll() {
		List<LostItem> lst = new ArrayList<LostItem>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM lostItems WHERE archived = 0 AND pickedUp = 0;");
			
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
	public LostItem get(int id) {
		LostItem item = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM lostItems WHERE id= " + id + ";");
			if(res.next()){
				item = getByResultSet(res);
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
		return item;
	}

	@Override
	public void update(LostItem obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE lostitems SET type = ?, description = ?, location = ?, pickedUp = ?, archived = ? WHERE id = ?;");
			stat.setString(1, obj.getType());
			stat.setString(2, obj.getDescription());
			stat.setString(3, obj.getLocation());
			stat.setBoolean(4, obj.isPickedUp());
			stat.setBoolean(5, obj.isArchived());
			stat.setInt(6, obj.getId());
			stat.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stat != null) stat.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(LostItem obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE lostItems SET archived = 1 WHERE id = ?");
			stat.setInt(1, obj.getId());
			stat.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(stat != null)stat.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
