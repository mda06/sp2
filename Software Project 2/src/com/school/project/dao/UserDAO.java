package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;
import com.school.project.model.UserCredential;

public class UserDAO implements BaseDAO<User>{

	private static UserDAO instance;
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		if(instance == null)
			instance = new UserDAO();
		
		return instance;
	}
	
	@Override
	public User getByResultSet(ResultSet res) throws SQLException {
		int id = res.getInt("id");
		Gender gender = Gender.valueOf(res.getString("gender").toUpperCase());
		UserType type = UserType.valueOf(res.getString("userType").toUpperCase());
		String firstName = res.getString("firstName");
		String lastName = res.getString("lastName");
		java.sql.Date dateOfBirth = res.getDate("dateOfBirth");
		boolean archived = res.getBoolean("archived");
		
		User u = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		u.setCredentials(UserCredentialsDAO.getInstance().getCredentialsOfUser(u));
		u.setAddress(AddressDAO.getInstance().get(res.getInt("addressId")));
		return u;
	}

	@Override
	public void add(User obj) {
		if(obj == null) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement st = null;
		
		try {
			String[] returnId = {"BATCHID"};
			st = connection.prepareStatement("INSERT INTO users(id, addressId, firstName, lastName, dateOfBirth, gender, userType, archived)"
					+ "VALUES (null, ?,?,?,?,?,?,?)", returnId);
			st.setInt(1, obj.getAddress().getId());
			st.setString(2, obj.getFirstName());
			st.setString(3, obj.getLastName());
			st.setDate(4, obj.getDateOfBirth());
			st.setString(5, obj.getGender().toString().toLowerCase());
			st.setString(6, obj.getType().toString().toLowerCase());
			st.setBoolean(7, obj.isArchived());
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
	public List<User> getAll() {
		List<User> lst = new ArrayList<User>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM users WHERE archived = 0;");
			
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

	public User get(String username, String password) {
		UserCredential cred = UserCredentialsDAO.getInstance().get(username, password);
		if(cred == null) return null;
		//User u = getUser(cred.g)
		return null;
	}
	
	@Override
	public User get(int id) {
		User user = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM users WHERE id= " + id + ";");
			if(res.next()){
				user = getByResultSet(res);
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
		return user;
	}

	@Override
	public void update(User obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{//															   
			stat = connection.prepareStatement("UPDATE users SET addressId = ?, firstName = ?, lastName = ?, dateOfBirth = ?, gender = ?, userType = ?, archived = ? WHERE id = ?;");
			stat.setInt(1, obj.getAddress().getId());
			stat.setString(2, obj.getFirstName());
			stat.setString(3, obj.getLastName());
			stat.setDate(4, obj.getDateOfBirth());
			stat.setString(5, obj.getGender().toString().toLowerCase());
			stat.setString(6, obj.getType().toString().toLowerCase());
			stat.setBoolean(7, obj.isArchived());
			stat.setInt(8, obj.getId());
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
	public void delete(User obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE users SET archived = 1 WHERE id = ");
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
