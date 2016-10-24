package com.school.project.dao;

import java.sql.*;

public class DatabaseHandler {
	private java.sql.Connection connection;
	private final String DB_URL = "dt5.ehb.be";
	private final String DB_NAME = "";
	private final String DB_USERNAME = "";
	private final String DB_PASSWORD = "";
	
	private static DatabaseHandler instance;
	
	private DatabaseHandler(){};
	
	public static DatabaseHandler getInstance(){
		if(instance == null)
			instance = new DatabaseHandler();
		return instance;	
	}
	
	public Connection getConnection(){
		try{
			if(connection == null || connection.isClosed()){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				} catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				connection = DriverManager.getConnection("jdbc:mysql://"+DB_URL+"/"+DB_NAME,DB_USERNAME, DB_PASSWORD);
			}	
		} catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(){
		try{
			if(connection != null && !connection.isClosed()){
				connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
