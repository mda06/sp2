package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.project.model.User;

public class NFCDAO{
	private static NFCDAO instance;
	private NFCDAO(){}
	
	public static NFCDAO getInstance() {
		if(instance == null) instance = new NFCDAO();
		return instance;
	}
	
	public User get(String nfcUid) {
		User user = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		ResultSet res = null;
		
		try{													   
			stat = connection.prepareStatement("SELECT userId FROM nfcCredentials WHERE nfcUid = ?;");
			stat.setString(1, nfcUid);
			res = stat.executeQuery();
			if(res.next()){
				int userId = res.getInt("userId");
				user = UserDAO.getInstance().get(userId);
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
}
