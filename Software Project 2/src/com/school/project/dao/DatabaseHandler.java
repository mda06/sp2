package com.school.project.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
	private java.sql.Connection connection;
	private final String DB_URL = "dt5.ehb.be";
	private final String DB_NAME;
	private final String DB_USERNAME;
	private final String DB_PASSWORD;
	
	private static DatabaseHandler instance;
	
	private DatabaseHandler() {
		String name = "", user = "", pass = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dbCredentials.txt")))) {

			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				switch(++i) {
				case 1 : name = line; break;
				case 2 : user = line; break;
				case 3 : pass = line; break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DB_NAME = name;
		DB_USERNAME = user;
		DB_PASSWORD = pass;
	}
	
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
