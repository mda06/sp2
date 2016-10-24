package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.User;
import com.school.project.model.UserCredential;

public class UserCredentialsDAO implements BaseDAO<UserCredential> {

	private static UserCredentialsDAO instance;
	
	private UserCredentialsDAO() {}
	
	public static UserCredentialsDAO getInstance() {
		if(instance == null)
			instance = new UserCredentialsDAO();
		
		return instance;
	}
	
	@Override
	public UserCredential getByResultSet(ResultSet res) throws SQLException {
		int id = res.getInt("id");
		String username = res.getString("username");
		String password = res.getString("passwordHash");
		boolean archived = res.getBoolean("archived");
		UserCredential uc = new UserCredential(id, username, password, archived);
		uc.setUserId(res.getInt("userId"));
		return uc;
	}
	
	public UserCredential getCredentialsOfUser(User u) {
		UserCredential credentials = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM userCredentials WHERE userId= " + u.getId() + ";");
			if(res.next()){
				credentials = getByResultSet(res);
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
		return credentials;
	}

	@Override
	public void add(UserCredential obj) {
		if(obj == null) return;
		
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement st = null;
		
		try {
			String[] returnId = {"BATCHID"};
			st = connection.prepareStatement("INSERT INTO userCredentials(id, username, passwordHash, archived, userId)"
					+ "VALUES (null, ?,?,?,?)", returnId);
			st.setString(1, obj.getUsername());
			st.setString(2, obj.getPassword());
			st.setBoolean(3, obj.isArchived());
			st.setInt(4, obj.getUserId());
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
	public List<UserCredential> getAll() {
		List<UserCredential> lst = new ArrayList<UserCredential>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM userCredentials WHERE archived = 0;");
			
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

	public UserCredential get(String username, String pass) {
		UserCredential cred = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.prepareStatement("SELECT * FROM userCredentials WHERE username = ? AND passwordHash = ?");
			stat.setString(1, username);
			stat.setString(2, pass);
			res = stat.executeQuery();
			if(res.next()){
				cred = getByResultSet(res);
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
		return cred;
	}
	
	@Override
	public UserCredential get(int id) {
		UserCredential credentials = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		
		try{
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM userCredentials WHERE id= " + id + ";");
			if(res.next()){
				credentials = getByResultSet(res);
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
		return credentials;
	}

	@Override
	public void update(UserCredential obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE userCredentials SET username = ?, passwordHash = ?, archived = ?, userId = ? WHERE id = ?;");
			stat.setString(1, obj.getUsername());
			stat.setString(2, obj.getPassword());
			stat.setBoolean(3,  obj.isArchived());
			stat.setInt(4, obj.getUserId());
			stat.setInt(5, obj.getId());
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
	public void delete(UserCredential obj) {
		if(obj == null || obj.getId() == -1) return;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE userCredentials SET archived = 1 WHERE id = ");
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
