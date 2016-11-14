package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.Address;

public class AddressDAO implements BaseDAO<Address> {

	private static AddressDAO instance;
	
	private AddressDAO() {}
	
	public static AddressDAO getInstance() {
		if(instance == null)
			instance = new AddressDAO();
		
		return instance;
	}
	
	@Override
	public Address getByResultSet(ResultSet res) throws SQLException {
		int id = res.getInt("id");
		String streetline1 = res.getString("streetLine1");
		String streetline2 = res.getString("streetLine2");
		String city = res.getString("City");
		String postalCode = res.getString("postalCode");
		String country = res.getString("country");
		boolean archived = res.getBoolean("archived");
		return new Address(id, streetline1, streetline2, city, postalCode, country, archived);
	}

	@Override
	public void add(Address obj) {
		if(obj == null) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement st = null;
		
		try {
			String[] returnId = {"BATCHID"};
			st = connection.prepareStatement("INSERT INTO addresses(id, country, postalCode, city, streetLine1, streetLine2, archived)"
					+ "VALUES (null, ?,?,?,?,?,?)", returnId);
			st.setString(1, obj.getCountry());
			st.setString(2, obj.getPostalCode());
			st.setString(3, obj.getCity());
			st.setString(4, obj.getStreetline1());
			st.setString(5, obj.getStreetline2());
			st.setBoolean(6, obj.isArchived());
			st.executeUpdate();
			
			ResultSet genKeys = null;
			try{
				genKeys = st.getGeneratedKeys();
				if(genKeys.next()){
					obj.setId(genKeys.getInt(1));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(genKeys != null) genKeys.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Address> getAll() {
		List<Address> lst = new ArrayList<Address>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM addresses WHERE archived = 0;");
			
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
	public Address get(int id) {
		Address address = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM addresses WHERE id= " + id + ";");
			if(res.next()){
				address = getByResultSet(res);
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
		return address;
	}

	@Override
	public void update(Address obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE addresses SET country = ?, postalCode = ?, city = ?, streetLine1 = ?, streetLine2 = ?, archived = ? WHERE id = ?;");
			stat.setString(1, obj.getCountry());
			stat.setString(2, obj.getPostalCode());
			stat.setString(3, obj.getCity());
			stat.setString(4, obj.getStreetline1());
			stat.setString(5, obj.getStreetline2());
			stat.setBoolean(6,  obj.isArchived());
			stat.setInt(7, obj.getId());
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
	public void delete(Address obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE addresses SET archived = 1 WHERE id = ?");
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
