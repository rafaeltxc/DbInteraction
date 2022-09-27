package com.webapp.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/library";
	final static String USER = "root";
	final static  String PASS = "root";
		
	private static ConnectionManager instance;
	
	private ConnectionManager() {}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
